package com.sol.app.boards;

import java.util.List;

import com.sol.app.files.FileDTO;
import com.sol.app.util.Pager;

public interface BoardDAO {

	List<BoardDTO> getList(Pager pager) throws Exception;

	BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	void hit(BoardDTO boardDTO) throws Exception;

	int update(BoardDTO boardDTO) throws Exception;

	Long getNum() throws Exception;
	
	int add(BoardDTO boardDTO) throws Exception;

	int addFile(BoardFileDTO boardFileDTO) throws Exception;
	
	int delete(BoardDTO boardDTO) throws Exception;

	Long countList(Pager pager) throws Exception;

	FileDTO fileDetail(FileDTO fileDTO) throws Exception;
}
