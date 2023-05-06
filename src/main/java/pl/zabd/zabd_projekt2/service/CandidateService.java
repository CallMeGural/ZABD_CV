package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.dto.CandidateDto;
import pl.zabd.zabd_projekt2.repository.CandidateRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate addCandidate(CandidateDto dto) {
        Candidate candidate = new Candidate();
        candidate.setName(dto.getName());
        candidate.setSurname(dto.getSurname());
        candidate.setSkills(dto.getSkills());
        return  candidateRepository.insert(candidate);
    }
}
