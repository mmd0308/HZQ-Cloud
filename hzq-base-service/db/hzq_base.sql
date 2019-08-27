CREATE DATABASE  IF NOT EXISTS `hzq_base` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hzq_base`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: hzq_base
-- ------------------------------------------------------
-- Server version	5.7.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `base_dict`
--

DROP TABLE IF EXISTS `base_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_dict` (
  `id` varchar(64) NOT NULL,
  `code` varchar(45) DEFAULT NULL COMMENT '数据编码',
  `name` varchar(45) DEFAULT NULL COMMENT '字典名称',
  `dict_type` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(10) DEFAULT NULL,
  `del_flag` char(1) DEFAULT '0' COMMENT '0 否 1 是',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级id 顶层是 0',
  `parent_ids` varchar(1024) DEFAULT NULL COMMENT '所有的父级别id',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_dict`
--

LOCK TABLES `base_dict` WRITE;
/*!40000 ALTER TABLE `base_dict` DISABLE KEYS */;
/*!40000 ALTER TABLE `base_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_element`
--

DROP TABLE IF EXISTS `base_element`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_element` (
  `id` varchar(64) NOT NULL,
  `menu_id` varchar(64) DEFAULT NULL COMMENT '菜单id,按钮属于哪个菜单下面的',
  `name` varchar(100) DEFAULT NULL COMMENT '按钮名称',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标示',
  `href` varchar(255) DEFAULT NULL COMMENT '链接',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `element_type` varchar(45) DEFAULT NULL COMMENT '元素类型,button,url等',
  `method` varchar(10) DEFAULT NULL COMMENT '资源请求类型\n',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='按钮资源表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_element`
--

LOCK TABLES `base_element` WRITE;
/*!40000 ALTER TABLE `base_element` DISABLE KEYS */;
INSERT INTO `base_element` VALUES ('172ed1bcd443a296ede6dcaa5e643d04','44454745d308cf60fde88697caa0ca68','bbe','bd','sadf',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('30fde0dc155072decf271979b938019d','44454745d308cf60fde88697caa0ca68','bbeaa','bdaa','sadfaa',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('37c3cd51d04199ea60c10c72f80fba55','44454745d308cf60fde88697caa0ca68','bbe','bba','bb',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('79cca7c522599b1984baa82bf933c852','44454745d308cf60fde88697caa0ca68','bb','bb','bb',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `base_element` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_menu`
--

DROP TABLE IF EXISTS `base_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_menu` (
  `id` varchar(64) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '上级菜单id 顶级菜单父级id为0',
  `parent_ids` varchar(1024) DEFAULT NULL COMMENT '所有父级id,用“,”顺序分隔',
  `href` varchar(100) DEFAULT NULL COMMENT '链接',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标名称',
  `show_flag` char(1) DEFAULT '1' COMMENT '是否在菜单显示 0 否 1 是 默认是1',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限标示',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记 0 否 1是',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `serve_id` varchar(64) DEFAULT NULL COMMENT '服务id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_menu`
--

LOCK TABLES `base_menu` WRITE;
/*!40000 ALTER TABLE `base_menu` DISABLE KEYS */;
INSERT INTO `base_menu` VALUES ('0f0d8584facadeec00ea97efba7ca0c7','ff','6fede4f73ab4c971535336197bc1cde5','0,6fede4f73ab4c971535336197bc1cde5','ff','','','ewe','0',NULL,4,NULL,NULL,NULL,NULL,'79ce6e913014025cd91d7978f8948069'),('19d04cdfac53cc723f3688d0333e1e83','日志','979bc00862fb020aebcea219d9111ce1','0,979bc00862fb020aebcea219d9111ce1','log','','','log','0',NULL,2,NULL,NULL,NULL,NULL,'a3a3e4fa35b314d137cc06fbbd315708'),('3471026c3e89ad19f6896ac84a68f0c1','权限管理','0','0','auth','','','auth','0',NULL,0,NULL,NULL,NULL,NULL,'a3a3e4fa35b314d137cc06fbbd315708'),('44454745d308cf60fde88697caa0ca68','hello','0','0','aa','','','Hello','0',NULL,4,NULL,NULL,NULL,NULL,'79ce6e913014025cd91d7978f8948069'),('6fede4f73ab4c971535336197bc1cde5','ee','0','0','ee','','','eee','0',NULL,5,NULL,NULL,NULL,NULL,'79ce6e913014025cd91d7978f8948069'),('788eaea05abc01e3a80d050aecaffb9b','bb','81f2e7b131cf6cdb3f339245a22eecd2','0,81f2e7b131cf6cdb3f339245a22eecd2','bb','','','bb','0',NULL,0,NULL,NULL,NULL,NULL,'79ce6e913014025cd91d7978f8948069'),('79bc45839b29d008ba605c74d09ea7ec','接口文档','0','0','api','','','api','0',NULL,4,NULL,NULL,NULL,NULL,'a3a3e4fa35b314d137cc06fbbd315708'),('7fc56372f99c5d71fd7c3aa8ed5111a4','ff','0','0','fff','','','ff','0',NULL,0,NULL,NULL,NULL,NULL,'79ce6e913014025cd91d7978f8948069'),('81f2e7b131cf6cdb3f339245a22eecd2','版本','0','0','版本','','','多少啊','0',NULL,0,NULL,NULL,NULL,NULL,'79ce6e913014025cd91d7978f8948069'),('979bc00862fb020aebcea219d9111ce1','系统监控','0','0','/monitor','','','monitor','0',NULL,2,NULL,NULL,NULL,NULL,'a3a3e4fa35b314d137cc06fbbd315708'),('ccc9b7d9e68350b52f8b6820e34e30b2','角色管理','0','0','/v1/menus','','','BASE:ROLE','0',NULL,4,NULL,NULL,NULL,NULL,'79ce6e913014025cd91d7978f8948069'),('f1cfc1d035465dd37b9ef29fbf864c16','服务管理','0','0','serve','','','serve','0',NULL,0,NULL,NULL,NULL,NULL,'a3a3e4fa35b314d137cc06fbbd315708');
/*!40000 ALTER TABLE `base_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_role`
--

DROP TABLE IF EXISTS `base_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_role` (
  `id` varchar(64) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '数据值\n',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记删除标记 ‘0’ 没有删除, ‘1’ 删除\n\n\n',
  `sys_flag` char(1) DEFAULT '0' COMMENT '系统角色标记 ‘0’ 不是 ‘1’是',
  `create_by` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_by` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级别id 顶级默认是0',
  `parent_ids` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色管理表\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_role`
--

LOCK TABLES `base_role` WRITE;
/*!40000 ALTER TABLE `base_role` DISABLE KEYS */;
INSERT INTO `base_role` VALUES ('266b6d46690cf193bda40c29396dbc54','ee','dd','0','',NULL,NULL,NULL,NULL,NULL,NULL),('59242ea4104092c510d24a0882b9669d','b','b','0','',NULL,NULL,NULL,NULL,'0','0'),('5e38106d504e69387373a2f7c83ea71d','e','q','0','',NULL,NULL,NULL,NULL,NULL,NULL),('73b43b676423794c771fa3f8d8003d3b','ff','ff','0','',NULL,NULL,NULL,NULL,'0','0'),('93a5258180f0c306fa1a0de9eb1de895','bb','bb','0','1',NULL,NULL,NULL,NULL,'59242ea4104092c510d24a0882b9669d','0,59242ea4104092c510d24a0882b9669d'),('a','a',NULL,'0','0',NULL,NULL,NULL,NULL,'0',NULL),('e7971a12f73df365e1e5431442775f96','cc','cc','0','0',NULL,NULL,NULL,NULL,'0','0');
/*!40000 ALTER TABLE `base_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_serve`
--

DROP TABLE IF EXISTS `base_serve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_serve` (
  `id` varchar(64) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '服务名称',
  `status` varchar(45) DEFAULT NULL COMMENT '服务状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='服务管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_serve`
--

LOCK TABLES `base_serve` WRITE;
/*!40000 ALTER TABLE `base_serve` DISABLE KEYS */;
INSERT INTO `base_serve` VALUES ('79ce6e913014025cd91d7978f8948069','基础服务','stat'),('8f2c32ac31abf5d62d9116e5cbc8ee09','系统服务','算法'),('a3a3e4fa35b314d137cc06fbbd315708','平台管理',''),('e0a7bfa303f702086623ab6690947809','本事','色卡肌肤');
/*!40000 ALTER TABLE `base_serve` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `base_user`
--

DROP TABLE IF EXISTS `base_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_user` (
  `id` varchar(64) NOT NULL,
  `username` varchar(45) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(45) DEFAULT NULL COMMENT '注册邮箱',
  `sex` char(1) DEFAULT NULL COMMENT '0 男 1 女',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_user`
--

LOCK TABLES `base_user` WRITE;
/*!40000 ALTER TABLE `base_user` DISABLE KEYS */;
INSERT INTO `base_user` VALUES ('091538858ce5eda4401971b271137c2c','fsa','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','fdsa','fdsa','0',NULL,NULL),('0fe62b199fbc00b6c1c56680072d4df5','ee','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','we','eew','1',NULL,NULL),('611e4ddd51d60ed8dbb8056f3240a962','f','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','f','f','0',NULL,NULL),('79329e25e926735d80babc3e70852df2','admin','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','skjfa','salfj','0',NULL,NULL),('7f07ec4eadf542fa8604094f09bac212','a','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','a','a','0',NULL,NULL),('8175be3c49c3b82f79e78d5978e97cc6','c','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','d','d','1',NULL,NULL),('8ad71d629e7eb38ca026612746cb3911','bb','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','b','bb','0',NULL,NULL),('96ff394a4e4934c00cc5a264a7555e49','aaa','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','aa','aa','0',NULL,NULL),('bade1c3d3915ed289e5b7635a4c6356f','c','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','c','c','1',NULL,NULL),('ef77919ac32df4b70b15ad9a02e1ae21','test','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','lkfjsd','test@163.com','0',NULL,NULL),('f741d6153a894f6218d2fcdc3b824a45','b','$2a$10$dFSNduLMn2tQ73IhoDVzYOamKF3hrHzp9A/.aQUWGv37AMxwWSUpm','b','b','0',NULL,NULL);
/*!40000 ALTER TABLE `base_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rl_role_resource`
--

DROP TABLE IF EXISTS `rl_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rl_role_resource` (
  `id` varchar(64) NOT NULL,
  `role_id` varchar(64) DEFAULT NULL COMMENT '角色',
  `serve_id` varchar(64) DEFAULT NULL COMMENT '服务id',
  `menu_id` varchar(64) DEFAULT NULL COMMENT '菜单id',
  `element_id` varchar(64) DEFAULT NULL COMMENT '元素id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色和资源关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rl_role_resource`
--

LOCK TABLES `rl_role_resource` WRITE;
/*!40000 ALTER TABLE `rl_role_resource` DISABLE KEYS */;
INSERT INTO `rl_role_resource` VALUES ('07d729beafac4aafa4274f7c43d46998','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','44454745d308cf60fde88697caa0ca68','30fde0dc155072decf271979b938019d'),('0929badfe7395b787fd07620be929bf3','59242ea4104092c510d24a0882b9669d','a3a3e4fa35b314d137cc06fbbd315708','3471026c3e89ad19f6896ac84a68f0c1',NULL),('09b6582ca49ee0a772663f9171ba48ba','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','',''),('0c57d0c4d80ca0d69696da3a216c0130','59242ea4104092c510d24a0882b9669d','a3a3e4fa35b314d137cc06fbbd315708','79bc45839b29d008ba605c74d09ea7ec',NULL),('0d537fe612c349089403a06a00673cd8','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','44454745d308cf60fde88697caa0ca68','37c3cd51d04199ea60c10c72f80fba55'),('1a2e0731f29cbef4e54bfcf5a8dd24f1','59242ea4104092c510d24a0882b9669d','8f2c32ac31abf5d62d9116e5cbc8ee09','',''),('25fbecd69d10e5e86d1c6063a4e84b48','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','0f0d8584facadeec00ea97efba7ca0c7',NULL),('26da69f59c0340f2abf6d0ca780243f6','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','44454745d308cf60fde88697caa0ca68','172ed1bcd443a296ede6dcaa5e643d04'),('3429cf19f8d4cab4d420ac4dd118bd14','59242ea4104092c510d24a0882b9669d','8f2c32ac31abf5d62d9116e5cbc8ee09','',''),('48f6d4f81b79e7deead96629324176a5','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','6fede4f73ab4c971535336197bc1cde5',NULL),('6c09458d18805768268eaca4763f2149','59242ea4104092c510d24a0882b9669d','8f2c32ac31abf5d62d9116e5cbc8ee09','',''),('6c3b1111ce85a4f2fc58a2137dbe3599','59242ea4104092c510d24a0882b9669d','a3a3e4fa35b314d137cc06fbbd315708','19d04cdfac53cc723f3688d0333e1e83',NULL),('6d73711ec6bf660b9dd9ae18b88975f1','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','81f2e7b131cf6cdb3f339245a22eecd2',NULL),('78e2b2c6f047466d7e78db855ee04900','59242ea4104092c510d24a0882b9669d','8f2c32ac31abf5d62d9116e5cbc8ee09','',''),('992ce5ed1abf04b767772a3d7e861fa0','59242ea4104092c510d24a0882b9669d','8f2c32ac31abf5d62d9116e5cbc8ee09','',''),('d8ccc5579eb4e01948c42680d1c89799','59242ea4104092c510d24a0882b9669d','a3a3e4fa35b314d137cc06fbbd315708','979bc00862fb020aebcea219d9111ce1',NULL),('decab891b9ef5cba2919fc170a687994','59242ea4104092c510d24a0882b9669d','a3a3e4fa35b314d137cc06fbbd315708','',''),('fb559c556b04463d885f9cedc169f4ee','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','44454745d308cf60fde88697caa0ca68','79cca7c522599b1984baa82bf933c852'),('fbcd4b2b0def89dbc4d83ce216f69ca1','59242ea4104092c510d24a0882b9669d','79ce6e913014025cd91d7978f8948069','ccc9b7d9e68350b52f8b6820e34e30b2',NULL);
/*!40000 ALTER TABLE `rl_role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rl_user_role`
--

DROP TABLE IF EXISTS `rl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rl_user_role` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户id',
  `role_Id` varchar(64) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rl_user_role`
--

LOCK TABLES `rl_user_role` WRITE;
/*!40000 ALTER TABLE `rl_user_role` DISABLE KEYS */;
INSERT INTO `rl_user_role` VALUES ('0fe62b199fbc00b6c1c56680072d4df5','79329e25e926735d80babc3e70852df2','59242ea4104092c510d24a0882b9669d'),('65a8f3a021524ef682764a6819066314','f741d6153a894f6218d2fcdc3b824a45','59242ea4104092c510d24a0882b9669d'),('90aa496023e641e8b83a4de765cae8e9','8175be3c49c3b82f79e78d5978e97cc6','59242ea4104092c510d24a0882b9669d'),('90f48830110e49dcafbb308c39b4ce62','611e4ddd51d60ed8dbb8056f3240a962','59242ea4104092c510d24a0882b9669d'),('ac42eca5fe694b45b3c31bb0e902a2c7','79329e25e926735d80babc3e70852df2','266b6d46690cf193bda40c29396dbc54'),('ddb4074ba69c46d1acb6b6740cc89918','ef77919ac32df4b70b15ad9a02e1ae21','59242ea4104092c510d24a0882b9669d'),('df52443daaf244ccb2e276493af7492f','96ff394a4e4934c00cc5a264a7555e49','59242ea4104092c510d24a0882b9669d'),('ed6262e5630a4d3c99672e383b74ebf8','7f07ec4eadf542fa8604094f09bac212','59242ea4104092c510d24a0882b9669d');
/*!40000 ALTER TABLE `rl_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-27 19:58:39
