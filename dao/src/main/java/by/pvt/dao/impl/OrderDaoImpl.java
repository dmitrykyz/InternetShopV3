package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.IOrderDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Order;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dmitry on 11/21/2016.
 */
@Repository()
public class OrderDaoImpl extends BaseDao<Order> implements IOrderDao<Order> {

    private static Logger log = Logger.getLogger(OrderDaoImpl.class);

    public OrderDaoImpl() {
    }

    public List<Order> getOrderByUserId(Integer id) throws DaoException {
        List<Order> orders = null;

        try {
            Session session = getSession();
            String hql = "SELECT O FROM Order O WHERE O.client.idUser=:idUserParam";
            Query query = session.createQuery(hql);
            query.setParameter("idUserParam", id);
            orders = query.list();
            log.info("getOrderByUserId() List<Order> by :" + id);
        } catch (HibernateException e) {
            log.error("Error getOrderByUserId() List<Order> by :" + id + " in Dao" + e);
            throw new DaoException(e);
        }

        return orders;
    }
}
