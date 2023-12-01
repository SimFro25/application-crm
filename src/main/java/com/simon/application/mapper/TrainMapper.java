package com.simon.application.mapper;

import com.simon.application.entity.Train;
import com.simon.application.form.TrainForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TrainMapper {

    @Mapping(source = "route", target = "route.id")
    Train mapFormToEntity(TrainForm trainForm);

    @Mapping(source = "route.id", target = "route")
    TrainForm mapEntityToForm(Train train);
}
