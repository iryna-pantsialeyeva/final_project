package finalproject.part1.dao.impl;

import finalproject.part1.bean.Author;
import finalproject.part1.bean.Book;
import finalproject.part1.bean.Genre;
import finalproject.part1.dao.BookDAO;
import finalproject.part1.dao.util.DataSourceUtil;
import finalproject.part1.dao.util.SQLRequest;

import java.sql.*;


public class SQLBookDAO implements BookDAO {

    private SQLAuthorDAO sqlAuthorDAO = new SQLAuthorDAO();
    private SQLGenreDAO sqlGenreDAO = new SQLGenreDAO();
    private DataSourceUtil connectionManager = DataSourceUtil.getInstance();

    public void addBook(String name, String isbn, String author, String genre) {
        Connection con = connectionManager.getConnection();
        try {
            PreparedStatement ps;
            String sql = SQLRequest.ADD_BOOK;
            int idAuthor = sqlAuthorDAO.getIdAuthor(author);
            int idGenre = sqlGenreDAO.getIdGenre(genre);

            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, isbn);
            ps.setInt(3, idAuthor);
            ps.setInt(4, idGenre);
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

    public void deleteBook(Long idBook) {
        Connection con = connectionManager.getConnection();
        try {
            Statement st = con.createStatement();
            st.executeUpdate(SQLRequest.DELETE_BOOK + idBook);
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
    public Book getBook(Long id) {
        Connection con = connectionManager.getConnection();
        Book book = null;
        try {
            book = new Book();
            String sql = SQLRequest.RETURN_BOOK_BY_ID + Math.toIntExact(id);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                book.setId((long) rs.getInt(1));
                book.setName(rs.getString(2));
                book.setISBN(rs.getString(3));
                book.setAuthor(new Author(rs.getString(4)));
                book.setGenre(new Genre(rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return book;
    }


    public Book getBookByParameters(String name, String author, String genre) {
        Connection con = connectionManager.getConnection();
        Book book = null;
        try {
            book = new Book();
            PreparedStatement ps;
            String sql = SQLRequest.RETURN_BOOK_BY_PARAMETERS;

            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, genre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                book.setId((long) rs.getInt(1));
                book.setName(rs.getString(2));
                book.setISBN(rs.getString(3));
                book.setAuthor(new Author(rs.getString(4)));
                book.setGenre(new Genre(rs.getString(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
