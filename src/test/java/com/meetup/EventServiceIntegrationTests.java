package com.meetup;

import com.meetup.domain.Event;
import com.meetup.repository.es.EventRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by bhavesh.shah on 4/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class EventServiceIntegrationTests {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testGetAllEvents(){
        Assert.assertNotNull(eventRepository);
        Assert.assertNotNull(elasticsearchTemplate);

        Iterable<Event> events =  eventRepository.findAll();

        Assert.assertNotNull(events);
    }

}
