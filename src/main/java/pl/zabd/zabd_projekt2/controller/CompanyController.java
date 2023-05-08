package pl.zabd.zabd_projekt2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.zabd.zabd_projekt2.model.Company;
import pl.zabd.zabd_projekt2.model.dto.CompanyDto;
import pl.zabd.zabd_projekt2.service.CompanyService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/companies")
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
    public String addCompany(CompanyDto dto) {
        companyService.addCompany(dto);
        return "redirect:/companies/list";
    }

    @GetMapping("{id}")
    public String getCompanyById(@PathVariable String id, Model model) {
        model.addAttribute("company",companyService.getCompanyById(id));
        return "companyEdit";
    }

    @PutMapping
    public String updateCompany(@Valid Company company, Errors errors) {
        if(errors.hasErrors()) return "companyEdit";
        companyService.updateCompany(company);
        return "redirect:/companies/list";
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable String id) {
        companyService.deleteCompany(id);
        return "redirect:/companies/list";
    }
}
