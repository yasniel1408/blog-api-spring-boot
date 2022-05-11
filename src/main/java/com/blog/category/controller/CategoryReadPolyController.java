package com.blog.category.controller;

import com.blog.category.dto.CategoryReadPolyServiceRequestDto;
import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.category.service.CategoryReadPolyService;
import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseReadPolyController;
import com.blog.common.controller.helpers.ResponseEntityCreator;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Category read poly controller.
 */
@RestController
@RequestMapping(ServiceEndpoints.CATEGORY_ENDPOINT)
@Tag(name = "Category")
public class CategoryReadPolyController extends BaseReadPolyController<CategoryReadPolyServiceRequestDto, CategoryServiceResponseDto, CategoryReadPolyService> {

    public CategoryReadPolyController(ResponseEntityCreator<CategoryServiceResponseDto> responseEntityCreator) {
        super(responseEntityCreator);
    }

}
