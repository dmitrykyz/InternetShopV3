package by.pvt.controller;

import by.pvt.entity.Client;
import by.pvt.entity.User;
import by.pvt.services.IClientService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Dmitry on 12/8/2016.
 */
@Controller
public class LoginController {

    private static Logger log = Logger.getLogger(LoginController.class);

    @Autowired
    private IClientService clientService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        return new ModelAndView("login2", "user", new User());
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "login2";
        }
        model.addAttribute("user", user);
        return "main";

    }

    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
    public String getUserById(){

        Integer idUser = 1;
        try {
            Client client = (Client)clientService.get(idUser);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + client);
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        return "main";
        }
}
