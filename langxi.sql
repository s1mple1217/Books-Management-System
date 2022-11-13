/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : langxi

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 13/11/2022 16:56:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'zhangsan', '123');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '西游记', '吴承恩', '不可借阅', 65.00, '文学');
INSERT INTO `book` VALUES (2, '红楼梦', '曹雪芹', '可借', 55.00, '文学');
INSERT INTO `book` VALUES (3, 'Java', '张三', '可借', 105.00, 'it');
INSERT INTO `book` VALUES (4, '深入理解Java虚拟机', '李四', '可借', 75.00, 'it');
INSERT INTO `book` VALUES (5, '数据库原理', '许薇', '可借', 55.00, 'it');
INSERT INTO `book` VALUES (6, '活着', '余华', '可借', 35.00, '小说');
INSERT INTO `book` VALUES (7, '百年孤独', '加西亚·马尔克斯', '可借', 40.00, '小说');
INSERT INTO `book` VALUES (8, '复活', '列夫·托尔斯泰', '可借', 45.00, '文学');
INSERT INTO `book` VALUES (9, 'spring6', '张三', '可借', 50.00, 'it');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `borrowtime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `returntime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES (15, 'lyj', 'Java', '2022-11-08 12:14:44', '2022-11-11 07:17:50');
INSERT INTO `borrow` VALUES (16, 'sss', '红楼梦', '2022-11-09 10:44:12', '2022-11-09 10:44:46');
INSERT INTO `borrow` VALUES (19, 'syp', '数据库原理', '2022-11-03 11:45:33', '2022-11-03 11:45:45');
INSERT INTO `borrow` VALUES (20, 'sss', '红楼梦', '2022-11-09 10:44:12', '2022-11-09 10:44:46');
INSERT INTO `borrow` VALUES (21, 'sss', '红楼梦', '2022-11-09 10:44:12', '2022-11-09 10:44:46');
INSERT INTO `borrow` VALUES (22, 'lyj', 'Java', '2022-11-08 12:14:44', '2022-11-11 07:17:50');
INSERT INTO `borrow` VALUES (23, 'syp', '西游记', '2022-11-05 10:53:08', NULL);
INSERT INTO `borrow` VALUES (24, 'sss', '红楼梦', '2022-11-09 10:44:12', '2022-11-09 10:44:46');
INSERT INTO `borrow` VALUES (25, 'lyj', 'Java', '2022-11-08 12:14:44', '2022-11-11 07:17:50');
INSERT INTO `borrow` VALUES (26, 'sss', '红楼梦', '2022-11-09 10:44:12', '2022-11-09 10:44:46');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bookname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `money` decimal(64, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lisi', '123', 100);
INSERT INTO `user` VALUES (2, 'syp', '123', NULL);
INSERT INTO `user` VALUES (3, 'lyj', '123', NULL);
INSERT INTO `user` VALUES (6, 'aaa', 'aaa', NULL);
INSERT INTO `user` VALUES (7, 'sss', 'sss', NULL);

SET FOREIGN_KEY_CHECKS = 1;
