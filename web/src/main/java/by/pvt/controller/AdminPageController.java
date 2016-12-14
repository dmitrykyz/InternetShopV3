package by.pvt.controller;

import by.pvt.entity.Product;
import by.pvt.services.IProductService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by Dmitry on 12/14/2016.
 */
@Controller
public class AdminPageController {

    private static Logger log = Logger.getLogger(AdminPageController.class);

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/addNewProduct", method = RequestMethod.GET)
    public String loginPage() {
        return "addNewProduct";
    }

    @RequestMapping(value = "/addNewProductApprove", method = RequestMethod.POST)
    public ModelAndView addNewProductApprove(@ModelAttribute("product") Product product, Model model){

        String messageAboutAddProductSuccesfully = "Error add product";
        try {
            productService.saveOrUpdate(product);
            messageAboutAddProductSuccesfully = "New Product succesfully add";
            log.info("New Product succesfully add " + (product));
        } catch (ServiceException e) {
            log.info("ERROR add product " + (product));
        }
        return new ModelAndView("admin", "messageAboutAddProductSuccesfully", messageAboutAddProductSuccesfully);
    }


    @RequestMapping(value = {"/getAllProductAdmin"})
    public ModelAndView getAllProductAdmin() {
        ArrayList<Product> productList = null;

        try {
            productList = (ArrayList<Product>) productService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ModelAndView("admin", "productList", productList);
    }
}
