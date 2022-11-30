package com.pxtwo.book.springboot.web;

import com.pxtwo.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//@RestController 는 선언된 컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어 줌(@ResponseBody 를 메소드마다 쓰는게 아니라, 한번만 쓰게 해줌)
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    //HelloResponseDto 객체를 return 하는 메소드
    //@RequestParam("name") 은 외부에서 "name" 이라고 넘긴 파라미터를 메소드 파라미터 String name 으로 받게해줌
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name,amount);
    }

}
