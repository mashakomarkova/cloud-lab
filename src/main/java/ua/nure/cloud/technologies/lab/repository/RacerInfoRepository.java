package ua.nure.cloud.technologies.lab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.nure.cloud.technologies.lab.entity.RacerInfo;

public interface RacerInfoRepository  extends MongoRepository<RacerInfo, Integer> {
}
