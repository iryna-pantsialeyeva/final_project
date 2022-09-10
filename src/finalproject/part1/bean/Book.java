package finalproject.part1.bean;

import java.util.Objects;

public class Book {

    private Long id;
    private Author a;
    private String name;
    private Genre g;
    private String ISBN;

    public Book() {
    }

    public Book(Long id, Author a, String name, Genre g, String ISBN) {
        this.id = id;
        this.a = a;
        this.name = name;
        this.g = g;
        this.ISBN = ISBN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return a;
    }

    public void setAuthor(Author a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return g;
    }

    public void setGenre(Genre g) {
        this.g = g;
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
        return Objects.equals(a, book.a) && Objects.equals(name, book.name) && Objects.equals(g, book.g);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, name, g);
    }

    @Override
    public String toString() {
        return " \n**********************\n Here is you book: \n id: " + id + "\n author: " + a + "\n book name: "
                + name + "\n genre: " + g + "\n ISBN: " + ISBN;
    }
}
