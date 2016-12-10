package by.pvt.dao;

import by.pvt.dao.exception.DaoException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/17/2016.
 */
public interface Dao<T> {

    void saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;

}
