package com.eeerrorcode.guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("guestbook")
// @Log4j2
public class GuestbookController {
  @GetMapping({"", "list"})
  public String list() {
    // log.info("?");
    return "/guestbook/list";
  }
  
}
