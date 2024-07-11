package com.sol.app.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sol.app.util.Pager;

@Service
public class ItemService {

	@Autowired
	private ItemDAO itemDAO;

	public Map<String, Object> getList(Pager pager) throws Exception {
		// page가 1이면 page 2 3
		// 첫번째 숫자 1 11 21
		// 두번째 숫자 10 20 30
		if (pager.getPage() == null || pager.getPage() < 1) pager.setPage(1L);

		Long perPage = 10L;
		pager.setPerPage(10L);

		
		Long perBlock = 5L;
		pager.setPerBlock(perBlock);
		
		pager.setTotalCount(itemDAO.countList());
		
		Long totalPage = (long) Math.ceil((double) pager.getTotalCount() / pager.getPerPage());
		pager.setTotalPage(totalPage);
		
		Long totalBlock = (long)Math.ceil((double)pager.getTotalPage()/pager.getPerBlock());
		pager.setTotalBlock(totalBlock);
		
		Long curBlock = (long)Math.ceil((double)pager.getPage()/pager.getPerBlock());
		pager.setCurBlock(curBlock);
		
		Long lastNum = pager.getCurBlock()*pager.getPerBlock();
		Long startNum = lastNum - pager.getPerBlock() + 1L;
		if(lastNum > pager.getTotalPage()) lastNum = pager.getTotalPage();
		if(startNum > lastNum) startNum = lastNum;
		
		pager.setLastNum(lastNum);
		pager.setStartNum(startNum);
		
		if(pager.getPage() > pager.getTotalPage()) pager.setPage(pager.getTotalPage());
		
		pager.setLastRow(pager.getPage()*pager.getPerPage());
		pager.setStartRow(pager.getLastRow()-pager.getPerPage()+1L); 
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", itemDAO.getList(pager));
		map.put("pager", pager);
		
		return map;
	}

	public ItemDTO getDetail(ItemDTO dto) throws Exception {
		return itemDAO.getDetail(dto);
	}

	public int add(ItemDTO dto) throws Exception {
		return itemDAO.add(dto);
	}

	public int delete(ItemDTO dto) throws Exception {
		return itemDAO.delete(dto);
	}

	public int update(ItemDTO dto) throws Exception {
		return itemDAO.update(dto);
	}
}
