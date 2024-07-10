package com.sol.app.trades;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;

public class TradeDAOTest extends DefaultTest{

	@Autowired
	private TradeDAO tradeDAO;
	
	private TradeDTO tradeDTO;
	
	@BeforeClass
	public static void beforeClass () {
		
	}
	
	@Before
	public void before() {
		this.tradeDTO = new TradeDTO();
		tradeDTO.setAccountNumber(198151515L);
		tradeDTO.setTradeAmount(5000L);
		tradeDTO.setTradeIO(0); //0 :입금
	}
	
//	@Test
	public void addTest() throws Exception {
		int result = tradeDAO.add(tradeDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void updateTest() throws Exception {
		int result = tradeDAO.update(tradeDTO);
		assertEquals(true, result > 0);
	}
	
	@After
	public void after() {
		tradeDTO = null;
	}

}
