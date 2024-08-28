package service;

import entity.Company;

import java.util.List;

public interface CompanyService {
    void saveCompany (Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    void deleteCompany(Long id);
    void updateCompany(Long id , Company newCompany);
}
