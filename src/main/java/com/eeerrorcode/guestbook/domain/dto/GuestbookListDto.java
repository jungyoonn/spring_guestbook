package com.eeerrorcode.guestbook.domain.dto;

import java.time.LocalDateTime;

import com.eeerrorcode.guestbook.domain.entity.Guestbook;

import lombok.*;

@Getter
@Setter
@ToString
public class GuestbookListDto {
  private Long gno;
  private String title;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  public GuestbookListDto(Guestbook entity) {
    this.gno = entity.getGno();
    this.title = entity.getTitle();
    this.writer = entity.getWriter();
    this.regDate = entity.getRegDate();
    this.modDate = entity.getModDate();
  }

  public Guestbook toEntity() {
    return Guestbook.builder()
    .gno(gno)
    .title(title)
    .writer(writer)
    .build();
  }
}