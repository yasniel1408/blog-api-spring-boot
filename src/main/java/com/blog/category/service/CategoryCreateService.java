package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceRequestDto;
import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.category.repository.ICategoryRepository;
import com.blog.category.service.helper.CategoryEntityCreator;
import com.blog.category.service.helper.CategoryResponseCreator;
import com.blog.common.service.BaseCreateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryCreateService extends BaseCreateService<CategoryServiceRequestDto, CategoryServiceResponseDto> {

    private final ICategoryRepository iCategoryRepository;

    private final CategoryResponseCreator categoryResponseCreator;

    private final CategoryEntityCreator categoryEntityCreator;

    @Override
    public CategoryServiceResponseDto create(CategoryServiceRequestDto categoryServiceRequestDto) {
        CategoryEntityDao categoryEntityDaoToBeCreated = categoryEntityCreator.create(categoryServiceRequestDto);
        CategoryEntityDao categoryEntityDao = iCategoryRepository.save(categoryEntityDaoToBeCreated);
        return categoryResponseCreator.create(categoryEntityDao);
    }
}
