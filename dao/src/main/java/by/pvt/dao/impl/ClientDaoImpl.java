package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.IClientDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Client;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
@Repository()
public class ClientDaoImpl extends BaseDao<Client> implements IClientDao<Client> {

    private static Logger log = Logger.getLogger(ClientDaoImpl.class);

    public ClientDaoImpl() {
    }

    public List<Client> getClientByLogin(String login) throws DaoException {
        List<Client> clients = null;

        try {
            Session session = getSession();
            String hql = "SELECT C FROM Client C WHERE C.login=:loginParam";
            Query query = session.createQuery(hql);
            query.setParameter("loginParam", login);
            clients = query.list();
            log.info("getClientByLogin() List<User> by :" + login);
        } catch (HibernateException e) {
            log.error("Error getClientByLogin() List<User> by :" + login + " in Dao" + e);
            throw new DaoException(e);
        }

        return clients;
    }
}
