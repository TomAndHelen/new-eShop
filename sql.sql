CREATE DATABASE  IF NOT EXISTS `shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_good`
--

DROP TABLE IF EXISTS `t_good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_good` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `sales` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `type` int DEFAULT NULL,
  `detail` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_good`
--

LOCK TABLES `t_good` WRITE;
/*!40000 ALTER TABLE `t_good` DISABLE KEYS */;
INSERT INTO `t_good` VALUES (1,'商品1号',10.00,19,81,0,'简介1'),(2,'商品2号',20.00,8,92,1,'简介2'),(3,'商品3号',30.00,7,93,0,'简介3'),(4,'商品4号',40.00,0,100,1,'简介4'),(5,'商品5号',50.00,0,100,0,'简介5'),(6,'商品6号',60.00,0,100,1,'简介6'),(8,'商品8号',80.00,0,100,0,'简介7'),(9,'更新商品',25.50,18,15,1,'简介8'),(10,'商品10号',100.00,0,100,1,'简介10');
/*!40000 ALTER TABLE `t_good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_history`
--

DROP TABLE IF EXISTS `t_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_history` (
  `userid` int DEFAULT NULL,
  `goodid` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_history`
--

LOCK TABLES `t_history` WRITE;
/*!40000 ALTER TABLE `t_history` DISABLE KEYS */;
INSERT INTO `t_history` VALUES (1,2,'商品2号',1,'2021-05-20 21:37:12'),(5,9,'更新商品',1,'2021-05-23 18:47:07'),(5,9,'更新商品',1,'2021-05-24 16:16:24'),(5,3,'商品3号',0,'2021-05-24 16:16:32'),(1,1,'商品1号',0,'2021-05-24 16:18:56'),(4,2,'商品2号',1,'2021-05-24 16:25:44');
/*!40000 ALTER TABLE `t_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_iologs`
--

DROP TABLE IF EXISTS `t_iologs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_iologs` (
  `id` int DEFAULT NULL,
  `ip` varchar(30) DEFAULT NULL,
  `iotime` varchar(40) DEFAULT NULL,
  `behaviour` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_iologs`
--

LOCK TABLES `t_iologs` WRITE;
/*!40000 ALTER TABLE `t_iologs` DISABLE KEYS */;
INSERT INTO `t_iologs` VALUES (1,'0:0:0:0:0:0:0:1','2021-05-20 21:36:46','logout'),(1,'0:0:0:0:0:0:0:1','2021-05-20 21:36:56','login'),(1,'0:0:0:0:0:0:0:1','2021-05-20 21:37:36','logout'),(1,'221.4.34.177','2021-05-23 18:30:18','login'),(1,'221.4.34.177','2021-05-23 18:30:31','logout'),(1,'221.4.34.177','2021-05-23 18:32:46','login'),(5,'221.4.34.247','2021-05-23 18:46:41','login'),(5,'221.4.34.247','2021-05-24 16:13:03','login'),(5,'221.4.34.247','2021-05-24 16:14:39','login'),(1,'221.4.34.177','2021-05-24 16:18:48','login'),(5,'221.4.34.247','2021-05-24 16:20:16','login'),(1,'221.4.34.177','2021-05-24 16:22:07','logout'),(4,'221.4.34.177','2021-05-24 16:22:20','login'),(5,'221.4.34.247','2021-05-24 16:23:12','login'),(4,'221.4.34.177','2021-05-24 16:25:26','login'),(5,'221.4.34.177','2021-05-24 16:28:29','login'),(5,'221.4.34.247','2021-05-24 18:18:31','login'),(5,'221.4.34.247','2021-05-25 09:51:01','login'),(5,'223.104.63.101','2021-05-25 14:09:14','login'),(1,'223.104.63.101','2021-05-25 15:06:22','login'),(1,'223.104.63.101','2021-05-25 15:06:34','logout'),(1,'223.104.63.101','2021-05-25 15:06:59','login');
/*!40000 ALTER TABLE `t_iologs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_oplogs`
--

DROP TABLE IF EXISTS `t_oplogs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_oplogs` (
  `id` int DEFAULT NULL,
  `optime` varchar(45) DEFAULT NULL,
  `behaviour` varchar(45) DEFAULT NULL,
  `ip` varchar(45) DEFAULT NULL,
  `obj` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_oplogs`
--

LOCK TABLES `t_oplogs` WRITE;
/*!40000 ALTER TABLE `t_oplogs` DISABLE KEYS */;
INSERT INTO `t_oplogs` VALUES (1,'2021-05-25 15:07:30','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:33','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:33','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:33','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:36','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:36','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:36','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:36','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:36','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:07:36','alter','223.104.63.101','商品1号'),(1,'2021-05-25 15:09:21','add','223.104.63.101','1'),(1,'2021-05-25 15:09:32','del','223.104.63.101','1');
/*!40000 ALTER TABLE `t_oplogs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order` (
  `orderId` varchar(50) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES ('16218440361505','2021-05-24 16:13:56',20.00,5),('16218442130075','2021-05-24 16:16:53',40.00,5),('16218443566461','2021-05-24 16:19:16',10.00,1),('16218444323865','2021-05-24 16:20:32',10.00,5),('16218445558004','2021-05-24 16:22:35',10.00,4),('16218446308175','2021-05-24 16:23:50',20.00,5),('16218447592274','2021-05-24 16:25:59',20.00,4),('16218449257725','2021-05-24 16:28:45',30.00,5),('16219075093205','2021-05-25 09:51:49',178.50,5),('16219076850665','2021-05-25 09:54:45',20.00,5);
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_item`
--

DROP TABLE IF EXISTS `t_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `count` int DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `totalPrice` decimal(11,2) DEFAULT NULL,
  `orderId` varchar(50) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`orderId`) REFERENCES `t_order` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_item`
--

LOCK TABLES `t_order_item` WRITE;
/*!40000 ALTER TABLE `t_order_item` DISABLE KEYS */;
INSERT INTO `t_order_item` VALUES (19,'商品1号',2,10.00,20.00,'16218440361505',0),(20,'商品1号',4,10.00,40.00,'16218442130075',0),(21,'商品1号',1,10.00,10.00,'16218443566461',0),(22,'商品1号',1,10.00,10.00,'16218444323865',0),(23,'商品1号',1,10.00,10.00,'16218445558004',0),(24,'商品1号',2,10.00,20.00,'16218446308175',0),(25,'商品2号',1,20.00,20.00,'16218447592274',1),(26,'商品3号',1,30.00,30.00,'16218449257725',0),(27,'更新商品',7,25.50,178.50,'16219075093205',1),(28,'商品1号',2,10.00,20.00,'16219076850665',0);
/*!40000 ALTER TABLE `t_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','admin','840165852@qq.com'),(2,'user1','121212','xiaojianpeng1102@outlook.com'),(3,'user2','121212','2456778752@qq.com'),(4,'xiaojianpeng','121212','abc@aa.com'),(5,'1234444','123456','12345@qq.com');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-30 10:34:53
