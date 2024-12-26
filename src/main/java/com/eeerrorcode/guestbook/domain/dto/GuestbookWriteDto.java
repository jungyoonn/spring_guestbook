package com.eeerrorcode.guestbook.domain.dto;

import com.eeerrorcode.guestbook.domain.entity.Guestbook;

import lombok.*;

@Getter
@Setter
@ToString
public class GuestbookWriteDto {
  private String title;
  private String content;
  private String writer;

  public GuestbookWriteDto(Guestbook entity) {
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.writer = entity.getWriter();
  }

  public Guestbook toEntity() {
    return Guestbook.builder()
    .title(title)
    .content(content)
    .writer(writer)
    .build();
  }
}
