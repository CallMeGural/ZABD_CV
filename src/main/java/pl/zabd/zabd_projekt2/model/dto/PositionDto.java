package pl.zabd.zabd_projekt2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zabd.zabd_projekt2.model.Skill;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {
    private String name;
    private double salary;
    private List<Skill> skills;
}
