package IncDao.dao.proxy;

import IncDao.dao.IUser_messageDao;
import IncDao.dao.impl.IUser_messageDaoImpl;
import IncDao.dbc.DBConnection;
import IncDao.vo.User_message;

import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class User_messageDaoProxy implements IUser_messageDao {
    private DBConnection dbc=null;
    private IUser_messageDao dao=null;
    public User_messageDaoProxy() throws Exception{
        dbc=new DBConnection();
        dao=new IUser_messageDaoImpl(dbc.getConnection());
    }
    @Override
    public User_message findByUserId(String user_id) throws Exception {
        User_message user_message=null;
        user_message=dao.findByUserId(user_id);
        dbc.close();
        return user_message;
    }

    @Override
    public User_message findByTitle(String message_title) throws Exception {
        User_message user_message=null;
        user_message=dao.findByTitle(message_title);
        dbc.close();
        return user_message;
    }

    @Override
    public List<User_message> findAll() throws Exception {
        List<User_message> all=null;
        all=dao.findAll();
        dbc.close();
        return all;
    }

    @Override
    public boolean doInsert(User_message user_message) throws Exception {
        boolean flag=false;
        if(dao.findByUserId(user_message.getUser_id())==null)
            flag=dao.doInsert(user_message);
        dbc.close();
        return flag;
    }

    @Override
    public boolean doUpdate(User_message user_message) throws Exception {
        boolean flag=false;
        if(dao.findByUserId(user_message.getUser_id())!=null)
            flag=dao.doUpdate(user_message);
        dbc.close();
        return flag;
    }

    @Override
    public boolean doDelete(User_message user_message) throws Exception {
        boolean flag=false;
        if(dao.findByUserId(user_message.getUser_id())!=null)
            flag=dao.doDelete(user_message);
        dbc.close();
        return flag;
    }
}
