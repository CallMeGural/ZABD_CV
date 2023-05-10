package pl.zabd.zabd_projekt2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Document
public class HrLady {
//    @Id
//    private String id;
    private String name;
    private List<Position> positions;

    @Override
    public String toString() {
        return name
                + positions.stream()
                .map(position -> position.toString()+"\n");
    }
}
