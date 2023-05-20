package com.pxsole.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@RunWith 는 테스트할 때 JUnit 의 실행자 외에 다른 실행자를 실행함(여기서는 SpringRunner 를 같이 실행)
//@WebMvcTest 는 Web(Spring MVC)에 집중할 수 있는 어노테이션
//선언할 경우, @Controller, @ControllerAdvice 등을 사용가능, 그러나 @Service, @Component, @Repository 등은 사용불가 
//컨트롤러만 사용하기 때문에 선언
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    //@Autowired 는 스프링 Bean 으로 등록시켜 줌
    //MockMvc 는 웹 API를 테스트할 때, 스프링 MVC 테스트의 시작점(HTTP GET, POST 등의 API 테스트를 할 수 있음)
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String greetings = "hello";

        //get 은 HTTP GET 메소드를 뜻함
        //status().isOk() 는 200 인가를 검증
        //content().string(greetings) 는 응답 본문의 내용을 검증
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(greetings));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        //param 은 API 테스트에 사용될 요청 파라미터를 뜻함 (단, String 만 지원되므로 형변환 필수)
        //jsonPath 는 JSON 응답값을 필드별로 검증하는 메소드 ($ 를 기준으로 필드명을 명시함)
        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
