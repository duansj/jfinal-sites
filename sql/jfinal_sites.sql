/*
Navicat MySQL Data Transfer

Source Server         : 172.16.176.141
Source Server Version : 50528
Source Host           : 172.16.176.141:3306
Source Database       : jfinal_sites

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-01-13 10:52:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `context` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('38e5093113e54df9913fce00ec9f5113', null, '### hello editor.md\r\n发士大夫士大夫\r\n![](D:/data/iamges/QQ图片20160603174136.gif)');
INSERT INTO `content` VALUES ('671816c51cd54451b9ea5ee7b775ecde', null, '### hello editor.md\r\n\r\n阿士大夫撒地方');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '1');
