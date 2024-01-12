package com.simon.application.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "distance_price", nullable = false)
    Double distancePrice;

    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    List<RailwayStop> railwayStops = new ArrayList<>();
}
