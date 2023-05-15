package pl.zabd.zabd_projekt2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pl.zabd.zabd_projekt2.model.Company;

import java.util.List;

public interface CompanyRepository extends MongoRepository<Company,String> {
    @Query("db.company.find({ \"hrs.positions.name\": { \"$regex\": ?0, \"$options\": \"i\" } })")
    List<Company> findAllByHrs_PositionsNameRegexIgnoreCase(String name);
}
