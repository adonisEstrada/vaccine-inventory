package com.adonis.vaccine.presentation.presenter;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePresenter {
    private UUID id;
    private String lastName;
    private String firstName;
    private String dateOfBirth;
    private String dni;
    private String address;
    private String mail;
    private String status;
    private String phone;
    @Builder.Default
    private List<EmployeeVaccinePresenter> employeeVaccinePresenters = new ArrayList<>();
}
