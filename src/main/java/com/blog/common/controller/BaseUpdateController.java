package com.blog.common.controller;

import com.blog.common.dto.BaseServiceRequestDto;
import com.blog.common.service.BaseUpdateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

/**
 * The type Base update controller.
 *
 * @param <I> the type parameter
 * @param <S> the type parameter
 */
public abstract class BaseUpdateController<I extends BaseServiceRequestDto, S extends BaseUpdateService<I>> extends BaseController<S> {

    /**
     * Update.
     *
     * @param request the request
     */
    @PutMapping
    @Operation(summary = "Update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody I request) {
        service.update(request);
    }

}
