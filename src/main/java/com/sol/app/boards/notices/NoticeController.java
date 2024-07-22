package com.sol.app.boards.notices;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sol.app.boards.BoardDTO;
import com.sol.app.boards.BoardService;
import com.sol.app.members.MemberDTO;
import com.sol.app.util.Pager;

@Controller
@RequestMapping(value = "/notice/")
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;

	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String getList(Pager pager, Model model) throws Exception {
		List<BoardDTO> list = boardService.getList(pager);
		if (list == null) {
			model.addAttribute("result", "게시글이 존재하지 않습니다");
			model.addAttribute("url", "/board/list");
			model.addAttribute("board", "notice");
			return "/commons/message";
		}
		model.addAttribute("list", list);
		return "/board/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String getDetail(NoticeDTO noticeDTO, Model model) throws Exception {
		hit(noticeDTO);
		BoardDTO boardDTO = boardService.getDetail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "board/detail";
	}

	public void hit(NoticeDTO noticeDTO) throws Exception {
		boardService.hit(noticeDTO);
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Model model, NoticeDTO noticeDTO) throws Exception {
		BoardDTO boardDTO = boardService.getDetail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "board/write";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {
		int num = boardService.update(noticeDTO);
		return "redirect:detail?boardNum=" + noticeDTO.getBoardNum();
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() throws Exception {
		return "board/write";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(NoticeDTO noticeDTO, MultipartFile[] files, HttpSession httpSession) throws Exception {
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		noticeDTO.setBoardWriter(memberDTO.getMember_id());
		int num = boardService.add(files, noticeDTO, httpSession);
		return "redirect:list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO) throws Exception {
		int num = boardService.delete(noticeDTO);
		return "redirect:list";
	}
}
