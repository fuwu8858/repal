package util.client.vo;
/**
 * 融宝卡BIN查询返回参数
 * @author hgs
 *
 */
public class ReapalBankCardBINResponse {
	private String bankCardNO;
	private String bankCardName;
	private String bankCode;
	
	public ReapalBankCardBINResponse() {
		
	}
	public String getBankCardNO() {
		return bankCardNO;
	}
	public void setBankCardNO(String bankCardNO) {
		this.bankCardNO = bankCardNO;
	}
	public String getBankCardName() {
		return bankCardName;
	}
	public void setBankCardName(String bankCardName) {
		this.bankCardName = bankCardName;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	
}
