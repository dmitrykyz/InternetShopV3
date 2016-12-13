package by.pvt.dao.impl;

import by.pvt.dao.BaseDao;
import by.pvt.dao.IAdminDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Admin;
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
public class AdminDaoImplTest {

    @Autowired
    private IAdminDao adminDao;

    private Admin admin;

    @Before
    public void setUp() throws Exception {
        admin = new Admin();
        admin.setIdUser(1);
        admin.setLogin("admin");
        admin.setPassword("1234");
        admin.setFirstName("Mikl");
        admin.setLastName("Smit");
        admin.setUserType(1);
        admin.setBankAccount(2.0);

    }

    @Test
    public void saveOrUpdate() throws Exception {
        try {
            adminDao.saveOrUpdate(admin);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        assertNotNull(adminDao.get(1));
        Admin adminFromDb = (Admin) adminDao.get(1);
        String adminFromDbLogin = adminFromDb.getLogin();
        assertEquals("admin", adminFromDbLogin);
    }

    @Test
    public void deletePerson() {

        try {
            adminDao.saveOrUpdate(admin);
        } catch (DaoException e) {
            e.printStackTrace();
        }

        Admin persistent = null;
        try {
            persistent = (Admin) adminDao.get(1);
            adminDao.delete(persistent);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        try {
            assertNull(adminDao.get(1));
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


//    @Test
//    public void getAdminByLogin() throws Exception {
//        adminDao.saveOrUpdate(admin);
//        Admin adminFromDb = (Admin) adminDao.getAdminByLogin("admin");
//        String adminFromDbLogin = adminFromDb.getLogin();
//        assertEquals("admin", adminFromDbLogin);
//    }

}