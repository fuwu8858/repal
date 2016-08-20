/*****************************************************
 * cn.caijingquan.p2p.reapal.client.utils
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月29日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
******************************************************/

package util.client.utils;

import java.util.ResourceBundle;

/**
 *
 * 代付参数配置实体封装
 * @author   songtao
 * @version  1.0
 * @Date	 2015年12月29日 下午7:04:29
 **/
public class ReapalWithdrawConfig {

	private static ResourceBundle bundle ;
	static {
		bundle = ResourceBundle.getBundle("reapal");
	}
	
	public static String partner = bundle.getString("partner");
    public static String key = bundle.getString("paid_key");
    public static String batchVersion = bundle.getString("batchVersion");
    public static String bizType = bundle.getString("bizType");
    public static String input_charset = bundle.getString("input_charset");
    public static String sign_type = bundle.getString("sign_type");
    public static String fkgate = bundle.getString("fkgate");
    public static String addr = bundle.getString("addr");
//    public static String payquerynew = bundle.getString("payquerynew");    //诺远
//    public static String collquerynew = bundle.getString("collquerynew");    //诺远
    public static String addrsingle = bundle.getString("addrsingle");
    public static String skgate = bundle.getString("skgate");
    public static String skaddr = bundle.getString("skaddr");
    public static String skaddrsingle = bundle.getString("skaddrsingle");
    public static String dsfacc = bundle.getString("dsfacc");
    public static String batchCount = bundle.getString("batchCount");
    
    public static String serialNumber = "1";
    public static String branchBank = "分行";
    public static String subbranchBank = "支行";
    public static String accountType = "私";
    public static String currency_type = bundle.getString("currency_type");//币种
    public static String document_type = "身份证";
    public static String protocol_number = bundle.getString("protocol_number");//用户协议号  代付一般用不到可以为空字符串
    
    public static String withdraw_publicKey = bundle.getString("withdraw_publicKey");
    public static String withdraw_privateKey = bundle.getString("withdraw_privateKey");
    public static String withdraw_reapal_publicKey = bundle.getString("withdraw_reapal_publicKey");
    
    public static void main(String[] args){
    	System.out.println(ReapalWithdrawConfig.withdraw_publicKey);
    	System.out.println(ReapalWithdrawConfig.withdraw_privateKey);
    	System.out.println(ReapalWithdrawConfig.withdraw_reapal_publicKey);
    }
	
}

