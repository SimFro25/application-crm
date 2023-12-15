package com.simon.application.mapper;

import com.simon.application.entity.Exemption;
import com.simon.application.form.ExemptionForm;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ExemptionMapper {

    Exemption mapFormToEntity(ExemptionForm exemptionForm);
    ExemptionForm mapEntityToForm(Exemption exemption);
}
