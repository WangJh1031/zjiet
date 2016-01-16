/*
 Navicat Premium Data Transfer

 Source Server         : aaa
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : zjiet

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 01/05/2016 12:06:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `inc`
-- ----------------------------
DROP TABLE IF EXISTS `inc`;
CREATE TABLE `inc` (
  `inc_title` varchar(20) COLLATE utf8_bin NOT NULL,
  `inc_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`inc_title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `inc`
-- ----------------------------
BEGIN;
INSERT INTO `inc` VALUES ('apple', 'this is test value'), ('sdad', 'ffff');
COMMIT;

-- ----------------------------
--  Table structure for `inc_news`
-- ----------------------------
DROP TABLE IF EXISTS `inc_news`;
CREATE TABLE `inc_news` (
  `news_id` int(8) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `news_value` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `news_date` datetime DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
delimiter ;;
CREATE TRIGGER `default_datetime` BEFORE INSERT ON `inc_news` FOR EACH ROW if new.news_date is null then 
      set new.news_date = now(); 
    end if;
 ;;
delimiter ;

-- ----------------------------
--  Records of `inc_news`
-- ----------------------------
BEGIN;
INSERT INTO `inc_news` VALUES ('1', 'apple 2016', 'this is test value', '2016-01-01 15:44:25'), ('2', 'apple 2015', 'this is test value', '2016-01-01 15:49:14'), ('3', 'google 2016', 'testtesttesttesttest', '2016-01-01 15:49:14'), ('5', 'f', 'sadawweeweweqqaa666sd', '2016-01-04 00:36:26');
COMMIT;

-- ----------------------------
--  Table structure for `items`
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `item_id` varchar(8) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `item_info` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `items`
-- ----------------------------
BEGIN;
INSERT INTO `items` VALUES ('aaaa', 'fffff', 'sadasasdas'), ('afffs', 'asdasfa', '???'), ('as', 'asdasfa', '???'), ('asd', 'asdasfa', '???????'), ('co1', '导弹发射器', '俄罗斯导弹发射器'), ('z01', 'F22战斗机', 'f22');
COMMIT;

-- ----------------------------
--  Table structure for `user_message`
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message` (
  `user_id` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `message_title` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `message_value` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `message_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
delimiter ;;
CREATE TRIGGER `massage_datetime` BEFORE INSERT ON `user_message` FOR EACH ROW if new.message_time is null then 
      set new.message_time = now(); 
    end if;
 ;;
delimiter ;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` varchar(8) COLLATE utf8_bin NOT NULL,
  `user_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `user_pwd` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `user_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('adasd', 'dasd', '12345', '3'), ('guest', 'guest', '123', '1'), ('winfath', 'kingsman', 'winfath', '5');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
