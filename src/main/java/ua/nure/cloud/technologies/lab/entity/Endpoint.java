package ua.nure.cloud.technologies.lab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Endpoint {

    private Integer id;
    private int speed;
    private LocalDateTime timeFromStart;
    private List<RacerInfo> racerInfos;
    private Endpoint nextEndpoint;
    private double timeToRest;
    private double waterSupply;
}