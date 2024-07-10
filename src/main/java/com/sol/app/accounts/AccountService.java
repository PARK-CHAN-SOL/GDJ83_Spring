package com.sol.app.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sol.app.bank_infos.Bank_infosDAO;
import com.sol.app.bank_infos.Bank_infosDTO;
import com.sol.app.members.MemberDTO;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	@Autowired
	private Bank_infosDAO bank_infosDAO;
	
	public int add (AccountDTO accountDTO) throws Exception {
		return accountDAO.add(accountDTO);
	}
	
	public AccountDTO detail(AccountDTO accountDTO) throws Exception {
		return accountDAO.detail(accountDTO);
	}
	
	public int transfer (MemberDTO memberDTO, Bank_infosDTO bank_infosDTO, String bank_pw) throws Exception {
		for(AccountDTO accountDTO : memberDTO.getDtos()) {
			System.out.print(accountDTO.getBank_id()+":");
			System.out.println(bank_infosDTO.getBank_id());
			System.out.print(accountDTO.getBank_pw()+":");
			System.out.println(bank_pw);
			if(accountDTO.getBank_id().equals(bank_infosDTO.getBank_id()) && accountDTO.getBank_pw().equals(bank_pw)) {
				System.out.println("CHECK1");
				bank_infosDTO.setBalance(accountDTO.getBalance());
				int num = 0;
				num += accountDAO.transfer(bank_infosDTO);
				num += accountDAO.transferU(bank_infosDTO);
				num += bank_infosDAO.transfer(bank_infosDTO);
				num += bank_infosDAO.transferU(bank_infosDTO);
				return num;
			}
		}
		return -1;
	}
	
}
