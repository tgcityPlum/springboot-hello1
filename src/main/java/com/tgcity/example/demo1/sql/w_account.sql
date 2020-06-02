/*
Navicat MySQL Data Transfer

Source Server         : tgcity
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : water

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-06-02 10:34:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for w_account
-- ----------------------------
DROP TABLE IF EXISTS `w_account`;
CREATE TABLE `w_account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户id',
  `user_account` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `password_encryption` varchar(255) DEFAULT NULL COMMENT '加密密码',
  `nick_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `platform` varchar(20) DEFAULT NULL COMMENT '平台',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像',
  `open_id` varchar(40) DEFAULT NULL COMMENT '微信公众号id',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `creator` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  `comments` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` bit(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_account
-- ----------------------------
INSERT INTO `w_account` VALUES ('12', 'OxGuWSJCBsBLGf44m3tR2sIAbQIPCQOze', 'tgcity', '6275e63adbd83801e74a17192b736624fea8b2f1223460148e89d352fa4e6261', 'VpfpbOub88JLrFdZ5nF9', '安卓测试账号', '13744448888', '安卓端', 'http://192.168.15.36:10324/water/upload/20200529191901157859.jpg', null, '2020-06-01 14:30:32', '2020-06-01 14:30:32', 'system', 'tgcity', null, '\0');
INSERT INTO `w_account` VALUES ('19', 'd6028229e495778', 'test001', '17a95e13f7e1d583b744be51949cd033f41408faf30d8480e7291dd26f77420f', 'cyVpdED2wHbe8y50lNMY', null, null, '其它', null, null, '2020-05-29 14:42:14', '2020-05-29 14:42:14', '匿名', '匿名', null, '\0');
