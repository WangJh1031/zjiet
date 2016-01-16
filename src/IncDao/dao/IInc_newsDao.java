package IncDao.dao;

import IncDao.vo.Inc_news;

import java.util.List;

/**
 * Created by winfath on 16/1/1.
 */
public interface IInc_newsDao {
    public boolean doUpdate (Inc_news inc_news) throws Exception;
    public Inc_news findById(int news_id) throws  Exception;
    public boolean doInsert (Inc_news inc_news) throws Exception;
    public boolean doDelete (Inc_news inc_news) throws Exception;
    public List<Inc_news> findAll() throws Exception;
}
