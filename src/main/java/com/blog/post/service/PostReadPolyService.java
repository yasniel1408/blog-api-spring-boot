package com.blog.post.service;

import com.blog.common.config.paginate.PageInformation;
import com.blog.common.service.BaseReadPolyService;
import com.blog.post.dao.PostEntityDao;
import com.blog.post.dto.PostReadPolyServiceRequestDto;
import com.blog.post.dto.PostServiceResponseDto;
import com.blog.post.repository.IPostRepository;
import com.blog.post.service.helper.PostResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The post read poly service
 */
@Service
@AllArgsConstructor
public class PostReadPolyService extends BaseReadPolyService<PostReadPolyServiceRequestDto, PostServiceResponseDto> {

    private final IPostRepository iPostRepository;

    private final PostResponseCreator postResponseCreator;

    @Override
    protected Page<PostServiceResponseDto> executeRead(PostReadPolyServiceRequestDto postReadPolyServiceRequestDto) {
        PageInformation pageInformation = postReadPolyServiceRequestDto.getPageInformation();
        int pageNumber = 0;
        int pageSize = 25;
        if (pageInformation != null) {
            pageNumber = pageInformation.getPage();
            pageSize = pageInformation.getSize();
        }
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<PostEntityDao> notificationEntityPage = iPostRepository.findAll(pageable);
        Page<PostServiceResponseDto> postServiceResponsePage = null;
        if (notificationEntityPage.hasContent()) {
            List<PostServiceResponseDto> postServiceResponseDtoList = new ArrayList<>();
            notificationEntityPage.forEach(notificationEntity -> postServiceResponseDtoList.add(postResponseCreator.create(notificationEntity)));
            postServiceResponsePage = new PageImpl<>(postServiceResponseDtoList, PageRequest.of(notificationEntityPage.getNumber(), notificationEntityPage.getSize()), notificationEntityPage.getTotalElements());
        }
        return postServiceResponsePage;
    }
}
