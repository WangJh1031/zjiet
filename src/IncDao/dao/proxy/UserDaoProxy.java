package IncDao.dao.proxy;

import IncDao.dao.IUserDao;
import IncDao.dao.impl.IUserDaoImpl;
import IncDao.dbc.DBConnection;
import IncDao.vo.Users;

import java.util.List;

/**
 * Created by winfath on 16/1/4.
 */
public class UserDaoProxy implements IUserDao {
    private DBConnection dbc=null;
    private IUserDao dao=null;
    public List<Users> findAll() throws Exception {
        List<Users> all=null;
        all=dao.findAll();
        dbc.close();
        return all;

    }
    public UserDaoProxy() throws Exception{
        dbc=new DBConnection();
        dao=new IUserDaoImpl(dbc.getConnection());
    }
    @Override
    public Users findById(String user_id) throws Exception {
        Users users=null;
        users=dao.findById(user_id);
        dbc.close();
        return users;
    }

    @Override
    public Users findByIdPwd(String user_id, String user_pwd) throws Exception {
        Users users=null;
        users=dao.findByIdPwd(user_id,user_pwd);
        dbc.close();
        return users;
    }

    @Override
    public boolean doInsert(Users users) throws Exception {
        boolean flag=false;
        if(dao.findById(users.getUser_id())==null)
            flag=dao.doInsert(users);
        dbc.close();
        return flag;
    }

    @Override
    public boolean doUpdate(Users users) throws Exception {
        boolean flag = false;
        if(dao.findById(users.getUser_id())!=null)
            flag=dao.doUpdate(users);
        dbc.close();
        return flag;
    }

    @Override
    public boolean doDelete(Users users) throws Exception {
        boolean flag=false;
        if(dao.findById(users.getUser_id())!=null)
            flag=dao.doDelete(users);
        dbc.close();
        return flag;
    }
}
