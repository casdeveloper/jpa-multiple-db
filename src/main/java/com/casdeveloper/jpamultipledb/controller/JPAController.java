package com.casdeveloper.jpamultipledb.controller;


import com.casdeveloper.jpamultipledb.model.one.Department;
import com.casdeveloper.jpamultipledb.model.one.Employee;
import com.casdeveloper.jpamultipledb.model.two.Contract;
import com.casdeveloper.jpamultipledb.model.two.Region;
import com.casdeveloper.jpamultipledb.service.ServiceOne;
import com.casdeveloper.jpamultipledb.service.ServiceTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JPAController {

    @Autowired
    ServiceOne serviceOne;

    @Autowired
    ServiceTwo serviceTwo;

    @PostMapping("/addRegion")
    ResponseEntity<Boolean> addRegion(@RequestBody Region region){
        return ResponseEntity.ok(serviceTwo.addRegion(region));
    }

    @PostMapping("/addContract")
    ResponseEntity<Boolean> addContract(@RequestBody Contract contract){
        return ResponseEntity.ok(serviceTwo.addContract(contract));
    }

    @GetMapping("/getAllRegion")
    ResponseEntity<List<Region>> getAllRegion(){
        return ResponseEntity.ok(serviceTwo.getAllRegion());
    }

    @GetMapping("/getAllContract")
    ResponseEntity<List<Contract>> getAllContract(){
        return  ResponseEntity.ok(serviceTwo.getAllContract());
    }

    @PostMapping("/addDepartment")
    ResponseEntity<Boolean> addDepartment(@RequestBody Department department){
        return ResponseEntity.ok(serviceOne.addDepartment(department));
    }

    @PostMapping("/addEmployee")
    ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(serviceOne.addEmployee(employee));
    }

    @GetMapping("/getAllDepartment")
    ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(serviceOne.getAllDepartment());
    }

    @GetMapping("/getAllEmployee")
    ResponseEntity<List<Employee>> getAllEmployee(){
        return  ResponseEntity.ok(serviceOne.getAllEmployee());
    }
}
