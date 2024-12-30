package com.eeerrorcode.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eeerrorcode.guestbook.domain.entity.Board;

public interface BoardRepositoy extends JpaRepository<Board, Long>{
  @Query("select b, m from tbl_board b left join member m where b.bno = :bno")
  Object getBoardWithMember(@Param("bno") Long gno);
}
