package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dmitry on 11/23/2016.
 */
public class ProductDaoImplTest {

    ProductDaoImpl productDao;
    Product product1;
    Product product2;
    Product product3;
    List<Product> productListbefore = null;
    Integer countBefore;

    @Before
    public void setUp() throws Exception {
//        productDao = new ProductDaoImpl();
//        productListbefore = productDao.getAll();
//        countBefore = productListbefore.size();
//
//        product1 = new Product();
//        product1.setIdProduct(995);
//        product1.setNameProduct("Tea");
//        product1.setPrice(5.0);
//        product1.setStatus(1);
//
//        product2 = new Product();
//        product2.setIdProduct(100);
//        product2.setNameProduct("Milk");
//        product2.setPrice(6.0);
//        product2.setStatus(1);
//
//        product3 = new Product();
//        product3.setIdProduct(101);
//        product3.setNameProduct("Chips");
//        product3.setPrice(6.0);
//        product3.setStatus(1);
//        try {
//            productDao.saveOrUpdate(product1);
//            productDao.saveOrUpdate(product2);
//            productDao.saveOrUpdate(product3);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void getAll() throws Exception {
//        List<Product> productListafter = null;
//        productListafter = productDao.getAll();
//        System.out.println("---------" + productListbefore.size());
//        System.out.println("+++++++++" + productListafter.size());
//        assertEquals(productListbefore.size(), productListafter.size());


    }

    @Test
    public void getTotalProductCount() throws Exception {


    }

    @Test
    public void getPartProductPagination() throws Exception {

    }

}