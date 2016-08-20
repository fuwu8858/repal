/*****************************************************
 * cn.caijingquan.p2p.reapal.client.vo
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月29日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
******************************************************/

package util.client.vo;
/**
 *
 * 绑卡签名接口响应实体封装
 * @author   Administrator
 * @version  1.0
 * @Date	 2015年12月29日 上午10:52:04
 **/
public class BindSignResponse {

	private String merchant_id;//商户ID
	private String order_no;//商户订单号
	private String result_code;//返回码
	private String result_msg;//错误信息
	private String bank_name;//银行名称
	private String bank_code;//银行编码
	
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
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
	
}

