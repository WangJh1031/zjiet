package Bean;

import IncDao.factory.DaoFactory;
import IncDao.vo.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfa on 2016/1/6.
 */
public class UserBean  {
    List<Users> all = new ArrayList<Users>();
    public UserBean() throws Exception{
        all= DaoFactory.getIuserDaostance().findAll();
    }

    public List<Users> getAll() {
        return all;
    }
}
