/*****************************************************
 * cn.caijingquan.p2p.reapal.client.enums
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月29日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
******************************************************/

package util.client.message;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 *
 * 查询融宝 错误码信息
 * @author   Administrator
 * @version  1.0
 * @Date	 2015年12月29日 下午12:04:09
 **/
public class ReapalMessage {

	private static ResourceBundle bundle;
	static {
		bundle = ResourceBundle.getBundle("reapalResult");
	}
	
	/**
	 * 查询 错误码信息
	 * @param code
	 * @return
	 */
	public static String getReapalResultMsg(String code){
		if(code != null){
			try{
				return bundle.getString(code);
			}catch(MissingResourceException m){
				return code;
			}
		}
		return null;
	}
}

