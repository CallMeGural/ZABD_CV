package pl.zabd.zabd_projekt2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.SkillDto;
import pl.zabd.zabd_projekt2.service.SkillService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/skill")
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/list")
    public String fetchAllSkills(Model model) {
        model.addAttribute("skills",skillService.getAllSkills());
        return "skillList";
    }

    @GetMapping("/form")
    public String addSkillForm(Model model) {
        model.addAttribute("skill",new SkillDto());
        return "skillForm";
    }

    @PostMapping
    public Skill addSkill(SkillDto dto) {
        return skillService.addSkill(dto);
    }

    @PutMapping
    public Skill updateSkill(Skill skill) {
        return  skillService.updateSkill(skill);
    }
}
