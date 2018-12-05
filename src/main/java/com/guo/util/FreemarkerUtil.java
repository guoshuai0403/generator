package com.guo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtil {
	/**
	 * 根据模板及数据生成字符串
	 * @param templateName - 模板名称
	 * @param model - 数据Map
	 * @return
	 */
	public static String generateToString(String projectName, String templateName, Map<String, Object> model){
		try {
			// 模板文件路径
			String project = "template";

			Configuration config = new Configuration();

			// 文件夹路径
			config.setDirectoryForTemplateLoading(new File(Class.class.getClass().getResource("/").getPath() + project));
			Template template = config.getTemplate(templateName + ".ftl");

			StringWriter out = new StringWriter();
			template.process(model, out);
			out.flush();
			out.close();
			return out.getBuffer().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
