package org.geektimes.projects.user.validator.bean.validation;

import org.apache.commons.lang.StringUtils;
import org.geektimes.projects.user.domain.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.util.regex.Pattern;

public class UserValidAnnotationValidator implements ConstraintValidator<UserValid, User> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(\\S+)$");

    private int idRange;
    private int minPasswordLength;
    private int maxPasswordLength;

    @Override
    public void initialize(UserValid annotation) {
        this.idRange = annotation.idRange();
        if (annotation.minPasswordLength() > annotation.maxPasswordLength()) {
            throw new ValidationException("password length range is valid!");
        }
        this.minPasswordLength = annotation.minPasswordLength();
        this.maxPasswordLength = annotation.maxPasswordLength();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        boolean isIdValid = value.getId() != null && value.getId() > idRange;
        boolean isPasswordValid = StringUtils.isNotEmpty(value.getPassword()) &&
                value.getPassword().length() >= minPasswordLength && value.getPassword().length() <= maxPasswordLength;
        boolean isEmailValid = value.getEmail() != null && EMAIL_PATTERN.matcher(value.getEmail()).matches();
        return isIdValid && isPasswordValid && isEmailValid;
    }
}
