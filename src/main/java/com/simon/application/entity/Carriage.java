package com.simon.application.entity;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "carriages")
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Short number;

    @Column(nullable = false)
    String type;

    @Column(nullable = false)
    Short seats;

    @ManyToOne
    Train train;
}
