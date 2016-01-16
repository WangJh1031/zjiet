package IncDao;

import IncDao.dao.IUserDao;
import IncDao.factory.DaoFactory;
import IncDao.vo.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfath on 16/1/4.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        List<Users> all= new ArrayList<Users>();
        all=DaoFactory.getIuserDaostance().findAll();
        System.out.println(all.get(0));


    }
}
