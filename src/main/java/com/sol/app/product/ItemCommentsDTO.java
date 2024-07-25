package com.sol.app.product;

import com.sol.app.boards.CommentsDTO;

public class ItemCommentsDTO extends CommentsDTO {
	private Long item_id;
	
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
}
