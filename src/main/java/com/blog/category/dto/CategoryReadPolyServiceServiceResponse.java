package com.blog.category.dto;

import com.blog.common.dto.BaseServiceResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The category read poly service response.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CategoryReadPolyServiceServiceResponse extends BaseServiceResponseDto {

    private String name;
}
