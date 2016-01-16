package IncDao.dao.impl;

import IncDao.dao.IItemsDao;
import IncDao.vo.Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfath on 16/1/3.
 */
public class ItemsDaoImpl implements IItemsDao{
    private Connection conn = null ;
    private PreparedStatement pstmt = null ;
    public ItemsDaoImpl(Connection conn){
        this.conn=conn;
    }
    @Override
    public Items findById(String item_id) throws Exception {
        Items items=null;
        String sql="SELECT * FROM items WHERE item_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,item_id);
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            items = new Items();
            items.setItem_id(rs.getString(1));
            items.setItem_name(rs.getString(2));
            items.setItem_info(rs.getString(3));
        }
        pstmt.close();
        return items;

    }

    @Override
    public List<Items> findAll() throws Exception {
        List<Items> all = new ArrayList<Items>();
        String sql="SELECT * FROM items";
        pstmt=conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            Items items = new Items();
            items.setId(rs.getInt(1));
            items.setItem_id(rs.getString(2));
            items.setItem_name(rs.getString(3));
            items.setItem_info(rs.getString(4));
            items.setIclass(rs.getString(5));
            items.setIsrc(rs.getString(6));
            all.add(items);
        }
        pstmt.close();
        return all;
    }

    @Override
    public boolean doInsert(Items items) throws Exception {
        boolean flag=false;
        String sql="INSERT INTO items VALUES (null,?,?,?,?,?)";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,items.getItem_id());
        pstmt.setString(2,items.getItem_name());
        pstmt.setString(3,items.getItem_info());
        pstmt.setString(4,items.getIclass());
        pstmt.setString(5,items.getIsrc());

        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }

    @Override
    public boolean doUpdate(Items items) throws Exception {
        boolean flag=false;
        String sql="UPDATE items SET item_name=?,item_info=? WHERE item_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,items.getItem_name());
        pstmt.setString(2,items.getItem_info());
        pstmt.setString(3,items.getItem_id());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }

    @Override
    public boolean doDelete(Items items) throws Exception {
        boolean flag=false;
        String sql="DELETE FROM items WHERE item_id=?";
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,items.getItem_id());
        if(pstmt.executeUpdate()>0)
            flag=true;
        return flag;
    }
}
