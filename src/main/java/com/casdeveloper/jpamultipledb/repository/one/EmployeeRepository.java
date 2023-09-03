package com.casdeveloper.jpamultipledb.repository.one;

import com.casdeveloper.jpamultipledb.model.one.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
