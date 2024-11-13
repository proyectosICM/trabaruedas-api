package com.icm.trabaruedas_api.repositories;

import com.icm.trabaruedas_api.models.WheelLockModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WheelLockRepository extends JpaRepository<WheelLockModel, Long> {
    List<WheelLockModel> findByCompanyModelId(Long id);
    Page<WheelLockModel> findByCompanyModelId(Long id, Pageable pageable);
}
