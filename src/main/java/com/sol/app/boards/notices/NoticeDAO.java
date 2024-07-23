package com.sol.app.boards.notices;

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
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sol.app.boards.notices.NoticeDAO.";
	
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long result = sqlSession.selectOne(NAMESPACE + "countSearch", pager);
		if(result == 0L) return null;
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", boardDTO);
	}
	
	public void hit(BoardDTO boardDTO) throws Exception {
		sqlSession.update(NAMESPACE + "hit", boardDTO);
	}

	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", boardDTO);

	}

	@Override
	public Long getNum() throws Exception {	
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}
	
	public int add(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", boardDTO);

	}
	
	public int addFile(BoardFileDTO boardFileDTO) throws Exception{
		return sqlSession.insert(NAMESPACE + "addFile", boardFileDTO);
	}

	public int delete(BoardDTO boardDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);

	}
	
	public Long countList (Pager pager) {
		return sqlSession.selectOne(NAMESPACE + "countList", pager);
	}
	
	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "fileDetail", fileDTO);
	}
}
