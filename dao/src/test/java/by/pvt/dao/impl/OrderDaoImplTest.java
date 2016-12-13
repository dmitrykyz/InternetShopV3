package by.pvt.dao.impl;

import by.pvt.dao.IOrderDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by Dmitry on 12/13/2016.
 */
@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class OrderDaoImplTest {

    @Autowired
    private IOrderDao orderDao;

    private Order order;

    @Before
    public void setUp() throws Exception {
        order = new Order();
        order.setIdOrder(1);
        order.setTotalPrice(200.0);
        order.setIsRegistryOrder(1);

    }

    @Test
    public void saveOrUpdate() throws Exception {
        try {
            orderDao.saveOrUpdate(order);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(orderDao.get(1));
        Order orderFromDb = (Order) orderDao.get(1);
        Double priceOrderFromDb = orderFromDb.getTotalPrice();
    }


}