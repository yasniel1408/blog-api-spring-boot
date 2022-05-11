package com.blog.post.service;

import com.blog.common.service.BaseCreateService;
import com.blog.post.dao.PostEntityDao;
import com.blog.post.dto.PostServiceRequestDto;
import com.blog.post.dto.PostServiceResponseDto;
import com.blog.post.repository.IPostRepository;
import com.blog.post.service.helper.PostEntityCreator;
import com.blog.post.service.helper.PostResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostCreateService extends BaseCreateService<PostServiceRequestDto, PostServiceResponseDto> {

    private final IPostRepository iPostRepository;

    private final PostResponseCreator postResponseCreator;

    private final PostEntityCreator postEntityCreator;

    @Override
    public PostServiceResponseDto executeCreate(PostServiceRequestDto postServiceRequestDto) {
        PostEntityDao postEntityDaoToBeCreated = postEntityCreator.create(postServiceRequestDto);
        PostEntityDao postEntityDao = iPostRepository.save(postEntityDaoToBeCreated);
        return postResponseCreator.create(postEntityDao);
    }
}
