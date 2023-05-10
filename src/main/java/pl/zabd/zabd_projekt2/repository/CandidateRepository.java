package pl.zabd.zabd_projekt2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.Skill;

import java.util.List;

public interface CandidateRepository extends MongoRepository<Candidate,String> {
//    List<Candidate> findAllBySkillsIn(List<Skill> skills);

}
