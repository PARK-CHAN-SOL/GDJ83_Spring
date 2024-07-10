package com.sol.app.trades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
	
	@Autowired
	private TradeDAO tradeDAO;
	
	public void transfer() throws Exception {
		//1번계좌에서 5000을 1720399116921계좌로 이체
		TradeDTO tradeDTO = new TradeDTO();
		tradeDTO.setAccountNumber(1L);
		tradeDTO.setTradeAmount(5000L * -1);
		tradeDTO.setTradeIO(1);
		//거래내역 추가
		int result = tradeDAO.add(tradeDTO);
		//계좌내용을 업데이트
		result = tradeDAO.update(tradeDTO);
		
		//받는 DTO로 수정
		tradeDTO.setAccountNumber(1720399116921L);
		tradeDTO.setTradeAmount(5000L);
		tradeDTO.setTradeIO(0);
		
		//거래내역 추가
		result = tradeDAO.add(tradeDTO);
		//계좌내용을 업데이트
		result = tradeDAO.update(tradeDTO);
	}
}
