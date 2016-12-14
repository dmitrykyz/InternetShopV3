package by.pvt.controller;

import by.pvt.entity.Client;
import by.pvt.entity.Order;
import by.pvt.entity.Product;
import by.pvt.services.IClientService;
import by.pvt.services.IOrderService;
import by.pvt.services.IProductService;
import by.pvt.services.exception.ServiceException;
import by.pvt.vo.ProductVOforPagination;
import com.sun.naming.internal.ResourceManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Dmitry on 12/11/2016.
 */
@Controller
public class MainPageController {

    private static Logger log = Logger.getLogger(LoginController.class);

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IClientService clientService;

    @RequestMapping(value = {"/getAllProduct"})
    public ModelAndView getAllProduct() {
        ArrayList<Product> productList = null;

        try {
            productList = (ArrayList<Product>) productService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("main", "productList", productList);
    }

    
    @RequestMapping(value = "/backToMainByer", method = RequestMethod.GET)
    public String backToMainByer() {
        return "main";
    }
    
    
    @RequestMapping(value = {"/getAllProductPagination"}, method = RequestMethod.GET)
    public ModelAndView getAllProductPagination() {
        return paginationUtil("1", "10");
    }

    @RequestMapping(value = {"/getAllProductPagination/{page}/{countPerPage}"}, method = RequestMethod.GET)
    public ModelAndView getAllUsersPagination(@PathVariable String page, @PathVariable String countPerPage) {
        return paginationUtil(page, countPerPage);
    }

    @RequestMapping(value = {"/filtrProductbyId"})
    public ModelAndView filtrProductbyId() {
        ArrayList<Product> productList = null;

        try {
            productList = (ArrayList<Product>) productService.getAllFilterById();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("main", "productList", productList);
    }

    @RequestMapping(value = {"/filtrProductbyName"})
    public ModelAndView filtrProductbyName() {
        ArrayList<Product> productList = null;

        try {
            productList = (ArrayList<Product>) productService.getAllFilterByName();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("main", "productList", productList);
    }

    @RequestMapping(value = {"/filtrProductbyPrice"})
    public ModelAndView filtrProductbyPrice() {
        ArrayList<Product> productList = null;

        try {
            productList = (ArrayList<Product>) productService.getAllFilterByPrice();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("main", "productList", productList);
    }


    @RequestMapping(value = {"/showbasket"})
    public ModelAndView showbasket(Authentication principal) {
        ArrayList<Order> listorderinbasket = null;
        //Get all Order from DB by User Id using serviceService
        try {
            Integer userId = getIdUserFromPrincipal(principal);
            if (userId != null){
                listorderinbasket = (ArrayList<Order>) orderService.getOrderInBasketByUserId(userId);
                log.info("Show all Order in Basket");
            } else log.info("Client do not found");;

        } catch (ServiceException e) {
            log.info("ERROR show all Order in Basket");
            e.printStackTrace();
        }
        return new ModelAndView("main", "listorderinbasket", listorderinbasket);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(value = "/addproducttoorder", method = RequestMethod.POST)
    public ModelAndView addproducttoorder(@RequestParam(value = "productId", required = true) Integer productId, Authentication principal, Model model){
        Integer clientId = getIdUserFromPrincipal(principal);
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%" + clientId);
        Integer idProduct = productId;
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&" + productId);
        Product product = null;
        Client client = null;
        try {
            product = (Product) productService.get(idProduct);
            client = (Client) clientService.get(clientId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        if (client.getOrderListInbBasket() == null){
            client.setOrderListInbBasket(new ArrayList<Order>());
        }

        List<Order> orderList = client.getOrderListInbBasket();
        Order order = null;
        for (Order orderTemp: orderList) {
            if (orderTemp.getIsRegistryOrder() == 0 && orderTemp.getIsPaidOrder() == 0){
                order = orderTemp;
            }
        }

        if (order == null) {
            order = new Order();
        }

        order.setIsPaidOrder(0);
        order.setIsRegistryOrder(0);
        order.setTotalPrice(order.getTotalPrice() + product.getPrice());
        if (order.getProductList() == null){
            order.setProductList(new ArrayList<Product>());
        }
        order.getProductList().add(product);

        if (order.getClient() == null){
            order.setClient(client);
        }
        log.info("Add Product in Order in class MainPageController");

        String messageAboutAddProduct = "ERROR add product into your order";
        try {
            if (orderService.saveOrUpdate(order) == true) {
              messageAboutAddProduct = "Product add into order succesfully";
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            log.info(messageAboutAddProduct);
        }
        return new ModelAndView("main", "messageAboutAddProduct", messageAboutAddProduct);
    }

    protected Integer getIdUserFromPrincipal(Authentication principal){
        String username = principal.getName();
        try {
            ArrayList clientList = (ArrayList<Client>) clientService.getClientByLogin(username);
            if (!clientList.isEmpty()){
                Client client = (Client) clientList.get(0);
                Integer userId = client.getIdUser();
                return userId;
            } else log.info("Client do not found");;

        } catch (ServiceException e) {
            log.info("ERROR show all Order in Basket");
            e.printStackTrace();
        }
        return null;
    }

    private ModelAndView paginationUtil(String page, String countPerPage) {
        ProductVOforPagination productVOforPagination = null;
        if (countPerPage == null)
            countPerPage = "10";
        if (page == null)
            page = "1";

        try {
            productVOforPagination = productService.paginationProducts(page, Integer.valueOf(countPerPage));
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("totalproductcount", productVOforPagination.getTotalProductCount());
        modelAndView.addObject("countofpages", (int) Math.ceil(productVOforPagination.getTotalProductCount()) * 1.0 / Integer.valueOf(countPerPage));
        modelAndView.addObject("page", productVOforPagination.getPage());
        modelAndView.addObject("listproductpagination", productVOforPagination.getProductList());
        modelAndView.addObject("countPerPage",countPerPage);

        modelAndView.setViewName("showProductPagination");
        return modelAndView;
    }

}
