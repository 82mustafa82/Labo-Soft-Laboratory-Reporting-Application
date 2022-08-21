CREATE DATABASE  IF NOT EXISTS `jpa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jpa`;
-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: localhost    Database: jpa
-- ------------------------------------------------------
-- Server version	8.0.30-0ubuntu0.20.04.2

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
-- Table structure for table `laborant`
--

DROP TABLE IF EXISTS `laborant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laborant` (
  `lid` int NOT NULL AUTO_INCREMENT,
  `hospital_no` varchar(7) NOT NULL,
  `laborant_first_name` varchar(20) NOT NULL,
  `laborant_last_name` varchar(20) NOT NULL,
  PRIMARY KEY (`lid`),
  UNIQUE KEY `UK_owth29gjr3h28yvfq05kh0fxm` (`hospital_no`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laborant`
--

LOCK TABLES `laborant` WRITE;
/*!40000 ALTER TABLE `laborant` DISABLE KEYS */;
INSERT INTO `laborant` VALUES (1,'1111111','Aizhan','Maksatbekyzy'),(3,'2222222','Dilara','Tanrikulu'),(9,'3333333','Furkan','Ercelebi'),(10,'4444444','Omer','Demir'),(11,'5555555','Efe','Tezcan'),(14,'6666667','Ozgur','Kan'),(15,'1601170','Mustafa','Aydin'),(16,'1601108','Fatma','Tanrikulu'),(17,'1234567','Busra','Kuden'),(18,'8901234','Yunus','Demir'),(19,'5678901','Betul','Ozmaral'),(20,'2345678','Betul','On');
/*!40000 ALTER TABLE `laborant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `rid` int NOT NULL AUTO_INCREMENT,
  `add_date` varchar(255) DEFAULT NULL,
  `diagnosis` varchar(50) NOT NULL,
  `identity` varchar(11) NOT NULL,
  `number` varchar(7) NOT NULL,
  `patient_first_name` varchar(20) NOT NULL,
  `patient_last_name` varchar(20) NOT NULL,
  `report_definition` longtext NOT NULL,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `UK_kgvoscl91gqqvv0lwrskguiji` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (1,'2022-08-11 00:00:00.000000','Timely Cancer','11111111111','1111','Duygu','Erduran','asd'),(4,'2022-08-11 00:00:00.000000','Human Brucellosis','33333333333','3333','Yusuf','Baskoy','asd'),(10,'2022-08-10 00:00:00.000000','von Willebrand Disease','55555555555','5555','Kaan','Akinturk','asd'),(11,'2022-08-09 00:00:00.000000','Lung Cancer','66666666666','6666','Furkan','Oguz','asd'),(12,'2022-08-11 00:00:00.000000','Prostate Cancer','12345678901','1234','Zeynep','Danis','asd'),(13,'2022-08-11 00:00:00.000000','Lymphoma','23456789012','5678','Semih','Durmaz','asd'),(14,'2022-08-11 00:00:00.000000','Rapid Cancer','45678901234','3456','Furkan','Kocyigit','asd'),(15,'2020-07-07 00:00:00.000000','Skin Cancer','56789012345','7890','Betul','Sinar','asd'),(16,'2022-08-11 00:00:00.000000','Infectious Disease','67890123456','0987','Halid','Sipahioglu','asd'),(17,'2020-09-09 00:00:00.000000','Cancer','34567890123','9012','Sena','Ocakci','asd'),(25,'2020-02-02 00:00:00.000000','Primary Ciliary Dyskinesia','44444444444','4444','Enes','Tezcan','asd');
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report_laborant`
--

DROP TABLE IF EXISTS `report_laborant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report_laborant` (
  `rid` int NOT NULL,
  `lid` int NOT NULL,
  PRIMARY KEY (`rid`,`lid`),
  KEY `FKffmofsqpleggqvhquu51f6nhk` (`lid`),
  CONSTRAINT `FK83e7udr9ad9eyhyts6c94rerx` FOREIGN KEY (`rid`) REFERENCES `report` (`rid`),
  CONSTRAINT `FKffmofsqpleggqvhquu51f6nhk` FOREIGN KEY (`lid`) REFERENCES `laborant` (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report_laborant`
--

LOCK TABLES `report_laborant` WRITE;
/*!40000 ALTER TABLE `report_laborant` DISABLE KEYS */;
INSERT INTO `report_laborant` VALUES (1,1),(4,3),(11,3),(4,9),(10,9),(4,10),(10,10),(11,10),(25,10),(1,11),(25,11),(1,14),(12,15),(13,15),(12,16),(13,16),(17,16),(14,17),(16,18),(14,19),(15,19),(15,20),(16,20);
/*!40000 ALTER TABLE `report_laborant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `password` varchar(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_name` varchar(20) NOT NULL,
  `lid` int DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  KEY `FKbocpj2nsacg7guy1wx9hsuu7u` (`lid`),
  CONSTRAINT `FKbocpj2nsacg7guy1wx9hsuu7u` FOREIGN KEY (`lid`) REFERENCES `laborant` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'123456','laborant','aizhan',1),(2,'benzema','laborant','dilara',3),(5,'fatma','admin','mustafa',15),(6,'mustafa','laborant','fatma',16);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-21 19:10:36
