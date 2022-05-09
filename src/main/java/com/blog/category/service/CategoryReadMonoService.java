package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.category.repository.ICategoryRepository;
import com.blog.category.service.helper.CategoryResponseCreator;
import com.blog.common.service.BaseReadMonoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Sample read mono service.
 */
@Service
@AllArgsConstructor
public class CategoryReadMonoService extends BaseReadMonoService<CategoryServiceResponseDto> {

    private final ICategoryRepository iCategoryRepository;

    private final CategoryResponseCreator categoryResponseCreator;

    @Override
    protected CategoryServiceResponseDto executeRead(Long id) {
        Optional<CategoryEntityDao> notificationEntityOptional = iCategoryRepository.findById(id);
        CategoryEntityDao categoryEntityDao;
        CategoryServiceResponseDto sampleServiceResponse = null;
        if (notificationEntityOptional.isPresent()) {
            categoryEntityDao = notificationEntityOptional.get();
            sampleServiceResponse = categoryResponseCreator.create(categoryEntityDao);
        }
        return sampleServiceResponse;
    }

}
