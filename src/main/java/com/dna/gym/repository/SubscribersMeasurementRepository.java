package com.dna.gym.repository;

import com.dna.gym.model.SubscriberMeasurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscribersMeasurementRepository extends JpaRepository<SubscriberMeasurements, Long> {

    List<SubscriberMeasurements> findBySubscriberId(String subscriberId);

}
