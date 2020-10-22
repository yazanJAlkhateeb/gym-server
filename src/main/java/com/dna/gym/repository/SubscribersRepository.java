package com.dna.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dna.gym.model.Subscriber;

@Repository
public interface SubscribersRepository extends JpaRepository<Subscriber, Long>{

}
