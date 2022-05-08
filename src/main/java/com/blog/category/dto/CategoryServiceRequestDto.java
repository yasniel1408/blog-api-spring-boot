package com.blog.category.dto;

import com.blog.common.dto.BaseServiceRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * CategoryServiceRequestDto requests from the service to create category
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryServiceRequestDto extends BaseServiceRequestDto {
    private String name;
}
