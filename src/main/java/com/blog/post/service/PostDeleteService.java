package com.blog.post.service;

import com.blog.common.service.BaseDeleteService;
import com.blog.post.dao.PostEntityDao;
import com.blog.post.repository.IPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Post delete service.
 */
@Service
@AllArgsConstructor
public class PostDeleteService extends BaseDeleteService<PostEntityDao, IPostRepository > {

    private final IPostRepository iPostRepository;

    @Override
    protected void executeDelete(Long id) {
        if (iPostRepository.existsById(id)) {
            iPostRepository.deleteById(id);
        }
    }

}
