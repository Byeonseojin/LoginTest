package org.example.logintest.config.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/all")
    public void exAll(){
        log.info("* exAll()메소드 호출됨");
    }
    @GetMapping("/member")
    public void exMember(){
        log.info("** exAll()메소드 호출됨");
    }
    @GetMapping("/admin")
    public void exAdmin(){
        log.info("*** exAll()메소드 호출됨");
    }
}