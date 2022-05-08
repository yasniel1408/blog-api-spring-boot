package com.blog.category.controller;

import com.blog.category.dto.CategoryReadPolyServiceRequest;
import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.category.service.CategoryReadPolyService;
import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseReadPolyController;
import com.blog.common.controller.helpers.ResponseEntityCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Category read poly controller.
 */
@RestController
@RequestMapping(ServiceEndpoints.CATEGORY_ENDPOINT)
//@Tag(name = "Category")
public class CategoryReadPolyController extends BaseReadPolyController<CategoryReadPolyServiceRequest, CategoryServiceResponseDto, CategoryReadPolyService> {

    public CategoryReadPolyController(ResponseEntityCreator<CategoryServiceResponseDto> responseEntityCreator) {
        super(responseEntityCreator);
    }

}
