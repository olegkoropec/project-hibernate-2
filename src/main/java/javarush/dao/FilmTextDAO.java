package javarush.dao;

import javarush.dao.GenericDAO;
import javarush.domain.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDAO extends GenericDAO<FilmText> {
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
