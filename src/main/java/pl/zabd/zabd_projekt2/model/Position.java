package pl.zabd.zabd_projekt2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@Document
public class Position {
    @Id
    private String id;
    private String name;
    private String hrName;
    private String hrPhoneNumber;
    private String companyName;
    private double salary;
    private String content;
    private List<Skill> skills;

    public Position() {
        this.skills=new ArrayList<>();
    }
}
