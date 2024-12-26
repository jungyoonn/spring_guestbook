package com.eeerrorcode.guestbook.domain.dto;

import com.eeerrorcode.guestbook.domain.entity.Guestbook;

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
public class GuestbookModifyDto {
  private Long gno;
  private String title;
  private String content;
  private String writer;

  public GuestbookModifyDto(Guestbook entity) {
    this.gno = entity.getGno();
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.writer = entity.getWriter();
  }

  public Guestbook toEntity() {
    return Guestbook.builder()
    .gno(gno)
    .title(title)
    .content(content)
    .writer(writer)
    .build();
  }
}
