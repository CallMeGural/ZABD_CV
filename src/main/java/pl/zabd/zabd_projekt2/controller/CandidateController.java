package pl.zabd.zabd_projekt2.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.model.dto.CandidateDto;
import pl.zabd.zabd_projekt2.model.dto.SkillDto;
import pl.zabd.zabd_projekt2.service.CandidateService;
import pl.zabd.zabd_projekt2.service.SkillService;

import java.util.List;


@Controller
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final SkillService skillService;

    @GetMapping("/list")
    public String fetchAllCandidates(Model model) {
        model.addAttribute("candidates",candidateService.getAllCandidates());
        return "candidateList";
    }

    @GetMapping("/form")
    public String addCandidateForm(Model model) {
        model.addAttribute("candidate",new CandidateDto());
        model.addAttribute("skills",skillService.getAllSkills());
        return "candidateForm";
    }

    @PostMapping
    public String addCandidate(CandidateDto dto) {
        candidateService.addCandidate(dto);
        return "redirect:/candidates/list";
    }

    @GetMapping("/{id}")
    public String getCandidateById(@PathVariable String id,Model model) {
        model.addAttribute("candidate",candidateService.getCandidateById(id));
        return "candidateEdit";
    }

    @PutMapping
    public String updateCandidate(@Valid Candidate candidate, Errors errors) {
        if(errors.hasErrors()) return "candidateEdit";
        candidateService.updateCandidate(candidate);
        return "redirect:/candidates/list";
    }

    @DeleteMapping("{id}")
    public String deleteCandidate(@PathVariable String id) {
        candidateService.deleteCandidate(id);
        return "redirect:/candidates/list";
    }

    @GetMapping
    public String fetchCandidatesBySkills(@RequestBody List<Skill> dtos, Model model) {
        model.addAttribute("candidates",candidateService.getCandidatesByCriteria(dtos));
        return "candidateList";
    }
}