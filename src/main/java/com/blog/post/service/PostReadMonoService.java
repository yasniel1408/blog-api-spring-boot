package com.blog.post.service;

import com.blog.common.service.BaseReadMonoService;
import com.blog.post.dao.PostEntityDao;
import com.blog.post.dto.PostReadMonoServiceResponseDto;
import com.blog.post.repository.IPostRepository;
import com.blog.post.service.helper.PostReadMonoResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Post read mono service.
 */
@Service
@AllArgsConstructor
public class PostReadMonoService extends BaseReadMonoService<PostReadMonoServiceResponseDto> {

    private final IPostRepository iPostRepository;

    private final PostReadMonoResponseCreator postReadMonoResponseCreator;

    @Override
    protected PostReadMonoServiceResponseDto executeRead(Long id) {
        Optional<PostEntityDao> notificationEntityOptional = iPostRepository.findById(id);
        PostEntityDao postEntityDao;
        PostReadMonoServiceResponseDto postReadMonoServiceResponseDto = null;
        if (notificationEntityOptional.isPresent()) {
            postEntityDao = notificationEntityOptional.get();
            postReadMonoServiceResponseDto = postReadMonoResponseCreator.create(postEntityDao);
        }
        return postReadMonoServiceResponseDto;
    }

}
