package pl.zabd.zabd_projekt2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zabd.zabd_projekt2.model.Position;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HrLadyDto {
    private String name;
    private List<Position> positions;
}
