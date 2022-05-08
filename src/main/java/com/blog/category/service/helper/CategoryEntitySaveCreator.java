package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryRequestDto;
import com.blog.category.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * CategoryEntitySaveCreator creates category entity save creator.
 */
@Component
@AllArgsConstructor
public class CategoryEntitySaveCreator {

    /**
     * Create category entity.
     *
     * @param request {@link com.blog.category.dto.CategoryRequestDto} the category create service request
     * @return {@link com.blog.category.dao.CategoryEntityDao} the category entity
     */
    CategoryEntityDao create(CategoryRequestDto request) {
        CategoryEntityDao categoryEntityDao = new CategoryEntityDao();
        categoryEntityDao.setName(request.getName());
        return categoryEntityDao;
    }
}
