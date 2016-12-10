package by.pvt.dao;

import by.pvt.dao.exception.DaoException;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IClientDao<T> extends Dao<T> {

    List<T> getClientByLogin(String login) throws DaoException;
}
