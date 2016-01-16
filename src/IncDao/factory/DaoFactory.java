package IncDao.factory;

import IncDao.dao.*;
import IncDao.dao.proxy.*;

/**
 * Created by winfath on 16/1/4.
 */
public class DaoFactory {
    public static IInc_newsDao getIInc_newsDaostance() throws Exception{
        return new Inc_newsDaoProxy();
    }
    public static IIncDao getIIncDaostance() throws Exception{
        return new IncDaoProxy();
    }
    public static IItemsDao getIItemsDaostance() throws Exception{
        return new ItemsDaoProxy();
    }
    public static IUser_messageDao getIUser_messageDAOstance() throws Exception{
        return new User_messageDaoProxy();
    }
    public static IUserDao getIuserDaostance() throws Exception{
        return new UserDaoProxy();
    }
    public static IsytleDao getIstyleDaostance() throws Exception{
        return new IstyleDaoProxy();
    }
}
