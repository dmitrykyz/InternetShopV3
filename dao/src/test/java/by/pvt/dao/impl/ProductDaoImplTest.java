package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
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
    private ProductDaoImpl productDao;

//    @Test
//    public void addPerson() {
//        Person p = new Person();
//        p.setName("Yuli");
//        p.setSurname("Slabko");
//        p.setAge(30);
//        Person persistent = personDao.add(p);
//        assertNotNull(persistent.getId());
//        persistent = personDao.get(Person.class, persistent.getId());
//        assertEquals("Person not persist", p, persistent);
//    }
//

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
        Product productFromDb = productDao.get(1);
        String nameProductFromDb = productFromDb.getNameProduct();
        assertEquals("Tea", nameProductFromDb);
    }

    @Test
    public void deletePerson() {

//        Product product1 = new Product();
//        product1.setIdProduct(1);
//        product1.setNameProduct("Tea");
//        product1.setPrice(5.0);
//        product1.setStatus(1);
//        try {
//            productDao.saveOrUpdate(product1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//
//        List<Product> list = null;
//        try {
//            list = productDao.getAll();
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        int size = list.size();
//        int sizeAfterDelete = 0;
//        if (list.size() > 0) {
//            Product persistent = list.get(0);
//            try {
//                productDao.delete(persistent);
//                sizeAfterDelete = productDao.getAll().size();
//            } catch (DaoException e) {
//                e.printStackTrace();
//            }
//            System.out.println("-------------------" + sizeAfterDelete);
//            System.out.println("-------------------" + size);
//            assertNotSame(sizeAfterDelete, size);
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