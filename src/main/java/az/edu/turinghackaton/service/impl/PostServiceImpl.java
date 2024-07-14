package az.edu.turinghackaton.service.impl;

import az.edu.turinghackaton.dao.entity.PostEntity;
import az.edu.turinghackaton.dao.repository.PostRepository;
import az.edu.turinghackaton.model.dto.PostRequestDto;
import az.edu.turinghackaton.model.dto.PostResponseDto;
import az.edu.turinghackaton.model.enums.Title;
import az.edu.turinghackaton.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Transactional
    @Override
    public void addPost(PostRequestDto dto) {
        PostEntity entity = new PostEntity();
        entity.setTitle(dto.title());
        entity.setDescription(dto.description());
        entity.setCompany(dto.company());
        entity.setCompanyImage(Base64.getDecoder().decode(dto.companyImage()));
        entity.setLocation(dto.location());
        entity.setJobType(dto.jobType());
        entity.setApplicationDeadline(dto.applicationDeadline());

        postRepository.save(entity);
    }

    @Override
    public List<PostResponseDto> getPosts() {
        List<PostEntity> all = postRepository.findAll();
        return all.stream().map(postEntity -> PostResponseDto.builder()
                .title(postEntity.getTitle())
                .description(postEntity.getDescription())
                .company(postEntity.getCompany())
                .companyImage(Base64.getEncoder().encodeToString(postEntity.getCompanyImage()))
                .jobType(postEntity.getJobType())
                .location(postEntity.getLocation())
                .applicationDeadline(postEntity.getApplicationDeadline())
                .build()).toList();
    }

    @Transactional
    @Override
    public List<PostResponseDto> getPostsByTitle(Title title) {
        List<PostEntity> all = postRepository.findByTitle(title);
        return all.stream().map(postEntity -> PostResponseDto.builder()
                .title(postEntity.getTitle())
                .description(postEntity.getDescription())
                .company(postEntity.getCompany())
                .companyImage(Base64.getEncoder().encodeToString(postEntity.getCompanyImage()))
                .jobType(postEntity.getJobType())
                .location(postEntity.getLocation())
                .applicationDeadline(postEntity.getApplicationDeadline())
                .build()).toList();
    }
}
