package IncDao.dao;


import IncDao.vo.User_message;

import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public interface IUser_messageDao {
    public User_message findByUserId(String user_id) throws Exception;
    public User_message findByTitle(String message_title) throws  Exception;
    public List<User_message> findAll() throws Exception;
    public boolean doInsert(User_message user_message) throws Exception;
    public boolean doUpdate(User_message user_message) throws Exception;
    public boolean doDelete(User_message user_message) throws Exception;
}
