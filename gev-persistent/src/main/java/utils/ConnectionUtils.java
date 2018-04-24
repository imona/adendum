package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Monzer Masri on 9.4.2018.
 */
public class ConnectionUtils {
    static final String DB_URL = PropertyReader.getAppProperty(ConstantUtils.JDBC_URL); //"jdbc:mysql://localhost:3306/"; //
    static final String DB_NAME = PropertyReader.getAppProperty(ConstantUtils.JDBC_DATABASE_NAME); //"d6d51eac55f047198ae2e8d2fdaa23d6";//"98db610e4e0c4973923d5165ca21431b" ; //
    static final String USER = PropertyReader.getAppProperty(ConstantUtils.JDBC_USER_NAME); //"root";
    static final String PASS = PropertyReader.getAppProperty(ConstantUtils.JDBC_PASSWORD); //"12345"; //

    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection((DB_URL + DB_NAME), USER, PASS);
    }
}
