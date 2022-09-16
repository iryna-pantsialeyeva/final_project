package finalproject.part1.dao;

public interface AuthorDAO {

        void addAuthor(String author);

        boolean isAuthorPresent(String author);

        int getIdAuthor(String author);
}
