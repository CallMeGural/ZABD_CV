package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.HrLady;
import pl.zabd.zabd_projekt2.model.Position;
import pl.zabd.zabd_projekt2.model.dto.PositionDto;
import pl.zabd.zabd_projekt2.repository.PositionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public void addPosition(PositionDto dto) {
        Position position = new Position();
        position.setName(dto.getName());
        position.setSalary(dto.getSalary());
        position.setSkills(dto.getSkills());
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
    }

    public void deletePosition(String id) {
        positionRepository.deleteById(id);
    }
}
