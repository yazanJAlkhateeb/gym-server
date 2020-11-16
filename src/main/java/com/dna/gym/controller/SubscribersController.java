package com.dna.gym.controller;

import com.dna.gym.exception.ResourceNotFoundException;
import com.dna.gym.model.Subscriber;
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
@RequestMapping(value = "/subscriber")
public class SubscribersController {
    @Autowired
    private SubscribersRepository subscribersRepository;

    @GetMapping("/subscribers")
    public List<Subscriber> getAllSubscribers() {
        return subscribersRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscriber> getById(@PathVariable(value = "id") Long subscriberId)
            throws ResourceNotFoundException {
        Subscriber subscriber = subscribersRepository.findById(subscriberId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + subscriberId));
        return ResponseEntity.ok().body(subscriber);
    }

    @GetMapping("/subscriberId")
    public ResponseEntity<Subscriber> getSubscriberById(@RequestParam String subscriberId)
            throws ResourceNotFoundException {
        Subscriber subscriber = subscribersRepository.findBySubscriberId(subscriberId);
                //.orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + subscriberId));
        return ResponseEntity.ok().body(subscriber);
    }

    @PostMapping("/create-subscriber")
    public Subscriber createSubscriber(@RequestBody Subscriber subscriber) {
        return subscribersRepository.save(subscriber);
    }

    @PutMapping("/update-subscriber/{id}")
    public void updateSubscriber(@PathVariable(value = "id") Long subscriberId,
                                                       @Valid @RequestBody Subscriber subscriberDetails) throws ResourceNotFoundException {
        Subscriber subscriber = subscribersRepository.findById(subscriberId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + subscriberId));

        subscribersRepository.save(subscriberDetails);
    }

    @DeleteMapping("/delete-subscriber/{id}")
    public Map<String, Boolean> deleteSubscriber(@PathVariable(value = "id") Long subscriberId)
            throws ResourceNotFoundException {
        Subscriber subscriber = subscribersRepository.findById(subscriberId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscriber not found for this id :: " + subscriberId));

        subscribersRepository.delete(subscriber);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
