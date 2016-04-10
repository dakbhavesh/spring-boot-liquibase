package com.meetup.web.resource;

import com.meetup.domain.Event;
import com.meetup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavesh.shah on 4/9/2016.
 */
@RestController
@RequestMapping("/events")
public class EventResource {

    // TODO: Replace in-memory events with  spring ES template
    List<Event> events = new ArrayList<>();

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> postEvent(@RequestBody Event event){
        events.add(event);
        template.convertAndSend("/topic/message", event.toLogString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> monitor(){
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
