package com.blog.post.dto;

import com.blog.common.dto.BaseServiceRequestDto;
import com.blog.post.service.validator.ValidPostServiceRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * PostServiceRequestDto requests from the service to create post
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ValidPostServiceRequest
public class PostServiceRequestDto extends BaseServiceRequestDto {

    @NotNull
    private String title;

    private String imgUrl;

    private String description;

    @NotNull
    private Long categoryId;

}
