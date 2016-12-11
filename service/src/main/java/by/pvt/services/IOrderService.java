package by.pvt.services;

import by.pvt.services.exception.ServiceException;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IOrderService<Order> extends IService<Order>{

    List<Order> getOrderInBasketByUserId(Integer id) throws ServiceException;
}
