package com.adonis.vaccine.service;

import com.adonis.vaccine.entity.EmployeeVaccine;
import com.adonis.vaccine.presentation.presenter.EmployeeVaccinePresenter;

import java.util.UUID;

public interface EmployeeVaccineService {
    EmployeeVaccine saveEmployeeVaccine(EmployeeVaccine employeeVaccine);

    String delete(UUID id);

    public EmployeeVaccine toEmployeeVaccine(EmployeeVaccinePresenter employeeVaccinePresenter);

    EmployeeVaccinePresenter toEmployeeVaccinePresenter(EmployeeVaccine employeeVaccine);
}
