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
 * 融宝代付查询请求参数封装
 * @author   Administrator
 * @version  1.0
 * @Date	 2015年12月30日 下午5:17:03
 **/
public class WithdrawResultResponse {

	private String _input_charset;//输入编码
	private String batchBizid;//合作伙伴客户号
	private String batchVersion;//版本号
	private String batchDate;//日期
	private String batchCurrnum;//批次号
	private String detailInfo;//交易明细
	private String sign;//签名方式
	private String signType;//签名方式
	
	private String tradeNum;//记录序号
	private String tradeCardnum;//银行卡号
	private String tradeCardname;//银行卡或存折上的所有人姓名
	private String tradeBranchbank;//开户行分行
	private String tradeSubbranchbank;//开户行支行
	private String tradeAccountname;//开户行名称
	private String tradeAccounttype;//账户类型：0私，1公
	private String tradeAmount;//整数，单位元
	private String tradeAmounttype;//人民币：CNY 元
	private String tradeRemark;//用途
	private String contractUsercode;//用户协议号 (代付可空)
	private String tradeFeedbackcode;//tradeFeedbackcode
	private String tradeReason;//反馈原因(可空)
	
	private String status;//请求状态
	private String reason;//失败原因
	
	public String get_input_charset() {
		return _input_charset;
	}
	public void set_input_charset(String _input_charset) {
		this._input_charset = _input_charset;
	}
	public String getBatchBizid() {
		return batchBizid;
	}
	public void setBatchBizid(String batchBizid) {
		this.batchBizid = batchBizid;
	}
	public String getBatchVersion() {
		return batchVersion;
	}
	public void setBatchVersion(String batchVersion) {
		this.batchVersion = batchVersion;
	}
	public String getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	public String getBatchCurrnum() {
		return batchCurrnum;
	}
	public void setBatchCurrnum(String batchCurrnum) {
		this.batchCurrnum = batchCurrnum;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
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
	public String getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}
	public String getTradeCardnum() {
		return tradeCardnum;
	}
	public void setTradeCardnum(String tradeCardnum) {
		this.tradeCardnum = tradeCardnum;
	}
	public String getTradeCardname() {
		return tradeCardname;
	}
	public void setTradeCardname(String tradeCardname) {
		this.tradeCardname = tradeCardname;
	}
	public String getTradeBranchbank() {
		return tradeBranchbank;
	}
	public void setTradeBranchbank(String tradeBranchbank) {
		this.tradeBranchbank = tradeBranchbank;
	}
	public String getTradeSubbranchbank() {
		return tradeSubbranchbank;
	}
	public void setTradeSubbranchbank(String tradeSubbranchbank) {
		this.tradeSubbranchbank = tradeSubbranchbank;
	}
	public String getTradeAccountname() {
		return tradeAccountname;
	}
	public void setTradeAccountname(String tradeAccountname) {
		this.tradeAccountname = tradeAccountname;
	}
	public String getTradeAccounttype() {
		return tradeAccounttype;
	}
	public void setTradeAccounttype(String tradeAccounttype) {
		this.tradeAccounttype = tradeAccounttype;
	}
	public String getTradeAmount() {
		return tradeAmount;
	}
	public void setTradeAmount(String tradeAmount) {
		this.tradeAmount = tradeAmount;
	}
	public String getTradeAmounttype() {
		return tradeAmounttype;
	}
	public void setTradeAmounttype(String tradeAmounttype) {
		this.tradeAmounttype = tradeAmounttype;
	}
	public String getTradeRemark() {
		return tradeRemark;
	}
	public void setTradeRemark(String tradeRemark) {
		this.tradeRemark = tradeRemark;
	}
	public String getContractUsercode() {
		return contractUsercode;
	}
	public void setContractUsercode(String contractUsercode) {
		this.contractUsercode = contractUsercode;
	}
	public String getTradeFeedbackcode() {
		return tradeFeedbackcode;
	}
	public void setTradeFeedbackcode(String tradeFeedbackcode) {
		this.tradeFeedbackcode = tradeFeedbackcode;
	}
	public String getTradeReason() {
		return tradeReason;
	}
	public void setTradeReason(String tradeReason) {
		this.tradeReason = tradeReason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}

