package Bean;

import IncDao.factory.DaoFactory;
import IncDao.vo.Istyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfa on 2016/1/7.
 */
public class IstyleBean {
    List<Istyle> all = new ArrayList<Istyle>();
    public IstyleBean() throws Exception{
        all= DaoFactory.getIstyleDaostance().findAll();
    }

    public List<Istyle> getAll() {
        return all;
    }
}
