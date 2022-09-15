package finalproject.part1.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataSourceUtil {

    private static final DataSourceUtil instance = new DataSourceUtil();
    private final String driverPath;
    private final String url;
    private final String user;
    private final String password;

    private DataSourceUtil() {
        this.driverPath = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://127.0.0.1/finallibrary?useSSL=false";
        this.user = "root";
        this.password = "admin";
    }

    public static DataSourceUtil getInstance() {
        return instance;
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
