package by.pvt.services;

import by.pvt.services.exception.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
public interface IService<T> {

    boolean saveOrUpdate(T t) throws ServiceException;

    T get(Serializable id) throws ServiceException;

    T load(Serializable id) throws ServiceException;

    boolean delete(T t) throws ServiceException;

    List<T> getAll() throws ServiceException;

}
