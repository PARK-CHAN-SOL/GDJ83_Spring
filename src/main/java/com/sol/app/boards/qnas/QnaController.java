package com.sol.app.boards.qnas;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sol.app.boards.BoardDTO;
import com.sol.app.members.MemberDTO;
import com.sol.app.util.Pager;

@Controller
@RequestMapping(value="/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}
	
	@GetMapping("list")
	public ModelAndView getList(ModelAndView mv, Pager pager) throws Exception {
		List<BoardDTO> list = qnaService.getList(pager);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@GetMapping("detail")
	public String getDetail(QnaDTO qnaDTO, Model model) throws Exception {
		qnaDTO = (QnaDTO)qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", qnaDTO);
		return "/board/detail";
	}
	
	@GetMapping("add")
	public ModelAndView add(ModelAndView mv) throws Exception {
		mv.setViewName("/board/write");
		return mv;
	}
	
	@PostMapping("add")
	public String add(QnaDTO qnaDTO, HttpSession httpSession) throws Exception {
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getMember_id());
		qnaDTO.setRef(qnaDTO.getBoardNum());
		qnaDTO.setStep(0L);
		qnaDTO.setDepth(0L);
		
		int result = qnaService.add(qnaDTO);
		
		return "redirect:./list";
	}
	
	@GetMapping("update")
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.getDetail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "/board/write";
	}
	
	@PostMapping("update")
	public String update(QnaDTO qnaDTO) throws Exception {
		qnaService.update(qnaDTO);
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public String reply(QnaDTO qnaDTO, Model model) throws Exception {
		model.addAttribute("dto", qnaDTO);
		return "/board/write";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO qnaDTO, HttpSession httpSession) throws Exception {
		MemberDTO memberDTO = (MemberDTO)httpSession.getAttribute("member");
		qnaDTO.setBoardWriter(memberDTO.getMember_id());
		int result = qnaService.reply(qnaDTO);
		return "redirect:./list";
	}
	
	@GetMapping("delete")
	public String delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);
		return "redirect:./list";
	}
}
