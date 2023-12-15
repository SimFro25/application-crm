package com.simon.application.service;

import com.simon.application.entity.Exemption;
import com.simon.application.form.ExemptionForm;
import com.simon.application.mapper.ExemptionMapper;
import com.simon.application.repository.ExemptionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExemptionService {

    ExemptionMapper exemptionMapper;
    ExemptionRepository exemptionRepository;

    public List<Exemption> getAll() {
        List<Exemption> exemptions = new ArrayList<>();

        for (Exemption exemption : exemptionRepository.findAll()) {
            exemptions.add(exemption);
        }

        return exemptions;
    }

    public Exemption getExemptionById(long id) {
        return exemptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Exemption with id %d doesn't exist", id)));
    }

    public void create(ExemptionForm exemptionForm) {
        Exemption exemption = exemptionMapper.mapFormToEntity(exemptionForm);
        exemptionRepository.save(exemption);
    }

    public void edit(long id, ExemptionForm exemptionForm) {
        Exemption exemption = getExemptionById(id);

        exemption.setName(exemptionForm.getName());
        exemption.setDiscount(exemptionForm.getDiscount());

        exemptionRepository.save(exemption);
    }

    public void delete(long id) {
        exemptionRepository.deleteById(id);
    }
}
