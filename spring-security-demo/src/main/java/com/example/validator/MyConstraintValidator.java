
package com.example.validator;

import com.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	@Autowired
	private HelloService helloService;

	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("校验器初始化");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println(value);
//		return value.equals(helloService.greeting("pwd"));
		return value.equals(helloService.greeting("密码"));
	}

}
