package by.pvt.services.impl;

import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.entity.Client;
import by.pvt.services.IClientService;
import by.pvt.services.exception.ServiceException;
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
@ContextConfiguration("/testContextService.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class ClientServiceImplTest {

    @Autowired
    private IClientService clientService;

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
        clientService.saveOrUpdate(client1);
        assertNotNull(clientService.get(1));
        Client clientFromDb = (Client) clientService.get(1);
        String clientFromDbLogin = clientFromDb.getLogin();
        assertEquals("client1", clientFromDbLogin);
    }

    @Test
    public void deletePerson() {

        try {
            clientService.saveOrUpdate(client1);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        Client persistent = null;
        try {
            persistent = (Client) clientService.get(1);
            clientService.delete(persistent);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        try {
            assertNull(clientService.get(1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void get() {
        try {
            clientService.saveOrUpdate(client1);
            assertNotNull(clientService.get(1));
            Client clientFromDb = (Client) clientService.get(1);
            String clientFromDbFirstName = clientFromDb.getFirstName();
            assertEquals("Mikl", clientFromDbFirstName);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}