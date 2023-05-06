package pl.zabd.zabd_projekt2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.zabd.zabd_projekt2.model.Company;

public interface CompanyRepository extends MongoRepository<Company,String> {
}
