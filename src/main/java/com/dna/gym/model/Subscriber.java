package com.dna.gym.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String subscriberId;
    private LocalDate startOfSubscription;
    private LocalDate endOfSubscription;
    private BigDecimal totalSubscriptionAmount;
    private BigDecimal paidSubscriptionAmount;
    @Lob
    @Column(length = 1000)
    private String image;
}
