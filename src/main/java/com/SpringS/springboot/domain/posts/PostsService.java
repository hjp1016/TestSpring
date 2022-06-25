package com.SpringS.springboot.domain.posts;

import com.SpringS.springboot.web.dto.PostsListResponseDto;
import com.SpringS.springboot.web.dto.PostsResponseDto;
import com.SpringS.springboot.web.dto.PostsSaveRequestDto;
import com.SpringS.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRespository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){

        return postsRespository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRespository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRespository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRespository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRespository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id=" + id));

        postsRespository.delete(posts);
    }
}
