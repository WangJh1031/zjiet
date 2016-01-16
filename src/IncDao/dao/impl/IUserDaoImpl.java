package IncDao.dao.impl;

import IncDao.dao.IUserDao;
import IncDao.vo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class IUserDaoImpl implements IUserDao {
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public IUserDaoImpl(Connection conn){
        this.conn=conn;
    }
    @Override
    public List<Users> findAll() throws Exception{
        List<Users> all = new ArrayList<Users>();
        String sql="select * from users";
        pstmt=conn.prepareStatement(sql);
        ResultSet rs =pstmt.executeQuery();
        while (rs.next()){
            Users user=new Users();
            user.setUser_id(rs.getString(1));
            user.setUser_name(rs.getString(2));
            user.setLevel(rs.getInt(4));
            all.add(user);
        }
        pstmt.close();
        return all;

    }
    public Users findById(String user_id) throws Exception {
        Users users =null;
        String sql="select * from users where user_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,user_id);
        ResultSet rs =pstmt.executeQuery();
        if(rs.next()){
            users=new Users();
            users.setUser_id(rs.getString(1));
            users.setUser_name(rs.getString(2));
            users.setUser_pwd(rs.getString(3));
            users.setLevel(rs.getInt(4));
        }
        pstmt.close();

        return users;
    }

    @Override
    public Users findByIdPwd(String user_id, String user_pwd) throws Exception {
        Users users =null;
        String sql="select * from users where user_id=? and user_pwd=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,user_id);
        pstmt.setString(2,user_pwd);
        ResultSet rs =pstmt.executeQuery();
        if(rs.next()){
            users=new Users();
            users.setUser_id(rs.getString(1));
            users.setUser_name(rs.getString(2));
            users.setLevel(rs.getInt(4));

        }
        pstmt.close();

        return users;
    }

    @Override
    public boolean doInsert(Users users) throws Exception {
        boolean flag=false;
        String sql="insert into users values(?,?,?,?)";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,users.getUser_id());
        pstmt.setString(2,users.getUser_name());
        pstmt.setString(3,users.getUser_pwd());
        pstmt.setInt(4,users.getLevel());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }

    @Override
    public boolean doUpdate(Users users) throws Exception {
        boolean flag=false;
        String sql="UPDATE users set user_name=?,user_level=? WHERE user_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(3,users.getUser_id());
        pstmt.setString(1,users.getUser_name());
        pstmt.setInt(2,users.getLevel());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }

    @Override
    public boolean doDelete(Users users) throws Exception {
        boolean flag=false;
        String sql="DELETE FROM users WHERE user_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,users.getUser_id());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }
}
