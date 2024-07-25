package com.sol.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sol.app.members.MemberDTO;
import com.sol.app.util.Pager;

@Controller
@RequestMapping("/product/")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@ModelAttribute
	public String getBoard() {
		return "Product";
	}
	
	@PostMapping("commentDelete")
	public String commentDelete(ItemCommentsDTO dto, Model model)throws Exception {
		int result = itemService.commentDelete(dto);
		model.addAttribute("msg", result);
		return "/commons/result";
	}
	
	@GetMapping("commentList")
	public void commentList(ItemCommentsPager pager, Model model)throws Exception{
		List<ItemCommentsDTO> list = itemService.commentList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
	}
	
	@PostMapping("commentAdd")
	public String commentAdd(ItemCommentsDTO dto, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		dto.setBoardWriter(memberDTO.getMember_id());
		int result = itemService.commentAdd(dto); 
		model.addAttribute("msg", result);
		return "/commons/result";
	}
	
	@GetMapping("deleteWishList")
	public String deleteWishList(Long[] item_id, HttpSession session, Model model) throws Exception {
//		System.out.println(itemDTO.getItem_id());
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		model.addAttribute("msg", itemService.deleteWishList(item_id, memberDTO));
		return "/commons/result";
	}
	
	@GetMapping("wishList")
	public void wishList(HttpSession session, Model model, Pager pager) throws Exception {
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<ItemDTO> wishList = itemService.wishList(memberDTO, pager);
		model.addAttribute("wishList", wishList);
		model.addAttribute("pager", pager);
	}
	
	@RequestMapping("list")
	public String getList(Model model, Pager pager) throws Exception {
		List<ItemDTO> list = itemService.getList(pager);
		if(list == null) {
			model.addAttribute("result", "상품이 존재하지 않습니다");
			model.addAttribute("url", "/product/list");
			return "/commons/message"; 
		}
		model.addAttribute("list", list);
		return "/product/list";
	}
	
	@GetMapping("addWish")
	public String addWish(Long item_id, HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		int result = itemService.addWish(item_id, memberDTO.getMember_id());
		model.addAttribute("msg", result);
		return "commons/result";
	}
	
	@RequestMapping("detail")
	public void getDetail(Model model, ItemDTO itemDTO) throws Exception {
		ItemDTO dto = itemService.getDetail(itemDTO);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public void add() {	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(ItemDTO dto, MultipartFile[] files, HttpSession httpSession) throws Exception {
		int num = itemService.add(dto, files, httpSession);
		return "redirect:./list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete (ItemDTO dto) throws Exception {
		int num = itemService.delete(dto);
		return "redirect:./list";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update(Model model, ItemDTO dto) throws Exception {
		dto = itemService.getDetail(dto);
		model.addAttribute("dto", dto);
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update (ItemDTO dto) throws Exception {
		int num = itemService.update(dto);
		return "redirect:./list";
	}

}
