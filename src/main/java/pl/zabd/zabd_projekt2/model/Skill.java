package pl.zabd.zabd_projekt2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Skill {
    @Id
    private String id;
    private String name;
    private IExperience experience;

    public Skill(String name, IExperience exp) {
        this.name=name;
        this.experience=exp;
    }

    @Override
    public String toString() {
        return  name + " : " +experience.toString();
    }
}
