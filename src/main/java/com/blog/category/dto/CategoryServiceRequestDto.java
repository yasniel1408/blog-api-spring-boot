package com.blog.category.dto;

import com.blog.category.service.validator.ValidCactegoryServiceRequest;
import com.blog.common.dto.BaseServiceRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * CategoryServiceRequestDto requests from the service to create category
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ValidCactegoryServiceRequest
public class CategoryServiceRequestDto extends BaseServiceRequestDto {

    @NotNull
    private String name;

    private String description;
}
