package ua.nure.cloud.technologies.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.cloud.technologies.lab.entity.Endpoint;
import ua.nure.cloud.technologies.lab.entity.RacerInfo;
import ua.nure.cloud.technologies.lab.repository.EndpointRepository;
import ua.nure.cloud.technologies.lab.repository.RacerInfoRepository;
import ua.nure.cloud.technologies.lab.repository.RacerRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ReduceController {
    @Autowired
    private RacerRepository repository;
    @Autowired
    private EndpointRepository endpointRepository;
    @Autowired
    private RacerInfoRepository racerInfoRepository;

    @GetMapping("/reduce/info/seasons")
    public ModelAndView getTopEightForThreeSeasonsSortedSeasons() {
        ModelAndView modelAndView = new ModelAndView();
        List<RacerInfo> racers = racerInfoRepository.findAll().stream()
                .filter(racerInfo -> racerInfo.getRacingPosition() < 9 && (racerInfo.getSeason().equals("Season_1") ||
                racerInfo.getSeason().equals("Season_2") || racerInfo.getSeason().equals("Season_3")))
                .sorted(Comparator.comparing(RacerInfo::getSeason))
                .collect(Collectors.toList());
        modelAndView.setViewName("reduceSeasons");
        modelAndView.addObject("info", racers);
        return modelAndView;
    }

    @GetMapping("/reduce/info/places")
    public ModelAndView getTopEightForThreeSeasonsSortedPlaces() {
        ModelAndView modelAndView = new ModelAndView();
        List<RacerInfo> racers = racerInfoRepository.findAll().stream()
                .filter(racerInfo -> racerInfo.getRacingPosition() < 9 && (racerInfo.getSeason().equals("Season_1") ||
                        racerInfo.getSeason().equals("Season_2") || racerInfo.getSeason().equals("Season_3")))
                .sorted(Comparator.comparing(RacerInfo::getRacingPosition))
                .collect(Collectors.toList());
        modelAndView.setViewName("reducePlaces");
        modelAndView.addObject("info", racers);
        return modelAndView;
    }

    @GetMapping("/reduce/info/endpoints")
    public ModelAndView getRacersLimitedTime() {
        ModelAndView modelAndView = new ModelAndView();
        List<Endpoint> endpoints = endpointRepository.findAll().stream()
                .map(endpoint -> {
                            endpoint.getRacerInfos().removeIf(racerInfo -> racerInfo.getDelay() > 10);
                    return endpoint;
                }).collect(Collectors.toList());
        modelAndView.setViewName("reduceEndpoints");
        modelAndView.addObject("info", endpoints);
        return modelAndView;
    }

}
