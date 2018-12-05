package com.guo.controller;

import com.guo.bean.generate.GeneFile;
import com.guo.service.IGenerateService;
import com.guo.util.IpAdrressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 根据数据库生成文件控制器
 */
@RestController
@RequestMapping(value = "/generate")
public class GenerateController {

    @Autowired
    private IGenerateService generateService;

    /**
     * 按表生成
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/tables")
    public String tables(GeneFile geneFile, HttpServletRequest request) throws Exception {
        geneFile.setIp(IpAdrressUtil.getIpAdrress(request));
        return generateService.tables(geneFile);
    }

    /**
     * 单张表多个字段生成
     *
     * @return
     */
    public String columns() {

        return null;
    }
}
