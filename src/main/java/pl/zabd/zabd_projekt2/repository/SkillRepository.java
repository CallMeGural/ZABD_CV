package pl.zabd.zabd_projekt2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.zabd.zabd_projekt2.model.Skill;

public interface SkillRepository extends MongoRepository<Skill,String> {
}
