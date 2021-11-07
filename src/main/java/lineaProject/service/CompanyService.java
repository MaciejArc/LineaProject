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

    public Company addNewCompany(Company company){
      return companyRepository.save(company);
    }

    public Company findCompanyById(Long id){return companyRepository.findById(id).get();}

    public Company editCompany(Company company, Company company1){
        company.setName(company1.getName());
        company.setNip(company1.getNip());
        company.setOwner(company1.getOwner());
        company.setPhone(company1.getPhone());
        return companyRepository.save(company);
    }
}
