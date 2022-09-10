package finalproject.part1.dao;

import finalproject.part1.bean.Book;

public interface BookDAO {

    void addBook(String name, String isbn, String author, String genre);

    void deleteBook(Long idBook);

    Book getBook(Long id);

    Book getBookByParameters(String name, String author, String genre);
}
