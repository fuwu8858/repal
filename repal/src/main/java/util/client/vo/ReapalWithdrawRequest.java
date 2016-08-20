/*****************************************************
 * cn.caijingquan.p2p.reapal.client.vo
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月30日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
******************************************************/

package util.client.vo;
/**
 *
 * 代付请求接口 请求参数封装
 * @author   songtao
 * @version  1.0
 * @Date	 2015年12月30日 上午11:24:59
 **/
public class ReapalWithdrawRequest {

	private String sign;//签名字符串 
	private String signType;//签名方式 固定值：MD5
	private String batchBizid;//合作伙伴在融宝的用户ID
	private String _input_charset;//编码类型   为UTF-8
	private String batchBiztype;//提交批次类型 默认00000
	private String batchDate;//提交日期 
	private String batchVersion;//版本号 固定值 00
	private String batchCurrnum;//批次号 50位长度，当日不能重复
	private String batchCount = "1";//数量
	private String batchAmount;//金额
	private String batchContent;//明细
	private String tradenum;//明细号
	
	private String bankCardNum;//银行卡号
	private String realName;//真实姓名
	private String bankCard;//银行名称
	private String withdrawMoney;//提现金额
	private String bankCardCity;//开户市
	private String bankCardProvince;//开户省
	private String loginName;//手机号
	private String cardId;//身份证号
	private String tradeSerial;//交易流水号
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getBatchBizid() {
		return batchBizid;
	}
	public void setBatchBizid(String batchBizid) {
		this.batchBizid = batchBizid;
	}
	public String get_input_charset() {
		return _input_charset;
	}
	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}
	public String getBatchBiztype() {
		return batchBiztype;
	}
	public void setBatchBiztype(String batchBiztype) {
		this.batchBiztype = batchBiztype;
	}
	public String getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	public String getBatchVersion() {
		return batchVersion;
	}
	public void setBatchVersion(String batchVersion) {
		this.batchVersion = batchVersion;
	}
	public String getBatchCurrnum() {
		return batchCurrnum;
	}
	public void setBatchCurrnum(String batchCurrnum) {
		this.batchCurrnum = batchCurrnum;
	}
	public String getBatchCount() {
		return batchCount;
	}
	public void setBatchCount(String batchCount) {
		this.batchCount = batchCount;
	}
	public String getBatchAmount() {
		return batchAmount;
	}
	public void setBatchAmount(String batchAmount) {
		this.batchAmount = batchAmount;
	}
	public String getBatchContent() {
		return batchContent;
	}
	public void setBatchContent(String batchContent) {
		this.batchContent = batchContent;
	}
	public String getTradenum() {
		return tradenum;
	}
	public void setTradenum(String tradenum) {
		this.tradenum = tradenum;
	}
	public String getBankCardNum() {
		return bankCardNum;
	}
	public void setBankCardNum(String bankCardNum) {
		this.bankCardNum = bankCardNum;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getBankCard() {
		return bankCard;
	}
	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}
	public String getWithdrawMoney() {
		return withdrawMoney;
	}
	public void setWithdrawMoney(String withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}
	public String getBankCardCity() {
		return bankCardCity;
	}
	public void setBankCardCity(String bankCardCity) {
		this.bankCardCity = bankCardCity;
	}
	public String getBankCardProvince() {
		return bankCardProvince;
	}
	public void setBankCardProvince(String bankCardProvince) {
		this.bankCardProvince = bankCardProvince;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getTradeSerial() {
		return tradeSerial;
	}
	public void setTradeSerial(String tradeSerial) {
		this.tradeSerial = tradeSerial;
	}
	
}

