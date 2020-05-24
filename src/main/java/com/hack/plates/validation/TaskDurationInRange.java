package com.hack.plates.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {TaskDurationRangeValidator.class})
public @interface TaskDurationInRange {

    String message() default "Task duration exceeds";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
