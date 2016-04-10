package com.meetup.repository.es;

import com.meetup.domain.Event;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by bhavesh.shah on 4/10/2016.
 */
public interface EventRepository  extends ElasticsearchRepository<Event, Long>{
}
