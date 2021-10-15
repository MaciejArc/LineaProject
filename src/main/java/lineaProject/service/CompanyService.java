package lineaProject.service;

import lineaProject.entity.Company;
import lineaProject.repository.CompanyRepository;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

   public List<Company> findAllCompany(){
        return companyRepository.findAll();
    }
}
