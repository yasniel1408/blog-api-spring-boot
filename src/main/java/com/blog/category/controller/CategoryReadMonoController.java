package com.blog.category.controller;

import com.blog.category.dto.CategoryReadMonoServiceResponseDto;
import com.blog.category.service.CategoryReadMonoService;
import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseReadMonoController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Category read mono controller.
 */
@RestController
@RequestMapping(ServiceEndpoints.CATEGORY_ENDPOINT)
@Tag(name = "Category")
public class SampleReadMonoController extends BaseReadMonoController<CategoryReadMonoServiceResponseDto, CategoryReadMonoService> {
}
