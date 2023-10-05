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

    int id;
    int order;
    int station;
    LocalTime timeOfArrival;
    LocalTime timeOfDepart;
}
