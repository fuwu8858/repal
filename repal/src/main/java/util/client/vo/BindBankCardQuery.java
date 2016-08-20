/*****************************************************
 * cn.caijingquan.p2p.reapal.client.vo
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2016年1月12日 			Administrator
 *
 * Copyright (c) 2016, caijinquan.
******************************************************/

package util.client.vo;
/**
 *
 *
 * @author   Administrator
 * @version  1.0
 * @Date	 2016年1月12日 下午2:45:27
 **/
public class BindBankCardQuery {

	private String bank_card_type;//银行卡类型 0-储蓄卡
	private String bank_name;//银行名称
	private String bank_code;//银行编号
	private String bind_id;//绑卡id
	private String card_last;//卡号后四位
	private String card_top;//卡号前六
	private String phone;//手机号
	
	public String getBank_card_type() {
		return bank_card_type;
	}
	public void setBank_card_type(String bank_card_type) {
		this.bank_card_type = bank_card_type;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getBind_id() {
		return bind_id;
	}
	public void setBind_id(String bind_id) {
		this.bind_id = bind_id;
	}
	public String getCard_last() {
		return card_last;
	}
	public void setCard_last(String card_last) {
		this.card_last = card_last;
	}
	public String getCard_top() {
		return card_top;
	}
	public void setCard_top(String card_top) {
		this.card_top = card_top;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

