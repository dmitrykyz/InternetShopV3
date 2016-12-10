package by.pvt.services.impl;

import by.pvt.dao.IAdminDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.AdminDaoImpl;
import by.pvt.entity.Admin;
import by.pvt.services.BaseService;
import by.pvt.services.IAdminService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/20/2016.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AdminServiceImpl extends BaseService<Admin> implements IAdminService<Admin> {
    private static Logger log = Logger.getLogger(AdminServiceImpl.class);

    @Autowired
    IAdminDao adminDao;

    public AdminServiceImpl() {
    }

    @Override
    public Admin get(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public Admin load(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public List<Admin> getAll() throws ServiceException {
        return null;
    }

    public List<Admin> getAdminByLogin(String login) {


        log.info("Getting object User in class AdminServiceImpl in metod getAdminByLogin by login: " + login);
        try {
            List<Admin> users = adminDao.getAdminByLogin(login);
            return users;
        } catch (DaoException e) {
            e.printStackTrace();
            return null;
        }

    }
}
