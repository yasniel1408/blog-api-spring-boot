package com.blog.category.controller;

import com.blog.category.dto.CategoryRequestDto;
import com.blog.category.dto.CategoryResponseDto;
import com.blog.category.service.CategoryCreateService;
import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseCreateController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * QuestionCreateController creates question
 */
@RestController
@RequestMapping(ServiceEndpoints.CATEGORY_ENDPOINT)
//@Tag(name = "Question")
public class CategoryCreateController extends BaseCreateController<CategoryRequestDto, CategoryResponseDto, CategoryCreateService> {

}
