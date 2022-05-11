package com.blog.common.controller;

import com.blog.common.controller.helpers.ResponseEntityCreator;
import com.blog.common.dto.BaseServiceRequestDto;
import com.blog.common.dto.BaseServiceResponseDto;
import com.blog.common.service.BaseReadPolyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
public abstract class BaseReadPolyController<I extends BaseServiceRequestDto, O extends BaseServiceResponseDto, S extends BaseReadPolyService<I, O>> extends BaseController<S> {

    private final ResponseEntityCreator<O> responseEntityCreator;

    /**
     * Gets multiple.
     *
     * @param request             the request
     * @param httpServletResponse the http servlet response
     * @return the multiple
     */
    @GetMapping
    @Operation(summary = "Read poly")
    public ResponseEntity<List<O>> read(I request, HttpServletResponse httpServletResponse) {
        logger.entry(request);

        Page<O> page = service.read(request);

        ResponseEntity<List<O>> responseEntity = responseEntityCreator.create(page, httpServletResponse);

        logger.exit(responseEntity);

        return responseEntity;
    }

}

