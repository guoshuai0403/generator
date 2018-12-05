package com.guo.dao.impl;

import com.guo.bean.ColumnBean;
import com.guo.bean.DataBaseBean;
import com.guo.bean.TableBean;
import com.guo.dao.IClientDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

@Repository
public class ClientDao implements IClientDao {

    /**
     * 查询数据库中所有表格
     * @param tableBean
     * @return
     * @throws Exception
     */
    @Override
    public List<TableBean> getTables(TableBean tableBean) throws Exception {

        SqlSession sqlSession = this.getSqlSession(tableBean.getDataBase());

        return sqlSession.selectList("dbMapper." + tableBean.getDataBase().getType().getComment()+ "_tables", tableBean);
    }

    @Override
    public List<ColumnBean> getColumns(TableBean tableBean) throws Exception {

        SqlSession sqlSession = this.getSqlSession(tableBean.getDataBase());

        return sqlSession.selectList("dbMapper." + tableBean.getDataBase().getType().getComment() + "_columns", tableBean);
    }

    /**
     * 创建sqlsession
     * @param dataBase
     * @return
     * @throws IOException
     */
    private SqlSession getSqlSession(DataBaseBean dataBase) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("jdbc.driver", dataBase.getDriver());
        properties.setProperty("jdbc.url", dataBase.getUrl());
        properties.setProperty("jdbc.username", dataBase.getUsername());
        properties.setProperty("jdbc.password", dataBase.getPassword());

        String resource = "mybatis/mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader, properties);

        SqlSession sqlSession = null;

        try {
            sqlSession = build.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
