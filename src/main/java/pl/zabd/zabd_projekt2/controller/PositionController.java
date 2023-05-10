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
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @GetMapping("/list")
    public String fetchAllHrs(Model model) {
        model.addAttribute("positions",positionService.getAllPositions());
        return "positionList";
    }

    @GetMapping("/form")
    public String addHrLadyForm(Model model) {
        model.addAttribute("position",new PositionDto());
        return "positionForm";
    }

    @PostMapping
    public String addHrLady(PositionDto dto) {
         positionService.addPosition(dto);
         return "redirect:/positions/list";
    }

}
