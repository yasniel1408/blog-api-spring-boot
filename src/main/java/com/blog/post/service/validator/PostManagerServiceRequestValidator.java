package com.blog.post.service.validator;

import com.blog.post.dto.PostServiceRequestDto;
import com.blog.post.repository.IPostRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Category manager service request validator.
 */
@AllArgsConstructor
public class PostManagerServiceRequestValidator implements ConstraintValidator<ValidPostServiceRequest, PostServiceRequestDto> {

    private static final String TITLE_ALREADY_EXISTS = "' title already exists";

    private final IPostRepository iPostRepository;

    @Override
    public boolean isValid(PostServiceRequestDto categoryServiceRequestDto, ConstraintValidatorContext context) {
        boolean isValid = true;

        String postTitle = categoryServiceRequestDto.getTitle();
        if (StringUtils.isNotBlank(postTitle)) {

            Long categoryId = categoryServiceRequestDto.getId();
            //Create case
            if (categoryId == null || categoryId == 0) {
                if (doesNameExist(context, postTitle)) {
                    isValid = false;
                }
                //Update case
            } else {
                if (doesNameExistAndIdIsDifferent(context, postTitle, categoryId)) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    private boolean doesNameExist(ConstraintValidatorContext context, String postTitle) {
        boolean exist = iPostRepository.existsByTitle(postTitle);
        if (exist) {
            setMessage(context, "'" + postTitle + PostManagerServiceRequestValidator.TITLE_ALREADY_EXISTS);
        }
        return exist;
    }

    private boolean doesNameExistAndIdIsDifferent(ConstraintValidatorContext context, String postTitle, Long postId) {
        boolean exist = iPostRepository.existsByTitleAndIdIsNot(postTitle, postId);
        if (exist) {
            setMessage(context, "'" + postTitle + PostManagerServiceRequestValidator.TITLE_ALREADY_EXISTS + " for another category");
        }
        return exist;
    }

    private void setMessage(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }

}
