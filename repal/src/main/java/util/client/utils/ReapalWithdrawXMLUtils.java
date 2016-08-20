/*****************************************************
 * cn.caijingquan.p2p.reapal.client.utils
 *
 *   ver    		date      			author
 * ──────────────────────────────────
 *   		 		2015年12月30日 			Administrator
 *
 * Copyright (c) 2015, caijinquan.
******************************************************/

package util.client.utils;

import util.client.vo.ReapalWithdrawResponse;
import util.client.vo.WithdrawResultResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *
 * 代付响应参数XML解析
 * @author   Administrator
 * @version  1.0
 * @Date	 2015年12月30日 下午3:57:49
 **/
public class ReapalWithdrawXMLUtils {

	private static Logger LOG = Logger.getLogger(ReapalWithdrawXMLUtils.class);
	
	/**
	 * 解析代付请求响应参数
	 * @param post
	 * @return
	 */
	public static ReapalWithdrawResponse withdrawXML(String post){
		
		if(StringUtils.isNotEmpty(post)){
			ReapalWithdrawResponse response = new ReapalWithdrawResponse();
			
			/*
			 * <Resp>
			 *		<status >fail</ status > 
			 *	  	< reason>商户号不能为空</ reason >  
			 *	</ Resp>
			 * 
			 * 
			 */
//			post =  "<Resp><status >fail</status><reason>商户号不能为空</reason></Resp>";
			try {
				Document doc = DocumentHelper.parseText(post);
				Element root = doc.getRootElement();
				String status = root.elementText("status");
				response.setStatus(status);
				if(!status.equals("succ")){//提现请求失败
					String reason = root.elementText("reason");
					response.setReason(reason);
				}
				return response;
			} catch (DocumentException e) {
				LOG.error("融宝解析提现请求返回参数出错", e);
				return null;
			}
		}
		return null;
	}
	/**
	 * 解析查询代付响应数据
	 * @param post
	 * @return
	 */
	public static WithdrawResultResponse queryWithdrawXML(String post){
		if(StringUtils.isNotEmpty(post)){
			
			Document doc = null;
			try {
				doc = DocumentHelper.parseText(post);
			} catch (DocumentException e) {
				LOG.error("融宝解析提现请求返回参数出错", e);
				return null;
			}
			WithdrawResultResponse response = new WithdrawResultResponse();
			Element root = doc.getRootElement();
			if(post.indexOf("status") != -1){   //失败
				
				/**
				 * 查询提现，银行处理失败返回结果数据
				 * <Resp>
				 * 		<status>fail</status>
				 * 		<reason>&#x6ca1;&#x6709;&#x53d1;&#x73b0;&#x8be5;&#x6279;&#x6b21;&#x7684;&#x4fe1;&#x606f;</reason>
				 * </Resp>
				 */
				
				String status = root.elementText("status");
				String reason = root.elementText("reason");
				
				response.setStatus(status);
				response.setReason(reason);
				
				return response;
			}
			
			String _input_charset = root.elementText("_input_charset");
			String batchBizid = root.elementText("batchBizid");
			String batchVersion = root.elementText("batchVersion");
			String batchDate = root.elementText("batchDate");
			String batchCurrnum = root.elementText("batchCurrnum");
			Element batchContent = root.element("batchContent");
			String detailInfo = batchContent.elementText("detailInfo");
			
			String sign = root.elementText("sign");
			String signType = root.elementText("signType");
			
			response.set_input_charset(_input_charset);
			response.setBatchBizid(batchBizid);
			response.setBatchVersion(batchVersion);
			response.setBatchDate(batchDate);
			response.setBatchCurrnum(batchCurrnum);
			response.setSign(sign);
			response.setSignType(signType);
			
			if(StringUtils.isEmpty(detailInfo)){
				return null;
			}
			/*<Resp>
			  <_input_charset>gbk</_input_charset>
			  <batchBizid>100000000216336</batchBizid>
			  <batchVersion>00</batchVersion>
			  <batchDate>20160128</batchDate>
			  <batchCurrnum>2016012816433718890711</batchCurrnum>
			  <batchContent>
			    <detailInfo>1,6212811702000660766,樊斯斯,分行,支行,中国农业银行,0,100.00,CNY,ok,,失败,记录不存在,错误码:[E99999001]|交易失败</detailInfo>
			  </batchContent>
			  <sign>162aeebaf593ee2cc5c7534a1f415140</sign>
			  <signType>MD5</signType>
			</Resp>*/
			//1,6212811702000660766,樊斯斯,分行,支行,中国农业银行,0,100.00,CNY,ok,,失败,记录不存在,错误码:[E99999001]|交易失败
			//2,6225885917535536,李四,分行,招商银行股份有限公司福州湖东支行,中国工商银行,0,12.00,CNY,代付,111111111111111,失败,账户类型不符
			//1,6228480018305613376,黄松涛,分行,支行,中国农业银行,0,0.01,CNY,ok,,,
			response = analysisDetaiInfo(detailInfo , response);
			
			return response;
			
		}
		return null;
	}
	/**
	 * 解析明细数据
	 * @param detailInfo
	 * @param response
	 * @return
	 */
	private static WithdrawResultResponse analysisDetaiInfo(String detailInfo , WithdrawResultResponse response){
		if(StringUtils.isNotEmpty(detailInfo)){
			detailInfo = detailInfo + ",";
			//1,6228480018305613376,黄松涛,分行,支行,中国农业银行,0,0.01,CNY,ok,,,
			int offset1 = 0 , count = 0;
			String[] arr = new String[18];
			while((offset1 = detailInfo.indexOf(",")) != -1){
	            
				offset1 = offset1 + ",".length();
				arr[count] = detailInfo.substring(0 , offset1);
				detailInfo = detailInfo.substring(offset1, detailInfo.length());
				count++ ;
	        }
			response.setTradeNum(arr[0].replace(",", ""));
			response.setTradeCardnum(arr[1].replace(",", ""));
			response.setTradeCardname(arr[2].replace(",", ""));
			response.setTradeBranchbank(arr[3].replace(",", ""));
			response.setTradeSubbranchbank(arr[4].replace(",", ""));
			response.setTradeAccountname(arr[5].replace(",", ""));
			response.setTradeAccounttype(arr[6].replace(",", ""));
			response.setTradeAmount(arr[7].replace(",", ""));
			response.setTradeAmounttype(arr[8].replace(",", ""));
			response.setTradeRemark(arr[9].replace(",", ""));
			response.setContractUsercode(arr[10].replace(",", ""));
			response.setTradeFeedbackcode(arr[11].replace(",", ""));
			response.setTradeReason(arr[12].replace(",", ""));
			
			return response;
		}
		return null;
	}
	
	public static void main(String[] args){
		
		/*<Resp>
		  		< _input_charset > gbk </ _input_charset > 
		< batchBizid > 100000000001524 </ batchBizid >
			    < batchVersion > 00 </ batchVersion >
		< batchDate > 20130315 </ batchDate >
			    < batchCurrnum > 10002 </ batchCurrnum >
				< batchContent >
		< detailInfo > 1,1111111111111111111,张三,北京分行,朝阳支行,中国工商银行,0,50.1,CNY,工资,111111111111111,,成功, </ detailInfo >
		<detailInfo>2,6225885917535536,李四,分行,招商银行股份有限公司福州湖东支行,中国工商银行,0,12.00,CNY,代付,111111111111111,失败,账户类型不符</ detailInfo >
		< /batchContent >
		< sign> 4728b5cf9b0bf895879a3b5b315b34b9 </ sign>
			    < signType > MD5 </ signType >
		  </ Resp>*/
		/*String post = "<Resp><_input_charset > gbk </_input_charset >" + 
						"<batchBizid > 100000000001524 </batchBizid >" +
						"<batchVersion > 00 </batchVersion >" +
						"<batchDate > 20130315 </batchDate >" +
						"<batchCurrnum > 10002 </batchCurrnum >" +
						"<batchContent >" +
						"<detailInfo>2,6225885917535536,李四,分行,招商银行股份有限公司福州湖东支行,中国工商银行,0,12.00,CNY,代付,111111111111111,失败,账户类型不符</detailInfo >" +
						"</batchContent >" +
						"<sign> 4728b5cf9b0bf895879a3b5b315b34b9 </sign>" +
						"<signType > MD5 </signType >" +
						"</Resp>";*/
		
//		ReapalWithdrawXMLUtils.withdrawXML("aaa");
//		System.out.println(post);
//		ReapalWithdrawXMLUtils.queryWithdrawXML(post.trim());
		
		
		
		analysisDetaiInfo("1,6212811702000660766,樊斯斯,分行,支行,中国农业银行,0,100.00,CNY,ok,,失败,记录不存在,错误码:[E99999001]|交易失败" , new WithdrawResultResponse());
	}
	
}

