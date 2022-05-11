package com.blog.post.controller;

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
@RequestMapping(ServiceEndpoints.POST_ENDPOINT)
@Tag(name = "Post")
public class PostDeleteController extends BaseDeleteController<BaseDeleteService> {

}
