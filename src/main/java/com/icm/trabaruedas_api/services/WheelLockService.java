package com.icm.trabaruedas_api.services;

import com.icm.trabaruedas_api.models.WheelLockModel;
import com.icm.trabaruedas_api.repositories.WheelLockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WheelLockService {
    public final WheelLockRepository wheelLockRepository;

    public WheelLockModel findById(Long id) {
        return wheelLockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Wheel lock with id " + id + " not found."));
    }

    public List<WheelLockModel> findAll(){
        return wheelLockRepository.findAll();
    }

    public Page<WheelLockModel> findAll(Pageable pageable){
        return wheelLockRepository.findAll(pageable);
    }
    public List<String> findMacsByCompany(Long companyId) {
        return wheelLockRepository.findByCompanyModelId(companyId)
                .stream()
                .map(WheelLockModel::getMac)
                .collect(Collectors.toList());
    }
    public List<WheelLockModel> findByCompany(Long companyId){
        return wheelLockRepository.findByCompanyModelId(companyId);
    }

    public Page<WheelLockModel> findByCompany(Long companyId, Pageable pageable){
        return wheelLockRepository.findByCompanyModelId(companyId, pageable);
    }

    public WheelLockModel save(WheelLockModel wheelLockModel){
        return wheelLockRepository.save(wheelLockModel);
    }

    public WheelLockModel editMac(Long id, String newMac) {
        return wheelLockRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.setMac(newMac);
                    return wheelLockRepository.save(existingCompany);
                })
                .orElseThrow(() -> new IllegalArgumentException("Wheel lock with id " + id + " not found."));
    }

    public WheelLockModel editCompany(Long id, Long companyId){
        return wheelLockRepository.findById(id)
                .map(existingCompany -> {
                    existingCompany.getCompanyModel().setId(companyId);
                    return wheelLockRepository.save(existingCompany);
                })
                .orElseThrow(() -> new IllegalArgumentException("Wheel lock with id " + id + " not found."));
    }

    public void delete(Long id){
        wheelLockRepository.deleteById(id);
    }
}
