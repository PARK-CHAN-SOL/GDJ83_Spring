package com.sol.app.boards.notices;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sol.app.boards.BoardDAO;
import com.sol.app.boards.BoardDTO;
import com.sol.app.boards.BoardFileDTO;
import com.sol.app.boards.BoardService;
import com.sol.app.files.FileDTO;
import com.sol.app.files.FileManager;
import com.sol.app.util.Pager;

@Service
public class NoticeService implements BoardService {
	
	@Autowired
	@Qualifier("noticeDAO")
	private BoardDAO boardDAO;
	
	@Autowired
	private FileManager fm;

	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		pager.makeNum(boardDAO.countList(pager));
		
		return boardDAO.getList(pager);
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return boardDAO.getDetail(boardDTO);
	}
	
	public void hit(BoardDTO boardDTO) throws Exception {
		boardDAO.hit(boardDTO);
	}

	public int update(BoardDTO boardDTO) throws Exception {
		return boardDAO.update(boardDTO);
	}

	public int add(MultipartFile[] files, BoardDTO boardDTO, HttpSession httpSession) throws Exception {
		if(boardDTO.getBoardContents().equals(""))boardDTO.setBoardContents(" ");
		String title = boardDTO.getBoardTitle();
		title = title.replace("<", "&lt;");
		title = title.replace(">", "&gt;");
		boardDTO.setBoardTitle(title);
		
		int result = boardDAO.add(boardDTO);
		
		if (files.length == 0) return result;
		
		ServletContext servletContext = httpSession.getServletContext();
		String path = servletContext.getRealPath("/resources/upload/Notice/");
		
		
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) continue;
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			fm.fileSave(mf, boardFileDTO, path);
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = boardDAO.addFile(boardFileDTO);
		}
		return result;
	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return boardDAO.delete(boardDTO);
	}
	
	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		return boardDAO.fileDetail(fileDTO);
	}
}
