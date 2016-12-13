package by.pvt.services.impl;

import by.pvt.dao.Dao;
import by.pvt.dao.IProductDao;
import by.pvt.dao.exception.DaoException;
import by.pvt.dao.impl.ProductDaoImpl;
import by.pvt.entity.Product;
import by.pvt.services.BaseService;
import by.pvt.services.IProductService;
import by.pvt.services.exception.ServiceException;
import by.pvt.vo.ProductVOforPagination;
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
public class ProductServiceImpl extends BaseService<Product> implements IProductService<Product> {

    private static Logger log = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    IProductDao productDao;

    public ProductServiceImpl() {
    }

    @Override
    public Product get(Serializable id) throws ServiceException {

        Product product = null;
        try {
            product = (Product) productDao.get(id);
            log.info("Get Product in ProductServiceImpl succesfully");

        } catch (DaoException e) {
            log.info("Get Product in ProductServiceImpl ERROR");
        }
        return product;
    }

    @Override
    public Product load(Serializable id) throws ServiceException {
        Product product = null;
        try {
            product = (Product) productDao.load(id);
            log.info("Load Product in ProductServiceImpl succesfully");
        } catch (DaoException e) {
            log.info("Load Product in ProductServiceImpl ERROR");
        }
        return product;
    }

    @Override
    public List<Product> getAll() throws ServiceException {
        List<Product> tList = null;
        try {
            tList = productDao.getAll();
            log.info("GetAll Product in ProductServiceImpl succesfully");
        } catch (DaoException e) {
            log.info("GetAll Product in ProductServiceImpl ERROR");
        }
        return tList;
    }

    public List<Product> getAllFilterById() throws ServiceException {
        List<Product> tList = null;
        try {
            tList = productDao.getAllFilterById();
            log.info("GetAllFilterByName Product in ProductServiceImpl succesfully");
        } catch (DaoException e) {
            log.info("GetAllFilterByName Product in ProductServiceImpl ERROR");
        }
        return tList;
    }

    public List<Product> getAllFilterByName() throws ServiceException {
        List<Product> tList = null;
        try {
            tList = productDao.getAllFilterByName();
            log.info("GetAllFilterByName Product in ProductServiceImpl succesfully");
        } catch (DaoException e) {
            log.info("GetAllFilterByName Product in ProductServiceImpl ERROR");
        }
        return tList;
    }

    public List<Product> getAllFilterByPrice() throws ServiceException {
        List<Product> tList = null;
        try {
            tList = productDao.getAllFilterByPrice();
            log.info("GetAllFilterByName Product in ProductServiceImpl succesfully");
        } catch (DaoException e) {
            log.info("GetAllFilterByName Product in ProductServiceImpl ERROR");
        }
        return tList;
    }

    public ProductVOforPagination paginationProducts(String page, Integer countPerPage) throws ServiceException {

        ProductVOforPagination productVOforPagination = new ProductVOforPagination();

        Integer newPage = page != null ? Integer.valueOf(page) : 1;
        List<Product> productList = null;
        Integer totalUsersCount =0;


        try {
            totalUsersCount = productDao.getTotalProductCount();
            Integer first = countPerPage*(newPage-1);
            productList = productDao.getPartProductPagination(countPerPage,first);
            log.info("PaginationProducts metod in ProductServiceImpl worked succesfully");
        } catch (DaoException e) {
            log.info("PaginationProducts metod in ProductServiceImpl ERROR");
        }

        productVOforPagination.setPage(String.valueOf(newPage));
        productVOforPagination.setTotalProductCount(totalUsersCount);
        productVOforPagination.setProductList(productList);

        return productVOforPagination;
    }

}
