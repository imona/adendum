package utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Monzer Masri on 9.4.2018.
 */
public class ConnectionUtils {
    static final String DB_URL = PropertyReader.getAppProperty(ConstantUtils.JDBC_URL); //"jdbc:mysql://localhost:3306/"; //
    static final String DB_NAME = PropertyReader.getAppProperty(ConstantUtils.JDBC_DATABASE_NAME); //"d6d51eac55f047198ae2e8d2fdaa23d6";//"98db610e4e0c4973923d5165ca21431b" ; //
    static final String USER = PropertyReader.getAppProperty(ConstantUtils.JDBC_USER_NAME); //"root";
    static final String PASS = PropertyReader.getAppProperty(ConstantUtils.JDBC_PASSWORD); //"12345"; //
    static final String DB_TYPE = PropertyReader.getAppProperty(ConstantUtils.JDBC_TYPE); //"12345"; //
//    static final Integer MIN_IDLE = Integer.valueOf(PropertyReader.getAppProperty(ConstantUtils.JDBC_POOL_MIN_IDLE)); //"12345"; //
//    static final Integer MAX_IDLE = Integer.valueOf(PropertyReader.getAppProperty(ConstantUtils.JDBC_POOL_MAX_IDLE)); //"12345"; //
//    static final Integer MAX_ACIVE = Integer.valueOf(PropertyReader.getAppProperty(ConstantUtils.JDBC_POOL_MAX_ACTIVE)); //"12345"; //
//    static final Integer MAX_OPENED_PS = Integer.valueOf(PropertyReader.getAppProperty(ConstantUtils.JDBC_POOL_MAX_OPENED_PS)); //"12345"; //

    static BasicDataSource ds = null;

    /* public static BasicDataSource getDataSource() throws Exception {
         if(ds == null) {
             ds = new BasicDataSource();

             if("MYSQL".equals(DB_TYPE)) {
                 ds.setDriverClassName("com.mysql.jdbc.Driver");
             } else if("MSSQL".equals(DB_TYPE)){
                 ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             } else {
                 throw new Exception("ERROR DB_TYPE in main.config file is wrong.");
             }

             ds.setUsername(USER);
             ds.setPassword(PASS);
             ds.setUrl(DB_URL + DB_NAME);

             // the settings below are optional -- dbcp can work with defaults
             ds.setMinIdle(MIN_IDLE);
             ds.setMaxIdle(MAX_IDLE);
             ds.setMaxActive(MAX_ACIVE);
             ds.setMaxOpenPreparedStatements(MAX_OPENED_PS);
         }

         return ds;
     }

     public static Connection getConnection() throws Exception {
         return  getDataSource().getConnection();
     }*/
    public static Connection getConnection() throws Exception {
        if("MYSQL".equals(DB_TYPE)) {
            Class.forName("com.mysql.jdbc.Driver");
        } else if("MSSQL".equals(DB_TYPE)){
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } else {
            throw new Exception("ERROR DB_TYPE in main.config file is wrong.");
        }

        return DriverManager.getConnection((DB_URL + DB_NAME), USER, PASS);
    }
}
