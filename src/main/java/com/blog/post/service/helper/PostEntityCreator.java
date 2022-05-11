package com.blog.post.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.post.dao.PostEntityDao;
import com.blog.post.dto.PostServiceRequestDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * PostEntityCreator creates post entity save creator.
 */
@Component
@AllArgsConstructor
public class PostEntityCreator {

    private final ModelMapper modelMapper;

    /**
     * Create post entity.
     *
     * @param postServiceRequestDto {@link PostServiceRequestDto} the post create service request
     * @return {@link PostEntityDao} the post entity
     */
    public PostEntityDao create(PostServiceRequestDto postServiceRequestDto) {
        PostEntityDao postEntityDao = null;
        if (postServiceRequestDto != null) {
            postEntityDao = modelMapper.map(postServiceRequestDto, PostEntityDao.class);
            CategoryEntityDao categoryEntityDao = new CategoryEntityDao();
            categoryEntityDao.setId(postServiceRequestDto.getCategoryId());
            categoryEntityDao.setVersion(1L);
            postEntityDao.setCategory(categoryEntityDao);
        }
        return postEntityDao;
    }
}
