package by.pvt.dao;

import by.pvt.dao.exception.DaoException;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IProductDao<T> extends Dao<T> {

    List<T> getAll()throws DaoException;

    Integer getTotalProductCount()throws DaoException;

    List<T> getPartProductPagination(Integer count, Integer startPosition) throws DaoException;
}
