package com.blog.category.dto;

import com.blog.common.dto.BaseResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * QuestionCreateServiceRes                                                                                                 ponse response to service to create questions.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryResponseDto extends BaseResponseDto {
    private String name;
}
