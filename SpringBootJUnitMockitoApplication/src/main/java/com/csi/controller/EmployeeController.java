package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){

        return ResponseEntity.ok(employeeService.saveData(employee));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){

        return ResponseEntity.ok(employeeService.getAllData());
    }

    @PutMapping("/updatedataByid/{empId}")
    public ResponseEntity<Employee> updateDataById(@PathVariable int empId, @RequestBody Employee employee){

        return ResponseEntity.ok(employeeService.updateDataById(employee));
    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){

        employeeService.deleteDataById(empId);
        return ResponseEntity.ok("DATA DELETED SUCCESSFULLY");
    }
}
