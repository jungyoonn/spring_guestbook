package com.eeerrorcode.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eeerrorcode.guestbook.domain.dto.GuestbookDto;
import com.eeerrorcode.guestbook.domain.dto.PageRequestDto;
import com.eeerrorcode.guestbook.domain.dto.PageResultDto;
import com.eeerrorcode.guestbook.domain.entity.Guestbook;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTests {
  @Autowired
  private GuestbookService service;

  @Test
  public void writeTest() {
    GuestbookDto dto = GuestbookDto.builder()
    .title("test title")
    .content("test content")
    .writer("test writer")
    .build();

    Long gno = service.write(dto);
    assertNotNull(gno);
  }

  @Test
  public void listTest() {
    PageRequestDto dto = new PageRequestDto(2, 10);
    PageResultDto<GuestbookDto, Guestbook> resultDto = service.list(dto);
    log.info(resultDto);
    resultDto.getDtoList().forEach(log::info);
  }
}
