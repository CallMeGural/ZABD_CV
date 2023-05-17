package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.CandidateDto;
import pl.zabd.zabd_projekt2.repository.CandidateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final MongoTemplate mongoTemplate;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate addCandidate(CandidateDto dto) {
        Candidate candidate = new Candidate();
        candidate.setName(dto.getName());
        candidate.setSurname(dto.getSurname());
        candidate.setSkills(dto.getSkills());
        candidate.setPhoneNumber(dto.getPhoneNumber());
        candidate.setIsStudent(dto.getIsStudent());
        return  candidateRepository.insert(candidate);
    }

    public void deleteCandidate(String id) {
        candidateRepository.deleteById(id);
    }

    public Candidate getCandidateById(String id) {
        return candidateRepository.findById(id).orElseThrow();
    }

    public void updateCandidate(Candidate candidate) {
        Candidate update = getCandidateById(candidate.getId());
        update.setSkills(candidate.getSkills());
        update.setName(candidate.getName());
        update.setSurname(candidate.getSurname());
        update.setPhoneNumber(candidate.getPhoneNumber());
        update.setIsStudent(candidate.getIsStudent());
        candidateRepository.save(update);

    }

    public List<Candidate> getCandidatesByCriteria(List<Skill> skills) {
        Criteria[] criteria = new Criteria[skills.size()];
        for(int i=0;i<skills.size();i++) {
            criteria[i] = Criteria.where("skills.name").is(skills.get(i).getName())
                              .and("skills.experience").gte(skills.get(i).getExperience());
        }
        Criteria queryCriteria = new Criteria().andOperator(criteria);
        Query query = Query.query(queryCriteria);
        return mongoTemplate.find(query, Candidate.class);
    }
}
