package com.blog.post.service.helper;

import com.blog.post.dao.PostEntityDao;
import com.blog.post.dto.PostServiceResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * The type Post response creator.
 */
@Component
public class PostResponseCreator {

    private final ModelMapper modelMapper;

    /**
     * Instantiates a new Post response creator.
     *
     * @param modelMapper the model mapper
     */
    public PostResponseCreator(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Create post service response.
     *
     * @param postEntityDao the post entity
     * @return the post service response
     */
    public PostServiceResponseDto create(PostEntityDao postEntityDao) {
        return modelMapper.map(postEntityDao, PostServiceResponseDto.class);
    }

}
