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
 * 代付请求接口响应参数封装 
 * @author   songtao
 * @version  1.0
 * @Date	 2015年12月30日 上午11:26:00
 **/
public class ReapalWithdrawResponse {

	private String status;//是否成功  succ ： 成功 ，fail ： 失败
	private String reason;//错误原因
	
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

