/*****************************************************
 * cn.caijingquan.p2p.reapal.client.vo
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月28日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
 ******************************************************/

package util.client.vo;

/**
 *
 * 储蓄卡签约接口请求参数实体
 * 
 * @author Administrator
 * @version 1.0
 * @Date 2015年12月28日 下午8:27:08
 **/
public class SignRequest {

	//终端设备类型
	public static String TERMINAL_TYPE_MOBILE = "mobile";
	
	public static String TERMINAL_TYPE_WEB = "web";
	
	public static String TERMINAL_TYPE_WAP = "wap";
	
	private String merchant_id;// 商户ID
	private String card_no;// 银行卡号
	private String owner;// 持卡人姓名
	private String cert_type;// 证件类型
	private String cert_no;// 证件号
	private String phone;// 手机号
	private String order_no;// 商户订单号
	private String transtime;// 交易时间
	private String currency;// 交易币种
	private String total_fee;// 交易金额
	private String title;// 商品名称
	private String body;// 商品描述
	private String member_id;// 用户ID
	private String terminal_type;// 终端类型
	private String terminal_info;// 终端信息
	private String member_ip;// 用户IP
	private String seller_email;// 商户邮箱
	private String notify_url;// 商户后台系统的回调地址
	private String token_id;// 指纹ID
	private String version;// 版本号
	private String sign_type;// 签名类型
	private String sign;// 签名
	private String bind_id;//绑卡签约ID
	private String apply_id;//申请id
	private String pay_state;//区分 还款 还是 首付款

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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCert_type() {
		return cert_type;
	}

	public void setCert_type(String cert_type) {
		this.cert_type = cert_type;
	}

	public String getCert_no() {
		return cert_no;
	}

	public void setCert_no(String cert_no) {
		this.cert_no = cert_no;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getTranstime() {
		return transtime;
	}

	public void setTranstime(String transtime) {
		this.transtime = transtime;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getTerminal_type() {
		return terminal_type;
	}

	public void setTerminal_type(String terminal_type) {
		this.terminal_type = terminal_type;
	}

	public String getTerminal_info() {
		return terminal_info;
	}

	public void setTerminal_info(String terminal_info) {
		this.terminal_info = terminal_info;
	}

	public String getMember_ip() {
		return member_ip;
	}

	public void setMember_ip(String member_ip) {
		this.member_ip = member_ip;
	}

	public String getSeller_email() {
		return seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getToken_id() {
		return token_id;
	}

	public void setToken_id(String token_id) {
		this.token_id = token_id;
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

	public String getBind_id() {
		return bind_id;
	}

	public void setBind_id(String bind_id) {
		this.bind_id = bind_id;
	}

	public String getApply_id() {
		return apply_id;
	}

	public void setApply_id(String apply_id) {
		this.apply_id = apply_id;
	}

	public String getPay_state() {
		return pay_state;
	}

	public void setPay_state(String pay_state) {
		this.pay_state = pay_state;
	}
	
}
