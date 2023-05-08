package pl.zabd.zabd_projekt2.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.zabd.zabd_projekt2.model.IExperience;
import pl.zabd.zabd_projekt2.model.Skill;

import java.util.HashMap;

@Getter
@Setter
public class CandidateDto {
    private String name;
    private String surname;
    private HashMap<Skill, IExperience> skills;
}
