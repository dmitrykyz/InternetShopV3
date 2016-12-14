package by.pvt.controller;

import by.pvt.entity.Client;
import by.pvt.services.IClientService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Dmitry on 12/11/2016.
 */
@Controller
public class RegistrationController {


    private static Logger log = Logger.getLogger(RegistrationController.class);

    @Autowired
    private IClientService clientService;

    @RequestMapping(value = {"/registrationform"}, method = RequestMethod.GET)
    public ModelAndView main() {
        return new ModelAndView("registrationform", "client", new Client());
    }


    @RequestMapping(value = "/registrationclient", method = RequestMethod.POST)
    public String checkUser(@Valid @ModelAttribute("client") Client client, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "registrationform";
        }
        try {
            clientService.saveOrUpdate(client);
            log.info("New Client succesfully registed " + client);
        } catch (ServiceException e) {
            log.info("ERROR registed Client " + client);
        }

        return "login";
    }

}
