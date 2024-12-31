package com.eeerrorcode.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eeerrorcode.guestbook.domain.dto.BoardDto;
import com.eeerrorcode.guestbook.domain.dto.PageRequestDto;
import com.eeerrorcode.guestbook.domain.dto.PageResultDto;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  @Autowired
  private BoardService service;

  @Test
  public void testGet() {
    Long bno = 200L;
    log.info(service.get(bno));
  }

  @Test
  public void testList() {
    PageResultDto<BoardDto, Object[]> dto = service.list(PageRequestDto.builder().page(1).size(10).build());
    log.info(dto);
    dto.getDtoList().forEach(log::info);
  }

  @Test
  public void testModify() {
    BoardDto dto = service.get(190L);
    dto.setContent("수정된 내용?");

    service.modify(dto);
  }

  @Test
  public void testRemove() {
    service.remove(104L);
  }
}
