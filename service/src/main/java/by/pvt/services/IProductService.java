package by.pvt.services;

import by.pvt.entity.Product;
import by.pvt.services.exception.ServiceException;
import by.pvt.vo.ProductVOforPagination;

import java.util.List;

/**
 * Created by Dmitry on 12/10/2016.
 */
public interface IProductService<Product>  extends IService<Product> {

    List<Product> getAll() throws ServiceException;

    List<Product> getAllFilterById() throws ServiceException;

    List<Product> getAllFilterByName() throws ServiceException;

    List<Product> getAllFilterByPrice() throws ServiceException;

    ProductVOforPagination paginationProducts(String page, Integer countPerPage) throws ServiceException;
}
