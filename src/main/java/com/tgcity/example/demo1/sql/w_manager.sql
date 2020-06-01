/*
Navicat MySQL Data Transfer

Source Server         : tgcity
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : water

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-06-01 18:07:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for w_manager
-- ----------------------------
DROP TABLE IF EXISTS `w_manager`;
CREATE TABLE `w_manager` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `manager_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '河长id',
  `manager_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '河长姓名',
  `mobile_phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '河长职务',
  `river_level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '河长级别，河长| 总河长| 副总河长',
  `admin_level` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '行政级别',
  `duty_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最高职务所在单位',
  `unit_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '单位类别',
  `area_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '行政区划河长和行政区的一对一关系',
  `leader_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '主要领导',
  `is_note` bit(1) DEFAULT NULL COMMENT '是否公告',
  `river_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '河长类型',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除标记',
  `creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `ux_manager_id` (`manager_id`) USING BTREE,
  KEY `area_id` (`area_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='河长表';

-- ----------------------------
-- Records of w_manager
-- ----------------------------
