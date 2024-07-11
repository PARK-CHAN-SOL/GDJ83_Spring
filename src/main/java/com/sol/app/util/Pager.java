package com.sol.app.util;

public class Pager {
	private Long startRow;
	private Long lastRow;
	private Long page;
	private Long totalCount;
	private Long perPage;
	private Long totalPage;
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	private Long curBlock;
	private Long totalBlock;
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(Long curBlock) {
		this.curBlock = curBlock;
	}
	public Long getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Long totalBlock) {
		this.totalBlock = totalBlock;
	}
}
