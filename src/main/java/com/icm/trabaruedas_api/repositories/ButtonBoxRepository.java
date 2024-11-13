package com.icm.trabaruedas_api.repositories;

import com.icm.trabaruedas_api.models.ButtonBoxModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ButtonBoxRepository extends JpaRepository<ButtonBoxModel, Long> {
    List<ButtonBoxModel> findByCompanyModelId(Long id);
    Page<ButtonBoxModel> findByCompanyModelId(Long id, Pageable pageable);
}
