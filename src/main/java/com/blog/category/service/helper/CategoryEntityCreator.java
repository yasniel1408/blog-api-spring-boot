package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * CategoryEntityCreator creates category entity save creator.
 */
@Component
@AllArgsConstructor
public class CategoryEntityCreator {

    /**
     * Create category entity.
     *
     * @param request {@link CategoryServiceRequestDto} the category create service request
     * @return {@link com.blog.category.dao.CategoryEntityDao} the category entity
     */
    CategoryEntityDao create(CategoryServiceRequestDto request) {
        CategoryEntityDao categoryEntityDao = new CategoryEntityDao();
        categoryEntityDao.setName(request.getName());
        return categoryEntityDao;
    }
}
