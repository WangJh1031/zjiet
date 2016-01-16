package IncDao.dao.impl;

import IncDao.dao.IIncDao;
import IncDao.vo.Inc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class IncDaoImpl implements IIncDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public IncDaoImpl(Connection conn) {
        this.conn = conn;
    }


    public boolean doDelete(Inc inc) throws Exception {
        boolean flag=false;
        String sql="delete from inc where inc_title=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,inc.getInc_title());
        if(pstmt.executeUpdate()>0)
            flag=true;
        pstmt.close();
        return flag;
    }


    public boolean doInsert(Inc inc) throws Exception {
        boolean flag=false;
        String sql="INSERT INTO inc VALUES (?,?)";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,inc.getInc_title());
        pstmt.setString(2,inc.getInc_info());
        if(pstmt.executeUpdate()>0)
            flag=true;
        pstmt.close();
        return flag;

    }


    public Inc findAll() throws Exception {
        Inc inc = null;
        String sql="select * from inc";
        pstmt=conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            inc = new Inc();
            inc.setInc_title(rs.getString(1));
            inc.setInc_info(rs.getString(2));

        }
        pstmt.close();
        return inc;

    }


    public boolean doUpdate(Inc inc) throws Exception {
        boolean flag=false;
        String sql="UPDATE inc SET inc_info=?,inc_title=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,inc.getInc_info());
        pstmt.setString(2,inc.getInc_title());
        if(pstmt.executeUpdate()>0)
            flag=true;
        pstmt.close();
        return flag;
    }
}
