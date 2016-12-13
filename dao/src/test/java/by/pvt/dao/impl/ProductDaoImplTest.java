package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.IProductDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dmitry on 11/23/2016.
 */
@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ProductDaoImplTest {

    @Autowired
    private IProductDao<Product> productDao;

    @Test
    public void saveOrUpdate() throws Exception {
        Product product1 = new Product();
        product1.setIdProduct(1);
        product1.setNameProduct("Tea");
        product1.setPrice(5.0);
        product1.setStatus(1);
        try {
            productDao.saveOrUpdate(product1);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(productDao.get(1));
        Product productFromDb = (Product) productDao.get(1);
        String nameProductFromDb = productFromDb.getNameProduct();
        assertEquals("Tea", nameProductFromDb);
    }

    @Test
    public void deletePerson() {

        Product product1 = new Product();
        product1.setIdProduct(2);
        product1.setNameProduct("Lemon");
        product1.setPrice(5.0);
        product1.setStatus(1);
        try {
            productDao.saveOrUpdate(product1);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Product persistent = null;
        try {
            persistent = (Product) productDao.get(2);
            productDao.delete(persistent);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        try {
            assertNull(productDao.get(2));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void getTotalProductCount(){
//        Product product1 = new Product();
//        product1.setIdProduct(1);
//        product1.setNameProduct("Tea");
//        product1.setPrice(5.0);
//        product1.setStatus(1);
//        Product product2 = new Product();
//        product2.setIdProduct(2);
//        product2.setNameProduct("Lemon");
//        product2.setPrice(5.0);
//        product2.setStatus(1);
//        Integer countProduct = 0;
//        try {
//            productDao.saveOrUpdate(product1);
//            productDao.saveOrUpdate(product2);
//            List<Product> productList = productDao.getAll();
//            countProduct = productDao.getTotalProductCount();
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        assertEquals(java.util.Optional.ofNullable(countProduct), 2);
//    }


}