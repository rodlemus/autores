package com.udb.autoresjsf.registration.validators;


import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Pattern;

@FacesValidator("svPhoneValidator")
public class SVPhoneValidator implements Validator<String> {

    // Formato: inicia con 2,3,6 o 7, seguido de 3 dígitos, guion y 4 dígitos => ####-####
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[267]\\d{3}-\\d{4}$");

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (value == null || !PHONE_PATTERN.matcher(value).matches()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Formato inválido", "El número debe ser ####-#### y empezar con 2, 6 o 7.");
            throw new ValidatorException(message);
        }
    }
}