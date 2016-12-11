package by.pvt.services;

import by.pvt.entity.Client;
import by.pvt.services.exception.ServiceException;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IClientService<Client> extends IService<Client> {

    List<Client> getClientByLogin(String login) throws ServiceException;
}
