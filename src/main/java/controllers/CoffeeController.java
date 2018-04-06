package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("coffee")
public class CoffeeController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(defaultValue = "0") int id) {

        model.addAttribute("title", "Coffees");
        model.addAttribute("Coffees",coffeDao.findAll());

        return "coffee/index";

        }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayCoffees(Model model) {
        model.addAttribute(new Locale.Category());
        model.addAttribute("title", "Add Coffees");
        return "coffee/add";

        }

    @RequestMapping(value = "add", method = RequestMethod.POST )
    public String add(@ModelAttribute @Valid Locale.Coffee coffee, Errors errors, Model model){

        if (errors.hasErrors()){
            model.addAttribute("title", "Add Name");
            return "coffee/add";
            }
        return "redirect:";


        }


    }
