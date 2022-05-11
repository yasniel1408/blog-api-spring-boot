package com.blog.post.dto;

import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.common.dto.BaseServiceResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * PostReadMonoServiceResponseDto                                                                                                 ponse response to service to create questions.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PostReadMonoServiceResponseDto extends BaseServiceResponseDto {
    private String title;
    private String imgUrl;
    private CategoryServiceResponseDto category;
    private String createdDate;
}
