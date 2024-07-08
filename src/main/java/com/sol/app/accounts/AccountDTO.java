package com.sol.app.accounts;

import java.sql.Date;

import com.sol.app.members.MemberDTO;
import com.sol.app.product.ItemDTO;

public class AccountDTO {
	private String bank_id;
	private String member_id;
	private Long item_id;
	private Date open_date;
	private String bank_pw;
	private Long balance;
	private MemberDTO memberDTO;
	private ItemDTO itemDTO;
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public Long getItem_id() {
		return item_id;
	}
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public String getBank_pw() {
		return bank_pw;
	}
	public void setBank_pw(String bank_pw) {
		this.bank_pw = bank_pw;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
}
