package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryRequestDto;
import com.blog.category.dto.CategoryResponseDto;
import com.blog.category.service.helper.CategoryEntitySaver;
import com.blog.common.service.BaseCreateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryCreateService extends BaseCreateService<CategoryRequestDto, CategoryResponseDto> {

    private final CategoryEntitySaver categoryEntitySaver;

    @Override
    public CategoryResponseDto create(CategoryRequestDto request) {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        CategoryEntityDao categoryEntityDao = categoryEntitySaver.save(request);
        categoryResponseDto.setId(categoryEntityDao.getId());
        return categoryResponseDto;
    }
}
