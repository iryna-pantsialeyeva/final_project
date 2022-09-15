package finalproject.part1.dao.impl;

import finalproject.part1.dao.GenreDAO;
import finalproject.part1.dao.util.DataSourceUtil;
import finalproject.part1.dao.util.SQLRequest;

import java.sql.*;

public class SQLGenreDAO implements GenreDAO {

    private DataSourceUtil connectionManager;

    public SQLGenreDAO() {
        this.connectionManager = DataSourceUtil.getInstance();
    }

    @Override
    public void addGenre(String genre) {

        try (Connection con = connectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLRequest.ADD_GENRE_BY_NAME))
        {
            ps.setString(1, genre);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Genre %s was added.", genre));
    }

    public boolean isGenrePresent(String genre) {

        String sql = SQLRequest.RETURN_GENRE_BY_NAME + String.format("\'%s\'", genre);
        try (Connection con = connectionManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql))
        {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getIdGenre(String genre) {
        int idGenre = 0;
        String sql = SQLRequest.RETURN_GENRE_ID + String.format("\'%s\'", genre);
        try (Connection con = connectionManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql))
        {
            if (rs.next()) {
                idGenre = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idGenre;
    }
}
