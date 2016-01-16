package IncDao.dao.impl;

import IncDao.dao.IUser_messageDao;
import IncDao.vo.User_message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class IUser_messageDaoImpl implements IUser_messageDao{
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public IUser_messageDaoImpl(Connection conn){
        this.conn=conn;
    }
    @Override
    public User_message findByUserId(String user_id) throws Exception {
        User_message user_message=null;
        String sql="SELECT * FROM user_message WHERE user_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,user_id);
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            user_message = new User_message();
            user_message.setUser_id(rs.getString(1));
            user_message.setUser_name(rs.getString(2));
            user_message.setMessage_title(rs.getString(3));
            user_message.setMessage_value(rs.getString(4));
            user_message.setMessage_date(rs.getDate(5));

        }
        pstmt.close();

        return user_message;
    }

    @Override
    public User_message findByTitle(String message_title) throws Exception {
        User_message user_message=null;
        String sql="select * from user_message where message_title=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,message_title);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            user_message = new User_message();
            user_message.setUser_id(rs.getString(1));
            user_message.setUser_name(rs.getString(2));
            user_message.setMessage_title(rs.getString(3));
            user_message.setMessage_value(rs.getString(4));
            user_message.setMessage_date(rs.getDate(5));

        }
        pstmt.close();
        return user_message;
    }

    @Override
    public List<User_message> findAll() throws Exception {
        List<User_message> all = new ArrayList<User_message>();
        String sql="SELECT * FROM user_message";
        pstmt=conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        User_message user_message=null;
        while (rs.next()){
            user_message = new User_message();
            user_message.setUser_id(rs.getString(1));
            user_message.setUser_name(rs.getString(2));
            user_message.setMessage_title(rs.getString(3));
            user_message.setMessage_value(rs.getString(4));
            user_message.setMessage_date(rs.getDate(5));
            all.add(user_message);
        }
        pstmt.close();
        return all;

    }

    @Override
    public boolean doInsert(User_message user_message) throws Exception {
        boolean flag=false;
        String sql="insert into user_message values (?,?,?,?,null)";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,user_message.getUser_id());
        pstmt.setString(2,user_message.getUser_name());
        pstmt.setString(3,user_message.getMessage_title());
        pstmt.setString(4,user_message.getMessage_value());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }

    @Override
    public boolean doUpdate(User_message user_message) throws Exception {

        return false;
    }

    @Override
    public boolean doDelete(User_message user_message) throws Exception {
        boolean flag = false;
        String sql="delete from user_message where message_title=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,user_message.getMessage_title());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }
}
