package finalproject.part1.dao.impl;

import finalproject.part1.dao.GenreDAO;
import finalproject.part1.dao.util.DataSourceUtil;
import finalproject.part1.dao.util.SQLRequest;

import java.sql.*;

public class SQLGenreDAO implements GenreDAO {

    private DataSourceUtil connectionManager = DataSourceUtil.getInstance();

    @Override
    public void addGenre(String genre) {
        Connection con = connectionManager.getConnection();

        try {
            String sql = SQLRequest.ADD_GENRE_BY_NAME;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, genre);
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

    public boolean isGenrePresent(String genre) {

        Connection con = connectionManager.getConnection();
        try {
            String sql = SQLRequest.RETURN_GENRE_BY_NAME + "\'" + genre + "\'";

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

    public int getIdGenre(String genre) {
        int idGenre = 0;
        Connection con = connectionManager.getConnection();

        try {
            String sql = SQLRequest.RETURN_GENRE_ID + "\'" + genre + "\'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                idGenre = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idGenre;
    }
}
