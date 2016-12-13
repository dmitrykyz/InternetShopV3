package by.pvt.controller;

import by.pvt.entity.Client;
import by.pvt.entity.User;
import by.pvt.services.IClientService;
import by.pvt.services.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hello and welcome");
        return "login";
    }
//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String adminPage(ModelMap model, Authentication principal) {
//        System.out.println(principal.getPrincipal());
//        model.addAttribute("user", getPrincipal());
//        return "admin";
//    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(ModelMap model, Authentication principal){
        System.out.println("**************************" + principal.getPrincipal());
        String usernameTemp = principal.getName();
        System.out.println("##########################" + usernameTemp);
        model.addAttribute("user", getPrincipal());
        return "main";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String mainAdmin(ModelMap model, Authentication principal){
        String usernameTemp = principal.getName();
        model.addAttribute("user", getPrincipal());
        return "admin";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "access_denied";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    private String getPrincipal(){
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView main(){
//        return new ModelAndView("login", "user", new User());
//    }
//
//    @RequestMapping(value = "/main", method = RequestMethod.GET)
//    public String main2(){
//        return "main";
//    }
//
//    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
//    public String checkUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
//        if (bindingResult.hasErrors()){
//            return "login";
//        }
//        model.addAttribute("user", user);
//        return "main";
//
//    }
//
//    @RequestMapping(value = "/getUserById", method = RequestMethod.POST)
//    public String getUserById(){
//
//        Integer idUser = 1;
//        try {
//            Client client = (Client)clientService.get(idUser);
//            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + client);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//
//
//        return "main";
//        }
}
