package pl.zabd.zabd_projekt2.model.dto;

import lombok.Getter;
import lombok.Setter;
import pl.zabd.zabd_projekt2.model.Skill;

import java.util.ArrayList;

@Getter
@Setter
public class SkillForm {
    private ArrayList<Skill> skills;

    public SkillForm() {
        skills = new ArrayList<>();
    }
}
