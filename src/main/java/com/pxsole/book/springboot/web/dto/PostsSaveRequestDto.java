package com.pxsole.book.springboot.web.dto;

import com.pxsole.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Entity 클래스인 Posts 와 거의 유사함에도 Dto 를 생성한 이유 :
//Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경되는데, 만약 사소한 화면 변경을 위해
//Entity 클래스를 변경한다면, 이는 너무 큰 변경으로 이어진다. (waste)
//Dto 는 순전히 View 만을 위한 클래스이므로, 자주 변경이 필요함
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
