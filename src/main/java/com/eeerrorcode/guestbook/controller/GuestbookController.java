package com.eeerrorcode.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eeerrorcode.guestbook.domain.dto.PageRequestDto;
import com.eeerrorcode.guestbook.service.GuestbookService;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("guestbook")
@Log4j2
public class GuestbookController {
  @Autowired
  private GuestbookService service;

  @GetMapping({"", "list"})
  public String list(Model model, PageRequestDto dto) {
    // log.info("?");
    model.addAttribute("result", service.list(dto));
    return "/guestbook/list";
  }
  

}
