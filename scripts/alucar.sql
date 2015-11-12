-- MySQL dump 10.13  Distrib 5.5.45, for Linux (x86_64)
--
-- Host: localhost    Database: alucar
-- ------------------------------------------------------
-- Server version	5.5.45

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
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agency`
--

LOCK TABLES `agency` WRITE;
/*!40000 ALTER TABLE `agency` DISABLE KEYS */;
INSERT INTO `agency` VALUES (1,'Agência SP','SP'),(2,'Agência RJ','RJ');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (2,'','Luxo','122334453','São Paulo','3000.00','5000.00','https://s3-us-west-2.amazonaws.com/alucar-tcc-satan/images/car_users/2-volt_hd.png','5000','ABC-1000','Mercedes','Lotec C100',NULL,'SP'),(3,'','Luxo','Chassi','Penha','5000','6000','https://s3-us-west-2.amazonaws.com/alucar-tcc-satan/images/car_users/3-i8_hd.png','0.0','01203223','Bugatti','Veyron','Carro satãnico','RJ'),(4,'','asd','asd','sd','2333','5999','https://s3-us-west-2.amazonaws.com/alucar-tcc-satan/images/car_users/4-viper_hd.png','6000','asd','teste','Modelo123',NULL,'SP');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (3,'Rua de Teste','45','1995-10-10','São Paulo','123.112.323-08','andrade.rmn@gmail.com','M','São Paulo','123432425','SP','2015-10-10','Teste','Bairro',NULL,'08280-050','SP'),(4,'asd','34','2015-11-01','teste','12379','eric@123.com','M','asd','123123','SP','2018-04-12','Teste','asda',NULL,'1231','SP');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `devolution`
--

DROP TABLE IF EXISTS `devolution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `devolution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `devolution_date` date DEFAULT NULL,
  `total_value` double DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  `rent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_77hoi3kmxgqu3n6w14cnqqddj` (`agency_id`),
  KEY `FK_69mdc4mkprpkyo5fkb9t5nfdk` (`rent_id`),
  CONSTRAINT `FK_69mdc4mkprpkyo5fkb9t5nfdk` FOREIGN KEY (`rent_id`) REFERENCES `rent` (`id`),
  CONSTRAINT `FK_77hoi3kmxgqu3n6w14cnqqddj` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `devolution`
--

LOCK TABLES `devolution` WRITE;
/*!40000 ALTER TABLE `devolution` DISABLE KEYS */;
INSERT INTO `devolution` VALUES (2,'2015-11-27',5000,1,3),(3,'2015-11-14',5999,1,4);
/*!40000 ALTER TABLE `devolution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `bank` varchar(255) DEFAULT NULL,
  `bank_agency` varchar(255) DEFAULT NULL,
  `card_date` date DEFAULT NULL,
  `card_number` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) NOT NULL,
  `created_at` date DEFAULT NULL,
  `holders_name` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `safe_code` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `value` double NOT NULL,
  `rent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tea4wtb9ki939257sn0xid5in` (`rent_id`),
  CONSTRAINT `FK_tea4wtb9ki939257sn0xid5in` FOREIGN KEY (`rent_id`) REFERENCES `rent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (2,NULL,NULL,NULL,'2015-11-20','121314324324','121.343.423-43','2015-11-12','Ramon',NULL,'2313','PAYED','CREDIT',50000,3),(3,NULL,NULL,NULL,'2015-11-20','123123','111.111.111-11','2015-11-12','Teste',NULL,'123','PAYED','CREDIT',59990,4);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` date DEFAULT NULL,
  `expected_date` date DEFAULT NULL,
  `killometer_type` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `agency_id` bigint(20) DEFAULT NULL,
  `car_id` bigint(20) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `expectedAgency_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qdl1q4sisnukomrr2s3v55b3` (`agency_id`),
  KEY `FK_iuo7m80kmrx80tjs3emcga1ey` (`car_id`),
  KEY `FK_3jsq9x8n2ydbo20cvc0yomcf8` (`client_id`),
  KEY `FK_lqkj6hg8elcp8dj102h1nhgui` (`expectedAgency_id`),
  CONSTRAINT `FK_lqkj6hg8elcp8dj102h1nhgui` FOREIGN KEY (`expectedAgency_id`) REFERENCES `agency` (`id`),
  CONSTRAINT `FK_3jsq9x8n2ydbo20cvc0yomcf8` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FK_iuo7m80kmrx80tjs3emcga1ey` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `FK_qdl1q4sisnukomrr2s3v55b3` FOREIGN KEY (`agency_id`) REFERENCES `agency` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
INSERT INTO `rent` VALUES (3,'2015-11-12','2015-11-20','FREE','FINISHED',1,2,3,1),(4,'2015-11-12','2015-11-14','FREE','FINISHED',1,4,3,1);
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
  `permission` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'eric','89794B621A313BB59EED0D9F0F4E8205','SUPERVISOR'),(2,'ramon','89794B621A313BB59EED0D9F0F4E8205','ATTENDANT');
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

-- Dump completed on 2015-11-12 23:08:32
