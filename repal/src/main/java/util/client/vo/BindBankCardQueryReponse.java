/*****************************************************
 * cn.caijingquan.p2p.reapal.client.vo
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2016年1月12日 			Administrator
 *
 * Copyright (c) 2016, caijinquan.
******************************************************/

package util.client.vo;

import java.util.List;

/**
 *
 *
 * @author   Administrator
 * @version  1.0
 * @Date	 2016年1月12日 下午2:28:33
 **/
public class BindBankCardQueryReponse {

	private String merchant_id;//商户ID
	private String member_id;//用户ID
	
	private List<BindBankCardQuery> bind_card_list;
	
	
	
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public List<BindBankCardQuery> getBind_card_list() {
		return bind_card_list;
	}
	public void setBind_card_list(List<BindBankCardQuery> bind_card_list) {
		this.bind_card_list = bind_card_list;
	}
	
}

