/*
Navicat MySQL Data Transfer

Source Server         : tgcity
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : water

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-06-02 14:05:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for w_river_area
-- ----------------------------
DROP TABLE IF EXISTS `w_river_area`;
CREATE TABLE `w_river_area` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `river_id` bigint(15) NOT NULL COMMENT '河流的id',
  `area_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区域的id',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '逻辑删除标记',
  `creator` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '修改人',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `comments` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `river_area_id` (`river_id`,`area_id`) USING BTREE,
  KEY `river_id` (`river_id`) USING BTREE,
  KEY `area_id` (`area_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=176423 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=COMPACT COMMENT='河流和区域的多对多关系表';

-- ----------------------------
-- Records of w_river_area
-- ----------------------------
