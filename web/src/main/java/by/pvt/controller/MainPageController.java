package by.pvt.controller;

import by.pvt.entity.Client;
import by.pvt.entity.Order;
import by.pvt.entity.Product;
import by.pvt.services.IClientService;
import by.pvt.services.IOrderService;
import by.pvt.services.IProductService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

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
        String username = principal.getName();
        try {
            ArrayList clientList = (ArrayList<Client>) clientService.getClientByLogin(username);
            if (!clientList.isEmpty()){
                Client client = (Client) clientList.get(0);
                Integer userId = client.getIdUser();
                listorderinbasket = (ArrayList<Order>) orderService.getOrderInBasketByUserId(userId);
                log.info("Show all Order in Basket");
            } else log.info("Client do not found");;

        } catch (ServiceException e) {
            log.info("ERROR show all Order in Basket");
            e.printStackTrace();
        }
        return new ModelAndView("main", "listorderinbasket", listorderinbasket);
    }


    @RequestMapping(value = "/addproducttoorder", method = RequestMethod.POST)
    public String addproducttoorder(@RequestParam(value = "productId", required = true) Integer productId, Model model){
        //Integer idProduct = product.getIdProduct();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&" + productId);

        return "main";

    }

}
