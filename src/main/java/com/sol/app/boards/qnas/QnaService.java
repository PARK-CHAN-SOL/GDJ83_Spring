package com.sol.app.boards.qnas;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sol.app.boards.BoardDTO;
import com.sol.app.boards.BoardFileDTO;
import com.sol.app.boards.BoardService;
import com.sol.app.files.FileManager;
import com.sol.app.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fm;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		//1. rowNum 계산
		pager.makeRow();
		
		//2. page 계산
		pager.makeNum(qnaDAO.countList(pager));
		
		
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public void hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int add(MultipartFile[] files, BoardDTO boardDTO, HttpSession httpSession) throws Exception {
		if(boardDTO.getBoardContents().equals(""))boardDTO.setBoardContents(" ");
		String title = boardDTO.getBoardTitle();
		title = title.replace("<", "&lt;");
		title = title.replace(">", "&gt;");
		boardDTO.setBoardTitle(title);
		Long num = qnaDAO.getNum();
		boardDTO.setBoardNum(num);
		
		int result = qnaDAO.add(boardDTO);
		
		if (files.length == 0) return result;
		
		ServletContext servletContext = httpSession.getServletContext();
		String path = servletContext.getRealPath("/resources/upload/QnA/");
		
		System.out.println(path);
		
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) continue;
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			fm.fileSave(mf, boardFileDTO, path);
			boardFileDTO.setBoardNum(num);
			result = qnaDAO.addFile(boardFileDTO);
		}
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.delete(boardDTO);
	}
	
	public int reply(QnaDTO qnaDTO, HttpSession httpSession, MultipartFile[] files) throws Exception {
		QnaDTO parent = (QnaDTO)getDetail(qnaDTO);
		//1. STEP을 +1씩 업데이트
		int result = qnaDAO.replyUpdate(parent);
		
		//2. 답글의 REF, STEP, DEPTH 세팅
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep() + 1L);
		qnaDTO.setDepth(parent.getDepth() + 1L);
		
		if(qnaDTO.getBoardContents() == null) qnaDTO.setBoardContents(" ");
		
		result = qnaDAO.reply(qnaDTO);
		
		if (files.length == 0) return result;
		
		ServletContext servletContext = httpSession.getServletContext();
		String path = servletContext.getRealPath("/resources/upload/QnA/");
				
		for(MultipartFile mf : files) {
			if(mf.isEmpty()) continue;
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			fm.fileSave(mf, boardFileDTO, path);
			boardFileDTO.setBoardNum(qnaDTO.getBoardNum());
			result = qnaDAO.addFile(boardFileDTO);
		}

		return result;
	}
	
}
