package org.geektimes.projects.user.validator.bean.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidAnnotationValidator.class)
public @interface UserValid {

    int idRange() default 0;

    int minPasswordLength() default 6;

    int maxPasswordLength() default 32;

    String message() default "user info is valid!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default { };

}
