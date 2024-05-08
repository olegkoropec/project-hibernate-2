package javarush.dao;

import javarush.domain.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends GenericDAO<Country>{
    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
