package util.client.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ResourceBundle;
import java.util.UUID;

public class ReapalUtil {
	/**
	 * 获得一个UUID
	 * @return String UUID
	 */
	public static String getUUID(){
		String s = UUID.randomUUID().toString();
		//去掉“-”符号
		return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
	}
	/**
	 * 连连银行编码转融宝银行编码
	 * @param llBankCode
	 * @return
	 */
	public static String getReapalBank(String llBankCode){
		
		if(StringUtils.isNotEmpty(llBankCode)){
			if(llBankCode.equals("icbc")){
				return "ICBC";
			}
			if(llBankCode.equals("ceb")){
				return "CEB";
			}
			if(llBankCode.equals("hxb")){
				return "HXB";
			}
			if(llBankCode.equals("ccb")){
				return "CCB";
			}
			if(llBankCode.equals("abc")){
				return "ABC";
			}
			if(llBankCode.equals("pab")){
				return "PAYH";
			}
			if(llBankCode.equals("spdb")){
				return "SPDB";
			}
			if(llBankCode.equals("cib")){
				return "CIB";
			}
			if(llBankCode.equals("cmb")){
				return "CMB";
			}
			if(llBankCode.equals("boc")){
				return "BOC";
			}
			if(llBankCode.equals("citic")){
				return "CITIC";
			}
			if(llBankCode.equals("post")){
				return "PSBC";
			}
			if(llBankCode.equals("cmbc")){
				return "CMBC";
			}
			if(llBankCode.equals("cgb")){
				return "CGB";
			}
		}
		
		return llBankCode;
	}
	/**
	 * 获取融宝快捷支付银行列表字符串
	 * @param bankCardCode
	 * @return
	 */
	public static String bankCardReapalList(){
		ResourceBundle bundle = ResourceBundle.getBundle("reapal");
		String bankCardList = bundle.getString("bank_card_list");
		return bankCardList;
	}
	/**
	 * 获取银行名称
	 * @param bankCardCode
	 * @return
	 */
	public static String getBankCardDesc(String bankCardCode){
		
		if(StringUtils.isNotEmpty(bankCardCode)){
			if(bankCardCode.equals("ICBC")){
				return "中国工商银行";
			}
			if(bankCardCode.equals("ABC")){
				return "中国农业银行";
			}
			if(bankCardCode.equals("BOC")){
				return "中国银行";
			}
			if(bankCardCode.equals("CCB")){
				return "中国建设银行";
			}
			if(bankCardCode.equals("PSBC")){
				return "中国邮政储蓄银行";
			}
			if(bankCardCode.equals("CITIC")){
				return "中信银行";
			}
			if(bankCardCode.equals("CEB")){
				return "光大银行";
			}
			if(bankCardCode.equals("CMBC")){
				return "民生银行";
			}
			if(bankCardCode.equals("PAYH")){
				return "平安银行";
			}
			if(bankCardCode.equals("CIB")){
				return "兴业银行";
			}
			if(bankCardCode.equals("CMB")){
				return "中国招商银行";
			}
			if(bankCardCode.equals("CGB")){
				return "广发银行";
			}
			if(bankCardCode.equals("HXB")){
				return "华夏银行";
			}
			if(bankCardCode.equals("SPDB")){
				return "浦发银行";
			}
			if(bankCardCode.equals("BCCB")){
				return "北京银行";
			}
			if(bankCardCode.equals("SHBANK")){
				return "上海银行";
			}
			if(bankCardCode.equals("BOCM")){
				return "交通银行";
			}
		}
		return null;
	}
	/**
	 * 
	 */
public static String getBankCards(String bankCardCode){
		
		if(StringUtils.isNotEmpty(bankCardCode)){
			if(bankCardCode.equals("ICBC")){
				return "中国工商银行";
			}
			if(bankCardCode.equals("ABC")){
				return "中国农业银行";
			}
			if(bankCardCode.equals("BOC")){
				return "中国银行";
			}
			if(bankCardCode.equals("CCB")){
				return "中国建设银行";
			}
			if(bankCardCode.equals("PSBC")){
				return "中国邮政储蓄银行";
			}
			if(bankCardCode.equals("CITIC")){
				return "中信银行";
			}
			if(bankCardCode.equals("CEB")){
				return "光大银行";
			}
			if(bankCardCode.equals("CMBC")){
				return "民生银行";
			}
			if(bankCardCode.equals("PAYH")){
				return "平安银行";
			}
			if(bankCardCode.equals("CIB")){
				return "兴业银行";
			}
			if(bankCardCode.equals("CMB")){
				return "中国招商银行";
			}
			if(bankCardCode.equals("CGB")){
				return "广发银行";
			}
			if(bankCardCode.equals("HXB")){
				return "华夏银行";
			}
			if(bankCardCode.equals("ICBC")){
				return "浦发银行";
			}
			if(bankCardCode.equals("BCCB")){
				return "北京银行";
			}
			if(bankCardCode.equals("SHBANK")){
				return "上海银行";
			}
			if(bankCardCode.equals("BOCM")){
				return "交通银行";
			}
			//连连
//			icbc = 01020000:中国工商银行
//			ccb = 01050000:中国建设银行
//			abc = 01030000:中国农业银行

			if(bankCardCode.equals("icbc")){
				return "中国工商银行";
			}
			if(bankCardCode.equals("ccb")){
				return "中国建设银行";
			}
			if(bankCardCode.equals("abc")){
				return "中国农业银行";
			}
//			cmb = 03080000:招商银行
//			bcom = 03010000:交通银行
//			boc = 01040000:中国银行
//			ceb = 03030000:光大银行
//			cmbc = 03050000:民生银行
			if(bankCardCode.equals("cmb")){
				return "招商银行";
			}
			if(bankCardCode.equals("bcom")){
				return "交通银行";
			}
			if(bankCardCode.equals("boc")){
				return "中国银行";
			}
			if(bankCardCode.equals("ceb")){
				return "光大银行";
			}
			if(bankCardCode.equals("cmbc")){
				return "民生银行";
			}
//			cib = 03090000:兴业银行
//			citic = 03020000:中信银行
//			cgb = 03060000:广发银行
//			spdb = 03100000:浦发银行

			if(bankCardCode.equals("cib")){
				return "兴业银行";
			}
			if(bankCardCode.equals("citic")){
				return "中信银行";
			}
			if(bankCardCode.equals("cgb")){
				return "广发银行";
			}
			if(bankCardCode.equals("spdb")){
				return "浦发银行";
			}
//			pab = 03700000:平安银行
//			hxb = 03040000:华夏银行
//			post = 01000000:中国邮储银行

			if(bankCardCode.equals("pab")){
				return "平安银行";
			}
			if(bankCardCode.equals("hxb")){
				return "华夏银行";
			}
			if(bankCardCode.equals("post")){
				return "中国邮储银行";
			}
//			srcb = 65012900:上海农商银行
//			bob = 04031000:北京银行
			if(bankCardCode.equals("srcb")){
				return "上海农商银行";
			}
			if(bankCardCode.equals("bob")){
				return "北京银行";
			}
		}
		return null;
	}
	
	
}
