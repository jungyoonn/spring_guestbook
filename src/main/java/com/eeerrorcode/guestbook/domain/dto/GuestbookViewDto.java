package com.eeerrorcode.guestbook.domain.dto;

import java.time.LocalDateTime;

import com.eeerrorcode.guestbook.domain.entity.GuestbookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookViewDto {
  private Long gno;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  public GuestbookViewDto(GuestbookEntity entity) {
    this.gno = entity.getGno();
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.writer = entity.getWriter();
    this.regDate = entity.getRegDate();
    this.modDate = entity.getModDate();
  }

  
}
