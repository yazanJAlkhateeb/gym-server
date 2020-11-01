package com.dna.gym.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.File;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String subscriberId;
    private LocalDate startOfSubscription;
    private LocalDate endOfSubscription;
    @Lob
    @Column(length = 1000)
    private String image;
}
