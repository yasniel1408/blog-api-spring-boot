package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceRequestDto;
import com.blog.category.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * QuestionEntitySaver saves a question with your possible answers.
 */
@Component
@AllArgsConstructor
public class CategoryEntitySaver {

    private final ICategoryRepository iCategoryRepository;

    private final CategoryEntityCreator categoryEntityCreator;

    /**
     * Save question entity.
     *
     * @param request {@link CategoryServiceRequestDto} the question create service request
     * @return {@link CategoryEntityDao} the question entity
     */
    public CategoryEntityDao save(CategoryServiceRequestDto request) {
        CategoryEntityDao categoryEntityDao = categoryEntityCreator.create(request);
        return iCategoryRepository.save(categoryEntityDao);
    }

}
