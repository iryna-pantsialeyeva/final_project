package finalproject.part1.dao.util;

public final class SQLRequest {

    public static final String RETURN_AUTHOR_ID = "SELECT id FROM authors WHERE name=";
    public static final String RETURN_AUTHOR_BY_NAME = "SELECT * FROM authors WHERE name = ";
    public static final String RETURN_GENRE_ID = "SELECT id FROM genres WHERE name=";
    public static final String RETURN_GENRE_BY_NAME = "SELECT * FROM genres WHERE name = ";
    public static final String RETURN_BOOK_BY_ID = "SELECT books.id, books.name, books.isbn, authors.name, genres.name" +
            " FROM books LEFT JOIN authors ON books.author_id=authors.id LEFT JOIN genres ON books.genre_id=genres.id " +
            "WHERE books.id=";
    public static final String RETURN_BOOK_BY_PARAMETERS = "SELECT books.id, books.name, books.isbn, authors.name, genres.name" +
            " FROM books LEFT JOIN authors ON books.author_id=authors.id LEFT JOIN genres ON books.genre_id=genres.id " +
            "WHERE books.name=? AND authors.name=? AND genres.name=?";


    public static final String ADD_AUTHOR_BY_NAME = "INSERT INTO authors(name) VALUES(?)";
    public static final String ADD_GENRE_BY_NAME = "INSERT INTO genres(name) VALUES(?)";
    public static final String ADD_BOOK = "INSERT INTO books(name, isbn, author_id, genre_id) VALUES (?,?,?,?)";

    public static final String DELETE_BOOK = "DELETE FROM books where id = ";
}
