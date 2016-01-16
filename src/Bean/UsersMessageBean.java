package Bean;

import IncDao.factory.DaoFactory;
import IncDao.vo.User_message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfa on 2016/1/5.
 */
public class UsersMessageBean {
    List<User_message> all = new ArrayList<User_message>();

    public UsersMessageBean() throws Exception{
        all=DaoFactory.getIUser_messageDAOstance().findAll();


    }

    public List<User_message> getAll() {
        return all;
    }
}
