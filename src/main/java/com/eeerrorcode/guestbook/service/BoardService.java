package com.eeerrorcode.guestbook.service;

import com.eeerrorcode.guestbook.domain.dto.BoardDto;
import com.eeerrorcode.guestbook.domain.entity.Board;
import com.eeerrorcode.guestbook.domain.entity.Member;

public interface BoardService {
  default Board toEntity(BoardDto dto) {
    return Board.builder()
    .bno(dto.getBno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .member(Member.builder().email(dto.getMemberEmail()).name(dto.getMemberName()).build())
    .build();
  }

  default BoardDto toDto(Object[] arr) {
    if(arr == null) return null;

    BoardDto.BoardDtoBuilder builder = BoardDto.builder();

    for(Object o : arr) {
      Class<?> cls = o.getClass();

      if(cls == int.class || cls == Integer.class) {

        builder.replyCnt(Integer.parseInt(o.toString()));

      } else if(cls == Member.class) {

        builder.memberEmail(((Member) o).getEmail());
        builder.memberName(((Member) o).getName());

      } else if(cls == Board.class) {

        Board board = (Board) o;
        builder.bno(board.getBno());
        builder.title(board.getTitle());
        builder.content(board.getContent());
        builder.regDate(board.getRegDate());
        builder.modDate(board.getModDate());

      }
    }
    return builder.build();
  }

  Long register(BoardDto dto);

  BoardDto get(Long bno);
}