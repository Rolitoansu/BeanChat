package com.raul.beanchat.controller;

import com.raul.beanchat.dto.SignUpFormDto;
import com.raul.beanchat.service.AuthService;
import com.raul.beanchat.service.EmailAlreadyExistsException;
import com.raul.beanchat.validator.SignupValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@AllArgsConstructor
public class AuthController implements WebMvcConfigurer {

    private final AuthService authService;
    private final SignupValidator validator;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/signup")
    public String signup(SignUpFormDto signUpFormDto) {
        return "/signup";
    }

    @PostMapping("/signup")
    public String signup(@Validated SignUpFormDto signUpFormDto, BindingResult result) {
        validator.validate(signUpFormDto, result);
        if (result.hasErrors()) {
            return "signup";
        }

        try {
            authService.registerUser(signUpFormDto.getEmail(), signUpFormDto.getPassword());
        } catch (EmailAlreadyExistsException ex) {
            result.rejectValue("email", "error.signUp.email.exists", "Email ya registrado");
            return "signup";
        }
        return "redirect:login";
    }
}
