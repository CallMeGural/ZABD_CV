package pl.zabd.zabd_projekt2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.zabd.zabd_projekt2.model.Candidate;
import pl.zabd.zabd_projekt2.model.Skill;
import pl.zabd.zabd_projekt2.repository.CandidateRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ZabdProjekt2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZabdProjekt2Application.class, args);
    }

    @Bean
    CommandLineRunner runner(CandidateRepository repository) {
        return args -> {
            repository.insert(new Candidate("Jan","Nowak",new HashMap<>()));
        };
    }
}
