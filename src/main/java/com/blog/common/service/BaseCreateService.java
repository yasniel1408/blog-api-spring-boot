package com.blog.common.service;

import com.blog.common.dto.BaseServiceRequestDto;
import com.blog.common.dto.BaseServiceResponseDto;

/**
 * The type Base create service.
 *
 * @param <I> the type parameter
 * @param <O> the type parameter
 */
public abstract class BaseCreateService<I extends BaseServiceRequestDto, O extends BaseServiceResponseDto> extends BaseService {

    /**
     * Create o.
     *
     * @param request the request
     * @return the o
     */
    public O create(I request) {

        logger.entry(request);

        O response = executeCreate(request);

        logger.exit(response);

        return response;
    }

    /**
     * Execute create o.
     *
     * @param request the request
     * @return the o
     */
    protected abstract O executeCreate(I request);
}
