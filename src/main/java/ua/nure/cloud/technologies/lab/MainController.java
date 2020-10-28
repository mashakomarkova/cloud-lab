package ua.nure.cloud.technologies.lab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("message", "dddd");
        return model;
    }
}
