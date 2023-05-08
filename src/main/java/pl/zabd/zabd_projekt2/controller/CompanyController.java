package pl.zabd.zabd_projekt2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.zabd.zabd_projekt2.model.Company;
import pl.zabd.zabd_projekt2.model.dto.CompanyDto;
import pl.zabd.zabd_projekt2.service.CompanyService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/list")
    public String fetchAllCompanies(Model model) {
        model.addAttribute("companies",companyService.getAllCompanies());
        return "companyList";
    }

    @GetMapping("/form")
    public String addCompanyForm(Model model) {
        model.addAttribute("company",new CompanyDto());
        return "companyForm";
    }

    @PostMapping
    public Company addCompany(CompanyDto dto) {
        return companyService.addCompany(dto);
    }
}
