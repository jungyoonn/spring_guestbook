package com.eeerrorcode.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eeerrorcode.guestbook.domain.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
  void deleteByBoardBno(Long bno);
}
