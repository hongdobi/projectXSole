package com.pxsole.book.springboot.service.posts;

import com.pxsole.book.springboot.domain.posts.PostsRepository;
import com.pxsole.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Autowired 로 Bean 등록하는 대신, @RequiredArgsConstructor 로 Bean 등록!
//@RequiredArgsConstructor 는 final 이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
//Lombok 어노테이션을 사용하면 클래스의 의존성 관계가 변경될 때마다 생성자를 변경해 줄 필요가 없다!
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

}
