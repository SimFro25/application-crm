package com.simon.application.mapper;

import com.simon.application.entity.Carriage;
import com.simon.application.form.CarriageForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarriageMapper {

    @Mapping(source = "trainId", target = "train.id")
    Carriage mapFormToEntity(CarriageForm carriageForm);

    @Mapping(source = "train.id", target = "trainId")
    CarriageForm mapEntityToForm(Carriage carriage);
}
