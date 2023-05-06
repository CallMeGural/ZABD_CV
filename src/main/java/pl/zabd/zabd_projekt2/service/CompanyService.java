package pl.zabd.zabd_projekt2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zabd.zabd_projekt2.model.Company;
import pl.zabd.zabd_projekt2.model.dto.CompanyDto;
import pl.zabd.zabd_projekt2.repository.CompanyRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company addCompany(CompanyDto dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setHrs(dto.getHrs());
        return companyRepository.insert(company);
    }
}
