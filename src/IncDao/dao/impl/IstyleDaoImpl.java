package IncDao.dao.impl;

import IncDao.dao.IsytleDao;
import IncDao.vo.Istyle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfa on 2016/1/7.
 */
public class IstyleDaoImpl implements IsytleDao{
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public IstyleDaoImpl(Connection conn){
        this.conn=conn;
    }
    @Override
    public List<Istyle> findAll() throws Exception {
        List<Istyle> all = new ArrayList<Istyle>();
        String sql="select * from style";
        pstmt=conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()){
            Istyle istyle = new Istyle();
            istyle.setIclass(rs.getString(1));
            istyle.setIsrc(rs.getString(2));
            all.add(istyle);
        }
        pstmt.close();
        return all;
    }
}
