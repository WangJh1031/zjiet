package Bean;

import IncDao.factory.DaoFactory;
import IncDao.vo.Items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfa on 2016/1/7.
 */
public class ItemBean {
    List<Items> all = new ArrayList<Items>();
    public ItemBean()throws Exception{
        all=DaoFactory.getIItemsDaostance().findAll();
    }

    public List<Items> getAll() {
        return all;
    }
}
