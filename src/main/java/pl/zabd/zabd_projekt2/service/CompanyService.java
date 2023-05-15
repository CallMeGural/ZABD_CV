package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.Company;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.CompanyDto;
import pl.zabd.zabd_projekt2.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final MongoTemplate mongoTemplate;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void addCompany(CompanyDto dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setHrs(dto.getHrs());
        companyRepository.insert(company);
    }

    public void deleteCompany(String id) {
        companyRepository.deleteById(id);
    }

    public Company getCompanyById(String id) {
        return companyRepository.findById(id).orElseThrow();
    }

    public void updateCompany(Company company) {
        Company update = getCompanyById(company.getId());
        update.setName(company.getName());
        update.setHrs(company.getHrs());
        companyRepository.save(update);
    }

    public List<Company> getCompaniesByCriteria(List<Skill> skills) {
        List<Criteria> criteriaList = new ArrayList<>();
        for (Skill skill : skills) {
            Criteria skillCriteria = Criteria.where("hrladyskills.positions.name").is(skill.getName())
                    .and("hrladyskills.positions.experience").gte(skill.getExperience());
            criteriaList.add(skillCriteria);
        }
        Criteria queryCriteria = new Criteria().andOperator(criteriaList.toArray(new Criteria[criteriaList.size()]));
        Query query = Query.query(queryCriteria);
        return mongoTemplate.find(query, Company.class);
    }

    public List<Company> getCompaniesByPositionName(String positionName) {
        return companyRepository.findAllByHrs_PositionsNameRegexIgnoreCase(positionName);
    }
}
