package com.adonis.vaccine.presentation.controller;

import com.adonis.vaccine.presentation.presenter.EmployeePresenter;
import com.adonis.vaccine.service.EmployeeService;
import com.sun.istack.NotNull;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Generated
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/findAll")
    public List<EmployeePresenter> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/getWorkOrderById")
    public EmployeePresenter getEmployeeById(@RequestParam("employeeId") UUID employeeId) throws ParseException {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/saveUpdateEmployee")
    public EmployeePresenter saveUpdateEmployee(@RequestBody @NotNull EmployeePresenter employeePresenter) throws ParseException {
        return employeeService.saveUpdateEmployee(employeePresenter);
    }
}
