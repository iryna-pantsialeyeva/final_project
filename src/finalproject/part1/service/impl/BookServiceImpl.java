package finalproject.part1.service.impl;

import finalproject.part1.bean.Book;
import finalproject.part1.dao.AuthorDAO;
import finalproject.part1.dao.BookDAO;
import finalproject.part1.dao.DAOFactory;
import finalproject.part1.dao.GenreDAO;
import finalproject.part1.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAOImpl = DAOFactory.getInstance().getSqlBookDAO();
    private GenreDAO genreDAOImpl = DAOFactory.getInstance().getSqlGenreDAO();
    private AuthorDAO authorDAOImpl = DAOFactory.getInstance().getSqlAuthorDAO();

    @Override
    public void addBook(String name, String isbn, String author, String genre) {

        if (!authorDAOImpl.isAuthorPresent(author)) {
            authorDAOImpl.addAuthor(author);
        }
        if (!genreDAOImpl.isGenrePresent(genre)) {
            genreDAOImpl.addGenre(genre);
        }
        bookDAOImpl.addBook(name, isbn, author, genre);
    }

    @Override
    public void deleteBook(Long idBook) {
        bookDAOImpl.deleteBook(idBook);
    }

    @Override
    public Book getBookById(Long id) {
        return bookDAOImpl.getBook(id);
    }

    @Override
    public Book getBookByParameters(String name, String author, String genre) {
        return bookDAOImpl.getBookByParameters(name,author,genre);
    }
}
