package com.raul.beanchat.validator;

import com.raul.beanchat.dto.SignUpFormDto;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignupValidator implements Validator {

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return SignUpFormDto.class.equals(clazz);
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        SignUpFormDto data = (SignUpFormDto) target;

        if (data.getPassword() != null && data.getRepeatPassword() != null) {
            if (!data.getPassword().equals(data.getRepeatPassword())) {
                errors.rejectValue("repeatPassword", "error.signUp.repeatPassword.noMatch");
            }
        }
    }
}
