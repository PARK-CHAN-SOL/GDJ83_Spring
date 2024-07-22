package com.sol.app.product;

import com.sol.app.files.FileDTO;

public class ItemFileDTO extends FileDTO{
	private Long item_id;

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
}
