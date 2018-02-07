/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50627
Source Host           : localhost:6588
Source Database       : mys1688

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-02-08 00:56:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_department`
-- ----------------------------
DROP TABLE IF EXISTS `tb_department`;
CREATE TABLE `tb_department` (
  `dpt_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门标识',
  `store_id` varchar(32) DEFAULT NULL COMMENT '归属门店',
  `tream_id` int(11) DEFAULT NULL COMMENT '系统用户组',
  `dpt_name` varchar(128) NOT NULL COMMENT '部门名称',
  `dpt_no` varchar(16) DEFAULT NULL COMMENT '部门编码',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `parent_id` int(32) DEFAULT NULL COMMENT '父级部门',
  `duty_name` varchar(64) DEFAULT NULL COMMENT '联络人',
  `duty_mobile` varchar(16) DEFAULT NULL COMMENT '联络人电话',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`dpt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

-- ----------------------------
-- Records of tb_department
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_employee`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `emp_id` varchar(32) NOT NULL COMMENT '员工标识',
  `emp_name` varchar(64) NOT NULL COMMENT '员工姓名',
  `pinyin` varchar(16) NOT NULL COMMENT '员工拼音',
  `emp_no` varchar(16) DEFAULT NULL COMMENT '员工工号',
  `emp_card` varchar(16) DEFAULT NULL COMMENT '员工卡号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '关联用户',
  `store_id` varchar(32) DEFAULT NULL COMMENT '所属门店',
  `dpt_id` varchar(32) DEFAULT NULL COMMENT '所属部门',
  `entry_date` date DEFAULT NULL COMMENT '入职时间',
  `quit_date` date DEFAULT NULL COMMENT '离职时间',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '员工状态 0正常',
  `is_manager` int(11) DEFAULT '0' COMMENT '是否管理 0否',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('12306F2882EF4D3ABE2C0881A2C8D893', '尹德', 'yd', null, '12', null, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', null, null, null, '0', '0', 'system', '2018-02-02 15:50:14', null, '2018-02-02 15:50:14');
INSERT INTO `tb_employee` VALUES ('4A21485019174112889F6ABB8FA12EED', '喻敏', 'ym', null, '11', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', 'system', '2018-02-02 15:48:44', null, '2018-02-02 15:48:44');
INSERT INTO `tb_employee` VALUES ('552309B47EA24279B7E761E6E8E387A6', '陈思思', 'css', null, '13', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', 'system', '2018-02-02 15:47:59', null, '2018-02-02 15:47:59');
INSERT INTO `tb_employee` VALUES ('69F6EC898EC345C7B73E3D7222641D53', '刘丹', 'ld', null, '14', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', 'system', '2018-02-02 15:49:05', null, '2018-02-02 15:49:05');
INSERT INTO `tb_employee` VALUES ('799AAE3B73CD45AEB641D95765A0205A', '高大山', 'gds', null, '15', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', 'system', '2018-02-02 15:46:50', null, '2018-02-02 15:46:50');
INSERT INTO `tb_employee` VALUES ('AED330EB655F40C3B2B7DD6D2A33DF18', '肖君', 'xj', null, '16', null, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', null, null, null, '0', '0', 'system', '2018-02-02 15:50:33', null, '2018-02-02 15:50:33');
INSERT INTO `tb_employee` VALUES ('AED999017B5446FB88F6F00225FF7991', '张果', 'zg', null, '17', null, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', null, null, null, '0', '0', 'system', '2018-02-02 15:50:22', null, '2018-02-02 15:50:22');
INSERT INTO `tb_employee` VALUES ('BF81C5AE66F54DB0AEFC232E37E46E59', '孙静', 'sj', null, '18', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', 'system', '2018-02-02 15:47:15', null, '2018-02-02 15:47:15');
INSERT INTO `tb_employee` VALUES ('CD2A52BC83C349D0978EC288809FCE6F', '蒋玮', 'jw', null, '19', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', 'system', '2018-02-02 15:48:18', null, '2018-02-02 15:48:18');
INSERT INTO `tb_employee` VALUES ('DEE1233D3C2E437CAE9E625B541A91A8', '罗丹', 'ld', null, '20', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', 'system', '2018-02-02 15:49:10', null, '2018-02-02 15:49:10');
INSERT INTO `tb_employee` VALUES ('E6017959302849FE9CB0629B89B77475', '周敏', 'zm', null, '10', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', 'system', '2018-02-02 15:48:54', null, '2018-02-02 15:48:54');

-- ----------------------------
-- Table structure for `tb_employee_special`
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee_special`;
CREATE TABLE `tb_employee_special` (
  `emp_id` varchar(32) NOT NULL COMMENT '员工标识',
  `emp_pwd` varchar(16) NOT NULL COMMENT '授权码',
  `credit_mount` decimal(10,2) DEFAULT NULL COMMENT '授信额度',
  `credit_left` decimal(10,2) DEFAULT NULL COMMENT '授信余额',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工特殊权限(扩)';

-- ----------------------------
-- Records of tb_employee_special
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_member`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member`;
CREATE TABLE `tb_member` (
  `member_id` varchar(32) NOT NULL COMMENT '会员标识',
  `member_name` varchar(64) NOT NULL COMMENT '会员名称',
  `pinyin` varchar(32) DEFAULT NULL COMMENT '拼音',
  `status` int(2) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `rfm` int(11) DEFAULT NULL COMMENT '会员成长值',
  `level_id` int(4) NOT NULL COMMENT '会员等级',
  `member_card` varchar(16) DEFAULT NULL COMMENT '卡号',
  `member_password` varchar(32) DEFAULT NULL COMMENT '会员密码',
  `integral` int(11) DEFAULT NULL COMMENT '积分',
  `balance` decimal(10,2) NOT NULL COMMENT '余额',
  `mobile` varchar(16) NOT NULL COMMENT '手机号',
  `mail` varchar(64) DEFAULT NULL COMMENT '邮箱地址',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `store_id` varchar(32) DEFAULT NULL COMMENT '开卡门店',
  `total_fee` decimal(10,2) DEFAULT NULL COMMENT '总花费',
  `sex` int(11) DEFAULT NULL COMMENT '性别 0男1女',
  `address` varchar(128) DEFAULT NULL COMMENT '住址',
  `card_type` int(11) DEFAULT NULL COMMENT '证件类型 0身份证',
  `card_no` varchar(32) DEFAULT NULL COMMENT '证件号码',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员';

-- ----------------------------
-- Records of tb_member
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_member_level`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member_level`;
CREATE TABLE `tb_member_level` (
  `level_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自标识',
  `level_name` varchar(64) NOT NULL COMMENT '级别名称',
  `level_rfm` int(11) DEFAULT NULL COMMENT '成长值',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级会员级别',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员体系';

-- ----------------------------
-- Records of tb_member_level
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_member_plus`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member_plus`;
CREATE TABLE `tb_member_plus` (
  `plus_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动标识',
  `plus_name` varchar(128) NOT NULL COMMENT '活动名称',
  `plus_money` decimal(10,2) NOT NULL COMMENT '充值金额',
  `gift_money` decimal(10,2) NOT NULL COMMENT '赠送金额',
  `money` decimal(10,2) NOT NULL COMMENT '提成金额',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '活动状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`plus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='会员充值活动';

-- ----------------------------
-- Records of tb_member_plus
-- ----------------------------
INSERT INTO `tb_member_plus` VALUES ('1', '充500送500', '50000.00', '50000.00', '5000.00', '0', 'admin', '2018-01-23 16:19:16', 'admin', '2018-01-23 16:19:21');
INSERT INTO `tb_member_plus` VALUES ('2', '充1000送1000', '100000.00', '100000.00', '10000.00', '0', 'admin', '2018-01-23 16:19:30', 'admin', '2018-01-23 16:19:30');
INSERT INTO `tb_member_plus` VALUES ('3', '充2000送3000', '200000.00', '300000.00', '20000.00', '0', 'admin', '2018-01-23 16:21:01', 'admin', '2018-01-23 16:21:03');

-- ----------------------------
-- Table structure for `tb_member_record`
-- ----------------------------
DROP TABLE IF EXISTS `tb_member_record`;
CREATE TABLE `tb_member_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录标识',
  `member_id` varchar(32) NOT NULL COMMENT '会员标识',
  `plus_id` int(11) DEFAULT NULL COMMENT '活动标识',
  `plus_money` decimal(10,2) NOT NULL COMMENT '充值金额',
  `gift_money` decimal(10,2) DEFAULT NULL COMMENT '赠送金额',
  `employee_id` varchar(32) DEFAULT NULL COMMENT '员工标识',
  `money` decimal(10,2) DEFAULT NULL COMMENT '员工提成',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员充值记录';

-- ----------------------------
-- Records of tb_member_record
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_reservation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_reservation`;
CREATE TABLE `tb_reservation` (
  `reservation_id` int(11) NOT NULL COMMENT '预定标识',
  `room_id` varchar(32) NOT NULL COMMENT '房间标识',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `estimate_time` datetime DEFAULT NULL COMMENT '预计到达时间',
  `reserve_time` datetime NOT NULL COMMENT '保留时间',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员标识',
  `estimate_person` varchar(64) NOT NULL COMMENT '预定人员',
  `estimate_call` varbinary(16) NOT NULL COMMENT '联系电话',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间预定';

-- ----------------------------
-- Records of tb_reservation
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_reservation_trade`
-- ----------------------------
DROP TABLE IF EXISTS `tb_reservation_trade`;
CREATE TABLE `tb_reservation_trade` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消费标识',
  `authorization_id` varchar(32) NOT NULL COMMENT '授权码',
  `types` int(11) NOT NULL COMMENT '交易类型 0商品1服务9套餐',
  `object_id` varchar(32) NOT NULL COMMENT '交易物品标识',
  `object_ct` int(11) NOT NULL COMMENT '交易数量',
  `can_cancel` int(11) DEFAULT NULL COMMENT '可否撤消 0是 1否',
  `status` int(11) NOT NULL COMMENT '详情状态 0正常 1取消',
  `note` varchar(256) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费商品详情';

-- ----------------------------
-- Records of tb_reservation_trade
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_room`
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `room_id` varchar(32) NOT NULL COMMENT '房间标识',
  `store_id` varchar(32) NOT NULL COMMENT '归属门店',
  `types` int(11) DEFAULT NULL COMMENT '房间类型',
  `area` varchar(8) DEFAULT NULL COMMENT '归属区域',
  `room_no` varchar(8) DEFAULT NULL COMMENT '房间编号',
  `room_name` varchar(32) NOT NULL COMMENT '房间名称',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `room_status` int(11) DEFAULT NULL COMMENT '自身状态',
  `chair` int(11) DEFAULT NULL COMMENT '椅子数量',
  `bed` int(11) DEFAULT NULL COMMENT '床数量',
  `mark` varchar(64) DEFAULT NULL COMMENT '标记',
  `phone` varchar(16) DEFAULT NULL COMMENT '房间分机',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间';

-- ----------------------------
-- Records of tb_room
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_store`
-- ----------------------------
DROP TABLE IF EXISTS `tb_store`;
CREATE TABLE `tb_store` (
  `store_id` varchar(32) NOT NULL COMMENT '门店标识',
  `store_name` varchar(128) NOT NULL COMMENT '门店名称',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `address` varchar(256) NOT NULL COMMENT '地址',
  `phone` varchar(16) NOT NULL COMMENT '电话',
  `license` varchar(32) DEFAULT NULL COMMENT '营业执照',
  `sno` varchar(16) DEFAULT NULL COMMENT '门店编号',
  `logitude` varchar(16) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(16) DEFAULT NULL COMMENT '纬度',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店';

-- ----------------------------
-- Records of tb_store
-- ----------------------------
INSERT INTO `tb_store` VALUES ('55CE8083FE254559AC989700F0D3354A', '富侨F联邦店', '0', '长沙市岳麓区麓云路中房F联邦', '0731-88888888', null, null, null, null, 'admin', '2018-02-02 15:39:45', null, '2018-02-02 15:39:45');
INSERT INTO `tb_store` VALUES ('69DF8088318C4F89840FD0F6A4AF46F9', '富侨浏城桥店', '0', '长沙市芙蓉中路小林子冲', '0731-88888888', null, null, null, null, 'admin', '2018-02-02 15:39:02', null, '2018-02-02 15:39:02');
INSERT INTO `tb_store` VALUES ('AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '迈优斯总部', '0', '深圳市迈优斯科技有限公司', '18888888888', '88888888', '88888888', null, null, 'system', '2018-01-31 10:58:22', 'system', '2018-01-31 10:58:22');

-- ----------------------------
-- Table structure for `tb_strap`
-- ----------------------------
DROP TABLE IF EXISTS `tb_strap`;
CREATE TABLE `tb_strap` (
  `strap_id` varchar(32) NOT NULL COMMENT '手牌标识',
  `store_id` varchar(32) NOT NULL COMMENT '归属门店',
  `strap_serial` varchar(16) NOT NULL COMMENT '手牌号码',
  `strap_no` varchar(8) DEFAULT NULL COMMENT '手牌编号',
  `types` int(11) NOT NULL COMMENT '手牌类型',
  `status` int(11) DEFAULT '0' COMMENT '手牌状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手牌';

-- ----------------------------
-- Records of tb_strap
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_types`
-- ----------------------------
DROP TABLE IF EXISTS `tb_types`;
CREATE TABLE `tb_types` (
  `type_id` int(4) NOT NULL COMMENT '类型标识',
  `ass` int(11) NOT NULL COMMENT '归属分类 0房1手环',
  `type_name` varchar(64) NOT NULL COMMENT '类型名称',
  `low_consumption` decimal(10,2) DEFAULT NULL COMMENT '最低消费',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '类型状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  `is_circle` int(4) NOT NULL DEFAULT '0' COMMENT '重复计费 0否1时长2时间点',
  `circle_step` int(11) DEFAULT NULL COMMENT '周期步长 时',
  `circle_time` time DEFAULT NULL COMMENT '计费时间点',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类型配置';

-- ----------------------------
-- Records of tb_types
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_types_bind`
-- ----------------------------
DROP TABLE IF EXISTS `tb_types_bind`;
CREATE TABLE `tb_types_bind` (
  `bind_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '绑定标识',
  `type_id` int(11) NOT NULL COMMENT '类型标识 0商品1套餐',
  `object_id` varchar(32) NOT NULL COMMENT '物品标识 商品 套餐',
  `object_ct` int(11) NOT NULL COMMENT '物品数量',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`bind_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='类型消费绑定';

-- ----------------------------
-- Records of tb_types_bind
-- ----------------------------

-- ----------------------------
-- Table structure for `tc_clock_broadcast`
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='报钟播报';

-- ----------------------------
-- Records of tc_clock_broadcast
-- ----------------------------
INSERT INTO `tc_clock_broadcast` VALUES ('1', '1', '1', '1111111111', null, '2018-01-30 15:30:20', null, '2018-01-30 15:30:20');

-- ----------------------------
-- Table structure for `tc_clock_order`
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
-- Records of tc_clock_order
-- ----------------------------

-- ----------------------------
-- Table structure for `tc_clock_record`
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
-- Records of tc_clock_record
-- ----------------------------

-- ----------------------------
-- Table structure for `tc_clock_skill`
-- ----------------------------
DROP TABLE IF EXISTS `tc_clock_skill`;
CREATE TABLE `tc_clock_skill` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '技能标识',
  `skill_name` varchar(64) NOT NULL COMMENT '技能名称',
  `material_id` int(11) NOT NULL COMMENT '服务标识',
  `is_clock` int(11) NOT NULL DEFAULT '0' COMMENT '是否计钟 0是',
  `classs` int(11) DEFAULT NULL COMMENT '归属轮班',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '技能状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='技能';

-- ----------------------------
-- Records of tc_clock_skill
-- ----------------------------
INSERT INTO `tc_clock_skill` VALUES ('2', 'QQQ23', '0', '0', '0', '0', 'string', '2018-01-26 09:47:16', 'string', '2018-01-30 11:27:32');
INSERT INTO `tc_clock_skill` VALUES ('4', 'AAAAA', '0', '0', '0', '0', 'string', '2018-01-26 09:47:17', 'string', '2018-01-29 21:30:59');
INSERT INTO `tc_clock_skill` VALUES ('7', 'yyyYYY', '0', '0', '0', '0', 'string', '2018-01-26 09:47:18', 'string', '2018-01-29 21:50:11');
INSERT INTO `tc_clock_skill` VALUES ('10', 'string', '0', '0', '0', '0', 'string', '2018-01-26 09:49:38', 'string', '2018-01-26 09:49:38');
INSERT INTO `tc_clock_skill` VALUES ('32', 'HHHHH', '1', '1', '1', '1', null, '2018-01-29 23:02:46', null, '2018-01-29 23:03:07');
INSERT INTO `tc_clock_skill` VALUES ('33', 'GGGGG567', '1', '1', '1', '1', null, '2018-01-29 23:04:34', null, '2018-01-30 00:49:40');
INSERT INTO `tc_clock_skill` VALUES ('36', 'XXXX', '1', '1', '1', '1', null, '2018-01-29 23:11:48', null, '2018-01-29 23:11:48');
INSERT INTO `tc_clock_skill` VALUES ('45', '555555555555', '2', '1', '1', '1', null, '2018-01-30 14:14:54', null, '2018-01-30 14:14:54');
INSERT INTO `tc_clock_skill` VALUES ('46', '11111111111', '1', '11', '1', '1', null, '2018-01-30 14:15:06', null, '2018-01-30 14:15:06');

-- ----------------------------
-- Table structure for `tc_skill_class`
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
-- Records of tc_skill_class
-- ----------------------------

-- ----------------------------
-- Table structure for `tc_technician`
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
-- Records of tc_technician
-- ----------------------------

-- ----------------------------
-- Table structure for `tc_technician_class`
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
-- Records of tc_technician_class
-- ----------------------------

-- ----------------------------
-- Table structure for `tc_technician_shift`
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
-- Records of tc_technician_shift
-- ----------------------------

-- ----------------------------
-- Table structure for `tc_technician_skill`
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

-- ----------------------------
-- Records of tc_technician_skill
-- ----------------------------

-- ----------------------------
-- Table structure for `to_authorization`
-- ----------------------------
DROP TABLE IF EXISTS `to_authorization`;
CREATE TABLE `to_authorization` (
  `authorization_id` varchar(32) NOT NULL COMMENT '授权码',
  `customer_id` int(11) NOT NULL COMMENT '归属客户',
  `types` int(2) NOT NULL COMMENT '终端类型 0房间 1手环',
  `device_id` varchar(32) NOT NULL COMMENT '终端标识',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '授权码状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费授权';

-- ----------------------------
-- Records of to_authorization
-- ----------------------------

-- ----------------------------
-- Table structure for `to_customer`
-- ----------------------------
DROP TABLE IF EXISTS `to_customer`;
CREATE TABLE `to_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户标识',
  `customer_name` varchar(32) NOT NULL COMMENT '客户名称',
  `advance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '押金',
  `note` varchar(64) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户';

-- ----------------------------
-- Records of to_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `to_goods`
-- ----------------------------
DROP TABLE IF EXISTS `to_goods`;
CREATE TABLE `to_goods` (
  `goods_id` varchar(32) NOT NULL COMMENT '商品标识',
  `store_id` varchar(32) NOT NULL COMMENT '归属门店',
  `goods_name` varchar(128) NOT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品售价',
  `unit_id` int(11) NOT NULL COMMENT '商品单位',
  `goods_time` int(11) DEFAULT NULL COMMENT '服务时长 分',
  `classify` int(11) DEFAULT NULL COMMENT '商品小类',
  `material_id` int(11) NOT NULL COMMENT '原料标识',
  `material_types` int(11) NOT NULL COMMENT '原料类型(冗) 0物品1服务',
  `material_ct` int(11) NOT NULL COMMENT '消耗原料数量 0不减库存',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `sale_status` int(11) DEFAULT NULL COMMENT '销售状态 推荐热销',
  `note` varchar(512) DEFAULT NULL COMMENT '商品说明',
  `goods_img` varchar(256) DEFAULT NULL COMMENT '商品图例',
  `is_show` int(11) NOT NULL DEFAULT '0' COMMENT '对客显示 0是',
  `can_cancel` int(11) NOT NULL DEFAULT '0' COMMENT '可否撤消 0是1否',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品服务';

-- ----------------------------
-- Records of to_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `to_goods_ext`
-- ----------------------------
DROP TABLE IF EXISTS `to_goods_ext`;
CREATE TABLE `to_goods_ext` (
  `goods_id` varchar(32) NOT NULL COMMENT '商品标识',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品服务扩展';

-- ----------------------------
-- Records of to_goods_ext
-- ----------------------------

-- ----------------------------
-- Table structure for `to_goods_material`
-- ----------------------------
DROP TABLE IF EXISTS `to_goods_material`;
CREATE TABLE `to_goods_material` (
  `material_id` int(11) DEFAULT NULL COMMENT '原料标识',
  `store_id` varchar(32) DEFAULT NULL COMMENT '归属门店',
  `material_name` varchar(128) DEFAULT NULL COMMENT '原料名称',
  `material_no` varchar(32) DEFAULT NULL COMMENT '原料代码',
  `material_types` int(11) DEFAULT NULL COMMENT '原料类型 0物品1服务',
  `material_ct` int(11) DEFAULT NULL COMMENT '原料库存',
  `pinyin` varchar(64) DEFAULT NULL COMMENT '拼音',
  `cost` decimal(10,2) DEFAULT NULL COMMENT '纯成本',
  `cost_all` decimal(10,2) DEFAULT NULL COMMENT '核算成本',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='基本原料';

-- ----------------------------
-- Records of to_goods_material
-- ----------------------------

-- ----------------------------
-- Table structure for `to_goods_unit`
-- ----------------------------
DROP TABLE IF EXISTS `to_goods_unit`;
CREATE TABLE `to_goods_unit` (
  `unit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '单位标识',
  `unit_name` varchar(64) NOT NULL COMMENT '单位名称',
  `base_unit` int(11) DEFAULT NULL COMMENT '基准单位',
  `base_ct` int(11) DEFAULT NULL COMMENT '换算比 与基准单位',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品单位';

-- ----------------------------
-- Records of to_goods_unit
-- ----------------------------

-- ----------------------------
-- Table structure for `to_packages`
-- ----------------------------
DROP TABLE IF EXISTS `to_packages`;
CREATE TABLE `to_packages` (
  `package_id` varchar(32) NOT NULL COMMENT '套餐标识',
  `store_id` int(11) NOT NULL COMMENT '归属门店',
  `package_name` varchar(64) NOT NULL COMMENT '套餐名称',
  `pinyin` varchar(64) NOT NULL COMMENT '套餐拼音',
  `price` decimal(10,2) NOT NULL COMMENT '售价',
  `valid_date` date DEFAULT NULL COMMENT '有效日期',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '套餐状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`package_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费套餐';

-- ----------------------------
-- Records of to_packages
-- ----------------------------

-- ----------------------------
-- Table structure for `to_packages_detail`
-- ----------------------------
DROP TABLE IF EXISTS `to_packages_detail`;
CREATE TABLE `to_packages_detail` (
  `detail_id` int(11) NOT NULL COMMENT '详情标识',
  `package_id` varchar(32) NOT NULL COMMENT '归属套餐',
  `goods_id` varchar(32) NOT NULL COMMENT '商品标识',
  `goods_ct` int(11) NOT NULL COMMENT '商品数量',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费套餐详情';

-- ----------------------------
-- Records of to_packages_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `ts_config`
-- ----------------------------
DROP TABLE IF EXISTS `ts_config`;
CREATE TABLE `ts_config` (
  `property_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性标识',
  `property_code` varchar(32) NOT NULL COMMENT '属性代码',
  `property_value` varchar(512) NOT NULL COMMENT '属性值',
  `property_note` varchar(32) DEFAULT NULL COMMENT '属性描述',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统配置';

-- ----------------------------
-- Records of ts_config
-- ----------------------------
INSERT INTO `ts_config` VALUES ('1', 'dictionary.file.url', 'C:\\Users\\Administrator\\git\\mys2018\\trunk\\src\\main\\resources\\static\\pc\\js\\dictionary.js', 'string', 'string', '2018-01-11 18:03:16', null, '2018-01-11 18:03:16');
INSERT INTO `ts_config` VALUES ('2', 'string', 'string', 'string', 'string', '2018-01-12 10:08:57', 'string', '2018-01-12 10:08:57');

-- ----------------------------
-- Table structure for `ts_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `ts_dictionary`;
CREATE TABLE `ts_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典标识',
  `code` varchar(32) NOT NULL COMMENT '字典编码',
  `value` varchar(128) NOT NULL COMMENT '字典值',
  `group_code` varchar(32) NOT NULL COMMENT '归属字典分组',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父字典编码',
  `sequence` int(11) DEFAULT NULL COMMENT '字典排序',
  `flag` int(11) DEFAULT '0' COMMENT '字典状态 0正常1停用',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典值';

-- ----------------------------
-- Records of ts_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `ts_dictionary_group`
-- ----------------------------
DROP TABLE IF EXISTS `ts_dictionary_group`;
CREATE TABLE `ts_dictionary_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组标识',
  `group_code` varchar(32) NOT NULL COMMENT '分组代码',
  `group_name` varchar(64) NOT NULL COMMENT '分组名称',
  `remark` varchar(255) DEFAULT NULL,
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典分组';

-- ----------------------------
-- Records of ts_dictionary_group
-- ----------------------------

-- ----------------------------
-- Table structure for `ts_document_info`
-- ----------------------------
DROP TABLE IF EXISTS `ts_document_info`;
CREATE TABLE `ts_document_info` (
  `doc_id` varchar(32) NOT NULL COMMENT '文档标识',
  `doc_name` varchar(128) NOT NULL COMMENT '文档名称',
  `actual_name` varchar(256) DEFAULT NULL COMMENT '真实名称',
  `suffix_name` varchar(16) DEFAULT NULL COMMENT '文档类型',
  `file_size` varchar(8) NOT NULL COMMENT '文档大小',
  `status` varchar(128) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `url` int(11) NOT NULL COMMENT '地址',
  `note` varchar(256) DEFAULT NULL COMMENT '说明',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文档';

-- ----------------------------
-- Records of ts_document_info
-- ----------------------------

-- ----------------------------
-- Table structure for `ts_log`
-- ----------------------------
DROP TABLE IF EXISTS `ts_log`;
CREATE TABLE `ts_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志标识',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户名',
  `user_ip` varchar(32) DEFAULT NULL COMMENT '访问IP',
  `oper` varchar(64) DEFAULT NULL COMMENT '操作名称',
  `oper_ua` varchar(256) DEFAULT NULL COMMENT '来源UA',
  `oper_type` varchar(16) DEFAULT NULL COMMENT '来源类型',
  `oper_status` int(11) DEFAULT NULL COMMENT '来源状态',
  `request` text COMMENT '请求全文',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志';

-- ----------------------------
-- Records of ts_log
-- ----------------------------

-- ----------------------------
-- Table structure for `ts_resource_info`
-- ----------------------------
DROP TABLE IF EXISTS `ts_resource_info`;
CREATE TABLE `ts_resource_info` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源标识',
  `title` varchar(64) NOT NULL COMMENT '资源名称',
  `type` varchar(16) NOT NULL COMMENT '资源类型',
  `url` varchar(128) DEFAULT NULL COMMENT '资源地址',
  `method` varchar(8) DEFAULT NULL COMMENT '访问方式',
  `image` varchar(64) DEFAULT NULL COMMENT '资源图片',
  `parent_id` int(11) DEFAULT NULL COMMENT '父资源',
  `is_display` int(11) DEFAULT NULL COMMENT '是否显示 0显示',
  `sequence` int(11) DEFAULT NULL COMMENT '资源排序',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用 0正常',
  `note` varchar(128) DEFAULT NULL COMMENT '资源描述',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=593 DEFAULT CHARSET=utf8 COMMENT='资源菜单';

-- ----------------------------
-- Records of ts_resource_info
-- ----------------------------
INSERT INTO `ts_resource_info` VALUES ('98', '部门-新增', 'ACTION', '/mys/department', 'POST', null, null, '1', null, '0', '部门-新增', 'admin', '2018-01-13 18:52:41', null, '2018-01-13 18:52:41');
INSERT INTO `ts_resource_info` VALUES ('99', '部门-修订', 'ACTION', '/mys/department/{}', 'PUT', null, null, '1', null, '0', '部门-修订', 'admin', '2018-01-13 18:52:41', null, '2018-01-13 18:52:41');
INSERT INTO `ts_resource_info` VALUES ('100', '部门-删除', 'ACTION', '/mys/department/{}', 'DELETE', null, null, '1', null, '0', '部门-删除', 'admin', '2018-01-13 18:52:41', null, '2018-01-13 18:52:41');
INSERT INTO `ts_resource_info` VALUES ('101', '部门-标识查询', 'ACTION', '/mys/department/{}', 'GET', null, null, '1', null, '0', '部门-标识查询', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('102', '部门-不分页列表', 'ACTION', '/mys/department', 'GET', null, null, '1', null, '0', '部门-不分页列表', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('103', '部门-分页列表', 'ACTION', '/mys/departments', 'GET', null, null, '1', null, '0', '部门-分页列表', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('104', '员工-新增', 'ACTION', '/mys/employee', 'POST', null, null, '1', null, '0', '员工-新增', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('105', '员工-修订', 'ACTION', '/mys/employee/{}', 'PUT', null, null, '1', null, '0', '员工-修订', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('106', '员工-删除', 'ACTION', '/mys/employee/{}', 'DELETE', null, null, '1', null, '0', '员工-删除', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('107', '员工-标识查询', 'ACTION', '/mys/employee/{}', 'GET', null, null, '1', null, '0', '员工-标识查询', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('108', '员工-不分页列表', 'ACTION', '/mys/employee', 'GET', null, null, '1', null, '0', '员工-不分页列表', 'admin', '2018-01-13 18:52:42', null, '2018-01-13 18:52:42');
INSERT INTO `ts_resource_info` VALUES ('109', '员工-分页列表', 'ACTION', '/mys/employees', 'GET', null, null, '1', null, '0', '员工-分页列表', 'admin', '2018-01-13 18:52:43', null, '2018-01-13 18:52:43');
INSERT INTO `ts_resource_info` VALUES ('110', '员工特殊权限(扩)-新增', 'ACTION', '/mys/employeespecial', 'POST', null, null, '1', null, '0', '员工特殊权限(扩)-新增', 'admin', '2018-01-13 18:52:43', null, '2018-01-13 18:52:43');
INSERT INTO `ts_resource_info` VALUES ('111', '员工特殊权限(扩)-修订', 'ACTION', '/mys/employeespecial/{}', 'PUT', null, null, '1', null, '0', '员工特殊权限(扩)-修订', 'admin', '2018-01-13 18:52:43', null, '2018-01-13 18:52:43');
INSERT INTO `ts_resource_info` VALUES ('112', '员工特殊权限(扩)-删除', 'ACTION', '/mys/employeespecial/{}', 'DELETE', null, null, '1', null, '0', '员工特殊权限(扩)-删除', 'admin', '2018-01-13 18:52:43', null, '2018-01-13 18:52:43');
INSERT INTO `ts_resource_info` VALUES ('113', '员工特殊权限(扩)-标识查询', 'ACTION', '/mys/employeespecial/{}', 'GET', null, null, '1', null, '0', '员工特殊权限(扩)-标识查询', 'admin', '2018-01-13 18:52:44', null, '2018-01-13 18:52:44');
INSERT INTO `ts_resource_info` VALUES ('114', '员工特殊权限(扩)-不分页列表', 'ACTION', '/mys/employeespecial', 'GET', null, null, '1', null, '0', '员工特殊权限(扩)-不分页列表', 'admin', '2018-01-13 18:52:44', null, '2018-01-13 18:52:44');
INSERT INTO `ts_resource_info` VALUES ('115', '员工特殊权限(扩)-分页列表', 'ACTION', '/mys/employeespecials', 'GET', null, null, '1', null, '0', '员工特殊权限(扩)-分页列表', 'admin', '2018-01-13 18:52:44', null, '2018-01-13 18:52:44');
INSERT INTO `ts_resource_info` VALUES ('116', '会员-新增', 'ACTION', '/mys/member', 'POST', null, null, '1', null, '0', '会员-新增', 'admin', '2018-01-13 18:52:44', null, '2018-01-13 18:52:44');
INSERT INTO `ts_resource_info` VALUES ('117', '会员-修订', 'ACTION', '/mys/member/{}', 'PUT', null, null, '1', null, '0', '会员-修订', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('118', '会员-删除', 'ACTION', '/mys/member/{}', 'DELETE', null, null, '1', null, '0', '会员-删除', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('119', '会员-标识查询', 'ACTION', '/mys/member/{}', 'GET', null, null, '1', null, '0', '会员-标识查询', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('120', '会员-不分页列表', 'ACTION', '/mys/member', 'GET', null, null, '1', null, '0', '会员-不分页列表', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('121', '会员-分页列表', 'ACTION', '/mys/members', 'GET', null, null, '1', null, '0', '会员-分页列表', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('122', '会员体系-新增', 'ACTION', '/mys/memberlevel', 'POST', null, null, '1', null, '0', '会员体系-新增', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('123', '会员体系-修订', 'ACTION', '/mys/memberlevel/{}', 'PUT', null, null, '1', null, '0', '会员体系-修订', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('124', '会员体系-删除', 'ACTION', '/mys/memberlevel/{}', 'DELETE', null, null, '1', null, '0', '会员体系-删除', 'admin', '2018-01-13 18:52:45', null, '2018-01-13 18:52:45');
INSERT INTO `ts_resource_info` VALUES ('125', '会员体系-标识查询', 'ACTION', '/mys/memberlevel/{}', 'GET', null, null, '1', null, '0', '会员体系-标识查询', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('126', '会员体系-不分页列表', 'ACTION', '/mys/memberlevel', 'GET', null, null, '1', null, '0', '会员体系-不分页列表', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('127', '会员体系-分页列表', 'ACTION', '/mys/memberlevels', 'GET', null, null, '1', null, '0', '会员体系-分页列表', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('128', '会员充值活动-新增', 'ACTION', '/mys/memberplus', 'POST', null, null, '1', null, '0', '会员充值活动-新增', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('129', '会员充值活动-修订', 'ACTION', '/mys/memberplus/{}', 'PUT', null, null, '1', null, '0', '会员充值活动-修订', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('130', '会员充值活动-删除', 'ACTION', '/mys/memberplus/{}', 'DELETE', null, null, '1', null, '0', '会员充值活动-删除', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('131', '会员充值活动-标识查询', 'ACTION', '/mys/memberplus/{}', 'GET', null, null, '1', null, '0', '会员充值活动-标识查询', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('132', '会员充值活动-不分页列表', 'ACTION', '/mys/memberplus', 'GET', null, null, '1', null, '0', '会员充值活动-不分页列表', 'admin', '2018-01-13 18:52:46', null, '2018-01-13 18:52:46');
INSERT INTO `ts_resource_info` VALUES ('133', '会员充值活动-分页列表', 'ACTION', '/mys/memberpluss', 'GET', null, null, '1', null, '0', '会员充值活动-分页列表', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('134', '会员充值记录-新增', 'ACTION', '/mys/memberrecord', 'POST', null, null, '1', null, '0', '会员充值记录-新增', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('135', '会员充值记录-修订', 'ACTION', '/mys/memberrecord/{}', 'PUT', null, null, '1', null, '0', '会员充值记录-修订', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('136', '会员充值记录-删除', 'ACTION', '/mys/memberrecord/{}', 'DELETE', null, null, '1', null, '0', '会员充值记录-删除', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('137', '会员充值记录-标识查询', 'ACTION', '/mys/memberrecord/{}', 'GET', null, null, '1', null, '0', '会员充值记录-标识查询', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('138', '会员充值记录-不分页列表', 'ACTION', '/mys/memberrecord', 'GET', null, null, '1', null, '0', '会员充值记录-不分页列表', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('139', '会员充值记录-分页列表', 'ACTION', '/mys/memberrecords', 'GET', null, null, '1', null, '0', '会员充值记录-分页列表', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('140', '房间预定-新增', 'ACTION', '/mys/reservation', 'POST', null, null, '1', null, '0', '房间预定-新增', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('141', '房间预定-修订', 'ACTION', '/mys/reservation/{}', 'PUT', null, null, '1', null, '0', '房间预定-修订', 'admin', '2018-01-13 18:52:47', null, '2018-01-13 18:52:47');
INSERT INTO `ts_resource_info` VALUES ('142', '房间预定-删除', 'ACTION', '/mys/reservation/{}', 'DELETE', null, null, '1', null, '0', '房间预定-删除', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('143', '房间预定-标识查询', 'ACTION', '/mys/reservation/{}', 'GET', null, null, '1', null, '0', '房间预定-标识查询', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('144', '房间预定-不分页列表', 'ACTION', '/mys/reservation', 'GET', null, null, '1', null, '0', '房间预定-不分页列表', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('145', '房间预定-分页列表', 'ACTION', '/mys/reservations', 'GET', null, null, '1', null, '0', '房间预定-分页列表', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('146', '消费商品详情-新增', 'ACTION', '/mys/reservationtrade', 'POST', null, null, '1', null, '0', '消费商品详情-新增', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('147', '消费商品详情-修订', 'ACTION', '/mys/reservationtrade/{}', 'PUT', null, null, '1', null, '0', '消费商品详情-修订', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('148', '消费商品详情-删除', 'ACTION', '/mys/reservationtrade/{}', 'DELETE', null, null, '1', null, '0', '消费商品详情-删除', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('149', '消费商品详情-标识查询', 'ACTION', '/mys/reservationtrade/{}', 'GET', null, null, '1', null, '0', '消费商品详情-标识查询', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('150', '消费商品详情-不分页列表', 'ACTION', '/mys/reservationtrade', 'GET', null, null, '1', null, '0', '消费商品详情-不分页列表', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('151', '消费商品详情-分页列表', 'ACTION', '/mys/reservationtrades', 'GET', null, null, '1', null, '0', '消费商品详情-分页列表', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('152', '房间-新增', 'ACTION', '/mys/room', 'POST', null, null, '1', null, '0', '房间-新增', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('153', '房间-修订', 'ACTION', '/mys/room/{}', 'PUT', null, null, '1', null, '0', '房间-修订', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('154', '房间-删除', 'ACTION', '/mys/room/{}', 'DELETE', null, null, '1', null, '0', '房间-删除', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('155', '房间-标识查询', 'ACTION', '/mys/room/{}', 'GET', null, null, '1', null, '0', '房间-标识查询', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('156', '房间-不分页列表', 'ACTION', '/mys/room', 'GET', null, null, '1', null, '0', '房间-不分页列表', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('157', '房间-分页列表', 'ACTION', '/mys/rooms', 'GET', null, null, '1', null, '0', '房间-分页列表', 'admin', '2018-01-13 18:52:48', null, '2018-01-13 18:52:48');
INSERT INTO `ts_resource_info` VALUES ('158', '门店-新增', 'ACTION', '/mys/store', 'POST', null, null, '1', null, '0', '门店-新增', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('159', '门店-修订', 'ACTION', '/mys/store/{}', 'PUT', null, null, '1', null, '0', '门店-修订', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('160', '门店-删除', 'ACTION', '/mys/store/{}', 'DELETE', null, null, '1', null, '0', '门店-删除', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('161', '门店-标识查询', 'ACTION', '/mys/store/{}', 'GET', null, null, '1', null, '0', '门店-标识查询', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('162', '门店-不分页列表', 'ACTION', '/mys/store', 'GET', null, null, '1', null, '0', '门店-不分页列表', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('163', '门店-分页列表', 'ACTION', '/mys/stores', 'GET', null, null, '1', null, '0', '门店-分页列表', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('164', '手牌-新增', 'ACTION', '/mys/strap', 'POST', null, null, '1', null, '0', '手牌-新增', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('165', '手牌-修订', 'ACTION', '/mys/strap/{}', 'PUT', null, null, '1', null, '0', '手牌-修订', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('166', '手牌-删除', 'ACTION', '/mys/strap/{}', 'DELETE', null, null, '1', null, '0', '手牌-删除', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('167', '手牌-标识查询', 'ACTION', '/mys/strap/{}', 'GET', null, null, '1', null, '0', '手牌-标识查询', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('168', '手牌-不分页列表', 'ACTION', '/mys/strap', 'GET', null, null, '1', null, '0', '手牌-不分页列表', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('169', '手牌-分页列表', 'ACTION', '/mys/straps', 'GET', null, null, '1', null, '0', '手牌-分页列表', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('170', '类型配置-新增', 'ACTION', '/mys/types', 'POST', null, null, '1', null, '0', '类型配置-新增', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('171', '类型配置-修订', 'ACTION', '/mys/types/{}', 'PUT', null, null, '1', null, '0', '类型配置-修订', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('172', '类型配置-删除', 'ACTION', '/mys/types/{}', 'DELETE', null, null, '1', null, '0', '类型配置-删除', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('173', '类型配置-标识查询', 'ACTION', '/mys/types/{}', 'GET', null, null, '1', null, '0', '类型配置-标识查询', 'admin', '2018-01-13 18:52:49', null, '2018-01-13 18:52:49');
INSERT INTO `ts_resource_info` VALUES ('174', '类型配置-不分页列表', 'ACTION', '/mys/types', 'GET', null, null, '1', null, '0', '类型配置-不分页列表', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('175', '类型配置-分页列表', 'ACTION', '/mys/typess', 'GET', null, null, '1', null, '0', '类型配置-分页列表', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('176', '类型消费绑定-新增', 'ACTION', '/mys/typesbind', 'POST', null, null, '1', null, '0', '类型消费绑定-新增', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('177', '类型消费绑定-修订', 'ACTION', '/mys/typesbind/{}', 'PUT', null, null, '1', null, '0', '类型消费绑定-修订', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('178', '类型消费绑定-删除', 'ACTION', '/mys/typesbind/{}', 'DELETE', null, null, '1', null, '0', '类型消费绑定-删除', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('179', '类型消费绑定-标识查询', 'ACTION', '/mys/typesbind/{}', 'GET', null, null, '1', null, '0', '类型消费绑定-标识查询', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('180', '类型消费绑定-不分页列表', 'ACTION', '/mys/typesbind', 'GET', null, null, '1', null, '0', '类型消费绑定-不分页列表', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('181', '类型消费绑定-分页列表', 'ACTION', '/mys/typesbinds', 'GET', null, null, '1', null, '0', '类型消费绑定-分页列表', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('182', '报钟播报-新增', 'ACTION', '/mys/clockbroadcast', 'POST', null, null, '1', null, '0', '报钟播报-新增', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('183', '报钟播报-修订', 'ACTION', '/mys/clockbroadcast/{}', 'PUT', null, null, '1', null, '0', '报钟播报-修订', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('184', '报钟播报-删除', 'ACTION', '/mys/clockbroadcast/{}', 'DELETE', null, null, '1', null, '0', '报钟播报-删除', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('185', '报钟播报-标识查询', 'ACTION', '/mys/clockbroadcast/{}', 'GET', null, null, '1', null, '0', '报钟播报-标识查询', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('186', '报钟播报-不分页列表', 'ACTION', '/mys/clockbroadcast', 'GET', null, null, '1', null, '0', '报钟播报-不分页列表', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('187', '报钟播报-分页列表', 'ACTION', '/mys/clockbroadcasts', 'GET', null, null, '1', null, '0', '报钟播报-分页列表', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('188', '订单-新增', 'ACTION', '/mys/clockorder', 'POST', null, null, '1', null, '0', '订单-新增', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('189', '订单-修订', 'ACTION', '/mys/clockorder/{}', 'PUT', null, null, '1', null, '0', '订单-修订', 'admin', '2018-01-13 18:52:50', null, '2018-01-13 18:52:50');
INSERT INTO `ts_resource_info` VALUES ('190', '订单-删除', 'ACTION', '/mys/clockorder/{}', 'DELETE', null, null, '1', null, '0', '订单-删除', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('191', '订单-标识查询', 'ACTION', '/mys/clockorder/{}', 'GET', null, null, '1', null, '0', '订单-标识查询', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('192', '订单-不分页列表', 'ACTION', '/mys/clockorder', 'GET', null, null, '1', null, '0', '订单-不分页列表', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('193', '订单-分页列表', 'ACTION', '/mys/clockorders', 'GET', null, null, '1', null, '0', '订单-分页列表', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('194', '应钟记录-新增', 'ACTION', '/mys/clockrecord', 'POST', null, null, '1', null, '0', '应钟记录-新增', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('195', '应钟记录-修订', 'ACTION', '/mys/clockrecord/{}', 'PUT', null, null, '1', null, '0', '应钟记录-修订', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('196', '应钟记录-删除', 'ACTION', '/mys/clockrecord/{}', 'DELETE', null, null, '1', null, '0', '应钟记录-删除', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('197', '应钟记录-标识查询', 'ACTION', '/mys/clockrecord/{}', 'GET', null, null, '1', null, '0', '应钟记录-标识查询', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('198', '应钟记录-不分页列表', 'ACTION', '/mys/clockrecord', 'GET', null, null, '1', null, '0', '应钟记录-不分页列表', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('199', '应钟记录-分页列表', 'ACTION', '/mys/clockrecords', 'GET', null, null, '1', null, '0', '应钟记录-分页列表', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('200', '技能-新增', 'ACTION', '/mys/clockskill', 'POST', null, null, '1', null, '0', '技能-新增', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('201', '技能-修订', 'ACTION', '/mys/clockskill/{}', 'PUT', null, null, '1', null, '0', '技能-修订', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('202', '技能-删除', 'ACTION', '/mys/clockskill/{}', 'DELETE', null, null, '1', null, '0', '技能-删除', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('203', '技能-标识查询', 'ACTION', '/mys/clockskill/{}', 'GET', null, null, '1', null, '0', '技能-标识查询', 'admin', '2018-01-13 18:52:51', null, '2018-01-13 18:52:51');
INSERT INTO `ts_resource_info` VALUES ('204', '技能-不分页列表', 'ACTION', '/mys/clockskill', 'GET', null, null, '1', null, '0', '技能-不分页列表', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('205', '技能-分页列表', 'ACTION', '/mys/clockskills', 'GET', null, null, '1', null, '0', '技能-分页列表', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('206', '轮班-新增', 'ACTION', '/mys/skillclass', 'POST', null, null, '1', null, '0', '轮班-新增', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('207', '轮班-修订', 'ACTION', '/mys/skillclass/{}', 'PUT', null, null, '1', null, '0', '轮班-修订', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('208', '轮班-删除', 'ACTION', '/mys/skillclass/{}', 'DELETE', null, null, '1', null, '0', '轮班-删除', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('209', '轮班-标识查询', 'ACTION', '/mys/skillclass/{}', 'GET', null, null, '1', null, '0', '轮班-标识查询', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('210', '轮班-不分页列表', 'ACTION', '/mys/skillclass', 'GET', null, null, '1', null, '0', '轮班-不分页列表', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('211', '轮班-分页列表', 'ACTION', '/mys/skillclasss', 'GET', null, null, '1', null, '0', '轮班-分页列表', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('212', '技师-新增', 'ACTION', '/mys/technician', 'POST', null, null, '1', null, '0', '技师-新增', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('213', '技师-修订', 'ACTION', '/mys/technician/{}', 'PUT', null, null, '1', null, '0', '技师-修订', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('214', '技师-删除', 'ACTION', '/mys/technician/{}', 'DELETE', null, null, '1', null, '0', '技师-删除', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('215', '技师-标识查询', 'ACTION', '/mys/technician/{}', 'GET', null, null, '1', null, '0', '技师-标识查询', 'admin', '2018-01-13 18:52:52', null, '2018-01-13 18:52:52');
INSERT INTO `ts_resource_info` VALUES ('216', '技师-不分页列表', 'ACTION', '/mys/technician', 'GET', null, null, '1', null, '0', '技师-不分页列表', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('217', '技师-分页列表', 'ACTION', '/mys/technicians', 'GET', null, null, '1', null, '0', '技师-分页列表', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('218', '轮班详情-新增', 'ACTION', '/mys/technicianclass', 'POST', null, null, '1', null, '0', '轮班详情-新增', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('219', '轮班详情-修订', 'ACTION', '/mys/technicianclass/{}', 'PUT', null, null, '1', null, '0', '轮班详情-修订', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('220', '轮班详情-删除', 'ACTION', '/mys/technicianclass/{}', 'DELETE', null, null, '1', null, '0', '轮班详情-删除', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('221', '轮班详情-标识查询', 'ACTION', '/mys/technicianclass/{}', 'GET', null, null, '1', null, '0', '轮班详情-标识查询', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('222', '轮班详情-不分页列表', 'ACTION', '/mys/technicianclass', 'GET', null, null, '1', null, '0', '轮班详情-不分页列表', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('223', '轮班详情-分页列表', 'ACTION', '/mys/technicianclasss', 'GET', null, null, '1', null, '0', '轮班详情-分页列表', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('224', '技师班次-新增', 'ACTION', '/mys/technicianshift', 'POST', null, null, '1', null, '0', '技师班次-新增', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('225', '技师班次-修订', 'ACTION', '/mys/technicianshift/{}', 'PUT', null, null, '1', null, '0', '技师班次-修订', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('226', '技师班次-删除', 'ACTION', '/mys/technicianshift/{}', 'DELETE', null, null, '1', null, '0', '技师班次-删除', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('227', '技师班次-标识查询', 'ACTION', '/mys/technicianshift/{}', 'GET', null, null, '1', null, '0', '技师班次-标识查询', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('228', '技师班次-不分页列表', 'ACTION', '/mys/technicianshift', 'GET', null, null, '1', null, '0', '技师班次-不分页列表', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('229', '技师班次-分页列表', 'ACTION', '/mys/technicianshifts', 'GET', null, null, '1', null, '0', '技师班次-分页列表', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('230', '技师技能-新增', 'ACTION', '/mys/technicianskill', 'POST', null, null, '1', null, '0', '技师技能-新增', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('231', '技师技能-修订', 'ACTION', '/mys/technicianskill/{}', 'PUT', null, null, '1', null, '0', '技师技能-修订', 'admin', '2018-01-13 18:52:53', null, '2018-01-13 18:52:53');
INSERT INTO `ts_resource_info` VALUES ('232', '技师技能-删除', 'ACTION', '/mys/technicianskill/{}', 'DELETE', null, null, '1', null, '0', '技师技能-删除', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('233', '技师技能-标识查询', 'ACTION', '/mys/technicianskill/{}', 'GET', null, null, '1', null, '0', '技师技能-标识查询', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('234', '技师技能-不分页列表', 'ACTION', '/mys/technicianskill', 'GET', null, null, '1', null, '0', '技师技能-不分页列表', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('235', '技师技能-分页列表', 'ACTION', '/mys/technicianskills', 'GET', null, null, '1', null, '0', '技师技能-分页列表', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('236', '消费授权-新增', 'ACTION', '/mys/authorization', 'POST', null, null, '1', null, '0', '消费授权-新增', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('237', '消费授权-修订', 'ACTION', '/mys/authorization/{}', 'PUT', null, null, '1', null, '0', '消费授权-修订', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('238', '消费授权-删除', 'ACTION', '/mys/authorization/{}', 'DELETE', null, null, '1', null, '0', '消费授权-删除', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('239', '消费授权-标识查询', 'ACTION', '/mys/authorization/{}', 'GET', null, null, '1', null, '0', '消费授权-标识查询', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('240', '消费授权-不分页列表', 'ACTION', '/mys/authorization', 'GET', null, null, '1', null, '0', '消费授权-不分页列表', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('241', '消费授权-分页列表', 'ACTION', '/mys/authorizations', 'GET', null, null, '1', null, '0', '消费授权-分页列表', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('242', '客户-新增', 'ACTION', '/mys/customer', 'POST', null, null, '1', null, '0', '客户-新增', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('243', '客户-修订', 'ACTION', '/mys/customer/{}', 'PUT', null, null, '1', null, '0', '客户-修订', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('244', '客户-删除', 'ACTION', '/mys/customer/{}', 'DELETE', null, null, '1', null, '0', '客户-删除', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('245', '客户-标识查询', 'ACTION', '/mys/customer/{}', 'GET', null, null, '1', null, '0', '客户-标识查询', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('246', '客户-不分页列表', 'ACTION', '/mys/customer', 'GET', null, null, '1', null, '0', '客户-不分页列表', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('247', '客户-分页列表', 'ACTION', '/mys/customers', 'GET', null, null, '1', null, '0', '客户-分页列表', 'admin', '2018-01-13 18:52:54', null, '2018-01-13 18:52:54');
INSERT INTO `ts_resource_info` VALUES ('248', '商品服务-新增', 'ACTION', '/mys/goods', 'POST', null, null, '1', null, '0', '商品服务-新增', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('249', '商品服务-修订', 'ACTION', '/mys/goods/{}', 'PUT', null, null, '1', null, '0', '商品服务-修订', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('250', '商品服务-删除', 'ACTION', '/mys/goods/{}', 'DELETE', null, null, '1', null, '0', '商品服务-删除', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('251', '商品服务-标识查询', 'ACTION', '/mys/goods/{}', 'GET', null, null, '1', null, '0', '商品服务-标识查询', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('252', '商品服务-不分页列表', 'ACTION', '/mys/goods', 'GET', null, null, '1', null, '0', '商品服务-不分页列表', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('253', '商品服务-分页列表', 'ACTION', '/mys/goodss', 'GET', null, null, '1', null, '0', '商品服务-分页列表', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('254', '商品服务扩展-新增', 'ACTION', '/mys/goodsext', 'POST', null, null, '1', null, '0', '商品服务扩展-新增', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('255', '商品服务扩展-修订', 'ACTION', '/mys/goodsext/{}', 'PUT', null, null, '1', null, '0', '商品服务扩展-修订', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('256', '商品服务扩展-删除', 'ACTION', '/mys/goodsext/{}', 'DELETE', null, null, '1', null, '0', '商品服务扩展-删除', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('257', '商品服务扩展-标识查询', 'ACTION', '/mys/goodsext/{}', 'GET', null, null, '1', null, '0', '商品服务扩展-标识查询', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('258', '商品服务扩展-不分页列表', 'ACTION', '/mys/goodsext', 'GET', null, null, '1', null, '0', '商品服务扩展-不分页列表', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('259', '商品服务扩展-分页列表', 'ACTION', '/mys/goodsexts', 'GET', null, null, '1', null, '0', '商品服务扩展-分页列表', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('260', '基本原料-新增', 'ACTION', '/mys/goodsmaterial', 'POST', null, null, '1', null, '0', '基本原料-新增', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('261', '基本原料-修订', 'ACTION', '/mys/goodsmaterial/{}', 'PUT', null, null, '1', null, '0', '基本原料-修订', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('262', '基本原料-删除', 'ACTION', '/mys/goodsmaterial/{}', 'DELETE', null, null, '1', null, '0', '基本原料-删除', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('263', '基本原料-标识查询', 'ACTION', '/mys/goodsmaterial/{}', 'GET', null, null, '1', null, '0', '基本原料-标识查询', 'admin', '2018-01-13 18:52:55', null, '2018-01-13 18:52:55');
INSERT INTO `ts_resource_info` VALUES ('264', '基本原料-不分页列表', 'ACTION', '/mys/goodsmaterial', 'GET', null, null, '1', null, '0', '基本原料-不分页列表', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('265', '基本原料-分页列表', 'ACTION', '/mys/goodsmaterials', 'GET', null, null, '1', null, '0', '基本原料-分页列表', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('266', '商品单位-新增', 'ACTION', '/mys/goodsunit', 'POST', null, null, '1', null, '0', '商品单位-新增', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('267', '商品单位-修订', 'ACTION', '/mys/goodsunit/{}', 'PUT', null, null, '1', null, '0', '商品单位-修订', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('268', '商品单位-删除', 'ACTION', '/mys/goodsunit/{}', 'DELETE', null, null, '1', null, '0', '商品单位-删除', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('269', '商品单位-标识查询', 'ACTION', '/mys/goodsunit/{}', 'GET', null, null, '1', null, '0', '商品单位-标识查询', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('270', '商品单位-不分页列表', 'ACTION', '/mys/goodsunit', 'GET', null, null, '1', null, '0', '商品单位-不分页列表', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('271', '商品单位-分页列表', 'ACTION', '/mys/goodsunits', 'GET', null, null, '1', null, '0', '商品单位-分页列表', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('272', '消费套餐-新增', 'ACTION', '/mys/packages', 'POST', null, null, '1', null, '0', '消费套餐-新增', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('273', '消费套餐-修订', 'ACTION', '/mys/packages/{}', 'PUT', null, null, '1', null, '0', '消费套餐-修订', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('274', '消费套餐-删除', 'ACTION', '/mys/packages/{}', 'DELETE', null, null, '1', null, '0', '消费套餐-删除', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('275', '消费套餐-标识查询', 'ACTION', '/mys/packages/{}', 'GET', null, null, '1', null, '0', '消费套餐-标识查询', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('276', '消费套餐-不分页列表', 'ACTION', '/mys/packages', 'GET', null, null, '1', null, '0', '消费套餐-不分页列表', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('277', '消费套餐-分页列表', 'ACTION', '/mys/packagess', 'GET', null, null, '1', null, '0', '消费套餐-分页列表', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('278', '消费套餐详情-新增', 'ACTION', '/mys/packagesdetail', 'POST', null, null, '1', null, '0', '消费套餐详情-新增', 'admin', '2018-01-13 18:52:56', null, '2018-01-13 18:52:56');
INSERT INTO `ts_resource_info` VALUES ('279', '消费套餐详情-修订', 'ACTION', '/mys/packagesdetail/{}', 'PUT', null, null, '1', null, '0', '消费套餐详情-修订', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('280', '消费套餐详情-删除', 'ACTION', '/mys/packagesdetail/{}', 'DELETE', null, null, '1', null, '0', '消费套餐详情-删除', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('281', '消费套餐详情-标识查询', 'ACTION', '/mys/packagesdetail/{}', 'GET', null, null, '1', null, '0', '消费套餐详情-标识查询', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('282', '消费套餐详情-不分页列表', 'ACTION', '/mys/packagesdetail', 'GET', null, null, '1', null, '0', '消费套餐详情-不分页列表', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('283', '消费套餐详情-分页列表', 'ACTION', '/mys/packagesdetails', 'GET', null, null, '1', null, '0', '消费套餐详情-分页列表', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('284', '系统配置-新增', 'ACTION', '/mys/config', 'POST', null, null, '1', null, '0', '系统配置-新增', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('285', '系统配置-修订', 'ACTION', '/mys/config/{}', 'PUT', null, null, '1', null, '0', '系统配置-修订', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('286', '系统配置-删除', 'ACTION', '/mys/config/{}', 'DELETE', null, null, '1', null, '0', '系统配置-删除', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('287', '系统配置-标识查询', 'ACTION', '/mys/config/{}', 'GET', null, null, '1', null, '0', '系统配置-标识查询', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('288', '系统配置-不分页列表', 'ACTION', '/mys/config', 'GET', null, null, '1', null, '0', '系统配置-不分页列表', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('289', '系统配置-分页列表', 'ACTION', '/mys/configs', 'GET', null, null, '1', null, '0', '系统配置-分页列表', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('290', '字典值-新增', 'ACTION', '/mys/dictionary', 'POST', null, null, '1', null, '0', '字典值-新增', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('291', '字典值-修订', 'ACTION', '/mys/dictionary/{}', 'PUT', null, null, '1', null, '0', '字典值-修订', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('292', '字典值-删除', 'ACTION', '/mys/dictionary/{}', 'DELETE', null, null, '1', null, '0', '字典值-删除', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('293', '字典值-标识查询', 'ACTION', '/mys/dictionary/{}', 'GET', null, null, '1', null, '0', '字典值-标识查询', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('294', '字典值-不分页列表', 'ACTION', '/mys/dictionary', 'GET', null, null, '1', null, '0', '字典值-不分页列表', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('295', '字典值-分页列表', 'ACTION', '/mys/dictionarys', 'GET', null, null, '1', null, '0', '字典值-分页列表', 'admin', '2018-01-13 18:52:57', null, '2018-01-13 18:52:57');
INSERT INTO `ts_resource_info` VALUES ('296', '字典分组-新增', 'ACTION', '/mys/dictionarygroup', 'POST', null, null, '1', null, '0', '字典分组-新增', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('297', '字典分组-修订', 'ACTION', '/mys/dictionarygroup/{}', 'PUT', null, null, '1', null, '0', '字典分组-修订', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('298', '字典分组-删除', 'ACTION', '/mys/dictionarygroup/{}', 'DELETE', null, null, '1', null, '0', '字典分组-删除', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('299', '字典分组-标识查询', 'ACTION', '/mys/dictionarygroup/{}', 'GET', null, null, '1', null, '0', '字典分组-标识查询', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('300', '字典分组-不分页列表', 'ACTION', '/mys/dictionarygroup', 'GET', null, null, '1', null, '0', '字典分组-不分页列表', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('301', '字典分组-分页列表', 'ACTION', '/mys/dictionarygroups', 'GET', null, null, '1', null, '0', '字典分组-分页列表', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('302', '文档-新增', 'ACTION', '/mys/documentinfo', 'POST', null, null, '1', null, '0', '文档-新增', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('303', '文档-修订', 'ACTION', '/mys/documentinfo/{}', 'PUT', null, null, '1', null, '0', '文档-修订', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('304', '文档-删除', 'ACTION', '/mys/documentinfo/{}', 'DELETE', null, null, '1', null, '0', '文档-删除', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('305', '文档-标识查询', 'ACTION', '/mys/documentinfo/{}', 'GET', null, null, '1', null, '0', '文档-标识查询', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('306', '文档-不分页列表', 'ACTION', '/mys/documentinfo', 'GET', null, null, '1', null, '0', '文档-不分页列表', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('307', '文档-分页列表', 'ACTION', '/mys/documentinfos', 'GET', null, null, '1', null, '0', '文档-分页列表', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('308', '日志-新增', 'ACTION', '/mys/log', 'POST', null, null, '1', null, '0', '日志-新增', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('309', '日志-修订', 'ACTION', '/mys/log/{}', 'PUT', null, null, '1', null, '0', '日志-修订', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('310', '日志-删除', 'ACTION', '/mys/log/{}', 'DELETE', null, null, '1', null, '0', '日志-删除', 'admin', '2018-01-13 18:52:58', null, '2018-01-13 18:52:58');
INSERT INTO `ts_resource_info` VALUES ('311', '日志-标识查询', 'ACTION', '/mys/log/{}', 'GET', null, null, '1', null, '0', '日志-标识查询', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('312', '日志-不分页列表', 'ACTION', '/mys/log', 'GET', null, null, '1', null, '0', '日志-不分页列表', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('313', '日志-分页列表', 'ACTION', '/mys/logs', 'GET', null, null, '1', null, '0', '日志-分页列表', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('314', '资源菜单-新增', 'ACTION', '/mys/resourceinfo', 'POST', null, null, '1', null, '0', '资源菜单-新增', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('315', '资源菜单-修订', 'ACTION', '/mys/resourceinfo/{}', 'PUT', null, null, '1', null, '0', '资源菜单-修订', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('316', '资源菜单-删除', 'ACTION', '/mys/resourceinfo/{}', 'DELETE', null, null, '1', null, '0', '资源菜单-删除', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('317', '资源菜单-标识查询', 'ACTION', '/mys/resourceinfo/{}', 'GET', null, null, '1', null, '0', '资源菜单-标识查询', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('318', '资源菜单-不分页列表', 'ACTION', '/mys/resourceinfo', 'GET', null, null, '1', null, '0', '资源菜单-不分页列表', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('319', '资源菜单-分页列表', 'ACTION', '/mys/resourceinfos', 'GET', null, null, '1', null, '0', '资源菜单-分页列表', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('320', '角色-新增', 'ACTION', '/mys/roleinfo', 'POST', null, null, '1', null, '0', '角色-新增', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('321', '角色-修订', 'ACTION', '/mys/roleinfo/{}', 'PUT', null, null, '1', null, '0', '角色-修订', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('322', '角色-删除', 'ACTION', '/mys/roleinfo/{}', 'DELETE', null, null, '1', null, '0', '角色-删除', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('323', '角色-标识查询', 'ACTION', '/mys/roleinfo/{}', 'GET', null, null, '1', null, '0', '角色-标识查询', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('324', '角色-不分页列表', 'ACTION', '/mys/roleinfo', 'GET', null, null, '1', null, '0', '角色-不分页列表', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('325', '角色-分页列表', 'ACTION', '/mys/roleinfos', 'GET', null, null, '1', null, '0', '角色-分页列表', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('326', '角色权限-新增', 'ACTION', '/mys/rolepermission', 'POST', null, null, '1', null, '0', '角色权限-新增', 'admin', '2018-01-13 18:52:59', null, '2018-01-13 18:52:59');
INSERT INTO `ts_resource_info` VALUES ('327', '角色权限-修订', 'ACTION', '/mys/rolepermission/{}', 'PUT', null, null, '1', null, '0', '角色权限-修订', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('328', '角色权限-删除', 'ACTION', '/mys/rolepermission/{}', 'DELETE', null, null, '1', null, '0', '角色权限-删除', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('329', '角色权限-标识查询', 'ACTION', '/mys/rolepermission/{}', 'GET', null, null, '1', null, '0', '角色权限-标识查询', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('330', '角色权限-不分页列表', 'ACTION', '/mys/rolepermission', 'GET', null, null, '1', null, '0', '角色权限-不分页列表', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('331', '角色权限-分页列表', 'ACTION', '/mys/rolepermissions', 'GET', null, null, '1', null, '0', '角色权限-分页列表', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('332', '用户-新增', 'ACTION', '/mys/user', 'POST', null, null, '1', null, '0', '用户-新增', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('333', '用户-修订', 'ACTION', '/mys/user/{}', 'PUT', null, null, '1', null, '0', '用户-修订', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('334', '用户-删除', 'ACTION', '/mys/user/{}', 'DELETE', null, null, '1', null, '0', '用户-删除', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('335', '用户-标识查询', 'ACTION', '/mys/user/{}', 'GET', null, null, '1', null, '0', '用户-标识查询', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('336', '用户-不分页列表', 'ACTION', '/mys/user', 'GET', null, null, '1', null, '0', '用户-不分页列表', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('337', '用户-分页列表', 'ACTION', '/mys/users', 'GET', null, null, '1', null, '0', '用户-分页列表', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('338', '用户组-新增', 'ACTION', '/mys/usergroup', 'POST', null, null, '1', null, '0', '用户组-新增', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('339', '用户组-修订', 'ACTION', '/mys/usergroup/{}', 'PUT', null, null, '1', null, '0', '用户组-修订', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('340', '用户组-删除', 'ACTION', '/mys/usergroup/{}', 'DELETE', null, null, '1', null, '0', '用户组-删除', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('341', '用户组-标识查询', 'ACTION', '/mys/usergroup/{}', 'GET', null, null, '1', null, '0', '用户组-标识查询', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('342', '用户组-不分页列表', 'ACTION', '/mys/usergroup', 'GET', null, null, '1', null, '0', '用户组-不分页列表', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('343', '用户组-分页列表', 'ACTION', '/mys/usergroups', 'GET', null, null, '1', null, '0', '用户组-分页列表', 'admin', '2018-01-13 18:53:00', null, '2018-01-13 18:53:00');
INSERT INTO `ts_resource_info` VALUES ('344', '用户权限-新增', 'ACTION', '/mys/userrole', 'POST', null, null, '1', null, '0', '用户权限-新增', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('345', '用户权限-修订', 'ACTION', '/mys/userrole/{}', 'PUT', null, null, '1', null, '0', '用户权限-修订', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('346', '用户权限-删除', 'ACTION', '/mys/userrole/{}', 'DELETE', null, null, '1', null, '0', '用户权限-删除', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('347', '用户权限-标识查询', 'ACTION', '/mys/userrole/{}', 'GET', null, null, '1', null, '0', '用户权限-标识查询', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('348', '用户权限-不分页列表', 'ACTION', '/mys/userrole', 'GET', null, null, '1', null, '0', '用户权限-不分页列表', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('349', '用户权限-分页列表', 'ACTION', '/mys/userroles', 'GET', null, null, '1', null, '0', '用户权限-分页列表', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('350', '优惠卷组-新增', 'ACTION', '/mys/coupon', 'POST', null, null, '1', null, '0', '优惠卷组-新增', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('351', '优惠卷组-修订', 'ACTION', '/mys/coupon/{}', 'PUT', null, null, '1', null, '0', '优惠卷组-修订', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('352', '优惠卷组-删除', 'ACTION', '/mys/coupon/{}', 'DELETE', null, null, '1', null, '0', '优惠卷组-删除', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('353', '优惠卷组-标识查询', 'ACTION', '/mys/coupon/{}', 'GET', null, null, '1', null, '0', '优惠卷组-标识查询', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('354', '优惠卷组-不分页列表', 'ACTION', '/mys/coupon', 'GET', null, null, '1', null, '0', '优惠卷组-不分页列表', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('355', '优惠卷组-分页列表', 'ACTION', '/mys/coupons', 'GET', null, null, '1', null, '0', '优惠卷组-分页列表', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('356', '优惠项目-新增', 'ACTION', '/mys/couponitem', 'POST', null, null, '1', null, '0', '优惠项目-新增', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('357', '优惠项目-修订', 'ACTION', '/mys/couponitem/{}', 'PUT', null, null, '1', null, '0', '优惠项目-修订', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('358', '优惠项目-删除', 'ACTION', '/mys/couponitem/{}', 'DELETE', null, null, '1', null, '0', '优惠项目-删除', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('359', '优惠项目-标识查询', 'ACTION', '/mys/couponitem/{}', 'GET', null, null, '1', null, '0', '优惠项目-标识查询', 'admin', '2018-01-13 18:53:01', null, '2018-01-13 18:53:01');
INSERT INTO `ts_resource_info` VALUES ('360', '优惠项目-不分页列表', 'ACTION', '/mys/couponitem', 'GET', null, null, '1', null, '0', '优惠项目-不分页列表', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('361', '优惠项目-分页列表', 'ACTION', '/mys/couponitems', 'GET', null, null, '1', null, '0', '优惠项目-分页列表', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('362', '结算币种-新增', 'ACTION', '/mys/exchange', 'POST', null, null, '1', null, '0', '结算币种-新增', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('363', '结算币种-修订', 'ACTION', '/mys/exchange/{}', 'PUT', null, null, '1', null, '0', '结算币种-修订', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('364', '结算币种-删除', 'ACTION', '/mys/exchange/{}', 'DELETE', null, null, '1', null, '0', '结算币种-删除', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('365', '结算币种-标识查询', 'ACTION', '/mys/exchange/{}', 'GET', null, null, '1', null, '0', '结算币种-标识查询', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('366', '结算币种-不分页列表', 'ACTION', '/mys/exchange', 'GET', null, null, '1', null, '0', '结算币种-不分页列表', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('367', '结算币种-分页列表', 'ACTION', '/mys/exchanges', 'GET', null, null, '1', null, '0', '结算币种-分页列表', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('368', '会员价格-新增', 'ACTION', '/mys/memberprice', 'POST', null, null, '1', null, '0', '会员价格-新增', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('369', '会员价格-修订', 'ACTION', '/mys/memberprice/{}', 'PUT', null, null, '1', null, '0', '会员价格-修订', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('370', '会员价格-删除', 'ACTION', '/mys/memberprice/{}', 'DELETE', null, null, '1', null, '0', '会员价格-删除', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('371', '会员价格-标识查询', 'ACTION', '/mys/memberprice/{}', 'GET', null, null, '1', null, '0', '会员价格-标识查询', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('372', '会员价格-不分页列表', 'ACTION', '/mys/memberprice', 'GET', null, null, '1', null, '0', '会员价格-不分页列表', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('373', '会员价格-分页列表', 'ACTION', '/mys/memberprices', 'GET', null, null, '1', null, '0', '会员价格-分页列表', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('374', '消费结算-新增', 'ACTION', '/mys/settlement', 'POST', null, null, '1', null, '0', '消费结算-新增', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('375', '消费结算-修订', 'ACTION', '/mys/settlement/{}', 'PUT', null, null, '1', null, '0', '消费结算-修订', 'admin', '2018-01-13 18:53:02', null, '2018-01-13 18:53:02');
INSERT INTO `ts_resource_info` VALUES ('376', '消费结算-删除', 'ACTION', '/mys/settlement/{}', 'DELETE', null, null, '1', null, '0', '消费结算-删除', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('377', '消费结算-标识查询', 'ACTION', '/mys/settlement/{}', 'GET', null, null, '1', null, '0', '消费结算-标识查询', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('378', '消费结算-不分页列表', 'ACTION', '/mys/settlement', 'GET', null, null, '1', null, '0', '消费结算-不分页列表', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('379', '消费结算-分页列表', 'ACTION', '/mys/settlements', 'GET', null, null, '1', null, '0', '消费结算-分页列表', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('380', '消费清单-新增', 'ACTION', '/mys/trade', 'POST', null, null, '1', null, '0', '消费清单-新增', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('381', '消费清单-修订', 'ACTION', '/mys/trade/{}', 'PUT', null, null, '1', null, '0', '消费清单-修订', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('382', '消费清单-删除', 'ACTION', '/mys/trade/{}', 'DELETE', null, null, '1', null, '0', '消费清单-删除', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('383', '消费清单-标识查询', 'ACTION', '/mys/trade/{}', 'GET', null, null, '1', null, '0', '消费清单-标识查询', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('384', '消费清单-不分页列表', 'ACTION', '/mys/trade', 'GET', null, null, '1', null, '0', '消费清单-不分页列表', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('385', '消费清单-分页列表', 'ACTION', '/mys/trades', 'GET', null, null, '1', null, '0', '消费清单-分页列表', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('386', '结算优惠项-新增', 'ACTION', '/mys/tradediscount', 'POST', null, null, '1', null, '0', '结算优惠项-新增', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('387', '结算优惠项-修订', 'ACTION', '/mys/tradediscount/{}', 'PUT', null, null, '1', null, '0', '结算优惠项-修订', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('388', '结算优惠项-删除', 'ACTION', '/mys/tradediscount/{}', 'DELETE', null, null, '1', null, '0', '结算优惠项-删除', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('389', '结算优惠项-标识查询', 'ACTION', '/mys/tradediscount/{}', 'GET', null, null, '1', null, '0', '结算优惠项-标识查询', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('390', '结算优惠项-不分页列表', 'ACTION', '/mys/tradediscount', 'GET', null, null, '1', null, '0', '结算优惠项-不分页列表', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('391', '结算优惠项-分页列表', 'ACTION', '/mys/tradediscounts', 'GET', null, null, '1', null, '0', '结算优惠项-分页列表', 'admin', '2018-01-13 18:53:03', null, '2018-01-13 18:53:03');
INSERT INTO `ts_resource_info` VALUES ('392', '优惠券-新增', 'ACTION', '/mys/volume', 'POST', null, null, '1', null, '0', '优惠券-新增', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('393', '优惠券-修订', 'ACTION', '/mys/volume/{}', 'PUT', null, null, '1', null, '0', '优惠券-修订', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('394', '优惠券-删除', 'ACTION', '/mys/volume/{}', 'DELETE', null, null, '1', null, '0', '优惠券-删除', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('395', '优惠券-标识查询', 'ACTION', '/mys/volume/{}', 'GET', null, null, '1', null, '0', '优惠券-标识查询', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('396', '优惠券-不分页列表', 'ACTION', '/mys/volume', 'GET', null, null, '1', null, '0', '优惠券-不分页列表', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('397', '优惠券-分页列表', 'ACTION', '/mys/volumes', 'GET', null, null, '1', null, '0', '优惠券-分页列表', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('398', '门店考勤-新增', 'ACTION', '/mys/attendance', 'POST', null, null, '1', null, '0', '门店考勤-新增', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('399', '门店考勤-修订', 'ACTION', '/mys/attendance/{}', 'PUT', null, null, '1', null, '0', '门店考勤-修订', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('400', '门店考勤-删除', 'ACTION', '/mys/attendance/{}', 'DELETE', null, null, '1', null, '0', '门店考勤-删除', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('401', '门店考勤-标识查询', 'ACTION', '/mys/attendance/{}', 'GET', null, null, '1', null, '0', '门店考勤-标识查询', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('402', '门店考勤-不分页列表', 'ACTION', '/mys/attendance', 'GET', null, null, '1', null, '0', '门店考勤-不分页列表', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('403', '门店考勤-分页列表', 'ACTION', '/mys/attendances', 'GET', null, null, '1', null, '0', '门店考勤-分页列表', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('404', '门店考勤详情-新增', 'ACTION', '/mys/attendancedetail', 'POST', null, null, '1', null, '0', '门店考勤详情-新增', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('405', '门店考勤详情-修订', 'ACTION', '/mys/attendancedetail/{}', 'PUT', null, null, '1', null, '0', '门店考勤详情-修订', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('406', '门店考勤详情-删除', 'ACTION', '/mys/attendancedetail/{}', 'DELETE', null, null, '1', null, '0', '门店考勤详情-删除', 'admin', '2018-01-13 18:53:04', null, '2018-01-13 18:53:04');
INSERT INTO `ts_resource_info` VALUES ('407', '门店考勤详情-标识查询', 'ACTION', '/mys/attendancedetail/{}', 'GET', null, null, '1', null, '0', '门店考勤详情-标识查询', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('408', '门店考勤详情-不分页列表', 'ACTION', '/mys/attendancedetail', 'GET', null, null, '1', null, '0', '门店考勤详情-不分页列表', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('409', '门店考勤详情-分页列表', 'ACTION', '/mys/attendancedetails', 'GET', null, null, '1', null, '0', '门店考勤详情-分页列表', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('410', '打卡记录-新增', 'ACTION', '/mys/employeeattend', 'POST', null, null, '1', null, '0', '打卡记录-新增', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('411', '打卡记录-修订', 'ACTION', '/mys/employeeattend/{}', 'PUT', null, null, '1', null, '0', '打卡记录-修订', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('412', '打卡记录-删除', 'ACTION', '/mys/employeeattend/{}', 'DELETE', null, null, '1', null, '0', '打卡记录-删除', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('413', '打卡记录-标识查询', 'ACTION', '/mys/employeeattend/{}', 'GET', null, null, '1', null, '0', '打卡记录-标识查询', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('414', '打卡记录-不分页列表', 'ACTION', '/mys/employeeattend', 'GET', null, null, '1', null, '0', '打卡记录-不分页列表', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('415', '打卡记录-分页列表', 'ACTION', '/mys/employeeattends', 'GET', null, null, '1', null, '0', '打卡记录-分页列表', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('416', '员工考勤关系-新增', 'ACTION', '/mys/employeeattendance', 'POST', null, null, '1', null, '0', '员工考勤关系-新增', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('417', '员工考勤关系-修订', 'ACTION', '/mys/employeeattendance/{}', 'PUT', null, null, '1', null, '0', '员工考勤关系-修订', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('418', '员工考勤关系-删除', 'ACTION', '/mys/employeeattendance/{}', 'DELETE', null, null, '1', null, '0', '员工考勤关系-删除', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('419', '员工考勤关系-标识查询', 'ACTION', '/mys/employeeattendance/{}', 'GET', null, null, '1', null, '0', '员工考勤关系-标识查询', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('420', '员工考勤关系-不分页列表', 'ACTION', '/mys/employeeattendance', 'GET', null, null, '1', null, '0', '员工考勤关系-不分页列表', 'admin', '2018-01-13 18:53:05', null, '2018-01-13 18:53:05');
INSERT INTO `ts_resource_info` VALUES ('421', '员工考勤关系-分页列表', 'ACTION', '/mys/employeeattendances', 'GET', null, null, '1', null, '0', '员工考勤关系-分页列表', 'admin', '2018-01-13 18:53:06', null, '2018-01-13 18:53:06');
INSERT INTO `ts_resource_info` VALUES ('422', '员工考勤日志-新增', 'ACTION', '/mys/employeejournal', 'POST', null, null, '1', null, '0', '员工考勤日志-新增', 'admin', '2018-01-13 18:53:06', null, '2018-01-13 18:53:06');
INSERT INTO `ts_resource_info` VALUES ('423', '员工考勤日志-修订', 'ACTION', '/mys/employeejournal/{}', 'PUT', null, null, '1', null, '0', '员工考勤日志-修订', 'admin', '2018-01-13 18:53:06', null, '2018-01-13 18:53:06');
INSERT INTO `ts_resource_info` VALUES ('424', '员工考勤日志-删除', 'ACTION', '/mys/employeejournal/{}', 'DELETE', null, null, '1', null, '0', '员工考勤日志-删除', 'admin', '2018-01-13 18:53:06', null, '2018-01-13 18:53:06');
INSERT INTO `ts_resource_info` VALUES ('425', '员工考勤日志-标识查询', 'ACTION', '/mys/employeejournal/{}', 'GET', null, null, '1', null, '0', '员工考勤日志-标识查询', 'admin', '2018-01-13 18:53:06', null, '2018-01-13 18:53:06');
INSERT INTO `ts_resource_info` VALUES ('426', '员工考勤日志-不分页列表', 'ACTION', '/mys/employeejournal', 'GET', null, null, '1', null, '0', '员工考勤日志-不分页列表', 'admin', '2018-01-13 18:53:06', null, '2018-01-13 18:53:06');
INSERT INTO `ts_resource_info` VALUES ('427', '员工考勤日志-分页列表', 'ACTION', '/mys/employeejournals', 'GET', null, null, '1', null, '0', '员工考勤日志-分页列表', 'admin', '2018-01-13 18:53:06', null, '2018-01-13 18:53:06');
INSERT INTO `ts_resource_info` VALUES ('428', '部门-列表', 'HTML', '/department/DepartmentList.html', 'POST', null, null, '0', null, '0', '部门-列表', 'admin', '2018-01-13 19:24:18', null, '2018-01-13 19:24:18');
INSERT INTO `ts_resource_info` VALUES ('429', '部门-新增', 'HTML', '/department/DepartmentAdd.html', 'PUT', null, null, '0', null, '0', '部门-新增', 'admin', '2018-01-13 19:24:18', null, '2018-01-13 19:24:18');
INSERT INTO `ts_resource_info` VALUES ('430', '部门-修订', 'HTML', '/department/DepartmentEdit.html', 'DELETE', null, null, '0', null, '0', '部门-修订', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('431', '员工-列表', 'HTML', '/employee/EmployeeList.html', 'POST', null, null, '0', null, '0', '员工-列表', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('432', '员工-新增', 'HTML', '/employee/EmployeeAdd.html', 'PUT', null, null, '0', null, '0', '员工-新增', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('433', '员工-修订', 'HTML', '/employee/EmployeeEdit.html', 'DELETE', null, null, '0', null, '0', '员工-修订', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('434', '员工特殊权限(扩)-列表', 'HTML', '/employeespecial/EmployeeSpecialList.html', 'POST', null, null, '0', null, '0', '员工特殊权限(扩)-列表', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('435', '员工特殊权限(扩)-新增', 'HTML', '/employeespecial/EmployeeSpecialAdd.html', 'PUT', null, null, '0', null, '0', '员工特殊权限(扩)-新增', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('436', '员工特殊权限(扩)-修订', 'HTML', '/employeespecial/EmployeeSpecialEdit.html', 'DELETE', null, null, '0', null, '0', '员工特殊权限(扩)-修订', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('437', '会员-列表', 'HTML', '/member/MemberList.html', 'POST', null, null, '0', null, '0', '会员-列表', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('438', '会员-新增', 'HTML', '/member/MemberAdd.html', 'PUT', null, null, '0', null, '0', '会员-新增', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('439', '会员-修订', 'HTML', '/member/MemberEdit.html', 'DELETE', null, null, '0', null, '0', '会员-修订', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('440', '会员体系-列表', 'HTML', '/memberlevel/MemberLevelList.html', 'POST', null, null, '0', null, '0', '会员体系-列表', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('441', '会员体系-新增', 'HTML', '/memberlevel/MemberLevelAdd.html', 'PUT', null, null, '0', null, '0', '会员体系-新增', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('442', '会员体系-修订', 'HTML', '/memberlevel/MemberLevelEdit.html', 'DELETE', null, null, '0', null, '0', '会员体系-修订', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('443', '会员充值活动-列表', 'HTML', '/memberplus/MemberPlusList.html', 'POST', null, null, '0', null, '0', '会员充值活动-列表', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('444', '会员充值活动-新增', 'HTML', '/memberplus/MemberPlusAdd.html', 'PUT', null, null, '0', null, '0', '会员充值活动-新增', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('445', '会员充值活动-修订', 'HTML', '/memberplus/MemberPlusEdit.html', 'DELETE', null, null, '0', null, '0', '会员充值活动-修订', 'admin', '2018-01-13 19:24:19', null, '2018-01-13 19:24:19');
INSERT INTO `ts_resource_info` VALUES ('446', '会员充值记录-列表', 'HTML', '/memberrecord/MemberRecordList.html', 'POST', null, null, '0', null, '0', '会员充值记录-列表', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('447', '会员充值记录-新增', 'HTML', '/memberrecord/MemberRecordAdd.html', 'PUT', null, null, '0', null, '0', '会员充值记录-新增', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('448', '会员充值记录-修订', 'HTML', '/memberrecord/MemberRecordEdit.html', 'DELETE', null, null, '0', null, '0', '会员充值记录-修订', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('449', '房间预定-列表', 'HTML', '/reservation/ReservationList.html', 'POST', null, null, '0', null, '0', '房间预定-列表', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('450', '房间预定-新增', 'HTML', '/reservation/ReservationAdd.html', 'PUT', null, null, '0', null, '0', '房间预定-新增', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('451', '房间预定-修订', 'HTML', '/reservation/ReservationEdit.html', 'DELETE', null, null, '0', null, '0', '房间预定-修订', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('452', '消费商品详情-列表', 'HTML', '/reservationtrade/ReservationTradeList.html', 'POST', null, null, '0', null, '0', '消费商品详情-列表', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('453', '消费商品详情-新增', 'HTML', '/reservationtrade/ReservationTradeAdd.html', 'PUT', null, null, '0', null, '0', '消费商品详情-新增', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('454', '消费商品详情-修订', 'HTML', '/reservationtrade/ReservationTradeEdit.html', 'DELETE', null, null, '0', null, '0', '消费商品详情-修订', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('455', '房间-列表', 'HTML', '/room/RoomList.html', 'POST', null, null, '0', null, '0', '房间-列表', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('456', '房间-新增', 'HTML', '/room/RoomAdd.html', 'PUT', null, null, '0', null, '0', '房间-新增', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('457', '房间-修订', 'HTML', '/room/RoomEdit.html', 'DELETE', null, null, '0', null, '0', '房间-修订', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('458', '门店-列表', 'HTML', '/store/StoreList.html', 'POST', null, null, '0', null, '0', '门店-列表', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('459', '门店-新增', 'HTML', '/store/StoreAdd.html', 'PUT', null, null, '0', null, '0', '门店-新增', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('460', '门店-修订', 'HTML', '/store/StoreEdit.html', 'DELETE', null, null, '0', null, '0', '门店-修订', 'admin', '2018-01-13 19:24:20', null, '2018-01-13 19:24:20');
INSERT INTO `ts_resource_info` VALUES ('461', '手牌-列表', 'HTML', '/strap/StrapList.html', 'POST', null, null, '0', null, '0', '手牌-列表', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('462', '手牌-新增', 'HTML', '/strap/StrapAdd.html', 'PUT', null, null, '0', null, '0', '手牌-新增', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('463', '手牌-修订', 'HTML', '/strap/StrapEdit.html', 'DELETE', null, null, '0', null, '0', '手牌-修订', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('464', '类型配置-列表', 'HTML', '/types/TypesList.html', 'POST', null, null, '0', null, '0', '类型配置-列表', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('465', '类型配置-新增', 'HTML', '/types/TypesAdd.html', 'PUT', null, null, '0', null, '0', '类型配置-新增', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('466', '类型配置-修订', 'HTML', '/types/TypesEdit.html', 'DELETE', null, null, '0', null, '0', '类型配置-修订', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('467', '类型消费绑定-列表', 'HTML', '/typesbind/TypesBindList.html', 'POST', null, null, '0', null, '0', '类型消费绑定-列表', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('468', '类型消费绑定-新增', 'HTML', '/typesbind/TypesBindAdd.html', 'PUT', null, null, '0', null, '0', '类型消费绑定-新增', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('469', '类型消费绑定-修订', 'HTML', '/typesbind/TypesBindEdit.html', 'DELETE', null, null, '0', null, '0', '类型消费绑定-修订', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('470', '报钟播报-列表', 'HTML', '/clockbroadcast/ClockBroadcastList.html', 'POST', null, null, '0', null, '0', '报钟播报-列表', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('471', '报钟播报-新增', 'HTML', '/clockbroadcast/ClockBroadcastAdd.html', 'PUT', null, null, '0', null, '0', '报钟播报-新增', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('472', '报钟播报-修订', 'HTML', '/clockbroadcast/ClockBroadcastEdit.html', 'DELETE', null, null, '0', null, '0', '报钟播报-修订', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('473', '订单-列表', 'HTML', '/clockorder/ClockOrderList.html', 'POST', null, null, '0', null, '0', '订单-列表', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('474', '订单-新增', 'HTML', '/clockorder/ClockOrderAdd.html', 'PUT', null, null, '0', null, '0', '订单-新增', 'admin', '2018-01-13 19:24:21', null, '2018-01-13 19:24:21');
INSERT INTO `ts_resource_info` VALUES ('475', '订单-修订', 'HTML', '/clockorder/ClockOrderEdit.html', 'DELETE', null, null, '0', null, '0', '订单-修订', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('476', '应钟记录-列表', 'HTML', '/clockrecord/ClockRecordList.html', 'POST', null, null, '0', null, '0', '应钟记录-列表', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('477', '应钟记录-新增', 'HTML', '/clockrecord/ClockRecordAdd.html', 'PUT', null, null, '0', null, '0', '应钟记录-新增', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('478', '应钟记录-修订', 'HTML', '/clockrecord/ClockRecordEdit.html', 'DELETE', null, null, '0', null, '0', '应钟记录-修订', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('479', '技能-列表', 'HTML', '/clockskill/ClockSkillList.html', 'POST', null, null, '0', null, '0', '技能-列表', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('480', '技能-新增', 'HTML', '/clockskill/ClockSkillAdd.html', 'PUT', null, null, '0', null, '0', '技能-新增', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('481', '技能-修订', 'HTML', '/clockskill/ClockSkillEdit.html', 'DELETE', null, null, '0', null, '0', '技能-修订', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('482', '轮班-列表', 'HTML', '/skillclass/SkillClassList.html', 'POST', null, null, '0', null, '0', '轮班-列表', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('483', '轮班-新增', 'HTML', '/skillclass/SkillClassAdd.html', 'PUT', null, null, '0', null, '0', '轮班-新增', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('484', '轮班-修订', 'HTML', '/skillclass/SkillClassEdit.html', 'DELETE', null, null, '0', null, '0', '轮班-修订', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('485', '技师-列表', 'HTML', '/technician/TechnicianList.html', 'POST', null, null, '0', null, '0', '技师-列表', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('486', '技师-新增', 'HTML', '/technician/TechnicianAdd.html', 'PUT', null, null, '0', null, '0', '技师-新增', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('487', '技师-修订', 'HTML', '/technician/TechnicianEdit.html', 'DELETE', null, null, '0', null, '0', '技师-修订', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('488', '轮班详情-列表', 'HTML', '/technicianclass/TechnicianClassList.html', 'POST', null, null, '0', null, '0', '轮班详情-列表', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('489', '轮班详情-新增', 'HTML', '/technicianclass/TechnicianClassAdd.html', 'PUT', null, null, '0', null, '0', '轮班详情-新增', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('490', '轮班详情-修订', 'HTML', '/technicianclass/TechnicianClassEdit.html', 'DELETE', null, null, '0', null, '0', '轮班详情-修订', 'admin', '2018-01-13 19:24:22', null, '2018-01-13 19:24:22');
INSERT INTO `ts_resource_info` VALUES ('491', '技师班次-列表', 'HTML', '/technicianshift/TechnicianShiftList.html', 'POST', null, null, '0', null, '0', '技师班次-列表', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('492', '技师班次-新增', 'HTML', '/technicianshift/TechnicianShiftAdd.html', 'PUT', null, null, '0', null, '0', '技师班次-新增', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('493', '技师班次-修订', 'HTML', '/technicianshift/TechnicianShiftEdit.html', 'DELETE', null, null, '0', null, '0', '技师班次-修订', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('494', '技师技能-列表', 'HTML', '/technicianskill/TechnicianSkillList.html', 'POST', null, null, '0', null, '0', '技师技能-列表', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('495', '技师技能-新增', 'HTML', '/technicianskill/TechnicianSkillAdd.html', 'PUT', null, null, '0', null, '0', '技师技能-新增', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('496', '技师技能-修订', 'HTML', '/technicianskill/TechnicianSkillEdit.html', 'DELETE', null, null, '0', null, '0', '技师技能-修订', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('497', '消费授权-列表', 'HTML', '/authorization/AuthorizationList.html', 'POST', null, null, '0', null, '0', '消费授权-列表', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('498', '消费授权-新增', 'HTML', '/authorization/AuthorizationAdd.html', 'PUT', null, null, '0', null, '0', '消费授权-新增', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('499', '消费授权-修订', 'HTML', '/authorization/AuthorizationEdit.html', 'DELETE', null, null, '0', null, '0', '消费授权-修订', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('500', '客户-列表', 'HTML', '/customer/CustomerList.html', 'POST', null, null, '0', null, '0', '客户-列表', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('501', '客户-新增', 'HTML', '/customer/CustomerAdd.html', 'PUT', null, null, '0', null, '0', '客户-新增', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('502', '客户-修订', 'HTML', '/customer/CustomerEdit.html', 'DELETE', null, null, '0', null, '0', '客户-修订', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('503', '商品服务-列表', 'HTML', '/goods/GoodsList.html', 'POST', null, null, '0', null, '0', '商品服务-列表', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('504', '商品服务-新增', 'HTML', '/goods/GoodsAdd.html', 'PUT', null, null, '0', null, '0', '商品服务-新增', 'admin', '2018-01-13 19:24:23', null, '2018-01-13 19:24:23');
INSERT INTO `ts_resource_info` VALUES ('505', '商品服务-修订', 'HTML', '/goods/GoodsEdit.html', 'DELETE', null, null, '0', null, '0', '商品服务-修订', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('506', '商品服务扩展-列表', 'HTML', '/goodsext/GoodsExtList.html', 'POST', null, null, '0', null, '0', '商品服务扩展-列表', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('507', '商品服务扩展-新增', 'HTML', '/goodsext/GoodsExtAdd.html', 'PUT', null, null, '0', null, '0', '商品服务扩展-新增', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('508', '商品服务扩展-修订', 'HTML', '/goodsext/GoodsExtEdit.html', 'DELETE', null, null, '0', null, '0', '商品服务扩展-修订', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('509', '基本原料-列表', 'HTML', '/goodsmaterial/GoodsMaterialList.html', 'POST', null, null, '0', null, '0', '基本原料-列表', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('510', '基本原料-新增', 'HTML', '/goodsmaterial/GoodsMaterialAdd.html', 'PUT', null, null, '0', null, '0', '基本原料-新增', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('511', '基本原料-修订', 'HTML', '/goodsmaterial/GoodsMaterialEdit.html', 'DELETE', null, null, '0', null, '0', '基本原料-修订', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('512', '商品单位-列表', 'HTML', '/goodsunit/GoodsUnitList.html', 'POST', null, null, '0', null, '0', '商品单位-列表', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('513', '商品单位-新增', 'HTML', '/goodsunit/GoodsUnitAdd.html', 'PUT', null, null, '0', null, '0', '商品单位-新增', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('514', '商品单位-修订', 'HTML', '/goodsunit/GoodsUnitEdit.html', 'DELETE', null, null, '0', null, '0', '商品单位-修订', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('515', '消费套餐-列表', 'HTML', '/packages/PackagesList.html', 'POST', null, null, '0', null, '0', '消费套餐-列表', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('516', '消费套餐-新增', 'HTML', '/packages/PackagesAdd.html', 'PUT', null, null, '0', null, '0', '消费套餐-新增', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('517', '消费套餐-修订', 'HTML', '/packages/PackagesEdit.html', 'DELETE', null, null, '0', null, '0', '消费套餐-修订', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('518', '消费套餐详情-列表', 'HTML', '/packagesdetail/PackagesDetailList.html', 'POST', null, null, '0', null, '0', '消费套餐详情-列表', 'admin', '2018-01-13 19:24:24', null, '2018-01-13 19:24:24');
INSERT INTO `ts_resource_info` VALUES ('519', '消费套餐详情-新增', 'HTML', '/packagesdetail/PackagesDetailAdd.html', 'PUT', null, null, '0', null, '0', '消费套餐详情-新增', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('520', '消费套餐详情-修订', 'HTML', '/packagesdetail/PackagesDetailEdit.html', 'DELETE', null, null, '0', null, '0', '消费套餐详情-修订', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('521', '系统配置-列表', 'HTML', '/config/ConfigList.html', 'POST', null, null, '0', null, '0', '系统配置-列表', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('522', '系统配置-新增', 'HTML', '/config/ConfigAdd.html', 'PUT', null, null, '0', null, '0', '系统配置-新增', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('523', '系统配置-修订', 'HTML', '/config/ConfigEdit.html', 'DELETE', null, null, '0', null, '0', '系统配置-修订', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('524', '字典值-列表', 'HTML', '/dictionary/DictionaryList.html', 'POST', null, null, '0', null, '0', '字典值-列表', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('525', '字典值-新增', 'HTML', '/dictionary/DictionaryAdd.html', 'PUT', null, null, '0', null, '0', '字典值-新增', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('526', '字典值-修订', 'HTML', '/dictionary/DictionaryEdit.html', 'DELETE', null, null, '0', null, '0', '字典值-修订', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('527', '字典分组-列表', 'HTML', '/dictionarygroup/DictionaryGroupList.html', 'POST', null, null, '0', null, '0', '字典分组-列表', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('528', '字典分组-新增', 'HTML', '/dictionarygroup/DictionaryGroupAdd.html', 'PUT', null, null, '0', null, '0', '字典分组-新增', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('529', '字典分组-修订', 'HTML', '/dictionarygroup/DictionaryGroupEdit.html', 'DELETE', null, null, '0', null, '0', '字典分组-修订', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('530', '文档-列表', 'HTML', '/documentinfo/DocumentInfoList.html', 'POST', null, null, '0', null, '0', '文档-列表', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('531', '文档-新增', 'HTML', '/documentinfo/DocumentInfoAdd.html', 'PUT', null, null, '0', null, '0', '文档-新增', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('532', '文档-修订', 'HTML', '/documentinfo/DocumentInfoEdit.html', 'DELETE', null, null, '0', null, '0', '文档-修订', 'admin', '2018-01-13 19:24:25', null, '2018-01-13 19:24:25');
INSERT INTO `ts_resource_info` VALUES ('533', '日志-列表', 'HTML', '/log/LogList.html', 'POST', null, null, '0', null, '0', '日志-列表', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('534', '日志-新增', 'HTML', '/log/LogAdd.html', 'PUT', null, null, '0', null, '0', '日志-新增', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('535', '日志-修订', 'HTML', '/log/LogEdit.html', 'DELETE', null, null, '0', null, '0', '日志-修订', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('536', '资源菜单-列表', 'HTML', '/resourceinfo/ResourceInfoList.html', 'POST', null, null, '0', null, '0', '资源菜单-列表', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('537', '资源菜单-新增', 'HTML', '/resourceinfo/ResourceInfoAdd.html', 'PUT', null, null, '0', null, '0', '资源菜单-新增', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('538', '资源菜单-修订', 'HTML', '/resourceinfo/ResourceInfoEdit.html', 'DELETE', null, null, '0', null, '0', '资源菜单-修订', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('539', '角色-列表', 'HTML', '/roleinfo/RoleInfoList.html', 'POST', null, null, '0', null, '0', '角色-列表', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('540', '角色-新增', 'HTML', '/roleinfo/RoleInfoAdd.html', 'PUT', null, null, '0', null, '0', '角色-新增', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('541', '角色-修订', 'HTML', '/roleinfo/RoleInfoEdit.html', 'DELETE', null, null, '0', null, '0', '角色-修订', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('542', '角色权限-列表', 'HTML', '/rolepermission/RolePermissionList.html', 'POST', null, null, '0', null, '0', '角色权限-列表', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('543', '角色权限-新增', 'HTML', '/rolepermission/RolePermissionAdd.html', 'PUT', null, null, '0', null, '0', '角色权限-新增', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('544', '角色权限-修订', 'HTML', '/rolepermission/RolePermissionEdit.html', 'DELETE', null, null, '0', null, '0', '角色权限-修订', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('545', '用户-列表', 'HTML', '/user/UserList.html', 'POST', null, null, '0', null, '0', '用户-列表', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('546', '用户-新增', 'HTML', '/user/UserAdd.html', 'PUT', null, null, '0', null, '0', '用户-新增', 'admin', '2018-01-13 19:24:26', null, '2018-01-13 19:24:26');
INSERT INTO `ts_resource_info` VALUES ('547', '用户-修订', 'HTML', '/user/UserEdit.html', 'DELETE', null, null, '0', null, '0', '用户-修订', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('548', '用户组-列表', 'HTML', '/usergroup/UserGroupList.html', 'POST', null, null, '0', null, '0', '用户组-列表', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('549', '用户组-新增', 'HTML', '/usergroup/UserGroupAdd.html', 'PUT', null, null, '0', null, '0', '用户组-新增', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('550', '用户组-修订', 'HTML', '/usergroup/UserGroupEdit.html', 'DELETE', null, null, '0', null, '0', '用户组-修订', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('551', '用户权限-列表', 'HTML', '/userrole/UserRoleList.html', 'POST', null, null, '0', null, '0', '用户权限-列表', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('552', '用户权限-新增', 'HTML', '/userrole/UserRoleAdd.html', 'PUT', null, null, '0', null, '0', '用户权限-新增', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('553', '用户权限-修订', 'HTML', '/userrole/UserRoleEdit.html', 'DELETE', null, null, '0', null, '0', '用户权限-修订', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('554', '优惠卷组-列表', 'HTML', '/coupon/CouponList.html', 'POST', null, null, '0', null, '0', '优惠卷组-列表', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('555', '优惠卷组-新增', 'HTML', '/coupon/CouponAdd.html', 'PUT', null, null, '0', null, '0', '优惠卷组-新增', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('556', '优惠卷组-修订', 'HTML', '/coupon/CouponEdit.html', 'DELETE', null, null, '0', null, '0', '优惠卷组-修订', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('557', '优惠项目-列表', 'HTML', '/couponitem/CouponItemList.html', 'POST', null, null, '0', null, '0', '优惠项目-列表', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('558', '优惠项目-新增', 'HTML', '/couponitem/CouponItemAdd.html', 'PUT', null, null, '0', null, '0', '优惠项目-新增', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('559', '优惠项目-修订', 'HTML', '/couponitem/CouponItemEdit.html', 'DELETE', null, null, '0', null, '0', '优惠项目-修订', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('560', '结算币种-列表', 'HTML', '/exchange/ExchangeList.html', 'POST', null, null, '0', null, '0', '结算币种-列表', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('561', '结算币种-新增', 'HTML', '/exchange/ExchangeAdd.html', 'PUT', null, null, '0', null, '0', '结算币种-新增', 'admin', '2018-01-13 19:24:27', null, '2018-01-13 19:24:27');
INSERT INTO `ts_resource_info` VALUES ('562', '结算币种-修订', 'HTML', '/exchange/ExchangeEdit.html', 'DELETE', null, null, '0', null, '0', '结算币种-修订', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('563', '会员价格-列表', 'HTML', '/memberprice/MemberPriceList.html', 'POST', null, null, '0', null, '0', '会员价格-列表', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('564', '会员价格-新增', 'HTML', '/memberprice/MemberPriceAdd.html', 'PUT', null, null, '0', null, '0', '会员价格-新增', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('565', '会员价格-修订', 'HTML', '/memberprice/MemberPriceEdit.html', 'DELETE', null, null, '0', null, '0', '会员价格-修订', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('566', '消费结算-列表', 'HTML', '/settlement/SettlementList.html', 'POST', null, null, '0', null, '0', '消费结算-列表', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('567', '消费结算-新增', 'HTML', '/settlement/SettlementAdd.html', 'PUT', null, null, '0', null, '0', '消费结算-新增', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('568', '消费结算-修订', 'HTML', '/settlement/SettlementEdit.html', 'DELETE', null, null, '0', null, '0', '消费结算-修订', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('569', '消费清单-列表', 'HTML', '/trade/TradeList.html', 'POST', null, null, '0', null, '0', '消费清单-列表', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('570', '消费清单-新增', 'HTML', '/trade/TradeAdd.html', 'PUT', null, null, '0', null, '0', '消费清单-新增', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('571', '消费清单-修订', 'HTML', '/trade/TradeEdit.html', 'DELETE', null, null, '0', null, '0', '消费清单-修订', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('572', '结算优惠项-列表', 'HTML', '/tradediscount/TradeDiscountList.html', 'POST', null, null, '0', null, '0', '结算优惠项-列表', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('573', '结算优惠项-新增', 'HTML', '/tradediscount/TradeDiscountAdd.html', 'PUT', null, null, '0', null, '0', '结算优惠项-新增', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('574', '结算优惠项-修订', 'HTML', '/tradediscount/TradeDiscountEdit.html', 'DELETE', null, null, '0', null, '0', '结算优惠项-修订', 'admin', '2018-01-13 19:24:28', null, '2018-01-13 19:24:28');
INSERT INTO `ts_resource_info` VALUES ('575', '优惠券-列表', 'HTML', '/volume/VolumeList.html', 'POST', null, null, '0', null, '0', '优惠券-列表', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('576', '优惠券-新增', 'HTML', '/volume/VolumeAdd.html', 'PUT', null, null, '0', null, '0', '优惠券-新增', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('577', '优惠券-修订', 'HTML', '/volume/VolumeEdit.html', 'DELETE', null, null, '0', null, '0', '优惠券-修订', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('578', '门店考勤-列表', 'HTML', '/attendance/AttendanceList.html', 'POST', null, null, '0', null, '0', '门店考勤-列表', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('579', '门店考勤-新增', 'HTML', '/attendance/AttendanceAdd.html', 'PUT', null, null, '0', null, '0', '门店考勤-新增', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('580', '门店考勤-修订', 'HTML', '/attendance/AttendanceEdit.html', 'DELETE', null, null, '0', null, '0', '门店考勤-修订', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('581', '门店考勤详情-列表', 'HTML', '/attendancedetail/AttendanceDetailList.html', 'POST', null, null, '0', null, '0', '门店考勤详情-列表', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('582', '门店考勤详情-新增', 'HTML', '/attendancedetail/AttendanceDetailAdd.html', 'PUT', null, null, '0', null, '0', '门店考勤详情-新增', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('583', '门店考勤详情-修订', 'HTML', '/attendancedetail/AttendanceDetailEdit.html', 'DELETE', null, null, '0', null, '0', '门店考勤详情-修订', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('584', '打卡记录-列表', 'HTML', '/employeeattend/EmployeeAttendList.html', 'POST', null, null, '0', null, '0', '打卡记录-列表', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('585', '打卡记录-新增', 'HTML', '/employeeattend/EmployeeAttendAdd.html', 'PUT', null, null, '0', null, '0', '打卡记录-新增', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('586', '打卡记录-修订', 'HTML', '/employeeattend/EmployeeAttendEdit.html', 'DELETE', null, null, '0', null, '0', '打卡记录-修订', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('587', '员工考勤关系-列表', 'HTML', '/employeeattendance/EmployeeAttendanceList.html', 'POST', null, null, '0', null, '0', '员工考勤关系-列表', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('588', '员工考勤关系-新增', 'HTML', '/employeeattendance/EmployeeAttendanceAdd.html', 'PUT', null, null, '0', null, '0', '员工考勤关系-新增', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('589', '员工考勤关系-修订', 'HTML', '/employeeattendance/EmployeeAttendanceEdit.html', 'DELETE', null, null, '0', null, '0', '员工考勤关系-修订', 'admin', '2018-01-13 19:24:29', null, '2018-01-13 19:24:29');
INSERT INTO `ts_resource_info` VALUES ('590', '员工考勤日志-列表', 'HTML', '/employeejournal/EmployeeJournalList.html', 'POST', null, null, '0', null, '0', '员工考勤日志-列表', 'admin', '2018-01-13 19:24:30', null, '2018-01-13 19:24:30');
INSERT INTO `ts_resource_info` VALUES ('591', '员工考勤日志-新增', 'HTML', '/employeejournal/EmployeeJournalAdd.html', 'PUT', null, null, '0', null, '0', '员工考勤日志-新增', 'admin', '2018-01-13 19:24:30', null, '2018-01-13 19:24:30');
INSERT INTO `ts_resource_info` VALUES ('592', '员工考勤日志-修订', 'HTML', '/employeejournal/EmployeeJournalEdit.html', 'DELETE', null, null, '0', null, '0', '员工考勤日志-修订', 'admin', '2018-01-13 19:24:30', null, '2018-01-13 19:24:30');

-- ----------------------------
-- Table structure for `ts_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `ts_role_info`;
CREATE TABLE `ts_role_info` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色标识',
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `role_title` varchar(64) DEFAULT NULL COMMENT '角色标题',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级角色',
  `role_type` varchar(2) DEFAULT NULL COMMENT '角色类型',
  `is_global` int(11) DEFAULT NULL COMMENT '全局角色',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of ts_role_info
-- ----------------------------
INSERT INTO `ts_role_info` VALUES ('1', 'ROLE1', '管理员', null, '0', null, '0', 'SYSTEM', '2018-01-15 08:50:32', 'SYSTEM', '2018-01-15 08:50:36');

-- ----------------------------
-- Table structure for `ts_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `ts_role_permission`;
CREATE TABLE `ts_role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色标识',
  `resource_id` int(11) NOT NULL COMMENT '资源标识',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';

-- ----------------------------
-- Records of ts_role_permission
-- ----------------------------
INSERT INTO `ts_role_permission` VALUES ('1', '335', 'admin', '2018-01-15 08:52:35', 'admin', '2018-01-15 08:52:38');

-- ----------------------------
-- Table structure for `ts_user`
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `user_name` varchar(64) NOT NULL COMMENT '用户姓名',
  `team_id` int(11) DEFAULT NULL COMMENT '用户组',
  `nick_name` varchar(64) NOT NULL COMMENT '呢称',
  `mobile` varchar(16) NOT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮件地址',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `repassword_date` date DEFAULT NULL COMMENT '下次修改密码时间',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of ts_user
-- ----------------------------
INSERT INTO `ts_user` VALUES ('1', 'admin', null, '管理员', '15112349876', 'admin@163.com', 'admin', '2018-01-31', '0', 'admin', '2018-01-12 10:32:56', 'admin', '2018-01-12 10:32:56');

-- ----------------------------
-- Table structure for `ts_user_group`
-- ----------------------------
DROP TABLE IF EXISTS `ts_user_group`;
CREATE TABLE `ts_user_group` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户组标识',
  `team_name` varchar(128) NOT NULL COMMENT '用户组名称',
  `parent_team` int(11) DEFAULT NULL COMMENT '父级组标识',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组';

-- ----------------------------
-- Records of ts_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for `ts_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `ts_user_role`;
CREATE TABLE `ts_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户标识',
  `role_id` int(11) NOT NULL COMMENT '角色标识',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限';

-- ----------------------------
-- Records of ts_user_role
-- ----------------------------
INSERT INTO `ts_user_role` VALUES ('1', '1', null, '2018-01-15 08:50:56', null, '2018-01-15 08:50:56');

-- ----------------------------
-- Table structure for `tt_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `tt_coupon`;
CREATE TABLE `tt_coupon` (
  `coupon_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '优惠券标识',
  `coupon_name` varchar(64) NOT NULL COMMENT '优惠券名称',
  `types` int(11) NOT NULL COMMENT '类型 0卷 1减 2送',
  `total_count` int(11) DEFAULT NULL COMMENT '总量',
  `allowance` int(11) DEFAULT NULL COMMENT '余量',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '价值',
  `from_time` datetime NOT NULL COMMENT '生效日期',
  `to_time` datetime NOT NULL COMMENT '失效日期',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '当前状态 0正常',
  `is_stack` int(11) NOT NULL DEFAULT '0' COMMENT '叠加使用 0是',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠卷组';

-- ----------------------------
-- Records of tt_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_coupon_item`
-- ----------------------------
DROP TABLE IF EXISTS `tt_coupon_item`;
CREATE TABLE `tt_coupon_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `coupon_id` int(11) NOT NULL COMMENT '归属券组',
  `object_type` int(11) NOT NULL COMMENT '商品服务类型',
  `object_id` varchar(32) NOT NULL COMMENT '商品服务标识',
  `status` int(11) NOT NULL COMMENT '状态',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠项目';

-- ----------------------------
-- Records of tt_coupon_item
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_exchange`
-- ----------------------------
DROP TABLE IF EXISTS `tt_exchange`;
CREATE TABLE `tt_exchange` (
  `exchange_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '汇率标识',
  `exchange_name` varchar(32) NOT NULL COMMENT '汇率币种',
  `exchange_rate` decimal(10,2) NOT NULL COMMENT '汇率',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`exchange_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算币种';

-- ----------------------------
-- Records of tt_exchange
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_member_price`
-- ----------------------------
DROP TABLE IF EXISTS `tt_member_price`;
CREATE TABLE `tt_member_price` (
  `price_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `level_id` int(11) NOT NULL COMMENT '会员等级标识',
  `object_type` int(11) NOT NULL COMMENT '估价类型1商品服务2套餐',
  `object_id` varchar(32) NOT NULL COMMENT '对象标识',
  `price` decimal(10,2) NOT NULL COMMENT '会员价格',
  `discount` decimal(10,2) NOT NULL COMMENT '优惠金额',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员价格';

-- ----------------------------
-- Records of tt_member_price
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_settlement`
-- ----------------------------
DROP TABLE IF EXISTS `tt_settlement`;
CREATE TABLE `tt_settlement` (
  `settlement_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '结算标识',
  `serial_number` varchar(16) NOT NULL COMMENT '流水号',
  `settlement_time` date NOT NULL COMMENT '结算时间',
  `marked_price` decimal(10,2) NOT NULL COMMENT '原价',
  `discount_price` decimal(10,2) DEFAULT NULL COMMENT '优惠总计',
  `reduction_price` decimal(10,2) DEFAULT NULL COMMENT '折扣',
  `deal_price` decimal(10,2) NOT NULL COMMENT '成交价',
  `exchange_id` int(11) NOT NULL COMMENT '支付方式 0本币',
  `pay_price` decimal(10,2) NOT NULL COMMENT '支付数量',
  `emp_id` varchar(32) DEFAULT NULL COMMENT '折扣授权员工',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`settlement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费结算';

-- ----------------------------
-- Records of tt_settlement
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_trade`
-- ----------------------------
DROP TABLE IF EXISTS `tt_trade`;
CREATE TABLE `tt_trade` (
  `trade_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易标识',
  `serial_number` varchar(16) NOT NULL COMMENT '流水号',
  `customer_id` int(11) NOT NULL COMMENT '客户标识',
  `customer_ct` int(11) NOT NULL COMMENT '客人数',
  `authorization_id` varchar(32) DEFAULT NULL COMMENT '授权码标识',
  `object_type` int(11) NOT NULL COMMENT '商品服务类型',
  `object_id` varchar(32) NOT NULL COMMENT '商品服务标识',
  `object_ct` int(11) NOT NULL COMMENT '交易数量',
  `status` int(11) NOT NULL COMMENT '清单状态 0正常',
  `note` varchar(128) DEFAULT NULL COMMENT '交易说明',
  `marked_price` decimal(10,2) NOT NULL COMMENT '原价',
  `discount_price` decimal(10,2) DEFAULT NULL COMMENT '优惠金额',
  `deal_price` decimal(10,2) NOT NULL COMMENT '成交价',
  `coupon_id` int(11) DEFAULT NULL COMMENT '活动标识',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`trade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费清单';

-- ----------------------------
-- Records of tt_trade
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_trade_discount`
-- ----------------------------
DROP TABLE IF EXISTS `tt_trade_discount`;
CREATE TABLE `tt_trade_discount` (
  `discount_id` int(11) NOT NULL COMMENT '自增标识',
  `serial_number` varchar(16) NOT NULL COMMENT '流水号',
  `coupon_id` int(11) NOT NULL COMMENT '优惠卷组',
  `volume_id` int(11) NOT NULL COMMENT '卡券标识',
  `discount_price` decimal(10,2) NOT NULL COMMENT '折扣金额',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`discount_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算优惠项';

-- ----------------------------
-- Records of tt_trade_discount
-- ----------------------------

-- ----------------------------
-- Table structure for `tt_volume`
-- ----------------------------
DROP TABLE IF EXISTS `tt_volume`;
CREATE TABLE `tt_volume` (
  `volume_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '卷号',
  `volume_code` varchar(16) NOT NULL COMMENT '卷编号',
  `coupon_id` int(11) NOT NULL COMMENT '券组标识',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态 0正常 1使用',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`volume_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券';

-- ----------------------------
-- Records of tt_volume
-- ----------------------------

-- ----------------------------
-- Table structure for `tw_attendance`
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance`;
CREATE TABLE `tw_attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考勤方案标识',
  `store_id` varchar(32) DEFAULT NULL COMMENT '门店标识',
  `attendance_name` varchar(64) NOT NULL COMMENT '考勤方案名称',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '考勤方案状态 0正常',
  `types` int(11) NOT NULL COMMENT '考勤方案方案  0休天数1考勤天数2详情 ',
  `attendance` int(11) DEFAULT NULL COMMENT '休息天数 类型0、1时有效 ',
  `sign_ct` int(4) NOT NULL DEFAULT '180' COMMENT '上班打卡范围',
  `out_ct` int(4) NOT NULL DEFAULT '300' COMMENT '下班打卡范围',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`attendance_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='门店考勤';

-- ----------------------------
-- Records of tw_attendance
-- ----------------------------
INSERT INTO `tw_attendance` VALUES ('1', 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '全局考勤规则', '0', '2', '0', '180', '300', null, '2018-02-06 21:44:41', null, '2018-02-06 21:44:41');
INSERT INTO `tw_attendance` VALUES ('8', 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '收银', '0', '2', '0', '180', '300', null, '2018-02-05 14:20:13', null, '2018-02-05 14:20:13');
INSERT INTO `tw_attendance` VALUES ('9', 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '技师', '0', '2', '0', '180', '300', null, '2018-02-05 14:29:37', null, '2018-02-05 14:36:00');
INSERT INTO `tw_attendance` VALUES ('11', 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '技师', '0', '2', '0', '180', '300', null, '2018-02-05 14:39:12', null, '2018-02-05 14:39:12');

-- ----------------------------
-- Table structure for `tw_attendance_detail`
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance_detail`;
CREATE TABLE `tw_attendance_detail` (
  `att_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '门店标识',
  `attendance_id` int(11) NOT NULL COMMENT '考勤标识',
  `weekday` int(2) NOT NULL COMMENT '星期',
  `att_date` date NOT NULL COMMENT '考勤日期',
  `att_month` varchar(10) NOT NULL COMMENT '归属月份',
  `att_day` int(2) NOT NULL COMMENT '日-月',
  `attendance` int(1) NOT NULL DEFAULT '0' COMMENT '是否考勤 0考勤',
  `time_id` int(11) DEFAULT NULL COMMENT '时段标识',
  `sign_time` datetime DEFAULT NULL COMMENT '应到时间',
  `out_time` datetime DEFAULT NULL COMMENT '应退时间',
  `editable` int(2) NOT NULL DEFAULT '0' COMMENT '0是1否',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`att_id`)
) ENGINE=InnoDB AUTO_INCREMENT=399 DEFAULT CHARSET=utf8 COMMENT='门店考勤详情';

-- ----------------------------
-- Records of tw_attendance_detail
-- ----------------------------
INSERT INTO `tw_attendance_detail` VALUES ('256', '8', '4', '2018-02-01', '2018-02', '1', '0', '1', '2018-02-01 21:30:00', '2018-02-02 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('257', '8', '5', '2018-02-02', '2018-02', '2', '0', '1', '2018-02-02 21:30:00', '2018-02-03 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('258', '8', '6', '2018-02-03', '2018-02', '3', '1', '1', '2018-02-03 21:30:00', '2018-02-04 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('259', '8', '7', '2018-02-04', '2018-02', '4', '1', '1', '2018-02-04 21:30:00', '2018-02-05 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('260', '8', '1', '2018-02-05', '2018-02', '5', '0', '1', '2018-02-05 21:30:00', '2018-02-06 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('261', '8', '2', '2018-02-06', '2018-02', '6', '0', '1', '2018-02-06 21:30:00', '2018-02-07 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('262', '8', '3', '2018-02-07', '2018-02', '7', '0', '1', '2018-02-07 21:30:00', '2018-02-08 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('263', '8', '4', '2018-02-08', '2018-02', '8', '0', '1', '2018-02-08 21:30:00', '2018-02-09 07:30:00', '1', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('264', '8', '5', '2018-02-09', '2018-02', '9', '0', '1', '2018-02-09 21:30:00', '2018-02-10 07:30:00', '0', null, '2018-02-05 21:41:16', null, '2018-02-05 21:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('265', '8', '6', '2018-02-10', '2018-02', '10', '1', '1', '2018-02-10 21:30:00', '2018-02-11 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('266', '8', '7', '2018-02-11', '2018-02', '11', '1', '1', '2018-02-11 21:30:00', '2018-02-12 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('267', '8', '1', '2018-02-12', '2018-02', '12', '0', '1', '2018-02-12 21:30:00', '2018-02-13 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('268', '8', '2', '2018-02-13', '2018-02', '13', '0', '1', '2018-02-13 21:30:00', '2018-02-14 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('269', '8', '3', '2018-02-14', '2018-02', '14', '0', '1', '2018-02-14 21:30:00', '2018-02-15 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('270', '8', '4', '2018-02-15', '2018-02', '15', '0', '1', '2018-02-15 21:30:00', '2018-02-16 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('271', '8', '5', '2018-02-16', '2018-02', '16', '0', '1', '2018-02-16 21:30:00', '2018-02-17 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('272', '8', '6', '2018-02-17', '2018-02', '17', '1', '1', '2018-02-17 21:30:00', '2018-02-18 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('273', '8', '7', '2018-02-18', '2018-02', '18', '1', '1', '2018-02-18 21:30:00', '2018-02-19 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('274', '8', '1', '2018-02-19', '2018-02', '19', '0', '1', '2018-02-19 21:30:00', '2018-02-20 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('275', '8', '2', '2018-02-20', '2018-02', '20', '0', '1', '2018-02-20 21:30:00', '2018-02-21 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('276', '8', '3', '2018-02-21', '2018-02', '21', '0', '1', '2018-02-21 21:30:00', '2018-02-22 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('277', '8', '4', '2018-02-22', '2018-02', '22', '0', '1', '2018-02-22 21:30:00', '2018-02-23 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('278', '8', '5', '2018-02-23', '2018-02', '23', '0', '1', '2018-02-23 21:30:00', '2018-02-24 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('279', '8', '6', '2018-02-24', '2018-02', '24', '1', '1', '2018-02-24 21:30:00', '2018-02-25 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('280', '8', '7', '2018-02-25', '2018-02', '25', '1', '1', '2018-02-25 21:30:00', '2018-02-26 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('281', '8', '1', '2018-02-26', '2018-02', '26', '0', '1', '2018-02-26 21:30:00', '2018-02-27 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('282', '8', '2', '2018-02-27', '2018-02', '27', '0', '1', '2018-02-27 21:30:00', '2018-02-28 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('283', '8', '3', '2018-02-28', '2018-02', '28', '0', '1', '2018-02-28 21:30:00', '2018-03-01 07:30:00', '0', null, '2018-02-05 21:41:17', null, '2018-02-05 21:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('284', '8', '4', '2018-03-01', '2018-03', '1', '0', '1', '2018-03-01 21:30:00', '2018-03-02 07:30:00', '0', null, '2018-02-05 21:44:24', null, '2018-02-05 21:44:24');
INSERT INTO `tw_attendance_detail` VALUES ('285', '8', '5', '2018-03-02', '2018-03', '2', '0', '1', '2018-03-02 21:30:00', '2018-03-03 07:30:00', '0', null, '2018-02-05 21:44:24', null, '2018-02-05 21:44:24');
INSERT INTO `tw_attendance_detail` VALUES ('286', '8', '6', '2018-03-03', '2018-03', '3', '1', '1', '2018-03-03 21:30:00', '2018-03-04 07:30:00', '0', null, '2018-02-05 21:44:24', null, '2018-02-05 21:44:24');
INSERT INTO `tw_attendance_detail` VALUES ('287', '8', '7', '2018-03-04', '2018-03', '4', '1', '1', '2018-03-04 21:30:00', '2018-03-05 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('288', '8', '1', '2018-03-05', '2018-03', '5', '0', '1', '2018-03-05 21:30:00', '2018-03-06 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('289', '8', '2', '2018-03-06', '2018-03', '6', '0', '1', '2018-03-06 21:30:00', '2018-03-07 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('290', '8', '3', '2018-03-07', '2018-03', '7', '0', '1', '2018-03-07 21:30:00', '2018-03-08 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('291', '8', '4', '2018-03-08', '2018-03', '8', '0', '1', '2018-03-08 21:30:00', '2018-03-09 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('292', '8', '5', '2018-03-09', '2018-03', '9', '0', '1', '2018-03-09 21:30:00', '2018-03-10 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('293', '8', '6', '2018-03-10', '2018-03', '10', '1', '1', '2018-03-10 21:30:00', '2018-03-11 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('294', '8', '7', '2018-03-11', '2018-03', '11', '1', '1', '2018-03-11 21:30:00', '2018-03-12 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('295', '8', '1', '2018-03-12', '2018-03', '12', '0', '1', '2018-03-12 21:30:00', '2018-03-13 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('296', '8', '2', '2018-03-13', '2018-03', '13', '0', '1', '2018-03-13 21:30:00', '2018-03-14 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('297', '8', '3', '2018-03-14', '2018-03', '14', '0', '1', '2018-03-14 21:30:00', '2018-03-15 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('298', '8', '4', '2018-03-15', '2018-03', '15', '0', '1', '2018-03-15 21:30:00', '2018-03-16 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('299', '8', '5', '2018-03-16', '2018-03', '16', '0', '1', '2018-03-16 21:30:00', '2018-03-17 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('300', '8', '6', '2018-03-17', '2018-03', '17', '1', '1', '2018-03-17 21:30:00', '2018-03-18 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('301', '8', '7', '2018-03-18', '2018-03', '18', '1', '1', '2018-03-18 21:30:00', '2018-03-19 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('302', '8', '1', '2018-03-19', '2018-03', '19', '0', '1', '2018-03-19 21:30:00', '2018-03-20 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('303', '8', '2', '2018-03-20', '2018-03', '20', '0', '1', '2018-03-20 21:30:00', '2018-03-21 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('304', '8', '3', '2018-03-21', '2018-03', '21', '0', '1', '2018-03-21 21:30:00', '2018-03-22 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('305', '8', '4', '2018-03-22', '2018-03', '22', '0', '1', '2018-03-22 21:30:00', '2018-03-23 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('306', '8', '5', '2018-03-23', '2018-03', '23', '0', '1', '2018-03-23 21:30:00', '2018-03-24 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('307', '8', '6', '2018-03-24', '2018-03', '24', '1', '1', '2018-03-24 21:30:00', '2018-03-25 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('308', '8', '7', '2018-03-25', '2018-03', '25', '1', '1', '2018-03-25 21:30:00', '2018-03-26 07:30:00', '0', null, '2018-02-05 21:44:25', null, '2018-02-05 21:44:25');
INSERT INTO `tw_attendance_detail` VALUES ('309', '8', '1', '2018-03-26', '2018-03', '26', '0', '1', '2018-03-26 21:30:00', '2018-03-27 07:30:00', '0', null, '2018-02-05 21:44:26', null, '2018-02-05 21:44:26');
INSERT INTO `tw_attendance_detail` VALUES ('310', '8', '2', '2018-03-27', '2018-03', '27', '0', '1', '2018-03-27 21:30:00', '2018-03-28 07:30:00', '0', null, '2018-02-05 21:44:26', null, '2018-02-05 21:44:26');
INSERT INTO `tw_attendance_detail` VALUES ('311', '8', '3', '2018-03-28', '2018-03', '28', '0', '1', '2018-03-28 21:30:00', '2018-03-29 07:30:00', '0', null, '2018-02-05 21:44:26', null, '2018-02-05 21:44:26');
INSERT INTO `tw_attendance_detail` VALUES ('312', '8', '4', '2018-03-29', '2018-03', '29', '0', '1', '2018-03-29 21:30:00', '2018-03-30 07:30:00', '0', null, '2018-02-05 21:44:26', null, '2018-02-05 21:44:26');
INSERT INTO `tw_attendance_detail` VALUES ('313', '8', '5', '2018-03-30', '2018-03', '30', '0', '1', '2018-03-30 21:30:00', '2018-03-31 07:30:00', '0', null, '2018-02-05 21:44:26', null, '2018-02-05 21:44:26');
INSERT INTO `tw_attendance_detail` VALUES ('314', '8', '6', '2018-03-31', '2018-03', '31', '1', '1', '2018-03-31 21:30:00', '2018-04-01 07:30:00', '0', null, '2018-02-05 21:44:26', null, '2018-02-05 21:44:26');
INSERT INTO `tw_attendance_detail` VALUES ('315', '9', '4', '2018-02-01', '2018-02', '1', '0', '12', '2018-02-01 20:30:00', '2018-02-02 08:00:00', '0', null, '2018-02-06 21:08:15', null, '2018-02-06 21:08:15');
INSERT INTO `tw_attendance_detail` VALUES ('316', '9', '5', '2018-02-02', '2018-02', '2', '0', '12', '2018-02-02 20:30:00', '2018-02-03 08:00:00', '0', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('317', '9', '6', '2018-02-03', '2018-02', '3', '1', '12', '2018-02-03 20:30:00', '2018-02-04 08:00:00', '0', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('318', '9', '7', '2018-02-04', '2018-02', '4', '1', '12', '2018-02-04 20:30:00', '2018-02-05 08:00:00', '0', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('319', '9', '1', '2018-02-05', '2018-02', '5', '0', '12', '2018-02-05 20:30:00', '2018-02-06 08:00:00', '0', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('320', '9', '2', '2018-02-06', '2018-02', '6', '0', '12', '2018-02-06 20:30:00', '2018-02-07 08:00:00', '1', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('321', '9', '3', '2018-02-07', '2018-02', '7', '0', '12', '2018-02-07 20:30:00', '2018-02-08 08:00:00', '1', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('322', '9', '4', '2018-02-08', '2018-02', '8', '0', '12', '2018-02-08 20:30:00', '2018-02-09 08:00:00', '1', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('323', '9', '5', '2018-02-09', '2018-02', '9', '0', '12', '2018-02-09 20:30:00', '2018-02-10 08:00:00', '0', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('324', '9', '6', '2018-02-10', '2018-02', '10', '1', '12', '2018-02-10 20:30:00', '2018-02-11 08:00:00', '0', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('325', '9', '7', '2018-02-11', '2018-02', '11', '1', '12', '2018-02-11 20:30:00', '2018-02-12 08:00:00', '0', null, '2018-02-06 21:08:16', null, '2018-02-06 21:08:16');
INSERT INTO `tw_attendance_detail` VALUES ('326', '9', '1', '2018-02-12', '2018-02', '12', '0', '12', '2018-02-12 20:30:00', '2018-02-13 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('327', '9', '2', '2018-02-13', '2018-02', '13', '0', '12', '2018-02-13 20:30:00', '2018-02-14 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('328', '9', '3', '2018-02-14', '2018-02', '14', '0', '12', '2018-02-14 20:30:00', '2018-02-15 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('329', '9', '4', '2018-02-15', '2018-02', '15', '0', '12', '2018-02-15 20:30:00', '2018-02-16 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('330', '9', '5', '2018-02-16', '2018-02', '16', '0', '12', '2018-02-16 20:30:00', '2018-02-17 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('331', '9', '6', '2018-02-17', '2018-02', '17', '1', '12', '2018-02-17 20:30:00', '2018-02-18 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('332', '9', '7', '2018-02-18', '2018-02', '18', '1', '12', '2018-02-18 20:30:00', '2018-02-19 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('333', '9', '1', '2018-02-19', '2018-02', '19', '0', '12', '2018-02-19 20:30:00', '2018-02-20 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('334', '9', '2', '2018-02-20', '2018-02', '20', '0', '12', '2018-02-20 20:30:00', '2018-02-21 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('335', '9', '3', '2018-02-21', '2018-02', '21', '0', '12', '2018-02-21 20:30:00', '2018-02-22 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('336', '9', '4', '2018-02-22', '2018-02', '22', '0', '12', '2018-02-22 20:30:00', '2018-02-23 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('337', '9', '5', '2018-02-23', '2018-02', '23', '0', '12', '2018-02-23 20:30:00', '2018-02-24 08:00:00', '0', null, '2018-02-06 21:08:17', null, '2018-02-06 21:08:17');
INSERT INTO `tw_attendance_detail` VALUES ('338', '9', '6', '2018-02-24', '2018-02', '24', '1', '12', '2018-02-24 20:30:00', '2018-02-25 08:00:00', '0', null, '2018-02-06 21:08:18', null, '2018-02-06 21:08:18');
INSERT INTO `tw_attendance_detail` VALUES ('339', '9', '7', '2018-02-25', '2018-02', '25', '1', '12', '2018-02-25 20:30:00', '2018-02-26 08:00:00', '0', null, '2018-02-06 21:08:18', null, '2018-02-06 21:08:18');
INSERT INTO `tw_attendance_detail` VALUES ('340', '9', '1', '2018-02-26', '2018-02', '26', '0', '12', '2018-02-26 20:30:00', '2018-02-27 08:00:00', '0', null, '2018-02-06 21:08:20', null, '2018-02-06 21:08:20');
INSERT INTO `tw_attendance_detail` VALUES ('341', '9', '2', '2018-02-27', '2018-02', '27', '0', '12', '2018-02-27 20:30:00', '2018-02-28 08:00:00', '0', null, '2018-02-06 21:08:20', null, '2018-02-06 21:08:20');
INSERT INTO `tw_attendance_detail` VALUES ('342', '9', '3', '2018-02-28', '2018-02', '28', '0', '12', '2018-02-28 20:30:00', '2018-03-01 08:00:00', '0', null, '2018-02-06 21:08:21', null, '2018-02-06 21:08:21');
INSERT INTO `tw_attendance_detail` VALUES ('343', '1', '4', '2018-02-01', '2018-02', '1', '0', '1', '2018-02-01 08:00:00', '2018-02-01 18:00:00', '0', null, '2018-02-06 22:02:34', null, '2018-02-06 22:02:34');
INSERT INTO `tw_attendance_detail` VALUES ('344', '1', '5', '2018-02-02', '2018-02', '2', '0', '1', '2018-02-02 08:00:00', '2018-02-02 18:00:00', '0', null, '2018-02-06 22:02:34', null, '2018-02-06 22:02:34');
INSERT INTO `tw_attendance_detail` VALUES ('345', '1', '6', '2018-02-03', '2018-02', '3', '1', '1', '2018-02-03 08:00:00', '2018-02-03 18:00:00', '0', null, '2018-02-06 22:02:34', null, '2018-02-06 22:02:34');
INSERT INTO `tw_attendance_detail` VALUES ('346', '1', '7', '2018-02-04', '2018-02', '4', '1', '1', '2018-02-04 08:00:00', '2018-02-04 18:00:00', '0', null, '2018-02-06 22:02:34', null, '2018-02-06 22:02:34');
INSERT INTO `tw_attendance_detail` VALUES ('347', '1', '1', '2018-02-05', '2018-02', '5', '0', '1', '2018-02-05 08:00:00', '2018-02-05 18:00:00', '0', null, '2018-02-06 22:02:34', null, '2018-02-06 22:02:34');
INSERT INTO `tw_attendance_detail` VALUES ('348', '1', '2', '2018-02-06', '2018-02', '6', '0', '1', '2018-02-06 08:00:00', '2018-02-06 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('349', '1', '3', '2018-02-07', '2018-02', '7', '0', '1', '2018-02-07 08:00:00', '2018-02-07 18:00:00', '1', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('350', '1', '4', '2018-02-08', '2018-02', '8', '0', '1', '2018-02-08 08:00:00', '2018-02-08 18:00:00', '1', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('351', '1', '5', '2018-02-09', '2018-02', '9', '0', '1', '2018-02-09 08:00:00', '2018-02-09 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('352', '1', '6', '2018-02-10', '2018-02', '10', '1', '1', '2018-02-10 08:00:00', '2018-02-10 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('353', '1', '7', '2018-02-11', '2018-02', '11', '1', '1', '2018-02-11 08:00:00', '2018-02-11 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('354', '1', '1', '2018-02-12', '2018-02', '12', '0', '1', '2018-02-12 08:00:00', '2018-02-12 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('355', '1', '2', '2018-02-13', '2018-02', '13', '0', '1', '2018-02-13 08:00:00', '2018-02-13 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('356', '1', '3', '2018-02-14', '2018-02', '14', '0', '1', '2018-02-14 08:00:00', '2018-02-14 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('357', '1', '4', '2018-02-15', '2018-02', '15', '0', '1', '2018-02-15 08:00:00', '2018-02-15 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('358', '1', '5', '2018-02-16', '2018-02', '16', '0', '1', '2018-02-16 08:00:00', '2018-02-16 18:00:00', '0', null, '2018-02-06 22:02:35', null, '2018-02-06 22:02:35');
INSERT INTO `tw_attendance_detail` VALUES ('359', '1', '6', '2018-02-17', '2018-02', '17', '1', '1', '2018-02-17 08:00:00', '2018-02-17 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('360', '1', '7', '2018-02-18', '2018-02', '18', '1', '1', '2018-02-18 08:00:00', '2018-02-18 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('361', '1', '1', '2018-02-19', '2018-02', '19', '0', '1', '2018-02-19 08:00:00', '2018-02-19 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('362', '1', '2', '2018-02-20', '2018-02', '20', '0', '1', '2018-02-20 08:00:00', '2018-02-20 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('363', '1', '3', '2018-02-21', '2018-02', '21', '0', '1', '2018-02-21 08:00:00', '2018-02-21 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('364', '1', '4', '2018-02-22', '2018-02', '22', '0', '1', '2018-02-22 08:00:00', '2018-02-22 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('365', '1', '5', '2018-02-23', '2018-02', '23', '0', '1', '2018-02-23 08:00:00', '2018-02-23 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('366', '1', '6', '2018-02-24', '2018-02', '24', '1', '1', '2018-02-24 08:00:00', '2018-02-24 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('367', '1', '7', '2018-02-25', '2018-02', '25', '1', '1', '2018-02-25 08:00:00', '2018-02-25 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('368', '1', '1', '2018-02-26', '2018-02', '26', '0', '1', '2018-02-26 08:00:00', '2018-02-26 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('369', '1', '2', '2018-02-27', '2018-02', '27', '0', '1', '2018-02-27 08:00:00', '2018-02-27 18:00:00', '0', null, '2018-02-06 22:02:36', null, '2018-02-06 22:02:36');
INSERT INTO `tw_attendance_detail` VALUES ('370', '1', '3', '2018-02-28', '2018-02', '28', '0', '1', '2018-02-28 08:00:00', '2018-02-28 18:00:00', '0', null, '2018-02-06 22:02:37', null, '2018-02-06 22:02:37');
INSERT INTO `tw_attendance_detail` VALUES ('371', '11', '4', '2018-02-01', '2018-02', '1', '0', '18', '2018-02-01 20:30:00', '2018-02-02 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('372', '11', '5', '2018-02-02', '2018-02', '2', '0', '18', '2018-02-02 20:30:00', '2018-02-03 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('373', '11', '6', '2018-02-03', '2018-02', '3', '1', '18', '2018-02-03 20:30:00', '2018-02-04 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('374', '11', '7', '2018-02-04', '2018-02', '4', '1', '18', '2018-02-04 20:30:00', '2018-02-05 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('375', '11', '1', '2018-02-05', '2018-02', '5', '0', '18', '2018-02-05 20:30:00', '2018-02-06 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('376', '11', '2', '2018-02-06', '2018-02', '6', '0', '18', '2018-02-06 20:30:00', '2018-02-07 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('377', '11', '3', '2018-02-07', '2018-02', '7', '0', '18', '2018-02-07 20:30:00', '2018-02-08 08:30:00', '1', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('378', '11', '4', '2018-02-08', '2018-02', '8', '0', '18', '2018-02-08 20:30:00', '2018-02-09 08:30:00', '1', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('379', '11', '5', '2018-02-09', '2018-02', '9', '0', '18', '2018-02-09 20:30:00', '2018-02-10 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('380', '11', '6', '2018-02-10', '2018-02', '10', '1', '18', '2018-02-10 20:30:00', '2018-02-11 08:30:00', '0', null, '2018-02-07 00:07:00', null, '2018-02-07 00:07:00');
INSERT INTO `tw_attendance_detail` VALUES ('381', '11', '7', '2018-02-11', '2018-02', '11', '1', '18', '2018-02-11 20:30:00', '2018-02-12 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('382', '11', '1', '2018-02-12', '2018-02', '12', '0', '18', '2018-02-12 20:30:00', '2018-02-13 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('383', '11', '2', '2018-02-13', '2018-02', '13', '0', '18', '2018-02-13 20:30:00', '2018-02-14 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('384', '11', '3', '2018-02-14', '2018-02', '14', '0', '18', '2018-02-14 20:30:00', '2018-02-15 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('385', '11', '4', '2018-02-15', '2018-02', '15', '0', '18', '2018-02-15 20:30:00', '2018-02-16 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('386', '11', '5', '2018-02-16', '2018-02', '16', '0', '18', '2018-02-16 20:30:00', '2018-02-17 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('387', '11', '6', '2018-02-17', '2018-02', '17', '1', '18', '2018-02-17 20:30:00', '2018-02-18 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('388', '11', '7', '2018-02-18', '2018-02', '18', '1', '18', '2018-02-18 20:30:00', '2018-02-19 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('389', '11', '1', '2018-02-19', '2018-02', '19', '0', '18', '2018-02-19 20:30:00', '2018-02-20 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('390', '11', '2', '2018-02-20', '2018-02', '20', '0', '18', '2018-02-20 20:30:00', '2018-02-21 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('391', '11', '3', '2018-02-21', '2018-02', '21', '0', '18', '2018-02-21 20:30:00', '2018-02-22 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('392', '11', '4', '2018-02-22', '2018-02', '22', '0', '18', '2018-02-22 20:30:00', '2018-02-23 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('393', '11', '5', '2018-02-23', '2018-02', '23', '0', '18', '2018-02-23 20:30:00', '2018-02-24 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('394', '11', '6', '2018-02-24', '2018-02', '24', '1', '18', '2018-02-24 20:30:00', '2018-02-25 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('395', '11', '7', '2018-02-25', '2018-02', '25', '1', '18', '2018-02-25 20:30:00', '2018-02-26 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('396', '11', '1', '2018-02-26', '2018-02', '26', '0', '18', '2018-02-26 20:30:00', '2018-02-27 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('397', '11', '2', '2018-02-27', '2018-02', '27', '0', '18', '2018-02-27 20:30:00', '2018-02-28 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_detail` VALUES ('398', '11', '3', '2018-02-28', '2018-02', '28', '0', '18', '2018-02-28 20:30:00', '2018-03-01 08:30:00', '0', null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');

-- ----------------------------
-- Table structure for `tw_attendance_diary`
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance_diary`;
CREATE TABLE `tw_attendance_diary` (
  `att_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `employee_id` varchar(32) NOT NULL COMMENT '员工号',
  `attendance` int(2) NOT NULL DEFAULT '0' COMMENT '要求考勤 0是1否',
  `att_time` date NOT NULL COMMENT '考勤日期',
  `sys_sign` datetime NOT NULL COMMENT '应到时间',
  `sign_time` datetime DEFAULT NULL COMMENT '实签时间',
  `sys_out` datetime NOT NULL COMMENT '应退时间',
  `out_time` datetime DEFAULT NULL COMMENT '实退时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`att_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COMMENT='打卡记录';

-- ----------------------------
-- Records of tw_attendance_diary
-- ----------------------------
INSERT INTO `tw_attendance_diary` VALUES ('1', '12306F2882EF4D3ABE2C0881A2C8D893', '0', '2018-02-06', '2018-02-06 20:30:00', null, '2018-02-07 08:00:00', null, null, '2018-02-06 21:16:10', null, '2018-02-06 21:16:10');
INSERT INTO `tw_attendance_diary` VALUES ('2', '4A21485019174112889F6ABB8FA12EED', '0', '2018-02-06', '2018-02-06 21:30:00', null, '2018-02-07 07:30:00', null, null, '2018-02-06 21:16:10', null, '2018-02-06 21:16:10');
INSERT INTO `tw_attendance_diary` VALUES ('3', '799AAE3B73CD45AEB641D95765A0205A', '0', '2018-02-06', '2018-02-06 20:30:00', null, '2018-02-07 08:00:00', null, null, '2018-02-06 21:16:10', null, '2018-02-06 21:16:10');
INSERT INTO `tw_attendance_diary` VALUES ('4', 'BF81C5AE66F54DB0AEFC232E37E46E59', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('5', 'AED330EB655F40C3B2B7DD6D2A33DF18', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('6', 'E6017959302849FE9CB0629B89B77475', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('7', '552309B47EA24279B7E761E6E8E387A6', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('8', 'CD2A52BC83C349D0978EC288809FCE6F', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('9', 'AED999017B5446FB88F6F00225FF7991', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('10', '69F6EC898EC345C7B73E3D7222641D53', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('11', 'DEE1233D3C2E437CAE9E625B541A91A8', '0', '2018-02-06', '2018-02-06 08:00:00', null, '2018-02-06 18:00:00', null, null, '2018-02-06 22:03:12', null, '2018-02-06 22:03:12');
INSERT INTO `tw_attendance_diary` VALUES ('12', '12306F2882EF4D3ABE2C0881A2C8D893', '0', '2018-02-07', '2018-02-07 20:30:00', null, '2018-02-08 08:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_diary` VALUES ('13', '4A21485019174112889F6ABB8FA12EED', '0', '2018-02-07', '2018-02-07 21:30:00', '2018-02-08 00:50:01', '2018-02-08 07:30:00', null, null, '2018-02-07 00:07:01', null, '2018-02-08 00:50:01');
INSERT INTO `tw_attendance_diary` VALUES ('14', '799AAE3B73CD45AEB641D95765A0205A', '0', '2018-02-07', '2018-02-07 20:30:00', null, '2018-02-08 08:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_diary` VALUES ('15', 'CD2A52BC83C349D0978EC288809FCE6F', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_diary` VALUES ('16', 'AED999017B5446FB88F6F00225FF7991', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_diary` VALUES ('17', '69F6EC898EC345C7B73E3D7222641D53', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_diary` VALUES ('18', 'DEE1233D3C2E437CAE9E625B541A91A8', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', '2018-02-08 00:51:26', null, '2018-02-07 00:07:01', null, '2018-02-08 00:51:26');
INSERT INTO `tw_attendance_diary` VALUES ('19', 'BF81C5AE66F54DB0AEFC232E37E46E59', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_diary` VALUES ('20', 'AED330EB655F40C3B2B7DD6D2A33DF18', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-07 00:07:01');
INSERT INTO `tw_attendance_diary` VALUES ('21', 'E6017959302849FE9CB0629B89B77475', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', null, null, '2018-02-07 00:07:01', null, '2018-02-08 00:43:05');
INSERT INTO `tw_attendance_diary` VALUES ('22', '552309B47EA24279B7E761E6E8E387A6', '0', '2018-02-07', '2018-02-07 08:00:00', null, '2018-02-07 18:00:00', '2018-02-08 00:51:11', null, '2018-02-07 00:07:01', null, '2018-02-08 00:51:11');
INSERT INTO `tw_attendance_diary` VALUES ('31', '12306F2882EF4D3ABE2C0881A2C8D893', '0', '2018-02-08', '2018-02-08 20:30:00', null, '2018-02-09 08:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('32', '4A21485019174112889F6ABB8FA12EED', '0', '2018-02-08', '2018-02-08 21:30:00', null, '2018-02-09 07:30:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('33', '799AAE3B73CD45AEB641D95765A0205A', '0', '2018-02-08', '2018-02-08 20:30:00', null, '2018-02-09 08:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('34', 'BF81C5AE66F54DB0AEFC232E37E46E59', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('35', 'AED330EB655F40C3B2B7DD6D2A33DF18', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('36', 'E6017959302849FE9CB0629B89B77475', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('37', '552309B47EA24279B7E761E6E8E387A6', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('38', 'CD2A52BC83C349D0978EC288809FCE6F', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('39', 'AED999017B5446FB88F6F00225FF7991', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('40', '69F6EC898EC345C7B73E3D7222641D53', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');
INSERT INTO `tw_attendance_diary` VALUES ('41', 'DEE1233D3C2E437CAE9E625B541A91A8', '0', '2018-02-08', '2018-02-08 08:00:00', null, '2018-02-08 18:00:00', null, null, '2018-02-08 00:07:00', null, '2018-02-08 00:07:00');

-- ----------------------------
-- Table structure for `tw_attendance_employee`
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance_employee`;
CREATE TABLE `tw_attendance_employee` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `emp_id` varchar(32) NOT NULL COMMENT '员工标识',
  `attendance_id` int(11) NOT NULL COMMENT '考勤方案标识',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='员工考勤关系';

-- ----------------------------
-- Records of tw_attendance_employee
-- ----------------------------
INSERT INTO `tw_attendance_employee` VALUES ('5', '12306F2882EF4D3ABE2C0881A2C8D893', '9', 'system', '2018-02-05 15:04:52', 'system', '2018-02-05 19:24:15');
INSERT INTO `tw_attendance_employee` VALUES ('7', '4A21485019174112889F6ABB8FA12EED', '8', 'system', '2018-02-05 15:06:22', null, '2018-02-05 15:06:22');
INSERT INTO `tw_attendance_employee` VALUES ('8', '799AAE3B73CD45AEB641D95765A0205A', '9', 'system', '2018-02-05 19:22:21', 'system', '2018-02-05 19:24:15');

-- ----------------------------
-- Table structure for `tw_attendance_logs`
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance_logs`;
CREATE TABLE `tw_attendance_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `emp_id` varchar(32) NOT NULL COMMENT '员工标识',
  `att_time` datetime NOT NULL COMMENT '签名时间',
  `att_note` varchar(128) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='员工考勤记录表';

-- ----------------------------
-- Records of tw_attendance_logs
-- ----------------------------
INSERT INTO `tw_attendance_logs` VALUES ('1', 'E6017959302849FE9CB0629B89B77475', '2018-02-08 00:41:18', '{\"cardNo\":\"10\"}');
INSERT INTO `tw_attendance_logs` VALUES ('2', 'E6017959302849FE9CB0629B89B77475', '2018-02-08 00:43:04', '{\"cardNo\":\"10\"}');
INSERT INTO `tw_attendance_logs` VALUES ('3', '4A21485019174112889F6ABB8FA12EED', '2018-02-08 00:43:51', '{\"cardNo\":\"11\"}');
INSERT INTO `tw_attendance_logs` VALUES ('4', '4A21485019174112889F6ABB8FA12EED', '2018-02-08 00:44:09', '{\"cardNo\":\"11\"}');
INSERT INTO `tw_attendance_logs` VALUES ('5', '4A21485019174112889F6ABB8FA12EED', '2018-02-08 00:48:17', '{\"cardNo\":\"11\"}');
INSERT INTO `tw_attendance_logs` VALUES ('6', '4A21485019174112889F6ABB8FA12EED', '2018-02-08 00:48:20', '{\"cardNo\":\"11\"}');
INSERT INTO `tw_attendance_logs` VALUES ('7', '4A21485019174112889F6ABB8FA12EED', '2018-02-08 00:50:01', '{\"cardNo\":\"11\"}');
INSERT INTO `tw_attendance_logs` VALUES ('8', '4A21485019174112889F6ABB8FA12EED', '2018-02-08 00:51:06', '{\"cardNo\":\"11\"}');
INSERT INTO `tw_attendance_logs` VALUES ('9', '552309B47EA24279B7E761E6E8E387A6', '2018-02-08 00:51:11', '{\"cardNo\":\"13\"}');
INSERT INTO `tw_attendance_logs` VALUES ('10', 'DEE1233D3C2E437CAE9E625B541A91A8', '2018-02-08 00:51:26', '{\"cardNo\":\"20\"}');

-- ----------------------------
-- Table structure for `tw_attendance_time`
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance_time`;
CREATE TABLE `tw_attendance_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `attendance_id` int(11) NOT NULL COMMENT '考勤标识',
  `name` varchar(16) NOT NULL COMMENT '时段名称',
  `sign_time` time NOT NULL COMMENT '上班时间',
  `out_time` time NOT NULL COMMENT '下班时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='考勤时段 一个考勤方案至多三个时段';

-- ----------------------------
-- Records of tw_attendance_time
-- ----------------------------
INSERT INTO `tw_attendance_time` VALUES ('1', '1', '全', '08:00:00', '18:00:00');
INSERT INTO `tw_attendance_time` VALUES ('4', '8', '早', '21:30:00', '07:30:00');
INSERT INTO `tw_attendance_time` VALUES ('5', '8', '晚', '20:00:00', '02:00:00');
INSERT INTO `tw_attendance_time` VALUES ('12', '9', '早', '20:30:00', '08:00:00');
INSERT INTO `tw_attendance_time` VALUES ('13', '9', '中', '23:00:00', '18:00:00');
INSERT INTO `tw_attendance_time` VALUES ('14', '9', '晚', '08:00:00', '22:00:00');
INSERT INTO `tw_attendance_time` VALUES ('18', '11', '早', '20:30:00', '08:30:00');
INSERT INTO `tw_attendance_time` VALUES ('20', '11', '中', '23:00:00', '18:00:00');
INSERT INTO `tw_attendance_time` VALUES ('21', '11', '晚', '08:00:00', '22:00:00');
INSERT INTO `tw_attendance_time` VALUES ('22', '13', 'string', '18:20:20', '12:20:20');

-- ----------------------------
-- Table structure for `tw_employee_journal`
-- ----------------------------
DROP TABLE IF EXISTS `tw_employee_journal`;
CREATE TABLE `tw_employee_journal` (
  `journal_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `emp_id` varchar(32) NOT NULL COMMENT '员工标识',
  `attendance_date` date NOT NULL COMMENT '考勤日期',
  `sign_time` datetime NOT NULL COMMENT '签到时间',
  `out_time` datetime NOT NULL COMMENT '签退时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`journal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工考勤日志';

-- ----------------------------
-- Records of tw_employee_journal
-- ----------------------------
