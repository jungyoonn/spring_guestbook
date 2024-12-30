package com.eeerrorcode.guestbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeerrorcode.guestbook.domain.dto.BoardDto;
import com.eeerrorcode.guestbook.domain.entity.Board;
import com.eeerrorcode.guestbook.repository.BoardRepositoy;

@Service
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepositoy repositoy;

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repositoy.save(board);
    return board.getBno();
  }

  @Override
  public BoardDto get(Long bno) {
    return toDto(repositoy.getBoardByBno(bno));
  }
  
}
