package com.blog.common.service;

import com.blog.common.dto.BaseRequestDto;
import com.blog.common.dto.BaseResponseDto;

/**
 * The type Base create service.
 *
 * @param <I> the type parameter
 * @param <O> the type parameter
 */
public abstract class BaseCreateService<I extends BaseRequestDto, O extends BaseResponseDto> extends BaseService {

    /**
     * Execute create o.
     *
     * @param request the request
     * @return the o
     */
    public abstract O create(I request);
}
