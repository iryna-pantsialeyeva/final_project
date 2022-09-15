package finalproject.part1.bean;

import java.util.Objects;

public class Book {

    private Long id;
    private Author author;
    private String name;
    private Genre genre;
    private String ISBN;

    public Book() {
    }

    public Book(Long id, Author author, String name, Genre genre, String ISBN) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.genre = genre;
        this.ISBN = ISBN;
    }

    public Book(String name, String ISBN, Author author, Genre genre) {
        this.name = name;
        this.ISBN = ISBN;
        this.author = author;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author a) {
        this.author = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre g) {
        this.genre = g;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(name, book.name) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, name, genre);
    }

    @Override
    public String toString() {
        return " \n**********************\n Here is you book: \n id: " + id + "\n author: " + author + "\n book name: "
                + name + "\n genre: " + genre + "\n ISBN: " + ISBN;
    }
}
