package com.sol.app.product;

import com.sol.app.util.Pager;

public class ItemCommentsPager extends Pager{
	private Long item_id;
	
	public ItemCommentsPager() {
		this.setPerPage(5L);
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
}
