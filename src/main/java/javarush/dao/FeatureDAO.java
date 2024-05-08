package javarush.dao;

import javarush.domain.Feature;
import javarush.domain.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FeatureDAO extends GenericDAO<Feature> {
    public FeatureDAO(SessionFactory sessionFactory) {
        super(Feature.class, sessionFactory);
    }

    public Film getFirstAvailableFilmForRent() {
        Query<Film> query = getCurrentSessionDAO().createQuery("select f from Film f where f.id not " +
                "in(select distinct f.id from Inventory)", Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
