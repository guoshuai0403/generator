package com.guo.controller;

import com.guo.bean.ColumnBean;
import com.guo.bean.DataBaseBean;
import com.guo.bean.TableBean;
import com.guo.cache.Client;
import com.guo.dao.IClientDao;
import com.guo.util.IpAdrressUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @类描述: 首页欢迎页
 * @功能描述: 
 * @创建者: guoshuai
 * @创建时间: 2018年3月27日下午8:46:57
 */
@RestController
public class IndexController {

	@Autowired
	private IClientDao clientDao;

	/**
	 * 获取数据库所有表
	 * @return
	 */
	@RequestMapping(value = "/tables")
	public List<TableBean> tables(HttpServletRequest request, DataBaseBean dataBase) throws Exception {

		String ipAdrress = IpAdrressUtil.getIpAdrress(request);

		Client.setCache(ipAdrress, dataBase);

		TableBean tableBean = new TableBean();

		tableBean.setDataBase(dataBase);

		return clientDao.getTables(tableBean);
	}

	/**
	 * 查询某个表的所有列
	 * @return
	 */
	@RequestMapping(value = "/columns")
	public List<ColumnBean> columns(TableBean tableBean, HttpServletRequest request){

		DataBaseBean cache = Client.getCache(IpAdrressUtil.getIpAdrress(request));

		tableBean.setDataBase(cache);

		try {
			return clientDao.getColumns(tableBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
