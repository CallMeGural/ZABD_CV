package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.Position;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.PositionDto;
import pl.zabd.zabd_projekt2.repository.CandidateRepository;
import pl.zabd.zabd_projekt2.repository.PositionRepository;
import pl.zabd.zabd_projekt2.repository.SkillRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class PositionService {

    private final PositionRepository positionRepository;
    private final CandidateRepository candidateRepository;
    private final MongoTemplate mongoTemplate;
    private final SkillRepository skillRepository;


    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public void addPosition(PositionDto dto) {
        Position position = new Position();
        position.setName(dto.getName());
        position.setSalary(dto.getSalary());
        dto.getSkills().forEach(skill -> {
            Skill skill1 = skillRepository.findById(skill).orElseThrow();
            position.getSkills().add(skill1);
        });
        position.setContent(dto.getContent());
        position.setCompanyName(dto.getCompanyName());
        position.setHrName(dto.getHrName());
        position.setHrPhoneNumber(dto.getHrPhoneNumber());
        positionRepository.insert(position);
    }

    public Position getPositionById(String id) {
        return positionRepository.findById(id).orElseThrow();
    }

    public void updatePosition(Position position) {
        Position update = getPositionById(position.getId());
        update.setSalary(position.getSalary());
        update.setName(position.getName());
        if(position.getSkills().size()>0)
            update.setSkills(position.getSkills());
        update.setHrName(position.getHrName());
        update.setCompanyName(position.getCompanyName());
        update.setHrPhoneNumber(position.getHrPhoneNumber());
        update.setContent(position.getContent());
        positionRepository.save(update);
    }

    public void deletePosition(String id) {
        positionRepository.deleteById(id);
    }

    public List<Position> getPositionsByCriteria(List<Skill> skills) {
        Criteria[] criteria = new Criteria[skills.size()];
        for(int i=0;i<skills.size();i++) {
            criteria[i] = Criteria.where("skills.name").is(skills.get(i).getName())
                    .and("skills.experience").is(skills.get(i).getExperience());
        }
        Criteria queryCriteria = new Criteria().orOperator(criteria);
        Query query = Query.query(queryCriteria);
        return mongoTemplate.find(query, Position.class);
    }



    public List<Candidate> findByCriteria(List<Skill> skills) {
        List<Candidate> allCandidates = candidateRepository.findAll();
        List<Candidate> matchedCandidates = new ArrayList<>();
        log.info(skills.toString()+"\n\n");
        allCandidates.forEach(
                candidate -> {
                    log.info(candidate.getName() +" "+candidate.getSkills().toString());
                    int matches = 0;
                    for(Skill skill : candidate.getSkills()) {
                        for(Skill positionSkill : skills) {
                            if(skill.getName().equals(positionSkill.getName()) && skill.getExperience()==positionSkill.getExperience()) matches++;
                        }
                    }
                    log.info(String.valueOf(matches));
                    if(matches>=2) matchedCandidates.add(candidate);
                }
        );

        return matchedCandidates;
    }
}
