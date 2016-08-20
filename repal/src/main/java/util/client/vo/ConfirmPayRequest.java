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
 * 确认支付接口请求参数实体封装
 * @author   Administrator
 * @version  1.0
 * @Date	 2015年12月29日 上午10:57:47
 **/
public class ConfirmPayRequest {

	private String merchant_id;// 商户ID
	private String order_no;// 商户订单号
	private String CVV2;// 卡后三位
	private String check_code;// 短信验证码
	private String version;// 版本号
	private String sign_type;// 签名类型
	private String sign;// 签名
	
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
	public String getCVV2() {
		return CVV2;
	}
	public void setCVV2(String cVV2) {
		CVV2 = cVV2;
	}
	public String getCheck_code() {
		return check_code;
	}
	public void setCheck_code(String check_code) {
		this.check_code = check_code;
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

