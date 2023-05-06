package pl.zabd.zabd_projekt2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zabd.zabd_projekt2.model.HrLady;
import pl.zabd.zabd_projekt2.model.dto.HrLadyDto;
import pl.zabd.zabd_projekt2.service.HrLadyService;

@Controller
@RequestMapping("/hrs")
@RequiredArgsConstructor
public class HrLadyController {

    private final HrLadyService hrService;

    @GetMapping
    public String fetchAllHrs(Model model) {
        model.addAttribute("hrs",hrService.getAllHrs());
        return "hrList";
    }

    @GetMapping("/form")
    public String addHrLadyForm(Model model) {
        model.addAttribute("hrLady",new HrLadyDto());
        return "hrForm";
    }

    @PostMapping
    public HrLady addHrLady(HrLadyDto dto) {
        return hrService.addHrLady(dto);
    }
}
