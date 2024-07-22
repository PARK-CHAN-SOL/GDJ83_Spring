package com.sol.app.files;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	//HDD에 파일 저장
	//fileSave
	
	public void fileSave (MultipartFile mf, FileDTO fileDTO, String path)throws Exception {
		
		File file = new File(path);
		
		//1. 파일 디렉토리 확인
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//2. 파일명 지정
		String fileName = UUID.randomUUID().toString();
		
		String oriName = mf.getOriginalFilename();
		fileName = fileName + "_" + oriName; 
		
		//3. HDD에 파일 저장
		File f = new File(file, fileName);
		mf.transferTo(f);
		
		fileDTO.setFileName(fileName);
		fileDTO.setOriName(oriName);

	}
}
