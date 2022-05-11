package com.blog.post.controller;

import com.blog.common.config.ServiceEndpoints;
import com.blog.common.controller.BaseReadPolyController;
import com.blog.common.controller.helpers.ResponseEntityCreator;
import com.blog.post.dto.PostReadPolyServiceRequestDto;
import com.blog.post.dto.PostServiceResponseDto;
import com.blog.post.service.PostReadPolyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Category read poly controller.
 */
@RestController
@RequestMapping(ServiceEndpoints.POST_ENDPOINT)
@Tag(name = "Post")
public class PostReadPolyController extends BaseReadPolyController<PostReadPolyServiceRequestDto, PostServiceResponseDto, PostReadPolyService> {

    public PostReadPolyController(ResponseEntityCreator<PostServiceResponseDto> responseEntityCreator) {
        super(responseEntityCreator);
    }

}
