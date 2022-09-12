package com.webmedapp.webmed.app.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webmedapp.webmed.app.model.Patients;
import com.webmedapp.webmed.app.repository.PatientRepository;

public class DataValidation implements Validator {

	@Autowired
	public PatientRepository patientRepository;

	// Regex
	String emailRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,}$";
	String phoneRegex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

	public boolean supports(Class<?> clazz) {
		return Patients.class.equals(clazz);
	}

	public void validate(Object o, Errors errors) {
			Patients patient = (Patients) o;

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fname", "size.user.fname");		
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lname", "size.user.lname");			
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");		
			if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
		    	errors.rejectValue("email", "size.user.unique");
		    }
			
	        // Add getters and setters for password2 to do validations
	        /* 
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2", "NotEmpty");
	        if (!patient.getPassword2().equals(user.getPassword())) {
		    	errors.rejectValue("password2", "match.user.password2");
		    } 
            */
	        
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
			if(!patient.getEmail().matches(emailRegex)) { 
				errors.rejectValue("email","size.user.email"); 
			}
			 
	        
	        if (!patient.getPassword().matches(passwordRegex)) {
	        	errors.rejectValue("password", "size.user.password");
		    }
}
