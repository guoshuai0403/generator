package com.guo.constant;

import com.guo.IBaseEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成文件类型的常量枚举类
 */
public enum FileTypeEnum implements IBaseEnum {

    /* S_实体类相关 */
    POJO(11, "数据库实体类", "", "Pojo", "bean.pojo", "java"),
    DO(12, "dao与service通讯类", "", "Do", "bean.do", "java"),
    DTO(13, "service与action通讯类", "", "Dto", "bean.dto", "java"),
    VO(14, "action与view通讯类， 视图类", "", "Vo", "bean.vo", "java"),
    /* E_实体类相关 */

    /* S_mapper配置文件相关 */
    FIELD(21, "mapper字段文件", "", "fieldMapper", "mapper.filed", "xml"),
    SENTENCE(22, "mapper语句", "", "sentenceMapper", "mapper.sentence", "xml"),
    /* E_mapper配置文件相关 */

    /* S_DAO层相关 */
    DAO(31, "dao实现类", "", "Dao", "dao.impl", "java"),
    IDAO(32, "dao接口", "I", "Dao", "dao", "java"),
    /* E_DAO层相关 */

    /* S_BO层相关 */
    BO(41, "bo实现类", "", "Manager", "manager.impl", "java"),
    IBO(42, "bo接口", "I", "Manager", "manager", "java"),
    /* E_BO层相关 */

    /* S_SERVICE层相关 */
    SERVICE(51, "service实现类", "", "Service", "service.impl", "java"),
    ISERVICE(52, "service接口", "I", "Service", "service", "java"),
    /* E_SERVICE层相关 */

    /* S_CONTROLLER层相关 */
    CONTROLLER(61, "控制器", "", "Controller", "controller", "java"),
    /* E_CONTROLLER层相关 */

    /* S_SHOWDOC生成文档用 */
    TABLE_SHOWDOC(101, "showdoc数据库表格", "", "table", "table-showdoc", "");
    /* E_SHOWDOC生成文档用 */


    // 编码
    private int code;

    // 说明
    private String comment;

    // 文件名称前缀
    private String prefix;

    // 文件名称后缀
    private String suffix;

    // 文件路径
    private String path;

    // 文件类型
    private String type;

    // 模板名称
    private String templateName;

    FileTypeEnum(int code, String comment, String prefix, String suffix, String path, String type) {
        this.code = code;
        this.comment = comment;
        this.prefix = prefix;
        this.suffix = suffix;
        this.path = path;
        this.comment = comment;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public String getComment() {
        return comment;
    }

    /**
     * 模板名称为文件路径把“.”改为下划线
     * @return
     */
    public String getTemplateName() {
        return this.path.replace(".", "_");
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getPath() {
        return this.path.replace(".", "/");
    }

    public String getType() {
        return type;
    }

    public static List<Integer> getAllCode(){
        FileTypeEnum[] enumConstants = FileTypeEnum.class.getEnumConstants();
        List<Integer> list = new ArrayList<Integer>();
        for (FileTypeEnum fileTypeEnum : enumConstants) {
            list.add(fileTypeEnum.getCode());
        }
        return list;
    }
}
