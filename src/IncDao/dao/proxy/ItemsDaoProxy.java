package IncDao.dao.proxy;

import IncDao.dao.IItemsDao;
import IncDao.dao.impl.ItemsDaoImpl;
import IncDao.dbc.DBConnection;
import IncDao.vo.Items;

import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class ItemsDaoProxy implements IItemsDao {
    private DBConnection dbc=null;
    private IItemsDao dao=null;
    public ItemsDaoProxy() throws Exception{
        dbc = new DBConnection();
        dao = new ItemsDaoImpl(dbc.getConnection());
    }
    @Override
    public Items findById(String item_id) throws Exception {
        Items items =null;
        items=dao.findById(item_id);
        dbc.close();
        return items;
    }

    @Override
    public List<Items> findAll() throws Exception {
        List<Items> all=null;
        all=dao.findAll();
        dbc.close();
        return all;
    }

    @Override
    public boolean doInsert(Items items) throws Exception {
        boolean flag=false;
        if(dao.findById(items.getItem_id())==null)
            flag=dao.doInsert(items);
        dbc.close();
        return flag;
    }

    @Override
    public boolean doUpdate(Items items) throws Exception {
        boolean flag=false;
        if(dao.findById(items.getItem_id())!=null)
            flag=dao.doUpdate(items);
        dbc.close();
        return flag;
    }

    @Override
    public boolean doDelete(Items items) throws Exception {
        boolean flag=false;
        if(dao.findById(items.getItem_id())!=null)
            flag=dao.doDelete(items);
        dbc.close();
        return flag;
    }
}
