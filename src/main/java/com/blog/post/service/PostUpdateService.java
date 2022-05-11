package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceRequestDto;
import com.blog.category.repository.ICategoryRepository;
import com.blog.common.service.BaseUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Category update service.
 */
@Service
@AllArgsConstructor
public class CategoryUpdateService extends BaseUpdateService<CategoryServiceRequestDto> {

    private final ICategoryRepository iCategoryRepository;

    @Override
    protected void executeUpdate(CategoryServiceRequestDto categoryServiceRequestDto) {
        Optional<CategoryEntityDao> notificationEntityOptional = iCategoryRepository.findById(categoryServiceRequestDto.getId());
        if (notificationEntityOptional.isPresent()) {
            CategoryEntityDao retrievedSampleEntity = notificationEntityOptional.get();
            retrievedSampleEntity.setName(categoryServiceRequestDto.getName());
            retrievedSampleEntity.setDescription(categoryServiceRequestDto.getDescription());
            iCategoryRepository.save(retrievedSampleEntity);
        }
    }
}
