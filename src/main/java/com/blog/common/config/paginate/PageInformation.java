package com.blog.common.config.paginate;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public final class PageInformation {

    @Min(1)
    private int page;

    @Min(1)
    private int size;

    private SortInformation sortInformation;

    public int getPage() {
        return page - 1;
    }

}
