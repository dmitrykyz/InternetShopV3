package by.pvt.services;

import by.pvt.entity.Admin;
import by.pvt.services.exception.ServiceException;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IAdminService<Admin> extends IService<Admin> {

    List<Admin> getAdminByLogin(String login) throws ServiceException;

}
