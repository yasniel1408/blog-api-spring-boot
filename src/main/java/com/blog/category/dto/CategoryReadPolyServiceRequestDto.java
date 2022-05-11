package com.blog.category.dto;

import com.blog.common.dao.BasePaginatedServiceRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The type Category Paginated service request.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class CategoryReadPolyServiceRequestDto extends BasePaginatedServiceRequest {
}
