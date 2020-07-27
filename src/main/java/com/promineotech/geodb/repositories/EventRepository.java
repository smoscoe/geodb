package com.promineotech.geodb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.geodb.entities.Event;

public interface EventRepository extends CrudRepository<Event,Long>{
	
	public Event findById (Long id);
}
