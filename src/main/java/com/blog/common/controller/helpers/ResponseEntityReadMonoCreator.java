package com.blog.common.controller.helpers;

import com.blog.common.dto.BaseServiceResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityReadMonoCreator {

    public <O extends BaseServiceResponseDto> ResponseEntity<O> create(O response) {
        return response == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(response);
    }
}
