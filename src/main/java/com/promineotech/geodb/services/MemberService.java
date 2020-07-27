package com.promineotech.geodb.services;

import org.springframework.stereotype.Service;

import com.promineotech.geodb.entities.Member;
import com.promineotech.geodb.repositories.MemberRepository;
import com.promineotech.geodb.util.DegreeLevel;
import com.promineotech.geodb.util.Title;

@Service
public class MemberService {
	
	private MemberRepository repo;
	
	public Iterable<Member> getAllMembers () {
		return repo.findAll();
	}
	
	public Member getMember (Long id) {
		return repo.findOne(id);
	}
	
	public void deleteMember (Long id) {
		repo.delete(id);
	}
	
	public Member createMember (Member member) {
		return repo.save(member);
	}
	
	public Member updateMember (Member member) throws Exception {
		Member foundMember = member;
		foundMember.setFirstName(member.getFirstName());
		foundMember.setLastName(member.getLastName());
		if (member.getTitle() == Title.Director || member.getTitle() == Title.TeamLead || member.getTitle() == Title.Member) {
		foundMember.setTitle(member.getTitle());
		} else {
			throw new Exception("Invalid Title");
		}
		if (member.getEducation() == DegreeLevel.Associates || member.getEducation() == DegreeLevel.Bachelors || 
				member.getEducation() == DegreeLevel.Masters || member.getEducation() == DegreeLevel.Doctorate) {
		foundMember.setEducation(member.getEducation());
		} else {
			throw new Exception("Invalid Degree Level");
		}
		repo.save(foundMember);
		return foundMember;
	}
}
