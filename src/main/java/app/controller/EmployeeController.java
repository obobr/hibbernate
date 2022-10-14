package app.controller;

import app.entity.CardAccount;
import app.entity.Employee;
import app.entity.Role;
import app.entity.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import app.service.EmployeeDataService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeDataService employeeDataService;

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Employee getEmployee(@PathVariable long id){
        return employeeDataService.findById(id);
    }

    @PostMapping(path = "/add",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
        employeeDataService.save(employee);
    }

    @DeleteMapping(path = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable long id){
        employeeDataService.delete(employeeDataService.findById(id));
    }

    @PutMapping(path = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        employeeDataService.updateEmployee(id,employee);
    }

    /*private void adSomeEmployee(String name, String secondName, String fatherName, String personalNumber, Date birthDate, Status status, Role role, List<CardAccount> cardAccounts){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setFatherName(fatherName);
        employee.setSecondName(secondName);
        employee.setPersonalNumber(personalNumber);
        employee.setBirthdate(birthDate);
        employee.setRole(role);
        employee.setStatus(status);
        employee.setCardAccounts(cardAccounts);
        employee.getRole().getEmployees().add(employee);
        employeeDataService.save(employee);
    }*/
}