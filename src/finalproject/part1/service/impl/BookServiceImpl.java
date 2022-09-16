package finalproject.part1.service.impl;

import finalproject.part1.bean.Author;
import finalproject.part1.bean.Book;
import finalproject.part1.bean.Genre;
import finalproject.part1.dao.AuthorDAO;
import finalproject.part1.dao.BookDAO;
import finalproject.part1.dao.DAOFactory;
import finalproject.part1.dao.GenreDAO;
import finalproject.part1.service.BookService;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAOImpl;
    private GenreDAO genreDAOImpl;
    private AuthorDAO authorDAOImpl;

    public BookServiceImpl() {
        this.bookDAOImpl = DAOFactory.getInstance().getSqlBookDAO();
        this.genreDAOImpl = DAOFactory.getInstance().getSqlGenreDAO();
        this.authorDAOImpl = DAOFactory.getInstance().getSqlAuthorDAO();
    }

    @Override
    public void addBook(String name, String isbn, String author, String genre) {

        Author authorClass = new Author(author);
        Genre genreClass = new Genre(genre);
        if (!authorDAOImpl.isAuthorPresent(author)) {
            authorDAOImpl.addAuthor(author);
        }
        if (!genreDAOImpl.isGenrePresent(genre)) {
            genreDAOImpl.addGenre(genre);
        }
        Book book = new Book(name, isbn, authorClass, genreClass);
        bookDAOImpl.addBook(book);
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
