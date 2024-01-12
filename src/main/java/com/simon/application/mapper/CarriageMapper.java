package com.simon.application.mapper;

import com.simon.application.entity.Carriage;
import com.simon.application.form.CarriageForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarriageMapper {

    @Mappings(value = {
            @Mapping(source = "trainId", target = "train.id"),
            @Mapping(source = "carriageTypeId", target = "carriageType.id")
    })
    Carriage mapFormToEntity(CarriageForm carriageForm);

    @Mappings(value = {
            @Mapping(source = "train.id", target = "trainId"),
            @Mapping(source = "carriageType.id", target = "carriageTypeId")
    })
    CarriageForm mapEntityToForm(Carriage carriage);
}
