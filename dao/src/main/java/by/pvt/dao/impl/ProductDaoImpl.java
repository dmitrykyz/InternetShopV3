package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.IProductDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Product;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
@Repository()
public class ProductDaoImpl extends BaseDao<Product> implements IProductDao<Product>{
    private static Logger log = Logger.getLogger(ClientDaoImpl.class);

    public ProductDaoImpl() {
        super();
    }


    public List<Product> getAll()throws DaoException {
        try {
            Session session = getSession();
            Query query = session.createQuery("from Product P");
            List<Product> list = query.list();
            log.info("Get all rows from Product");
            return list;
        } catch (HibernateException e) {
            log.error("Error Get all rows in ProductDaoImpl" + e);
            throw new DaoException(e);
        }
    }

    public List<Product> getAllFilterById() throws DaoException {
        try {
            Session session = getSession();
            Query query = session.createQuery("from Product P ORDER BY P.idProduct ASC");
            List<Product> list = query.list();
            log.info("Get all rows from Product Filter By idProduct");
            return list;
        } catch (HibernateException e) {
            log.error("Error Get all rows in ProductDaoImpl Filter By idProduct" + e);
            throw new DaoException(e);
        }
    }

    public List<Product> getAllFilterByName() throws DaoException {
        try {
            Session session = getSession();
            Query query = session.createQuery("from Product P ORDER BY P.nameProduct ASC");
            List<Product> list = query.list();
            log.info("Get all rows from Product Filter By Name");
            return list;
        } catch (HibernateException e) {
            log.error("Error Get all rows in ProductDaoImpl Filter By Name" + e);
            throw new DaoException(e);
        }
    }

    public List<Product> getAllFilterByPrice() throws DaoException {
        try {
            Session session = getSession();
            Query query = session.createQuery("from Product P ORDER BY P.price ASC");
            List<Product> list = query.list();
            log.info("Get all rows from Product Filter By price");
            return list;
        } catch (HibernateException e) {
            log.error("Error Get all rows in ProductDaoImpl Filter By price" + e);
            throw new DaoException(e);
        }
    }

    public Integer getTotalProductCount()throws DaoException {
        Integer totalProductCount = 0;
        log.info("Get totalProductCount");

        try {
            Session session = getSession();
            Query query = session.createQuery("select count(P) from Product P");
            query.setCacheable(true);
            Long totalProduct = (Long) query.uniqueResult();
            totalProductCount = totalProduct != null ? totalProduct.intValue() : null;
            log.info("got totalProductCount!");
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return totalProductCount;
    }

    public List<Product> getPartProductPagination(Integer count, Integer startPosition) throws DaoException{
        List<Product>  productList = null;
        try {
            Session session = getSession();
            String hql = "from Product ";
            Query query = session.createQuery(hql);
            query.setFirstResult(startPosition);
            query.setMaxResults(count);
            query.setCacheable(true);
            productList = query.list();
        } catch (HibernateException e) {
            log.error("Error get " + " in Dao" + e);
            throw new DaoException(e);
        }
        return productList;
    }
}
