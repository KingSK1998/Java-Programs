package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    //              endpoint path        
    @RequestMapping(name = "/employee", method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam Long id) {
        return new Employee(id, "SK", "IT");
    }
    
    @RequestMapping(name = "/employee", method = RequestMethod.POST, consumes = "application/JSON")
    public Employee createEmployee(@RequestBody Employee emp) {
        return emp;
    }
}
