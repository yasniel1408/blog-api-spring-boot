package com.blog.common.service;

import com.blog.common.dto.BaseServiceResponseDto;

/**
 * The type Base read mono service.
 *
 * @param <O> the type parameter
 */
public abstract class BaseReadMonoService<O extends BaseServiceResponseDto> extends BaseService {

    /**
     * Read o.
     *
     * @param id the id
     * @return the o
     */
    public O read(Long id) {

        logger.entry(id);

        O response = executeRead(id);

        logger.exit(response);

        return response;
    }

    /**
     * Execute read o.
     *
     * @param id the id
     * @return the o
     */
    protected abstract O executeRead(Long id);

}
