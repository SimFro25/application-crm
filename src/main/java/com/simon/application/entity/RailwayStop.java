package com.simon.application.entity;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors (chain = true)
@FieldDefaults (level = AccessLevel.PRIVATE)
@Entity
@Table(name = "railway_stops")
public class RailwayStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Route route;

    @ManyToOne
    Station station;

    @Column(name = "stop_order")
    Integer order;

    @Column(name = "time_of_arrival")
    LocalTime timeOfArrival;

    @Column(name = "time_of_depart")
    LocalTime timeOfDepart;

    public Long getParkingTime() {
        return ChronoUnit.MINUTES.between(timeOfArrival, timeOfDepart);
    }

}
