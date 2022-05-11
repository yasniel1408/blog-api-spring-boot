package com.blog.post.dto;

import com.blog.category.dto.CategoryServiceResponseDto;
import com.blog.common.dto.BaseServiceResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * QuestionCreateServiceRes                                                                                                 ponse response to service to create questions.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PostServiceResponseDto extends BaseServiceResponseDto {
    private String title;
    private String imgUrl;
    private String description;
    private CategoryServiceResponseDto category;
}
