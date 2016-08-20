/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.springapp.mvc.dao;


import com.springapp.mvc.model.TradeOrder;
import org.springframework.stereotype.Repository;

/**
 * orderDAO接口
 * @author gjy
 * @version 2016-08-09
 */
@Repository
public interface TradeOrderDao {


   /* Order getOrderById(String id);*/
    TradeOrder get(String id);
    int insert(TradeOrder tradeOrder);

    int update(TradeOrder tradeOrder);

    TradeOrder getOrderByOrderNo(String orderNo);
}