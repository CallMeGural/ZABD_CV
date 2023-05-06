package pl.zabd.zabd_projekt2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zabd.zabd_projekt2.model.HrLady;
import pl.zabd.zabd_projekt2.model.Position;
import pl.zabd.zabd_projekt2.model.dto.HrLadyDto;
import pl.zabd.zabd_projekt2.model.dto.PositionDto;
import pl.zabd.zabd_projekt2.service.PositionService;

@Controller
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public String fetchAllHrs(Model model) {
        model.addAttribute("hrs",positionService.getAllPositions());
        return "positionList";
    }

    @GetMapping("/form")
    public String addHrLadyForm(Model model) {
        model.addAttribute("position",new PositionDto());
        return "positionForm";
    }

    @PostMapping
    public Position addHrLady(PositionDto dto) {
        return positionService.addPosition(dto);
    }

}
