package Bean;

import IncDao.factory.DaoFactory;
import IncDao.vo.Inc;

/**
 * Created by winfa on 2016/1/5.
 */
public class IncBean {
    String inc_title;
    String inc_value;
    Inc inc = null;
    public IncBean() throws Exception {
        Inc inc = new Inc();
        inc= DaoFactory.getIIncDaostance().findAll();
        setInc_title(inc.getInc_title());
        setInc_value(inc.getInc_info());

    }
    public String getInc_title() throws Exception {

        return inc_title;
    }

    public String getInc_value() throws Exception {
        return inc_value;
    }

    public void setInc_title(String inc_title) throws Exception {
        this.inc_title=inc_title;

    }


    public void setInc_value(String inc_value) throws Exception {
        this.inc_value=inc_value;
    }



}
