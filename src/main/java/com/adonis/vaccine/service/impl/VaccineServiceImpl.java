package com.adonis.vaccine.service.impl;

import com.adonis.vaccine.entity.Vaccine;
import com.adonis.vaccine.presentation.presenter.VaccinePresenter;
import com.adonis.vaccine.repository.VaccineRepository;
import com.adonis.vaccine.service.VaccineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Override
    public List<VaccinePresenter> getVaccines() {
        Iterable<Vaccine> vaccines = vaccineRepository.findAll();
        List<VaccinePresenter> vaccinePresenters = new ArrayList<>();
        vaccines.forEach(vaccine -> {
            vaccinePresenters.add(toVaccinePresenter(vaccine));
        });
        return vaccinePresenters;
    }

    @Override
    public Vaccine findById(UUID id) {
        Optional<Vaccine> vaccine = vaccineRepository.findById(id);
        if(vaccine.isPresent()){
            return vaccine.get();
        }
        throw new RuntimeException("Vaccine not found");
    }

    @Override
    public VaccinePresenter toVaccinePresenter(Vaccine vaccine) {
        return VaccinePresenter.builder()
                .id(vaccine.getId())
                .name(vaccine.getName())
                .description(vaccine.getDescription())
                .build();
    }

    @Override
    public Vaccine toVaccine(VaccinePresenter vaccinePresenter) {
        return Vaccine.builder()
                .id(vaccinePresenter.getId())
                .name(vaccinePresenter.getName())
                .description(vaccinePresenter.getDescription())
                .build();
    }
}
