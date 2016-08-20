/*****************************************************
 * cn.caijingquan.p2p.reapal.client.vo
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2016年1月10日 			Administrator
 *
 * Copyright (c) 2016, caijinquan.
******************************************************/

package util.client.vo;
/**
 *
 *
 * @author   songtao
 * @version  1.0
 * @Date	 2016年1月10日 下午2:42:00
 **/
public class RechargeInfoReturnResponse {

	private String merchant_id;//商户ID
	private String trade_no;//融宝交易流水号
	private String order_no;//财金圈订单号（流水号）
	private String total_fee;//支付金额
	private String status;//状态
	private String result_code;//错误码
	private String result_msg;//错误信息
	private String version;//版本号
	private String Notify_id;//通知ID
	private String sign_type;//签名类型
	private String sign;//签名
	
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNotify_id() {
		return Notify_id;
	}
	public void setNotify_id(String notify_id) {
		Notify_id = notify_id;
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

