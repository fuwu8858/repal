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
 * 支付接口查询接口响应参数实体封装
 * @author   Administrator
 * @version  1.0
 * @Date	 2015年12月29日 上午11:40:08
 **/
public class PayResultResponse {

	private String merchant_id;//商户ID
	private String order_no;//商户订单号
	private String result_code;//返回码
	private String result_msg;//错误信息
	private String status;//completed（交易完成）、failed：支付失败
	private String total_fee;//金额
	private String timestamp;//时间戳
	private String trade_no;//融宝交易流水号
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}
}

