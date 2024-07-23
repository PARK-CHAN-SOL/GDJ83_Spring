package com.sol.app.boards.qnas;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.boards.BoardDAO;
import com.sol.app.boards.BoardDTO;
import com.sol.app.boards.BoardFileDTO;
import com.sol.app.files.FileDTO;
import com.sol.app.util.Pager;

@Repository
public class QnaDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.sol.app.boards.qnas.QnaDAO.";

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}

	@Override
	public void hit(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}
	
	@Override
	public Long getNum() throws Exception {	
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}
	
	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}
	
	
	public int addFile(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}

	@Override
	public Long countList(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "countList", pager);
	}
	
	public int reply (QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "reply", qnaDTO);
	}
	
	public int replyUpdate(QnaDTO qnaDTO) {
		return sqlSession.update(NAMESPACE + "replyUpdate", qnaDTO);
	}
	
	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "fileDetail", fileDTO);
	}
	
	
}
