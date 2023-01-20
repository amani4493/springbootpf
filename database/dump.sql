/*
Navicat MySQL Data Transfer

Source Server         : developer@docker
Source Server Version : 50740
Source Host           : localhost:3306
Source Database       : pftwitter

Target Server Type    : MYSQL
Target Server Version : 50740
File Encoding         : 65001

Date: 2023-01-16 15:36:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `followers`
-- ----------------------------
DROP TABLE IF EXISTS `followers`;
CREATE TABLE `followers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `my_id` int(10) unsigned NOT NULL COMMENT '自分のユーザーID',
  `follower_id` int(10) unsigned NOT NULL COMMENT 'フォローワーのユーザID',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `followers_IX1` (`my_id`,`follower_id`),
  KEY `followers_IX2` (`follower_id`,`my_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='フォローワー';

-- ----------------------------
-- Records of followers
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tweet_id` int(10) unsigned NOT NULL COMMENT 'ツイートID',
  `user_id` int(10) unsigned NOT NULL COMMENT 'ユーザID',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `goods_IX1` (`tweet_id`,`user_id`),
  KEY `goods_IX2` (`user_id`,`tweet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='いいね';

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `images`
-- ----------------------------
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tweet_id` int(10) unsigned NOT NULL COMMENT 'ツイートid',
  `path` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '画像パス',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `images_IX1` (`tweet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='画像';

-- ----------------------------
-- Records of images
-- ----------------------------

-- ----------------------------
-- Table structure for `retweets`
-- ----------------------------
DROP TABLE IF EXISTS `retweets`;
CREATE TABLE `retweets` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `retweet_id` int(10) unsigned NOT NULL COMMENT 'リツイートID',
  `user_id` int(10) unsigned NOT NULL COMMENT 'ユーザID',
  `tweet_id` int(10) unsigned DEFAULT NULL COMMENT 'ツイートID',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `retweets_IX1` (`retweet_id`,`user_id`),
  KEY `retweets_IX2` (`user_id`,`retweet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='リツイート';

-- ----------------------------
-- Records of retweets
-- ----------------------------

-- ----------------------------
-- Table structure for `tweets`
-- ----------------------------
DROP TABLE IF EXISTS `tweets`;
CREATE TABLE `tweets` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(10) unsigned NOT NULL COMMENT 'ユーザーid',
  `body` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '本文',
  `parent_id` int(10) unsigned DEFAULT NULL COMMENT '親ツイートid',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `tweets_IX1` (`user_id`),
  KEY `tweets_IX2` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ツイート';

-- ----------------------------
-- Records of tweets
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'TwitterID',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'パスワード',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ハンドルネーム',
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '紹介文',
  `icon` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'アイコン',
  `birthday` date DEFAULT NULL COMMENT '生年月日',
  `header_image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'ヘッダー画像',
  `created` datetime DEFAULT NULL COMMENT '利用開始日',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime NOT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_IX1` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ユーザー';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'brnakina', 'pass', 'ぱぱちん', 'これは説明文です。', '/images/icon/brnakina.jpg', '1975-03-19', '/images/header/brnakina.jpg', '2023-01-16 08:11:27', '2023-01-16 08:11:27', '2023-01-16 08:11:27');
