package com.sol.app.boards;

import java.sql.Date;
import java.util.List;

public class BoardDTO extends CommentsDTO{
	private String boardTitle;
	private Date updateDate;
	private Long boardHit;
	private Character boardCategory;
	private Integer del;
	private List<BoardFileDTO> fileDTOs;

	public List<BoardFileDTO> getFileDTOs() {
		return fileDTOs;
	}
	public void setFileDTOs(List<BoardFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}
	public Integer getDel() {
		if(this.del == null) this.del = 0;
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Long getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(Long boardHit) {
		this.boardHit = boardHit;
	}
	public Character getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(Character boardCategory) {
		this.boardCategory = boardCategory;
	}
}
