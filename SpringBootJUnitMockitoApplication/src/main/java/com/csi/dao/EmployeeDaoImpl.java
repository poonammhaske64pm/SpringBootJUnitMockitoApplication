package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveData(Employee employee){

        return employeeRepository.save(employee);
    }

    public List<Employee> getAllData(){

        return employeeRepository.findAll();
    }

    public Employee updateDataById(Employee employee){

        return employeeRepository.save(employee);
    }

    public void deleteDataById(int empId){

        employeeRepository.deleteById(empId);
    }
}
