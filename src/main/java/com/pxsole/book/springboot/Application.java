package com.pxsole.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication 은 Bean 읽기와 생성을 포함한 스프링부트의 자동설정을 가능하게 해줌
//이 위치부터 설정을 읽어가기 때문에 항상 프로젝트 최상단에 위치해야함 (main 메소드)
@SpringBootApplication
public class Application {

    //SpringApplication.run 은 내장 WAS 를 실행함
    //스프링부트로 만들어진 Jar 파일(실행가능한 JAVA 패키징 파일)로 실행
    //외부 WAS 사용시와 비교하여, 장점은 언제 어디서나 같은 환경에서 스프링부트를 배포할 수 있음
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
