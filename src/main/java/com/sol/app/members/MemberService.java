package com.sol.app.members;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sol.app.accounts.AccountDAO;
import com.sol.app.files.FileManager;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private AccountDAO accountDAO;
	
	private String name = "members";
	
	public int idCheck(MemberDTO memberDTO) throws Exception {
		return memberDAO.idCheck(memberDTO);
	}
	
	public int join(MemberDTO dto, MultipartFile files, HttpSession httpSession) throws Exception {
		int result = memberDAO.join(dto);
		
		if(files.isEmpty()) return result;
		
		ServletContext servletContext =	httpSession.getServletContext();
		//1. 어디에 저장? (운영체제가 알고 있는 경로에 써줘야한다)
		
		String path = servletContext.getRealPath("resources/upload/" + name);
		
		System.out.println(path);
		
		
		/*
		 * //2. 파일명을 뭐로 할거냐? // 1) 시간을 이용하자
		 * 
		 * Calendar calendar = Calendar.getInstance(); long t =
		 * calendar.getTimeInMillis(); String originalFilename =
		 * files.getOriginalFilename(); // String fileName = t +
		 * originalFilename.substring(originalFilename.lastIndexOf(".")); // String
		 * fileName = t + "_" + originalFilename;
		 * 
		 * // 2) library를 사용하자 UUID String fileName = UUID.randomUUID().toString() + "_"
		 * + originalFilename; System.out.println(fileName);
		 * 
		 * //3. 하드디스크에 파일을 저장하자 file = new File(file, fileName);
		 * 
		 * // 1) library를 사용하자 ( MultipartFile ) // files.transferTo(file); //
		 * FileWriter fw = new
		 * 
		 * // 1-1) ( FileCopyUtils ) FileCopyUtils.copy(files.getBytes(), file);
		 */
		FileManager fm = new FileManager();
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		
		fm.fileSave(files, memberFileDTO, path);
		
		memberFileDTO.setMember_id(dto.getMember_id());
		
		memberDAO.addFile(memberFileDTO);
		return result;
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		MemberDTO result = memberDAO.login(memberDTO);
		if (result != null) {
			if (result.getMember_pw().equals(memberDTO.getMember_pw())) {
				// 로그인 성공 지점
				return result;
				
			} else {
				return null;
				
			}
		}
		
		return result;
	}

	public int update(MemberDTO dto) throws Exception {
		return memberDAO.update(dto);
	}

	public int delete(MemberDTO dto) throws Exception {
		return memberDAO.delete(dto);
	}
	
	public MemberDTO detail(MemberDTO dto) throws Exception {
		return memberDAO.detail(dto);
	}
}
