package IncDao.dao.proxy;

import IncDao.dao.IItemsDao;
import IncDao.dao.IsytleDao;
import IncDao.dao.impl.IstyleDaoImpl;
import IncDao.dao.impl.ItemsDaoImpl;
import IncDao.dbc.DBConnection;
import IncDao.vo.Istyle;

import java.util.List;

/**
 * Created by winfa on 2016/1/7.
 */
public class IstyleDaoProxy implements IsytleDao{
    private DBConnection dbc=null;
    private IstyleDaoImpl dao=null;
    public IstyleDaoProxy() throws Exception{
        dbc=new DBConnection();
        dao=new IstyleDaoImpl(dbc.getConnection());
    }
    @Override
    public List<Istyle> findAll() throws Exception {
        List<Istyle> all =null;
        all=dao.findAll();
        dbc.close();
        return all;
    }
}
