package com.blog.common.config.paginate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseHeaders {

    PAGE("Page"), SIZE("Size"), TOTAL_RESULTS_COUNT("Total-Results-Count");

    /**
     * Name of the exposed header.
     */
    private String name;

}
