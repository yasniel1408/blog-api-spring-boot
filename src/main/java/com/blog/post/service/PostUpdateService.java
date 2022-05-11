package com.blog.post.service;

import com.blog.common.service.BaseUpdateService;
import com.blog.post.dao.PostEntityDao;
import com.blog.post.dto.PostServiceRequestDto;
import com.blog.post.repository.IPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Category update service.
 */
@Service
@AllArgsConstructor
public class PostUpdateService extends BaseUpdateService<PostServiceRequestDto> {

    private final IPostRepository iPostRepository;

    @Override
    protected void executeUpdate(PostServiceRequestDto postServiceRequestDto) {
        Optional<PostEntityDao> notificationEntityOptional = iPostRepository.findById(postServiceRequestDto.getId());
        if (notificationEntityOptional.isPresent()) {
            PostEntityDao retrievedPostEntity = notificationEntityOptional.get();
            retrievedPostEntity.setTitle(postServiceRequestDto.getTitle());
            retrievedPostEntity.setImgUrl(postServiceRequestDto.getImgUrl());
            retrievedPostEntity.setDescription(postServiceRequestDto.getDescription());
//            retrievedPostEntity.setCategory_id(postServiceRequestDto.getCategory_id());
            iPostRepository.save(retrievedPostEntity);
        }
    }
}
