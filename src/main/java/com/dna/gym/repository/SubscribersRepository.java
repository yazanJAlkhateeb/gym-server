package com.dna.gym.repository;

import com.dna.gym.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscribersRepository extends JpaRepository<Subscriber, Long> {

    Subscriber findBySubscriberId(String subscriberId);

}
