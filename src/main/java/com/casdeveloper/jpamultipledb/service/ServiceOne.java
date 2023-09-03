package com.casdeveloper.jpamultipledb.service;

import com.casdeveloper.jpamultipledb.model.one.Department;
import com.casdeveloper.jpamultipledb.model.one.Employee;

import java.util.List;

public interface ServiceOne {

    Boolean addDepartment(Department department);
    Boolean addEmployee(Employee employee);
    List<Department> getAllDepartment();
    List<Employee> getAllEmployee();
}
