package az.edu.turinghackaton.controller;


import az.edu.turinghackaton.model.dto.PostRequestDto;
import az.edu.turinghackaton.model.dto.PostResponseDto;
import az.edu.turinghackaton.model.dto.RestResponse;
import az.edu.turinghackaton.model.enums.Title;
import az.edu.turinghackaton.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class PostController {
    private final PostService postService;

    @GetMapping()
    public ResponseEntity<RestResponse<List<PostResponseDto>>> getPosts() {
        List<PostResponseDto> posts = postService.getPosts();

        RestResponse<List<PostResponseDto>> restResponse = RestResponse.<List<PostResponseDto>>builder()
                .status("SUCCESS")
                .data(posts)
                .build();
        return ResponseEntity.ok(restResponse);
    }

    @PostMapping()
    public ResponseEntity<Void> login(@RequestBody @Valid PostRequestDto postRequestDto) {
        postService.addPost(postRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<RestResponse<List<PostResponseDto>>> getPostsByTitle(@RequestParam Title title) {
        List<PostResponseDto> posts = postService.getPostsByTitle(title);

        RestResponse<List<PostResponseDto>> restResponse = RestResponse.<List<PostResponseDto>>builder()
                .status("SUCCESS")
                .data(posts)
                .build();
        return ResponseEntity.ok(restResponse);
    }


}
