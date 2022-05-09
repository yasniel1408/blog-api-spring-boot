package com.blog.common.controller.helpers;

import com.blog.common.config.paginate.ResponseHeaders;
import com.blog.common.dto.BaseServiceResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class ResponseEntityCreator<O extends BaseServiceResponseDto> {

    public final ResponseEntity<List<O>> create(Page<O> page, HttpServletResponse httpServletResponse) {
        ResponseEntity<List<O>> responseEntity;

        List<O> pageContent = null;
        if (page != null) {
            pageContent = page.getContent();
        }
        if (page == null || CollectionUtils.isEmpty(pageContent)) {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            setPaginationHeaders(page, httpServletResponse);
            responseEntity = new ResponseEntity<>(pageContent, HttpStatus.OK);
        }
        return responseEntity;
    }

    private void setPaginationHeaders(Page<O> page, HttpServletResponse httpServletResponse) {
        if (page != null && !CollectionUtils.isEmpty(page.getContent())) {
            httpServletResponse.setHeader(ResponseHeaders.SIZE.getName(), String.valueOf(page.getSize()));
            httpServletResponse.setHeader(ResponseHeaders.PAGE.getName(), String.valueOf(page.getNumber() + 1));
            httpServletResponse.setHeader(ResponseHeaders.TOTAL_RESULTS_COUNT.getName(), String.valueOf(page.getTotalElements()));
        }
    }

}
