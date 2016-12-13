package by.pvt.dao;

import by.pvt.dao.exception.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


@Repository()
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);


    public BaseDao() {

    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(T t) throws DaoException {
        try {
            Session session = getSession();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao" + e);
            throw new DaoException(e);
        }

    }

    public T get(Serializable id) throws DaoException {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            Session session = getSession();
            t = (T) session.get(getPersistentClass(), id);
            System.out.println("isDirty before commit = "+ session.isDirty());
            System.out.println("isDirty after commit = "+ session.isDirty());
            log.info("get class:" + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public T load(Serializable id) throws DaoException {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            Session session = getSession();
            t = (T) session.load(getPersistentClass(), id);
            System.out.println("isDirty before commit = "+ session.isDirty());
            log.info("load() class:" + t);
            System.out.println("isDirty after commit = "+ session.isDirty());
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public void delete(T t) throws DaoException {
        try {
            Session session = getSession();
            session.delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error delete PERSON in Dao" + e);
            throw new DaoException(e);
        }
    }


    protected Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}