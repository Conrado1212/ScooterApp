package pl.edu.wszib.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.dao.impl.ScooterDAOImpl;

public class ScootersController {
    @Autowired
    ScooterDAOImpl scooterDAO ;


    @RequestMapping(value ="/allScooter",method = RequestMethod.GET)
    public String allScooter(Model model){

        model.addAttribute("allScooter",scooterDAO.getAllScooters());
        return "allScooter";
    }

    @RequestMapping(value = "/allScooterXiomi",method = RequestMethod.GET)
    public String scooterXiaomiPage(Model model){

        model.addAttribute("allScooterXiomi",scooterDAO.getAllScooterXiaomi());
        return"allScooterXiomi";
    }

    @RequestMapping(value = "/allScooterFiat",method = RequestMethod.GET)
    public String scooterFiatPage(Model model){

        model.addAttribute("allScooterFiat",scooterDAO.getAllScooterFiat());
        return "allScooterFiat";
    }

}
