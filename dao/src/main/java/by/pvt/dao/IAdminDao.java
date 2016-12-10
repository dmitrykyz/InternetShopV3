package by.pvt.dao;

import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Admin;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IAdminDao<T> extends Dao<T> {

    List<T> getAdminByLogin(String login) throws DaoException;;
}
