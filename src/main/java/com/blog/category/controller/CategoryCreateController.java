package com.blog.category.controller;

import com.blog.category.dto.CategoryServiceRequestDto;
import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.category.service.CategoryCreateService;
import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseCreateController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * QuestionCreateController creates question
 */
@RestController
@RequestMapping(ServiceEndpoints.CATEGORY_ENDPOINT)
@Tag(name = "Category")
public class CategoryCreateController extends BaseCreateController<CategoryServiceRequestDto, CategoryServiceResponseDto, CategoryCreateService> {

}
