/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 80018
Source Host           : 192.168.15.36:3306
Source Database       : water

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-05-26 14:41:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `party_id` bigint(20) NOT NULL COMMENT '用户对应的PARTY_ID',
  `account_name` varchar(32) DEFAULT NULL COMMENT '账号',
  `open_id` varchar(50) DEFAULT NULL COMMENT '公众号openId',
  `password` varchar(80) DEFAULT NULL COMMENT '密码',
  `password_salt` varchar(50) DEFAULT NULL COMMENT '密码加盐',
  `mobile_phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `true_name` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `credentials_number` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '照片',
  `version` bigint(20) unsigned DEFAULT NULL COMMENT '版本号',
  `deleted` bit(1) DEFAULT b'0' COMMENT '删除标记',
  `creator` varchar(20) DEFAULT NULL,
  `updater` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `party_id` (`party_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息表\r\nAMOUNT = 100000\r\nSELECT = MEDIUM\r\nINSERT = LOW\r\nUPDATE = LOW';

-- ----------------------------
-- Records of t_account
-- ----------------------------
