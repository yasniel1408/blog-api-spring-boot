package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceRequestDto;
import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.category.service.helper.CategoryEntitySaver;
import com.blog.common.service.BaseCreateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryCreateService extends BaseCreateService<CategoryServiceRequestDto, CategoryServiceResponseDto> {

    private final CategoryEntitySaver categoryEntitySaver;

    @Override
    public CategoryServiceResponseDto create(CategoryServiceRequestDto request) {
        CategoryServiceResponseDto categoryResponseDto = new CategoryServiceResponseDto();
        CategoryEntityDao categoryEntityDao = categoryEntitySaver.save(request);
        categoryResponseDto.setId(categoryEntityDao.getId());
        return categoryResponseDto;
    }
}
