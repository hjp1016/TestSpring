package com.SpringS.springboot.domain.posts;

import com.SpringS.springboot.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRespository postsRespository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postsRespository.save(requestDto.toEntity()).getId();
    }
}
