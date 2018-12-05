package com.guo.dao;


import com.guo.bean.ColumnBean;
import com.guo.bean.TableBean;

import java.util.List;

public interface IClientDao {

    /**
     * 获取数据库中的所有表包括视图
     * @param tableBean
     * @return
     * @throws Exception
     */
    List<TableBean> getTables(TableBean tableBean) throws Exception;

    /**
     * 查询表中的所有的列
     * @param table
     * @return
     * @throws Exception
     */
    List<ColumnBean> getColumns(TableBean table) throws Exception;
}
