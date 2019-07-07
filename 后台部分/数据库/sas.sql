/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : attendance

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 06/07/2019 11:02:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for absenteeism
-- ----------------------------
DROP TABLE IF EXISTS `absenteeism`;
CREATE TABLE `absenteeism`  (
  `AId` int(64) NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CourseId` int(64) DEFAULT NULL,
  `AtteanceNum` int(64) DEFAULT NULL,
  `LeaveNum` int(64) DEFAULT NULL,
  `AbsenteeismNum` int(64) DEFAULT NULL,
  `AbsenteeismList` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateTime` date DEFAULT NULL,
  PRIMARY KEY (`AId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of absenteeism
-- ----------------------------
INSERT INTO `absenteeism` VALUES (30, '专业英语', 3, 0, 0, 3, ',44,55,45,', '2019-06-24');

-- ----------------------------
-- Table structure for attendance
-- ----------------------------
DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `Aid` int(11) NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CourseId` int(11) DEFAULT NULL,
  `StudentName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `StudentId` int(11) DEFAULT NULL,
  `State` int(11) DEFAULT NULL COMMENT '0:签到成功    1：请假',
  `SignDeskTime` datetime(0) DEFAULT NULL,
  `SignDeskAddress` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SeatNumber` int(11) DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` date DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Aid`) USING BTREE,
  INDEX `FK_Reference_13`(`CourseId`) USING BTREE,
  INDEX `FK_Reference_14`(`StudentId`) USING BTREE,
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`StudentId`) REFERENCES `personnel` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of attendance
-- ----------------------------
INSERT INTO `attendance` VALUES (2, '高速网络原理', 1, '谢维鹏', 45, 1, '2019-06-22 01:15:35', '', NULL, NULL, '2019-06-22', NULL, NULL);

-- ----------------------------
-- Table structure for class_room
-- ----------------------------
DROP TABLE IF EXISTS `class_room`;
CREATE TABLE `class_room`  (
  `ClassRoomId` int(11) NOT NULL AUTO_INCREMENT,
  `OrganizationId` int(11) DEFAULT NULL,
  `ClassRoomName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ClassRoomAddress` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Galleryful` int(11) DEFAULT NULL,
  `IsUse` int(11) DEFAULT NULL,
  `UseStratTime` date DEFAULT NULL,
  `UseEndTime` date DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` date DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Longitude` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Latitude` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ClassRoomId`) USING BTREE,
  INDEX `FK_Reference_8`(`OrganizationId`) USING BTREE,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`OrganizationId`) REFERENCES `organization_dictionary` (`OrganizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class_room
-- ----------------------------
INSERT INTO `class_room` VALUES (1, 2, '三号楼307', '数计学院三号楼', 90, 0, NULL, NULL, NULL, '2019-03-12', NULL, NULL, '119.187162', '26.050719');
INSERT INTO `class_room` VALUES (2, 2, '408楼', '学院三', 78, 0, NULL, NULL, NULL, '2019-03-13', NULL, NULL, '119.187162', '26.050719');
INSERT INTO `class_room` VALUES (3, 2, '东三-201', '东三', 60, 0, NULL, NULL, NULL, '2019-03-05', NULL, NULL, '119.187162', '26.050719');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `CourseId` int(11) NOT NULL AUTO_INCREMENT,
  `OrganizationId` int(11) DEFAULT NULL,
  `ClassRoomSize` int(11) DEFAULT NULL,
  `ClassRoomName` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ClassRoomId` int(11) DEFAULT NULL,
  `TeacherId` int(11) DEFAULT NULL,
  `CourseName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `SchoolTime` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `StartTime` date DEFAULT NULL,
  `EndTime` date DEFAULT NULL,
  `StudentNum` int(11) DEFAULT NULL,
  `TeacherName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` date DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CourseAdminId` int(11) DEFAULT NULL,
  `StudentIdList` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `DayOfWeek` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `IsAttendance` int(11) UNSIGNED ZEROFILL DEFAULT NULL,
  PRIMARY KEY (`CourseId`) USING BTREE,
  INDEX `FK_course_course_admin`(`CourseAdminId`) USING BTREE,
  INDEX `FK_Reference_10`(`OrganizationId`) USING BTREE,
  INDEX `FK_Reference_11`(`TeacherId`) USING BTREE,
  INDEX `FK_Reference_9`(`ClassRoomId`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`OrganizationId`) REFERENCES `organization_dictionary` (`OrganizationId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`TeacherId`) REFERENCES `personnel` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`ClassRoomId`) REFERENCES `class_room` (`ClassRoomId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_course_course_admin` FOREIGN KEY (`CourseAdminId`) REFERENCES `course_admin` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 2, 80, '408楼', 2, 43, '高速网络原理', ',2,3,', '2019-03-12', '2019-06-14', 50, 'teacher', NULL, '2019-06-23', NULL, NULL, 1, ',44,45,', '星期三', 00000000001);
INSERT INTO `course` VALUES (3, 2, 78, '东三307', 1, 43, '专业英语', ',1,2,3,4,5,6,', '2019-03-12', '2019-06-13', 4, 'teacher', NULL, '2019-06-23', NULL, NULL, 4, ',44,55,45,', '星期二', 00000000000);
INSERT INTO `course` VALUES (7, 2, 90, '数计三号楼307', 1, 43, '工程实践', ',1,2,3,4,5，', '2019-03-12', '2019-06-29', 3, 'teacher', NULL, '2019-06-24', NULL, NULL, 3, ',55,57,58,', '星期六', 00000000000);

-- ----------------------------
-- Table structure for course_admin
-- ----------------------------
DROP TABLE IF EXISTS `course_admin`;
CREATE TABLE `course_admin`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` date DEFAULT NULL,
  `ModifyDate` date DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `OrganizationId` int(11) DEFAULT NULL,
  `IsOpen` int(4) UNSIGNED ZEROFILL DEFAULT 0000,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_admin
-- ----------------------------
INSERT INTO `course_admin` VALUES (1, '计算机高速网络', NULL, '2019-03-12', NULL, NULL, 2, 0000);
INSERT INTO `course_admin` VALUES (3, '工程实践', NULL, '2019-03-12', NULL, NULL, 2, 0000);
INSERT INTO `course_admin` VALUES (4, '专业英语', NULL, '2019-03-07', NULL, NULL, 2, 0000);
INSERT INTO `course_admin` VALUES (7, '数值分析', NULL, '2019-07-05', NULL, NULL, 2, 0000);

-- ----------------------------
-- Table structure for dictionary_detail
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_detail`;
CREATE TABLE `dictionary_detail`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `DictionaryId` int(11) DEFAULT NULL,
  `ItemKey` int(11) DEFAULT NULL,
  `IsDefault` bit(1) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `ItemValue` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_1`(`DictionaryId`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`DictionaryId`) REFERENCES `dictionarys` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for dictionarys
-- ----------------------------
DROP TABLE IF EXISTS `dictionarys`;
CREATE TABLE `dictionarys`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Code` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Description` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for organization_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `organization_dictionary`;
CREATE TABLE `organization_dictionary`  (
  `OrganizationId` int(11) NOT NULL AUTO_INCREMENT,
  `OrganizationName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`OrganizationId`) USING BTREE,
  INDEX `FK_Reference_7`(`ParentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = 'ѧУ-ѧԺ-ϵ-רҵ' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of organization_dictionary
-- ----------------------------
INSERT INTO `organization_dictionary` VALUES (1, '福州大学', 0, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (2, '数学与计算机学院', 1, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (3, '专硕一班', 2, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (5, '土木学院', 1, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (6, '清华大学', 0, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (9, '专硕一班', 2, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (11, '土木1班', 5, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (12, '经济与管理学院', 6, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (15, '经济与管理学院', 1, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (16, '财务管理一班', 15, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (19, '物信学院', 1, NULL, NULL, NULL, NULL);
INSERT INTO `organization_dictionary` VALUES (20, '物信一班', 19, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `URL` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `HTTPType` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `IsMenu` bit(1) DEFAULT NULL,
  `IsPage` bit(1) DEFAULT NULL,
  `Description` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  `Position` int(11) DEFAULT NULL,
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '系统设置', 'back/role/initfun', NULL, b'1', b'0', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (2, '角色管理', 'back/role/initfun', NULL, b'1', b'0', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (3, '功能管理', 'back/fun/initfun', NULL, b'1', b'0', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (4, '学生功能', 'wwww', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (7, '学生请假', 'xxxx', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (8, '学生签到', 'wwwww', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 4, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (9, '教师功能', 'wwwww', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (10, '查询课表', 'wwwww', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 9, NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES (11, '教师功能', 'www', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `OrganizationId` int(11) DEFAULT NULL,
  `Name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Sex` int(11) DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `JobNum` int(11) DEFAULT NULL,
  `PeopleNum` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EntryTime` date DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_15`(`OrganizationId`) USING BTREE,
  CONSTRAINT `personnel_ibfk_1` FOREIGN KEY (`OrganizationId`) REFERENCES `organization_dictionary` (`OrganizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = 'InnoDB free: 4096 kB; (`OrganizationId`) REFER `sas/organiza' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of personnel
-- ----------------------------
INSERT INTO `personnel` VALUES (1, 1, 1, 'admin', 1, 23, 2222, '2', '2019-06-09', NULL, NULL, NULL, NULL, '22@qq.com', 'headImg/dd938252-9744-48dc-bd80-709dcb7770a9.jpg');
INSERT INTO `personnel` VALUES (43, 38, 2, 'teacher', 0, 23, 180327000, '36255278626244', '2019-05-29', NULL, NULL, NULL, NULL, 'xwp2@qq.com', 'headImg/b8977f1f-3c10-4363-a90d-db395bccce68.jpg');
INSERT INTO `personnel` VALUES (44, 36, 2, 'student', 0, 24, 180327000, '36255278626244', '2019-06-24', NULL, NULL, NULL, NULL, '68156587@qq.com', 'headImg/317ee53d-7264-4087-969c-c05a2dfb7a86.jpg');
INSERT INTO `personnel` VALUES (45, 36, 3, 'lwf', 0, 23, 180327000, '36255278626244', '2019-06-10', NULL, NULL, NULL, NULL, '68156587@qq.com', 'headImg/85a341c5-8952-4d1c-bc00-2c466e67bdeb.jpg');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `SchoolId` int(11) DEFAULT NULL COMMENT '学校的机构id',
  `RoleName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`RoleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 1, '管理员', NULL, '2019-06-21 00:24:56', NULL, NULL);
INSERT INTO `role` VALUES (36, 1, '学生', NULL, '2019-06-09 16:00:13', NULL, NULL);
INSERT INTO `role` VALUES (38, 1, '教师', NULL, '2019-06-23 00:24:53', NULL, NULL);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `RoleId` int(11) DEFAULT NULL,
  `PermissionId` int(11) DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_5`(`PermissionId`) USING BTREE,
  INDEX `FK_Reference_6`(`RoleId`) USING BTREE,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`PermissionId`) REFERENCES `permission` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`RoleId`) REFERENCES `role` (`RoleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 125 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (100, 0, 1, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES (101, 0, 2, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES (102, 0, 3, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES (108, 38, 1, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES (109, 38, 2, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES (110, 38, 3, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES (123, 36, 1, NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES (124, 36, 3, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `StudentNum` int(11) NOT NULL,
  `OrganizationId` int(11) DEFAULT NULL,
  `StudentName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `StudentSex` int(11) DEFAULT NULL,
  `StudentAge` int(11) DEFAULT NULL,
  `StudentNumber` int(11) DEFAULT NULL,
  `PeopleNum` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EntranceTime` date DEFAULT NULL,
  `Grade` int(11) DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`StudentNum`) USING BTREE,
  INDEX `FK_Reference_12`(`OrganizationId`) USING BTREE,
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`OrganizationId`) REFERENCES `organization_dictionary` (`OrganizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 3, 'lwf', 1, 24, 180327048, '111111111111111', '2019-04-26', 2018, NULL, NULL, NULL, NULL, '123456789@qq.com', NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `TeacherId` int(11) NOT NULL AUTO_INCREMENT,
  `OrganizationId` int(11) DEFAULT NULL,
  `TeacherName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TeacherSex` int(11) DEFAULT NULL,
  `TeacherAge` int(11) DEFAULT NULL,
  `JobNum` int(11) DEFAULT NULL,
  `PeopleNum` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `EntryTime` date DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Email` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Image` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`TeacherId`) USING BTREE,
  INDEX `FK_Reference_15`(`OrganizationId`) USING BTREE,
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`OrganizationId`) REFERENCES `organization_dictionary` (`OrganizationId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 2, '郑老师', 1, 30, 2424, '333333333333', '2019-04-26', NULL, NULL, NULL, NULL, '14155255@qq.com', 'headImg/491493c9-35e7-4860-91a9-6946a118b570.png');
INSERT INTO `teacher` VALUES (2, 3, '迟老师', 1, 30, 3030, '36255278626244', '2019-05-10', NULL, NULL, NULL, NULL, '1450628865@qq.com', 'headImg/c4f9b840-d7c4-42d5-ad81-00afe3ac45ed.png');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `Id` int(11) NOT NULL,
  `AccountName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `RegisterTime` datetime(0) DEFAULT NULL,
  `LastLoginTime` datetime(0) DEFAULT NULL,
  `Image` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `Level` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '2019-06-01 15:58:26', '2019-06-01 15:58:29', NULL, NULL);
INSERT INTO `user_info` VALUES (43, 'teacher', '2019-06-23 21:22:30', '2019-06-23 21:22:33', NULL, NULL);
INSERT INTO `user_info` VALUES (44, 'student', '2019-06-23 21:22:36', '2019-06-23 21:22:40', NULL, NULL);
INSERT INTO `user_info` VALUES (45, 'lwf', '2019-06-23 21:22:43', '2019-06-23 21:22:45', NULL, NULL);
INSERT INTO `user_info` VALUES (55, 'fxh', '2019-06-23 21:22:56', '2019-06-23 21:22:58', NULL, NULL);
INSERT INTO `user_info` VALUES (57, 'lt', '2019-06-23 22:16:02', '2019-06-23 22:16:07', NULL, NULL);
INSERT INTO `user_info` VALUES (58, 'th', '2019-06-23 22:17:05', '2019-06-23 22:17:10', NULL, NULL);
INSERT INTO `user_info` VALUES (59, 'ly', '2019-06-23 22:20:05', '2019-06-23 22:20:10', NULL, NULL);

-- ----------------------------
-- Table structure for user_login_info
-- ----------------------------
DROP TABLE IF EXISTS `user_login_info`;
CREATE TABLE `user_login_info`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `LoginName` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `LoginPassWord` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `LoginType` int(11) DEFAULT NULL,
  `OrganizationId` int(11) DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`Id`) USING BTREE,
  INDEX `FK_Reference_2`(`UserId`) USING BTREE,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`UserId`) REFERENCES `user_info` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_login_info
-- ----------------------------
INSERT INTO `user_login_info` VALUES (1, 1, 'admin', '123456', NULL, 1);
INSERT INTO `user_login_info` VALUES (6, 43, 'teacher', '123456', NULL, 2);
INSERT INTO `user_login_info` VALUES (7, 44, 'student', '123456', NULL, 2);
INSERT INTO `user_login_info` VALUES (8, 45, 'lwf', '123456', NULL, 2);
INSERT INTO `user_login_info` VALUES (18, 55, 'fxh', '123456', NULL, 3);
INSERT INTO `user_login_info` VALUES (20, 57, 'lt', '123456', NULL, 3);
INSERT INTO `user_login_info` VALUES (21, 58, 'test', '123456', NULL, 3);
INSERT INTO `user_login_info` VALUES (22, 59, 'th', '123456', NULL, 3);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `Rol_Id` int(11) DEFAULT NULL,
  `CreateBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `CreateDate` datetime(0) DEFAULT NULL,
  `ModifyDate` datetime(0) DEFAULT NULL,
  `ModifyBy` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_4`(`Rol_Id`) USING BTREE,
  INDEX `FK_Reference_3`(`UserId`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`UserId`) REFERENCES `user_info` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`Rol_Id`) REFERENCES `role` (`RoleId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 36, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (18, 55, 36, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (19, 57, 36, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (20, 58, 36, NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES (21, 59, 36, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
