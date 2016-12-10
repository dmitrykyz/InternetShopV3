package by.pvt.services.impl;

import by.pvt.dao.IClientDao;
import by.pvt.dao.IOrderDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.OrderDaoImpl;
import by.pvt.entity.Order;
import by.pvt.services.BaseService;
import by.pvt.services.IOrderService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 11/21/2016.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl extends BaseService<Order> implements IOrderService<Order> {

    private static Logger log = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    IOrderDao orderDao;

    public OrderServiceImpl() {
    }

    @Override
    public Order get(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public Order load(Serializable id) throws ServiceException {
        return null;
    }

    @Override
    public List<Order> getAll() throws ServiceException {
        return null;
    }

    public List<Order> getOrderInBasketByUserId(Integer id){


        log.info("Getting Order in class ClientServiceImpl in metod getOrderInBasketByUserId by id User : " + id);
        try {
            List<Order> orders = orderDao.getOrderByUserId(id);
            List<Order> listOrdersInBasket = new ArrayList<>();
            for (Order orderTemp: orders) {
                if (orderTemp.getIsRegistryOrder() == 0){
                    listOrdersInBasket.add(orderTemp);
                }
            }
            return listOrdersInBasket;
        } catch (DaoException e) {
            e.printStackTrace();
            return null;
        }
    }


}
