package com.eeerrorcode.guestbook.domain.dto;

import com.eeerrorcode.guestbook.domain.entity.GuestbookEntity;

import lombok.*;

@Getter
@Setter
@ToString
public class GuestbookWriteDto {
  private String title;
  private String content;
  private String writer;

  public GuestbookWriteDto(GuestbookEntity entity) {
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.writer = entity.getWriter();
  }

  public GuestbookEntity toEntity() {
    return GuestbookEntity.builder()
    .title(title)
    .content(content)
    .writer(writer)
    .build();
  }
}
