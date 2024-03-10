package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDao;

    public Employee  saveData(Employee employee){

        return employeeDao.saveData(employee);
    }

    public List<Employee> getAllData(){

        return employeeDao.getAllData();
    }

    public Employee updateDataById(Employee employee){

        return employeeDao.updateDataById(employee);
    }

    public void deleteDataById(int empId){

        employeeDao.deleteDataById(empId);
    }
}
