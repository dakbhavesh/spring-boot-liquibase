package com.meetup.service;

import com.meetup.domain.Event;
import com.meetup.repository.es.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bhavesh.shah on 4/10/2016.
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAll(){
        Sort sort = new Sort(Sort.Direction.DESC);
        sort.getOrderFor("logTimeStamp");
        return (List<Event>) eventRepository.findAll(sort);
    }

}
