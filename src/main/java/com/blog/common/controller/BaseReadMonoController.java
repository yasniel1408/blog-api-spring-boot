package com.blog.common.controller;

import com.blog.common.dto.BaseServiceResponseDto;
import com.blog.common.service.BaseReadMonoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The type Base read mono controller.
 *
 * @param <O> the type parameter
 * @param <S> the type parameter
 */
@AllArgsConstructor
public abstract class BaseReadMonoController<O extends BaseServiceResponseDto, S extends BaseReadMonoService<O>> extends BaseController<S> {

    /**
     * Read response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/{id}")
    @Operation(summary = "Read Mono")
    public ResponseEntity<O> read(@PathVariable Long id) {
        logger.entry(id);

        O response = service.read(id);

        ResponseEntity<O> responseEntity = responseEntityReadMonoCreator.create(response);

        logger.exit(responseEntity);

        return responseEntity;
    }

}
