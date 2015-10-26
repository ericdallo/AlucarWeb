-- MySQL dump 10.13  Distrib 5.6.25, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: alucar
-- ------------------------------------------------------
-- Server version	5.6.25-0ubuntu0.15.04.1

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
-- Table structure for table `agency`
--

DROP TABLE IF EXISTS `agency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
/*!40000 ALTER TABLE `agency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` bit(1) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `chassi` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `controlKm` varchar(255) DEFAULT NULL,
  `freeKm` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `km` varchar(255) DEFAULT NULL,
  `licensePlate` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `obs` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (1,'','Teste','Teste','Bagulhos','52,00','22,00','https://s3-us-west-2.amazonaws.com/alucar-tcc-satan/images/car_users/1-viper_hd.png','Teste','92842','Fabrica de testes','Modelo Satanico','este é um teste','SP'),(2,'','aisojd','jasoidj','Sao teste de teste','39','22','https://s3-us-west-2.amazonaws.com/alucar-tcc-satan/images/car_users/2-c15doors_hd.png',NULL,'9292829','Fabricandate asdasd','Modelo 123 mudar','teste teste teste teste','SP'),(3,'','askdml','asdokasdn','asdaopsd','833','28','https://s3-us-west-2.amazonaws.com/alucar-tcc-satan/images/car_users/3-i8_hd.png','29','23892380','aaiosjdoiajsd','asdoiajsd','alsdnlkansd','SP');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `addressNumber` varchar(255) NOT NULL,
  `born` date DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) NOT NULL,
  `licenseCity` varchar(255) DEFAULT NULL,
  `licenseCode` varchar(255) DEFAULT NULL,
  `licenseState` varchar(255) DEFAULT NULL,
  `licenseValidity` date DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `postalCode` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Rua 123 de satan','666','1995-09-25','Bagulhos','4949595955','eriasd','F','Baguhlos','1231','SP','1998-02-19','Joao','Penha',NULL,'03633020','SP'),(2,'Teste','22','1998-12-12','Teste','222200','Teste@Teste','M','Teste','Teste','SP','2015-12-12','Teste','Teste',NULL,'22222222','RJ'),(3,'9','9','2015-12-12','9','9','9','F','9','9','SP','2018-04-12','292922222922922','9',NULL,'9','SP'),(6,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(8,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(10,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(11,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(12,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(13,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(15,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(17,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(19,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(20,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(21,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(22,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP'),(23,'ijo','ij','2015-12-12','oi','213123','qweqwe','F','io','oij','SP','2017-09-12','Teste123 de oliveira testado','ioj',NULL,'jiioj','SP');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devolution`
--

DROP TABLE IF EXISTS `devolution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devolution` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devolutionDate` date DEFAULT NULL,
  `totalValue` double NOT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_77hoi3kmxgqu3n6w14cnqqddj` (`agency_id`),
  CONSTRAINT `FK_77hoi3kmxgqu3n6w14cnqqddj` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolution`
--

LOCK TABLES `devolution` WRITE;
/*!40000 ALTER TABLE `devolution` DISABLE KEYS */;
INSERT INTO `devolution` VALUES (1,'2015-12-12',0,NULL);
/*!40000 ALTER TABLE `devolution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createdAt` date DEFAULT NULL,
  `killometerType` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `devolution_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_iuo7m80kmrx80tjs3emcga1ey` (`car_id`),
  KEY `FK_3jsq9x8n2ydbo20cvc0yomcf8` (`client_id`),
  KEY `FK_1vt6t4h14rti28r3lkwxyu81o` (`devolution_id`),
  CONSTRAINT `FK_1vt6t4h14rti28r3lkwxyu81o` FOREIGN KEY (`devolution_id`) REFERENCES `devolution` (`id`),
  CONSTRAINT `FK_3jsq9x8n2ydbo20cvc0yomcf8` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FK_iuo7m80kmrx80tjs3emcga1ey` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
INSERT INTO `rent` VALUES (3,'2015-02-13','CONTROLLED','FINISHED',1,1,1);
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'ramon','266575D3C2B8A34F83817458F96152B1'),(3,'eric','89794B621A313BB59EED0D9F0F4E8205');
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

-- Dump completed on 2015-10-25 20:22:29
