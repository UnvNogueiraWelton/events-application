package com.example.eventsapplication.service;

import com.example.eventsapplication.model.Event;
import com.example.eventsapplication.model.Participant;
import com.example.eventsapplication.repository.EventRepository;
import com.example.eventsapplication.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private EventService eventService;

    public Participant createParticipant(Participant participant) {
        eventService.getEventById(participant.getEvent().getId());
        return participantRepository.save(participant);
    }

    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante não encontrado"));
    }

    public Participant updateParticipant(Long id, Participant updatedParticipant) {
        Participant participant = getParticipantById(id);

        participant.setName(updatedParticipant.getName());
        participant.setEmail(updatedParticipant.getEmail());
        participant.setPhone(updatedParticipant.getPhone());

        return participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        getParticipantById(id);
        participantRepository.deleteById(id);
    }
}