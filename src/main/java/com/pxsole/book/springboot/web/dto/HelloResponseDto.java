package com.pxsole.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//@Getter 는 DTO 내부에 선언된 모든 필드에 대해 get 메소드를 생성해줌
//RequiredArgsConstructor 는 final 로 선언된 필드가 포함된 생성자를 생성해줌 (final 이 아니라면 생성자에 포함되지 않음)
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
