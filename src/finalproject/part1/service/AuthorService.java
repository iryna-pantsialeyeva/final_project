package finalproject.part1.service;

public interface AuthorService {

    void addAuthor(String author);

    boolean isAuthorPresent(String author);

    int getIdAuthor(String author);
}
