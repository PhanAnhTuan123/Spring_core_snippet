package com.anhtuan.springboot.cruddemo.rest;

import com.anhtuan.springboot.cruddemo.entity.Employee;
import com.anhtuan.springboot.cruddemo.error.EmployeeNotFoundException;
import com.anhtuan.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }
//    private EmployeeDAO employeeDAO;
    //quick and dirty: inject employee dao
//   public EmployeeRestController(EmployeeDAO thEmployeeDAO){
//       this.employeeDAO = thEmployeeDAO;
//   }
    //expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee>findAll(){
       return employeeService.findAll();
    }

    // add mapping for GET / employees / {employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) throws MethodArgumentTypeMismatchException {
        try{
            int id = Integer.parseInt(String.valueOf(employeeId));
        }catch(MethodArgumentTypeMismatchException exc){
            throw exc;
        }
        Employee thEmployee
                 = employeeService.findById(employeeId);
        if(thEmployee == null){
            throw new EmployeeNotFoundException("Employee id not found" + employeeId);
        }
        return thEmployee;
    }
    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

    // also just in case they pass an id in JSON ... set id to -0
        // this is to force a save of new item ... instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for PUT / employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for DELETE / employees/ {employeeID} -delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee == null){
            throw new EmployeeNotFoundException("Employeee not found "+ employeeId);

        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - "+ employeeId;
    }
}
