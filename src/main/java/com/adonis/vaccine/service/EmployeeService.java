package com.adonis.vaccine.service;

import com.adonis.vaccine.entity.Employee;
import com.adonis.vaccine.entity.EmployeeVaccine;
import com.adonis.vaccine.presentation.presenter.EmployeePresenter;
import com.adonis.vaccine.presentation.presenter.EmployeeVaccinePresenter;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<EmployeePresenter> findAll();
    EmployeePresenter getEmployeeById(UUID employeeId) throws ParseException;

    EmployeePresenter toEmployeePresenter(Employee workOrder) throws ParseException;

    EmployeePresenter saveUpdateEmployee(EmployeePresenter employeePresenter) throws ParseException;
}
