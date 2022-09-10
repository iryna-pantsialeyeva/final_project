package finalproject.part1.service;

import finalproject.part1.bean.Book;

public interface BookService {

    void addBook(String name, String isbn, String author, String genre);

    void deleteBook(Long idBook);

    Book getBookById(Long id);

    Book getBookByParameters(String name, String author, String genre);
    }




