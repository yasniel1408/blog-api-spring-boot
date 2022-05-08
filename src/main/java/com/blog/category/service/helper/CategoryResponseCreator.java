package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * The type Sample response creator.
 */
@Component
public class CategoryResponseCreator {

    private final ModelMapper modelMapper;

    /**
     * Instantiates a new Category response creator.
     *
     * @param modelMapper the model mapper
     */
    public CategoryResponseCreator(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    /**
     * Create category service response.
     *
     * @param categoryEntityDao the category entity
     * @return the category service response
     */
    public CategoryServiceResponseDto create(CategoryEntityDao categoryEntityDao) {
        return modelMapper.map(categoryEntityDao, CategoryServiceResponseDto.class);
    }

}
