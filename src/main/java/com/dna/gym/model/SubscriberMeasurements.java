package com.dna.gym.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class SubscriberMeasurements {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String subscriberId;
    private String height;
    private String weight;
    private String chest;
    private String shoulders;
    private String arms;
    private String stomach;
    private String pelvis;
    private String thigh;
    private LocalDate date;

}
