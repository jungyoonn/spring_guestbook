package com.eeerrorcode.guestbook.repository;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.eeerrorcode.guestbook.domain.entity.Board;
import com.eeerrorcode.guestbook.domain.entity.Member;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
  @Autowired
  private BoardRepositoy repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  @Transactional
  @Rollback(false)
  public void testInsert() {
    IntStream.rangeClosed(2, 100).forEach(i -> {
      Board board = Board.builder()
      .title("title" + i)
      .content("content" + i)
      .member(Member.builder().email("user" + i + "@a.com").build())
      .build();
      repository.save(board);
    });

    // Board board = Board.builder()
    //   .title("title2")
    //   .content("content2")
    //   .member(Member.builder().email("user2@a.com").build())
    //   .build();
    //   repository.save(board);
  }

  @Test
  public void testSelectList() {
    repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne() {
    Board board = repository.findById(10L).orElse(null);
    log.info(board.getMember());
  }

  @Test
  public void testGetBoardWithMember() {
    Object result = repository.getBoardWithMember(104L);
    Object[] arr = (Object[]) result;
    log.info(Arrays.toString(arr));
  }
}
