package org.learning.emp_project;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    // List<Employee> employees = new ArrayList<>();//if not using db then only

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity emplyeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, emplyeeEntity);// from employee to emplyeeEntity-data --normal data to entity
                                                          // then table
        employeeRepository.save(emplyeeEntity);
        // employees.add(employee);//local operations
        return "saved succesfully";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);// from emplyeeEntity to employee-data

        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity emplyeeEntity : employeesList) {
            Employee emp = new Employee();
            emp.setId(emplyeeEntity.getId());
            emp.setName(emplyeeEntity.getName());
            emp.setEmail(emplyeeEntity.getEmail());
            emp.setPhone(emplyeeEntity.getPhone());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String UpdateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);// new values here
        return "Update succesfully";
    }

}
