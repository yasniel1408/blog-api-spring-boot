package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryReadMonoServiceResponseDto;
import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.common.dto.BaseServiceResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * The type Category response creator.
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
        return (CategoryServiceResponseDto) modelMapper.map(categoryEntityDao, BaseServiceResponseDto.class);
    }

}
