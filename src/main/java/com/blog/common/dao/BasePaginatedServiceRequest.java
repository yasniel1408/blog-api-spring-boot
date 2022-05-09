package com.blog.common.dao;

import com.blog.common.config.paginate.PageInformation;
import com.blog.common.dto.BaseServiceRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The type Base service request.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BasePaginatedServiceRequest extends BaseServiceRequestDto {

    private PageInformation pageInformation;

}