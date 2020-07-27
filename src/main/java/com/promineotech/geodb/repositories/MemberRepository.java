package com.promineotech.geodb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.geodb.entities.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{

	public Member findById (Long id);
}
