package com.springapp.mvc.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springapp.mvc.common.DateUtil;
import com.springapp.mvc.dao.AgreementDao;
import com.springapp.mvc.dao.TradeOrderDao;
import com.springapp.mvc.model.Agreement;
import com.springapp.mvc.model.Msg;
import com.springapp.mvc.model.TradeOrder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author gjy
 * @Description: -com.springapp.mvc.service
 * @date 2016/8/9 10:52
 */

/**
 * {"body":"body",
 * "card_no":"6214242710498301",
 * "cert_no":"210302196001012114",
 * "cert_type":"01",
 * "currency":"156",
 * "member_id":"bdfq25",
 * "member_ip":"member_ip",
 * "merchant_id":"100000000000147",
 * "notify_url":"http://www.aaabbb.com/reapal_notify.jsp",
 * "order_no":"20160808174204",
 * "owner":"韩梅梅",
 * "phone":"13220482188","seller_email":"820061154@qq.com",
 * "sign":"43c26f987210a79c12abae7d3c6d3e07",
 * "sign_type":"MD5",
 * "terminal_info":"djddh",
 * "terminal_type":"mobile",
 * "title":"title",
 * "token_id":"c563c08fb07748ed9b1aa4c1cc2a6798",
 * "total_fee":"100",
 * "transtime":"2016-08-08 17:42:04",
 * "version":"3.1.3"}
 * }
 */
@Service
public class TradeOrderService {
   private  static Logger logger= LoggerFactory.getLogger(TradeOrderService.class);
    @Resource
    private TradeOrderDao tradeOrderDao;
    @Resource
    private AgreementDao agreementDao;

    public TradeOrder getOrderById(String id) {
        return tradeOrderDao.get(id);
    }

    /**
     * 插入记录 首次签约 记录
     *
     * @param jsonObject
     * @return
     */
    public Agreement insert(JSONObject jsonObject,Msg msg) {
        TradeOrder tradeOrder = new TradeOrder();
        tradeOrder.setMemberId(jsonObject.get("member_id").toString());
        tradeOrder.setMemberIp(jsonObject.get("member_ip").toString());

        tradeOrder.setMerchantId(jsonObject.get("merchant_id").toString());
        tradeOrder.setNotifyurl(jsonObject.get("notify_url").toString());
        tradeOrder.setOrderNo(jsonObject.get("order_no").toString());


        tradeOrder.setSign(jsonObject.get("sign").toString());

        tradeOrder.setSignType(jsonObject.get("sign_type").toString());
        tradeOrder.setTokenId(jsonObject.get("token_id").toString());
        tradeOrder.setTotalFee(jsonObject.get("total_fee").toString());
        tradeOrder.setTransTime(jsonObject.get("transtime").toString());
        tradeOrder.setUpdateTime(DateUtil.getCurrDateTime());
        tradeOrder.setStatus(0);//待支付状态
        tradeOrder.setVersion(jsonObject.get("version").toString());
        if (StringUtils.isNotBlank(jsonObject.getString("bind_id"))) {
             logger.info("非首次签约");
            tradeOrder.setBindId(jsonObject.getString("bind_id"));
            //校验bingId 的  取值
            Agreement agreement = new Agreement();
            agreement.setBindId(tradeOrder.getBindId());
            agreement= agreementDao.findAgreementByBindId(agreement);
            //bindId 不一致
            if(agreement==null){
                logger.info("tradeOrder.bindId【{}】不存在",tradeOrder.getBindId());
                msg.setStatus("3072");
                msg.setMsg("无效的绑卡ID");
               return agreement;
            }else{

                if(!agreement.getMemberId().equalsIgnoreCase(tradeOrder.getMemberId())){

                    logger.info("agreement.memberId【{}】------bindId有误-------tradeOrder.memberId",agreement.getMemberId(),tradeOrder.getMemberId());
                    msg.setStatus("2031");
                    msg.setMsg("会员id与原绑卡id不一致");


                    return agreement;
                }

            }

        } else {
            logger.info("首次签约");
            tradeOrder.setCardNo(jsonObject.get("card_no").toString());
            tradeOrder.setCertNo(jsonObject.get("cert_no").toString());
            tradeOrder.setOwner(jsonObject.get("owner").toString());
            tradeOrder.setBindId(System.currentTimeMillis() + "");
            tradeOrder.setPhone(jsonObject.get("phone").toString());
        }



        Agreement resultAgreement = null;
        if (StringUtils.isBlank(jsonObject.getString("bind_id"))) {
            Agreement agreement = new Agreement();
            agreement.setMerchantId(tradeOrder.getMerchantId());
            agreement.setCardNo(tradeOrder.getCardNo());
            resultAgreement = agreementDao.findAgreement(agreement);

            if (resultAgreement == null) {
                logger.info("【{}】******************************该用户尚未签约",tradeOrder.getMemberId());
                agreement.setMemberId(tradeOrder.getMemberId());

                tradeOrderDao.insert(tradeOrder);

                agreement.setBindId(tradeOrder.getBindId());
                agreement.setCreateTime(DateUtil.getCurrDateTime());
                agreement.setRelationId(tradeOrder.getId() + "");
                agreement.setOwner(tradeOrder.getOwner());
                agreement.setPhone(tradeOrder.getPhone());
                agreement.setCertNo(tradeOrder.getCertNo());
                agreementDao.insert(agreement);
                resultAgreement = agreement;
            } else {
                tradeOrder.setBindId(resultAgreement.getBindId());
                tradeOrderDao.insert(tradeOrder);
                logger.info("【{}】******************************该用户已经签约",tradeOrder.getMemberId());
            }
        }else {
            logger.info("根据绑卡id签约");
            tradeOrderDao.insert(tradeOrder);
        }

        msg.setStatus("0000");

        msg.setMsg("签约成功");

        return resultAgreement;
    }


}
