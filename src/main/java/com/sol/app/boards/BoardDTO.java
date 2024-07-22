package com.sol.app.boards;

import java.sql.Date;
import java.util.List;

public class BoardDTO {
	private Long boardNum;
	private String boardWriter;
	private String boardTitle;
	private Date createDate;
	private Date updateDate;
	private Long boardHit;
	private String boardContents;
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
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public Character getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(Character boardCategory) {
		this.boardCategory = boardCategory;
	}
}
