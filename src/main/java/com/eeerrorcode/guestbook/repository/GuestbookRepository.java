package com.eeerrorcode.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.eeerrorcode.guestbook.domain.entity.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>
, QuerydslPredicateExecutor<Guestbook>
{
  
}
