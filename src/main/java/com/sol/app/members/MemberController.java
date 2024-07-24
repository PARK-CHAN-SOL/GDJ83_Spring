package com.sol.app.members;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/members/")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("idCheck")
	public String idCheck(MemberDTO memberDTO, Model model) throws Exception {
		int result = memberService.idCheck(memberDTO);
		model.addAttribute("msg", result);
		return "/commons/result";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() {

	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO dto, MultipartFile files, HttpSession httpSession) throws Exception {
		
		int num = memberService.join(dto, files, httpSession);
		
		return "redirect:/";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model, @CookieValue(name = "remember", required = false, defaultValue = "") String value)
			throws Exception {
		model.addAttribute("remember", value);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, MemberDTO dto, HttpServletResponse response, String remember,
		HttpSession httpSession) throws Exception {
		System.out.println(dto.getMember_id());
		System.out.println(dto.getMember_pw());
		System.out.println(remember);
		if (remember != null) {
			Cookie cookie = new Cookie("remember", dto.getMember_id());
			cookie.setMaxAge(1800);
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		dto = memberService.login(dto);

		if (dto != null) {
			httpSession.setAttribute("member", dto);
			model.addAttribute("url", "/");
			model.addAttribute("result", "로그인 성공");
		} else {
			model.addAttribute("url", "/members/login");
			model.addAttribute("result", "로그인 실패");
		}
		return "/commons/message";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.setAttribute("member", null);
//		httpSession.invalidate();
//		httpSession.removeAttribute("member");
//		httpSession.removeValue("member");
//		httpSession.isNew();
		return "redirect:/";
	}

	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public void mypage(HttpSession httpSession, Model model) throws Exception {
		MemberDTO dto = (MemberDTO) httpSession.getAttribute("member");
		dto = memberService.detail(dto);
		model.addAttribute("member", dto);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(HttpSession httpSession, Model model) throws Exception {
		MemberDTO dto = (MemberDTO) httpSession.getAttribute("member");
		dto = memberService.detail(dto);
		model.addAttribute("member", dto);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpSession httpSession, MemberDTO dto) throws Exception {
		MemberDTO dtoTmp = (MemberDTO) httpSession.getAttribute("member");
		dto.setMember_pw(dtoTmp.getMember_pw());
		dto.setMember_id(dtoTmp.getMember_id());

		int num = memberService.update(dto);

		return "redirect:/";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(Model model, HttpSession httpSession) throws Exception {
		MemberDTO dto = (MemberDTO) httpSession.getAttribute("member");
		int num = memberService.delete(dto);
		if (num > 0) {
			model.addAttribute("result", "계정이 삭제되었습니다.");
			model.addAttribute("url", "/");
			httpSession.setAttribute("member", null);
		} else {
			model.addAttribute("result", "계정이 삭제실패.");
			model.addAttribute("url", "/");
		}
		return "/commons/message";
	}

}
