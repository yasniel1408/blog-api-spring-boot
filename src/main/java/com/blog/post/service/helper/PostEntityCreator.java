package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceRequestDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * CategoryEntityCreator creates category entity save creator.
 */
@Component
@AllArgsConstructor
public class CategoryEntityCreator {

    private final ModelMapper modelMapper;

    /**
     * Create category entity.
     *
     * @param categoryServiceRequestDto {@link CategoryServiceRequestDto} the category create service request
     * @return {@link CategoryEntityDao} the category entity
     */
    public CategoryEntityDao create(CategoryServiceRequestDto categoryServiceRequestDto) {
        CategoryEntityDao categoryEntityDao = null;
        if (categoryServiceRequestDto != null) {
            categoryEntityDao = modelMapper.map(categoryServiceRequestDto, CategoryEntityDao.class);
        }
        return categoryEntityDao;
    }
}
