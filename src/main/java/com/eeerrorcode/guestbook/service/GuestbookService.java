package com.eeerrorcode.guestbook.service;

import java.util.List;

import com.eeerrorcode.guestbook.domain.dto.GuestbookListDto;
import com.eeerrorcode.guestbook.domain.dto.GuestbookModifyDto;
import com.eeerrorcode.guestbook.domain.dto.GuestbookViewDto;
import com.eeerrorcode.guestbook.domain.dto.GuestbookWriteDto;

public interface GuestbookService {
  void write(GuestbookWriteDto dto);
  void modify(GuestbookModifyDto dto);
  void remove(Long gno);

  List<GuestbookListDto> list();
  GuestbookViewDto get(Long gno);
}
