package finalproject.part1.service.impl;

import finalproject.part1.dao.DAOFactory;
import finalproject.part1.dao.GenreDAO;
import finalproject.part1.service.GenreService;

public class GenreServiceImpl implements GenreService {

    private GenreDAO genreDAOImpl;

    public GenreServiceImpl() {
        this.genreDAOImpl = DAOFactory.getInstance().getSqlGenreDAO();
    }

    @Override
    public void addGenre(String genre) {
    genreDAOImpl.addGenre(genre);
    }

    @Override
    public boolean isGenrePresent(String genre) {
        return genreDAOImpl.isGenrePresent(genre);
    }

    @Override
    public int getIdGenre(String genre) {
        return genreDAOImpl.getIdGenre(genre);
    }
}
