package com.simon.application.mapper;

import com.simon.application.entity.Route;
import com.simon.application.form.RouteForm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RouteMapper {

    Route mapFormToEntity(RouteForm routeForm);
    RouteForm mapEntityToForm(Route route);

}
