package com.promineotech.geodb.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.promineotech.geodb.entities.Event;
import com.promineotech.geodb.entities.Member;
import com.promineotech.geodb.entities.Station;
import com.promineotech.geodb.repositories.EventRepository;
import com.promineotech.geodb.repositories.MemberRepository;
import com.promineotech.geodb.repositories.StationRepository;

@Service
public class EventService {
	
	private EventRepository repo;
	private StationRepository stationRepo;
	private MemberRepository memberRepo;
	
	public Event createEvent (Event event) {
		return repo.save(event);	
	}
	
	//test by submitting postman w/o members.
	public Event updateEvent (Event event, Long id, Set<Station> stations) {
		Event foundEvent = repo.findById(id);
		foundEvent.setDate(event.getDate());
		foundEvent.setDepth(event.getDepth());
		foundEvent.setHorizontal(event.getHorizontal());
		foundEvent.setVertical(event.getVertical());
		foundEvent.setZone(event.getZone());
		foundEvent.setSize(event.getSize());
		foundEvent.setMembers(addStationMembersToEvent(event.getStations()));
		foundEvent.setStations(event.getStations());
		repo.save(foundEvent);
		return foundEvent;
		
	}
	
	public Iterable<Event> getEvents () {
		return repo.findAll();
	}
	
	public Event getSingleEvent (Long id) {
		return repo.findOne(id);
	}
	
	public void deleteEvent (Long id) {
		repo.delete(repo.findById(id));
	}

	public Set<Member> addStationMembersToEvent(Set<Station> stations) {
		Set<Member> members = new HashSet<Member>();
		for(Station station : stations) {
			for(Member member : station.getMembers()) {
				members.add(member);
			}
		}
		return members;
	}
	
	public Event removeStationsFromEvent (Long eventId, Set<Long> stationIds) {
		Event foundEvent = repo.findOne(eventId);
		for (Station station : stationRepo.findAll(stationIds)) {
			for(Member member: station.getMembers()) {
				foundEvent.getMembers().remove(member);
			}
			foundEvent.getStations().remove(station);
		}
		repo.save(foundEvent);
		return foundEvent;
	}
	
	public Event removeMembersFromEvent (Long eventId, Set<Long> memberIds) {
		Event foundEvent = repo.findOne(eventId);
		for(Member member : memberRepo.findAll(memberIds)) {
			foundEvent.getMembers().remove(member);
		}
		repo.save(foundEvent);
		return foundEvent;
	}
}
