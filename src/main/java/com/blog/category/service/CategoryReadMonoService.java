package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryReadMonoServiceResponseDto;
import com.blog.category.repository.ICategoryRepository;
import com.blog.category.service.helper.CategoryReadMonoResponseCreator;
import com.blog.common.service.BaseReadMonoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Sample read mono service.
 */
@Service
@AllArgsConstructor
public class CategoryReadMonoService extends BaseReadMonoService<CategoryReadMonoServiceResponseDto> {

    private final ICategoryRepository iCategoryRepository;

    private final CategoryReadMonoResponseCreator categoryResponseCreator;

    @Override
    protected CategoryReadMonoServiceResponseDto executeRead(Long id) {
        Optional<CategoryEntityDao> notificationEntityOptional = iCategoryRepository.findById(id);
        CategoryEntityDao categoryEntityDao;
        CategoryReadMonoServiceResponseDto categoryReadMonoServiceResponseDto = null;
        if (notificationEntityOptional.isPresent()) {
            categoryEntityDao = notificationEntityOptional.get();
            categoryReadMonoServiceResponseDto = categoryResponseCreator.create(categoryEntityDao);
        }
        return categoryReadMonoServiceResponseDto;
    }

}
