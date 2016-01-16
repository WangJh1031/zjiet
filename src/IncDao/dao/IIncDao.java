package IncDao.dao;

        import IncDao.vo.Inc;

        import java.util.List;

/**
 * Created by winfath on 16/1/1.
 */
public interface IIncDao {
    public boolean doUpdate(Inc inc) throws Exception;
    public Inc findAll() throws Exception;
    public boolean doInsert(Inc inc) throws  Exception;
    public boolean doDelete(Inc inc) throws Exception;

}
