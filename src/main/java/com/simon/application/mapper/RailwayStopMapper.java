package com.simon.application.mapper;

import com.simon.application.entity.RailwayStop;
import com.simon.application.form.RailwayStopForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RailwayStopMapper {

    @Mapping(source = "station", target = "station.id")
    RailwayStop mapFormToEntity(RailwayStopForm railwayStopForm);

    @Mapping(source = "station.id", target = "station")
    RailwayStopForm mapEntityToForm(RailwayStop railwayStop);

}
