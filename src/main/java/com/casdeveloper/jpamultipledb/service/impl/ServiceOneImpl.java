package com.casdeveloper.jpamultipledb.service.impl;

import com.casdeveloper.jpamultipledb.model.one.Department;
import com.casdeveloper.jpamultipledb.model.one.Employee;
import com.casdeveloper.jpamultipledb.repository.one.DepartmentRepository;
import com.casdeveloper.jpamultipledb.repository.one.EmployeeRepository;
import com.casdeveloper.jpamultipledb.service.ServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOneImpl implements ServiceOne {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Boolean addDepartment(Department department) {
        try {
            departmentRepository.save(department);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
