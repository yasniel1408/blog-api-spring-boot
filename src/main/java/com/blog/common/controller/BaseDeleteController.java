package com.blog.common.controller;

import com.blog.common.service.BaseDeleteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Base delete controller.
 *
 * @param <S> the type parameter
 */
public abstract class BaseDeleteController<S extends BaseDeleteService> extends BaseController<S> {

    /**
     * Delete.
     *
     * @param id the Id
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        logger.entry(id);

        service.delete(id);

        logger.exit();
    }

}
