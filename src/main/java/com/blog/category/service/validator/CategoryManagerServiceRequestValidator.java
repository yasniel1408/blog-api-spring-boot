package com.blog.category.service.validator;

import com.blog.category.dto.CategoryServiceRequestDto;
import com.blog.category.repository.ICategoryRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Sample manager service request validator.
 */
@AllArgsConstructor
public class CategoryManagerServiceRequestValidator implements ConstraintValidator<ValidSampleServiceRequest, CategoryServiceRequestDto> {

    private static final String NAME_ALREADY_EXISTS = "' name already exists";

    private final ICategoryRepository iCategoryRepository;

    @Override
    public boolean isValid(CategoryServiceRequestDto categoryServiceRequestDto, ConstraintValidatorContext context) {
        boolean isValid = true;

        String categoryName = categoryServiceRequestDto.getName();
        if (StringUtils.isNotBlank(categoryName)) {

            Long categoryId = categoryServiceRequestDto.getId();
            //Create case
            if (categoryId == null || categoryId == 0) {
                if (doesNameExist(context, categoryName)) {
                    isValid = false;
                }
                //Update case
            } else {
                if (doesNameExistAndIdIsDifferent(context, categoryName, categoryId)) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    private boolean doesNameExist(ConstraintValidatorContext context, String categoryName) {
        boolean exist = iCategoryRepository.existsByName(categoryName);
        if (exist) {
            setMessage(context, "'" + categoryName + CategoryManagerServiceRequestValidator.NAME_ALREADY_EXISTS);
        }
        return exist;
    }

    private boolean doesNameExistAndIdIsDifferent(ConstraintValidatorContext context, String categoryName, Long sampleId) {
        boolean exist = iCategoryRepository.existsByNameAndIdIsNot(categoryName, sampleId);
        if (exist) {
            setMessage(context, "'" + categoryName + CategoryManagerServiceRequestValidator.NAME_ALREADY_EXISTS + " for another sample");
        }
        return exist;
    }

    private void setMessage(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
    }

}
