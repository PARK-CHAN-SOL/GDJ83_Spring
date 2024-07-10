package com.sol.app.accounts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;
import com.sol.app.bank_infos.Bank_infosDTO;

public class AccounDAOTest extends DefaultTest {

	@Autowired
	private AccountDAO accountDAO;
	
	private Bank_infosDTO bank_infosDTO;
	
	private AccountDTO accountDTO;

	@Before
	public void before() throws Exception {
		bank_infosDTO = new Bank_infosDTO();
		bank_infosDTO.setBank_id("00000120000000000006");
		bank_infosDTO.setAccount_u("00000110000000000004");
		bank_infosDTO.setBalance(10000L);
		bank_infosDTO.setDifference(5000L);
		
		accountDTO = new AccountDTO();
		accountDTO.setBank_id("00000110000000000004");
	}
	
	// @Test
	public void detailTest() throws Exception {
		accountDTO = accountDAO.detail(accountDTO);
		assertNotNull(accountDTO);
		assertNotNull(accountDTO.getItemDTO());
	}

	@Test
	public void transferTest() throws Exception {
		assertEquals(1, accountDAO.transfer(bank_infosDTO));
	}
	
	@Test
	public void transferUTest() throws Exception {
		assertEquals(1, accountDAO.transferU(bank_infosDTO));
	}

}
