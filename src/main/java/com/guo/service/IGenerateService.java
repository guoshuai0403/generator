package com.guo.service;


import com.guo.bean.generate.GeneFile;

/**
 * 描述：生成文件
 * 创建人： guoshuai
 * 创建时间： 2018-03-31 16:52
 */
public interface IGenerateService {

    /**
     * 表中的所有字段都生成
     * @param geneFile
     * @return
     * @throws Exception
     */
    String tables(GeneFile geneFile) throws Exception;


}
