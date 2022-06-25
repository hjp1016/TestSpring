package com.SpringS.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRespository extends JpaRepository<Posts, Long > {
}
