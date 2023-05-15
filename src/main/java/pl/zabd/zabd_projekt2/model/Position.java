package pl.zabd.zabd_projekt2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Document
public class Position {
//    @Id
//    private String id;
    private String name;
    private double salary;
//    private HashMap<Skill,IExperience> skills;
    private List<Skill> skills;

    @Override
    public String toString() {
        return name + " "
                + salary+"/msc"
                + skills.stream()
                .map(skill -> skill.toString()+"\n");
    }
}
