package ua.nure.cloud.technologies.lab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.nure.cloud.technologies.lab.entity.Endpoint;

public interface EnpointRepository extends MongoRepository<Endpoint, Integer> {
}
