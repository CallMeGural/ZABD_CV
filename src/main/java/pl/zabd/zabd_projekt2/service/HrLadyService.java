package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.HrLady;
import pl.zabd.zabd_projekt2.model.dto.HrLadyDto;
import pl.zabd.zabd_projekt2.repository.HrLadyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HrLadyService {

    private final HrLadyRepository hrRepository;

    public List<HrLady> getAllHrs() {
        return hrRepository.findAll();
    }

    public HrLady addHrLady(HrLadyDto dto) {
        HrLady hrLady = new HrLady();
        hrLady.setName(dto.getName());
        hrLady.setPositions(dto.getPositions());
        return hrRepository.insert(hrLady);
    }

    public HrLady getHrById(String id) {
        return hrRepository.findById(id).orElseThrow();
    }

    public void updateHr(HrLady hrLady) {
        HrLady update = getHrById(hrLady.getId());
        update.setPositions(hrLady.getPositions());
        update.setName(hrLady.getName());
        hrRepository.save(update);
    }

    public void deleteHr(String id) {
        hrRepository.deleteById(id);
    }
}
