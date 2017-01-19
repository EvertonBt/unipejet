package br.com.unipejet.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import br.com.unipejet.models.User;


	public class UserValidator implements Validator{

		@Override
	public void validate(Object target, Errors errors) {
	ValidationUtils.rejectIfEmptyOrWhitespace(errors,
	"login", "preencha o seu login");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors,
	"password", "preencha a sua senha ");
	User user = (User) target;


if(user.getIdade() == 18){
errors.rejectValue("idade", "maior de 18 anos");
}

	}
		
		

		@Override
		public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

