package com.icm.trabaruedas_api.services;

import com.icm.trabaruedas_api.models.CompanyModel;
import com.icm.trabaruedas_api.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyModel findById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Company with id " + id + " not found."));
    }

    public List<CompanyModel> findAll(){
        return companyRepository.findAll();
    }

    public Page<CompanyModel> findAll(Pageable pageable){
        return companyRepository.findAll(pageable);
    }

    public CompanyModel save(CompanyModel companyModel){
        return companyRepository.save(companyModel);
    }

    public CompanyModel edit(Long id, CompanyModel companyModel) {
        return companyRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setCompanyName(companyModel.getCompanyName());
                    existingCompany.setUsername(companyModel.getUsername());
                    existingCompany.setPassword(companyModel.getPassword());
                    return companyRepository.save(existingCompany);
                })
                .orElseThrow(() -> new IllegalArgumentException("Company with id " + id + " not found."));
    }

    public CompanyModel changeCredentials(Long id, String username, String password){
        return companyRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setUsername(username);
                    existingCompany.setPassword(password);
                    return companyRepository.save(existingCompany);
                })
                .orElseThrow(() -> new IllegalArgumentException("Company with id " + id + " not found."));
    }

    public void delete(Long id){
        companyRepository.deleteById(id);
    }
}
