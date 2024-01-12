package com.simon.application.service;

import com.simon.application.entity.CarriageType;
import com.simon.application.form.CarriageTypeForm;
import com.simon.application.mapper.CarriageTypeMapper;
import com.simon.application.repository.CarriageTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CarriageTypeService {

    CarriageTypeRepository carriageTypeRepository;
    CarriageTypeMapper carriageTypeMapper;

    public List<CarriageType> getAllCarriageTypes() {
        List<CarriageType> carriageTypes = new ArrayList<>();

        for (CarriageType carriageType : carriageTypeRepository.findAll()) {
            carriageTypes.add(carriageType);
        }

        return carriageTypes;
    }

    public CarriageType getCarriageTypeById(long id) {
        return carriageTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Carriage type with id %d doesn't exists", id)));
    }

    public void create(CarriageTypeForm carriageTypeForm) {
        CarriageType carriageType = carriageTypeMapper.mapFormToEntity(carriageTypeForm);
        carriageTypeRepository.save(carriageType);
    }

    public void edit(long id, CarriageTypeForm carriageTypeForm) {
        CarriageType carriageType = getCarriageTypeById(id);

        carriageType.setName(carriageTypeForm.getName());
        carriageType.setSeats(carriageTypeForm.getSeats());
        carriageType.setPrice(carriageTypeForm.getPrice());

        carriageTypeRepository.save(carriageType);
    }

    public void remove(long id) {
        carriageTypeRepository.deleteById(id);
    }
}
