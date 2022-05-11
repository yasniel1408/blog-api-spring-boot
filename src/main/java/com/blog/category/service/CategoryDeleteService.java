package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.repository.ICategoryRepository;
import com.blog.common.service.BaseDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The type Sample delete service.
 */
@Service
@AllArgsConstructor
public class CategoryDeleteService extends BaseDeleteService<CategoryEntityDao, ICategoryRepository> {

    private final ICategoryRepository iCategoryRepository;

    @Override
    protected void executeDelete(Long id) {
        if (iCategoryRepository.existsById(id)) {
            iCategoryRepository.deleteById(id);
        }
    }

}
