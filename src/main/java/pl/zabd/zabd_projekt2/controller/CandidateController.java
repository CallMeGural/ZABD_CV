package pl.zabd.zabd_projekt2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.dto.CandidateDto;
import pl.zabd.zabd_projekt2.service.CandidateService;

import java.util.List;

@Controller
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping("/list")
    public String fetchAllCandidates(Model model) {
        model.addAttribute("candidates",candidateService.getAllCandidates());
        return "candidateList";
    }

    @GetMapping("/form")
    public String addCandidateForm(Model model) {
        model.addAttribute("candidate",new CandidateDto());
        return "candidateForm";
    }

    @PostMapping
    public Candidate addCandidate(CandidateDto dto) {
        return candidateService.addCandidate(dto);
    }
}
