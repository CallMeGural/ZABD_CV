package pl.zabd.zabd_projekt2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.service.CandidateService;

import java.util.List;

@Controller
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping
    public List<Candidate> fetchAllStudents() {
        return candidateService.getAllStudents();
    }
}
