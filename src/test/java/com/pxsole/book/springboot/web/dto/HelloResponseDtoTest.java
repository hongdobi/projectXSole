package com.pxsole.book.springboot.web.dto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        //assertThat 은 assertj 라이브러리의 테스트 검증 메소드
        //Junit 의 assertThat 과는 달리, 추가 라이브러리가 필요하지 않음
        //자동완성이 더 잘되서 더 편함
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
