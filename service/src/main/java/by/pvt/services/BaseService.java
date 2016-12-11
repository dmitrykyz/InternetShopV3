package by.pvt.services;

import by.pvt.dao.BaseDao;
import by.pvt.dao.Dao;
import by.pvt.dao.exception.DaoException;
import by.pvt.services.exception.ServiceException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public abstract class BaseService<T> implements IService<T> {

    @Autowired
    private Dao<T> baseDao;

    public BaseService() {
    }


    @Override
    public boolean saveOrUpdate(T t) throws ServiceException {
        try {
            baseDao.saveOrUpdate(t);
            return true;
        } catch (DaoException e) {
            return false;
        }
    }

    @Override
    public abstract T get(Serializable id) throws ServiceException;

    @Override
    public abstract T load(Serializable id) throws ServiceException;

    @Override
    public boolean delete(T t) throws ServiceException {
        try {
            baseDao.delete(t);
            return true;
        } catch (DaoException e) {

            return false;
        }
    }

    @Override
    public abstract List<T> getAll() throws ServiceException;
}
