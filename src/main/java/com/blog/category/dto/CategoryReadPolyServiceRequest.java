package com.blog.category.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The type Sample Paginated service request.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class CategoryReadPolyServiceRequest extends BasePaginatedServiceRequest {
}
