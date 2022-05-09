package com.blog.common.config.paginate;

import lombok.Data;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.NotBlank;

@Data
class Order {

    @NotBlank
    private String property;

    private Sort.Direction direction;

}
