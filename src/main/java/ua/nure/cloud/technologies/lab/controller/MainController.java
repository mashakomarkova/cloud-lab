package ua.nure.cloud.technologies.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.cloud.technologies.lab.entity.Endpoint;
import ua.nure.cloud.technologies.lab.entity.Racer;
import ua.nure.cloud.technologies.lab.entity.RacerInfo;
import ua.nure.cloud.technologies.lab.repository.EndpointRepository;
import ua.nure.cloud.technologies.lab.repository.RacerInfoRepository;
import ua.nure.cloud.technologies.lab.repository.RacerRepository;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private RacerRepository repository;
    @Autowired
    private EndpointRepository endpointRepository;
    @Autowired
    private RacerInfoRepository racerInfoRepository;

    @GetMapping("/")
    public ModelAndView welcome() {
        List<Racer> racerList = repository.findAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("racers", racerList);
        return model;
    }

    @GetMapping("/racer/info")
    public ModelAndView showRacerInfo() {
        List<RacerInfo> endpointList = racerInfoRepository.findAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("endpoints");
        model.addObject("racerInfo", endpointList);
        return model;
    }

    @GetMapping("/endpoint/info")
    public ModelAndView showEndpointInfo() {
        List<Endpoint> endpointList = endpointRepository.findAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("endpoint");
        model.addObject("endpointInfo", endpointList);
        return model;
    }

    @GetMapping("/racer/info2")
    public ModelAndView showAnotherRacerInfo() {
        List<RacerInfo> endpointList = racerInfoRepository.findAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("raceInfo");
        model.addObject("info", endpointList);
        return model;
    }

    @GetMapping("/endpoint/info2")
    public ModelAndView showAnotherEndpointInfo() {
        List<Endpoint> endpointList = endpointRepository.findAll();
        ModelAndView model = new ModelAndView();
        model.setViewName("end_point");
        model.addObject("info", endpointList);
        return model;
    }


}
