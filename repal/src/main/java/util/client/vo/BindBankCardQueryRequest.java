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
 * 查询绑定银行卡信息 请求参数
 * @author   songtao
 * @version  1.0
 * @Date	 2016年1月12日 下午2:28:20
 **/
public class BindBankCardQueryRequest {

	private String merchant_id;//商户ID
	private String member_id;//用户ID
	private String bank_card_type;//银行卡类型 0-储蓄卡
	private String version;//版本号
	private String sign_type;//签名类型
	private String sign;//签名
	
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getBank_card_type() {
		return bank_card_type;
	}
	public void setBank_card_type(String bank_card_type) {
		this.bank_card_type = bank_card_type;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
}

