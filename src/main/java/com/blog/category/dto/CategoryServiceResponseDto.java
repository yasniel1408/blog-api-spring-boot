package com.blog.category.dto;

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
public class CategoryServiceResponseDto extends BaseServiceResponseDto {
    private String name;
    private String description;
    private String createdDate;
}
