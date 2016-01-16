package IncDao.dao.proxy;

import IncDao.dao.IIncDao;
import IncDao.dao.impl.IncDaoImpl;
import IncDao.dbc.DBConnection;
import IncDao.vo.Inc;

import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class IncDaoProxy implements IIncDao{
    private DBConnection dbc=null;
    private IIncDao dao=null;
    public IncDaoProxy() throws Exception{
        dbc=new DBConnection();
        dao=new IncDaoImpl(dbc.getConnection());
    }
    @Override
    public boolean doUpdate(Inc inc) throws Exception {
        boolean flag=false;
        dao.doUpdate(inc);
        flag=true;
        dbc.close();
        return flag;
    }

    @Override
    public Inc findAll() throws Exception {
        Inc inc = null;
        inc=dao.findAll();
        dbc.close();
        return inc;
    }

    @Override
    public boolean doInsert(Inc inc) throws Exception {
        dao.doInsert(inc);
        dbc.close();
        return true;
    }

    @Override
    public boolean doDelete(Inc inc) throws Exception {
        dao.doDelete(inc);
        dbc.close();
        return true;
    }
}
