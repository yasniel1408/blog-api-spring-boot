package com.blog.post.controller;

import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseCreateController;
import com.blog.post.dto.PostServiceRequestDto;
import com.blog.post.dto.PostServiceResponseDto;
import com.blog.post.service.PostCreateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * QuestionCreateController creates question
 */
@RestController
@RequestMapping(ServiceEndpoints.POST_ENDPOINT)
@Tag(name = "Post")
public class PostCreateController extends BaseCreateController<PostServiceRequestDto, PostServiceResponseDto, PostCreateService> {

}
