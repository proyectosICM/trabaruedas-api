package com.icm.trabaruedas_api.services;

import com.icm.trabaruedas_api.models.ButtonBoxModel;
import com.icm.trabaruedas_api.models.CompanyModel;
import com.icm.trabaruedas_api.repositories.ButtonBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ButtonBoxService {
    private final ButtonBoxRepository buttonBoxRepository;

    public ButtonBoxModel findById(Long id) {
        return buttonBoxRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Button Box lock with id " + id + " not found."));
    }

    public List<ButtonBoxModel> findAll(){
        return buttonBoxRepository.findAll();
    }

    public Page<ButtonBoxModel> findAll(Pageable pageable){
        return buttonBoxRepository.findAll(pageable);
    }

    public List<ButtonBoxModel> findByCompany(Long companyId){
        return buttonBoxRepository.findByCompanyModelId(companyId);
    }

    public Page<ButtonBoxModel> findByCompany(Long companyId, Pageable pageable){
        return buttonBoxRepository.findByCompanyModelId(companyId, pageable);
    }

    public ButtonBoxModel save(ButtonBoxModel buttonBoxModel){
        return buttonBoxRepository.save(buttonBoxModel);
    }

    public ButtonBoxModel editCompany(Long id, Long companyId){
        return buttonBoxRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.getCompanyModel().setId(companyId);
                    return buttonBoxRepository.save(existingCompany);
                })
                .orElseThrow(() -> new IllegalArgumentException("Button Box with id " + id + " not found."));
    }

    public void delete(Long id){
        buttonBoxRepository.deleteById(id);
    }
}
