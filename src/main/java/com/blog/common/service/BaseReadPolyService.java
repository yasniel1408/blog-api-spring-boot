package com.blog.common.service;

import com.blog.common.dto.BaseServiceRequestDto;
import com.blog.common.dto.BaseServiceResponseDto;
import org.springframework.data.domain.Page;

/**
 * The type Base read poly service.
 *
 * @param <I> the type parameter
 * @param <O> the type parameter
 */
public abstract class BaseReadPolyService<I extends BaseServiceRequestDto, O extends BaseServiceResponseDto> extends BaseService {

    /**
     * Read page.
     *
     * @param request the request
     * @return the page
     */
    public Page<O> read(I request) {

        logger.entry(request);

        Page<O> responses = executeRead(request);

        logger.exit(responses);

        return responses;
    }

    /**
     * Execute read page.
     *
     * @param request the request
     * @return the page
     */
    protected abstract Page<O> executeRead(I request);
}
