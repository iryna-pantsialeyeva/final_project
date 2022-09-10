package finalproject.part1.service;

import finalproject.part1.service.impl.AuthorServiceImpl;
import finalproject.part1.service.impl.BookServiceImpl;
import finalproject.part1.service.impl.GenreServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private BookService bookService = new BookServiceImpl();
    private AuthorService authorService = new AuthorServiceImpl();
    private GenreService genreService = new GenreServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public BookService getBookService(){
        return bookService;
    }

    public AuthorService getAuthorService() {
        return authorService;
    }

    public GenreService getGenreService() {
        return genreService;
    }
}
