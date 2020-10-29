package ua.nure.cloud.technologies.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.cloud.technologies.lab.entity.Endpoint;
import ua.nure.cloud.technologies.lab.entity.Racer;
import ua.nure.cloud.technologies.lab.entity.RacerInfo;
import ua.nure.cloud.technologies.lab.repository.EndpointRepository;
import ua.nure.cloud.technologies.lab.repository.RacerInfoRepository;
import ua.nure.cloud.technologies.lab.repository.RacerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class AddTestDateController {
    private RacerInfoRepository racerInfoRepository;
    private RacerRepository repository;
    private EndpointRepository endpointRepository;

    @Autowired
    public AddTestDateController(RacerInfoRepository racerInfoRepository, RacerRepository repository, EndpointRepository endpointRepository) {
        this.racerInfoRepository = racerInfoRepository;
        this.repository = repository;
        this.endpointRepository = endpointRepository;
    }

    @GetMapping("/test")
    public ModelAndView welcome() {
        ModelAndView model = new ModelAndView();

        Racer racer;
        for (int i = 0; i < 100; i++) {
            racer = new Racer();
            racer.setId(i);
            racer.setName("Racer_" + i);
            repository.save(racer);
        }

        Endpoint endpoint;
        for (int i = 3; i > 0; i--) {
            Random random = new Random();
            endpoint = new Endpoint();
            endpoint.setTimeFromStart(random.nextInt(7));
            endpoint.setId(i);
            if (i == 3) {
                endpoint.setNextEndpoint(null);
            } else {
                endpoint.setNextEndpoint(endpointRepository.findById(i + 1));
            }
            endpoint.setSpeed(random.nextInt(22));
            List<RacerInfo> racerInfoList = new ArrayList<>();
            RacerInfo racerInfo;

            for (int j = 0; j < 100; j++) {
                racerInfo = new RacerInfo();
                racerInfo.setId(UUID.randomUUID().toString());
                Racer tempRacer = repository.findById(j);
                racerInfo.setRacer(tempRacer);
                racerInfo.setRacingPosition(random.nextInt(1000));
                racerInfo.setDelay(racerInfo.getRacingPosition() - 1);
                racerInfoRepository.save(racerInfo);
                racerInfoList.add(racerInfo);
            }
            endpoint.setRacerInfos(racerInfoList);
            endpointRepository.save(endpoint);
        }

        model.setViewName("index");
        model.addObject("message", "added");
        return model;
    }
}
