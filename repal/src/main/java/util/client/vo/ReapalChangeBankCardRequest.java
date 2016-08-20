package util.client.vo;
/**
 *
 * 更新银行卡 鉴权
 * @author   qm
 * @version  1.0
 * @Date	 2015年12月31日 下午7:03:05
 **/
public class ReapalChangeBankCardRequest {

    private String card_no;//银行卡号
    private String cert_no;//身份证号
    private String member_id;//
	private String owner;//姓名
	private String phone;//电话
	private String sign;// 签名
	
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
    public String getCert_no() {
        return cert_no;
    }
    public void setCert_no(String cert_no) {
        this.cert_no = cert_no;
    }
    public String getMember_id() {
        return member_id;
    }
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

