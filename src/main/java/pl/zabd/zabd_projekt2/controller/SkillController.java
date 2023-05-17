package pl.zabd.zabd_projekt2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zabd.zabd_projekt2.model.IExperience;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.repository.SkillRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/skills")
public class SkillController {

    private final SkillRepository skillRepository;


    @GetMapping
    public String skillForm(Model model) {
        model.addAttribute("skill",new Skill());
        return "skillForm";
    }

    @PostMapping
    public String addSkill(Skill skill) {
        for(IExperience exp : IExperience.values()) {
            skillRepository.insert(new Skill(skill.getName(),exp));
        }
        return "redirect:/";
    }
}
