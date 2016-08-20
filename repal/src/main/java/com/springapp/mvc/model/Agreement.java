package com.springapp.mvc.model;

/** 签约
 * @author gjy
 * @Description: -com.springapp.mvc.model
 * @date 2016/8/9 16:26
 */
public class Agreement {
    private long id;

    private String memberId;		// 用户Id

    private String merchantId;		// 商户号

    private String bindId;     //绑卡Id

    private String relationId;     //相关Id


    private String cardNo;		// 银行卡号

     private String certNo;		// 身份证号

    private String createTime;		// 创建时间

    private String phone;		// 手机号

    private String owner;		// 姓名

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getBindId() {
        return bindId;
    }

    public void setBindId(String bindId) {
        this.bindId = bindId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCreateTime() {
        return createTime;
    }



    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
