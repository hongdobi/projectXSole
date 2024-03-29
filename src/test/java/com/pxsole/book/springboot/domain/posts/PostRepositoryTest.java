package com.pxsole.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //Junit 에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
    //보통 통합 테스트를 수행할 때 테스트간 데이터 침범을 막기위해 사용
    //여러 테스트를 동시에 수행하면 테이트용 DB인 H2 에 데이터가 그대로 나마 다음 테스트 실행시 테스트 실패할 수 있음
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //save : 테이블 posts에 insert/update 쿼리 실행
        //id값이 있다면 update, 없으면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hongdobi@gmail.com")
                .build());

        //findAll : 테이블 posts에 있는 모든 데이터를 조회
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2023,12,23,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> createDate=" + posts.getCreatedDate()+ ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
