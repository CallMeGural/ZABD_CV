package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.SkillDto;
import pl.zabd.zabd_projekt2.repository.SkillRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill addSkill(SkillDto dto) {
        Skill skill = new Skill();
        skill.setName(dto.getName());
        return skillRepository.insert(skill);
    }

    public Skill updateSkill(Skill skill) {
        Skill update = skillRepository.findById(skill.getId()).orElseThrow();
        //TODO: check how to update
        return null;
    }
}
