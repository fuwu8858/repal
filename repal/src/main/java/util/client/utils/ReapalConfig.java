package util.client.utils;

import java.util.ResourceBundle;

public class ReapalConfig {

	private static ResourceBundle bundle;
	
	static{
		bundle = ResourceBundle.getBundle("reapal");
	}
	
	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 商户ID，由纯数字组成的字符串
	public static String merchant_id = bundle.getString("merchant_id");

	// 交易安全检验码，由数字和字母组成的64位字符串
	public static String key = bundle.getString("key");
	// 签约融宝支付账号或卖家收款融宝支付帐户
	public static String seller_email = bundle.getString("seller_email");
	// 通知地址，由商户提供
	public static String notify_url = bundle.getString("notify_url");

	// 卡密认证同步通知地址,由商户提供
	public static String certify_return_url = bundle.getString("certify_return_url");
	// 卡密认证异步通知地址,由商户提供
	public static String certify_notify_url = bundle.getString("certify_notify_url");
	// 卡密认证请求地址 正式地址
	public static String certify_url = bundle.getString("certify_url");

	// 商户私钥
	//public static String privateKey = bundle.getString("privateKey");
	// 私钥密码
	public static String password = bundle.getString("password");
	// 测试环境地址
	public static String rongpay_api = bundle.getString("rongpay_api");

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// 融宝公钥 正式环境不用更换
	//public static String pubKeyUrl = bundle.getString("pubKeyUrl");
	// 访问模式,根据自己的服务器是否支持ssl访问，若支持请选择https；若不支持请选择http
	public static String transport = bundle.getString("transport");
	// 接口版本号
	public static String version = bundle.getString("version");
	// 字符编码格式 目前支持 utf-8
	public static String charset = bundle.getString("charset");
	// 签名方式 不需修改
	public static String sign_type = bundle.getString("sign_type");
	
	///////////////////////////////////////////////////////////////////////
	//终端类型
	public static String TERMINAL_TYPE_WEB = "web";
	public static String TERMINAL_TYPE_WAP = "wap";
	public static String TERMINAL_TYPE_MOBILE = "mobile";
	
	//证件类型
	public static String cert_type = bundle.getString("cert_type");
	//交易币种
	public static String currency = bundle.getString("currency");
	//卡类型    储蓄卡
	public static String bank_card_type = bundle.getString("bank_card_type");
	
	public static String addrbdfq = bundle.getString("addrbdfq");

    //运行环境
	public static String mode = bundle.getString("mode");

    /**
     * 当前运行环境
     * @return
     */
    public  static boolean getIsMode(){
        if(mode.equalsIgnoreCase("dev")){
            return true;
        }else {
            return false;
        }
    }

	//////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args){
		System.out.println(ReapalConfig.addrbdfq);
		System.out.println(ReapalConfig.key);

	}

}
