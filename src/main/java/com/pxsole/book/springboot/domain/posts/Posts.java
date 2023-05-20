package com.pxsole.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@NoArgsConstructor 는 파라미터가 없는 "기본 생성자"를 생성
//@AllArgsConstructor 는 모든 필드값을 파라미터로 받는 생성자를 생성
//@RequiredArgsConstructor 는 final 이나 @nonNull 인 필드값만 파라미터로 받는 생성자를 생성
//@Getter 와 @NoArgsConstructor 는 lombok 어노테이션
//@Entity 는 JPA 어노테이션으로, 테이블과 링크될 클래스임을 나타냄
//@Setter 가 없는 이유 :
//=> Setter 로 클래스의 인스턴스 값들을 직접 변경하다보면, 언제 어디서 변해야하는지 코드상으로 명확하게 구분이 안됨
//=> 명확한 목적과 의도를 가진 메소드를 사용하여, 인스턴스 값을 변경하는 것을 추천
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    //@GeneratedValue 는 PK의 생성규칙을 나타냄
    //GenerationType.IDENTITY 를 추가해야만 auto_increment 가 됨
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column 은 테이블의 컬럼을 나타내며, 기본값 외에 추가로 변경이 필요한 옵션을 나타내고자 사용 (length 나, TEXT 속성 등)
    //=> 굳이 선언하지 않더라도 모든 필드는 컬럼으로 사용됨
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //@Builder 는 해당 클래스의 빌더 패턴 클래스를 생성
    //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

}
