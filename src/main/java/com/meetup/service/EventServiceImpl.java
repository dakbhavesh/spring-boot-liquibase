package com.meetup.service;

import com.meetup.domain.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavesh.shah on 4/10/2016.
 */
@Service
public class EventServiceImpl implements EventService {

    public List<Event> getAll(){
        /*Sort sort = new Sort(Sort.Direction.DESC);
        sort.getOrderFor("logTimeStamp");
        return (List<Event>) eventRepository.findAll(sort);*/
        return new ArrayList<>();
    }

}
