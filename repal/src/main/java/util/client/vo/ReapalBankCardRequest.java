/*****************************************************
 * cn.caijingquan.p2p.reapal.client.vo
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月31日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
******************************************************/

package util.client.vo;
/**
 *
 * 查询银行卡信息 请求参数实体封装
 * @author   songtao
 * @version  1.0
 * @Date	 2015年12月31日 下午7:03:05
 **/
public class ReapalBankCardRequest {

	private String merchant_id;// 商户ID
	private String card_no;//银行卡号
	private String sign_type;// 签名类型
	private String sign;// 签名
	
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
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

