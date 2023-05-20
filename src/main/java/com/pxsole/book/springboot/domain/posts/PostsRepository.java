package com.pxsole.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Posts 의 repository 인터페이스로, 기존 MyBatis 에서 DAO(DB Accessing Object)라고 불리는 것과 동일한 역할
//단순히 인터페이스 생성 후, JPARepository<Entity 클래스, PK 타입> 을 상속하면 기본적인 CRUD 가 자동 생성됨
//Entity 와 Entity Repository 는 항상 함께 위치해야 함 (cannot work alone)
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
