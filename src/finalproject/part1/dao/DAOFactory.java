package finalproject.part1.dao;

import finalproject.part1.dao.impl.SQLAuthorDAO;
import finalproject.part1.dao.impl.SQLBookDAO;
import finalproject.part1.dao.impl.SQLGenreDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private BookDAO sqlBookDAO = new SQLBookDAO();
    private AuthorDAO sqlAuthorDAO = new SQLAuthorDAO();
    private GenreDAO sqlGenreDAO = new SQLGenreDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public BookDAO getSqlBookDAO() {
        return sqlBookDAO;
    }

    public AuthorDAO getSqlAuthorDAO() {
        return sqlAuthorDAO;
    }

    public GenreDAO getSqlGenreDAO() {
        return sqlGenreDAO;
    }
}
