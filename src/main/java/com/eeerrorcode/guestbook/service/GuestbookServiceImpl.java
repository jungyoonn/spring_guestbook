package com.eeerrorcode.guestbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eeerrorcode.guestbook.domain.dto.GuestbookListDto;
import com.eeerrorcode.guestbook.domain.dto.GuestbookModifyDto;
import com.eeerrorcode.guestbook.domain.dto.GuestbookViewDto;
import com.eeerrorcode.guestbook.domain.dto.GuestbookWriteDto;
import com.eeerrorcode.guestbook.domain.entity.GuestbookEntity;
import com.eeerrorcode.guestbook.repository.GuestbookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
  private final GuestbookRepository repository;

  public List<GuestbookListDto> list() {
    return repository.findAll().stream().map(GuestbookListDto::new).toList();
  }

  public void write(GuestbookWriteDto dto) {
    repository.save(dto.toEntity());
  }

  public void remove(Long gno) {
    repository.deleteById(gno);
  }

  @Override
  public void modify(GuestbookModifyDto dto) {
    repository.save(dto.toEntity());    
  }

  @Override
  public GuestbookViewDto get(Long gno) {
    Optional<GuestbookEntity> opt = repository.findById(gno);
    if(!opt.isPresent()) {
      return null;
    }
    return new GuestbookViewDto(opt.get());    
  }
}
