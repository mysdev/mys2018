/*
Navicat MySQL Data Transfer

Source Server         : Local-VBox-192.168.132.26
Source Server Version : 50719
Source Host           : 192.168.135.101:3306
Source Database       : aaa

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-01-09 14:49:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tc_clock_broadcast
-- ----------------------------
DROP TABLE IF EXISTS `tc_clock_broadcast`;
CREATE TABLE `tc_clock_broadcast` (
  `broadcast_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录标识',
  `stauts` int(11) NOT NULL DEFAULT '0' COMMENT '记录状态 0待播 播放次数',
  `types` int(11) DEFAULT NULL COMMENT '播报类型',
  `content` varchar(256) NOT NULL COMMENT '播报内容',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`broadcast_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报钟播报';

-- ----------------------------
-- Table structure for tc_clock_order
-- ----------------------------
DROP TABLE IF EXISTS `tc_clock_order`;
CREATE TABLE `tc_clock_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `authorization_id` varchar(32) NOT NULL COMMENT '授权标识',
  `types` int(11) NOT NULL COMMENT '来源类型 0房间1手环',
  `object_id` varchar(32) NOT NULL COMMENT '来源标识',
  `status` int(11) NOT NULL COMMENT '订单状态 0等待1进行中2完成4取消',
  `material_id` varchar(0) NOT NULL COMMENT '服务标识',
  `goods_id` varchar(0) NOT NULL COMMENT '商品标识',
  `goods_time` int(11) NOT NULL COMMENT '服务时长',
  `technician_id` varchar(32) NOT NULL COMMENT '技师标识',
  `customer_note` varchar(256) DEFAULT NULL COMMENT '客户备注',
  `note` varchar(256) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Table structure for tc_clock_record
-- ----------------------------
DROP TABLE IF EXISTS `tc_clock_record`;
CREATE TABLE `tc_clock_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '应钟标识',
  `order_id` int(11) NOT NULL COMMENT '订单标识',
  `technician_id` int(11) NOT NULL COMMENT '技师标识',
  `class_id` int(11) NOT NULL COMMENT '归属轮班',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '应钟状态 正常0 过时1',
  `begin_time` datetime DEFAULT NULL COMMENT '上钟时间',
  `end_time` datetime DEFAULT NULL COMMENT '预计下钟时间',
  `acture_time` datetime DEFAULT NULL COMMENT '实际下钟时间',
  `record_status` int(11) DEFAULT NULL COMMENT '服务状态 0完成 1退换',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应钟记录';

-- ----------------------------
-- Table structure for tc_clock_skill
-- ----------------------------
DROP TABLE IF EXISTS `tc_clock_skill`;
CREATE TABLE `tc_clock_skill` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '技能标识',
  `skill_name` varchar(64) NOT NULL COMMENT '技能名称',
  `material_id` int(11) NOT NULL COMMENT '服务标识',
  `is_clock` int(11) NOT NULL DEFAULT '0' COMMENT '是否计钟 0是',
  `class` int(11) DEFAULT NULL COMMENT '归属轮班',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '技能状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技能';

-- ----------------------------
-- Table structure for tc_skill_class
-- ----------------------------
DROP TABLE IF EXISTS `tc_skill_class`;
CREATE TABLE `tc_skill_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `class_name` varchar(64) NOT NULL COMMENT '轮班名称',
  `status` int(11) NOT NULL COMMENT '轮班状态',
  `clock_flag` int(11) DEFAULT NULL COMMENT '计钟指针',
  `flag` int(11) DEFAULT NULL COMMENT '不计指针',
  `types` int(11) NOT NULL DEFAULT '0' COMMENT '排号规则 0按序1按次',
  `is_priority` int(11) NOT NULL DEFAULT '0' COMMENT '挂起优先 0否1是',
  `priority_accumulate` int(11) NOT NULL DEFAULT '0' COMMENT '挂起累计 0是1否',
  `arrive_warn` int(11) NOT NULL DEFAULT '0' COMMENT '到时提醒 0否',
  `arrive_remind` int(11) NOT NULL DEFAULT '0' COMMENT '提前播报 0否',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮班';

-- ----------------------------
-- Table structure for tc_technician
-- ----------------------------
DROP TABLE IF EXISTS `tc_technician`;
CREATE TABLE `tc_technician` (
  `technician_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '技师标识',
  `emp_id` varchar(32) DEFAULT NULL COMMENT '员工标识',
  `tech_no` varchar(16) NOT NULL COMMENT '技师代号',
  `tech_card` varchar(16) DEFAULT NULL COMMENT '技师卡号',
  `tech_name` varchar(32) NOT NULL COMMENT '技师呢称',
  `sex` int(11) DEFAULT '0' COMMENT '性别 0女',
  `shift_id` int(11) DEFAULT NULL COMMENT '技师班次',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '技师状态 0正常',
  `shift_status` int(11) DEFAULT '0' COMMENT '工作状态 0盖牌 1翻牌 2上钟 3接单',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`technician_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技师';

-- ----------------------------
-- Table structure for tc_technician_class
-- ----------------------------
DROP TABLE IF EXISTS `tc_technician_class`;
CREATE TABLE `tc_technician_class` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `class_id` int(11) NOT NULL COMMENT '归属轮班',
  `technician_id` int(11) NOT NULL COMMENT '技师标识',
  `clock_ct` int(11) NOT NULL DEFAULT '0' COMMENT '轮钟次数',
  `is_work` int(11) NOT NULL DEFAULT '0' COMMENT '是否在班 0否 1在',
  `technician_level` int(11) DEFAULT '0' COMMENT '轮班级别',
  `priority` int(11) DEFAULT '0' COMMENT '挂起次数',
  `seqencing` int(11) DEFAULT NULL COMMENT '轮班排序',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='轮班详情';

-- ----------------------------
-- Table structure for tc_technician_shift
-- ----------------------------
DROP TABLE IF EXISTS `tc_technician_shift`;
CREATE TABLE `tc_technician_shift` (
  `shift_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `shift_name` varchar(64) NOT NULL COMMENT '班次名称',
  `in_time` time NOT NULL COMMENT '起班时间',
  `out_time` time NOT NULL COMMENT '交班时间',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`shift_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技师班次';

-- ----------------------------
-- Table structure for tc_technician_skill
-- ----------------------------
DROP TABLE IF EXISTS `tc_technician_skill`;
CREATE TABLE `tc_technician_skill` (
  `ts_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `skill_id` int(11) NOT NULL COMMENT '技能标识',
  `technician_id` int(11) NOT NULL COMMENT '技师标识',
  `skill_level` int(11) NOT NULL DEFAULT '0' COMMENT '技能等级',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`ts_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='技师技能';
