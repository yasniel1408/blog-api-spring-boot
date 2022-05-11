package com.blog.category.controller;

import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseDeleteController;
import com.blog.common.service.BaseDeleteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Category delete controller.
 */
@RestController
@RequestMapping(ServiceEndpoints.CATEGORY_ENDPOINT)
@Tag(name = "Category")
public class CategoryDeleteController extends BaseDeleteController<BaseDeleteService> {

}
