package com.simon.application.service;

import com.simon.application.entity.Carriage;
import com.simon.application.form.CarriageForm;
import com.simon.application.mapper.CarriageMapper;
import com.simon.application.repository.CarriageRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarriageService {

    CarriageTypeService carriageTypeService;
    CarriageMapper carriageMapper;
    CarriageRepository carriageRepository;

    public Carriage getCarriageById(long id) {
        return carriageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Carriage with id %d doesn't exist", id)));
    }

    public void create(long trainId, CarriageForm carriageForm) {
        carriageForm.setTrainId(trainId);

        Carriage entity = carriageMapper.mapFormToEntity(carriageForm);
        carriageRepository.save(entity);
    }

    public void edit(long carriageId, CarriageForm carriageForm) {
        Carriage carriage = getCarriageById(carriageId);

        carriage.setNumber(carriageForm.getNumber());
        carriage.setCarriageType(carriageTypeService.getCarriageTypeById(carriageForm.getCarriageTypeId()));

        carriageRepository.save(carriage);
    }

    public void delete(long carriageId) {
        carriageRepository.deleteById(carriageId);
    }
}
