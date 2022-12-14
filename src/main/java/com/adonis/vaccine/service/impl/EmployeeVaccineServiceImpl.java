package com.adonis.vaccine.service.impl;

import com.adonis.vaccine.entity.EmployeeVaccine;
import com.adonis.vaccine.presentation.presenter.EmployeeVaccinePresenter;
import com.adonis.vaccine.repository.EmployeeVaccineRepository;
import com.adonis.vaccine.service.EmployeeVaccineService;
import com.adonis.vaccine.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class EmployeeVaccineServiceImpl implements EmployeeVaccineService {
    @Autowired
    private EmployeeVaccineRepository employeeVaccineRepository;

    @Autowired
    private VaccineService vaccineService;

    @Override
    public EmployeeVaccine saveEmployeeVaccine(EmployeeVaccine employeeVaccine) {
        return employeeVaccineRepository.save(employeeVaccine);
    }

    @Override
    public String delete(UUID id) {
        Optional<EmployeeVaccine> employeeVaccine = employeeVaccineRepository.findById(id);
        if (employeeVaccine.isPresent()) {
            employeeVaccineRepository.deleteById(id);
            return "deleted correctly";
        }
        return "vaccine not found";
    }

    @Override
    public EmployeeVaccine toEmployeeVaccine(EmployeeVaccinePresenter employeeVaccinePresenter) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        try {
            date1 = formatter1.parse(employeeVaccinePresenter.getDate());
        } catch (ParseException e) {
            date1 = new Date();
        }


        return EmployeeVaccine.builder()
                .id(employeeVaccinePresenter.getId() != null
                        ? employeeVaccinePresenter.getId() : UUID.randomUUID())
                .date(date1)
                .dose(employeeVaccinePresenter.getDose())
                .vaccine(vaccineService.findById(employeeVaccinePresenter.getVaccinePresenter().getId()))
                .build();
    }

    @Override
    public EmployeeVaccinePresenter toEmployeeVaccinePresenter(EmployeeVaccine employeeVaccine) {
        return EmployeeVaccinePresenter.builder()
                .id(employeeVaccine.getId())
                .date(employeeVaccine.getDate().toString())
                .dose(employeeVaccine.getDose())
                .vaccinePresenter(vaccineService.toVaccinePresenter(employeeVaccine.getVaccine()))
                .build();
    }
}
