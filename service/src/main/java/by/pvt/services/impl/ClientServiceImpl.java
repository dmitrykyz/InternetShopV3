package by.pvt.services.impl;

import by.pvt.dao.IClientDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.entity.Client;
import by.pvt.services.BaseService;
import by.pvt.services.IClientService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Dmitry on 11/19/2016.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ClientServiceImpl extends BaseService<Client> implements IClientService<Client> {

    private static Logger log = Logger.getLogger(ClientServiceImpl.class);

    @Autowired
    IClientDao clientDao;

    public ClientServiceImpl() {
    }

    @Override
    public Client get(Serializable id) throws ServiceException {
        Client client = null;
        try {
            client = (Client) clientDao.get(id);
            log.info("Get Client in ClientServiceImpl succesfully");
        } catch (DaoException e) {
            log.info("Get Client in ClientServiceImpl ERROR");
        }
        return client;
    }

    @Override
    public Client load(Serializable id) throws ServiceException {

        Client client = null;
        try {
            client = (Client) clientDao.load(id);
            log.info("Load Client in ClientServiceImpl succesfully");
        } catch (DaoException e) {
            log.info("Load Client in ClientServiceImpl ERROR");
        }
        return client;
    }

    @Override
    public List<Client> getAll() throws ServiceException {
        return null;
    }


    public List<Client> getClientByLogin(String login) throws ServiceException {
        log.info("Getting object User in class ClientServiceImpl in metod getClientByLogin by login: " + login);
        try {
            List<Client> clients = clientDao.getClientByLogin(login);
            return clients;
        } catch (DaoException e) {
            e.printStackTrace();

            return null;
        }

    }

//    public IClientDao getClientDao() {
//        return clientDao;
//    }
//
//    public void setClientDao(IClientDao clientDao) {
//        this.clientDao = clientDao;
//    }
}
