package pl.zabd.zabd_projekt2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zabd.zabd_projekt2.model.IExperience;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {
    private String name;
    private IExperience experience;
}
