package com.sol.app.product;

import java.util.List;

import com.sol.app.accounts.AccountDTO;

public class ItemDTO {
	private Long item_id;
	private String item_name;
	private String item_detail;
	private Double item_rate;
	private List<AccountDTO> dtos;
	private List<ItemFileDTO> fileDTOs;

	public List<ItemFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<ItemFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

	public List<AccountDTO> getDtos() {
		return dtos;
	}

	public void setDtos(List<AccountDTO> dtos) {
		this.dtos = dtos;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_detail() {
		return item_detail;
	}

	public void setItem_detail(String item_detail) {
		this.item_detail = item_detail;
	}

	public Double getItem_rate() {
		return item_rate;
	}

	public void setItem_rate(Double item_rate) {
		this.item_rate = item_rate;
	}

}
