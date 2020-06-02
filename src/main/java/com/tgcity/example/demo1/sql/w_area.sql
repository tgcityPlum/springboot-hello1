/*
Navicat MySQL Data Transfer

Source Server         : tgcity
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : water

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-06-02 10:34:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for w_area
-- ----------------------------
DROP TABLE IF EXISTS `w_area`;
CREATE TABLE `w_area` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `area_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区域id',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区域编码',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区域名称',
  `grade` int(11) NOT NULL COMMENT '区域等级 市、区、镇、村',
  `parent_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '该区域所属的父区域',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除标记',
  `creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `ux_area_id` (`area_id`) USING BTREE,
  UNIQUE KEY `code` (`code`) USING BTREE,
  KEY `ix_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6319 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='上海市的各个区域，市、区、镇、村';

-- ----------------------------
-- Records of w_area
-- ----------------------------
INSERT INTO `w_area` VALUES ('6318', '5ab8a66d3bea3f0d186f9fd7', '310105103', '临空园区', '4', '000000000000000000000003', '\0', '匿名', '2020-06-02 10:10:32', '匿名', '2020-06-02 10:10:32', null);
