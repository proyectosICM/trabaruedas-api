package com.icm.trabaruedas_api.repositories;

import com.icm.trabaruedas_api.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
}
