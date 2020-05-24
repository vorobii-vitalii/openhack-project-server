package com.hack.plates.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ResponsibilityIdValidator.class})
public @interface ResponsibilityId {

    String message() default "No such responsibility";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
