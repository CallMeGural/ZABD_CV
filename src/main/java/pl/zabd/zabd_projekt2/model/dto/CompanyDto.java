package pl.zabd.zabd_projekt2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.zabd.zabd_projekt2.model.HrLady;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
    private String name;
    private List<HrLady> hrs;
}
