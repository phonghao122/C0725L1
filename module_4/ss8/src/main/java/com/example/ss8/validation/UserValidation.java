package com.example.ss8.validation;

import com.example.ss8.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.io.IOException;

public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;
        if (!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword", null, "Password not match");
        }else if (user.getPassword().length() < 6){
            errors.rejectValue("password", null, "Password must be >= 6 chars");
        }else if (user.getPhone().length() != 10){
            errors.rejectValue("phone", null, "Phone must be 10 digits");
        }else if (!user.getEmail().contains("@")){
            errors.rejectValue("email", null, "Invalid email");
        }else if ("".equals(user.getName())){
            errors.rejectValue("name", null, "Name is required");
        }
    }
}
