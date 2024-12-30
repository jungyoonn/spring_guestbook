package com.eeerrorcode.guestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eeerrorcode.guestbook.domain.entity.Board;

public interface BoardRepositoy extends JpaRepository<Board, Long>{
  @Query("select b, m from tbl_board b left join member m where b.bno = :bno")
  Object getBoardWithMember(@Param("bno") Long gno);

  @Query("select b, r from tbl_board b left join tbl_reply r on b = r.board where bno = :bno")
  List<Object[]> getBoardWithReply(@Param("bno") Long bno);
}
