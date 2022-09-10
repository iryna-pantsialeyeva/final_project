package finalproject.part1.dao.impl;

import finalproject.part1.dao.AuthorDAO;
import finalproject.part1.dao.util.DataSourceUtil;
import finalproject.part1.dao.util.SQLRequest;

import java.sql.*;


public class SQLAuthorDAO implements AuthorDAO {

    private DataSourceUtil connectionManager = DataSourceUtil.getInstance();

    @Override

    public void addAuthor(String author) {
        Connection con = connectionManager.getConnection();
        try {
            String sql = SQLRequest.ADD_AUTHOR_BY_NAME;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, author);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isAuthorPresent(String author) {
        Connection con = connectionManager.getConnection();

        try {
            String sql = SQLRequest.RETURN_AUTHOR_ID + "\'" + author + "\'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int getIdAuthor(String author) {
        int idAuthor = 0;
        Connection con = connectionManager.getConnection();

        try {
            String sql = SQLRequest.RETURN_AUTHOR_ID + "\'" + author + "\'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idAuthor = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idAuthor;
    }
}
