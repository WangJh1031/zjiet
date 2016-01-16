package IncDao.dao;

import IncDao.vo.Items;

import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public interface IItemsDao {
    public Items findById(String item_id) throws Exception;
    public List<Items> findAll() throws Exception;
    public boolean doInsert(Items items) throws Exception;
    public boolean doUpdate(Items items) throws Exception;
    public boolean doDelete(Items items) throws Exception;
}
