package com.casdeveloper.jpamultipledb.repository.two;

import com.casdeveloper.jpamultipledb.model.two.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
}
