package IncDao.dao;


import IncDao.vo.Users;

import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public interface IUserDao {
    public Users findById(String user_id) throws Exception;
    public Users findByIdPwd(String user_id,String user_pwd) throws Exception;
    public List<Users> findAll() throws Exception;
    public boolean doInsert(Users users) throws Exception;
    public boolean doUpdate(Users users) throws Exception;
    public boolean doDelete(Users users) throws Exception;
}
