package com.promineotech.geodb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.geodb.entities.Station;

public interface StationRepository extends CrudRepository<Station, Long>{
	
	public Station findById (Long id);
}
