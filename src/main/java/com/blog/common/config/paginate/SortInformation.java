package com.blog.common.config.paginate;

import lombok.Data;

import java.util.List;

@Data
public class SortInformation {

    private List<Order> orders;
}
