package com.sol.app.boards;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.sol.app.util.Pager;

public interface BoardService {
	public List<BoardDTO> getList(Pager pager) throws Exception;

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	public void hit(BoardDTO boardDTO) throws Exception;

	public int update(BoardDTO boardDTO) throws Exception;

	public int add(MultipartFile[] files, BoardDTO boardDTO, HttpSession httpSession) throws Exception;

	public int delete(BoardDTO boardDTO) throws Exception;
}
