package pl.zabd.zabd_projekt2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Candidate {
    @Id
    private String id;
    private String name;
    private String surname;
    private HashMap<Skill,IExperience> skills;

    public Candidate(String name, String surname, HashMap<Skill, IExperience> skills) {
        this.name = name;
        this.surname = surname;
        this.skills = skills;
    }
}
