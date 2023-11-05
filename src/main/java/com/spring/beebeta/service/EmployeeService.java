package com.spring.beebeta.service;

import com.spring.beebeta.entity.Employee;
import com.spring.beebeta.entity.Role;
import com.spring.beebeta.repository.EmployeeRepository;
import com.spring.beebeta.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;
    public List<Employee> getAll(){
        return repository.getAll();
    }

    public List<Employee> getAllbyName(String name){
        return repository.searchByName('%'+name+'%');
    }

    public Employee add(EmployeeRequest request){
        Employee employee = new Employee();
        employee.setCode(request.getCode());
        employee.setFullname(request.getFullname());
        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());
        employee.setImage(request.getImage());
        employee.setGender(request.getGender());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());
        employee.setStatus(0);
        employee.setRole(Role.builder().Id(request.getIdRole()).build());
        return repository.save(employee);
    }

    public Employee update(Integer id,EmployeeRequest request){
        Employee employee = repository.getById(id);
        employee.setCode(request.getCode());
        employee.setFullname(request.getFullname());
        employee.setUsername(request.getUsername());
        employee.setPassword(request.getPassword());
        employee.setImage(request.getImage());
        employee.setGender(request.getGender());
        employee.setPhone(request.getPhone());
        employee.setEmail(request.getEmail());
        employee.setRole(Role.builder().Id(request.getIdRole()).build());
        return repository.save(employee);
    }

    public Employee delete(Integer Id){
        Employee employee = repository.getById(Id);
        employee.setStatus(1);
        return repository.save(employee);
    }

    public Employee getById(Integer Id){
        Employee employee = repository.getById(Id);
        return employee;
    }
    public Employee getByUsername(String username){
        return repository.getByUsername(username);
    }
}
