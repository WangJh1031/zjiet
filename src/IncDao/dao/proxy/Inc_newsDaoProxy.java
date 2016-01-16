package IncDao.dao.proxy;


import IncDao.dao.IInc_newsDao;
import IncDao.dao.impl.Inc_newsDaoImpl;
import IncDao.dbc.DBConnection;
import IncDao.vo.Inc_news;

import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class Inc_newsDaoProxy implements IInc_newsDao {
    private DBConnection dbc=null;
    private IInc_newsDao dao=null;
    public Inc_newsDaoProxy() throws Exception {
        dbc=new DBConnection();
        dao=new Inc_newsDaoImpl(dbc.getConnection());
    }
    @Override
    public boolean doUpdate(Inc_news inc_news) throws Exception {
        boolean flag=false;
        if(dao.findById(inc_news.getNews_id())!=null){
            flag=dao.doUpdate(inc_news);
        }
        dbc.close();

        return flag;
    }

    @Override
    public Inc_news findById(int news_id) throws Exception {
        Inc_news inc_news=null;
        inc_news=dao.findById(news_id);
        dbc.close();
        return inc_news;
    }

    @Override
    public boolean doInsert(Inc_news inc_news) throws Exception {

        dao.doInsert(inc_news);
        dbc.close();
        return true;
    }

    @Override
    public boolean doDelete(Inc_news inc_news) throws Exception {
        boolean flag=false;
        if(dao.findById(inc_news.getNews_id())!=null)
            flag=dao.doDelete(inc_news);
        dbc.close();
        return flag;
    }

    @Override
    public List<Inc_news> findAll() throws Exception {
        List<Inc_news> all=null;
        all=dao.findAll();
        dbc.close();
        return all;
    }
}
