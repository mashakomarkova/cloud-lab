package ua.nure.cloud.technologies.lab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Endpoint {
    private int id;
    private int speed;
    private double timeFromStart;
    private List<RacerInfo> racerInfos;
    private Endpoint nextEndpoint;
}
