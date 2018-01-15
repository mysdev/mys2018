/*
Navicat MySQL Data Transfer

Source Server         : Local-VBox-192.168.132.26
Source Server Version : 50719
Source Host           : 192.168.135.101:3306
Source Database       : mys1688

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-01-10 11:37:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for to_authorization
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
-- Table structure for to_customer
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
-- Table structure for tb_department
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
-- Table structure for tb_employee
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE `tb_employee` (
  `emp_id` varchar(32) NOT NULL COMMENT '员工标识',
  `emp_name` varchar(64) NOT NULL COMMENT '员工姓名',
  `pinyin` varchar(16) NOT NULL COMMENT '员工拼音',
  `emp_no` varchar(16) DEFAULT NULL COMMENT '员工工号',
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
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Table structure for tb_employee_special
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
-- Table structure for to_goods
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
-- Table structure for to_goods_ext
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
-- Table structure for to_goods_material
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
-- Table structure for to_goods_unit
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
-- Table structure for tb_member
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
-- Table structure for tb_member_level
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
-- Table structure for tb_member_plus
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员充值活动';

-- ----------------------------
-- Table structure for tb_member_record
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
-- Table structure for to_packages
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
-- Table structure for to_packages_detail
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
-- Table structure for tb_reservation
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
-- Table structure for tb_reservation_trade
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
-- Table structure for tb_room
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
-- Table structure for tb_store
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
-- Table structure for tb_strap
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
-- Table structure for tb_type
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
-- Table structure for tb_type_bind
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
  `classs` int(11) DEFAULT NULL COMMENT '归属轮班',
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

-- ----------------------------
-- Table structure for ts_config
-- ----------------------------
DROP TABLE IF EXISTS `ts_config`;
CREATE TABLE `ts_config` (
  `property_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性标识',
  `property_code` varchar(16) NOT NULL COMMENT '属性代码',
  `property_value` varchar(512) NOT NULL COMMENT '属性值',
  `property_note` varchar(32) DEFAULT NULL COMMENT '属性描述',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`property_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='系统配置';

-- ----------------------------
-- Table structure for ts_dictionary
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
-- Table structure for ts_dictionary_group
-- ----------------------------
DROP TABLE IF EXISTS `ts_dictionary_group`;
CREATE TABLE `ts_dictionary_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组标识',
  `group_code` varchar(32) NOT NULL COMMENT '分组代码',
  `group_name` varchar(64) NOT NULL COMMENT '分组名称',
  `remark` varchar(255) COMMENT '备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典分组';

-- ----------------------------
-- Table structure for ts_document_info
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
-- Table structure for ts_log
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
-- Table structure for ts_resource_info
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源菜单';

-- ----------------------------
-- Table structure for ts_role_info
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Table structure for ts_role_permission
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
-- Table structure for ts_user
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Table structure for ts_user_group
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
-- Table structure for ts_user_role
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
-- Table structure for tt_coupon
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
-- Table structure for tt_coupon_item
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
-- Table structure for tt_exchange
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
-- Table structure for tt_member_price
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
-- Table structure for tt_settlement
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
-- Table structure for tt_trade
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
-- Table structure for tt_trade_discount
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
-- Table structure for tt_volume
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
-- Table structure for tw_attendance
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance`;
CREATE TABLE `tw_attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考勤方案标识',
  `store_id` varchar(32) DEFAULT NULL COMMENT '门店标识',
  `attendance_name` varchar(64) NOT NULL COMMENT '考勤方案名称',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '考勤方案状态 0正常',
  `types` int(11) NOT NULL COMMENT '考勤方案方案 0休天数 1详情',
  `attendance` int(11) DEFAULT NULL COMMENT '休息天数 类型0时有效',
  `sign_time` time NOT NULL COMMENT '上班时间',
  `out_time` time NOT NULL COMMENT '下班时间',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`attendance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店考勤';

-- ----------------------------
-- Table structure for tw_attendance_detail
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance_detail`;
CREATE TABLE `tw_attendance_detail` (
  `att_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '门店标识',
  `attendance_id` int(11) NOT NULL COMMENT '考勤标识',
  `att_date` date NOT NULL COMMENT '考勤日期',
  `attendance` int(11) NOT NULL DEFAULT '0' COMMENT '是否考勤 0考勤',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`att_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='门店考勤详情';

-- ----------------------------
-- Table structure for tw_employee_attend
-- ----------------------------
DROP TABLE IF EXISTS `tw_employee_attend`;
CREATE TABLE `tw_employee_attend` (
  `att_id` int(11) NOT NULL,
  `employee_id` varchar(32) NOT NULL,
  `att_time` datetime NOT NULL,
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`att_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='打卡记录';

-- ----------------------------
-- Table structure for tw_employee_attendance
-- ----------------------------
DROP TABLE IF EXISTS `tw_employee_attendance`;
CREATE TABLE `tw_employee_attendance` (
  `link_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `emp_id` varchar(32) NOT NULL COMMENT '员工标识',
  `attendance_id` int(11) NOT NULL COMMENT '考勤方案标识',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工考勤关系';

-- ----------------------------
-- Table structure for tw_employee_journal
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
