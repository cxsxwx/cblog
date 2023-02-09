/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50559
 Source Host           : localhost:3306
 Source Schema         : cblog

 Target Server Type    : MySQL
 Target Server Version : 50559
 File Encoding         : 65001

 Date: 09/02/2023 09:41:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for authorandadmin
-- ----------------------------
DROP TABLE IF EXISTS `authorandadmin`;
CREATE TABLE `authorandadmin`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `information` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of authorandadmin
-- ----------------------------
INSERT INTO `authorandadmin` VALUES (1, 'cxsxwx', '17674096162', NULL);

-- ----------------------------
-- Table structure for blog_posts
-- ----------------------------
DROP TABLE IF EXISTS `blog_posts`;
CREATE TABLE `blog_posts`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `posted_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `love` int(20) NULL DEFAULT NULL COMMENT '点赞数',
  `update_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改时间',
  `pview` int(20) NULL DEFAULT NULL COMMENT '浏览数量',
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属分类',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `mfile` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '编译后的文件',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_posts
-- ----------------------------
INSERT INTO `blog_posts` VALUES (26, 'javaScript箭头函数', '# javaScript箭头函数\nm:首先开始，我们来看一下没有使用箭头函数的语法\n```javaScript\nlet hello = function(){\n    console.log(\"hello\");\n}\n```\n::: hljs-right\n\ny:那么使用箭头函数是什么样子的？\n\n:::\nm:这是使用箭头函数的样子\n```javaScript\nlet hello = () =>{\n    console.log(\"hello\");\n}\n```\nm:是不是变短了呢？\n::: hljs-right\n\ny:嗯嗯，是的；\ny:那如果我们有参数怎么办呢？\n:::\nm：其实很简单，看代码\n```javaScript\nlet hello = (name) =>{\n    console.log(\"hello,\" + name);\n}\n```\n::: hljs-right\n\ny:哇，是的耶(＾－＾)V；\ny:但我还是感觉太长了，还可以再简写一点吗？\n:::\nm:当然，向这种只有函数中只有一行代码的可以将其写成一行，比如：\n```javaScript\nlet hello = () => console.log(\"hello\");\n```\nm:如果参数只有一个，我们也可以去掉括号，比如：\n```javaScript\nlet hello = name => console.log(\"hello\" + name);\n```\nm:好了，今天带大家了解了一下箭头函数的基本用法，不知是否起到了一点一点小小的帮助呢？', '2022-03-14 19:51:32', 999, '2022-03-14 19:51:32', 0, '1', 'cxsxwx', '<h1><a id=\"javaScript_0\"></a>javaScript箭头函数</h1>\n<p>m:首先开始，我们来看一下没有使用箭头函数的语法</p>\n<pre><div class=\"hljs\"><code class=\"lang-javaScript\"><span class=\"hljs-keyword\">let</span> hello = <span class=\"hljs-keyword\">function</span>(<span class=\"hljs-params\"></span>){\n    <span class=\"hljs-variable language_\">console</span>.<span class=\"hljs-title function_\">log</span>(<span class=\"hljs-string\">&quot;hello&quot;</span>);\n}\n</code></div></pre>\n<div class=\"hljs-right\">\n<p>y:那么使用箭头函数是什么样子的？</p>\n</div>\n<p>m:这是使用箭头函数的样子</p>\n<pre><div class=\"hljs\"><code class=\"lang-javaScript\"><span class=\"hljs-keyword\">let</span> <span class=\"hljs-title function_\">hello</span> = (<span class=\"hljs-params\"></span>) =&gt;{\n    <span class=\"hljs-variable language_\">console</span>.<span class=\"hljs-title function_\">log</span>(<span class=\"hljs-string\">&quot;hello&quot;</span>);\n}\n</code></div></pre>\n<p>m:是不是变短了呢？</p>\n<div class=\"hljs-right\">\n<p>y:嗯嗯，是的；<br />\ny:那如果我们有参数怎么办呢？</p>\n</div>\n<p>m：其实很简单，看代码</p>\n<pre><div class=\"hljs\"><code class=\"lang-javaScript\"><span class=\"hljs-keyword\">let</span> <span class=\"hljs-title function_\">hello</span> = (<span class=\"hljs-params\">name</span>) =&gt;{\n    <span class=\"hljs-variable language_\">console</span>.<span class=\"hljs-title function_\">log</span>(<span class=\"hljs-string\">&quot;hello,&quot;</span> + name);\n}\n</code></div></pre>\n<div class=\"hljs-right\">\n<p>y:哇，是的耶(＾－＾)V；<br />\ny:但我还是感觉太长了，还可以再简写一点吗？</p>\n</div>\n<p>m:当然，向这种只有函数中只有一行代码的可以将其写成一行，比如：</p>\n<pre><div class=\"hljs\"><code class=\"lang-javaScript\"><span class=\"hljs-keyword\">let</span> <span class=\"hljs-title function_\">hello</span> = (<span class=\"hljs-params\"></span>) =&gt; <span class=\"hljs-variable language_\">console</span>.<span class=\"hljs-title function_\">log</span>(<span class=\"hljs-string\">&quot;hello&quot;</span>);\n</code></div></pre>\n<p>m:如果参数只有一个，我们也可以去掉括号，比如：</p>\n<pre><div class=\"hljs\"><code class=\"lang-javaScript\"><span class=\"hljs-keyword\">let</span> <span class=\"hljs-title function_\">hello</span> = name =&gt; <span class=\"hljs-variable language_\">console</span>.<span class=\"hljs-title function_\">log</span>(<span class=\"hljs-string\">&quot;hello&quot;</span> + name);\n</code></div></pre>\n<p>m:好了，今天带大家了解了一下箭头函数的基本用法，不知是否起到了一点一点小小的帮助呢？</p>\n', NULL, 'ES6 中引入了箭头函数。箭头函数允许我们编写更短的函数');
INSERT INTO `blog_posts` VALUES (27, '内容', '# aaa\n\n我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣', '2022-03-16 15:37:19', 999, '2022-03-28 08:53:53', 0, '3', 'csw', '<h1><a id=\"aaa_0\"></a>aaa</h1>\n<p>我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣我是内容荣</p>\n', NULL, '测试');
INSERT INTO `blog_posts` VALUES (28, '我是内容', '内容内容', '2022-03-28 09:16:23', 999, '2022-03-28 09:16:23', 0, '3', 'csw', '<p>内容内容</p>\n', NULL, '内容');
INSERT INTO `blog_posts` VALUES (29, '测试', NULL, NULL, 1, NULL, 1, NULL, 'csw', NULL, NULL, NULL);
INSERT INTO `blog_posts` VALUES (30, '测试', NULL, NULL, 1, NULL, 1, NULL, 'csw', NULL, NULL, NULL);
INSERT INTO `blog_posts` VALUES (31, '测试', NULL, NULL, 1, NULL, 1, NULL, 'csw', NULL, NULL, NULL);
INSERT INTO `blog_posts` VALUES (32, '测试', NULL, NULL, 1, NULL, 1, NULL, 'csw', NULL, NULL, NULL);
INSERT INTO `blog_posts` VALUES (33, '测试', NULL, NULL, 1, NULL, 1, NULL, 'csw', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for c_label
-- ----------------------------
DROP TABLE IF EXISTS `c_label`;
CREATE TABLE `c_label`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `label_id` int(20) NULL DEFAULT NULL,
  `blog_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 76 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of c_label
-- ----------------------------
INSERT INTO `c_label` VALUES (38, 25, 24);
INSERT INTO `c_label` VALUES (40, 25, 33);
INSERT INTO `c_label` VALUES (41, 25, 36);
INSERT INTO `c_label` VALUES (42, 25, 40);
INSERT INTO `c_label` VALUES (70, 36, 26);
INSERT INTO `c_label` VALUES (73, 36, 27);
INSERT INTO `c_label` VALUES (74, 36, 28);
INSERT INTO `c_label` VALUES (75, 24, 28);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'java');
INSERT INTO `category` VALUES (3, 'js');
INSERT INTO `category` VALUES (4, 'springCloud');
INSERT INTO `category` VALUES (5, 'html');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES (24, 'java');
INSERT INTO `label` VALUES (36, 'js');
INSERT INTO `label` VALUES (37, '测试');
INSERT INTO `label` VALUES (38, 'springCloud');
INSERT INTO `label` VALUES (39, 'springBoot');

SET FOREIGN_KEY_CHECKS = 1;
