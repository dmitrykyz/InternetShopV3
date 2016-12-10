package by.pvt.dao;

import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.entity.Product;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Dmitry on 11/22/2016.
 */
public class BaseDaoTest{

    BaseDao<Product> productDao;
    Product product1;


    @Before
    public void setUp(){
//        productDao = new ProductDaoImpl();
//        product1 = new Product();
//        product1.setIdProduct(99);
//        product1.setNameProduct("Tea");
//        product1.setPrice(5.0);
//        product1.setStatus(1);
//        try {
//            productDao.saveOrUpdate(product1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void saveOrUpdate() throws Exception {
//        try {
//            productDao.saveOrUpdate(product1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        assertNotNull(productDao.get(99));

    }

    @Test
    public void get() throws Exception {

//        Product product = null;
//
//        try {
//            productDao.saveOrUpdate(product1);
//            product = productDao.get(99);
//
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        assertNotNull(product);
//        assertEquals(product, product1);
//        assertNull(productDao.get(1000));
    }

    @Test
    public void load() throws Exception {

    }

    @Test
    public void delete() throws Exception {
//        try {
//            productDao.delete(product1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        assertNull(productDao.get(99));
    }

}