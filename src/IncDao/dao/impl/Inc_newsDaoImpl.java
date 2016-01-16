package IncDao.dao.impl;

import IncDao.dao.IInc_newsDao;
import IncDao.vo.Inc_news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class Inc_newsDaoImpl implements IInc_newsDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public Inc_newsDaoImpl(Connection conn){
        this.conn=conn;
    }
    @Override
    public boolean doUpdate(Inc_news inc_news) throws Exception {
        boolean flag=false;
        String sql="UPDATE inc_news SET news_title=?,news_value=? WHERE news_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,inc_news.getNews_title());
        pstmt.setString(2,inc_news.getNews_value());
        pstmt.setInt(3,inc_news.getNews_id());
        if(pstmt.executeUpdate()>0)
            flag=true;
        pstmt.close();
        return flag;
    }

    @Override
    public Inc_news findById(int news_id) throws Exception {
        Inc_news inc_news=null;
        String sql="SELECT * FROM inc_news WHERE news_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1,news_id);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            inc_news = new Inc_news();
            inc_news.setNews_id(rs.getInt(1));
            inc_news.setNews_title(rs.getString(2));
            inc_news.setNews_value(rs.getString(3));
        }
        pstmt.close();
        return inc_news;
    }

    @Override
    public boolean doInsert(Inc_news inc_news) throws Exception {
        boolean flag=false;
        String sql="INSERT INTO inc_news VALUES (null,?,?,null)";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,inc_news.getNews_title());
        pstmt.setString(2,inc_news.getNews_value());
        if(pstmt.executeUpdate()>0)
            flag=true;
        pstmt.close();
        return flag;
    }

    @Override
    public boolean doDelete(Inc_news inc_news) throws Exception {
        boolean flag=false;
        String sql="DELETE FROM inc_news WHERE news_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1,inc_news.getNews_id());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }

    @Override
    public List<Inc_news> findAll() throws Exception {
        List<Inc_news> all = new ArrayList<Inc_news>();
        String sql="SELECT * FROM inc_news";
        pstmt=conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            Inc_news inc_news = new Inc_news();
            inc_news.setNews_id(rs.getInt(1));
            inc_news.setNews_title(rs.getString(2));
            inc_news.setNews_value(rs.getString(3));
            inc_news.setNews_date(rs.getDate(4));
            all.add(inc_news);


        }
        pstmt.close();
        return all;
    }
}
