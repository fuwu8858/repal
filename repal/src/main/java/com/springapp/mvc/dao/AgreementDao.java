package com.springapp.mvc.dao;

import com.springapp.mvc.model.Agreement;
import com.springapp.mvc.model.TradeOrder;
import org.springframework.stereotype.Repository;

/** 签约
 * @author gjy
 * @Description: -com.springapp.mvc.model
 * @date 2016/8/9 16:26
 */
@Repository
public interface AgreementDao {

    int insert(Agreement agreement);

    Agreement findAgreement(Agreement agreement);

    Agreement findAgreementByBindId(Agreement agreement);
}
