package com.example.fileupload.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	private static String SAVE_PATH = "/uploads"; //JVM이 알아서 윈도우일 경우 C:\, D:\를 붙여준다.
	private static String PREFIX_URL = "/uploads/";
	/**
	 *  실제로 저장되는 위치와 접근할 수 있는 File의 위치는 완전히 상이하다.
	 *  로컬에서는 잘 돌아갈지 몰라도 서버에 올리면 파일에 접근할 수 없다.
	 *  따라서 이 Locial URL과 실제로 저장되어 있는 Physical URL을 Mapping해주는 기술이 필요하다.
	 */
	
	public String restore(MultipartFile multiPartFile) {
		String url = "";
		
		String originFileName = multiPartFile.getOriginalFilename();
		String extName = originFileName.substring(originFileName.lastIndexOf("."), originFileName.length());
		Long size = multiPartFile.getSize();
		String saveFileName = generateSaveFileName(extName);
		
		
		System.out.println("===============================================");
		System.out.println(originFileName);
		System.out.println("===============================================");
		System.out.println(extName);
		System.out.println("===============================================");
		System.out.println(size);
		System.out.println("===============================================");
		System.out.println(saveFileName);
		System.out.println("===============================================");
		
		try {
			writeFile(multiPartFile, saveFileName);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		url = PREFIX_URL + saveFileName;
		return url;
	}
	
	private void writeFile(MultipartFile multipartFile, String saveFileName) throws IOException {
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.flush();
		fos.close();
	}
	
	private String generateSaveFileName(String extName) {
		Calendar c = Calendar.getInstance();
		StringBuilder fileNameBuilder = new StringBuilder();
		fileNameBuilder.append(c.get(Calendar.YEAR));
		fileNameBuilder.append(c.get(Calendar.MONTH));
		fileNameBuilder.append(c.get(Calendar.DATE));
		fileNameBuilder.append(c.get(Calendar.HOUR_OF_DAY));
		fileNameBuilder.append(c.get(Calendar.MINUTE));
		fileNameBuilder.append(c.get(Calendar.SECOND));
		fileNameBuilder.append(c.get(Calendar.MILLISECOND));
		fileNameBuilder.append(extName);
		return fileNameBuilder.toString();
	}
}
