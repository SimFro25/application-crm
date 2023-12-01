package com.simon.application.form;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public class RailwayStopForm {

    Long id;
    Integer order;
    Long station;
    LocalTime timeOfArrival;
    LocalTime timeOfDepart;
}
