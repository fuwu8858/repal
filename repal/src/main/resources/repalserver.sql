/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50631
Source Host           : localhost:3306
Source Database       : repalserver

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-08-10 18:00:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for agreement
-- ----------------------------
DROP TABLE IF EXISTS `agreement`;
CREATE TABLE `agreement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(32) NOT NULL COMMENT '用户Id',
  `merchant_id` varchar(32) NOT NULL COMMENT '商户号',
  `card_no` varchar(255) DEFAULT NULL COMMENT '订单号',
  `bind_id` varchar(100) DEFAULT NULL COMMENT '绑卡Id',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '交易时间',
  `relation_id` varchar(100) DEFAULT NULL COMMENT '关联id',
  `cert_no` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `owner` varchar(100) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(100) DEFAULT NULL COMMENT '银行卡号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for trade_order
-- ----------------------------
DROP TABLE IF EXISTS `trade_order`;
CREATE TABLE `trade_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(32) NOT NULL COMMENT '用户Id',
  `member_ip` varchar(32) NOT NULL COMMENT '用户Ip',
  `merchant_id` varchar(32) NOT NULL COMMENT '商户号',
  `notifyUrl` varchar(255) DEFAULT NULL COMMENT '异步通知地址',
  `order_no` varchar(255) DEFAULT NULL COMMENT '订单号',
  `sign` varchar(100) DEFAULT NULL COMMENT '签名',
  `sign_type` varchar(10) DEFAULT NULL COMMENT '签名类型',
  `token_id` varchar(100) DEFAULT NULL COMMENT '请求唯一标识',
  `total_fee` bigint(100) DEFAULT NULL COMMENT '交易金额(分)',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  `trans_time` timestamp NULL DEFAULT NULL COMMENT '交易时间',
  `version` varchar(100) DEFAULT NULL COMMENT '请求接口版本号',
  `bind_id` varchar(100) DEFAULT '0' COMMENT '绑卡Id',
  `status` tinyint(10) DEFAULT '0' COMMENT '订单状态 0 待支付  1  已支付  2  已经异步通知并接到响应 3 异步通知 未接到 响应',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
