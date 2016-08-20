package com.springapp.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springapp.mvc.common.DateUtil;
import com.springapp.mvc.dao.TradeOrderDao;
import com.springapp.mvc.model.Agreement;
import com.springapp.mvc.model.Msg;
import com.springapp.mvc.model.TradeOrder;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.TradeOrderService;
import com.springapp.mvc.service.UserService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import util.client.ReapalPayClient;
import util.client.utils.ReapalConfig;
import util.client.utils.ReapalSubmit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

@Controller
@RequestMapping ("/")
public class PaymentController {

    @Resource
    private TradeOrderService tradeOrderService;
    @Resource
    private TradeOrderDao tradeOrderDao;
    @Resource
    private UserService userService;

    @RequestMapping (method = RequestMethod.GET)
    @ResponseBody
    public String printWelcome(ModelMap model, HttpServletRequest request) {
      /*  ReapalPayClient.bankCardQuery(request);*/
        User user=new User();
        user.setName("王晓松");
        user.setPhone("13931200761");
        userService.saveUser(user);
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    /**
     * 银行卡查询
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping (value = "/fast/bankcard/list")
    @ResponseBody
    public String repalServer(ModelMap model, HttpServletRequest request) {
        String data = ReapalPayClient.decryData(request);

        Map map = new HashMap();


        JSONObject jsonObject = JSON.parseObject(data);

        String card_no = jsonObject.get("card_no").toString();



        /*{"bank_card_type":"0",
        "bank_code":"CCB",
        "bank_name":"建设银行",

        "bank_name":"建设银行",
        "card_no":"6214242710498301",
        "merchant_id":"100000000000147",
        "result_code":"0000",
        "result_msg":"查询成功"}*/


        map.put("bank_card_type", "0");

        map.put("bank_code", "CCB");

        map.put("bank_name", "建设银行");

        map.put("card_no", card_no);

        map.put("result_code", "0000");

        map.put("result_msg", "查询成功");

        Map responseData = new HashMap();

        responseData = ReapalPayClient.encryData(map);
        ;

        return JSON.toJSONString(responseData);
        /**
         * {"bank_card_type":"0",
         * "bank_code":"CCB",
         * "bank_name":"建设银行",
         * "card_no":"6214242710498301",
         * "merchant_id":"100000000000147",
         * "result_code":"0000",
         * "result_msg":"查询成功"}
         */
    }
    /**
     {"body":"body",
     "card_no":"6214242710498301",
     "cert_no":"210302196001012114",
     "cert_type":"01",
     "currency":"156",
     "member_id":"bdfq25",
     "member_ip":"member_ip",
     "merchant_id":"100000000000147",
     "notify_url":"http://www.aaabbb.com/reapal_notify.jsp",
     "order_no":"20160808174204","owner":"韩梅梅",
     "phone":"13220482188","seller_email":"820061154@qq.com",
     "sign":"43c26f987210a79c12abae7d3c6d3e07",
     "sign_type":"MD5",
     "terminal_info":"djddh",
     "terminal_type":"mobile",
     "title":"title",
     "token_id":"c563c08fb07748ed9b1aa4c1cc2a6798",
     "total_fee":"100",
     "transtime":"2016-08-08 17:42:04",
     "version":"3.1.3"}
     }

     */
    /**
     * 银行卡 首次  签约  返回的  参数
     *
     * @param model
     * @param request
     * @return json数据=============>{"bank_code":"CCB",
     * "bank_name":"建设银行","bind_id":"343546",
     * "merchant_id":"100000000000147",
     * "order_no":"20160808174204",
     * "result_code":"0000",
     * "result_msg":"签约成功"}
     */


    @RequestMapping (value = "/fast/debit/portal")
    @ResponseBody
    public String repalFirstBindServer(ModelMap model, HttpServletRequest request) {
        String data = ReapalPayClient.decryData(request);

        Map map = new HashMap();


        JSONObject jsonObject = JSON.parseObject(data);

        String order_no = jsonObject.get("order_no").toString();
        Msg msg = new Msg();

        Agreement agreement = tradeOrderService.insert(jsonObject, msg);


        map.put("bank_code", "CCB");

        map.put("bank_name", "建设银行");

        map.put("bind_id", agreement.getBindId());

        map.put("order_no", order_no);

        map.put("result_code", msg.getStatus());

        map.put("result_msg", msg.getMsg());

        Map responseData = new HashMap();

        responseData = ReapalPayClient.encryData(map);
        ;

        return JSON.toJSONString(responseData);
        /**
         * {"bank_card_type":"0",
         * "bank_code":"CCB",
         * "bank_name":"建设银行",
         * "card_no":"6214242710498301",
         * "merchant_id":"100000000000147",
         * "result_code":"0000",
         * "result_msg":"查询成功"}
         */
    }

    /**
     * 接收到的 参数
     * {"bind_id":"343546",
     * "body":"yyyy",
     * "currency":"156",
     * "member_id":"bdfq25",
     * "member_ip":"member_ip",
     * "merchant_id":"100000000000147",
     * "notify_url":"http://www.aaabbb.com/reapal_notify.jsp",
     * "order_no":"20160808180403",
     * "seller_email":"820061154@qq.com",
     * "sign":"fbc1da14ad538fcfd44d05e2d1a9afa3",
     * "sign_type":"MD5",
     * "terminal_info":"djddh",
     * "terminal_type":"mobile",
     * "title":"yyyyy",
     * "token_id":"1788850685d4494fa1e5503f9836164b",
     * "total_fee":"100",
     * "transtime":"2016-08-08 18:04:03",
     * "version":"3.1.3"}
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping (value = "/fast/bindcard/portal")
    @ResponseBody
    public String repalSecondBindServer(ModelMap model, HttpServletRequest request) {
        String data = ReapalPayClient.decryData(request);

        Map map = new HashMap();


        JSONObject jsonObject = JSON.parseObject(data);
        Msg msg = new Msg();
        tradeOrderService.insert(jsonObject, msg);

        String order_no = jsonObject.get("order_no").toString();

        map.put("bank_code", "CCB");

        map.put("bank_name", "建设银行");


        map.put("order_no", order_no);

        map.put("result_code", msg.getStatus());

        map.put("result_msg", msg.getMsg());

        Map responseData = new HashMap();

        responseData = ReapalPayClient.encryData(map);
        ;

        return JSON.toJSONString(responseData);
        /**
         * {"bank_code":"CCB",
         * "bank_name":"建设银行",

         * "order_no":"20160808180403",
         * "result_code":"0000",
         * "result_msg":"签约成功"}
         */
    }

    /**
     * 确认支付
     * {"check_code":"123456",
     * "merchant_id":"100000000000147",
     * "order_no":"20160808180403",
     * "sign":"427c62d5d827c74832b5ee1e5abed712",
     * "sign_type":"MD5",
     * "version":"3.1.3"}
     *
     * @param model
     * @param request
     * @return
     */

    @RequestMapping (value = "/fast/pay")
    @ResponseBody
    public synchronized String repalConfirmPayServer(ModelMap model, HttpServletRequest request) {

        String data = ReapalPayClient.decryData(request);

        Map map = new HashMap();


        JSONObject jsonObject = JSON.parseObject(data);

        final String order_no = jsonObject.get("order_no").toString();
        final TradeOrder tradeOrder = tradeOrderDao.getOrderByOrderNo(order_no);
        if (tradeOrder != null && "666888".equalsIgnoreCase(jsonObject.getString("check_code"))) {
            map.put("bank_card_type", "1");

            map.put("bank_code", "CCB");

            map.put("bank_name", "建设银行");

            map.put("bind_id", tradeOrder.getBindId());

            map.put("card_last", "8301");


            map.put("order_no", order_no);

            map.put("phone", "13220482188");
            map.put("trade_no", "trade_no" + order_no);
            if (tradeOrder.getStatus() == 0) {
                map.put("result_code", "0000");

                map.put("result_msg", "扣款成功");

                tradeOrder.setUpdateTime(DateUtil.getCurrDateTime());
                tradeOrder.setStatus(1);
                tradeOrderDao.update(tradeOrder);
            } else {
                map.put("result_code", "3017");

                map.put("result_msg", "交易订单已经支付成功，不允许再发起支付请求");
            }

        } else {
            if ("666888".equalsIgnoreCase(jsonObject.getString("check_code"))) {
                map.put("result_code", "3015");

                map.put("result_msg", "订单不存在");
            } else {
                map.put("result_code", "3069");

                map.put("result_msg", "验证码错误");
            }

        }

        Map responseData = new HashMap();

        responseData = ReapalPayClient.encryData(map);
        ;
        Executors.newFixedThreadPool(1).execute(new Runnable() {
            @Override
            public void run() {
                //插入充值失败记录


                payCallBack(tradeOrder);


            }
        });

        return JSON.toJSONString(responseData);
        /**
         * {"bank_code":"CCB",
         * "bank_name":"建设银行",

         * "order_no":"20160808180403",
         * "result_code":"0000",
         * "result_msg":"签约成功"}
         */
    }
/*  确认支付 返回结果
* {"bank_card_type":"1",
* "bank_code":"CCB",
* "bank_name":"建设银行",
* "bind_id":"343546",
* "card_last":"8301",
* "merchant_id":"100000000000147",
* "order_no":"20160808180403",
* "phone":"13220482188",
* "result_code":"0000",
* "result_msg":"扣款成功",
* "trade_no":"10160808000011364"}
*
*
* */
    //重发短信

    /**
     * {"merchant_id":"100000000000147",
     * "order_no":"13260451145",
     * "sign":"7bba22734336ac6d61202ee1d7e31ab4",
     * "sign_type":"MD5",
     * "version":"3.1.3"}
     */

    @RequestMapping (value = "/fast/sms")
    @ResponseBody
    public String repalReSmsServer(ModelMap model, HttpServletRequest request) {
        String data = ReapalPayClient.decryData(request);

        Map map = new HashMap();


        JSONObject jsonObject = JSON.parseObject(data);

        String order_no = jsonObject.get("order_no").toString();

        TradeOrder tradeOrder = tradeOrderDao.getOrderByOrderNo(order_no);

        if (tradeOrder == null) {


            map.put("result_code", "3015");

            map.put("result_msg", "订单不存在");

        } else {
            map.put("result_code", "0000");

            map.put("result_msg", "发送成功");
        }
        map.put("order_no", order_no);

        map.put("phone", "13220482188");
        Map responseData = new HashMap();

        responseData = ReapalPayClient.encryData(map);
        ;

        return JSON.toJSONString(responseData);

    }

    /*  确认支付 返回结果
    {"merchant_id":"100000000000147",
    "order_no":"13260451145",
    "phone":"13220482188",
    "result_code":"0000",
    "result_msg":"发送成功"}
    * */
    @RequestMapping (value = "/fast/payCallBack")

    public String repalPayCallBackServer(String order_no, String total_fee, HttpServletRequest request) {


        Map<String, String> map = new HashMap<String, String>();
        map.put("merchant_id", ReapalConfig.merchant_id);
        map.put("version", ReapalConfig.version);
        //订单号
        map.put("notify_id", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

        map.put("order_no", order_no);
        map.put("status", "TRADE_FINISHED");

        map.put("total_fee", total_fee);

        map.put("trade_no", "trade_no" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

/*        "notify_id": "8c9ff9d80e744c939c4646dbc841ebbb",
                "order_no": "102015090119375101",
                "status": "TRADE_FINISHED",
                "total_fee": "1",
                "trade_no": "101509010233137"
        “merchant_id":"100000000009085"*/
        //请求接口
        String url = "/fast/payCallBack";
        //返回结果
        String post = null;
        try {
            post = ReapalSubmit.buildSubmit(map, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("返回结果post==========>" + post);
        if (post.contains("success")) {
            System.out.println("**************************************");
        }

        return "hello";

    }

    private void payCallBack(TradeOrder tradeOrder) {
        Map<String, String> map = new HashMap<String, String>();
        /*		map.put("merchant_id", merchant_id);
		map.put("trade_no", trade_no);
		map.put("order_no", order_no);
		map.put("total_fee", total_fee);
		map.put("status", status);
		map.put("notify_id", notify_id);*/

        map.put("merchant_id", ReapalConfig.merchant_id);

        //订单号
        map.put("notify_id", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

        map.put("order_no", tradeOrder.getOrderNo());
        map.put("status", "TRADE_FINISHED");

        map.put("total_fee", tradeOrder.getTotalFee());

        map.put("trade_no", "trade_no" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));

/*        "notify_id": "8c9ff9d80e744c939c4646dbc841ebbb",
                "order_no": "102015090119375101",
                "status": "TRADE_FINISHED",
                "total_fee": "1",
                "trade_no": "101509010233137"
        “merchant_id":"100000000009085"*/
        //请求接口
        String url = tradeOrder.getNotifyurl();
        //返回结果
        String post = null;


        boolean status = false;
        for (int i = 1; i <= 4; i++) {

            try {
                post = ReapalSubmit.buildSubmitPayCallBack(map, url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("返回结果post==========>" + post);
            if (post.contains("success")) {
                status = true;
                break;
            }

            try {
                //线程等待30秒
                Thread.sleep(1000 * 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        if (status) {

            tradeOrder.setStatus(2);//正确 客户端响应

        } else {
            tradeOrder.setStatus(3);//错误 客户端响应
        }

        tradeOrder.setUpdateTime(DateUtil.getCurrDateTime());

        tradeOrderDao.update(tradeOrder);
    }

    public static void main(String[] args) {

    }
}