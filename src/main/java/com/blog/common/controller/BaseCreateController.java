package com.blog.common.controller;

import com.blog.common.dto.BaseServiceRequestDto;
import com.blog.common.dto.BaseServiceResponseDto;
import com.blog.common.service.BaseCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * The type Base create controller.
 *
 * @param <I> the type parameter
 * @param <O> the type parameter
 * @param <S> the type parameter
 */
public abstract class BaseCreateController<I extends BaseServiceRequestDto, O extends BaseServiceResponseDto, S extends BaseCreateService<I, O>> extends BaseController<S> {

    /**
     * Create response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping
//    @Operation(summary = "Create")
    public ResponseEntity<O> create(@Valid @RequestBody I request) {
        O response = service.create(request);
        ResponseEntity<O> responseEntity = createPostResponseEntity(response);
        return responseEntity;
    }

    /**
     * Create post response entity response entity.
     *
     * @param response the response
     * @return the response entity
     */
    private ResponseEntity<O> createPostResponseEntity(O response) {
        ResponseEntity<O> responseEntity;
        if (response != null) {
            Long id = response.getId();
            if (id != null && id != 0) {
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
                responseEntity = createResponseEntity(location, response);
            } else {
                responseEntity = ResponseEntity.ok(response);
            }
        } else {
            responseEntity = ResponseEntity.noContent().build();
        }

        return responseEntity;
    }

    private ResponseEntity<O> createResponseEntity(URI location, O response) {
        return ResponseEntity.created(location).body(response);
    }

}
