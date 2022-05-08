package com.blog.category.dto;

import com.blog.common.dto.BaseRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * CategoryRequestDto requests from the service to create category
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryRequestDto extends BaseRequestDto {
    private String name;
}
