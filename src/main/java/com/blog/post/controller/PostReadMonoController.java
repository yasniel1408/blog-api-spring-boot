package com.blog.post.controller;

import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseReadMonoController;
import com.blog.post.dto.PostReadMonoServiceResponseDto;
import com.blog.post.service.PostReadMonoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Category read mono controller.
 */
@RestController
@RequestMapping(ServiceEndpoints.POST_ENDPOINT)
@Tag(name = "Post")
public class PostReadMonoController extends BaseReadMonoController<PostReadMonoServiceResponseDto, PostReadMonoService> {
}
