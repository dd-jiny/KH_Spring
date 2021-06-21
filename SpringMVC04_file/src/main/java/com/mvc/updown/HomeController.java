package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.validate.FileValidator;
import com.mvc.updown.validate.UploadFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		//UploadFile uploadFile 여기에 upload.jsp에서 보내준 값이 담긴다 
		//BindingResult result 밸리데이터의 결과가 나올때까지 기다려주는 역할을 한다 
		
		// 파일 유효성 검사
		fileValidator.validate(uploadFile, result);
		if(result.hasErrors()) {
			return "upload"; //filevalidator클래스에서 validate()메서드가 error가 나면 
		}
		MultipartFile file = uploadFile.getMpfile();  // 사용자가 업로드한 파일을 가지고 옴
		String name = file.getOriginalFilename(); 	  // 사용자가 업로드한 파일의 이름을 가지고옴
		
		UploadFile fileObj = new UploadFile(); 		  // 서버에 넣은 파일정보에 대한 내용의 객체 생성
		fileObj.setName(name);						 // 서버쪽 객체에 업로드한 파일 이름을 넣음
		fileObj.setDesc(uploadFile.getDesc());       //서버쪽 객체에 내용을 넣음
		
		InputStream inputStream = null;              //데이터를 가지고 올 객체 
		OutputStream outputStream = null;            // 데이터를 내보낼 객체 
		
		try {
			inputStream = file.getInputStream();  // 사용자가 업로드한 파일의 내용을 읽어옴 
			//getrealpath : webapp폴더까지를 의미한다
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			System.out.println("업로드 실제 경로: "+path);
			
			//해당 경로에 폴더가 없으면 생성한다
			File storage = new File(path); 
			if(!storage.exists()) {
				storage.mkdir();
			}
			
			//해당 경로에 대한 새로운 파일을 생성한다 
			File newFile = new File(path+"/"+name);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			//FileOutputstream 은 무조건 해당 파일을 생성한다. 존재하는 파일일 경우 덮어쓰기함 
			outputStream = new FileOutputStream(newFile);
			
			int read = 0 ; 
			byte[] b = new byte[(int)file.getSize()];
			//read(byte[] b) : 입력 스트림으로부터 매개값으로 주어진 바이트 배열의 길이만큼 바이트를 읽고 저장 . 읽은 바이트 수를 리턴.   
			//더 이상 바이트를 읽을 수 없으면 read()는 -1 리턴
			

			// 읽어온 파일이 끝이 될때까지 서버내용부분에 저장
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b,0,read); // outputstream 이 읽어온 값? 경로?
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		model.addAttribute("fileObj", fileObj);
		
		return "download";
		
	}
	
	@ResponseBody // 해당 컨트롤러에서 리턴해주는애를 response 객체로 바로 넘겨주겠다 ! 
	@RequestMapping("/download")
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		
		byte[] down = null; 
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			File file = new File(path+"/"+name);  // 파일이름을 넣어줬기때문에 해당 파일의 이름으로 가져올 수 있음
			
			// FileCopyUtils란 파일및 스트림복사를 위한 간단한 유틸리티 메소드의 집합체
            // copyToByteArray 지정한 inputStream의 내용을 카피하고 완료하면 stream을 닫는다.
			
			down = FileCopyUtils.copyToByteArray(file);
			//get Bytes : 플램폼의 기본 문자 집ㄹ합을 사용하여 이 문자열을 바이트 시퀀스로 인코딩하고 결과를 새 바이트 배열에 저장.                                   
			//get Name : 이 추상 경로 이름으로 표시도니 파일 또는 디첵토리의 이름을 반환.
			String filename = new String(file.getName().getBytes(),"8859_1"); 
			
			// setheader를 통해 첨부파일 명시 // 파일이름까지 설정
			
			
			// 한글은 http 헤더에 사용할 수 없기때문에 파일명은 영문으로 인코인하여 헤더에 적용한다.
			response.setHeader("Content-Disposition","attachment; filename=\""+filename+"\"");
			//content-disPosition : 컨텐트 타입의 옵션
			//attachment : 브라우저 인식 파일확장자를 포함하여 모든 확장자의 파일들에 대해, 다운로드 시 무조건 '파일다운로드' 대화상자가 뜨도록 하는 해더속성
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return down;
	}
	
}
