package by.pvt.dao;

import by.pvt.dao.exception.DaoException;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IOrderDao<T> extends Dao<T> {

    List<T> getOrderByUserId(Integer id) throws DaoException;
}
