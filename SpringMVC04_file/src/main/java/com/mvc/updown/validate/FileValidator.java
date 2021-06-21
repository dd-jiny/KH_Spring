package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//이 클래스를 객체화 시키기 위한 어노테이션이다 
@Service
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//validator 사용 가능 여부 확인 
		
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UploadFile file = (UploadFile) target; 
		
		if(file.getMpfile().getSize()==0) { //파일 업로드를 안했을 경우
			//mpfile(field)에 대한 errorCode return. 해당 errorCode가 없으면 default message  전달. 
			errors.rejectValue("mpfile", "fileNPE","Please select a file");
		}
	}

}
