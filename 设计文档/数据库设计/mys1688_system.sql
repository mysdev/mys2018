/*
Navicat MySQL Data Transfer

Source Server         : 本地虚拟mysql
Source Server Version : 50719
Source Host           : 192.168.135.101:3306
Source Database       : mys1688

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-01-02 11:42:57
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统配置';

-- ----------------------------
-- Records of ts_config
-- ----------------------------
INSERT INTO `ts_config` VALUES ('1', 'cmpname', '深圳市优迈斯网络技术有限公司', '公司名称', null, '2018-01-02 03:37:06', null, '2018-01-02 03:37:06');
INSERT INTO `ts_config` VALUES ('2', 'cmpname', '深圳市优迈斯网络技术有限公司', null, null, '2018-01-02 03:41:00', null, '2018-01-02 03:41:00');

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
  `url` varchar(8) DEFAULT NULL COMMENT '资源地址',
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
-- Records of ts_resource_info
-- ----------------------------

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
-- Records of ts_role_info
-- ----------------------------

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

-- ----------------------------
-- Table structure for ts_user
-- ----------------------------
DROP TABLE IF EXISTS `ts_user`;
CREATE TABLE `ts_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户标识',
  `user_name` varchar(64) NOT NULL COMMENT '用户姓名',
  `team_id` int(11) DEFAULT NULL COMMENT '用户组',
  `nick_name` varchar(64) NOT NULL COMMENT '呢称',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `id_card` varchar(18) DEFAULT NULL COMMENT '证件号',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `address` varchar(128) DEFAULT NULL COMMENT '地址',
  `mobile` varchar(16) NOT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮件地址',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `repassword_date` date DEFAULT NULL COMMENT '下次修改密码时间',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用 0正常',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) DEFAULT NULL COMMENT '修订人员',
  `updated_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修订时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of ts_user
-- ----------------------------

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
