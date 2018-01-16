/*
Navicat MySQL Data Transfer

Source Server         : 172.16.176.141
Source Server Version : 50528
Source Host           : 172.16.176.141:3306
Source Database       : jfinal_sites

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-01-16 10:06:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_case
-- ----------------------------
DROP TABLE IF EXISTS `t_case`;
CREATE TABLE `t_case` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `picture` varchar(2000) DEFAULT NULL,
  `context` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='案例表';

-- ----------------------------
-- Records of t_case
-- ----------------------------

-- ----------------------------
-- Table structure for t_case_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `t_case_evaluate`;
CREATE TABLE `t_case_evaluate` (
  `id` varchar(32) NOT NULL,
  `case_id` varchar(32) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `context` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评价表';

-- ----------------------------
-- Records of t_case_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for t_leave_message
-- ----------------------------
DROP TABLE IF EXISTS `t_leave_message`;
CREATE TABLE `t_leave_message` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `context` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言表';

-- ----------------------------
-- Records of t_leave_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_rticle
-- ----------------------------
DROP TABLE IF EXISTS `t_rticle`;
CREATE TABLE `t_rticle` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `context` varchar(255) DEFAULT NULL,
  `classification` varchar(25) DEFAULT NULL,
  `category` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of t_rticle
-- ----------------------------
INSERT INTO `t_rticle` VALUES ('04cd9c6e4c844414a09f05bdcfb636f8', '阿斯蒂芬', '### hello editor.md', '留学荷英', '精华文章', '专业解读', '2018-01-15 20:55:57', null);
INSERT INTO `t_rticle` VALUES ('29282231997a4f4eb503e6efdc96cfdd', 'sdf', '### hello editor.md\r\nasdf', '留学荷英', '精华文章', '专业解读', '2018-01-16 09:40:33', null);
INSERT INTO `t_rticle` VALUES ('38e5093113e54df9913fce00ec9f5113', null, '### hello editor.md\r\n发士大夫士大夫\r\n![](D:/data/iamges/QQ图片20160603174136.gif)', null, null, null, null, null);
INSERT INTO `t_rticle` VALUES ('671816c51cd54451b9ea5ee7b775ecde', null, '### hello editor.md\r\n\r\n阿士大夫撒地方', null, null, null, null, null);
INSERT INTO `t_rticle` VALUES ('7aa0759ba9c947a89ac70330ed751944', '电饭锅', null, '0', '精华文章', '0', null, null);
INSERT INTO `t_rticle` VALUES ('bbb0229667354173a0817900327e2aa4', '阿斯蒂芬', null, '留学北欧', '精华文章', '学院院系', null, null);
INSERT INTO `t_rticle` VALUES ('e1f5b9949d18499fbfc1721ca8c54658', 'sdf', 'qq![](asd/服务器traceroute.jpg)\r\n### hello editor.md\r\nasdf\r\n\r\nsdf\r\nsdf\r\nd', '留学荷英', '精华文章', '申请细节', '2018-01-16 09:41:19', null);
INSERT INTO `t_rticle` VALUES ('eca8b9325d694b038a2df83ef466ff20', '阿斯蒂芬', null, '留学北欧', '精华文章', '专业解读', '2018-01-15 20:28:04', null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'admin', '1', null, null);
