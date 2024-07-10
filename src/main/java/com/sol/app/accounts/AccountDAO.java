package com.sol.app.accounts;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sol.app.bank_infos.Bank_infosDAO;
import com.sol.app.bank_infos.Bank_infosDTO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.sol.app.accounts.AccountDAO.";

	public int add(AccountDTO accountDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", accountDTO);
	}

	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", accountDTO);
	}
	
	public int transfer(Bank_infosDTO bank_infosDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "transfer", bank_infosDTO);
	}
	
	public int transferU(Bank_infosDTO bank_infosDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "transferU", bank_infosDTO);
	}
	
	/*
	 * public int transferU(Bank_infosDTO bank_infosDTO) throws Exception { return
	 * sqlSession.update(NAMESPACE + "transferU", bank_infosDTO); }
	 */
}
