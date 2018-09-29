/*
Navicat MySQL Data Transfer

Source Server         : 方向180
Source Server Version : 50632
Source Host           : 211.149.247.180:33060
Source Database       : mys

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2018-09-28 17:14:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for code_culums
-- ----------------------------
DROP TABLE IF EXISTS `code_culums`;
CREATE TABLE `code_culums` (
  `cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '列id',
  `tid` int(10) NOT NULL COMMENT '表格id',
  `columnName` varchar(100) DEFAULT NULL COMMENT '字段名',
  `columnLabel` varchar(100) DEFAULT NULL COMMENT '显示名',
  `columnComment` varchar(200) DEFAULT NULL COMMENT '字段注释',
  `columnType` varchar(100) DEFAULT NULL COMMENT '字段类型',
  `scale` varchar(20) DEFAULT NULL COMMENT '规模',
  `precision` varchar(20) DEFAULT NULL COMMENT '精度',
  `nullable` varchar(20) DEFAULT NULL COMMENT '是否可以为空',
  `foreignKey` int(11) DEFAULT '0' COMMENT '是否外键',
  `filedType` varchar(100) DEFAULT NULL COMMENT 'Java属性类型',
  `length` int(11) DEFAULT NULL COMMENT '字段长度',
  `isSearch` int(11) DEFAULT NULL COMMENT '是否查询条件',
  `isList` int(11) DEFAULT NULL COMMENT '是否列表显示',
  `listSort` int(11) DEFAULT NULL COMMENT '列表顺序',
  `listWidth` int(11) DEFAULT NULL COMMENT '列表宽度',
  `isForm` int(11) DEFAULT NULL COMMENT '是否表单显示',
  `formType` int(11) DEFAULT NULL COMMENT '表单控件类型',
  `groupCode` varchar(100) DEFAULT NULL COMMENT '数据字典groupCode',
  `formClass` varchar(100) DEFAULT NULL COMMENT '表单Class',
  `formValidate` varchar(100) DEFAULT NULL COMMENT '表单校验',
  `fromWidth` int(11) DEFAULT NULL COMMENT '控件宽度',
  `spacing` int(11) DEFAULT NULL COMMENT '间隔宽度',
  `isNewLine` int(11) DEFAULT NULL COMMENT '是否换行',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=1876 DEFAULT CHARSET=utf8 COMMENT='表格列';

-- ----------------------------
-- Records of code_culums
-- ----------------------------
INSERT INTO `code_culums` VALUES ('1702', '158', 'member_id', '会员标识', '会员标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1703', '158', 'member_name', '会员名称', '会员名称', 'varchar', null, null, 'N', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1704', '158', 'pinyin', '拼音', '拼音', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1705', '158', 'status', '状态 0正常', '状态 0正常', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '78', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1706', '158', 'rfm', '会员成长值', '会员成长值', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '65', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1707', '158', 'level_id', '会员等级', '会员等级', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1708', '158', 'member_card', '卡号', '卡号', 'varchar', null, null, 'Y', '0', 'String', '16', '1', '1', null, '208', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1709', '158', 'member_password', '会员密码', '会员密码', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1710', '158', 'integral', '积分', '积分', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1711', '158', 'balance', '余额', '余额', 'decimal', '2', null, 'N', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1712', '158', 'mobile', '手机号', '手机号', 'varchar', null, null, 'N', '0', 'String', '16', '1', '1', null, '208', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1713', '158', 'mail', '邮箱地址', '邮箱地址', 'varchar', null, null, 'Y', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1714', '158', 'birthday', '生日', '生日', 'date', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1715', '158', 'store_id', '开卡门店', '开卡门店', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1716', '158', 'total_fee', '总花费', '总花费', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '39', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1717', '158', 'sex', '性别 0男1女', '性别 0男1女', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '91', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1718', '158', 'address', '住址', '住址', 'varchar', null, null, 'Y', '0', 'String', '128', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1719', '158', 'card_type', '证件类型 0身份证', '证件类型 0身份证', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '117', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1720', '158', 'card_no', '证件号码', '证件号码', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1721', '158', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1722', '158', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1723', '158', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1724', '158', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1725', '159', 'level_id', '自标识', '自标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '39', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1726', '159', 'level_name', '级别名称', '级别名称', 'varchar', null, null, 'N', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1727', '159', 'level_rfm', '成长值', '成长值', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '39', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1728', '159', 'parent_id', '上级会员级别', '上级会员级别', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '78', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1729', '159', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1730', '159', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1731', '159', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1732', '159', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1733', '160', 'record_id', '记录标识', '记录标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1734', '160', 'member_id', '会员标识', '会员标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1735', '160', 'rtype', '收支', '收支', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1736', '160', 'money', '金额', '金额', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1737', '160', 'balance', '余额', '余额', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1738', '160', 'remark', '备注', '备注', 'varchar', null, null, 'Y', '0', 'String', '200', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1739', '160', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1740', '160', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1741', '161', 'record_id', '记录标识', '记录标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1742', '161', 'member_id', '会员标识', '会员标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1743', '161', 'rtype', '收支', '收支', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1744', '161', 'integral', '积分', '积分', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1745', '161', 'balance', '余额', '余额', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1746', '161', 'remark', '备注', '备注', 'varchar', null, null, 'Y', '0', 'String', '200', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1747', '161', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1748', '161', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1749', '162', 'cid', '记录标识', '记录标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1750', '162', 'employee_id', '员工标识', '员工标识', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1751', '162', 'money', '金额', '金额', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1752', '162', 'cause', '原由', '原由', 'varchar', null, null, 'Y', '0', 'String', '200', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1753', '162', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1754', '162', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1755', '162', 'remark', '备注', '备注', 'varchar', null, null, 'Y', '0', 'String', '200', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1756', '163', 'emp_id', '员工标识', '员工标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1757', '163', 'emp_name', '员工姓名', '员工姓名', 'varchar', null, null, 'N', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1758', '163', 'pinyin', '员工拼音', '员工拼音', 'varchar', null, null, 'N', '0', 'String', '16', '1', '1', null, '208', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1759', '163', 'emp_no', '员工工号', '员工工号', 'varchar', null, null, 'Y', '0', 'String', '16', '1', '1', null, '208', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1760', '163', 'emp_card', '员工卡号', '员工卡号', 'varchar', null, null, 'Y', '0', 'String', '16', '1', '1', null, '208', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1761', '163', 'user_id', '关联用户', '关联用户', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1762', '163', 'store_id', '所属门店', '所属门店', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1763', '163', 'dpt_id', '所属部门', '所属部门', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1764', '163', 'entry_date', '入职时间', '入职时间', 'date', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1765', '163', 'quit_date', '离职时间', '离职时间', 'date', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1766', '163', 'status', '员工状态 0正常', '员工状态 0正常', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '104', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1767', '163', 'is_manager', '是否管理 0否', '是否管理 0否', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '91', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1768', '163', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1769', '163', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1770', '163', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1771', '163', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1772', '164', 'room_id', '房间标识', '房间标识', 'varchar', '', '', 'N', '0', 'String', '32', '0', '0', null, '416', '0', '1', '', 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1773', '164', 'types', '房间类型', '房间类型', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1774', '164', 'area', '归属区域', '归属区域', 'varchar', null, null, 'Y', '0', 'String', '8', '1', '1', null, '104', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1775', '164', 'room_no', '房间编号', '房间编号', 'varchar', null, null, 'Y', '0', 'String', '8', '1', '1', null, '104', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1776', '164', 'room_name', '房间名称', '房间名称', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1777', '164', 'status', '状态 0正常', '状态 0正常', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '78', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1778', '164', 'room_status', '自身状态', '自身状态', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1779', '164', 'chair', '椅子数量', '椅子数量', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1780', '164', 'bed', '床数量', '床数量', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '39', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1781', '164', 'mark', '标记', '标记', 'varchar', null, null, 'Y', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1782', '164', 'phone', '房间分机', '房间分机', 'varchar', null, null, 'Y', '0', 'String', '16', '1', '1', null, '208', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1783', '164', 'is_consumption', '是否包含基础消费', '是否包含基础消费', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '104', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1784', '164', 'commodity', '商品id，逗号分隔', '商品id，逗号分隔', 'varchar', null, null, 'Y', '0', 'String', '200', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1785', '164', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1786', '164', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1787', '164', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1788', '164', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1789', '165', 'strap_id', '手牌标识', '手牌标识', 'varchar', '', '', 'N', '0', 'String', '32', '0', '0', null, '416', '0', '1', '', 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1791', '165', 'strap_serial', '手牌号码', '手牌号码', 'varchar', null, null, 'N', '0', 'String', '16', '1', '1', null, '208', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1792', '165', 'strap_no', '手牌编号', '手牌编号', 'varchar', null, null, 'Y', '0', 'String', '8', '1', '1', null, '104', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1793', '165', 'types', '手牌类型', '手牌类型', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1794', '165', 'status', '手牌状态 0正常', '手牌状态 0正常', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '104', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1795', '165', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1796', '165', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1797', '165', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1798', '165', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1799', '166', 'goods_id', '商品标识', '商品标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1800', '166', 'store_id', '归属门店', '归属门店', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1801', '166', 'goods_name', '商品名称', '商品名称', 'varchar', null, null, 'N', '0', 'String', '128', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1802', '166', 'price', '商品售价', '商品售价', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1803', '166', 'unit_id', '商品单位', '商品单位', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1804', '166', 'goods_time', '服务时长 分', '服务时长 分', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '78', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1805', '166', 'classify', '商品小类', '商品小类', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1806', '166', 'material_id', '原料标识', '原料标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1807', '166', 'material_types', '原料类型(冗) 0物品1服务', '原料类型(冗) 0物品1服务', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '182', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1808', '166', 'material_ct', '消耗原料数量 0不减库存', '消耗原料数量 0不减库存', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '156', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1809', '166', 'status', '状态 0正常', '状态 0正常', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '78', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1810', '166', 'sale_status', '销售状态 推荐热销', '销售状态 推荐热销', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '117', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1811', '166', 'note', '商品说明', '商品说明', 'varchar', null, null, 'Y', '0', 'String', '512', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1812', '166', 'goods_img', '商品图例', '商品图例', 'varchar', null, null, 'Y', '0', 'String', '256', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1813', '166', 'is_show', '对客显示 0是', '对客显示 0是', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '91', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1814', '166', 'can_cancel', '可否撤消 0是1否', '可否撤消 0是1否', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '117', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1815', '166', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1816', '166', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1817', '166', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1818', '166', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1819', '167', 'unit_id', '单位标识', '单位标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1820', '167', 'unit_name', '单位名称', '单位名称', 'varchar', null, null, 'N', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1821', '167', 'base_unit', '基准单位', '基准单位', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1822', '167', 'base_ct', '换算比 与基准单位', '换算比 与基准单位', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '117', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1823', '167', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1824', '167', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1825', '167', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1826', '167', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1827', '168', 'material_id', '原料标识', '原料标识', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1828', '168', 'store_id', '归属门店', '归属门店', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1829', '168', 'material_name', '原料名称', '原料名称', 'varchar', null, null, 'Y', '0', 'String', '128', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1830', '168', 'material_no', '原料代码', '原料代码', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1831', '168', 'material_types', '原料类型 0物品1服务', '原料类型 0物品1服务', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '143', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1832', '168', 'material_ct', '原料库存', '原料库存', 'int', '0', null, 'Y', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1833', '168', 'pinyin', '拼音', '拼音', 'varchar', null, null, 'Y', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1834', '168', 'cost', '纯成本', '纯成本', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '39', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1835', '168', 'cost_all', '核算成本', '核算成本', 'decimal', '2', null, 'Y', '0', 'java.math.BigDecimal', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1836', '168', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1837', '168', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1838', '168', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1839', '168', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1840', '169', 'authorization_id', '授权码', '授权码', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1841', '169', 'customer_id', '归属客户', '归属客户', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1842', '169', 'types', '终端类型 0房间 1手环', '终端类型 0房间 1手环', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '156', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1843', '169', 'device_id', '终端标识', '终端标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1844', '169', 'status', '授权码状态 0正常', '授权码状态 0正常', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '117', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1845', '169', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1846', '169', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1847', '169', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1848', '169', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1849', '170', 'customer_id', '客户标识', '客户标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1850', '170', 'customer_name', '客户名称', '客户名称', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1851', '170', 'advance', '押金', '押金', 'decimal', '2', null, 'N', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1852', '170', 'note', '备注', '备注', 'varchar', null, null, 'Y', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1853', '170', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1854', '170', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1855', '170', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1856', '170', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1857', '171', 'package_id', '套餐标识', '套餐标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1858', '171', 'store_id', '归属门店', '归属门店', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1859', '171', 'package_name', '套餐名称', '套餐名称', 'varchar', null, null, 'N', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1860', '171', 'pinyin', '套餐拼音', '套餐拼音', 'varchar', null, null, 'N', '0', 'String', '64', '1', '1', null, '500', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1861', '171', 'price', '售价', '售价', 'decimal', '2', null, 'N', '0', 'java.math.BigDecimal', '0', '1', '1', null, '26', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1862', '171', 'valid_date', '有效日期', '有效日期', 'date', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1863', '171', 'status', '套餐状态 0正常', '套餐状态 0正常', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '104', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1864', '171', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1865', '171', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1866', '171', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1867', '171', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1868', '172', 'detail_id', '详情标识', '详情标识', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1869', '172', 'package_id', '归属套餐', '归属套餐', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1870', '172', 'goods_id', '商品标识', '商品标识', 'varchar', null, null, 'N', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1871', '172', 'goods_ct', '商品数量', '商品数量', 'int', '0', null, 'N', '0', 'Integer', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1872', '172', 'created_by', '创建人员', '创建人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1873', '172', 'created_date', '创建时间', '创建时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1874', '172', 'updated_by', '修订人员', '修订人员', 'varchar', null, null, 'Y', '0', 'String', '32', '1', '1', null, '416', '1', '1', null, 'form-control', null, null, null, '0');
INSERT INTO `code_culums` VALUES ('1875', '172', 'updated_date', '修订时间', '修订时间', 'datetime', null, null, 'Y', '0', 'Date', '0', '1', '1', null, '52', '1', '1', null, 'form-control', null, null, null, '0');

-- ----------------------------
-- Table structure for code_tables
-- ----------------------------
DROP TABLE IF EXISTS `code_tables`;
CREATE TABLE `code_tables` (
  `tid` int(10) NOT NULL AUTO_INCREMENT COMMENT '表格id',
  `tableName` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '表格名',
  `tableComment` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '注释',
  `isCode` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否生成代码',
  `pakageURL` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '包路径',
  `className` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '类名',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=latin1 COMMENT='表格';

-- ----------------------------
-- Records of code_tables
-- ----------------------------
INSERT INTO `code_tables` VALUES ('158', 'tb_member', '会员', '0', 'com.jing.core', 'Member');
INSERT INTO `code_tables` VALUES ('159', 'tb_member_level', '会员体系', '0', 'com.jing.core', 'MemberLevel');
INSERT INTO `code_tables` VALUES ('160', 'tb_member_money_record', '会员金额流水', '0', 'com.jing.core', 'MemberMoneyRecord');
INSERT INTO `code_tables` VALUES ('161', 'tb_member_integral_record', '会员积分流水', '0', 'com.jing.core', 'MemberIntegralRecord');
INSERT INTO `code_tables` VALUES ('162', 'tb_employee_commission', '员工提成', '0', 'com.jing.core', 'EmployeeCommission');
INSERT INTO `code_tables` VALUES ('163', 'tb_employee', '员工', '0', 'com.jing.core', 'Employee');
INSERT INTO `code_tables` VALUES ('164', 'tb_room', '房间', '0', 'com.jing.core', 'Room');
INSERT INTO `code_tables` VALUES ('165', 'tb_strap', '手牌', '0', 'com.jing.core', 'Strap');
INSERT INTO `code_tables` VALUES ('166', 'to_goods', '商品服务', '0', 'com.jing.settlement', 'Goods');
INSERT INTO `code_tables` VALUES ('167', 'to_goods_unit', '商品单位', '0', 'com.jing.settlement', 'GoodsUnit');
INSERT INTO `code_tables` VALUES ('168', 'to_goods_material', '基本原料', '0', 'com.jing.settlement', 'GoodsMaterial');
INSERT INTO `code_tables` VALUES ('169', 'to_authorization', '消费授权', '0', 'com.jing.settlement', 'Authorization');
INSERT INTO `code_tables` VALUES ('170', 'to_customer', '客户', '0', 'com.jing.settlement', 'Customer');
INSERT INTO `code_tables` VALUES ('171', 'to_packages', '消费套餐', '0', 'com.jing.settlement', 'Packages');
INSERT INTO `code_tables` VALUES ('172', 'to_packages_detail', '消费套餐详情', '0', 'com.jing.settlement', 'PackagesDetail');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `pid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pcode` varchar(50) NOT NULL COMMENT '编码',
  `pvalue` varchar(4000) NOT NULL COMMENT '值',
  `desc` varchar(100) DEFAULT NULL COMMENT '描述',
  `createdBy` int(11) NOT NULL COMMENT '创建人',
  `createdDate` datetime NOT NULL COMMENT '创建时间',
  `updatedBy` int(11) NOT NULL COMMENT '修改人',
  `updatedDate` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统参数表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'document.upload.folder.temp', 'E:/fhgrid/docs/temp', '临时附件的存储目录', '0', '2018-05-16 10:00:29', '0', '2018-08-25 18:14:37');
INSERT INTO `sys_config` VALUES ('2', 'document.upload.folder.data', 'E:/fhgrid/docs/data', '正式附件的存储目录', '0', '2018-05-16 10:00:50', '0', '2018-08-25 18:14:49');
INSERT INTO `sys_config` VALUES ('3', 'cache.type', 'local', '缓存类型(memcached/local)', '0', '2018-05-22 14:49:32', '0', '2018-05-22 14:49:36');
INSERT INTO `sys_config` VALUES ('4', 'dictionary.file', 'C:/Users/Administrator/git/mys2018/trunk/src/main/resources/static/pc/resources/js/dictionary.js', '数据字典缓存文件绝对地址', '0', '2018-07-05 09:18:24', '1', '2018-09-26 17:25:46');
INSERT INTO `sys_config` VALUES ('5', 'gexin_appKey', 'Mg3Bt7uSvk6USxj2r2i6yA', '个推-appkey', '0', '2017-07-14 11:19:50', '0', '2018-09-11 12:30:43');
INSERT INTO `sys_config` VALUES ('6', 'gexin_masterSecret', 'z6X6ukkjgJ9t2AX5gGEKz6', '个推-masterSecret', '0', '2017-07-14 11:20:20', '0', '2018-09-11 12:32:17');
INSERT INTO `sys_config` VALUES ('7', 'gexin_appId', 'ZcXaUEAxpV5DcCarDWguu4', '个推-appId', '0', '2017-07-14 11:19:23', '0', '2018-09-11 12:30:32');
INSERT INTO `sys_config` VALUES ('8', 'gexin_host', 'http://sdk.open.api.igexin.com/apiex.htm', '个推-host', '0', '2017-07-14 11:20:47', '0', '2017-07-14 11:20:47');
INSERT INTO `sys_config` VALUES ('9', 'mobile.version.remark', '紧急更新:1.修复‘事件审核’报错问题；2.增加‘事件档案’模块;3.调整主界面；', 'APP版本更新说明', '0', '2018-01-15 09:06:00', '0', '2018-09-11 18:15:21');
INSERT INTO `sys_config` VALUES ('10', 'mobile.version.file', 'http://fhx.faithoa.cn:8082/grid/webpage/help/fhx.apk', 'APP版本更新路径', '0', '2017-11-01 13:07:04', '0', '2018-09-11 15:54:01');
INSERT INTO `sys_config` VALUES ('11', 'mobile.version.no', '17', 'APP版本号', '0', '2018-01-15 09:05:01', '0', '2018-09-11 18:17:04');
INSERT INTO `sys_config` VALUES ('12', 'dictionary_version', '1', '数据字典版本号', '0', '2018-08-16 09:45:17', '0', '2018-08-16 09:45:17');
INSERT INTO `sys_config` VALUES ('13', 'exp_templet_people', 'E:/fhgrid/grid/webpage/help/peopleTemplet.xls', '人口数据导出模板', '0', '2018-08-16 09:45:17', '0', '2018-08-16 09:45:17');
INSERT INTO `sys_config` VALUES ('14', 'exp_templet_floor', 'E:/fhgrid/grid/webpage/help/floorTemplet.xls', '楼栋数据导出模板', '0', '2018-08-16 09:45:17', '0', '2018-08-16 09:45:17');
INSERT INTO `sys_config` VALUES ('15', 'exp_templet_event', 'E:/fhgrid/grid/webpage/help/eventTemplet.xls', '事件数据导出模板', '0', '2018-08-16 09:45:17', '0', '2018-08-16 09:45:17');
INSERT INTO `sys_config` VALUES ('16', 'gexin_appSecret', 'BVAYxSJdoNAO4bz0ravte9', '个推-AppSecret', '0', '2018-09-11 12:33:22', '0', '2018-09-11 12:33:22');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `deptCode` int(11) NOT NULL AUTO_INCREMENT,
  `DeptName` longtext,
  `remark` longtext,
  `pid` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `files` longtext,
  PRIMARY KEY (`deptCode`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '总部', '', '0', '1', '1', '');
INSERT INTO `sys_dept` VALUES ('2', '吧台', '', '1', '1', '1', null);

-- ----------------------------
-- Table structure for sys_dept_staff
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_staff`;
CREATE TABLE `sys_dept_staff` (
  `dsid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `deptCode` int(11) NOT NULL COMMENT '部门编码',
  `image` varchar(32) DEFAULT NULL COMMENT '照片',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(50) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `phone` varchar(50) DEFAULT NULL COMMENT '电话',
  `addr` varchar(50) DEFAULT NULL COMMENT '地址',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `post` varchar(50) DEFAULT NULL COMMENT '职务',
  `createdBy` int(11) DEFAULT NULL COMMENT '发布人',
  `createdDate` datetime DEFAULT NULL COMMENT '发布时间',
  `updatedBy` int(11) DEFAULT NULL COMMENT '修改人',
  `updatedDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`dsid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='部门职工表';

-- ----------------------------
-- Records of sys_dept_staff
-- ----------------------------
INSERT INTO `sys_dept_staff` VALUES ('1', '113', 'BBBC9322306C47A0923B91977EAB1D83', '李勇', null, null, '18608456784', '湖南长沙', null, null, null, null, null, null);
INSERT INTO `sys_dept_staff` VALUES ('3', '1', '767356594EC7466EBA540AFBF54C2801', '龙国华', '00011', '2018-08-08 00:00:00', '18608408897', '湖南长沙', '53796952@qq.com', '44000', '1', '2018-08-08 13:50:44', '1', '2018-08-08 13:51:42');

-- ----------------------------
-- Table structure for sys_dept_work
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_work`;
CREATE TABLE `sys_dept_work` (
  `dwid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `deptCode` int(11) NOT NULL COMMENT '部门编码',
  `content` varchar(100) NOT NULL COMMENT '工作内容',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  `createdBy` int(11) DEFAULT NULL COMMENT '登记人',
  `createdDate` datetime DEFAULT NULL COMMENT '登记时间',
  `updatedBy` int(11) DEFAULT NULL COMMENT '操作人',
  `updatedDate` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`dwid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept_work
-- ----------------------------
INSERT INTO `sys_dept_work` VALUES ('1', '1', '1', '1', '1', '2018-08-16 15:45:48', '1', '2018-08-16 15:45:51');

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `code` varchar(20) NOT NULL COMMENT '编码',
  `value` varchar(100) DEFAULT NULL COMMENT '值',
  `groupCode` varchar(50) NOT NULL COMMENT '分组编码',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `flag` int(11) DEFAULT NULL COMMENT '状态',
  `createdBy` varchar(32) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `updatedBy` varchar(32) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`code`,`groupCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dictionary
-- ----------------------------
INSERT INTO `sys_dictionary` VALUES ('0', '否', '1001', '2', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00011', '男', '0001', '2', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00012', '女', '0001', '3', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000310', '研究生', '0003', '10', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000320', '大学本科', '0003', '9', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000330', '大学专科和专科学校', '0003', '8', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000340', '中等专业学校或中等技术学校', '0003', '7', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000350', '技工学校', '0003', '6', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000360', '高中', '0003', '5', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000370', '初中', '0003', '4', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000380', '小学', '0003', '3', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000390', '文盲或半文盲', '0003', '2', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000391', '其他', '0003', '99', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000399', '学龄前儿童', '0003', '1', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000410', '未婚', '0004', '1', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000420', '已婚', '0004', '2', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000421', '初婚', '0004', '3', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000422', '再婚', '0004', '4', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000423', '复婚', '0004', '5', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000430', '丧偶', '0004', '6', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000440', '离婚', '0004', '7', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000490', '其他', '0004', '8', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00051', '正常', '0005', '1', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000510', '健康或良好', '0005', '10', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00052', '低体重儿', '0005', '2', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00053', '肉眼可见的出生缺陷', '0005', '3', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000530', '有慢性病', '0005', '30', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000531', '心血管病', '0005', '31', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000532', '脑血管病', '0005', '32', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000533', '慢性呼吸系统病', '0005', '33', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000534', '慢性消化系统病', '0005', '34', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000535', '慢性肾炎', '0005', '35', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000536', '结核病', '0005', '36', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000537', '糖尿病', '0005', '37', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000538', '神经或精神疾病', '0005', '38', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00054', '一般或较弱', '0005', '4', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000540', '有慢性病', '0005', '40', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000541', '癌病', '0005', '41', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000549', '其他慢性病', '0005', '49', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00055', '(严重)疾病', '0005', '5', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00056', '后天致残', '0005', '6', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000560', '残疾', '0005', '60', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000561', '视力残疾', '0005', '61', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000562', '听力残疾', '0005', '62', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000563', '言语残疾', '0005', '63', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000564', '肢体残疾', '0005', '64', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000565', '智力残疾', '0005', '65', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000566', '精神残疾', '0005', '66', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000567', '多重残疾', '0005', '67', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000569', '其他残疾', '0005', '69', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00057', '死亡', '0005', '7', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00059', '其他', '0005', '8', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00061', '中国共产党党员', '0006', '1', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('000613', '群众', '0006', '13', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00063', '中国共产主义青年团团员', '0006', '3', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('00064', '中国国民党革命委员会会员', '0006', '4', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('00065', '中国民主同盟盟员', '0006', '5', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('00066', '中国民主建国会会员', '0006', '6', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('00067', '中国民主促进会会员', '0006', '7', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('00068', '中国农工民主党党员', '0006', '8', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('00069', '中国致公党党员', '0006', '9', '1', 'ADMIN', '2018-08-03 12:28:32', null, null);
INSERT INTO `sys_dictionary` VALUES ('00091', '汉族', '0009', '1', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000910', '朝鲜族', '0009', '10', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000911', '满族', '0009', '11', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000912', '侗族', '0009', '12', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000913', '瑶族', '0009', '13', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000914', '白族', '0009', '14', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000915', '土家族', '0009', '15', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000916', '哈尼族', '0009', '16', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000917', '哈萨克族', '0009', '17', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000918', '傣族', '0009', '18', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000919', '黎族', '0009', '19', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00092', '蒙族', '0009', '2', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000920', '傈僳族', '0009', '20', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000921', '佤族', '0009', '21', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000922', '舍族', '0009', '22', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000923', '高山族', '0009', '23', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000924', '拉祜族', '0009', '24', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000925', '水族', '0009', '25', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000926', '东乡族', '0009', '26', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000927', '纳西族', '0009', '27', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000928', '景颇族', '0009', '28', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000929', '柯尔克孜族', '0009', '29', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00093', '回族', '0009', '3', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000930', '土族', '0009', '30', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000931', '达斡尔族', '0009', '31', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000932', '仫佬族', '0009', '32', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000933', '羌族', '0009', '33', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000934', '布朗族', '0009', '34', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000935', '撒拉族', '0009', '35', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000936', '毛南族', '0009', '36', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000937', '仡佬族', '0009', '37', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000938', '锡伯族', '0009', '38', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000939', '阿昌族', '0009', '39', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00094', '藏族', '0009', '4', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000940', '普米族', '0009', '40', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000941', '塔吉克族', '0009', '41', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000942', '怒族', '0009', '42', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000943', '乌孜别克族', '0009', '43', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000944', '俄罗斯族', '0009', '44', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000945', '鄂温克族', '0009', '45', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000946', '德昂族', '0009', '46', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000947', '保安族', '0009', '47', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000948', '裕固族', '0009', '48', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000949', '京族', '0009', '49', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00095', '维族', '0009', '5', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000950', '塔塔尔族', '0009', '50', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000951', '独龙族', '0009', '51', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000952', '鄂伦春族', '0009', '52', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000953', '赫哲族', '0009', '53', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000954', '门巴族', '0009', '54', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000955', '珞巴族', '0009', '55', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000956', '基诺族', '0009', '56', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00096', '苗族', '0009', '6', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00097', '彝族', '0009', '7', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00098', '壮族', '0009', '8', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('00099', '布依族', '0009', '9', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000997', '*未识别', '0009', '57', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('000998', '*外入中籍', '0009', '58', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('1', '是', '1001', '1', '1', 'ADMIN', '2017-04-27 15:22:44', null, null);
INSERT INTO `sys_dictionary` VALUES ('200101', '饮料', '2001', '1', '1', null, '2018-09-26 17:28:20', null, '2018-09-26 17:28:20');
INSERT INTO `sys_dictionary` VALUES ('200102', '水果', '2001', '2', '1', null, '2018-09-26 17:28:39', null, '2018-09-26 17:28:39');
INSERT INTO `sys_dictionary` VALUES ('200103', '主食', '2001', '3', '1', null, '2018-09-26 17:28:55', null, '2018-09-26 17:28:55');
INSERT INTO `sys_dictionary` VALUES ('200199', '其他', '2001', '99', '1', null, '2018-09-26 17:29:23', null, '2018-09-26 17:29:23');

-- ----------------------------
-- Table structure for sys_dictionary_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary_group`;
CREATE TABLE `sys_dictionary_group` (
  `code` varchar(50) NOT NULL COMMENT '编码',
  `desc` varchar(100) DEFAULT NULL COMMENT '描述',
  `createdBy` varchar(32) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `updatedBy` varchar(32) DEFAULT NULL,
  `updatedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典组';

-- ----------------------------
-- Records of sys_dictionary_group
-- ----------------------------
INSERT INTO `sys_dictionary_group` VALUES ('0001', '性别', 'ADMIN', '2017-04-27 15:19:00', null, null);
INSERT INTO `sys_dictionary_group` VALUES ('0003', '文化程度', 'ADMIN', '2017-04-27 15:19:00', null, null);
INSERT INTO `sys_dictionary_group` VALUES ('0004', '婚姻状况', 'ADMIN', '2017-04-27 15:19:00', null, null);
INSERT INTO `sys_dictionary_group` VALUES ('0005', '健康状况', 'ADMIN', '2017-04-27 15:19:00', null, null);
INSERT INTO `sys_dictionary_group` VALUES ('0006', '政治面貌', 'ADMIN', '2017-04-27 15:19:00', null, null);
INSERT INTO `sys_dictionary_group` VALUES ('0009', '民族', 'ADMIN', '2017-04-27 15:19:00', null, null);
INSERT INTO `sys_dictionary_group` VALUES ('1001', '是否', 'ADMIN', '2017-04-27 15:19:00', null, null);
INSERT INTO `sys_dictionary_group` VALUES ('2001', '商品小类', 'admin', '2018-09-26 17:27:58', 'admin', '2018-09-26 17:27:58');

-- ----------------------------
-- Table structure for sys_document
-- ----------------------------
DROP TABLE IF EXISTS `sys_document`;
CREATE TABLE `sys_document` (
  `did` varchar(32) CHARACTER SET latin1 NOT NULL COMMENT '主键',
  `remark` varchar(100) CHARACTER SET latin1 DEFAULT NULL COMMENT '文件描述',
  `actual` varchar(50) DEFAULT NULL COMMENT '文件名',
  `suffix` varchar(16) CHARACTER SET latin1 DEFAULT NULL COMMENT '文件后缀',
  `size` decimal(18,0) DEFAULT NULL COMMENT '文件大小',
  `state` int(11) DEFAULT NULL COMMENT '文件状态',
  `url` varchar(200) CHARACTER SET latin1 DEFAULT NULL COMMENT '文件存储路径',
  `res` varchar(36) CHARACTER SET latin1 DEFAULT NULL COMMENT '关联主键',
  `upTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`did`),
  KEY `index_sys_document` (`res`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Records of sys_document
-- ----------------------------
INSERT INTO `sys_document` VALUES ('02B84284288D46D79605BB3217913279', null, '1537242603243', '.jpg', '680916', '1', 'E:/fhgrid/docs/temp/2018-09-18/1F8DE5C26787435C839552A9BE1D8FC0.jpg', null, '2018-09-18 11:50:03');
INSERT INTO `sys_document` VALUES ('058F0BD4DC1E4A1D89141E8F68AA9999', null, '微信图片_20180910225047', '.jpg', '65499', '2', 'D:/fhgrid/docs/data/4ED9046EC2664F9FACBD8CCFD96C9F2E/08A82C034D8748CD9925957F21CC6EAB.jpg', '4ED9046EC2664F9FACBD8CCFD96C9F2E', '2018-09-10 23:01:56');
INSERT INTO `sys_document` VALUES ('066E163524A4439C99A19A61C7384147', null, '26840979402351602', '.jpg', '175301', '2', 'D:/fhgrid/docs/data/6AB4D4CECCAF4B32A3FE33F5B59179B5/9D46E1C6D3464F9BB2E9D608B2FE5FB8.jpg', '6AB4D4CECCAF4B32A3FE33F5B59179B5', '2018-09-11 14:41:33');
INSERT INTO `sys_document` VALUES ('0C5A56F719E64B2D88E85646FC57B29C', null, '微信图片_20180910224955', '.jpg', '65925', '2', 'D:/fhgrid/docs/data/CDBD5E8C9E00438ABE58906C799EB4D3/C8357EB6858A4E22AED65A21DBE9410E.jpg', 'CDBD5E8C9E00438ABE58906C799EB4D3', '2018-09-10 22:58:43');
INSERT INTO `sys_document` VALUES ('0CA5E68CEA4A4D4B871BE645F00EB036', null, '1536673133109', '.jpg', '970549', '1', 'D:/fhgrid/docs/temp/2018-09-11/B660994946804C1AA2B512F38D86B91B.jpg', null, '2018-09-11 21:40:07');
INSERT INTO `sys_document` VALUES ('0FFD887FEB1949C984B1E27D78B3E6A4', null, '1537242576961', '.jpg', '364684', '1', 'E:/fhgrid/docs/temp/2018-09-18/42D7521BEB30438E85AF6634C9126757.jpg', null, '2018-09-18 11:49:37');
INSERT INTO `sys_document` VALUES ('12826C7DDC98454582D852FF7516B3E7', null, '307323084368850898', '.jpg', '100996', '2', 'D:/fhgrid/docs/data/98168D08DA4E4D06B54E8F075AED454D/EF503C9E18FA4C33B4DB059D69855038.jpg', '98168D08DA4E4D06B54E8F075AED454D', '2018-09-10 09:15:10');
INSERT INTO `sys_document` VALUES ('14EA6098E2174589AF216BB4460CB635', null, '1536742987237', '.jpg', '331016', '2', 'D:/fhgrid/docs/data/622852A73C574A73A63D4BCFA5305714/672F716398F5473D997941BF6AF04E06.jpg', '622852A73C574A73A63D4BCFA5305714', '2018-09-12 17:03:10');
INSERT INTO `sys_document` VALUES ('14F80B15454E4D6DA8DE80325939AD1D', null, '1536737672839', '.jpg', '507714', '1', 'D:/fhgrid/docs/temp/2018-09-12/1E284E59A32D44D2BFAE947539164B02.jpg', null, '2018-09-12 15:34:35');
INSERT INTO `sys_document` VALUES ('15D316E1A9104555A01E84728CDFC96D', null, '修路', '.jpg', '187974', '2', 'D:/fhgrid/docs/data/CD698591E4EF4808BBF5621E3C17A836/C9CF091C8D8A49399EAE63CA3ECCE8A6.jpg', 'CD698591E4EF4808BBF5621E3C17A836', '2018-09-11 16:14:40');
INSERT INTO `sys_document` VALUES ('1655E88807834E48970B654833012EFE', null, '图片1_看图王', '.png', '523228', '1', 'D:/fhgrid/docs/temp/2018-09-06/EC09C4E939D4482E8746A71D0E0F709B.png', null, '2018-09-06 21:09:56');
INSERT INTO `sys_document` VALUES ('1943F361E4FC49678B8ABE6E198757FC', null, '图片1_看图王(1)', '.png', '339318', '1', 'D:/fhgrid/docs/temp/2018-09-06/D5EA5F9BDB70468AAB21C0685B31C03F.png', null, '2018-09-06 21:15:56');
INSERT INTO `sys_document` VALUES ('1ABEF55CA9204B9190C5B931633C33D2', null, '1536282201803', '.jpg', '1418745', '2', 'D:/fhgrid/docs/data/A17A395B956B45F1977217BDF36A556B/9DFE2545E7DB47C8AEEDD0E7036ECD1C.jpg', 'A17A395B956B45F1977217BDF36A556B', '2018-09-07 09:03:29');
INSERT INTO `sys_document` VALUES ('1B6FA835DA3E407E8E3E11658CEF4C7B', null, '1536649124295', '.jpg', '562708', '2', 'D:/fhgrid/docs/data/74CE872523D642BEA7A200C5514AAA74/0A00AFB32E154D189C9B92DC3C8397AB.jpg', '74CE872523D642BEA7A200C5514AAA74', '2018-09-11 14:58:48');
INSERT INTO `sys_document` VALUES ('1CE09823F57A4B9CA3DF61ECBCAB23AE', null, '1_万能看图王', '.jpg', '528487', '2', 'D:/fhgrid/docs/data/71C40895711B46989D02AACA574FC368/17313EB6DEBE4613998415B91BBBD643.jpg', '71C40895711B46989D02AACA574FC368', '2018-09-12 09:03:04');
INSERT INTO `sys_document` VALUES ('1DCC5C6DD955479291F66165B23B08D7', null, '1536539385685', '.jpg', '366416', '2', 'D:/fhgrid/docs/data/B3B99BDEEABA483F86A586EE8D511409/2833ED3B26824666B75AEB50772CE100.jpg', 'B3B99BDEEABA483F86A586EE8D511409', '2018-09-10 08:29:48');
INSERT INTO `sys_document` VALUES ('1ED677C7F6604CC8AF6D3137C6B5BE5A', null, '微信图片_20180907160917', '.jpg', '131250', '1', 'D:/fhgrid/docs/temp/2018-09-07/20ACC07EA5C140C8B3D7386B7F301DD4.jpg', null, '2018-09-07 16:09:41');
INSERT INTO `sys_document` VALUES ('1FF4A9C5AF4847FCBA6B15A634386F25', null, '617900401306458635', '.jpg', '974105', '1', 'D:/fhgrid/docs/temp/2018-09-10/70FCB8A35B22495D94B71E42EDFBFC8B.jpg', null, '2018-09-10 11:42:18');
INSERT INTO `sys_document` VALUES ('201718B971444A5CAC5D1CF4251DB72D', null, '9.11回龙阁漏水', '.jpg', '168650', '2', 'D:/fhgrid/docs/data/770A8C4B27E64A84B3703DF6B318E73A/07866C4A348A40438FFBFB10EE3BAC0B.jpg', '770A8C4B27E64A84B3703DF6B318E73A', '2018-09-11 15:07:46');
INSERT INTO `sys_document` VALUES ('21838A17086C4970A8EFD509D88B78D7', null, '1', '.jpg', '101613', '2', 'D:/fhgrid/docs/data/6D23A3A0877C41B898E85C8938DE56B1/0761331391734E07B0CA849BABAB9425.jpg', '6D23A3A0877C41B898E85C8938DE56B1', '2018-09-11 16:33:00');
INSERT INTO `sys_document` VALUES ('2190295F91ED4AFB87EA31D19298F10C', null, '1536567755640', '.jpg', '273855', '2', 'D:/fhgrid/docs/data/8DB38EE700754E7E9E961B4C3BDF3933/AA6B62181B3C4167B02239DDF409C746.jpg', '8DB38EE700754E7E9E961B4C3BDF3933', '2018-09-10 16:22:37');
INSERT INTO `sys_document` VALUES ('236C7470A4854164BB9D15F7DC54ABA7', null, '微信图片_20180910232301', '.jpg', '84741', '2', 'D:/fhgrid/docs/data/AD375F4709FE4722B1EF5A03929CE8F2/88BED79E006C404A89532376E2E5BDDA.jpg', 'AD375F4709FE4722B1EF5A03929CE8F2', '2018-09-10 23:15:15');
INSERT INTO `sys_document` VALUES ('290006ABD0754637A7B7CA4C88F3110D', null, '742701283099945429', '.jpg', '157279', '2', 'D:/fhgrid/docs/data/FB68F8D6CBFB47D293E31724E54C1E58/9FDC0B44929B4FAEB43DBB27CF14F944.jpg', 'FB68F8D6CBFB47D293E31724E54C1E58', '2018-09-12 10:24:27');
INSERT INTO `sys_document` VALUES ('2A7B94D4C3244CE489220F9D6B775B5A', null, 'Koala', '.jpg', '780831', '1', 'E:/fhgrid/docs/temp/2018-09-26/DA6BAD2A8B204865AB61DD2374A4B485.jpg', null, '2018-09-26 18:13:07');
INSERT INTO `sys_document` VALUES ('2A7CF2B8758343C8B37E7BAA7B0090B9', null, 'mmexport1536669646341', '.jpg', '142594', '2', 'D:/fhgrid/docs/data/7BE0EFBA9109441F909D3FA30E9524C5/DD67265109354ADDA69D9B1B2F4E968C.jpg', '7BE0EFBA9109441F909D3FA30E9524C5', '2018-09-11 20:54:48');
INSERT INTO `sys_document` VALUES ('2B65BF1DAEDE41CD86D6706A4302D917', null, '图片1', '.png', '785590', '1', 'D:/fhgrid/docs/temp/2018-09-06/388CB68EEEF64AE39693B9A764630610.png', null, '2018-09-06 21:09:06');
INSERT INTO `sys_document` VALUES ('2B9DADBB08004DC79DB808AF7F59A70F', null, 'ICON', '.png', '27354', '1', 'D:/fhgrid/docs/temp/2018-09-10/96E8C667CF1F4FC9A3ADCA8D882B4350.png', null, '2018-09-10 10:06:42');
INSERT INTO `sys_document` VALUES ('2E6B7863B11A4C68BC8F9AFF60902F99', null, '1536321593690', '.jpg', '861989', '2', 'D:/fhgrid/docs/data/2968297F70E64903A6EEA9BD7E8EF371/9DBDC3C5FCE142DDA06EACC41D841B45.jpg', '2968297F70E64903A6EEA9BD7E8EF371', '2018-09-07 19:59:53');
INSERT INTO `sys_document` VALUES ('2F04F25702244EC3937F15369BC1993A', null, '477517289273793389', '.jpg', '158638', '2', 'D:/fhgrid/docs/data/29C105891A754188AFD90460247BC733/40A39F3077444FD59CF4EE7B3DFDDD57.jpg', '29C105891A754188AFD90460247BC733', '2018-09-12 10:34:26');
INSERT INTO `sys_document` VALUES ('302D44E1F74F4C2CB8C447D5A8B270A9', null, '1536714774409', '.jpg', '828415', '2', 'D:/fhgrid/docs/data/0DB87CBC5E1448A7AF553B700DA33DC4/D2470EDCE5E14F0E8A7900639020CCB7.jpg', '0DB87CBC5E1448A7AF553B700DA33DC4', '2018-09-12 09:12:59');
INSERT INTO `sys_document` VALUES ('31830CFD663044DEBC0EDBB01277EEEB', null, '1536280720704', '.amr', '5382', '1', 'D:/fhgrid/docs/temp/2018-09-07/95E0443B08E94DC5BC1CE102685D481A.amr', null, '2018-09-07 08:38:51');
INSERT INTO `sys_document` VALUES ('32543E03FEB64D5E8C0C3AAD7021635E', null, '1536279945240', '.amr', '4774', '1', 'D:/fhgrid/docs/temp/2018-09-07/67066D3DD9E948F7AE1A7A73A783296E.amr', null, '2018-09-07 08:25:54');
INSERT INTO `sys_document` VALUES ('32EBD39C521C4244B993CC7405C2B655', null, 'QQ图片20170608094524', '.jpg', '71839', '1', 'D:/fhgrid/docs/temp/2018-09-06/2D34E04878F04F6C85906A174E82198C.jpg', null, '2018-09-06 16:21:48');
INSERT INTO `sys_document` VALUES ('34019B71A035460890B44A935C8C19D7', null, '910513385583982148', '.jpg', '698152', '1', 'D:/fhgrid/docs/temp/2018-09-10/EC92D681812843D8BC5E13644C851828.jpg', null, '2018-09-10 11:27:19');
INSERT INTO `sys_document` VALUES ('368AE4C62A3040DF858C1516212AA841', null, '1536720343261', '.jpg', '922919', '2', 'D:/fhgrid/docs/data/AC051A930B6947E4ABE5D7D74ABB3750/897A0998590B415B9EABC321AE60A133.jpg', 'AC051A930B6947E4ABE5D7D74ABB3750', '2018-09-12 10:45:51');
INSERT INTO `sys_document` VALUES ('37F3DB79822B4EEA9FF2BC43D82368A6', null, '1536663263686', '.jpg', '312416', '2', 'D:/fhgrid/docs/data/70C4FEE1FD214E50B9F368932B57BFF8/3245CFE0CE064D6093E45BB1E51E267E.jpg', '70C4FEE1FD214E50B9F368932B57BFF8', '2018-09-11 18:54:27');
INSERT INTO `sys_document` VALUES ('37FA310DE52542DF997432409D577C64', null, '85695003130476420', '.jpg', '215255', '2', 'D:/fhgrid/docs/data/A43C4D6BCE0942B49E2D647D4EE745B0/E466FF5DBE3D4F768CE81CD6C0384D1C.jpg', 'A43C4D6BCE0942B49E2D647D4EE745B0', '2018-09-11 13:34:05');
INSERT INTO `sys_document` VALUES ('39A3889AC4E64E4595C7A212F8FD3005', null, '1536278732854', '.amr', '4774', '1', 'D:/fhgrid/docs/temp/2018-09-07/A5C1607115754E9B88061224075E66DE.amr', null, '2018-09-07 08:05:42');
INSERT INTO `sys_document` VALUES ('3C396F33A9884604B4775462B69DFFCA', null, '694906072375905872', '.jpg', '112121', '2', 'D:/fhgrid/docs/data/6FA9CED0066346579D2094DB3249C911/AE740DDCF8064D26B89338CFE528ECAE.jpg', '6FA9CED0066346579D2094DB3249C911', '2018-09-10 11:35:06');
INSERT INTO `sys_document` VALUES ('3CD5ACE2AB4C44EB9B83BF492EAD3823', null, '1536893933304', '.jpg', '275618', '1', 'E:/fhgrid/docs/temp/2018-09-14/9AB779C43B5445FC909CB90D62206A8C.jpg', null, '2018-09-14 10:58:50');
INSERT INTO `sys_document` VALUES ('3D2FCA61E53D468E9C613ABCF4AC4D9D', null, 'psb', '.jpg', '286599', '2', 'D:/fhgrid/docs/data/CD8B16249B7849DB885B496DCFDD6EFA/AFC32CCD09704C91960AF50D9A831970.jpg', 'CD8B16249B7849DB885B496DCFDD6EFA', '2018-09-11 10:47:33');
INSERT INTO `sys_document` VALUES ('3D831EE8BBF24316B22891AE7A021A80', null, '1536476932314', '.jpg', '667067', '2', 'D:/fhgrid/docs/data/062E7EFFC7664353972744E96FCA093B/29B7412C6F0B4E5BB59337F2646213F1.jpg', '062E7EFFC7664353972744E96FCA093B', '2018-09-09 15:08:49');
INSERT INTO `sys_document` VALUES ('3DF5F114FB734835B67983659FEA9D6D', null, '1536559205360', '.jpg', '351652', '2', 'D:/fhgrid/docs/data/E041176630BD4C2E811FEEAB9104F48C/BA0664BD0DED44ABB1CA05B50C7B5556.jpg', 'E041176630BD4C2E811FEEAB9104F48C', '2018-09-10 14:00:03');
INSERT INTO `sys_document` VALUES ('3EAEFD35135745AA85121C90B224DF9B', null, '1536280385076', '.amr', '2918', '1', 'D:/fhgrid/docs/temp/2018-09-07/F709588E05A34D808E4A6E8124E75B83.amr', null, '2018-09-07 08:33:13');
INSERT INTO `sys_document` VALUES ('3ED36E25955344F2896906C9047A46F7', null, '微信图片_20180910231352', '.jpg', '97468', '2', 'D:/fhgrid/docs/data/BE7B576C528E4149B40F67007BB32214/A909654BECD5444BABE9FCC361F6D515.jpg', 'BE7B576C528E4149B40F67007BB32214', '2018-09-10 23:06:05');
INSERT INTO `sys_document` VALUES ('40D8192E50C844609A2CBC4B7FBA17C1', null, '703725863929439974', '.jpg', '227951', '2', 'D:/fhgrid/docs/data/6B351F04BB684E43B71D21CF0A48E63C/DEF3FB5853524B6B94170B5A08E592F0.jpg', '6B351F04BB684E43B71D21CF0A48E63C', '2018-09-11 17:41:21');
INSERT INTO `sys_document` VALUES ('42E95F01F5554D86AA72812E9FE062CE', null, '闪屏', '.png', '653777', '1', 'D:/fhgrid/docs/temp/2018-09-10/C6448CF35D63400FA031F205A575F9A0.png', null, '2018-09-10 11:04:14');
INSERT INTO `sys_document` VALUES ('4427C3AB34D944FE90E513164B230B6A', null, '微信图片_20180910152813', '.jpg', '92198', '2', 'D:/fhgrid/docs/data/6D33B68EEC804599BB8CA2C4FA766A3E/E5147E4212C14B6C830A5491469179DE.jpg', '6D33B68EEC804599BB8CA2C4FA766A3E', '2018-09-10 15:31:40');
INSERT INTO `sys_document` VALUES ('452808E3BCEB48B79E01EE000AA16782', null, '新申请低保', '.jpg', '103365', '2', 'D:/fhgrid/docs/data/70E87FB010C54203A13FAB830FE48FF8/634124A1047E4DE399844A7C351B3FE1.jpg', '70E87FB010C54203A13FAB830FE48FF8', '2018-09-10 11:19:57');
INSERT INTO `sys_document` VALUES ('477AF858D5DC48EAB10D0380C78AFE2A', null, '上户记录提交方法', '.jpg', '152236', '1', 'D:/fhgrid/docs/temp/2018-09-10/ABD19A16D4C54B84AF726BA89C649ACD.jpg', null, '2018-09-10 11:04:06');
INSERT INTO `sys_document` VALUES ('47ACF75BDA33489798993C80978D6055', null, 'QQ图片20180912094516', '.png', '15378', '2', 'D:/fhgrid/docs/data/oa_task_34/C04353794F424D2F9F0B295E4919ED08.png', 'oa_task_34', '2018-09-12 09:45:26');
INSERT INTO `sys_document` VALUES ('4846FE2EEAA64065B3E661E703247D9B', null, '1536559490724', '.jpg', '441758', '1', 'D:/fhgrid/docs/temp/2018-09-10/61C2FE8953A3423D97C18E054B96EFCF.jpg', null, '2018-09-10 14:04:51');
INSERT INTO `sys_document` VALUES ('4A6186EF22C84DCF89F54161E36750A3', null, '要点', '.txt', '304', '2', 'D:/fhgrid/docs/data/oa_task_work64/980D54471E6E43CA90D8B23194CB4C6A.txt', 'oa_task_work64', '2018-09-06 16:23:54');
INSERT INTO `sys_document` VALUES ('4AD2E0A676704DC485F8E17005FB9A03', null, '1536476550091', '.jpg', '186263', '2', 'D:/fhgrid/docs/data/6B46ED8C3A7A45FEA3396CBC620BB5E3/5B3111A7529E47EEBFD57FD80ABDCFFF.jpg', '6B46ED8C3A7A45FEA3396CBC620BB5E3', '2018-09-09 15:02:26');
INSERT INTO `sys_document` VALUES ('4B118E5218234042A37641535E1A14FE', null, '1536280745696', '.mp4', '1630324', '1', 'D:/fhgrid/docs/temp/2018-09-07/D39D45FF3B384E2891F6C0E2F271E8B2.mp4', null, '2018-09-07 08:39:22');
INSERT INTO `sys_document` VALUES ('51AFE2C91D7B47FCAB808414E83A9F23', null, '微信图片_20180910231935', '.jpg', '105669', '2', 'D:/fhgrid/docs/data/4689475201D74279A45C9819F28EFEA9/26DAC1EEA09B474C94698F26E4116A14.jpg', '4689475201D74279A45C9819F28EFEA9', '2018-09-10 23:10:09');
INSERT INTO `sys_document` VALUES ('51F4BAF8C5CD4564B9109A29CFFE6A02', null, '1536279491838', '.amr', '1958', '1', 'D:/fhgrid/docs/temp/2018-09-07/DA0EB6F6AD58422EBF347523605AAF91.amr', null, '2018-09-07 08:18:19');
INSERT INTO `sys_document` VALUES ('5AA0EE2CAFB846DDB26F137A4D432D46', null, '1536397014462', '.jpg', '667371', '2', 'D:/fhgrid/docs/data/F66EE95E03A44DEDA278448C3A61054D/20EC9EC24A2240C39C16EDBC09C219F4.jpg', 'F66EE95E03A44DEDA278448C3A61054D', '2018-09-08 16:56:51');
INSERT INTO `sys_document` VALUES ('5C50A0254E69473B9A523C2672996A4B', null, 'Tulips', '.jpg', '620888', '1', 'D:/fhgrid/docs/temp/2018-09-12/4426E892A5C341D085226026F281E4B9.jpg', null, '2018-09-12 16:03:35');
INSERT INTO `sys_document` VALUES ('5D783F37D2284CCA9903C5AD2F1E9F59', null, '12网格停车', '.jpg', '165135', '2', 'D:/fhgrid/docs/data/32754CA5D04B438EADAFCB3DBE131A7A/D0DAEE7E9EDF496E9F981D8AFECDE264.jpg', '32754CA5D04B438EADAFCB3DBE131A7A', '2018-09-11 15:56:15');
INSERT INTO `sys_document` VALUES ('5E4B8E1F8EC04CE58501F376780A56FB', null, '1536418166012', '.jpg', '534219', '2', 'D:/fhgrid/docs/data/E1FA87AA083D4208A791BCCB5839FE5C/39EF95A4611A48F3BC8E0343E74767CA.jpg', 'E1FA87AA083D4208A791BCCB5839FE5C', '2018-09-08 22:49:28');
INSERT INTO `sys_document` VALUES ('5E802E9C50C148DC8DD7167F1C65AE8D', null, '1537245834151', '.jpg', '400574', '1', 'E:/fhgrid/docs/temp/2018-09-18/A9A611F3600B4B218024FE9D251E1637.jpg', null, '2018-09-18 12:43:53');
INSERT INTO `sys_document` VALUES ('5FABD8A5686044D5969BA303D46C471B', null, 't01e687d9c1a0f515ea', '.jpg', '35245', '1', 'D:/fhgrid/docs/temp/2018-09-10/22CDB2FB773E442BABC558BA6266B715.jpg', null, '2018-09-10 12:58:52');
INSERT INTO `sys_document` VALUES ('608E457CDBBB4EE2A167B4953DECC43E', null, '1536658752611', '.jpg', '795227', '1', 'D:/fhgrid/docs/temp/2018-09-11/A1FE2834472E45909905F13A73A5AECD.jpg', null, '2018-09-11 17:39:17');
INSERT INTO `sys_document` VALUES ('62D6CF3FE58C4C629C6B7710844CF7AB', null, '1536642586153', '.jpg', '550161', '2', 'D:/fhgrid/docs/data/690E48A710DA4A76A7495C78A15BA51B/CF66EADD8DEF47C68761D72CF2E96BBA.jpg', '690E48A710DA4A76A7495C78A15BA51B', '2018-09-11 13:09:50');
INSERT INTO `sys_document` VALUES ('6458DFE52425494D9BE380B2EDFEE54C', null, 'QQ图片20170608094524', '.jpg', '71839', '2', 'D:/fhgrid/docs/data/6E62CD0FD5EF4BB8874FFB846499DC8B/D59320A9AB2642D5881BC1E561C51F0E.jpg', '6E62CD0FD5EF4BB8874FFB846499DC8B', '2018-09-06 16:09:56');
INSERT INTO `sys_document` VALUES ('6524003E32BF45BB80C8C528E00A0FCF', null, '1537243026700', '.jpg', '400574', '1', 'E:/fhgrid/docs/temp/2018-09-18/A94FB9692CC446B9B4DC6310692C29B0.jpg', null, '2018-09-18 11:57:06');
INSERT INTO `sys_document` VALUES ('6559B201D1F84E7ABDB3FA02311138DB', null, '微信图片_20180910225024', '.jpg', '75416', '1', 'D:/fhgrid/docs/temp/2018-09-10/373B2AFF36EC49D9988DB20FB1357F92.jpg', null, '2018-09-10 23:00:22');
INSERT INTO `sys_document` VALUES ('656EC6DEB94848D0AC6C360DB08E0D7E', null, '1536567179185', '.jpg', '1085889', '2', 'D:/fhgrid/docs/data/2458CFB5DCD24DB1A0A054CDFD9D4595/5FB59237A72446A6B97196BF5DAAE158.jpg', '2458CFB5DCD24DB1A0A054CDFD9D4595', '2018-09-10 16:13:02');
INSERT INTO `sys_document` VALUES ('6632FE13D4E94B3AB21203E95EF2C529', null, '1536737458670', '.jpg', '507714', '1', 'D:/fhgrid/docs/temp/2018-09-12/83A140744384404A8F4B95515F6E3A64.jpg', null, '2018-09-12 15:31:01');
INSERT INTO `sys_document` VALUES ('6901479AD8DA4F689B272172BCF7AE09', null, '732792718781795161', '.jpg', '84572', '2', 'D:/fhgrid/docs/data/83A29E32409244C89B96CF0718B2938C/601E3956F12840879424564B1F509E35.jpg', '83A29E32409244C89B96CF0718B2938C', '2018-09-12 08:36:19');
INSERT INTO `sys_document` VALUES ('6BEEFE33197B43419BA63E9E500E565F', null, '要点', '.txt', '0', '2', 'D:/fhgrid/docs/data/oa_task_25/5CBB514CB65E432FAFF652B0483DE091.txt', 'oa_task_25', '2018-09-06 11:03:56');
INSERT INTO `sys_document` VALUES ('6DFEFECF37BF404EAA75F2AA2CC3813B', null, '1536634667638', '.jpg', '717197', '2', 'D:/fhgrid/docs/data/E7224A182DF846AE82BB5425485C0BE2/91096498386049E58C6D713724F1047F.jpg', 'E7224A182DF846AE82BB5425485C0BE2', '2018-09-11 10:57:51');
INSERT INTO `sys_document` VALUES ('6FA965E9457D43B19F877FDB67B12E12', null, '1536280432437', '.amr', '3302', '1', 'D:/fhgrid/docs/temp/2018-09-07/12B630766F964930BE64A9C4BC61CC94.amr', null, '2018-09-07 08:34:00');
INSERT INTO `sys_document` VALUES ('739D52F943BE4FAB87A80A2B58FC3087', null, '吴军2', '.jpg', '69615', '1', 'D:/fhgrid/docs/temp/2018-09-10/65120453488D49488296A69875A3C30D.jpg', null, '2018-09-10 14:40:14');
INSERT INTO `sys_document` VALUES ('74A0EB89F0714ADB94C703F3FEDF8BBB', null, '1536658837129', '.jpg', '795227', '2', 'D:/fhgrid/docs/data/739130F7BCAE454B8DFCA99AE2B5687F/8EE03E91627E4D50A286E98B165702DC.jpg', '739130F7BCAE454B8DFCA99AE2B5687F', '2018-09-11 17:40:42');
INSERT INTO `sys_document` VALUES ('74F8BA5A2DE841079914566316931A9D', null, '禾库镇村级网格数差异统计表', '.docx', '12774', '2', 'D:/fhgrid/docs/data/oa_task_work52/D3ABEF08AE3B4669AFEDE534501502E1.docx', 'oa_task_work52', '2018-09-11 15:40:32');
INSERT INTO `sys_document` VALUES ('74F91DCD35A4464FB8398FBEA85D07DA', null, '2', '.jpg', '168947', '2', 'D:/fhgrid/docs/data/4212DBC373BB48A884356DBDCE91DE9B/2AE906418D5E4AE28F5B9738D93395F1.jpg', '4212DBC373BB48A884356DBDCE91DE9B', '2018-09-10 11:58:36');
INSERT INTO `sys_document` VALUES ('765ADBB562344DB79BE6927DC1B6196E', null, '1536584326403', '.jpg', '1355574', '2', 'D:/fhgrid/docs/data/618DE43D2C6443E98A7B8ABB66F47247/0517DB338E9A4C349ADB953599D48628.jpg', '618DE43D2C6443E98A7B8ABB66F47247', '2018-09-10 20:58:50');
INSERT INTO `sys_document` VALUES ('7A62145194A846549C73AB1015D0C449', null, 'psb', '.jpg', '171680', '2', 'D:/fhgrid/docs/data/07E7B955367D44929B74E3803BCA8462/7DFE925B876C4776AF52D5B964BD9DB3.jpg', '07E7B955367D44929B74E3803BCA8462', '2018-09-11 15:25:18');
INSERT INTO `sys_document` VALUES ('7D25149D8CB64CB291F7CE17F0EB65E5', null, '1536805579908', '.jpg', '34537', '2', 'E:/fhgrid/docs/data/oa_virtual_people28/9387ABC666304151A2B124FAB4127224.jpg', 'oa_virtual_people28', '2018-09-13 10:26:18');
INSERT INTO `sys_document` VALUES ('7E8DE35AAAFD4A3B9FCDCCF1C71CA710', null, 'mmexport1536669650058', '.jpg', '423385', '2', 'D:/fhgrid/docs/data/1BDB05D0D9884B11A6151962B567B598/AD66687D879A4847AC3D1DA57E80A098.jpg', '1BDB05D0D9884B11A6151962B567B598', '2018-09-11 20:58:48');
INSERT INTO `sys_document` VALUES ('808776D532B048459DFBC8D1857D0834', null, 'psb (1)', '.jpg', '170728', '2', 'D:/fhgrid/docs/data/F54EE4D0DAC94DB99B6870CF628FF4E3/B343A0DC177349C9A2510AD43EDB04AD.jpg', 'F54EE4D0DAC94DB99B6870CF628FF4E3', '2018-09-10 11:42:16');
INSERT INTO `sys_document` VALUES ('81540A3F872E45B999516FB22D38005C', null, 'psb', '.jpg', '718530', '1', 'D:/fhgrid/docs/temp/2018-09-11/F14D05C251254CB984638C15EE0424D5.jpg', null, '2018-09-11 15:28:16');
INSERT INTO `sys_document` VALUES ('81C789454B284E05B342144AF27A84AB', null, '1536714885343', '.jpg', '878536', '2', 'D:/fhgrid/docs/data/1D92D91A532243C48C1F979A321B2A89/E5EF5D70F1DA4E7AA420CBF0B01F0E06.jpg', '1D92D91A532243C48C1F979A321B2A89', '2018-09-12 09:14:50');
INSERT INTO `sys_document` VALUES ('82DCE05E76B64AE8A12FFA297FDEA619', null, '2d7e308e1aaf72f592d38f9852e57ef', '.png', '462631', '2', 'D:/fhgrid/docs/data/B8590A7FDB1645A6A6A5F189D21398D7/4FDAFADE9B2646F28FB4911A788AFE41.png', 'B8590A7FDB1645A6A6A5F189D21398D7', '2018-09-11 15:32:38');
INSERT INTO `sys_document` VALUES ('82FB21526D064146B369E887720B62BA', null, '88802801992948053', '.jpg', '81047', '1', 'D:/fhgrid/docs/temp/2018-09-07/B4931EABED0B4B1CADF0DA288AF6A004.jpg', null, '2018-09-07 16:22:30');
INSERT INTO `sys_document` VALUES ('834A5B8B870C423EAAB41E154064C55F', null, '9.10调解', '.jpg', '92714', '2', 'D:/fhgrid/docs/data/694351A1FBF44418AC8F6438C86E286E/D7D27D69359E4A37A560E78606967EB7.jpg', '694351A1FBF44418AC8F6438C86E286E', '2018-09-11 09:01:52');
INSERT INTO `sys_document` VALUES ('83707D95CA6C41B297DCB32286B5BFCA', null, '254202826455079084', '.jpg', '175078', '2', 'D:/fhgrid/docs/data/B1C6AABE85394235AFCCA3D11FECAD8F/C6B0AD79649B4FB99238CB15FF0C6BEE.jpg', 'B1C6AABE85394235AFCCA3D11FECAD8F', '2018-09-10 10:41:27');
INSERT INTO `sys_document` VALUES ('859C9D29445348A094720A578B40F0E8', null, '1536321387488', '.jpg', '658426', '2', 'D:/fhgrid/docs/data/6BC9AB0ED7AA4A4ABFFCE13AB6EB2D8B/9F138763CBF4448FB4412B0087D00E16.jpg', '6BC9AB0ED7AA4A4ABFFCE13AB6EB2D8B', '2018-09-07 19:56:27');
INSERT INTO `sys_document` VALUES ('870F83FB6D2E49578AB705FBFC518716', null, '1536485097703', '.jpg', '655939', '2', 'D:/fhgrid/docs/data/B8E9B77A1482401F8B926166C22B1519/51909262D2E749CBB8B224D980BD22E1.jpg', 'B8E9B77A1482401F8B926166C22B1519', '2018-09-09 17:24:58');
INSERT INTO `sys_document` VALUES ('87A8B5CE1F684D30A4C41A1167A5E81B', null, '1536805190671', '.jpg', '275618', '1', 'E:/fhgrid/docs/temp/2018-09-13/16C92EFBFE1C4C76B48CB40332FFA701.jpg', null, '2018-09-13 10:19:49');
INSERT INTO `sys_document` VALUES ('891D9C4902A94AB6BEA306FF8365D5F5', null, '1536803731678', '.jpg', '275618', '2', 'E:/fhgrid/docs/data/oa_virtual_people5/A58176745F424662BF5B854395B25533.jpg', 'oa_virtual_people5', '2018-09-13 09:55:30');
INSERT INTO `sys_document` VALUES ('8C2E1442C4364386AA7FB44C0975C31A', null, '399873969832304703', '.jpg', '94834', '2', 'D:/fhgrid/docs/data/E9BC9571EE814812B0B273B2AEC9D71A/0B0DE7CD4E99481E9B42A0B4F56E2445.jpg', 'E9BC9571EE814812B0B273B2AEC9D71A', '2018-09-12 10:51:40');
INSERT INTO `sys_document` VALUES ('8D5753411FDA40CB868DF3FCA4F66B25', null, '1536673093425', '.jpg', '1106116', '1', 'D:/fhgrid/docs/temp/2018-09-11/E8367761B24D4CF58DB5A46BE4E44027.jpg', null, '2018-09-11 21:39:00');
INSERT INTO `sys_document` VALUES ('8DCF13BB4C634A128979BF68E2DFA997', null, '1536652667778', '.jpg', '832346', '2', 'D:/fhgrid/docs/data/2D2F097B8B3D45CFBAD65B094BF950A6/7313281DB4A44AD4985107776CD70BDD.jpg', '2D2F097B8B3D45CFBAD65B094BF950A6', '2018-09-11 15:57:52');
INSERT INTO `sys_document` VALUES ('8E28CF96A5FF4FB190488C0FDD29DFFB', null, 'mmexport1536669635194', '.jpg', '168773', '2', 'D:/fhgrid/docs/data/910D66455DDF41CE9F3B6FA6D9299E41/4B2AC5C72ADF401CBD6C44119CCBF385.jpg', '910D66455DDF41CE9F3B6FA6D9299E41', '2018-09-11 20:45:10');
INSERT INTO `sys_document` VALUES ('8F1777C04F504AB9AF7ED5E194AB9903', null, '1536321991299', '.jpg', '295385', '1', 'D:/fhgrid/docs/temp/2018-09-07/03D9C19F85AC4DD58BCC3C7FA38776EC.jpg', null, '2018-09-07 20:06:30');
INSERT INTO `sys_document` VALUES ('90550CAA286F4CD9AEBCDE049F6D6C76', null, 'u=2281195109,2436880366&fm=27&gp=0', '.jpg', '36137', '2', 'D:/fhgrid/docs/data/2FCAAE10D40E4628B7322C1A445A6453/C0DA8E194B7E4D1D9A0AD21B1F604AEB.jpg', '2FCAAE10D40E4628B7322C1A445A6453', '2018-09-10 12:25:06');
INSERT INTO `sys_document` VALUES ('90FDC5CA565C4D81930425337942A78A', null, 'psb', '.jpg', '373931', '2', 'D:/fhgrid/docs/data/70206C5767774B818778FF8CACE3ED36/5EFF3F0F93B240558344CEAEDB6F2645.jpg', '70206C5767774B818778FF8CACE3ED36', '2018-09-10 11:22:13');
INSERT INTO `sys_document` VALUES ('91B005EF407043F6903164F5B4292EB5', null, '1536742911289', '.jpg', '331016', '2', 'D:/fhgrid/docs/data/FB0285B5E7594DEF843E069FCE460139/9BE05BE83029408A88B38A8B3D8CA5BF.jpg', 'FB0285B5E7594DEF843E069FCE460139', '2018-09-12 17:01:54');
INSERT INTO `sys_document` VALUES ('91BC81DE09E74B1CB50876520E602D9A', null, 'Tulips', '.jpg', '620888', '1', 'D:/fhgrid/docs/temp/2018-09-12/E06ED5974DD24CE2B1EA899D327BAC9C.jpg', null, '2018-09-12 16:03:08');
INSERT INTO `sys_document` VALUES ('97077A0F3815423F88E4116330CD0234', null, '1536280066353', '.amr', '4646', '1', 'D:/fhgrid/docs/temp/2018-09-07/9FE5C3130CB049C4BEA58DBB12EBF46F.amr', null, '2018-09-07 08:27:55');
INSERT INTO `sys_document` VALUES ('98006A45BD924751AD557A7435CE4127', null, '1536803481611', '.jpg', '864512', '1', 'E:/fhgrid/docs/temp/2018-09-13/A7291893D0754CF8905A0F8CA7905967.jpg', null, '2018-09-13 09:51:20');
INSERT INTO `sys_document` VALUES ('989DFA239B7E4A3AA0698D94AFECC6EE', null, 'ld', '.jpg', '95129', '2', 'D:/fhgrid/docs/data/B90F45805FB04DD2A1F69A3C5B9903B7/3C00749ECDD84E2588BFA9106C907402.jpg', 'B90F45805FB04DD2A1F69A3C5B9903B7', '2018-09-10 10:59:08');
INSERT INTO `sys_document` VALUES ('98B888489A8148A19ADF08788A5D8136', null, '1536278446427', '.amr', '4934', '1', 'D:/fhgrid/docs/temp/2018-09-07/BF055F24C1D6481AA892397680E2C3D3.amr', null, '2018-09-07 08:00:56');
INSERT INTO `sys_document` VALUES ('98E9D14F169B433D96D40E47A75147AC', null, '519347104863214643', '.jpg', '167915', '2', 'D:/fhgrid/docs/data/1F866D1DF5574B679156A5B5D58B35F5/5DC801B8E3EA400590719782D75102F1.jpg', '1F866D1DF5574B679156A5B5D58B35F5', '2018-09-11 14:35:18');
INSERT INTO `sys_document` VALUES ('995F23A54069478ABFFBFD4D70AF17E9', null, '1536673106603', '.jpg', '1001869', '1', 'D:/fhgrid/docs/temp/2018-09-11/B342D0F124FC4700BEF5878733596E97.jpg', null, '2018-09-11 21:39:33');
INSERT INTO `sys_document` VALUES ('9F3701D30EF84D25AFC596D1FD296538', null, '1536552446527', '.jpg', '896436', '1', 'D:/fhgrid/docs/temp/2018-09-10/AF64FE452B0040C0AC7978E75DBA9E3B.jpg', null, '2018-09-10 12:07:59');
INSERT INTO `sys_document` VALUES ('A239ED62ADC742EF83C790B3A73570DA', null, '1536673177940', '.jpg', '1106116', '1', 'D:/fhgrid/docs/temp/2018-09-11/8DDB3BCBCCC54B758FFBA754477C3CC3.jpg', null, '2018-09-11 21:41:09');
INSERT INTO `sys_document` VALUES ('A327DDC5BD454B1AB23FF19D0B6FCF96', null, '1536321241301', '.jpg', '999940', '2', 'D:/fhgrid/docs/data/737C1F8A0F78431C8BB89207BB4D36B8/4C066DEAE33044C1A4B5C6FF1824DA9B.jpg', '737C1F8A0F78431C8BB89207BB4D36B8', '2018-09-07 19:54:01');
INSERT INTO `sys_document` VALUES ('A536ACAF9C4B4D57B7BC38E2550DECFA', null, '1536418142917', '.jpg', '564434', '2', 'D:/fhgrid/docs/data/E1FA87AA083D4208A791BCCB5839FE5C/051A0EEA4C5943A38525878CFEDF2E92.jpg', 'E1FA87AA083D4208A791BCCB5839FE5C', '2018-09-08 22:49:06');
INSERT INTO `sys_document` VALUES ('A54A4B14F67D4721BB0998AA42DE3709', null, '1536321108522', '.jpg', '533962', '2', 'D:/fhgrid/docs/data/BDBE4765A590490E99264FF43B77259E/5D0F5C0457A14A95B759924ECC017E64.jpg', 'BDBE4765A590490E99264FF43B77259E', '2018-09-07 19:51:48');
INSERT INTO `sys_document` VALUES ('A5717A3AB4654496ADA202B41A5B8A5A', null, '1536418156717', '.jpg', '539084', '2', 'D:/fhgrid/docs/data/E1FA87AA083D4208A791BCCB5839FE5C/4800416D8CD240C8A01A4336871CE8B9.jpg', 'E1FA87AA083D4208A791BCCB5839FE5C', '2018-09-08 22:49:18');
INSERT INTO `sys_document` VALUES ('A5B0EB45B5A847A88FED91341A4E0C0F', null, '1536280403918', '.jpg', '794400', '1', 'D:/fhgrid/docs/temp/2018-09-07/51EE4BE23D2B44259C6A254E7F28C2AD.jpg', null, '2018-09-07 08:33:33');
INSERT INTO `sys_document` VALUES ('A61E96AD3C094A1CA089DD8390704962', null, '微信图片_20180911101242', '.jpg', '73935', '2', 'D:/fhgrid/docs/data/DEC25D6F7F3B47709D3644E716655B9C/6CED283B0F234570AA6F596DEE138496.jpg', 'DEC25D6F7F3B47709D3644E716655B9C', '2018-09-11 10:16:25');
INSERT INTO `sys_document` VALUES ('A6E53F7C19DA48718AF1DB0486B19272', null, '微信图片_20180910152706', '.jpg', '265387', '2', 'D:/fhgrid/docs/data/4710B2E18CEF4795A46990D4ACDEC246/E0DCF547267B41EE983055E165D3DCA4.jpg', '4710B2E18CEF4795A46990D4ACDEC246', '2018-09-10 15:36:17');
INSERT INTO `sys_document` VALUES ('A898632558BD4A0F89CCA350FF50C6FF', null, '1536476304562', '.jpg', '264392', '2', 'D:/fhgrid/docs/data/3EDB5C51A5C340DAB468927B2E52D6BB/3DE53B4E942840759A57F0D5864E55D5.jpg', '3EDB5C51A5C340DAB468927B2E52D6BB', '2018-09-09 14:58:21');
INSERT INTO `sys_document` VALUES ('A93EADAF747F4CE187AD5D1A5313B690', null, '1536649182803', '.jpg', '909831', '1', 'D:/fhgrid/docs/temp/2018-09-11/7D8FF5B1A0A744A0B52A202853968DE9.jpg', null, '2018-09-11 14:59:50');
INSERT INTO `sys_document` VALUES ('ABE3AA9C70E34A49A234887131281E01', null, '微信图片_20180907160923', '.jpg', '125806', '1', 'D:/fhgrid/docs/temp/2018-09-07/6E32B80A28AC4C7EA2B86C52B69DE930.jpg', null, '2018-09-07 16:09:47');
INSERT INTO `sys_document` VALUES ('ABF472E04A0C4D9784935CC662C86B1C', null, '1536671060964', '.jpg', '322735', '2', 'D:/fhgrid/docs/data/40B36EAA3F324EB39139C82A04DA1F22/5E2CD5DB3E234FB18C20CF0B930C5800.jpg', '40B36EAA3F324EB39139C82A04DA1F22', '2018-09-11 21:04:24');
INSERT INTO `sys_document` VALUES ('AF5A493218954F5189C73E52191FE3D3', null, '1536649025127', '.jpg', '1431291', '2', 'D:/fhgrid/docs/data/A57A1D0F892A48E889D2BE04E8D7DC6C/9DDE690B568C42F195E55A03E954973B.jpg', 'A57A1D0F892A48E889D2BE04E8D7DC6C', '2018-09-11 14:57:11');
INSERT INTO `sys_document` VALUES ('B3211B15E962445BA53E5A754EFE492D', null, '巡查', '.jpg', '114964', '2', 'D:/fhgrid/docs/data/7E493262AA4D4B5CA4EAF23A08EB2DEB/2502FFFA0484495B825DC3BA8BE18AF3.jpg', '7E493262AA4D4B5CA4EAF23A08EB2DEB', '2018-09-10 11:38:25');
INSERT INTO `sys_document` VALUES ('B3D62EC02FD54AD8A6F54827957B6E9B', null, '1536552382169', '.jpg', '720175', '2', 'D:/fhgrid/docs/data/40E0B38EE78C4FA083B88CAA9E4B793F/682F253E902C40F6ACE9439364CCF04B.jpg', '40E0B38EE78C4FA083B88CAA9E4B793F', '2018-09-10 12:06:24');
INSERT INTO `sys_document` VALUES ('B40142C9FF894960A11059CBC3335390', null, '151506526968257571', '.jpg', '162482', '2', 'D:/fhgrid/docs/data/7918C8215CB240069511390CD5DE6E9B/097D5D70673A4201B0BCEE882AB19CE2.jpg', '7918C8215CB240069511390CD5DE6E9B', '2018-09-12 08:41:43');
INSERT INTO `sys_document` VALUES ('B52EF4D0A0AA456BA3BDE4EBDB587D53', null, '微信图片_20180910225113', '.jpg', '113562', '2', 'D:/fhgrid/docs/data/4ED9046EC2664F9FACBD8CCFD96C9F2E/32B411C0EE274929AA71E49A8870386E.jpg', '4ED9046EC2664F9FACBD8CCFD96C9F2E', '2018-09-10 23:01:55');
INSERT INTO `sys_document` VALUES ('B9CA241336004E92897BE6A864DFB39A', null, '微信图片_20180911105806', '.jpg', '56205', '2', 'D:/fhgrid/docs/data/3176FE6853E24EBBAD436BD0023F2E6C/F9B7A31D6E694176966CD6594B3D6222.jpg', '3176FE6853E24EBBAD436BD0023F2E6C', '2018-09-11 10:57:37');
INSERT INTO `sys_document` VALUES ('BA9C924436C94B869CFB52D10CFCA23C', null, '1536388415251', '.jpg', '497834', '2', 'D:/fhgrid/docs/data/5D46A571068041FFA2BAD234A9719B7B/093098C737DB494EB4C92BC89571C387.jpg', '5D46A571068041FFA2BAD234A9719B7B', '2018-09-08 14:33:34');
INSERT INTO `sys_document` VALUES ('BC3DE4A143A242AD91844F974BA95CB6', null, '微信图片_20180908211139', '.jpg', '97547', '2', 'D:/fhgrid/docs/data/A74EAE2F736248BB8F0A880132CBEFB4/90B8CB5CB2544CA2A7D69C95622471E9.jpg', 'A74EAE2F736248BB8F0A880132CBEFB4', '2018-09-10 22:51:46');
INSERT INTO `sys_document` VALUES ('BC6040BE85154FC29CCFC831B97749AE', null, '1536278863544', '.amr', '2566', '1', 'D:/fhgrid/docs/temp/2018-09-07/D7E2B0B224D9400E8F7181BA195951C5.amr', null, '2018-09-07 08:07:51');
INSERT INTO `sys_document` VALUES ('BD2B7598C29B4ED787C46612D70A3718', null, '1536673194577', '.jpg', '1106116', '1', 'D:/fhgrid/docs/temp/2018-09-11/56830C5791C245AA8E0FAC82A1D62462.jpg', null, '2018-09-11 21:41:13');
INSERT INTO `sys_document` VALUES ('BE9961D00A1F4E1FB2B52EE959902692', null, '879489818846143769', '.jpg', '132753', '2', 'D:/fhgrid/docs/data/1B018053AAF746AA90FCF469A0A8377E/3609A42DE0C54454B055ED7699D060F1.jpg', '1B018053AAF746AA90FCF469A0A8377E', '2018-09-12 10:42:28');
INSERT INTO `sys_document` VALUES ('BF1C2930112A4AD99D9525131D113319', null, '1536320902513', '.jpg', '1008115', '2', 'D:/fhgrid/docs/data/F31602E3931246BB84F166E2D89D6325/8A7ACAD8F4FC468AA81ECC87B744CCB0.jpg', 'F31602E3931246BB84F166E2D89D6325', '2018-09-07 19:48:22');
INSERT INTO `sys_document` VALUES ('C2A1FFDEF07649F8B21D8260EE2FCFA2', null, '344873365812411638', '.jpg', '234984', '2', 'D:/fhgrid/docs/data/A73E79A1EFC7494AAD463797B7ADD041/C27E0A5EBC634E9D904E1CDD0AEDAA58.jpg', 'A73E79A1EFC7494AAD463797B7ADD041', '2018-09-11 11:21:26');
INSERT INTO `sys_document` VALUES ('C3C8178622DE4040B9EF4CF53A033FD9', null, 'mmexport1536669641491', '.jpg', '78218', '2', 'D:/fhgrid/docs/data/77C664760F1A407AA4467ECC573D9DF9/DE0143AAAB594D9BA55A66285820FA2A.jpg', '77C664760F1A407AA4467ECC573D9DF9', '2018-09-11 20:50:49');
INSERT INTO `sys_document` VALUES ('C413892B74E34A68A97DEA388D4F0CE3', null, 'Hydrangeas', '.jpg', '595284', '1', 'E:/fhgrid/docs/temp/2018-09-28/8899678B73544C9EB6B016F49EA94F10.jpg', null, '2018-09-28 11:10:18');
INSERT INTO `sys_document` VALUES ('C58192752A0348A3BC61E92ACAC5F5B8', null, '7网格', '.jpg', '84827', '2', 'D:/fhgrid/docs/data/3F1140FE77E64279898E35784729F9C4/2E0943C3E8824F9E827C47E70931D623.jpg', '3F1140FE77E64279898E35784729F9C4', '2018-09-11 16:37:59');
INSERT INTO `sys_document` VALUES ('C88B0784C3E6480D8C14B5A6DD636110', null, '1536476698337', '.jpg', '275280', '2', 'D:/fhgrid/docs/data/DD68194DCE6447B0B5951E35DA4123D7/E5DE08D917B94255AF95446A0C0BC44D.jpg', 'DD68194DCE6447B0B5951E35DA4123D7', '2018-09-09 15:04:55');
INSERT INTO `sys_document` VALUES ('C97536F62EAF4812A502356A1068949A', null, '1536649324950', '.jpg', '745760', '2', 'D:/fhgrid/docs/data/D2BFB0CEF28742208201DC08F240087D/AC8A49D90030477B8F748CB75B73D662.jpg', 'D2BFB0CEF28742208201DC08F240087D', '2018-09-11 15:02:09');
INSERT INTO `sys_document` VALUES ('CCB82210725F47B39A9D33D52CE8C1FC', null, '2_万能看图王', '.jpg', '862067', '2', 'D:/fhgrid/docs/data/71C40895711B46989D02AACA574FC368/14D2AB5426F24EBD913D6F15A4F952E5.jpg', '71C40895711B46989D02AACA574FC368', '2018-09-12 09:04:10');
INSERT INTO `sys_document` VALUES ('CD600E93694C4444BFAE532ABB838BE3', null, '1537246220287', '.jpg', '680916', '2', 'E:/fhgrid/docs/data/102885/FE894C3188574ED5B8266FF0ACCE0D2A.jpg', '102885', '2018-09-18 12:50:21');
INSERT INTO `sys_document` VALUES ('CD70BC11CE0E4B7C8451D7E2D48826E6', null, '1536825438829', '.jpg', '606787', '1', 'E:/fhgrid/docs/temp/2018-09-13/7D56E85BE65F4583A88D52CB7A35D187.jpg', null, '2018-09-13 15:57:18');
INSERT INTO `sys_document` VALUES ('CDD45F3B095B46509ACDE3FDDBF38D2B', null, '88802801992948053', '.jpg', '81047', '2', 'D:/fhgrid/docs/data/912446D0D4734511BDAA644D31840C58/6CEDF3DFDC29470DBAA2364B228987BA.jpg', '912446D0D4734511BDAA644D31840C58', '2018-09-10 11:22:22');
INSERT INTO `sys_document` VALUES ('CF07D5DEA5694356A7C6509944EE45B2', null, '131918464865377105', '.jpg', '305636', '2', 'D:/fhgrid/docs/data/07B6BF4E627E4699B8C8177B80AEBF1D/67FB5F7033264CCEBC963815AB3D510F.jpg', '07B6BF4E627E4699B8C8177B80AEBF1D', '2018-09-12 10:17:43');
INSERT INTO `sys_document` VALUES ('D03C94C64A6A45BE9F9CDF085EC2F44D', null, 'psb', '.jpg', '306857', '2', 'D:/fhgrid/docs/data/FB9E163D93E4447D9F8D2BB4DC156201/33BB35B1868A4E71A8F8A8B57E7B49A2.jpg', 'FB9E163D93E4447D9F8D2BB4DC156201', '2018-09-10 11:12:00');
INSERT INTO `sys_document` VALUES ('D2529DCF02084758BAA5C4C4EB9F406D', null, '1536548698922', '.jpg', '67883', '2', 'D:/fhgrid/docs/data/2C7BD84C70BC4E7CBC7A859B8DC6AECF/C8366CEACB6642008AC1506AA3003409.jpg', '2C7BD84C70BC4E7CBC7A859B8DC6AECF', '2018-09-10 11:05:04');
INSERT INTO `sys_document` VALUES ('D2AC23365DDC44DD9652C8C069E04CF4', null, 'psb', '.jpg', '402488', '2', 'D:/fhgrid/docs/data/7B232526EFAB48D1911C5F45F435BEFD/D59E92A767564FA69D18CA9E8CAEDC15.jpg', '7B232526EFAB48D1911C5F45F435BEFD', '2018-09-10 11:08:01');
INSERT INTO `sys_document` VALUES ('D4C158725F0F46ED8DF3E8746EEF6856', null, '1537244696717', '.jpg', '400574', '1', 'E:/fhgrid/docs/temp/2018-09-18/FF32AA74A7404467A0BF8D27910EC805.jpg', null, '2018-09-18 12:24:56');
INSERT INTO `sys_document` VALUES ('D6E2A3FD6031425883D50510D9DC30C5', null, 'psb', '.jpg', '158276', '2', 'D:/fhgrid/docs/data/F9019BFC43AA40CFB905959288FB60BA/F631B97D2A5A42688777C8B47263D34E.jpg', 'F9019BFC43AA40CFB905959288FB60BA', '2018-09-10 11:25:25');
INSERT INTO `sys_document` VALUES ('D766FD402F4F4678A979C095677AF5B3', null, 'psb', '.jpg', '362697', '2', 'D:/fhgrid/docs/data/D4376122560440F18490671A2DCCD9C9/FE171D68738A4EF0A36FBF99425449A5.jpg', 'D4376122560440F18490671A2DCCD9C9', '2018-09-10 11:38:20');
INSERT INTO `sys_document` VALUES ('D8CF478C42A1446B8088C75D959918DB', null, '微信图片_20180911101242', '.jpg', '73935', '2', 'D:/fhgrid/docs/data/5E8B274E48144353B1CA96C02A9A579B/53FEBC118CE64C8D97D0C7BCE9557A85.jpg', '5E8B274E48144353B1CA96C02A9A579B', '2018-09-11 10:20:47');
INSERT INTO `sys_document` VALUES ('D9FCDE3E2CF84702A3557DA2B2583D8D', null, '微信图片_20180910231603', '.jpg', '76188', '2', 'D:/fhgrid/docs/data/CD39176939D94AABBB49EB5FE7A55DED/44A8640464BB43B5871C27BE1619AE7B.jpg', 'CD39176939D94AABBB49EB5FE7A55DED', '2018-09-10 23:07:34');
INSERT INTO `sys_document` VALUES ('DB944110D2B94BFCA3774B87BD78B03B', null, '1536673151319', '.jpg', '965925', '1', 'D:/fhgrid/docs/temp/2018-09-11/DF1EC94812AA400E90B098A42DC50D65.jpg', null, '2018-09-11 21:40:39');
INSERT INTO `sys_document` VALUES ('DEC85D4012354FED82A4DC8BF62D9806', null, '1536737956546', '.jpg', '507714', '2', 'D:/fhgrid/docs/data/CAF9BB6910794730A49CA0B863F8A6DE/6D82D65F6C01446399CBA64DEB58B211.jpg', 'CAF9BB6910794730A49CA0B863F8A6DE', '2018-09-12 15:39:19');
INSERT INTO `sys_document` VALUES ('E17918DDA54A4538B417B5D41E8670A0', null, 'mmexport1530857557691', '.jpg', '104065', '2', 'D:/fhgrid/docs/data/9D17F0B6592C409E837D01C6CE34F046/7CA57BDA8AF54B9889B5387CD7F61C24.jpg', '9D17F0B6592C409E837D01C6CE34F046', '2018-09-10 08:28:02');
INSERT INTO `sys_document` VALUES ('E197369B1C954C5BB1AFBD733EEA4100', null, '1536803192147', '.jpg', '275618', '1', 'E:/fhgrid/docs/temp/2018-09-13/D64A203BDDA4447B8BC44EAA32F27AC9.jpg', null, '2018-09-13 09:46:30');
INSERT INTO `sys_document` VALUES ('E311BE1C84544AB58284F6782F036A13', null, '要点', '.txt', '0', '2', 'D:/fhgrid/docs/data/oa_task_work60/D7AA70AE9FE548669C32AB073E8FEEDE.txt', 'oa_task_work60', '2018-09-06 11:04:57');
INSERT INTO `sys_document` VALUES ('E356DF54C84A401CAB0A7FD8A7E505C6', null, '1536673165826', '.jpg', '936480', '1', 'D:/fhgrid/docs/temp/2018-09-11/6EDD9CE92A7A4A4EB462EF3E0407C445.jpg', null, '2018-09-11 21:40:54');
INSERT INTO `sys_document` VALUES ('E5C4F5C35A4F4672A5287022F43DCCAC', null, '1536552834711', '.jpg', '988536', '1', 'D:/fhgrid/docs/temp/2018-09-10/ECFC4D3BDF014DB6A213C6B25E872E88.jpg', null, '2018-09-10 12:13:58');
INSERT INTO `sys_document` VALUES ('E79C66C9E1984329ACC35E7EE69386AD', null, '凤凰县网格化编码表（木江坪镇）', '.xls', '45568', '2', 'D:/fhgrid/docs/data/oa_task_work50/5C904A026AA04890B0EBB2B8D11B2972.xls', 'oa_task_work50', '2018-09-08 17:28:52');
INSERT INTO `sys_document` VALUES ('E91E7EF963AA4887ACF9BAD28D513CB0', null, 'QQ图片20170608094524', '.jpg', '71839', '2', 'D:/fhgrid/docs/data/oa_gridActivity_2/5237BB30EC1A4AE4B3910636ED950DB5.jpg', 'oa_gridActivity_2', '2018-09-06 16:29:16');
INSERT INTO `sys_document` VALUES ('E9CD7634016847FB838C091457F43DBA', null, '203582986486882569', '.jpg', '133157', '2', 'D:/fhgrid/docs/data/711C845FB7034F8884001292E976CAB0/32357B23693144188BCE3DB88648ACB7.jpg', '711C845FB7034F8884001292E976CAB0', '2018-09-12 09:44:56');
INSERT INTO `sys_document` VALUES ('EC1261751E8C440898A43743EAC1CD1F', null, 'psb', '.jpg', '594223', '2', 'D:/fhgrid/docs/data/104E5ABF557C4C02B94330D2C5E416EF/949AA29561E54FB6A8BC90F3C3005552.jpg', '104E5ABF557C4C02B94330D2C5E416EF', '2018-09-10 14:43:19');
INSERT INTO `sys_document` VALUES ('EF29629BDD9B4F7F8423CD905E06BF47', null, '480273544636788748', '.jpg', '139845', '2', 'D:/fhgrid/docs/data/8332944BF1EC4BD49A9D478CB527A451/A222A09775E8422191C5BB40D82E0588.jpg', '8332944BF1EC4BD49A9D478CB527A451', '2018-09-12 09:50:25');
INSERT INTO `sys_document` VALUES ('F1C07300C4D049EFAD3A19010947A686', null, '1537243089110', '.jpg', '400574', '1', 'E:/fhgrid/docs/temp/2018-09-18/04B062C340704503969D776FB6A01A00.jpg', null, '2018-09-18 11:58:08');
INSERT INTO `sys_document` VALUES ('F3BD514B4DCB475EBE1FACA1ECCFCBEC', null, '1536737865845', '.jpg', '507714', '1', 'D:/fhgrid/docs/temp/2018-09-12/4E0FC9F76C054345A288444C21B32D22.jpg', null, '2018-09-12 15:37:48');
INSERT INTO `sys_document` VALUES ('F4F4F116B3E7407396F1CA38B23D47DE', null, '1536321731502', '.jpg', '381260', '2', 'D:/fhgrid/docs/data/0CDEB0DB4D8643768B6DFC244B1A517D/AAB3916560924ED899055DB05E77FDDA.jpg', '0CDEB0DB4D8643768B6DFC244B1A517D', '2018-09-07 20:02:10');
INSERT INTO `sys_document` VALUES ('F5020FAB5A784AB8B39C8648EFDACA9A', null, '1536320762019', '.jpg', '1054959', '2', 'D:/fhgrid/docs/data/B29410FAE6A74E4A864D939791A1BBA0/15FC316367D342D592754EA2B1A9F8CA.jpg', 'B29410FAE6A74E4A864D939791A1BBA0', '2018-09-07 19:46:02');
INSERT INTO `sys_document` VALUES ('F6C3A3251FE04D94B3A3215B8FC3AFF7', null, 'QQ图片20170608094524', '.jpg', '71839', '2', 'D:/fhgrid/docs/data/oa_task_24/632DD0B05F0648F48224F42475BE1F5D.jpg', 'oa_task_24', '2018-09-06 11:00:42');
INSERT INTO `sys_document` VALUES ('F7B7B8F3700A435EA3A86C21592D9C4C', null, '1536279620179', '.amr', '5702', '1', 'D:/fhgrid/docs/temp/2018-09-07/8EDC906FBDBE466EB2FF43D24FD3BF7A.amr', null, '2018-09-07 08:20:29');
INSERT INTO `sys_document` VALUES ('FA5AB4AB2DDA4A45ACFCC590B0F46EB0', null, 'QQ图片20180907090157', '.jpg', '328164', '1', 'D:/fhgrid/docs/temp/2018-09-07/E884F665D9144E1BBEAD6790C0F5CAD9.jpg', null, '2018-09-07 09:02:54');
INSERT INTO `sys_document` VALUES ('FBD35CBA4AD443EEBD6496C915A4B218', null, 'QQ图片20170608094524', '.jpg', '71839', '2', 'D:/fhgrid/docs/data/5FCD4AF8C58C4BA796D2073EE71890AC/9A2BF16569404B69A15BCE40AF80FED6.jpg', '5FCD4AF8C58C4BA796D2073EE71890AC', '2018-09-06 10:54:33');
INSERT INTO `sys_document` VALUES ('FD2109724C2045F58575DEBA66DC2FD3', null, '微信图片_20180911093827', '.jpg', '56205', '2', 'D:/fhgrid/docs/data/88D48414434B4ABF9A7A5ABE93D5D344/A6D18C58B18F473AA776C0FEF4459B12.jpg', '88D48414434B4ABF9A7A5ABE93D5D344', '2018-09-11 10:11:31');
INSERT INTO `sys_document` VALUES ('FE26143B345B46E6B20C15672EA0B783', null, 't01e687d9c1a0f515ea', '.jpg', '35245', '1', 'D:/fhgrid/docs/temp/2018-09-10/646C46ABA3D840548CEFAB8FC37E7D91.jpg', null, '2018-09-10 13:00:50');

-- ----------------------------
-- Table structure for sys_form
-- ----------------------------
DROP TABLE IF EXISTS `sys_form`;
CREATE TABLE `sys_form` (
  `fid` int(11) NOT NULL AUTO_INCREMENT COMMENT '表单ID',
  `title` varchar(100) NOT NULL COMMENT '表单名称',
  `createdBy` int(11) NOT NULL COMMENT '创建人',
  `createdDate` datetime NOT NULL COMMENT '创建时间',
  `updatedBy` int(11) NOT NULL COMMENT '修改人',
  `updatedDate` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=470 DEFAULT CHARSET=utf8 COMMENT='动态表单';

-- ----------------------------
-- Records of sys_form
-- ----------------------------
INSERT INTO `sys_form` VALUES ('1', '第三方', '1', '2018-08-11 10:27:48', '1', '2018-08-11 10:27:48');
INSERT INTO `sys_form` VALUES ('3', '测试2', '1', '2018-08-11 11:21:38', '1', '2018-08-11 11:21:38');
INSERT INTO `sys_form` VALUES ('469', '城乡规划局', '1', '2018-08-11 13:30:47', '1', '2018-08-11 13:30:47');

-- ----------------------------
-- Table structure for sys_form_business
-- ----------------------------
DROP TABLE IF EXISTS `sys_form_business`;
CREATE TABLE `sys_form_business` (
  `bid` varchar(32) NOT NULL COMMENT '主键',
  `fid` int(11) NOT NULL COMMENT '表单ID',
  `createdBy` int(11) NOT NULL COMMENT '创建人',
  `createdDate` datetime NOT NULL COMMENT '创建时间',
  `updatedBy` int(11) NOT NULL COMMENT '修改人',
  `updatedDate` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动态表单业务数据';

-- ----------------------------
-- Records of sys_form_business
-- ----------------------------
INSERT INTO `sys_form_business` VALUES ('36DC613CFF584CFAB99E332FBDA5B4AC', '469', '1', '2018-08-11 15:30:56', '1', '2018-08-11 17:03:28');
INSERT INTO `sys_form_business` VALUES ('66D22E0212E84078A0A08E61C167275D', '469', '1', '2018-08-11 17:04:08', '1', '2018-08-13 09:35:41');
INSERT INTO `sys_form_business` VALUES ('E15E5B13F70B4A50ACF42F85A3A9C88B', '469', '1', '2018-08-11 15:38:29', '1', '2018-08-11 17:03:03');

-- ----------------------------
-- Table structure for sys_form_business_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_form_business_details`;
CREATE TABLE `sys_form_business_details` (
  `fbid` varchar(32) NOT NULL COMMENT '主键',
  `bid` varchar(32) NOT NULL COMMENT '业务主键',
  `ffid` int(11) NOT NULL COMMENT '表单ID',
  `fvalue` varchar(200) DEFAULT NULL COMMENT '字段值',
  PRIMARY KEY (`fbid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='动态表单业务数据详情';

-- ----------------------------
-- Records of sys_form_business_details
-- ----------------------------
INSERT INTO `sys_form_business_details` VALUES ('0B2F74AECC154892A54D170D6D1C6E82', 'E15E5B13F70B4A50ACF42F85A3A9C88B', '3', '433123101200209');
INSERT INTO `sys_form_business_details` VALUES ('120C4D05B163439DBFDC6238DD574EF3', '66D22E0212E84078A0A08E61C167275D', '11', '2018-08-08');
INSERT INTO `sys_form_business_details` VALUES ('13C82CC8153541828514BCD07E60D135', '66D22E0212E84078A0A08E61C167275D', '3', '433123100001201');
INSERT INTO `sys_form_business_details` VALUES ('2549DE9CE5324F729CDC115BB0E3EEA5', '36DC613CFF584CFAB99E332FBDA5B4AC', '3', '433123100001201');
INSERT INTO `sys_form_business_details` VALUES ('27FF6DFCA14147B69C5DEEA69FD7FC05', '66D22E0212E84078A0A08E61C167275D', '10', '处理完成');
INSERT INTO `sys_form_business_details` VALUES ('415672EA358B4625A4E3635A760466D9', '66D22E0212E84078A0A08E61C167275D', '5', '1231231231231');
INSERT INTO `sys_form_business_details` VALUES ('52E6D44FBE5446559B458DCF07C1DAF3', '66D22E0212E84078A0A08E61C167275D', '9', '李四');
INSERT INTO `sys_form_business_details` VALUES ('58C8B03ECE7C44DF820206D6B7A82F21', '36DC613CFF584CFAB99E332FBDA5B4AC', '4', '张三111');
INSERT INTO `sys_form_business_details` VALUES ('6603B64C41D94721A6514A6462167330', 'E15E5B13F70B4A50ACF42F85A3A9C88B', '6', '2018-08-06');
INSERT INTO `sys_form_business_details` VALUES ('9347C67E583F4D3CAFE910D1E4FED9B8', '66D22E0212E84078A0A08E61C167275D', '8', '陈工');
INSERT INTO `sys_form_business_details` VALUES ('96B4AD0B3881437A807D58C61B852639', 'E15E5B13F70B4A50ACF42F85A3A9C88B', '5', '12345678901');
INSERT INTO `sys_form_business_details` VALUES ('A622E318DD184B5FAC6E3BFA1696C5C1', '66D22E0212E84078A0A08E61C167275D', '7', '阿斯达斯加打卡坚实的');
INSERT INTO `sys_form_business_details` VALUES ('C3CA281ED6944F1F945BA8EF8C4172D9', 'E15E5B13F70B4A50ACF42F85A3A9C88B', '4', '王五222');
INSERT INTO `sys_form_business_details` VALUES ('CA6025F400044BE8AAE1563E80ECD361', '66D22E0212E84078A0A08E61C167275D', '6', '2018-08-09');
INSERT INTO `sys_form_business_details` VALUES ('CAD99F17935D4E55B6EBEED0CF48F2F8', '66D22E0212E84078A0A08E61C167275D', '4', '阿斯达');
INSERT INTO `sys_form_business_details` VALUES ('E4920BD0085E4C21966FC267269ED69A', '36DC613CFF584CFAB99E332FBDA5B4AC', '6', '2018-08-11');
INSERT INTO `sys_form_business_details` VALUES ('F2AD7D09F2804DD2B386144B9D1A9277', '36DC613CFF584CFAB99E332FBDA5B4AC', '5', '12711111111');

-- ----------------------------
-- Table structure for sys_form_filed
-- ----------------------------
DROP TABLE IF EXISTS `sys_form_filed`;
CREATE TABLE `sys_form_filed` (
  `ffid` int(11) NOT NULL AUTO_INCREMENT COMMENT '字段ID',
  `fid` int(11) NOT NULL COMMENT '表单ID',
  `ftype` varchar(10) NOT NULL COMMENT '字段类型',
  `fname` varchar(50) NOT NULL COMMENT '字段名',
  `isQuery` int(11) NOT NULL DEFAULT '0' COMMENT '是否查询条件',
  `isMust` int(11) NOT NULL DEFAULT '0' COMMENT '是否必填',
  `isList` int(11) NOT NULL DEFAULT '1' COMMENT '是否列表显示',
  `length` int(11) NOT NULL DEFAULT '10' COMMENT '字段长度',
  `width` int(11) NOT NULL DEFAULT '10' COMMENT '列表宽度',
  `seq` int(11) NOT NULL DEFAULT '0' COMMENT '字段排序',
  `formWidth` int(11) NOT NULL COMMENT '表单控件宽度',
  `dictCode` varchar(50) DEFAULT NULL COMMENT '数据字典组CODE',
  `createdBy` int(11) NOT NULL COMMENT '创建人',
  `createdDate` datetime NOT NULL COMMENT '创建时间',
  `updatedBy` int(11) NOT NULL COMMENT '修改人',
  `updatedDate` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`ffid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='动态表单字段';

-- ----------------------------
-- Records of sys_form_filed
-- ----------------------------
INSERT INTO `sys_form_filed` VALUES ('1', '1', '911301', '姓名', '1', '1', '1', '50', '120', '1', '6', '', '1', '2018-08-11 11:10:31', '1', '2018-08-11 11:10:31');
INSERT INTO `sys_form_filed` VALUES ('2', '1', '911305', '性别', '1', '1', '1', '10', '60', '2', '6', '0001', '1', '2018-08-11 11:17:24', '1', '2018-08-11 11:17:24');
INSERT INTO `sys_form_filed` VALUES ('3', '469', '911306', '所属区域', '1', '1', '1', '50', '100', '1', '6', '', '1', '2018-08-11 13:31:49', '1', '2018-08-11 13:31:49');
INSERT INTO `sys_form_filed` VALUES ('4', '469', '911301', '举报人', '1', '1', '1', '50', '100', '2', '6', '', '1', '2018-08-11 13:32:37', '1', '2018-08-11 13:32:37');
INSERT INTO `sys_form_filed` VALUES ('5', '469', '911301', '联系方式', '0', '0', '1', '50', '100', '3', '6', '', '1', '2018-08-11 13:33:05', '1', '2018-08-11 13:33:05');
INSERT INTO `sys_form_filed` VALUES ('6', '469', '911304', '办结日期', '0', '1', '1', '50', '100', '9', '6', '', '1', '2018-08-11 13:34:08', '1', '2018-08-11 13:34:08');
INSERT INTO `sys_form_filed` VALUES ('7', '469', '911302', '事件', '0', '1', '1', '2000', '100', '4', '12', '', '1', '2018-08-13 09:10:29', '1', '2018-08-13 09:10:29');
INSERT INTO `sys_form_filed` VALUES ('8', '469', '911301', '接收人员', '0', '1', '1', '100', '100', '5', '6', '', '1', '2018-08-13 09:11:11', '1', '2018-08-13 09:11:11');
INSERT INTO `sys_form_filed` VALUES ('9', '469', '911301', '处理人员', '0', '1', '1', '100', '100', '6', '6', '', '1', '2018-08-13 09:11:44', '1', '2018-08-13 09:11:44');
INSERT INTO `sys_form_filed` VALUES ('10', '469', '911302', '处理情况', '0', '1', '0', '1000', '100', '7', '12', '', '1', '2018-08-13 09:12:20', '1', '2018-08-13 09:12:20');
INSERT INTO `sys_form_filed` VALUES ('11', '469', '911304', '登记日期', '0', '1', '1', '100', '100', '8', '6', '', '1', '2018-08-13 09:12:54', '1', '2018-08-13 09:12:54');

-- ----------------------------
-- Table structure for sys_gexin_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_gexin_message`;
CREATE TABLE `sys_gexin_message` (
  `mid` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL COMMENT '发送对象用户名',
  `title` varchar(100) NOT NULL COMMENT '消息标题',
  `text` varchar(1000) NOT NULL COMMENT '消息内容',
  `transmissionContent` varchar(1000) DEFAULT NULL COMMENT '透传消息',
  `createdDate` datetime NOT NULL COMMENT '创建时间',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '消息是否有效',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个推待发消息';

-- ----------------------------
-- Records of sys_gexin_message
-- ----------------------------
INSERT INTO `sys_gexin_message` VALUES ('1704A6FEB7974AED90E1A40CD04A398F', 'test', '您有待处理事件', '新的ADMIN', '待处理事件,F50A4AF4756C4EF387C200CB15604649', '2018-08-04 16:38:25', '1');
INSERT INTO `sys_gexin_message` VALUES ('2551E7ED5BB942D7B6A1C35D9073364D', '大坪村', '您派遣的事件被签收', '社保工作已被廖家桥镇签收', '已签收事件,618DE43D2C6443E98A7B8ABB66F47247', '2018-09-10 21:01:41', '1');
INSERT INTO `sys_gexin_message` VALUES ('3B473784F55F4A28A7AF44750495855C', 'admin', '您有待复核事件', '第一', '待复核事件,ADBC4B2431E64F48932EBC4393080578', '2018-08-06 16:24:49', '1');
INSERT INTO `sys_gexin_message` VALUES ('464D4D8A487142169714682EA601FA61', 'admin', '您有待复核事件', '阿斯达', '待复核事件,470B62BCB18B4CCAB791538CD89D5010', '2018-08-09 15:10:42', '1');
INSERT INTO `sys_gexin_message` VALUES ('46C6CF2E64944B01BE60FDDA8859550D', '事件', '您派遣的事件被签收', '第一已被事件签收', '已签收事件,ADBC4B2431E64F48932EBC4393080578', '2018-08-06 14:36:10', '1');
INSERT INTO `sys_gexin_message` VALUES ('4816DCD8977744048BB0CD1C9A5AE162', 'admin', '您有待复核事件', '测试1111111111', '待复核事件,6F5C7C0F84C34266AEBB7B7773FCDCE0', '2018-08-24 11:12:21', '1');
INSERT INTO `sys_gexin_message` VALUES ('498A961088B743C59D5366AC4C87854C', '龙国华', '您有待处理事件', '新的', '待处理事件,0502F0C0B4C247BEA85708856CC84F8D', '2018-08-04 16:36:32', '1');
INSERT INTO `sys_gexin_message` VALUES ('529A15F8868442A5B6A3938D56822304', '文曦', '您有待处理事件', '事件账号的派遣', '待处理事件,B6DF05584CAC4C55932C2F6773630493', '2018-08-04 16:49:45', '1');
INSERT INTO `sys_gexin_message` VALUES ('5BCEF63309CE4246A6BF02B5967756E4', 'test', '您有待处理事件', '新_事件', '待处理事件,B6A5FDFE362741E084D101C92B6F07E9', '2018-08-04 16:07:35', '1');
INSERT INTO `sys_gexin_message` VALUES ('5F920BB8742C48B3833A88E112CD5095', '文曦', '您有待处理事件', '新的', '待处理事件,0502F0C0B4C247BEA85708856CC84F8D', '2018-08-04 16:36:32', '1');
INSERT INTO `sys_gexin_message` VALUES ('631D208A2E334A7F9196C71ED2E7CF79', '菖蒲塘村', '您派遣的事件被签收', '民调走访类已被廖家桥镇签收', '已签收事件,1D92D91A532243C48C1F979A321B2A89', '2018-09-12 09:25:47', '1');
INSERT INTO `sys_gexin_message` VALUES ('7078342E08EF436D88FBB7135E000EB2', 'admin', '您派遣的事件被签收', '查看复核事件已被事件签收', '已签收事件,FCD6D564D0CF4787B6C361CE671D341B', '2018-08-09 15:45:02', '1');
INSERT INTO `sys_gexin_message` VALUES ('74E6A17E32A0431F961654F0CD769978', 'admin', '您有待复核事件', '查看复核事件', '待复核事件,FCD6D564D0CF4787B6C361CE671D341B', '2018-08-09 15:45:13', '1');
INSERT INTO `sys_gexin_message` VALUES ('A9F1D26A32B34BC6B6C2706FC88DB03D', 'admin', '您派遣的事件被签收', '测试1111111111已被超级管理员签收', '已签收事件,6F5C7C0F84C34266AEBB7B7773FCDCE0', '2018-08-24 11:12:00', '1');
INSERT INTO `sys_gexin_message` VALUES ('B83808D72788406A8AA74CEE2921223A', 'admin', '您有待复核事件', '派遣处理事件', '待复核事件,9E763B31879F41FEA9A9337B0C02AEC9', '2018-08-09 14:26:32', '1');
INSERT INTO `sys_gexin_message` VALUES ('BA01B3502D514AEDAFAF358EA32B9540', 'admin', '您派遣的事件被签收', '阿斯达已被事件签收', '已签收事件,470B62BCB18B4CCAB791538CD89D5010', '2018-08-09 15:10:22', '1');
INSERT INTO `sys_gexin_message` VALUES ('BC0A40F466CE41BB92D3531C4D18929B', 'admin', '您派遣的事件被签收', '派遣处理事件已被事件签收', '已签收事件,9E763B31879F41FEA9A9337B0C02AEC9', '2018-08-09 14:25:57', '1');
INSERT INTO `sys_gexin_message` VALUES ('F6C7EEC1A91D4438BD977960DE1D46C1', 'admin', '您上报的事件被退回，请修改后重新上报', '新_事件', '待上报事件,B6A5FDFE362741E084D101C92B6F07E9', '2018-08-04 15:57:36', '1');

-- ----------------------------
-- Table structure for sys_hodiday_pub
-- ----------------------------
DROP TABLE IF EXISTS `sys_hodiday_pub`;
CREATE TABLE `sys_hodiday_pub` (
  `hid` varchar(32) NOT NULL COMMENT '主键',
  `htype` varchar(20) NOT NULL COMMENT '字典：加班、休假',
  `hdate` datetime NOT NULL COMMENT '日期',
  `hnumber` int(11) NOT NULL COMMENT '数字日期',
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='节假日表';

-- ----------------------------
-- Records of sys_hodiday_pub
-- ----------------------------
INSERT INTO `sys_hodiday_pub` VALUES ('9C7C19C4F45C4988B98757D84010168E', '1', '2018-09-30 00:00:00', '20180930');
INSERT INTO `sys_hodiday_pub` VALUES ('9D8519C6C33C4E48B97DC38A6EECC30D', '0', '2018-09-24 00:00:00', '20180924');
INSERT INTO `sys_hodiday_pub` VALUES ('CEF8C9DE6BA44C2680A017486D4A483C', '1', '2018-09-29 00:00:00', '20180929');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `logId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `userIp` varchar(100) DEFAULT NULL COMMENT '用户IP',
  `oper` varchar(200) DEFAULT NULL COMMENT '操作',
  `operClient` varchar(200) DEFAULT NULL COMMENT '客户端',
  `operType` varchar(200) DEFAULT NULL COMMENT '操作类型',
  `operTime` datetime NOT NULL COMMENT '操作时间',
  `operStatus` int(11) DEFAULT NULL COMMENT '状态',
  `request` blob COMMENT '请求报文',
  PRIMARY KEY (`logId`)
) ENGINE=InnoDB AUTO_INCREMENT=2728 DEFAULT CHARSET=utf8 COMMENT='系统操作记录表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('2660', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 11:34:38', '1', null);
INSERT INTO `sys_log` VALUES ('2661', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 11:57:53', '1', null);
INSERT INTO `sys_log` VALUES ('2662', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 12:01:27', '1', null);
INSERT INTO `sys_log` VALUES ('2663', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 13:25:11', '1', null);
INSERT INTO `sys_log` VALUES ('2664', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 15:05:04', '1', null);
INSERT INTO `sys_log` VALUES ('2665', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 15:19:10', '1', null);
INSERT INTO `sys_log` VALUES ('2666', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 15:24:07', '1', null);
INSERT INTO `sys_log` VALUES ('2667', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 15:29:54', '1', null);
INSERT INTO `sys_log` VALUES ('2668', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-19 16:49:12', '1', null);
INSERT INTO `sys_log` VALUES ('2669', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-20 08:44:32', '1', null);
INSERT INTO `sys_log` VALUES ('2670', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-20 13:29:30', '1', null);
INSERT INTO `sys_log` VALUES ('2671', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-20 17:01:50', '1', null);
INSERT INTO `sys_log` VALUES ('2672', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-20 17:51:21', '1', null);
INSERT INTO `sys_log` VALUES ('2673', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 09:07:31', '1', null);
INSERT INTO `sys_log` VALUES ('2674', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 10:47:05', '1', null);
INSERT INTO `sys_log` VALUES ('2675', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 13:39:40', '1', null);
INSERT INTO `sys_log` VALUES ('2676', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 16:05:41', '1', null);
INSERT INTO `sys_log` VALUES ('2677', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 17:48:46', '1', null);
INSERT INTO `sys_log` VALUES ('2678', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 17:48:46', '1', null);
INSERT INTO `sys_log` VALUES ('2679', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 19:27:03', '1', null);
INSERT INTO `sys_log` VALUES ('2680', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 21:08:10', '1', null);
INSERT INTO `sys_log` VALUES ('2681', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 21:08:25', '1', null);
INSERT INTO `sys_log` VALUES ('2682', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-21 21:58:51', '1', null);
INSERT INTO `sys_log` VALUES ('2683', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-22 07:43:01', '1', null);
INSERT INTO `sys_log` VALUES ('2684', '1362', '0:0:0:0:0:0:0:1', '登录成功', 'FIREFOX', null, '2018-09-22 08:04:34', '1', null);
INSERT INTO `sys_log` VALUES ('2685', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-22 10:34:27', '1', null);
INSERT INTO `sys_log` VALUES ('2686', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-22 15:24:59', '1', null);
INSERT INTO `sys_log` VALUES ('2687', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-23 07:33:17', '1', null);
INSERT INTO `sys_log` VALUES ('2688', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-23 16:50:29', '1', null);
INSERT INTO `sys_log` VALUES ('2689', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-23 20:20:50', '1', null);
INSERT INTO `sys_log` VALUES ('2690', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-24 22:45:02', '1', null);
INSERT INTO `sys_log` VALUES ('2691', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-24 22:46:49', '1', null);
INSERT INTO `sys_log` VALUES ('2692', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-24 22:47:55', '1', null);
INSERT INTO `sys_log` VALUES ('2693', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-25 09:53:14', '1', null);
INSERT INTO `sys_log` VALUES ('2694', '1', '127.0.0.1', '登录成功', 'FIREFOX', null, '2018-09-25 10:08:36', '1', null);
INSERT INTO `sys_log` VALUES ('2695', '1', '127.0.0.1', '登录成功', 'FIREFOX', null, '2018-09-25 10:14:47', '1', null);
INSERT INTO `sys_log` VALUES ('2696', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-25 11:35:32', '1', null);
INSERT INTO `sys_log` VALUES ('2697', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-25 11:35:48', '1', null);
INSERT INTO `sys_log` VALUES ('2698', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-25 14:28:25', '1', null);
INSERT INTO `sys_log` VALUES ('2699', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-25 14:28:41', '1', null);
INSERT INTO `sys_log` VALUES ('2700', '1', '127.0.0.1', '登录成功', 'FIREFOX', null, '2018-09-25 15:41:34', '1', null);
INSERT INTO `sys_log` VALUES ('2701', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-25 16:11:59', '1', null);
INSERT INTO `sys_log` VALUES ('2702', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-26 10:13:31', '1', null);
INSERT INTO `sys_log` VALUES ('2703', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-26 11:09:16', '1', null);
INSERT INTO `sys_log` VALUES ('2704', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-26 14:37:49', '1', null);
INSERT INTO `sys_log` VALUES ('2705', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-26 14:37:57', '1', null);
INSERT INTO `sys_log` VALUES ('2706', '1', '127.0.0.1', '登录成功', 'FIREFOX', null, '2018-09-26 15:25:26', '1', null);
INSERT INTO `sys_log` VALUES ('2707', '1', '127.0.0.1', '登录成功', 'FIREFOX', null, '2018-09-26 15:40:56', '1', null);
INSERT INTO `sys_log` VALUES ('2708', '1', '127.0.0.1', '登录成功', 'FIREFOX', null, '2018-09-26 15:43:52', '1', null);
INSERT INTO `sys_log` VALUES ('2709', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-26 16:02:01', '1', null);
INSERT INTO `sys_log` VALUES ('2710', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 09:19:36', '1', null);
INSERT INTO `sys_log` VALUES ('2711', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 09:53:12', '1', null);
INSERT INTO `sys_log` VALUES ('2712', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 10:39:36', '1', null);
INSERT INTO `sys_log` VALUES ('2713', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 11:49:01', '1', null);
INSERT INTO `sys_log` VALUES ('2714', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 11:49:12', '1', null);
INSERT INTO `sys_log` VALUES ('2715', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 15:29:52', '1', null);
INSERT INTO `sys_log` VALUES ('2716', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 16:28:46', '1', null);
INSERT INTO `sys_log` VALUES ('2717', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 16:28:57', '1', null);
INSERT INTO `sys_log` VALUES ('2718', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 16:28:59', '1', null);
INSERT INTO `sys_log` VALUES ('2719', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 16:29:03', '1', null);
INSERT INTO `sys_log` VALUES ('2720', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 17:24:21', '1', null);
INSERT INTO `sys_log` VALUES ('2721', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 17:24:35', '1', null);
INSERT INTO `sys_log` VALUES ('2722', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 17:24:55', '1', null);
INSERT INTO `sys_log` VALUES ('2723', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-27 17:54:08', '1', null);
INSERT INTO `sys_log` VALUES ('2724', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-28 08:58:04', '1', null);
INSERT INTO `sys_log` VALUES ('2725', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-28 10:20:16', '1', null);
INSERT INTO `sys_log` VALUES ('2726', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-28 10:34:52', '1', null);
INSERT INTO `sys_log` VALUES ('2727', '1', '0:0:0:0:0:0:0:1', '登录成功', 'CHROME', null, '2018-09-28 12:09:48', '1', null);

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `roleId` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `resId` int(11) DEFAULT NULL COMMENT '资源ID',
  KEY `sys_permission_resIdroleid` (`roleId`,`resId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('ROLE0', '1');
INSERT INTO `sys_permission` VALUES ('ROLE0', '2');
INSERT INTO `sys_permission` VALUES ('ROLE0', '17');
INSERT INTO `sys_permission` VALUES ('ROLE0', '22');
INSERT INTO `sys_permission` VALUES ('ROLE0', '33');
INSERT INTO `sys_permission` VALUES ('ROLE0', '41');
INSERT INTO `sys_permission` VALUES ('ROLE0', '42');
INSERT INTO `sys_permission` VALUES ('ROLE0', '43');
INSERT INTO `sys_permission` VALUES ('ROLE0', '57');
INSERT INTO `sys_permission` VALUES ('ROLE0', '73');
INSERT INTO `sys_permission` VALUES ('ROLE0', '935');
INSERT INTO `sys_permission` VALUES ('ROLE0', '936');
INSERT INTO `sys_permission` VALUES ('ROLE0', '940');
INSERT INTO `sys_permission` VALUES ('ROLE0', '946');
INSERT INTO `sys_permission` VALUES ('ROLE0', '950');
INSERT INTO `sys_permission` VALUES ('ROLE0', '951');
INSERT INTO `sys_permission` VALUES ('ROLE0', '957');
INSERT INTO `sys_permission` VALUES ('ROLE0', '959');
INSERT INTO `sys_permission` VALUES ('ROLE0', '965');
INSERT INTO `sys_permission` VALUES ('ROLE0', '971');
INSERT INTO `sys_permission` VALUES ('ROLE0', '973');
INSERT INTO `sys_permission` VALUES ('ROLE0', '983');
INSERT INTO `sys_permission` VALUES ('ROLE0', '986');
INSERT INTO `sys_permission` VALUES ('ROLE0', '990');
INSERT INTO `sys_permission` VALUES ('ROLE0', '995');
INSERT INTO `sys_permission` VALUES ('ROLE1', '0');
INSERT INTO `sys_permission` VALUES ('ROLE1', '4');
INSERT INTO `sys_permission` VALUES ('ROLE1', '5');
INSERT INTO `sys_permission` VALUES ('ROLE1', '6');
INSERT INTO `sys_permission` VALUES ('ROLE1', '7');
INSERT INTO `sys_permission` VALUES ('ROLE1', '8');
INSERT INTO `sys_permission` VALUES ('ROLE1', '9');
INSERT INTO `sys_permission` VALUES ('ROLE1', '10');
INSERT INTO `sys_permission` VALUES ('ROLE1', '11');
INSERT INTO `sys_permission` VALUES ('ROLE1', '12');
INSERT INTO `sys_permission` VALUES ('ROLE1', '13');
INSERT INTO `sys_permission` VALUES ('ROLE1', '14');
INSERT INTO `sys_permission` VALUES ('ROLE1', '15');
INSERT INTO `sys_permission` VALUES ('ROLE1', '16');
INSERT INTO `sys_permission` VALUES ('ROLE1', '18');
INSERT INTO `sys_permission` VALUES ('ROLE1', '19');
INSERT INTO `sys_permission` VALUES ('ROLE1', '20');
INSERT INTO `sys_permission` VALUES ('ROLE1', '21');
INSERT INTO `sys_permission` VALUES ('ROLE1', '23');
INSERT INTO `sys_permission` VALUES ('ROLE1', '24');
INSERT INTO `sys_permission` VALUES ('ROLE1', '25');
INSERT INTO `sys_permission` VALUES ('ROLE1', '26');
INSERT INTO `sys_permission` VALUES ('ROLE1', '27');
INSERT INTO `sys_permission` VALUES ('ROLE1', '28');
INSERT INTO `sys_permission` VALUES ('ROLE1', '29');
INSERT INTO `sys_permission` VALUES ('ROLE1', '30');
INSERT INTO `sys_permission` VALUES ('ROLE1', '31');
INSERT INTO `sys_permission` VALUES ('ROLE1', '32');
INSERT INTO `sys_permission` VALUES ('ROLE1', '34');
INSERT INTO `sys_permission` VALUES ('ROLE1', '35');
INSERT INTO `sys_permission` VALUES ('ROLE1', '36');
INSERT INTO `sys_permission` VALUES ('ROLE1', '37');
INSERT INTO `sys_permission` VALUES ('ROLE1', '38');
INSERT INTO `sys_permission` VALUES ('ROLE1', '39');
INSERT INTO `sys_permission` VALUES ('ROLE1', '40');
INSERT INTO `sys_permission` VALUES ('ROLE1', '44');
INSERT INTO `sys_permission` VALUES ('ROLE1', '45');
INSERT INTO `sys_permission` VALUES ('ROLE1', '46');
INSERT INTO `sys_permission` VALUES ('ROLE1', '47');
INSERT INTO `sys_permission` VALUES ('ROLE1', '48');
INSERT INTO `sys_permission` VALUES ('ROLE1', '49');
INSERT INTO `sys_permission` VALUES ('ROLE1', '50');
INSERT INTO `sys_permission` VALUES ('ROLE1', '51');
INSERT INTO `sys_permission` VALUES ('ROLE1', '52');
INSERT INTO `sys_permission` VALUES ('ROLE1', '53');
INSERT INTO `sys_permission` VALUES ('ROLE1', '54');
INSERT INTO `sys_permission` VALUES ('ROLE1', '55');
INSERT INTO `sys_permission` VALUES ('ROLE1', '56');
INSERT INTO `sys_permission` VALUES ('ROLE1', '58');
INSERT INTO `sys_permission` VALUES ('ROLE1', '59');
INSERT INTO `sys_permission` VALUES ('ROLE1', '60');
INSERT INTO `sys_permission` VALUES ('ROLE1', '61');
INSERT INTO `sys_permission` VALUES ('ROLE1', '62');
INSERT INTO `sys_permission` VALUES ('ROLE1', '63');
INSERT INTO `sys_permission` VALUES ('ROLE1', '64');
INSERT INTO `sys_permission` VALUES ('ROLE1', '65');
INSERT INTO `sys_permission` VALUES ('ROLE1', '66');
INSERT INTO `sys_permission` VALUES ('ROLE1', '67');
INSERT INTO `sys_permission` VALUES ('ROLE1', '68');
INSERT INTO `sys_permission` VALUES ('ROLE1', '69');
INSERT INTO `sys_permission` VALUES ('ROLE1', '70');
INSERT INTO `sys_permission` VALUES ('ROLE1', '71');
INSERT INTO `sys_permission` VALUES ('ROLE1', '72');
INSERT INTO `sys_permission` VALUES ('ROLE1', '924');
INSERT INTO `sys_permission` VALUES ('ROLE1', '925');
INSERT INTO `sys_permission` VALUES ('ROLE1', '926');
INSERT INTO `sys_permission` VALUES ('ROLE1', '927');
INSERT INTO `sys_permission` VALUES ('ROLE1', '928');
INSERT INTO `sys_permission` VALUES ('ROLE1', '929');
INSERT INTO `sys_permission` VALUES ('ROLE1', '930');
INSERT INTO `sys_permission` VALUES ('ROLE1', '931');
INSERT INTO `sys_permission` VALUES ('ROLE1', '932');
INSERT INTO `sys_permission` VALUES ('ROLE1', '933');
INSERT INTO `sys_permission` VALUES ('ROLE1', '934');
INSERT INTO `sys_permission` VALUES ('ROLE1', '937');
INSERT INTO `sys_permission` VALUES ('ROLE1', '938');
INSERT INTO `sys_permission` VALUES ('ROLE1', '939');
INSERT INTO `sys_permission` VALUES ('ROLE1', '941');
INSERT INTO `sys_permission` VALUES ('ROLE1', '942');
INSERT INTO `sys_permission` VALUES ('ROLE1', '943');
INSERT INTO `sys_permission` VALUES ('ROLE1', '944');
INSERT INTO `sys_permission` VALUES ('ROLE1', '945');
INSERT INTO `sys_permission` VALUES ('ROLE1', '947');
INSERT INTO `sys_permission` VALUES ('ROLE1', '948');
INSERT INTO `sys_permission` VALUES ('ROLE1', '949');
INSERT INTO `sys_permission` VALUES ('ROLE1', '952');
INSERT INTO `sys_permission` VALUES ('ROLE1', '953');
INSERT INTO `sys_permission` VALUES ('ROLE1', '954');
INSERT INTO `sys_permission` VALUES ('ROLE1', '955');
INSERT INTO `sys_permission` VALUES ('ROLE1', '956');
INSERT INTO `sys_permission` VALUES ('ROLE1', '958');
INSERT INTO `sys_permission` VALUES ('ROLE1', '960');
INSERT INTO `sys_permission` VALUES ('ROLE1', '961');
INSERT INTO `sys_permission` VALUES ('ROLE1', '962');
INSERT INTO `sys_permission` VALUES ('ROLE1', '963');
INSERT INTO `sys_permission` VALUES ('ROLE1', '964');
INSERT INTO `sys_permission` VALUES ('ROLE1', '966');
INSERT INTO `sys_permission` VALUES ('ROLE1', '967');
INSERT INTO `sys_permission` VALUES ('ROLE1', '968');
INSERT INTO `sys_permission` VALUES ('ROLE1', '969');
INSERT INTO `sys_permission` VALUES ('ROLE1', '970');
INSERT INTO `sys_permission` VALUES ('ROLE1', '972');
INSERT INTO `sys_permission` VALUES ('ROLE1', '974');
INSERT INTO `sys_permission` VALUES ('ROLE1', '975');
INSERT INTO `sys_permission` VALUES ('ROLE1', '976');
INSERT INTO `sys_permission` VALUES ('ROLE1', '977');
INSERT INTO `sys_permission` VALUES ('ROLE1', '978');
INSERT INTO `sys_permission` VALUES ('ROLE1', '979');
INSERT INTO `sys_permission` VALUES ('ROLE1', '980');
INSERT INTO `sys_permission` VALUES ('ROLE1', '981');
INSERT INTO `sys_permission` VALUES ('ROLE1', '982');
INSERT INTO `sys_permission` VALUES ('ROLE1', '984');
INSERT INTO `sys_permission` VALUES ('ROLE1', '985');
INSERT INTO `sys_permission` VALUES ('ROLE1', '987');
INSERT INTO `sys_permission` VALUES ('ROLE1', '988');
INSERT INTO `sys_permission` VALUES ('ROLE1', '989');
INSERT INTO `sys_permission` VALUES ('ROLE1', '991');
INSERT INTO `sys_permission` VALUES ('ROLE1', '992');
INSERT INTO `sys_permission` VALUES ('ROLE1', '993');
INSERT INTO `sys_permission` VALUES ('ROLE1', '994');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resId` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `resName` varchar(32) DEFAULT NULL COMMENT '资源名称',
  `resURL` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `resType` int(11) DEFAULT NULL COMMENT '资源类型',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT NULL COMMENT '序号',
  `promission` int(11) DEFAULT NULL COMMENT '是否权限配置',
  `parentId` int(11) DEFAULT NULL COMMENT '上级资源',
  `pageButtonKey` varchar(32) DEFAULT NULL COMMENT '界面按钮标识',
  `callback` varchar(50) DEFAULT NULL COMMENT '调用函数',
  PRIMARY KEY (`resId`),
  KEY `index_sys_resource_url` (`resURL`)
) ENGINE=InnoDB AUTO_INCREMENT=996 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '获取用户对象', '/login/user', '1', '', '1', '2', '0', '', '');
INSERT INTO `sys_resource` VALUES ('2', '获取菜单', '/sys/permission/menu', '1', '', '2', '2', '0', '', '');
INSERT INTO `sys_resource` VALUES ('4', '系统管理', '/sys/permission/action', '2', 'icon-settings', '99', '1', '0', '', '');
INSERT INTO `sys_resource` VALUES ('5', '权限管理', null, '2', '', '10', '1', '4', '', '');
INSERT INTO `sys_resource` VALUES ('6', '系统设置', null, '2', '', '20', '1', '4', '', '');
INSERT INTO `sys_resource` VALUES ('7', '数据字典', '/pc/webpage/system/dictionary/dictionary.html', '2', '', '15', '1', '4', '', '');
INSERT INTO `sys_resource` VALUES ('8', '角色管理', '/pc/webpage/system/permission/role/role.html', '2', '', '98', '1', '5', '', '');
INSERT INTO `sys_resource` VALUES ('9', '用户管理', '/pc/webpage/system/user/user.html', '2', '', '20', '1', '5', '', '');
INSERT INTO `sys_resource` VALUES ('10', '资源管理', '/pc/webpage/system/permission/resources/resources.html', '2', '', '30', '1', '5', '', '');
INSERT INTO `sys_resource` VALUES ('11', '机构管理', '/pc/webpage/system/dept/dept.html', '2', '', '50', '1', '5', '', '');
INSERT INTO `sys_resource` VALUES ('12', '分页查询', '/sys/user/page', '1', '', '10', '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('13', '资源查询', '/sys/user/index', '1', '', '10', '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('14', '新增', '/sys/user/add', '1', 'icon-add', '10', '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('15', '修改', '/sys/user/update', '1', 'icon-edit', '10', '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('16', '删除', '/sys/user/delete', '1', 'icon-clear', '10', '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('17', '综合查询', '/sys/user/detail/list', '1', '', null, '2', '9', 'search', '10');
INSERT INTO `sys_resource` VALUES ('18', '用户详情添加', '/sys/user/detail/add', '1', 'icon-add', '6', '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('19', '用户详情修改', '/sys/user/detail/update', '1', 'icon-edit', '7', '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('20', '用户详情分页', '/sys/user/detail/page', '1', '', null, '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('21', '用户详情', '/sys/user/detail/list', '1', '', null, '1', '9', '', '');
INSERT INTO `sys_resource` VALUES ('22', '修改密码', '/sys/user/password', '1', '', '10', '2', '9', '', '');
INSERT INTO `sys_resource` VALUES ('23', '分页查询', '/sys/permission/resources/page', '1', '', '10', '1', '10', '', '');
INSERT INTO `sys_resource` VALUES ('24', '资源查询', '/sys/permission/resources/index', '1', '', '10', '1', '10', '', '');
INSERT INTO `sys_resource` VALUES ('25', '资源树查询', '/sys/permission/resources/tree', '1', '', '10', '1', '10', '', '');
INSERT INTO `sys_resource` VALUES ('26', '新增', '/sys/permission/resources/add', '1', 'icon-add', '10', '1', '10', '14', '');
INSERT INTO `sys_resource` VALUES ('27', '修改', '/sys/permission/resources/update', '1', 'icon-edit', '10', '1', '10', '14', '');
INSERT INTO `sys_resource` VALUES ('28', '删除', '/sys/permission/resources/delete', '1', 'icon-clear', '10', '1', '10', '14', '');
INSERT INTO `sys_resource` VALUES ('29', '新增', '/sys/permission/role/add', '1', 'icon-add', null, '1', '8', '', '');
INSERT INTO `sys_resource` VALUES ('30', '修改', '/sys/permission/role/update', '1', 'icon-edit', '2', '1', '8', '', '');
INSERT INTO `sys_resource` VALUES ('31', '删除', '/sys/permission/role/delete', '1', 'icon-clear', '3', '1', '8', '', '');
INSERT INTO `sys_resource` VALUES ('32', '分页查询', '/sys/permission/role/page', '1', '', '3', '1', '8', 'search', '');
INSERT INTO `sys_resource` VALUES ('33', '详细信息', '/sys/permission/role/index', '1', '', null, '2', '8', '', '');
INSERT INTO `sys_resource` VALUES ('34', '查询所有角色(带权限)', '/sys/permission/role/alllist', '1', '', '6', '1', '8', '', '');
INSERT INTO `sys_resource` VALUES ('35', '查询用户拥有的角色', '/sys/permission/userRole/getUserRole', '1', null, '105', '1', '8', null, null);
INSERT INTO `sys_resource` VALUES ('36', '给一个用户分配一个角色', '/sys/permission/userRole/add', '1', 'icon-add', '106', '1', '8', null, null);
INSERT INTO `sys_resource` VALUES ('37', '查询用户部门下的角色', '/sys/permission/role/selectRole', '1', null, '107', '1', '8', null, null);
INSERT INTO `sys_resource` VALUES ('38', '删除一个用户角色', '/sys/permission/userRole/delete', '1', 'icon-clear', '109', '1', '8', null, null);
INSERT INTO `sys_resource` VALUES ('39', '给角色分配权限', '/sys/permission/addPermission', '1', null, '111', '1', '8', null, null);
INSERT INTO `sys_resource` VALUES ('40', '根据ID查询权限', '/sys/permission/index', '1', null, '110', '1', '8', null, null);
INSERT INTO `sys_resource` VALUES ('41', '查询系统可选择角色', '/sys/permission/role/list', '1', '', null, '2', '8', 'search', '10');
INSERT INTO `sys_resource` VALUES ('42', '根据用户角色获取资源', '/sys/permission/resources/listWithRole', '1', '', null, '2', '8', '', '');
INSERT INTO `sys_resource` VALUES ('43', '组织机构树查询', '/sys/dept/tree', '1', '', '10', '2', '11', '', '');
INSERT INTO `sys_resource` VALUES ('44', '查询部门', '/sys/dept/page', '1', null, '6', '1', '11', null, null);
INSERT INTO `sys_resource` VALUES ('45', '添加部门', '/sys/dept/add', '1', 'icon-add', null, '1', '11', '', '');
INSERT INTO `sys_resource` VALUES ('46', '查询单个部门', '/sys/dept/index', '1', '', null, '1', '11', '', '');
INSERT INTO `sys_resource` VALUES ('47', '修改部门', '/sys/dept/update', '1', 'icon-edit', null, '1', '11', '', '');
INSERT INTO `sys_resource` VALUES ('48', '删除', '/sys/dept/delete', '1', 'icon-clear', null, '1', '11', '', '');
INSERT INTO `sys_resource` VALUES ('49', '参数设置', '/pc/webpage/system/config/sysConfig.html', '2', '', '20', '1', '6', '', '');
INSERT INTO `sys_resource` VALUES ('50', '节假日设置', '/pc/webpage/system/hodiday/hodiday.html', '2', '', '30', '1', '6', '', '');
INSERT INTO `sys_resource` VALUES ('51', '表单设置', '/pc/webpage/system/form/Form_list.html', '2', 'icon-settings ', '5', '1', '6', '', '');
INSERT INTO `sys_resource` VALUES ('52', '参数设置分页', '/sys/sysConfig/page', '1', '', '1', '1', '49', null, null);
INSERT INTO `sys_resource` VALUES ('53', '参数设置新增', '/sys/sysConfig/add', '1', 'icon-add', '2', '1', '49', null, null);
INSERT INTO `sys_resource` VALUES ('54', '参数设置详情', '/sys/sysConfig/index', '1', '', '3', '1', '49', null, null);
INSERT INTO `sys_resource` VALUES ('55', '参数设置修改', '/sys/sysConfig/update', '1', 'icon-edit', '4', '1', '49', null, null);
INSERT INTO `sys_resource` VALUES ('56', '参数设置删除', '/sys/sysConfig/delete', '1', 'icon-clear', '5', '1', '49', null, null);
INSERT INTO `sys_resource` VALUES ('57', '根据code查询配置', '/sys/sysConfig/cache', '1', '', '6', '2', '49', 'search', '');
INSERT INTO `sys_resource` VALUES ('58', '分页查询', '/sys/hodiday/page', '1', '', '10', '1', '50', '', '');
INSERT INTO `sys_resource` VALUES ('59', '资源查询', '/sys/hodiday/index', '1', '', '10', '1', '50', '', '');
INSERT INTO `sys_resource` VALUES ('60', '新增', '/sys/hodiday/add', '1', 'icon-add', '10', '1', '50', '', '');
INSERT INTO `sys_resource` VALUES ('61', '修改', '/sys/hodiday/update', '1', 'icon-edit', '10', '1', '50', '', '');
INSERT INTO `sys_resource` VALUES ('62', '删除', '/sys/hodiday/delete', '1', 'icon-clear', '10', '1', '50', '', '');
INSERT INTO `sys_resource` VALUES ('63', '查询字典', '/sys/dictionary/page', '1', null, '3', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('64', '查询字典组', '/sys/dictionary/groupTree', '1', null, '4', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('65', '新增字典', '/system/dictionary/add', '1', 'icon-add', '5', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('66', '查看单个字典详情', '/sys/dictionary/index', '1', null, '6', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('67', '删除字典', '/system/dictionary/delete', '1', 'icon-clear', '6', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('68', '删除字典组', '/sys/dictionary/deleteGroup', '1', null, '7', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('69', '新增字典组', '/sys/dictionary/group/save', '1', null, '8', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('70', '修改字典组', '/system/dictionary/group/update', '1', 'icon-edit', '9', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('71', '修改字典', '/system/dictionary/update', '1', 'icon-edit', '10', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('72', '刷新字典缓存', '/sys/dictionary/refresh/file', '1', null, '1', '1', '7', null, null);
INSERT INTO `sys_resource` VALUES ('73', '手机端获取数据字典', '/sys/dictionary/mobile/all', '1', '', '10', '2', '7', 'search', '');
INSERT INTO `sys_resource` VALUES ('924', 'codeing', '/pc/webpage/codeing/tables.html', '2', '', '9', '1', '4', '', '');
INSERT INTO `sys_resource` VALUES ('925', '分页查询表', '/codeing/tables/page', '1', '', '1', '1', '924', 'search', '');
INSERT INTO `sys_resource` VALUES ('926', '添加表', '/codeing/tables/add', '1', 'icon-add', '2', '1', '924', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('927', '修改表', '/codeing/tables/update', '1', 'icon-edit', '3', '1', '924', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('928', '删除表', '/codeing/tables/delete', '1', 'icon-clear', '4', '1', '924', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('929', '列信息', '/codeing/columns/page', '1', 'icon-login ', '5', '1', '924', '', 'goToColumns()');
INSERT INTO `sys_resource` VALUES ('930', '导入表', '/codeing/tables/add/', '1', 'icon-target ', '6', '1', '924', '', 'loadTable()');
INSERT INTO `sys_resource` VALUES ('931', '生成代码', '/codeing/generate', '1', 'icon-layers ', '7', '1', '924', '', 'goCode()');
INSERT INTO `sys_resource` VALUES ('932', '添加', '/codeing/columns/add', '1', 'icon-add', '1', '1', '929', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('933', '删除', '/codeing/columns/delete', '1', 'icon-clear', '3', '1', '929', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('934', '修改', '/codeing/columns/update', '1', 'icon-edit', '2', '1', '929', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('935', '详情', '/codeing/tables/index', '1', 'icon-size-fullscreen ', '10', '2', '924', '', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('936', '数据列详情', '/codeing/columns/index', '1', 'icon-size-fullscreen ', '8', '2', '929', '', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('937', '基础信息', '#', '2', 'icon-diamond ', '1', '1', '0', '', '');
INSERT INTO `sys_resource` VALUES ('938', '订单', '#', '2', 'icon-film ', '2', '1', '0', '', '');
INSERT INTO `sys_resource` VALUES ('939', '会员管理', '/pc/webpage/core/member/member.html', '2', 'icon-badge', '1', '1', '937', '', '');
INSERT INTO `sys_resource` VALUES ('940', '分页查询', '/core/member/page', '1', '', '1', '2', '939', 'search', '');
INSERT INTO `sys_resource` VALUES ('941', '新增', '/core/member/add', '1', 'icon-add', '2', '1', '939', ' ', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('942', '修改', '/core/member/update', '1', 'icon-edit', '3', '1', '939', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('943', '删除', '/core/member/delete', '1', 'icon-clear', '3', '1', '939', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('944', '详情', '/core/member/index', '1', '', '5', '1', '939', '', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('945', '会员体系', '/pc/webpage/core/member/memberLevel.html', '2', 'icon-graduation ', '2', '1', '937', '', '');
INSERT INTO `sys_resource` VALUES ('946', '分页查询', '/core/memberLevel/page', '1', '', '1', '2', '945', 'search', '');
INSERT INTO `sys_resource` VALUES ('947', '新增', '/core/memberLevel/add', '1', 'icon-add', '2', '1', '945', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('948', '修改', '/core/memberLevel/update', '1', 'icon-edit', '3', '1', '945', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('949', '删除', '/core/memberLevel/delete', '1', 'icon-clear', '4', '1', '945', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('950', '详情', '/core/memberLevel/index', '1', '', '5', '2', '945', 'search', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('951', '查询所有会员级别', '/core/memberLevel/all', '1', '', '6', '2', '945', 'search', '');
INSERT INTO `sys_resource` VALUES ('952', '员工管理', '/pc/webpage/core/employee/employee.html', '2', 'icon-user ', '3', '1', '937', '', '');
INSERT INTO `sys_resource` VALUES ('953', '新增', '/core/employee/add', '1', 'icon-add', '1', '1', '952', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('954', '修改', '/core/employee/update', '1', 'icon-edit', '2', '1', '952', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('955', '删除', '/core/employee/delete', '1', 'icon-clear', '3', '1', '952', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('956', '分页查询', '/core/employee/page', '1', '', '4', '1', '952', 'search', '');
INSERT INTO `sys_resource` VALUES ('957', '详情', '/core/employee/index', '1', 'icon-size-fullscreen ', '5', '2', '952', '', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('958', '同步用户', '/core/employee/toUser', '1', 'icon-login ', '7', '1', '952', '', 'toUser()');
INSERT INTO `sys_resource` VALUES ('959', '根据用户名查询用户', '/sys/user/getByUsername', '1', '', '88', '2', '9', 'search', '');
INSERT INTO `sys_resource` VALUES ('960', '客房管理', '/pc/webpage/core/room/room.html', '2', 'icon-home ', '4', '1', '937', '', '');
INSERT INTO `sys_resource` VALUES ('961', '新增', '/core/room/add', '1', 'icon-add', '1', '1', '960', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('962', '修改', '/core/room/update', '1', 'icon-edit', '2', '1', '960', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('963', '删除', '/core/room/delete', '1', 'icon-clear', '3', '1', '960', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('964', '分页查询', '/core/room/page', '1', '', '4', '1', '960', 'search', '');
INSERT INTO `sys_resource` VALUES ('965', '详情', '/core/room/index', '1', 'icon-size-fullscreen ', '5', '2', '960', 'search', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('966', '手牌管理', '/pc/webpage/core/strap/strap.html', '2', 'icon-like ', '5', '1', '937', '', '');
INSERT INTO `sys_resource` VALUES ('967', '新增', '/core/strap/add', '1', 'icon-add', '1', '1', '966', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('968', '修改', '/core/strap/update', '1', 'icon-edit', '2', '1', '966', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('969', '删除', '/core/strap/delete', '1', 'icon-clear', '3', '1', '966', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('970', '分页查询', '/core/strap/page', '1', '', '2', '1', '966', 'search', '');
INSERT INTO `sys_resource` VALUES ('971', '详情', '/core/strap/index', '1', 'icon-size-fullscreen ', '5', '2', '966', 'search', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('972', '商品服务', '/pc/webpage/settlement/goods/goods.html', '2', 'icon-credit-card ', '9', '1', '938', '', '');
INSERT INTO `sys_resource` VALUES ('973', '分页查询', '/trade/goods/page', '1', '', '1', '2', '972', 'search', '');
INSERT INTO `sys_resource` VALUES ('974', '新增', '/trade/goods/add', '1', 'icon-add', '2', '1', '972', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('975', '修改', '/trade/goods/update', '1', 'icon-edit', '3', '1', '972', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('976', '删除', '/trade/goods/delete', '1', 'icon-clear', '3', '1', '972', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('977', '详情', '/trade/goods/index', '1', 'icon-size-fullscreen ', '4', '1', '972', '', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('978', '商品单位', '/pc/webpage/settlement/goods/goodsUnit.html', '2', 'icon-vector ', '10', '1', '938', '', '');
INSERT INTO `sys_resource` VALUES ('979', '分页查询', '/settlement/goodsUnit/page', '1', '', '1', '1', '978', 'search', '');
INSERT INTO `sys_resource` VALUES ('980', '新增', '/settlement/goodsUnit/add', '1', 'icon-add', '2', '1', '978', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('981', '修改', '/settlement/goodsUnit/update', '1', 'icon-edit', '3', '1', '978', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('982', '删除', '/settlement/goodsUnit/delete', '1', 'icon-clear', '3', '1', '978', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('983', '详情', '/settlement/goodsUnit/index', '1', 'icon-size-fullscreen ', '3', '2', '978', 'search', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('984', '属性查询', '/settlement/goodsUnit/list', '1', '', '6', '1', '978', 'search', '');
INSERT INTO `sys_resource` VALUES ('985', '套餐管理', '/pc/webpage/settlement/packages/packages.html', '2', 'icon-layers ', '3', '1', '938', '', '');
INSERT INTO `sys_resource` VALUES ('986', '分页查询', '/settlement/packages/page', '1', '', '1', '2', '985', 'search', '');
INSERT INTO `sys_resource` VALUES ('987', '新增', '/settlement/packages/add', '1', 'icon-add', '2', '1', '985', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('988', '修改', '/settlement/packages/update', '1', 'icon-edit', '3', '1', '985', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('989', '删除', '/settlement/packages/delete', '1', 'icon-clear', '4', '1', '985', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('990', '详情', '/settlement/packages/index', '1', '', '5', '2', '985', 'search', 'Faith.doView();');
INSERT INTO `sys_resource` VALUES ('991', '套餐详情', '/settlement/packagesDetail/page', '1', 'icon-share-alt ', '6', '1', '985', '', 'packagesDetail();');
INSERT INTO `sys_resource` VALUES ('992', '新增', '/settlement/packagesDetail/add', '1', '', '1', '1', '991', '', 'Faith.doAdd();');
INSERT INTO `sys_resource` VALUES ('993', '修改', '/settlement/packagesDetail/update', '1', '', '2', '1', '991', '', 'Faith.doUpdate();');
INSERT INTO `sys_resource` VALUES ('994', '删除', '/settlement/packagesDetail/delete', '1', '', '3', '1', '991', '', 'Faith.doDelete();');
INSERT INTO `sys_resource` VALUES ('995', '详情', '/settlement/packagesDetail/index', '1', '', '4', '2', '991', '', 'Faith.doView();');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `roleId` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `roleName` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `roleTitle` varchar(50) DEFAULT NULL COMMENT '角色别名',
  `deptCode` int(11) DEFAULT NULL COMMENT '部门编号',
  `parentRole` varchar(32) DEFAULT NULL COMMENT '上级角色',
  `status` int(11) DEFAULT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('ROLE1', 'ROLE_ADMIN', '超级管理员', null, '', '1');
INSERT INTO `sys_role` VALUES ('ROLE0', 'ROLE_ALL', '所有用户', null, '', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `nickName` char(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '昵称',
  `status` int(11) DEFAULT NULL COMMENT '账号状态',
  `loginStatus` int(11) DEFAULT NULL COMMENT '登录状态',
  `clintId` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '客户端标识',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1363 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'BCE6C8D76606139E', '超级管理员', '1', null, null);
INSERT INTO `sys_user` VALUES ('1361', '王一', 'BCE6C8D76606139E', '王一', '1', null, null);
INSERT INTO `sys_user` VALUES ('1362', 'zs', 'BCE6C8D76606139E', '张三', '1', null, null);

-- ----------------------------
-- Table structure for sys_user_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `deptCode` int(11) DEFAULT NULL COMMENT '部门编码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户部门关联表';

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------
INSERT INTO `sys_user_dept` VALUES ('1', '1');
INSERT INTO `sys_user_dept` VALUES ('1361', '1');
INSERT INTO `sys_user_dept` VALUES ('1362', '2');

-- ----------------------------
-- Table structure for sys_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_detail`;
CREATE TABLE `sys_user_detail` (
  `userId` int(11) NOT NULL COMMENT '用户主键',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `image` varchar(500) DEFAULT NULL COMMENT '照片',
  `addr` varchar(100) DEFAULT NULL COMMENT '地址',
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `remediation` varchar(10) DEFAULT NULL COMMENT '政治面貌',
  `scope` varchar(50) DEFAULT NULL COMMENT '管理范围',
  `familyNumber` int(11) DEFAULT NULL COMMENT '管理户数',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户详情表';

-- ----------------------------
-- Records of sys_user_detail
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `roleId` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `deptCode` int(11) DEFAULT NULL COMMENT '部门编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', 'ROLE1', null);
INSERT INTO `sys_user_role` VALUES ('1', 'ROLE0', null);
INSERT INTO `sys_user_role` VALUES ('1361', 'ROLE0', null);
INSERT INTO `sys_user_role` VALUES ('1362', 'ROLE0', null);

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
-- Records of tb_department
-- ----------------------------

-- ----------------------------
-- Table structure for tb_employee
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
  `created_by` int(11) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` int(11) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of tb_employee
-- ----------------------------
INSERT INTO `tb_employee` VALUES ('12306F2882EF4D3ABE2C0881A2C8D893', '尹德', 'yd', '1', '12', null, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', null, null, null, '0', '0', '0', '2018-02-02 15:50:14', '0', '2018-02-02 15:50:14');
INSERT INTO `tb_employee` VALUES ('4A21485019174112889F6ABB8FA12EED', '喻敏', 'ym', '2', '11', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', '0', '2018-02-02 15:48:44', '0', '2018-02-02 15:48:44');
INSERT INTO `tb_employee` VALUES ('552309B47EA24279B7E761E6E8E387A6', '陈思思', 'css', '3', '13', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', '0', '2018-02-02 15:47:59', '0', '2018-02-02 15:47:59');
INSERT INTO `tb_employee` VALUES ('69F6EC898EC345C7B73E3D7222641D53', '刘丹', 'ld', '4', '14', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', '0', '2018-02-02 15:49:05', '0', '2018-02-02 15:49:05');
INSERT INTO `tb_employee` VALUES ('799AAE3B73CD45AEB641D95765A0205A', '高大山', 'gds', '5', '15', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', '0', '2018-02-02 15:46:50', '0', '2018-02-02 15:46:50');
INSERT INTO `tb_employee` VALUES ('AED330EB655F40C3B2B7DD6D2A33DF18', '肖君', 'xj', '6', '16', null, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', null, null, null, '0', '0', '0', '2018-02-02 15:50:33', '0', '2018-02-02 15:50:33');
INSERT INTO `tb_employee` VALUES ('AED999017B5446FB88F6F00225FF7991', '张果', 'zg', '7', '17', null, 'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', null, null, null, '0', '0', '0', '2018-02-02 15:50:22', '0', '2018-02-02 15:50:22');
INSERT INTO `tb_employee` VALUES ('BF81C5AE66F54DB0AEFC232E37E46E59', '孙静', 'sj', '8', '18', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', '0', '2018-02-02 15:47:15', '0', '2018-02-02 15:47:15');
INSERT INTO `tb_employee` VALUES ('CD2A52BC83C349D0978EC288809FCE6F', '蒋玮', 'jw', '9', '19', null, '55CE8083FE254559AC989700F0D3354A', null, null, null, '0', '0', '0', '2018-02-02 15:48:18', '0', '2018-02-02 15:48:18');
INSERT INTO `tb_employee` VALUES ('DEE1233D3C2E437CAE9E625B541A91A8', '罗丹', 'ld', '11', '20', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', '0', '2018-02-02 15:49:10', '0', '2018-02-02 15:49:10');
INSERT INTO `tb_employee` VALUES ('E4CD61024E674A1DA3EE1EEF70123A14', '张三', 'zs', '111777', '2222', '1362', '', '2', '2018-09-20', null, '0', '1', '1', '2018-09-21 21:41:08', '1', '2018-09-22 07:55:00');
INSERT INTO `tb_employee` VALUES ('E6017959302849FE9CB0629B89B77475', '周敏', 'zm', '12', '10', null, '69DF8088318C4F89840FD0F6A4AF46F9', null, null, null, '0', '0', '0', '2018-02-02 15:48:54', '0', '2018-02-02 15:48:54');

-- ----------------------------
-- Table structure for tb_employee_commission
-- ----------------------------
DROP TABLE IF EXISTS `tb_employee_commission`;
CREATE TABLE `tb_employee_commission` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录标识',
  `employee_id` varchar(32) DEFAULT NULL COMMENT '员工标识',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `cause` varchar(200) DEFAULT NULL COMMENT '原由',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工提成';

-- ----------------------------
-- Records of tb_employee_commission
-- ----------------------------

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
-- Records of tb_employee_special
-- ----------------------------

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
-- Records of tb_member
-- ----------------------------
INSERT INTO `tb_member` VALUES ('1111', '段王爷', null, '0', null, '4', '13812345678', '', '0', '0.00', '13812345678', '', '2018-09-21', null, null, '11', '', null, '', '1', '2018-09-21 17:59:48', '1', '2018-09-21 18:14:57');

-- ----------------------------
-- Table structure for tb_member_integral_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_member_integral_record`;
CREATE TABLE `tb_member_integral_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录标识',
  `member_id` varchar(32) NOT NULL COMMENT '会员标识',
  `rtype` int(11) NOT NULL COMMENT '收支',
  `integral` decimal(10,2) DEFAULT NULL COMMENT '积分',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员积分流水';

-- ----------------------------
-- Records of tb_member_integral_record
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='会员体系';

-- ----------------------------
-- Records of tb_member_level
-- ----------------------------
INSERT INTO `tb_member_level` VALUES ('1', '青铜', '1000', '2', '1', '2018-09-21 16:22:37', '1', '2018-09-21 17:50:51');
INSERT INTO `tb_member_level` VALUES ('2', '白银', '2000', '4', '1', '2018-09-21 16:23:08', '1', '2018-09-21 17:51:47');
INSERT INTO `tb_member_level` VALUES ('3', '钻石', '16000', null, '1', '2018-09-21 16:23:35', '1', '2018-09-21 17:52:14');
INSERT INTO `tb_member_level` VALUES ('4', '黄金', '4000', '5', '1', '2018-09-21 17:51:16', '1', '2018-09-21 17:52:23');
INSERT INTO `tb_member_level` VALUES ('5', '铂金', '8000', '3', '1', '2018-09-21 17:51:35', '1', '2018-09-21 17:51:35');

-- ----------------------------
-- Table structure for tb_member_money_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_member_money_record`;
CREATE TABLE `tb_member_money_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录标识',
  `member_id` varchar(32) NOT NULL COMMENT '会员标识',
  `rtype` int(11) NOT NULL COMMENT '收支',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `balance` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员金额流水';

-- ----------------------------
-- Records of tb_member_money_record
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='会员充值活动';

-- ----------------------------
-- Records of tb_member_plus
-- ----------------------------
INSERT INTO `tb_member_plus` VALUES ('1', '充500送500', '50000.00', '50000.00', '5000.00', '0', 'admin', '2018-01-23 16:19:16', 'admin', '2018-01-23 16:19:21');
INSERT INTO `tb_member_plus` VALUES ('2', '充1000送1000', '100000.00', '100000.00', '10000.00', '0', 'admin', '2018-01-23 16:19:30', 'admin', '2018-01-23 16:19:30');
INSERT INTO `tb_member_plus` VALUES ('3', '充2000送3000', '200000.00', '300000.00', '20000.00', '0', 'admin', '2018-01-23 16:21:01', 'admin', '2018-01-23 16:21:03');

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
-- Records of tb_reservation
-- ----------------------------

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
-- Records of tb_reservation_trade
-- ----------------------------

-- ----------------------------
-- Table structure for tb_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `room_id` varchar(32) NOT NULL COMMENT '房间标识',
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
  `is_consumption` int(11) DEFAULT NULL COMMENT '是否包含基础消费',
  `commodity` varchar(200) DEFAULT NULL COMMENT '商品id，逗号分隔',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间';

-- ----------------------------
-- Records of tb_room
-- ----------------------------
INSERT INTO `tb_room` VALUES ('10BFE61C680A4994A4E0EC00B1E39C49', '1', '1', '101', '客101', '0', '0', '1', '1', '**', '101', '1', '', '1', '2018-09-22 16:16:27', '1', '2018-09-22 16:16:48');

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
-- Records of tb_store
-- ----------------------------
INSERT INTO `tb_store` VALUES ('55CE8083FE254559AC989700F0D3354A', '富侨F联邦店', '0', '长沙市岳麓区麓云路中房F联邦', '0731-88888888', null, null, null, null, 'admin', '2018-02-02 15:39:45', null, '2018-02-02 15:39:45');
INSERT INTO `tb_store` VALUES ('69DF8088318C4F89840FD0F6A4AF46F9', '富侨浏城桥店', '0', '长沙市芙蓉中路小林子冲', '0731-88888888', null, null, null, null, 'admin', '2018-02-02 15:39:02', null, '2018-02-02 15:39:02');
INSERT INTO `tb_store` VALUES ('AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA', '迈优斯总部', '0', '深圳市迈优斯科技有限公司', '18888888888', '88888888', '88888888', null, null, 'system', '2018-01-31 10:58:22', 'system', '2018-01-31 10:58:22');

-- ----------------------------
-- Table structure for tb_strap
-- ----------------------------
DROP TABLE IF EXISTS `tb_strap`;
CREATE TABLE `tb_strap` (
  `strap_id` varchar(32) NOT NULL COMMENT '手牌标识',
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
INSERT INTO `tb_strap` VALUES ('57E2E7CFCDA943EC934BAE0E365B1DEB', '1', '2', '11', '0', '1', '2018-09-23 08:04:07', '1', '2018-09-25 11:36:23');

-- ----------------------------
-- Table structure for tb_types
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
-- Table structure for tb_types_bind
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='报钟播报';

-- ----------------------------
-- Records of tc_clock_broadcast
-- ----------------------------
INSERT INTO `tc_clock_broadcast` VALUES ('1', '1', '1', '1111111111', null, '2018-01-30 15:30:20', null, '2018-01-30 15:30:20');

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
-- Records of tc_clock_order
-- ----------------------------

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
-- Records of tc_clock_record
-- ----------------------------

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
-- Records of tc_skill_class
-- ----------------------------

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
-- Records of tc_technician
-- ----------------------------

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
-- Records of tc_technician_class
-- ----------------------------

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
-- Records of tc_technician_shift
-- ----------------------------

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
-- Records of tc_technician_skill
-- ----------------------------

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
-- Records of to_authorization
-- ----------------------------

-- ----------------------------
-- Table structure for to_customer
-- ----------------------------
DROP TABLE IF EXISTS `to_customer`;
CREATE TABLE `to_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户标识',
  `customer_name` varchar(32) NOT NULL COMMENT '客户名称',
  `advance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '押金',
  `note` varchar(64) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT '0' COMMENT '状态',
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
-- Table structure for to_goods
-- ----------------------------
DROP TABLE IF EXISTS `to_goods`;
CREATE TABLE `to_goods` (
  `goods_id` varchar(32) NOT NULL COMMENT '商品标识',
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
INSERT INTO `to_goods` VALUES ('61716A6B41D54A4FB09552AEF8706676', '可乐', '5.90', '1', '0', '200101', '100', '0', '1', '0', '1', '百事可乐', '', '1', '1', '1', '2018-09-26 17:35:21', '1', '2018-09-26 17:36:16');
INSERT INTO `to_goods` VALUES ('76D3B6B5012A40D491A44301F6896730', '足底', '200.00', '3', '60', '200199', '0', '1', '0', '0', '0', '高级技师盲人按摩', '2A7B94D4C3244CE489220F9D6B775B5A', '0', '0', '1', '2018-09-26 17:42:17', '1', '2018-09-26 18:13:11');
INSERT INTO `to_goods` VALUES ('D22E9B4629AF494386CD4D236013030A', '薯条', '18.00', '4', null, '200103', '1000', '0', '1', '0', '0', '鲜榨薯条（原味）', 'C413892B74E34A68A97DEA388D4F0CE3', '1', '1', '1', '2018-09-28 11:11:12', '1', '2018-09-28 11:11:12');
INSERT INTO `to_goods` VALUES ('D398AC0280EB4AFA91B56549FFB5BC0D', '农夫矿泉水', '2.00', '5', '0', '200101', '1000', '0', '1', '0', '1', '农夫矿泉水农夫矿泉水农夫矿泉水农夫矿泉水农夫矿泉水农夫矿泉水', '', '1', '0', '1', '2018-09-28 11:13:46', '1', '2018-09-28 11:13:46');

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
-- Records of to_goods_ext
-- ----------------------------

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
-- Records of to_goods_material
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='商品单位';

-- ----------------------------
-- Records of to_goods_unit
-- ----------------------------
INSERT INTO `to_goods_unit` VALUES ('1', '厅', null, null, '1', '2018-09-26 16:33:40', '1', '2018-09-26 16:33:40');
INSERT INTO `to_goods_unit` VALUES ('2', '箱', '1', '10', '1', '2018-09-26 16:48:13', '1', '2018-09-26 16:48:13');
INSERT INTO `to_goods_unit` VALUES ('3', '钟', null, null, '1', '2018-09-26 17:40:53', '1', '2018-09-26 17:40:53');
INSERT INTO `to_goods_unit` VALUES ('4', '盒', null, null, '1', '2018-09-28 11:08:59', '1', '2018-09-28 11:08:59');
INSERT INTO `to_goods_unit` VALUES ('5', '瓶', null, null, '1', '2018-09-28 11:12:29', '1', '2018-09-28 11:12:29');
INSERT INTO `to_goods_unit` VALUES ('6', '打', '5', '12', '1', '2018-09-28 11:12:42', '1', '2018-09-28 11:12:42');

-- ----------------------------
-- Table structure for to_packages
-- ----------------------------
DROP TABLE IF EXISTS `to_packages`;
CREATE TABLE `to_packages` (
  `package_id` varchar(32) NOT NULL COMMENT '套餐标识',
  `package_name` varchar(64) NOT NULL COMMENT '套餐名称',
  `pinyin` varchar(64) NOT NULL COMMENT '套餐拼音',
  `price` decimal(10,2) NOT NULL COMMENT '售价',
  `valid_date` date DEFAULT NULL COMMENT '有效日期',
  `img` varchar(32) DEFAULT NULL,
  `preferential_price` decimal(10,2) DEFAULT NULL COMMENT '优惠幅度',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '原价',
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
INSERT INTO `to_packages` VALUES ('42C2935666204675B1C9A092A5768DEF', 'A套餐', 'Ataocan', '99.00', '2018-09-10', null, null, null, '0', '1', '2018-09-28 09:07:49', '1', '2018-09-28 09:07:49');
INSERT INTO `to_packages` VALUES ('FE5ED08AE72C4640995611CB3837528A', 'B套餐', 'Btaocan', '199.00', '2018-11-30', null, '-175.10', null, '0', '1', '2018-09-28 09:08:48', '1', '2018-09-28 09:08:48');

-- ----------------------------
-- Table structure for to_packages_detail
-- ----------------------------
DROP TABLE IF EXISTS `to_packages_detail`;
CREATE TABLE `to_packages_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '详情标识',
  `package_id` varchar(32) NOT NULL COMMENT '归属套餐',
  `goods_id` varchar(32) NOT NULL COMMENT '商品标识',
  `goods_ct` int(11) NOT NULL COMMENT '商品数量',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='消费套餐详情';

-- ----------------------------
-- Records of to_packages_detail
-- ----------------------------
INSERT INTO `to_packages_detail` VALUES ('1', 'FE5ED08AE72C4640995611CB3837528A', '61716A6B41D54A4FB09552AEF8706676', '1', '1', '2018-09-28 11:08:17', '1', '2018-09-28 11:08:17');
INSERT INTO `to_packages_detail` VALUES ('2', 'FE5ED08AE72C4640995611CB3837528A', 'D22E9B4629AF494386CD4D236013030A', '1', '1', '2018-09-28 11:11:34', '1', '2018-09-28 12:27:59');
INSERT INTO `to_packages_detail` VALUES ('3', '42C2935666204675B1C9A092A5768DEF', 'D398AC0280EB4AFA91B56549FFB5BC0D', '2', '1', '2018-09-28 11:14:19', '1', '2018-09-28 11:14:19');
INSERT INTO `to_packages_detail` VALUES ('4', '42C2935666204675B1C9A092A5768DEF', '76D3B6B5012A40D491A44301F6896730', '1', '1', '2018-09-28 11:14:33', '1', '2018-09-28 11:14:33');

-- ----------------------------
-- Table structure for ts_config
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
-- Records of ts_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for ts_dictionary_group
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
-- Records of ts_document_info
-- ----------------------------

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
-- Records of ts_log
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of ts_role_info
-- ----------------------------
INSERT INTO `ts_role_info` VALUES ('1', 'ROLE1', '管理员', null, '0', null, '0', 'SYSTEM', '2018-01-15 08:50:32', 'SYSTEM', '2018-01-15 08:50:36');

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
-- Records of ts_role_permission
-- ----------------------------
INSERT INTO `ts_role_permission` VALUES ('1', '335', 'admin', '2018-01-15 08:52:35', 'admin', '2018-01-15 08:52:38');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of ts_user
-- ----------------------------
INSERT INTO `ts_user` VALUES ('1', 'admin', null, '管理员', '15112349876', 'admin@163.com', 'admin', '2018-01-31', '0', 'admin', '2018-01-12 10:32:56', 'admin', '2018-01-12 10:32:56');

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
-- Records of ts_user_group
-- ----------------------------

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
-- Records of ts_user_role
-- ----------------------------
INSERT INTO `ts_user_role` VALUES ('1', '1', null, '2018-01-15 08:50:56', null, '2018-01-15 08:50:56');

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
-- Records of tt_coupon
-- ----------------------------

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
-- Records of tt_coupon_item
-- ----------------------------

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
-- Records of tt_exchange
-- ----------------------------

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
-- Records of tt_member_price
-- ----------------------------

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
-- Records of tt_settlement
-- ----------------------------

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
-- Records of tt_trade
-- ----------------------------

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
-- Records of tt_trade_discount
-- ----------------------------

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
-- Records of tt_volume
-- ----------------------------

-- ----------------------------
-- Table structure for tw_attendance
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance`;
CREATE TABLE `tw_attendance` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考勤方案标识',
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='门店考勤';

-- ----------------------------
-- Records of tw_attendance
-- ----------------------------
INSERT INTO `tw_attendance` VALUES ('1', '职能部门考勤', '0', '2', '0', '180', '300', '1', '2018-02-06 21:44:41', '1', '2018-02-06 21:44:41');
INSERT INTO `tw_attendance` VALUES ('2', '技能岗早班', '0', '2', '0', '180', '300', '1', '2018-02-05 14:20:13', '1', '2018-02-05 14:20:13');
INSERT INTO `tw_attendance` VALUES ('3', '技能岗中班', '0', '2', '0', '180', '300', '1', '2018-02-05 14:29:37', '1', '2018-02-05 14:36:00');
INSERT INTO `tw_attendance` VALUES ('4', '技能岗晚班', '0', '2', '0', '180', '300', '1', '2018-02-05 14:39:12', '1', '2018-09-26 15:48:47');
INSERT INTO `tw_attendance` VALUES ('5', '后勤人员考勤', '0', '2', '0', '180', '300', '1', '2018-07-31 14:38:35', '1', '2018-07-31 14:38:35');

-- ----------------------------
-- Table structure for tw_attendance_detail
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
) ENGINE=InnoDB AUTO_INCREMENT=1315 DEFAULT CHARSET=utf8 COMMENT='门店考勤详情';

-- ----------------------------
-- Records of tw_attendance_detail
-- ----------------------------
INSERT INTO `tw_attendance_detail` VALUES ('1254', '1', '6', '2018-09-01', '2018-09', '1', '1', '0', null, null, '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1255', '1', '7', '2018-09-02', '2018-09', '2', '1', '0', null, null, '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1256', '1', '1', '2018-09-03', '2018-09', '3', '0', '1', '2018-09-03 20:00:00', '2018-09-04 03:00:00', '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1257', '1', '2', '2018-09-04', '2018-09', '4', '0', '1', '2018-09-04 20:00:00', '2018-09-05 03:00:00', '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1258', '1', '3', '2018-09-05', '2018-09', '5', '0', '1', '2018-09-05 20:00:00', '2018-09-06 03:00:00', '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1259', '1', '4', '2018-09-06', '2018-09', '6', '0', '1', '2018-09-06 20:00:00', '2018-09-07 03:00:00', '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1260', '1', '5', '2018-09-07', '2018-09', '7', '0', '1', '2018-09-07 20:00:00', '2018-09-08 03:00:00', '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1261', '1', '6', '2018-09-08', '2018-09', '8', '1', '0', null, null, '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1262', '1', '7', '2018-09-09', '2018-09', '9', '1', '0', null, null, '1', '1', '2018-09-26 16:27:44', '1', '2018-09-26 16:27:44');
INSERT INTO `tw_attendance_detail` VALUES ('1263', '1', '1', '2018-09-10', '2018-09', '10', '0', '1', '2018-09-10 20:00:00', '2018-09-11 03:00:00', '1', '1', '2018-09-26 16:27:45', '1', '2018-09-26 16:27:45');
INSERT INTO `tw_attendance_detail` VALUES ('1264', '1', '2', '2018-09-11', '2018-09', '11', '0', '1', '2018-09-11 20:00:00', '2018-09-12 03:00:00', '1', '1', '2018-09-26 16:27:45', '1', '2018-09-26 16:27:45');
INSERT INTO `tw_attendance_detail` VALUES ('1265', '1', '3', '2018-09-12', '2018-09', '12', '0', '1', '2018-09-12 20:00:00', '2018-09-13 03:00:00', '1', '1', '2018-09-26 16:27:45', '1', '2018-09-26 16:27:45');
INSERT INTO `tw_attendance_detail` VALUES ('1266', '1', '4', '2018-09-13', '2018-09', '13', '0', '1', '2018-09-13 20:00:00', '2018-09-14 03:00:00', '1', '1', '2018-09-26 16:27:45', '1', '2018-09-26 16:27:45');
INSERT INTO `tw_attendance_detail` VALUES ('1267', '1', '5', '2018-09-14', '2018-09', '14', '0', '1', '2018-09-14 20:00:00', '2018-09-15 03:00:00', '1', '1', '2018-09-26 16:27:45', '1', '2018-09-26 16:27:45');
INSERT INTO `tw_attendance_detail` VALUES ('1268', '1', '6', '2018-09-15', '2018-09', '15', '1', '0', null, null, '1', '1', '2018-09-26 16:27:45', '1', '2018-09-26 16:27:45');
INSERT INTO `tw_attendance_detail` VALUES ('1269', '1', '7', '2018-09-16', '2018-09', '16', '1', '0', null, null, '1', '1', '2018-09-26 16:27:45', '1', '2018-09-26 16:27:45');
INSERT INTO `tw_attendance_detail` VALUES ('1270', '1', '1', '2018-09-17', '2018-09', '17', '0', '1', '2018-09-17 20:00:00', '2018-09-18 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1271', '1', '2', '2018-09-18', '2018-09', '18', '0', '1', '2018-09-18 20:00:00', '2018-09-19 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1272', '1', '3', '2018-09-19', '2018-09', '19', '0', '1', '2018-09-19 20:00:00', '2018-09-20 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1273', '1', '4', '2018-09-20', '2018-09', '20', '0', '1', '2018-09-20 20:00:00', '2018-09-21 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1274', '1', '5', '2018-09-21', '2018-09', '21', '0', '1', '2018-09-21 20:00:00', '2018-09-22 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1275', '1', '6', '2018-09-22', '2018-09', '22', '1', '0', null, null, '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1276', '1', '7', '2018-09-23', '2018-09', '23', '1', '0', null, null, '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1277', '1', '1', '2018-09-24', '2018-09', '24', '0', '1', '2018-09-24 20:00:00', '2018-09-25 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1278', '1', '2', '2018-09-25', '2018-09', '25', '0', '1', '2018-09-25 20:00:00', '2018-09-26 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1279', '1', '3', '2018-09-26', '2018-09', '26', '0', '1', '2018-09-26 20:00:00', '2018-09-27 03:00:00', '1', '1', '2018-09-26 16:27:46', '1', '2018-09-26 16:27:46');
INSERT INTO `tw_attendance_detail` VALUES ('1280', '1', '4', '2018-09-27', '2018-09', '27', '0', '1', '2018-09-27 20:00:00', '2018-09-28 03:00:00', '1', '1', '2018-09-26 16:27:47', '1', '2018-09-26 16:27:47');
INSERT INTO `tw_attendance_detail` VALUES ('1281', '1', '5', '2018-09-28', '2018-09', '28', '0', '0', null, null, '1', '1', '2018-09-26 16:27:47', '1', '2018-09-26 16:36:57');
INSERT INTO `tw_attendance_detail` VALUES ('1282', '1', '6', '2018-09-29', '2018-09', '29', '1', '0', null, null, '0', '1', '2018-09-26 16:27:47', '1', '2018-09-26 16:27:47');
INSERT INTO `tw_attendance_detail` VALUES ('1283', '1', '7', '2018-09-30', '2018-09', '30', '1', '0', null, null, '0', '1', '2018-09-26 16:27:47', '1', '2018-09-26 16:27:47');
INSERT INTO `tw_attendance_detail` VALUES ('1284', '1', '1', '2018-10-01', '2018-10', '1', '0', '1', '2018-10-01 20:00:00', '2018-10-02 03:00:00', '0', '1', '2018-09-26 16:41:07', '1', '2018-09-26 16:41:07');
INSERT INTO `tw_attendance_detail` VALUES ('1285', '1', '2', '2018-10-02', '2018-10', '2', '0', '1', '2018-10-02 20:00:00', '2018-10-03 03:00:00', '0', '1', '2018-09-26 16:41:08', '1', '2018-09-26 16:41:08');
INSERT INTO `tw_attendance_detail` VALUES ('1286', '1', '3', '2018-10-03', '2018-10', '3', '0', '1', '2018-10-03 20:00:00', '2018-10-04 03:00:00', '0', '1', '2018-09-26 16:41:08', '1', '2018-09-26 16:41:08');
INSERT INTO `tw_attendance_detail` VALUES ('1287', '1', '4', '2018-10-04', '2018-10', '4', '0', '1', '2018-10-04 20:00:00', '2018-10-05 03:00:00', '0', '1', '2018-09-26 16:41:09', '1', '2018-09-26 16:41:09');
INSERT INTO `tw_attendance_detail` VALUES ('1288', '1', '5', '2018-10-05', '2018-10', '5', '0', '1', '2018-10-05 20:00:00', '2018-10-06 03:00:00', '0', '1', '2018-09-26 16:41:09', '1', '2018-09-26 16:41:09');
INSERT INTO `tw_attendance_detail` VALUES ('1289', '1', '6', '2018-10-06', '2018-10', '6', '1', '0', null, null, '0', '1', '2018-09-26 16:41:10', '1', '2018-09-26 16:41:10');
INSERT INTO `tw_attendance_detail` VALUES ('1290', '1', '7', '2018-10-07', '2018-10', '7', '1', '0', null, null, '0', '1', '2018-09-26 16:41:10', '1', '2018-09-26 16:41:10');
INSERT INTO `tw_attendance_detail` VALUES ('1291', '1', '1', '2018-10-08', '2018-10', '8', '0', '1', '2018-10-08 20:00:00', '2018-10-09 03:00:00', '0', '1', '2018-09-26 16:41:15', '1', '2018-09-26 16:41:15');
INSERT INTO `tw_attendance_detail` VALUES ('1292', '1', '2', '2018-10-09', '2018-10', '9', '0', '1', '2018-10-09 20:00:00', '2018-10-10 03:00:00', '0', '1', '2018-09-26 16:41:15', '1', '2018-09-26 16:41:15');
INSERT INTO `tw_attendance_detail` VALUES ('1293', '1', '3', '2018-10-10', '2018-10', '10', '0', '1', '2018-10-10 20:00:00', '2018-10-11 03:00:00', '0', '1', '2018-09-26 16:41:15', '1', '2018-09-26 16:41:15');
INSERT INTO `tw_attendance_detail` VALUES ('1294', '1', '4', '2018-10-11', '2018-10', '11', '0', '1', '2018-10-11 20:00:00', '2018-10-12 03:00:00', '0', '1', '2018-09-26 16:41:15', '1', '2018-09-26 16:41:15');
INSERT INTO `tw_attendance_detail` VALUES ('1295', '1', '5', '2018-10-12', '2018-10', '12', '0', '1', '2018-10-12 20:00:00', '2018-10-13 03:00:00', '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1296', '1', '6', '2018-10-13', '2018-10', '13', '1', '0', null, null, '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1297', '1', '7', '2018-10-14', '2018-10', '14', '1', '0', null, null, '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1298', '1', '1', '2018-10-15', '2018-10', '15', '0', '1', '2018-10-15 20:00:00', '2018-10-16 03:00:00', '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1299', '1', '2', '2018-10-16', '2018-10', '16', '0', '1', '2018-10-16 20:00:00', '2018-10-17 03:00:00', '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1300', '1', '3', '2018-10-17', '2018-10', '17', '0', '1', '2018-10-17 20:00:00', '2018-10-18 03:00:00', '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1301', '1', '4', '2018-10-18', '2018-10', '18', '0', '1', '2018-10-18 20:00:00', '2018-10-19 03:00:00', '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1302', '1', '5', '2018-10-19', '2018-10', '19', '0', '1', '2018-10-19 20:00:00', '2018-10-20 03:00:00', '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1303', '1', '6', '2018-10-20', '2018-10', '20', '1', '0', null, null, '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1304', '1', '7', '2018-10-21', '2018-10', '21', '1', '0', null, null, '0', '1', '2018-09-26 16:41:16', '1', '2018-09-26 16:41:16');
INSERT INTO `tw_attendance_detail` VALUES ('1305', '1', '1', '2018-10-22', '2018-10', '22', '0', '1', '2018-10-22 20:00:00', '2018-10-23 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1306', '1', '2', '2018-10-23', '2018-10', '23', '0', '1', '2018-10-23 20:00:00', '2018-10-24 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1307', '1', '3', '2018-10-24', '2018-10', '24', '0', '1', '2018-10-24 20:00:00', '2018-10-25 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1308', '1', '4', '2018-10-25', '2018-10', '25', '0', '1', '2018-10-25 20:00:00', '2018-10-26 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1309', '1', '5', '2018-10-26', '2018-10', '26', '0', '1', '2018-10-26 20:00:00', '2018-10-27 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1310', '1', '6', '2018-10-27', '2018-10', '27', '1', '0', null, null, '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1311', '1', '7', '2018-10-28', '2018-10', '28', '1', '0', null, null, '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1312', '1', '1', '2018-10-29', '2018-10', '29', '0', '1', '2018-10-29 20:00:00', '2018-10-30 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1313', '1', '2', '2018-10-30', '2018-10', '30', '0', '1', '2018-10-30 20:00:00', '2018-10-31 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');
INSERT INTO `tw_attendance_detail` VALUES ('1314', '1', '3', '2018-10-31', '2018-10', '31', '0', '1', '2018-10-31 20:00:00', '2018-11-01 03:00:00', '0', '1', '2018-09-26 16:41:17', '1', '2018-09-26 16:41:17');

-- ----------------------------
-- Table structure for tw_attendance_diary
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
) ENGINE=InnoDB AUTO_INCREMENT=417 DEFAULT CHARSET=utf8 COMMENT='打卡记录';

-- ----------------------------
-- Records of tw_attendance_diary
-- ----------------------------

-- ----------------------------
-- Table structure for tw_attendance_employee
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='员工考勤关系';

-- ----------------------------
-- Records of tw_attendance_employee
-- ----------------------------

-- ----------------------------
-- Table structure for tw_attendance_logs
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
-- Table structure for tw_attendance_time
-- ----------------------------
DROP TABLE IF EXISTS `tw_attendance_time`;
CREATE TABLE `tw_attendance_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `attendance_id` int(11) NOT NULL COMMENT '考勤标识',
  `name` varchar(16) NOT NULL COMMENT '时段名称',
  `sign_time` time NOT NULL COMMENT '上班时间',
  `out_time` time NOT NULL COMMENT '下班时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='考勤时段 一个考勤方案至多三个时段';

-- ----------------------------
-- Records of tw_attendance_time
-- ----------------------------
INSERT INTO `tw_attendance_time` VALUES ('1', '1', '大班', '20:00:00', '03:00:00');
INSERT INTO `tw_attendance_time` VALUES ('2', '2', '早', '21:30:00', '07:30:00');
INSERT INTO `tw_attendance_time` VALUES ('3', '3', '晚', '20:00:00', '02:00:00');
INSERT INTO `tw_attendance_time` VALUES ('4', '4', '早', '20:30:00', '08:00:00');
INSERT INTO `tw_attendance_time` VALUES ('5', '5', '中', '23:00:00', '18:00:00');
INSERT INTO `tw_attendance_time` VALUES ('25', '1', '小班', '23:00:00', '04:00:00');

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

-- ----------------------------
-- Records of tw_employee_journal
-- ----------------------------
DROP TRIGGER IF EXISTS `t_insert_on_sys_resource`;
DELIMITER ;;
CREATE TRIGGER `t_insert_on_sys_resource` AFTER INSERT ON `sys_resource` FOR EACH ROW BEGIN
-- 不需要要权限配置，
	if new.promission =2 THEN
		INSERT INTO sys_permission(roleid,resid)VALUES('ROLE0',new.resid);
	END if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `t_update_on_sys_resource`;
DELIMITER ;;
CREATE TRIGGER `t_update_on_sys_resource` AFTER UPDATE ON `sys_resource` FOR EACH ROW BEGIN
-- 不需要要权限配置，
	DECLARE v_r0 int DEFAULT 0;	
	SELECT count(0) INTO v_r0 FROM sys_permission p WHERE p.resId=new.resId and p.roleId = 'ROLE0';

	IF new.promission =1 THEN
		if v_r0 >0 THEN
			DELETE FROM sys_permission WHERE resId=new.resId and roleId = 'ROLE0';
		end if;	
	END IF;

	IF new.promission =2 THEN
		if v_r0 = 0 THEN
			INSERT INTO sys_permission(roleid,resid)VALUES('ROLE0',new.resid);
		end IF;	
	END IF;

END
;;
DELIMITER ;
