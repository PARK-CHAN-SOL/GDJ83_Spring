package com.sol.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.members.MemberDTO;
import com.sol.app.util.Pager;

@Repository
public class ItemDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sol.app.product.ItemDAO.";
	
	public int commentUpdate(ItemCommentsDTO dto) throws Exception {
		return sqlSession.update(NAMESPACE + "commentUpdate", dto);
	}
	
	public int commentDelete(ItemCommentsDTO dto) throws Exception {
		return sqlSession.delete(NAMESPACE + "commentDelete", dto);
	}
	
	public Long commentTotalCount (ItemCommentsPager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "commentTotalCount", pager);
	}
	
	public List<ItemCommentsDTO> commentList(ItemCommentsPager pager)throws Exception{
		return sqlSession.selectList(NAMESPACE + "commentList", pager);
	}
	
	public int commentAdd(ItemCommentsDTO dto) throws Exception {
		return sqlSession.insert(NAMESPACE + "commentAdd", dto);
	}
	
	public List<ItemDTO> wishList(Map<String, Object> map) throws Exception {
		return sqlSession.selectList(NAMESPACE + "wishList", map);
	}
	
	public int addWish(Map<String, Object> map) throws Exception {
		return sqlSession.insert(NAMESPACE + "addWish", map);
	}

	public List<ItemDTO> getList(Pager pager) throws Exception {
		Long result = sqlSession.selectOne(NAMESPACE + "countSearch", pager);
		if(result == 0L) return null;
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	public ItemDTO getDetail(ItemDTO dto) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getDetail", dto);
	}

	public Long getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}
	
	public int add(ItemDTO dto) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	public int addFile(ItemFileDTO dto) throws Exception {
		return sqlSession.insert(NAMESPACE + "addFile", dto);
	}

	public int delete(ItemDTO dto) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}

	public int update(ItemDTO dto) throws Exception {
		return sqlSession.update(NAMESPACE + "update", dto);
	}

	public long countList(Pager pager) {
		return sqlSession.selectOne(NAMESPACE + "countList", pager);
	}
	
	public long countWishList(MemberDTO memberDTO) {
		return sqlSession.selectOne(NAMESPACE + "countWishList", memberDTO);
	}
	
	public int deleteWishList (Map<String, Object> map) throws Exception{
		return sqlSession.delete(NAMESPACE + "deleteWishList", map);
	}
}
