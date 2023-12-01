package com.simon.application.mapper;

import com.simon.application.entity.Station;
import com.simon.application.form.StationForm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StationMapper {

    Station mapFormToEntity(StationForm stationForm);
    StationForm mapEntityToForm(Station station);

}
