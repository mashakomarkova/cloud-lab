package ua.nure.cloud.technologies.lab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Racer {
    private int id;
    private String name;
    private String country;
}