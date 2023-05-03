package pl.zabd.zabd_projekt2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.zabd.zabd_projekt2.model.Candidate;

@NoRepositoryBean
public interface CandidateRepository extends MongoRepository<Candidate,String> {
}
