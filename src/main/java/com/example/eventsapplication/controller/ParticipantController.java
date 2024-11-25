package com.example.eventsapplication.controller;


import com.example.eventsapplication.model.Participant;
import com.example.eventsapplication.service.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping("/participants")
    public ResponseEntity<Participant> createEvent(@Valid @RequestBody Participant participant) {
        return new ResponseEntity<>(participantService.createParticipant(participant), HttpStatus.CREATED);
    }

    @GetMapping("/participants")
    public ResponseEntity<List<Participant>> getAllParticipants() {
        return new ResponseEntity<>(participantService.getAllParticipants(), HttpStatus.OK);
    }

    @GetMapping("/participants/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long id) {
        return new ResponseEntity<>(participantService.getParticipantById(id), HttpStatus.OK);
    }

    @PutMapping("/participants/{id}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Long id, @Valid @RequestBody Participant participant) {
        return new ResponseEntity<>(participantService.updateParticipant(id, participant), HttpStatus.OK);
    }

    @DeleteMapping("/participants/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
