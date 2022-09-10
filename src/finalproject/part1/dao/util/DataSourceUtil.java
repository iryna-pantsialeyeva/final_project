package finalproject.part1.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataSourceUtil {

    private static final DataSourceUtil instance = new DataSourceUtil();

    private String driverPath;
    private String url;
    private String user;
    private String password;

    private DataSourceUtil() {
        this.driverPath = StaticVariable.DRIVER_PATH;
        this.url = StaticVariable.URL;
        this.user = StaticVariable.USER;
        this.password = StaticVariable.PASSWORD;
    }

    public static DataSourceUtil getInstance() {
        return instance;
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driverPath);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
