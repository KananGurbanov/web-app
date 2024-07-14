package az.edu.turinghackaton.service;

import az.edu.turinghackaton.model.dto.PostRequestDto;
import az.edu.turinghackaton.model.dto.PostResponseDto;
import az.edu.turinghackaton.model.enums.Title;

import java.util.List;

public interface PostService {
    void addPost(PostRequestDto postRequestDto);

    List<PostResponseDto> getPosts();

    List<PostResponseDto> getPostsByTitle(Title title);
}
