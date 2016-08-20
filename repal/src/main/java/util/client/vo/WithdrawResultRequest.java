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
 * @Date	 2015年12月30日 下午5:17:14
 **/
public class WithdrawResultRequest {

	private String sign;//签名字符串
	private String signType;//签名方式
	private String batchBizid;//合作伙伴客户号
	private String _input_charset;//输入编码
	private String batchVersion;//版本号
	private String batchCurrnum;//批次号
	private String batchDate;//日期
	private String tradenum;//明细号
	
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
	public String getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	public String getTradenum() {
		return tradenum;
	}
	public void setTradenum(String tradenum) {
		this.tradenum = tradenum;
	}
	
}

