/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : personal_plan

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-12-17 13:55:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `reportid` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `plan` varchar(255) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `task` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`reportid`),
  KEY `FK_q1gy81c6pxx1ddwysrvvbdfuq` (`userid`),
  CONSTRAINT `FK_q1gy81c6pxx1ddwysrvvbdfuq` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '2016-12-13 18:54:42', '完成简历', 'spring data jpa', '无', '项目过程中', '1');
INSERT INTO `report` VALUES ('2', '2016-12-13 20:33:23', '不知道', '很多', '没有', '哈哈哈哈哈', '1');
INSERT INTO `report` VALUES ('3', '2016-12-13 20:46:28', '加油', '太多了', '。。。', '嘿嘿嘿', '1');
INSERT INTO `report` VALUES ('4', '2016-12-14 09:04:43', '还没有计划', '还没有遇到', '无', '还没有完成', '1');
INSERT INTO `report` VALUES ('5', '2016-12-14 09:09:28', '不知道', '还没有遇到', '无', '还没有完成', '1');
INSERT INTO `report` VALUES ('6', '2016-12-14 09:16:34', '个人简历完成', '很多', '加油', '我的第一条任务', '2');

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `taskid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`taskid`),
  KEY `FK_qitdd7l4mhemy6byavh20f18i` (`userid`),
  CONSTRAINT `FK_qitdd7l4mhemy6byavh20f18i` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '第一个任务', '2016-12-17 00:00:00', '暂时还没有', 'give up', '1');
INSERT INTO `task` VALUES ('2', '我的第二个任务', '2016-12-17 00:00:00', '没有啊', 'finish', '1');
INSERT INTO `task` VALUES ('3', '我的第一个任务', '2016-12-14 11:22:15', '嘿嘿嘿\r\n', '未完成', '2');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
INSERT INTO `user` VALUES ('2', 'tang', '1234');
