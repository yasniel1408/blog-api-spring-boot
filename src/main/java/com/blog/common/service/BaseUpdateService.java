package com.blog.common.service;

import com.blog.common.dto.BaseServiceRequestDto;

/**
 * The type Base update service.
 *
 * @param <I> the type parameter
 */
public abstract class BaseUpdateService<I extends BaseServiceRequestDto> extends BaseService {

    /**
     * Update.
     *
     * @param request the request
     */
    public void update(I request) {

        logger.entry(request);

        executeUpdate(request);

        logger.exit();

    }

    /**
     * Execute update.
     *
     * @param request the request
     */
    protected abstract void executeUpdate(I request);
}
