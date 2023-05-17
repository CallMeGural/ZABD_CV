package pl.zabd.zabd_projekt2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import pl.zabd.zabd_projekt2.model.Position;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.PositionDto;
import pl.zabd.zabd_projekt2.repository.SkillRepository;
import pl.zabd.zabd_projekt2.service.PositionService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;
    private final SkillRepository skillRepository;

    @GetMapping("/list")
    public String fetchPositions(Model model) {
        model.addAttribute("positions",positionService.getAllPositions());
        return "positionList";
    }

    @GetMapping("/form")
    public String addPositionForm(Model model) {
        model.addAttribute("position",new PositionDto());
        List<Skill> skills = new ArrayList<>(skillRepository.findAll());
        model.addAttribute("skills",skills);
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
        List<Skill> skills = new ArrayList<>(skillRepository.findAll());
        model.addAttribute("skills",skills);
        return "positionEdit";
    }

    @PutMapping("/{id}")
    public String updatePosition(@Valid Position position, Errors errors) {
        if(errors.hasErrors()) return "positionEdit";
        positionService.updatePosition(position);
        return "redirect:/positions/list";
    }

    @DeleteMapping("/{id}")
    public String deletePosition(@PathVariable String id) {
        positionService.deletePosition(id);
        return "redirect:/positions/list";
    }

    @PostMapping("/{id}")
    public String passPositionSkills(@PathVariable String id,Model model) {
        Position position = positionService.getPositionById(id);
        model.addAttribute("candidates",positionService.findByCriteria(position.getSkills()));
        return "candidateList";
    }

}
