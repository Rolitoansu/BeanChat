package com.raul.beanchat.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpFormDto {

    @NotBlank(message = "{error.signUp.email.blank}")
    @Email(message = "{error.signUp.email.invalid}")
    private String email;

    @Size(min = 8, max = 20, message = "{error.signUp.password.size}")
    @NotBlank(message = "{error.signUp.password.blank}")
    private String password;

    @NotBlank(message = "{error.signUp.repeatPassword.blank}")
    private String repeatPassword;

}