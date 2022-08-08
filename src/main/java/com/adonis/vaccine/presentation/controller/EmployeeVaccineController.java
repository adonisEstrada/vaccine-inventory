package com.adonis.vaccine.presentation.controller;

import com.adonis.vaccine.entity.EmployeeVaccine;
import com.adonis.vaccine.presentation.presenter.EmployeePresenter;
import com.adonis.vaccine.presentation.presenter.EmployeeVaccinePresenter;
import com.adonis.vaccine.service.EmployeeVaccineService;
import com.sun.istack.NotNull;
import liquibase.pro.packaged.A;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Generated
@RestController
public class EmployeeVaccineController {

    @Autowired
    private EmployeeVaccineService employeeVaccineService;

    @PostMapping("/deleteEmployeeVaccine")
    public String saveUpdateEmployee(@RequestBody @NotNull String id) {
        return employeeVaccineService.delete(UUID.fromString(id));
    }

    @PostMapping("/saveVaccine")
    public EmployeeVaccinePresenter saveVaccine(@RequestBody @NotNull EmployeeVaccinePresenter employeeVaccinePresenter) {
        return employeeVaccineService.toEmployeeVaccinePresenter(employeeVaccineService.saveEmployeeVaccine(employeeVaccineService.toEmployeeVaccine(employeeVaccinePresenter)));
    }
}
