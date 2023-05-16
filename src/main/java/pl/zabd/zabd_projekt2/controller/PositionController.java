package pl.zabd.zabd_projekt2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.zabd.zabd_projekt2.model.Company;
import pl.zabd.zabd_projekt2.model.HrLady;
import pl.zabd.zabd_projekt2.model.IExperience;
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
    public String fetchPositions(Model model) {
        model.addAttribute("positions",positionService.getAllPositions());
        return "positionList";
    }

    @GetMapping("/form")
    public String addPositionForm(Model model) {
        model.addAttribute("position",new PositionDto());
        model.addAttribute("skills", IExperience.values());
        return "positionForm";
    }

    @PostMapping
    public String addPosition(PositionDto dto) {
         positionService.addPosition(dto);
         return "redirect:/positions/list";
    }

    @GetMapping("/{id}")
    public String getPositionById(@PathVariable String id, Model model) {
        model.addAttribute("position",positionService.getPositionById(id));
        return "positionEdit";
    }

    @PutMapping("/{id}")
    public String updatePosition(@Valid Position position, Errors errors) {
        if(errors.hasErrors()) return "companyEdit";
        positionService.updatePosition(position);
        return "redirect:/positions/list";
    }

    @DeleteMapping("/{id}")
    public String deletePosition(@PathVariable String id) {
        positionService.deletePosition(id);
        return "redirect:/positions/list";
    }

}
