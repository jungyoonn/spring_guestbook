package com.eeerrorcode.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eeerrorcode.guestbook.domain.entity.Board;

public interface BoardRepositoy extends JpaRepository<Board, Long>{
  
}
