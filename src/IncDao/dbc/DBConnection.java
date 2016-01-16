package IncDao.dbc;
import java.sql.Connection ;
import java.sql.DriverManager ;
/**
 * Created by winfath on 16/1/3.
 */
public class DBConnection {
    private static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    private static final String DBURL = "jdbc:mysql://localhost:3306/zjiet" ;
    private static final String DBUSER = "root" ;
    private static final String DBPASSWORD = "root" ;
    private static Connection conn ;
    public DBConnection() throws Exception {
        Class.forName(DBDRIVER) ;
        this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
    }
    public static Connection getConnection(){
        return conn ;
    }
    public void close() throws Exception {
        if(this.conn != null){
            try{
                this.conn.close() ;
            }catch(Exception e){
                throw e ;
            }
        }
    }
}
