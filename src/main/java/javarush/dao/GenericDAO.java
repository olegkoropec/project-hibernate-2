package javarush.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GenericDAO <T>{
    private final Class<T> clazz;
    private SessionFactory sessionFactory;

    public GenericDAO(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    public T getByID(final int id){
        return (T) getCurrentSessionDAO().get(clazz, id);
    }

    public List<T> getItems(int offset, int count){
        Query<T> query = getCurrentSessionDAO().createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.getResultList();
    }

    public List<T> findAll(){
        return getCurrentSessionDAO().createQuery("from " + clazz.getName(), clazz).list();
    }

    public T save(final T entity){
        getCurrentSessionDAO().saveOrUpdate(entity);
        return entity;
    }

    public T update(final T entity){
        return (T) getCurrentSessionDAO().merge(entity);
    }

    public void delete(final T entity){
        getCurrentSessionDAO().delete(entity);
    }

    public void deleteByID(final int entity){
        final T byID = getByID(entity);
        delete(byID);
    }

    protected Session getCurrentSessionDAO(){
        return sessionFactory.getCurrentSession();
    }
}
