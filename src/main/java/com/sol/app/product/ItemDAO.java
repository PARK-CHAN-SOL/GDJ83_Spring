package com.sol.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.util.DBConnection;

@Repository
public class ItemDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sol.app.product.ItemDAO.";

	public List<ItemDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "getList");
	}

	public ItemDTO getDetail(ItemDTO dto) throws Exception {

		return sqlSession.selectOne(NAMESPACE + "getDetail", dto);
	}

	public int add(ItemDTO dto) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", dto);
	}
	
	public int update(ItemDTO dto) throws Exception {
		return sqlSession.insert(NAMESPACE + "update", dto);
	}
	
	public int delete(ItemDTO dto) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", dto);
	}
}
