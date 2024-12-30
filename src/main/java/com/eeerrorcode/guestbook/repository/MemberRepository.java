package com.eeerrorcode.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eeerrorcode.guestbook.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
  
}
