package finalproject.part1.service;

public interface GenreService {

    void addGenre(String genre);

    boolean isGenrePresent(String genre);

    int getIdGenre(String genre);
}
