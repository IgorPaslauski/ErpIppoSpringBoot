package com.example.ErpIppo.Repository;

import com.example.ErpIppo.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {

}
