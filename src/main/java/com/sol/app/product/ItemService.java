package com.sol.app.product;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sol.app.files.FileManager;
import com.sol.app.util.Pager;

@Service
public class ItemService {

	@Autowired
	private ItemDAO itemDAO;
	
	@Autowired
	private FileManager fm;

	public List<ItemDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		pager.makeNum(itemDAO.countList(pager));

		return itemDAO.getList(pager);
	}

	public ItemDTO getDetail(ItemDTO dto) throws Exception {
		return itemDAO.getDetail(dto);
	}

	public int add(ItemDTO dto, MultipartFile[] files, HttpSession httpSession) throws Exception {
		
		Long num = itemDAO.getNum();
		
		dto.setItem_id(num);
		
		int result = itemDAO.add(dto);
		
		if(files == null) {
			return result;
		}
		
		//1. 저장할 폴더 지정
		ServletContext servletContext = httpSession.getServletContext();
		String path = servletContext.getRealPath("resources/upload/products/");
		System.out.println(path);
		
	
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) continue;
			
			ItemFileDTO itemFileDTO = new ItemFileDTO();
			
			fm.fileSave(mf, itemFileDTO, path);
			
			itemFileDTO.setItem_id(num);
			
			result = itemDAO.addFile(itemFileDTO);
		}
		
		return result; 
	}

	public int delete(ItemDTO dto) throws Exception {
		return itemDAO.delete(dto);
	}

	public int update(ItemDTO dto) throws Exception {
		return itemDAO.update(dto);
	}
}
