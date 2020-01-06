package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IAuthenticationService;

@Controller
public class AuthorizationController {

    IAuthenticationService authenticationService;

    @RequestMapping(value = "loginPage",method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("userModel",new User());
        model.addAttribute("errorMessage","");
        return "loginForm";
    }

    @RequestMapping(value = "authenticate",method = RequestMethod.POST)
    public  String authenticateUser(@ModelAttribute("userModel")User user,Model model){
        boolean authResult = this.authenticationService.authenticateUser(user);
        if(authResult){
            return "redirect:scooterPage";
        }else{
            model.addAttribute("errorMessage","zle dane!!!");
            model.addAttribute("userModel",new User());
            return "loginForm";
        }


    }
}
