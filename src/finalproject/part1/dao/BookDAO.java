package finalproject.part1.dao;

import finalproject.part1.bean.Book;

public interface BookDAO {

    void addBook(Book book);

    void deleteBook(Long idBook);

    Book getBook(Long id);

    Book getBookByParameters(String name, String author, String genre);
}
