package com.blog.category.controller;

import com.blog.category.dto.CategoryServiceRequestDto;
import com.blog.category.service.CategoryUpdateService;
import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseUpdateController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Sample update controller.
 */
@RestController
@RequestMapping(ServiceEndpoints.CATEGORY_ENDPOINT)
@Tag(name = "Category")
public class CategoryUpdateController extends BaseUpdateController<CategoryServiceRequestDto, CategoryUpdateService> {
}
