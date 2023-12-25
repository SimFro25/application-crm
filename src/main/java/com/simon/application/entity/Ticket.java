package com.simon.application.entity;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String passenger;

    @ManyToOne
    Exemption exemption;

    @ManyToOne(optional = false)
    Train train;

    @ManyToOne(optional = false)
    Carriage carriage;

    @Column(name = "depart_station")
    @ManyToOne(optional = false)
    Station departStation;

    @Column(name = "arrival_station")
    @ManyToOne(optional = false)
    Station arrivalStation;

    @Column(nullable = false)
    Integer seat;

    @Column(name = "ticket_date", nullable = false)
    LocalDate ticketDate;

    @Column(nullable = false)
    BigDecimal price;
}
