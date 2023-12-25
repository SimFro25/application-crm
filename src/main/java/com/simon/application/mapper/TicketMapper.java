package com.simon.application.mapper;

import com.simon.application.entity.Ticket;
import com.simon.application.form.TicketForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {

    @Mappings({
            @Mapping(source = "exemption", target = "exemption.id"),
            @Mapping(source = "train", target = "train.id"),
            @Mapping(source = "carriage", target = "carriage.id"),
            @Mapping(source = "departStation", target = "departStation.id"),
            @Mapping(source = "arrivalStation", target = "arrivalStation.id"),
    })
    Ticket mapFormToEntity(TicketForm ticketForm);

    @Mappings({
            @Mapping(source = "exemption.id", target = "exemption"),
            @Mapping(source = "train.id", target = "train"),
            @Mapping(source = "carriage.id", target = "carriage"),
            @Mapping(source = "departStation.id", target = "departStation"),
            @Mapping(source = "arrivalStation.id", target = "arrivalStation"),
    })
    TicketForm mapEntityToForm(Ticket ticket);
}
