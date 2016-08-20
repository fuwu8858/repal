package util.client.utils;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.util.Map;

/* *
 *类名：ReapalSubmit
 *功能：融宝各接口请求提交类
 *详细：构造融宝各接口发送请求数据，获取远程HTTP数据
 *版本：3.1.2
 *日期：2015-08-15
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究融宝接口使用，只是提供一个参考。
 */

public class ReapalSubmit {
	
	private static Logger LOG = Logger.getLogger(ReapalSubmit.class);
	
	/**
	 * 快捷支付发送请求
	 * 
	 * @return 返回结果
	 */
	public static String buildSubmit(Map<String, String> para, String url)
			throws Exception {
		// 生成签名
		String mysign = Md5Utils.BuildMysign(para, ReapalConfig.key);
//		String mysign = Md5Utils.BuildMysign(para, "e977ade964836408243b5g2444848f7b39d09fb41c77ae2e327ffb16f905e117");
		LOG.debug("********************签名sign为：" + mysign);
		para.put("sign_type", "MD5");
		para.put("sign", mysign);
		// 将map转化为json 串
		String json = JSON.toJSONString(para);
		
		LOG.debug("加密前:请求融宝数据=====>json：" + json);
		
		// 加密数据
		Map<String, String> maps = Decipher.encryptData(json);
		maps.put("merchant_id", ReapalConfig.merchant_id);
		
		LOG.debug("加密后:请求融宝数据=====>json：" + JSON.toJSONString(maps));
		// 发送请求 并接收
		String post = HttpClientUtil.post(ReapalConfig.rongpay_api + url, maps);
		return post;
	}
    /**
     * 确认支付后   异步通知
     *
     * @return 返回结果
     */
    public static String buildSubmitPayCallBack(Map<String, String> para, String url)
            throws Exception {
        // 生成签名
        String mysign = Md5Utils.BuildMysign(para, ReapalConfig.key);
//		String mysign = Md5Utils.BuildMysign(para, "e977ade964836408243b5g2444848f7b39d09fb41c77ae2e327ffb16f905e117");
        LOG.debug("********************签名sign为：" + mysign);
        para.put("sign_type", "MD5");
        para.put("sign", mysign);
        // 将map转化为json 串
        String json = JSON.toJSONString(para);

        LOG.debug("加密前:异步通知商户数据=====>json：" + json);

        // 加密数据
        Map<String, String> maps = Decipher.encryptData(json);
        maps.put("merchant_id", ReapalConfig.merchant_id);

        LOG.debug("加密前:异步通知商户数据=====>json：" + JSON.toJSONString(maps));
        // 发送请求 并接收
        String post = HttpClientUtil.post(url, maps);
        return post;
    }
	/**
	 * 代付发送请求
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String withdrawSubmit(Map<String, String> para ,String url) throws Exception{
		
		String post = HttpClientUtil.postWithdraw(url , para);
		
		return post;
	}
	/**
	 * 代付查询
	 */
	public static String withdrawQuery(String url) throws Exception{
		String data = HttpClientUtil.get(url);
		return data;
	}
}
