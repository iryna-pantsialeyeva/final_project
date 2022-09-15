package finalproject.part1.service.impl;

import finalproject.part1.dao.AuthorDAO;
import finalproject.part1.dao.DAOFactory;
import finalproject.part1.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDAO authorDAOImpl;

    public AuthorServiceImpl() {
        this.authorDAOImpl = DAOFactory.getInstance().getSqlAuthorDAO();
    }

    @Override
    public void addAuthor(String author) {
    authorDAOImpl.addAuthor(author);
    }

    @Override
    public boolean isAuthorPresent(String author) {
        return authorDAOImpl.isAuthorPresent(author);
    }

    @Override
    public int getIdAuthor(String author) {
        return authorDAOImpl.getIdAuthor(author);
    }
}
