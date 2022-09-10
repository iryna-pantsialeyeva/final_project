package finalproject.part1.dao;

public interface GenreDAO {

    void addGenre(String genre);

    boolean isGenrePresent(String genre);

    int getIdGenre(String genre);
}
