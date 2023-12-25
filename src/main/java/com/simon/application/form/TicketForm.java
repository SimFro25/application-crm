package com.simon.application.form;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketForm {

    Long id;
    String passenger;
    Long exemption;
    Long train;
    Long carriage;
    Long departStation;
    Long arrivalStation;
    Integer seat;
    LocalDate ticketDate;
    BigDecimal price;
}
