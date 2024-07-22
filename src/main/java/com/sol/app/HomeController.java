package com.sol.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sol.app.members.MemberDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {

//		System.out.println("Study_Conflict");

		// 하위 -> 상위 O (하위에서 꺼내는거는 가능)
		// 상위 -> 하위 X (상위에서 꺼내는거는 불가능)
		
		HttpSession httpSession = request.getSession();
		httpSession.getServletContext();

//		Cookie cookie = new Cookie("test", "pcs");
//		cookie.setMaxAge(60);
//		
//		response.addCookie(cookie);
		System.out.print(request.getRemoteAddr()+": ");
		if(httpSession.getAttribute("member") != null) {
			MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
			System.out.println(memberDTO.getMember_id());
		}

		return "index";
	}
	
}
