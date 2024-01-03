package com.simon.application.mapper;

import com.simon.application.entity.CarriageType;
import com.simon.application.form.CarriageTypeForm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarriageTypeMapper {

    CarriageType mapFormToEntity(CarriageTypeForm carriageTypeForm);
    CarriageTypeForm mapEntityToForm(CarriageType carriageType);
}
