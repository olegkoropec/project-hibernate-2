package javarush.dao;

import javarush.dao.GenericDAO;
import javarush.domain.Rating;
import org.hibernate.SessionFactory;

public class RatingDAO extends GenericDAO<Rating> {
    public RatingDAO(SessionFactory sessionFactory) {
        super(Rating.class, sessionFactory);
    }
}
