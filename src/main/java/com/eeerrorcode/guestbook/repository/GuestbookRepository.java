package com.eeerrorcode.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eeerrorcode.guestbook.domain.entity.GuestbookEntity;

public interface GuestbookRepository extends JpaRepository<GuestbookEntity, Long>{
  
}
