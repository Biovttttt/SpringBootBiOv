package service.serviceImpl;

import entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CompanyRepository;
import service.CompanyService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public void saveCompany(Company company) {
companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElseThrow(
                ()->new NoSuchElementException(
                        "Company with id "+id+" not found!")
        );
    }

    @Override
    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
        }else {
            throw new NoSuchElementException(
                    "Company with id "+id+" not found!");
        }
    }

    @Override
    public void updateCompany(Long id, Company newCompany) {
Company company= getCompanyById(id);
company.setName(newCompany.getName());
company.setAddress(newCompany.getAddress());
company.setCountry(newCompany.getCountry());
company.setPhoneNumber(newCompany.getPhoneNumber());
   companyRepository.save(company);
    }
}
