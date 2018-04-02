package com.example.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.fileupload.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping( "/form" )
	public String form() {
		return "form";
	}
	
	@RequestMapping( "/upload" )
	public String upload(
				@RequestParam("email") String email,
				@RequestParam("file1") MultipartFile multiPartFile1,
				@RequestParam("file2") MultipartFile multiPartFile2,
				Model model
			) {
		String url = fileUploadService.restore(multiPartFile1);	//임시 파일을 실제 파일로 저장하는 작업
		model.addAttribute("url", url);
		// DB 테이블 구조 : no, original_file_name, save_file_name, type
		return "result";
	}
}
