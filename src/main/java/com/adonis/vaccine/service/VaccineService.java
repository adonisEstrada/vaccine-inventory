package com.adonis.vaccine.service;

import com.adonis.vaccine.entity.Vaccine;
import com.adonis.vaccine.presentation.presenter.VaccinePresenter;

import java.util.List;
import java.util.UUID;

public interface VaccineService {

    VaccinePresenter toVaccinePresenter(Vaccine vaccine);

    Vaccine toVaccine(VaccinePresenter vaccinePresenter);

    List<VaccinePresenter> getVaccines();

    Vaccine findById(UUID id);
}
