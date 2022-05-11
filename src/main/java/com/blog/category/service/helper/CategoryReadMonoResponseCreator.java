package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryReadMonoServiceResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * The type Category response creator.
 */
@Component
public class CategoryReadMonoResponseCreator {

    private final ModelMapper modelMapper;

    /**
     * Instantiates a new Category response creator.
     *
     * @param modelMapper the model mapper
     */
    public CategoryReadMonoResponseCreator(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Create category service response.
     *
     * @param categoryEntityDao the category entity
     * @return the category service response
     */
    public CategoryReadMonoServiceResponseDto create(CategoryEntityDao categoryEntityDao) {
        return modelMapper.map(categoryEntityDao, CategoryReadMonoServiceResponseDto.class);
    }

}
