package by.pvt.dao.impl;

import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Admin;
import by.pvt.entity.Client;
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
 * Created by Dmitry on 11/22/2016.
 */
@ContextConfiguration("/testContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ClientDaoImplTest {

    @Autowired
    private ClientDaoImpl clientDao;

    private Client client1;

    @Before
    public void setUp() throws Exception {
        client1 = new Client();
        client1.setIdUser(1);
        client1.setLogin("client1");
        client1.setPassword("1234");
        client1.setFirstName("Mikl");
        client1.setLastName("Smit");
        client1.setUserType(0);
        client1.setInBlackList(0);
        client1.setSummOnCreditCard(3.0);
        client1.setOrderListInbBasket(null);

    }

    @Test
    public void saveOrUpdate() throws Exception {
        try {
            clientDao.saveOrUpdate(client1);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(clientDao.get(1));
        Client clientFromDb = (Client) clientDao.get(1);
        String clientFromDbLogin = clientFromDb.getLogin();
        assertEquals("client1", clientFromDbLogin);
    }

    @Test
    public void deletePerson() {

        try {
            clientDao.saveOrUpdate(client1);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Client persistent = null;
        try {
            persistent = (Client) clientDao.get(1);
            clientDao.delete(persistent);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {
            assertNull(clientDao.get(1));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get() {
        try {
            clientDao.saveOrUpdate(client1);
            assertNotNull(clientDao.get(1));
            Client clientFromDb = (Client) clientDao.get(1);
            String clientFromDbFirstName = clientFromDb.getFirstName();
            assertEquals("Mikl", clientFromDbFirstName);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void getClientByLogin() throws Exception {
//        clientDao.saveOrUpdate(client1);
//        Client clientFromDb = (Client) clientDao.getClientByLogin("client1");
//        String clientFromDbLogin = clientFromDb.getLogin();
//        assertEquals("client1", clientFromDbLogin);
//    }

}