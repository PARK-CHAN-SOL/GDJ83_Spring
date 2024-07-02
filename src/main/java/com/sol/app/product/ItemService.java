package com.sol.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	private ItemDAO itemDAO;
	
	public List<ItemDTO> getList() throws Exception {
		return itemDAO.getList();
	}
	
	public ItemDTO getDetail(Long id) throws Exception {
		return itemDAO.getDetail(id);
	}
	
	public void add(ItemDTO dto) throws Exception {
		itemDAO.add(dto);
	}
}
