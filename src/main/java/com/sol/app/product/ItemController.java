package com.sol.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sol.app.util.Pager;

@Controller
@RequestMapping("/product/")
public class ItemController {
	@Autowired
	private ItemService itemService;
	
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
