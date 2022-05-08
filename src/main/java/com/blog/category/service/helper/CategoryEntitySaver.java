package com.blog.category.service.helper;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryRequestDto;
import com.blog.category.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * QuestionEntitySaver saves a question with your possible answers.
 */
@Component
@AllArgsConstructor
public class CategoryEntitySaver {

    private final ICategoryRepository iCategoryRepository;

    private final CategoryEntitySaveCreator categoryEntitySaveCreator;

    /**
     * Save question entity.
     *
     * @param request {@link CategoryRequestDto} the question create service request
     * @return {@link CategoryEntityDao} the question entity
     */
    public CategoryEntityDao save(CategoryRequestDto request) {
        CategoryEntityDao categoryEntityDao = categoryEntitySaveCreator.create(request);
        return iCategoryRepository.save(categoryEntityDao);
    }

}
