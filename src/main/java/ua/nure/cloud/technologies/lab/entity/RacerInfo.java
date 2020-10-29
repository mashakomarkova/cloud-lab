package ua.nure.cloud.technologies.lab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RacerInfo {
    private String id;
    private Racer racer;
    private int racingPosition;
    private int delay;
}
