package com.promineotech.geodb.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.promineotech.geodb.entities.Station;
import com.promineotech.geodb.repositories.MemberRepository;
import com.promineotech.geodb.repositories.StationRepository;

@Service
public class StationService {
	
	private StationRepository repo;
	private MemberRepository memberRepo;
	
	public Iterable<Station> getallStations () {
		return repo.findAll();
	}
	
	public Station getOneStation (Long id) {
		return repo.findById(id);
	}
	
	public Station createStation (Station station) {
		return repo.save(station);
	}
	
	public void deleteStation (Long id) {
		repo.delete(id);
	}
	
	//testing, using patch/DynamicUpdate to not update members 
	//Plan B, keep above in play and use If statement
	public Station updateStation (Station station) {
		Station foundStation = station;
		foundStation.setHorizontal(station.getHorizontal());
		foundStation.setVertical(station.getVertical());
		foundStation.setZone(station.getZone());
		foundStation.setMembers(station.getMembers());
		repo.save(foundStation);
		return foundStation;
	}
	
	public Station addMembersToStation (Long stationId, Set<Long> memberIds) {
		Station station = repo.findById(stationId);
		for (Long id : memberIds) {
			station.getMembers().add(memberRepo.findById(id));
		}
		repo.save(station);
		return station;
	}
	
	public Station removeMembersFromStation (Long stationId, Set<Long> memberIds) {
		Station station = repo.findById(stationId);
		for (Long id : memberIds) {
			station.getMembers().remove(memberRepo.findOne(id));
		}
		repo.save(station);
		return station;
	}

}
