package com.sol.app.trades;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sol.app.DefaultTest;

public class TradeServiceTest extends DefaultTest{

	@Autowired
	private TradeService tradeService;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void transferTest() throws Exception {
		tradeService.transfer();
		
		System.out.print("종료");
	}
}
