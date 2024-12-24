package com.eeerrorcode.guestbook.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eeerrorcode.guestbook.domain.entity.GuestbookEntity;

import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
public class GuestbookRepositoryTests {
  @Autowired
  private GuestbookRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  public void testInsert() {
    repository.saveAll(
      IntStream.rangeClosed(1, 300).mapToObj(i -> {
        return GuestbookEntity.builder()
        .title("제목" + i)
        .content("내용" + i)
        .writer("작성자" + (i % 10))
        .build();
      }).toList()
    );
  }

  @Test
  public void testSelectList() {
    repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne() {
    log.info(repository.findById(1L));
  }

  @Test
  public void testModify() {

    Optional<GuestbookEntity> entity = repository.findById(1L);

    // 1
    entity.ifPresent(e -> {
      repository.save(GuestbookEntity.builder()
      .gno(entity.get().getGno())
      .title("제목수정")
      .content("수정1")
      .writer(entity.get().getWriter())
      .build());
    });

    // 2
    if(!entity.isPresent()) {
      return;
    }
    
    repository.save(GuestbookEntity.builder()
    .gno(entity.get().getGno())
    .title("제목수정")
    .content("수정1")
    .writer(entity.get().getWriter())
    .build());
    log.info(repository.findById(1L));  

    // repository.save(GuestbookEntity.builder()
    //   .gno(entity.get().getGno())
    //   .content("수정1")
    //   .writer(entity.get().getWriter())
    //   .build());
    // log.info(repository.findById(1L));
  }
}
