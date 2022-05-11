package com.blog.post.dto;

import com.blog.common.dao.BasePaginatedServiceRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The type Post Paginated service request.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class PostReadPolyServiceRequestDto extends BasePaginatedServiceRequest {
}
