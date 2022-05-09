package com.blog.category.service;

import com.blog.category.dao.CategoryEntityDao;
import com.blog.category.dto.CategoryServiceResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.blog.category.dto.CategoryReadPolyServiceRequest;
import com.blog.category.service.helper.CategoryResponseCreator;
import com.blog.common.config.paginate.PageInformation;
import com.blog.common.service.BaseReadPolyService;
import lombok.AllArgsConstructor;
import com.blog.category.repository.ICategoryRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The category read poly service
 */
@Service
@AllArgsConstructor
public class CategoryReadPolyService extends BaseReadPolyService<CategoryReadPolyServiceRequest, CategoryServiceResponseDto> {

    private final ICategoryRepository iCategoryRepository;

    private final CategoryResponseCreator categoryResponseCreator;

    @Override
    protected Page<CategoryServiceResponseDto> executeRead(CategoryReadPolyServiceRequest categoryReadPolyServiceRequest) {
        PageInformation pageInformation = categoryReadPolyServiceRequest.getPageInformation();
        int pageNumber = 0;
        int pageSize = 25;
        if (pageInformation != null) {
            pageNumber = pageInformation.getPage();
            pageSize = pageInformation.getSize();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<CategoryEntityDao> notificationEntityPage = iCategoryRepository.findAll(pageable);
        Page<CategoryServiceResponseDto> categoryServiceResponsePage = null;
        if (notificationEntityPage.hasContent()) {
            List<CategoryServiceResponseDto> categoryServiceResponseDtoList = new ArrayList<>();
            notificationEntityPage.forEach(notificationEntity -> categoryServiceResponseDtoList.add(categoryResponseCreator.create(notificationEntity)));
            categoryServiceResponsePage = new PageImpl<>(categoryServiceResponseDtoList, PageRequest.of(notificationEntityPage.getNumber(), notificationEntityPage.getSize()), notificationEntityPage.getTotalElements());
        }
        return categoryServiceResponsePage;
    }
}
