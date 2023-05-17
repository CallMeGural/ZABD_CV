package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.HrLady;
import pl.zabd.zabd_projekt2.model.Position;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.PositionDto;
import pl.zabd.zabd_projekt2.repository.PositionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;
    private final MongoTemplate mongoTemplate;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public void addPosition(PositionDto dto) {
        Position position = new Position();
        position.setName(dto.getName());
        position.setSalary(dto.getSalary());
        position.setSkills(dto.getSkills());
        //position.setContent(dto.getContent());
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
        update.setSkills(position.getSkills());
        update.setHrName(position.getHrName());
        update.setCompanyName(position.getCompanyName());
        update.setHrPhoneNumber(position.getHrPhoneNumber());
        positionRepository.save(update);
    }

    public void deletePosition(String id) {
        positionRepository.deleteById(id);
    }

    public List<Position> getPositionsByCriteria(List<Skill> skills) {
        Criteria[] criteria = new Criteria[skills.size()];
        for(int i=0;i<skills.size();i++) {
            criteria[i] = Criteria.where("skills.name").is(skills.get(i).getName())
                    .and("skills.experience").gte(skills.get(i).getExperience());
        }
        Criteria queryCriteria = new Criteria().andOperator(criteria);
        Query query = Query.query(queryCriteria);
        return mongoTemplate.find(query, Position.class);
    }
}
