package com.eeerrorcode.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eeerrorcode.guestbook.domain.dto.GuestbookDto;
import com.eeerrorcode.guestbook.domain.dto.PageRequestDto;
import com.eeerrorcode.guestbook.domain.dto.PageResultDto;
import com.eeerrorcode.guestbook.domain.entity.Guestbook;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTests {
  @Autowired
  private GuestbookService service;

  @Test
  @DisplayName("글 작성 서비스 테스트")
  @Transactional // 글은 써지는데 커밋을 안 함(디비에 반영 x)
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
    PageRequestDto dto = PageRequestDto.builder().page(1).size(10).type("TC").keyword("제목").build();
    PageResultDto<GuestbookDto, Guestbook> resultDto = service.list(dto);
    log.info(resultDto);
    resultDto.getDtoList().forEach(log::info);
  }
}
