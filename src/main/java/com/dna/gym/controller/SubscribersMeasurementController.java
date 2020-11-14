package com.dna.gym.controller;

import com.dna.gym.exception.ResourceNotFoundException;
import com.dna.gym.model.Subscriber;
import com.dna.gym.model.SubscriberMeasurements;
import com.dna.gym.repository.SubscribersMeasurementRepository;
import com.dna.gym.repository.SubscribersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/measurement")
public class SubscribersMeasurementController {
    @Autowired
    private SubscribersMeasurementRepository subscribersMeasurementRepository;



    @GetMapping("/subscriberId")
    public ResponseEntity<List<SubscriberMeasurements>> getSubscriberById(@RequestParam String subscriberId)
            throws ResourceNotFoundException {
        List<SubscriberMeasurements> subscriber = subscribersMeasurementRepository.findBySubscriberId(subscriberId);
        return ResponseEntity.ok().body(subscriber);
    }

    @PostMapping("/create-measurement")
    public SubscriberMeasurements createSubscriber(@RequestBody SubscriberMeasurements subscriberMeasurements) {
        return subscribersMeasurementRepository.save(subscriberMeasurements);
    }

}
