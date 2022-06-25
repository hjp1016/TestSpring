package com.SpringS.springboot.web;

import com.SpringS.springboot.domain.posts.PostsRespository;
import com.SpringS.springboot.domain.posts.PostsService;
import com.SpringS.springboot.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
}
