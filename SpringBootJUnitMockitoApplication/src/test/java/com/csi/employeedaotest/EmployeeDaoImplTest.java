package com.csi.employeedaotest;
import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

    @MockBean
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeDaoImpl employeeDao;

    @Test
    public void getAllDataTest(){

        when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(21,"SHRI",35000,412578),
                new Employee(44,"KOYAL",41000,9874566),
                new Employee(63,"RAM",65000,3256666),
                new Employee(74,"KOMAL",78000,74589666)).collect(Collectors.toList()));

        assertEquals(4, employeeDao.getAllData().size());
    }

    @Test
    public void saveDataTest(){

        Employee employee = new Employee(44,"KOYAL",41000,9874566);
        employeeDao.saveData(employee);

        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void updateDataByIdTest(){

        Employee employee = new Employee(44,"KOYAL",41000,9874566);
        employeeDao.updateDataById(employee);

        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void deleteDataByIdTest(){

        Employee employee = new Employee(44,"KOYAL",41000,9874566);
        employeeDao.deleteDataById(employee.getEmpId());

        verify(employeeRepository, times(1)).deleteById(employee.getEmpId());
    }
}
