package ua.nure.cloud.technologies.lab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.nure.cloud.technologies.lab.entity.Racer;

public interface RacerRepository extends MongoRepository<Racer, Integer> {
}
