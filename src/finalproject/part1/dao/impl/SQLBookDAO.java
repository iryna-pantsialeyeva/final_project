package finalproject.part1.dao.impl;

import finalproject.part1.bean.Author;
import finalproject.part1.bean.Book;
import finalproject.part1.bean.Genre;
import finalproject.part1.dao.BookDAO;
import finalproject.part1.dao.util.DataSourceUtil;
import finalproject.part1.dao.util.SQLRequest;

import java.sql.*;


public class SQLBookDAO implements BookDAO {

    private SQLAuthorDAO sqlAuthorDAO;
    private SQLGenreDAO sqlGenreDAO;
    private DataSourceUtil connectionManager;

    public SQLBookDAO() {
        this.sqlAuthorDAO = new SQLAuthorDAO();
        this.sqlGenreDAO = new SQLGenreDAO();
        this.connectionManager = DataSourceUtil.getInstance();
    }

    public void addBook(Book book) {

        int idAuthor = sqlAuthorDAO.getIdAuthor(book.getAuthor().getName());
        int idGenre = sqlGenreDAO.getIdGenre(book.getGenre().getName());
        try (Connection con = connectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLRequest.ADD_BOOK))
        {
            ps.setString(1, book.getName());
            ps.setString(2, book.getISBN());
            ps.setInt(3, idAuthor);
            ps.setInt(4, idGenre);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Long idBook) {

        try (Connection con = connectionManager.getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(SQLRequest.DELETE_BOOK + idBook);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getBook(Long id) {
        Book book = null;
        try (Connection con = connectionManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(SQLRequest.RETURN_BOOK_BY_ID + Math.toIntExact(id))) {
            book = new Book();

            if (rs.next()) {
                book.setId(rs.getLong(1));
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

    public Book getBookByParameters(String name, String author, String genre) {

        Book book = null;
        try (Connection con = connectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(SQLRequest.RETURN_BOOK_BY_PARAMETERS);
             ResultSet rs = ps.executeQuery()) {
            book = new Book();

            ps.setString(1, name);
            ps.setString(2, author);
            ps.setString(3, genre);

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
