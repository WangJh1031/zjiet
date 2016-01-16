package Bean;

import IncDao.factory.DaoFactory;
import IncDao.vo.Inc_news;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winfa on 2016/1/6.
 */
public class NewsBean {
    List<Inc_news> all = new ArrayList<Inc_news>();
    public NewsBean() throws Exception{
        all= DaoFactory.getIInc_newsDaostance().findAll();
    }

    public List<Inc_news> getAll() {
        return all;
    }
}
