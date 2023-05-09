package pl.zabd.zabd_projekt2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.zabd.zabd_projekt2.model.Company;
import pl.zabd.zabd_projekt2.model.HrLady;
import pl.zabd.zabd_projekt2.model.dto.HrLadyDto;
import pl.zabd.zabd_projekt2.service.HrLadyService;
import pl.zabd.zabd_projekt2.service.PositionService;

@Controller
@RequestMapping("/hrs")
@RequiredArgsConstructor
public class HrLadyController {

    private final HrLadyService hrService;
    private final PositionService positionService;

    @GetMapping("/list")
    public String fetchAllHrs(Model model) {
        model.addAttribute("hrs",hrService.getAllHrs());
        return "hrList";
    }

    @GetMapping("/form")
    public String addHrLadyForm(Model model) {
        model.addAttribute("hrLady",new HrLadyDto());
        model.addAttribute("positions",positionService.getAllPositions());
        return "hrForm";
    }

    @PostMapping
    public HrLady addHrLady(HrLadyDto dto) {
        return hrService.addHrLady(dto);
    }

    @GetMapping("{id}")
    public String getCompanyById(@PathVariable String id, Model model) {
        model.addAttribute("hrLady",hrService.getHrById(id));
        return "hrEdit";
    }

    @PutMapping
    public String updateCompany(@Valid HrLady hrLady, Errors errors) {
        if(errors.hasErrors()) return "hrEdit";
        hrService.updateHr(hrLady);
        return "redirect:/hrs/list";
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable String id) {
        hrService.deleteHr(id);
        return "redirect:/hrs/list";
    }
}
