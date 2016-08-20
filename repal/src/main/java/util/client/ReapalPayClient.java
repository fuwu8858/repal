/*****************************************************
 * cn.caijingquan.p2p.reapal.client
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月29日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
******************************************************/

package util.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import util.client.utils.*;

import util.client.utils.xmljson.JsonLib;
import util.client.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * 融宝接口调用封装
 * @author   Administrator
 * @version  1.0
 * @Date	 2015年12月29日 下午1:52:01
 **/
public class ReapalPayClient {
	
	private static Logger LOG = Logger.getLogger(ReapalPayClient.class);




    /**
     *
     * @param request
     * @return
     */

    public static String decryData(HttpServletRequest request){
        String key = ReapalConfig.key;
        String data = request.getParameter("data");
        String encryptkey = request.getParameter("encryptkey");
        LOG.info("充值回调返回数据：data=====>" + data +",encryptkey======>" + encryptkey);


        if(StringUtils.isEmpty(data)||StringUtils.isEmpty(encryptkey)) {
            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("verifyStatus", "fail");
            return resultMap.toString();
        }
        //解析密文数据
        String decryData = "";
        try {
            decryData = Decipher.decryptData(encryptkey,data);
        } catch (Exception e) {
            LOG.error("充值回调返回数据：data=====>" + data +",encryptkey======>" + encryptkey,e);
        }
        System.out.println("解密后的数据:"+decryData);

        return decryData;
    }

    /**
     * 加密数据
     * @param para
     * @return
     */
    public static Map encryData(Map para) {
        // 生成签名
        String mysign = Md5Utils.BuildMysign(para, ReapalConfig.key);
//		String mysign = Md5Utils.BuildMysign(para, "e977ade964836408243b5g2444848f7b39d09fb41c77ae2e327ffb16f905e117");
        LOG.debug("********************签名sign为：" + mysign);
/*        para.put("sign_type", "MD5");
        para.put("sign", mysign);*/
        para.put("merchant_id", ReapalConfig.merchant_id);
        // 将map转化为json 串
        String json = JSON.toJSONString(para);

        LOG.debug("加密前:请求数据=====>json：" + json);

        // 加密数据
        Map<String, String> maps = null;
        try {
            maps = Decipher.encryptData(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        maps.put("merchant_id", ReapalConfig.merchant_id);

        LOG.debug("加密后:数据=====>json：" + JSON.toJSONString(maps));
        return maps;

    }
	
}

