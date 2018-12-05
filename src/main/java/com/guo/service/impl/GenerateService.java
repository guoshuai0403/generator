package com.guo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.guo.bean.ColumnBean;
import com.guo.bean.TableBean;
import com.guo.bean.generate.Bean;
import com.guo.bean.generate.GeneFile;
import com.guo.bean.generate.JavaAttr;
import com.guo.cache.Client;
import com.guo.constant.FileTypeEnum;
import com.guo.dao.IClientDao;
import com.guo.service.IGenerateService;
import com.guo.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * 创建人： guoshuai
 * 创建时间： 2018-03-31 16:54
 */
@Service
public class GenerateService implements IGenerateService {

    @Autowired
    private IClientDao clientDao;

    /**
     * 表中的所有字段都生成
     *
     * @param codes
     * @param tables
     * @return
     * @throws Exception
     */
    @Override
    public String tables(GeneFile geneFile) throws Exception {

        // 返回结果
        StringBuffer tabResult = new StringBuffer();

        // 获取要生成的文件
        List<Integer> fileTypes = geneFile.getFileTypes();

        // 获取系统预定义的文件类型
        List<Integer> predefinedFileTypes = FileTypeEnum.getAllCode();

        // 获取要生成的预定义的文件类型
        predefinedFileTypes.retainAll(fileTypes);

        // 获取要生成的数据库表名集合
        List<String> tableNames = geneFile.getTableName();

        // 遍历要生成文件的数据库表格
        for (String tabName : tableNames) {
            TableBean tableBean = new TableBean();
            tableBean.setName(tabName);
            tableBean.setDataBase(Client.getCache(geneFile.getIp()));

            // 获取单个表格
            List<TableBean> tablesList = clientDao.getTables(tableBean);
            if (!CollectionUtils.isEmpty(tablesList) && tablesList.size() > 0) {
                tableBean.setComment(tablesList.get(0).getComment());
                tableBean.setName(tablesList.get(0).getName());
                tableBean.setType(tablesList.get(0).getType());
            }

            // 获取表格中的列
            List<ColumnBean> columns = clientDao.getColumns(tableBean);
            tableBean.setColumns(columns);

            // 把数据库对应的字段转换成类
            Bean bean = this.getBean(tableBean);

            Logger logger = LoggerFactory.getLogger(GenerateService.class);

            logger.info(JSONObject.toJSONString(bean));

            // 生成系统预定于的文件类型
            this.genePredefinedFile(bean, predefinedFileTypes, geneFile.getCommonPath());
        }
        return tabResult.toString();
    }

    /**
     * 生成指定的预定义文件
     * @param bean
     * @param predefinedFileTypes
     */
    private void genePredefinedFile(Bean bean, List<Integer> predefinedFileTypes, String filePath) throws Exception {
        for (Integer fileTypeCode : predefinedFileTypes) {
            FileTypeEnum fileType = EnumUtil.getByCode(FileTypeEnum.class, fileTypeCode);
            // 获取生成文件的路径
            StringBuffer path = new StringBuffer(filePath);
            path.append(File.separator + fileType.getPath());

            // 需要生成的文件的名称
            StringBuffer fileName = new StringBuffer();
            fileName.append(fileType.getPrefix());
            fileName.append(bean.getClassName());
            fileName.append(fileType.getSuffix());
            fileName.append(".");
            fileName.append(fileType.getType());

            // 需要生成的文件内容
            String content = FreemarkerUtil.generateToString(bean.getTableBean().getDataBase().getName(),
                    fileType.getTemplateName(), MapUtil.objectToMap(bean));

            // 生成文件
            FileUtil.createFile(path.toString(), fileName.toString(), content);
        }
    }

    /**
     * 生成bean
     *
     * @param columns
     * @param tableBean
     * @return
     */
    private Bean getBean(TableBean tableBean) {
        // table 转换为bean
        Bean bean = new Bean();
        bean.setClassName(StringUtil.firstToUpper(StringUtil.hump(tableBean.getName())));
        bean.setDescription(StringUtils.isEmpty(tableBean.getComment())?"" : tableBean.getComment());
        bean.setCreateTime(DateFormatUtils.getFormatTime("yyyy-MM-dd"));
        bean.setAuth(StringUtils.isEmpty(tableBean.getAuth())?"system":tableBean.getAuth());

        // field 转换成 javaAttr
        List<JavaAttr> javaAttrs = new ArrayList<>();

        for (ColumnBean columnBean : tableBean.getColumns()) {

            JavaAttr javaAttr = new JavaAttr();
            javaAttr.setName(StringUtil.hump(columnBean.getName()));
            javaAttr.setComment(columnBean.getComment());
            javaAttr.setType(FieldTypeUtil.jdbcToJava(tableBean.getDataBase().getType().getComment() + "." + columnBean.getColumnType().toUpperCase()));

            // mysql数据库中不支持boolean
            if ("tinyint".equalsIgnoreCase(columnBean.getType())) {

                if (columnBean.getLength() != null && columnBean.getLength() == 1) {

                    javaAttr.setType("Boolean");
                }
            }

            // int 类型转换成INTEGER
            if("int".equalsIgnoreCase(columnBean.getColumnType())){

                columnBean.setColumnType("INTEGER");
            }
            javaAttr.setColumnBean(columnBean);
            javaAttrs.add(javaAttr);
        }

        // 实体类对应的数据库表格
        bean.setTableBean(tableBean);

        // java字段列表
        bean.setAttrs(javaAttrs);
        return bean;
    }
}
