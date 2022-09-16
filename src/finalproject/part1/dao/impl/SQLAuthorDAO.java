package finalproject.part1.dao.impl;

import finalproject.part1.dao.AuthorDAO;
import finalproject.part1.dao.util.DataSourceUtil;
import finalproject.part1.dao.util.SQLRequest;

import java.sql.*;


public class SQLAuthorDAO implements AuthorDAO {

    private DataSourceUtil connectionManager;

    public SQLAuthorDAO() {
        this.connectionManager = DataSourceUtil.getInstance();
    }

    @Override

    public void addAuthor(String author) {

        try (Connection con = connectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLRequest.ADD_AUTHOR_BY_NAME)) {

            ps.setString(1, author);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Author %s was added", author));
    }

    @Override
    public boolean isAuthorPresent(String author) {

        try (Connection con = connectionManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SQLRequest.RETURN_AUTHOR_ID + "\'" + author + "\'");) {

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getIdAuthor(String author) {
        int idAuthor = 0;
        String sql = String.format(SQLRequest.RETURN_AUTHOR_ID + "\'%s\'", author);
        try (Connection con = connectionManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                idAuthor = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return idAuthor;
    }
}
