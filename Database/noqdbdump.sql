CREATE DATABASE  IF NOT EXISTS `noqshows_test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `noqshows_test`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: noqshows_test
-- ------------------------------------------------------
-- Server version	5.5.29

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
-- Table structure for table `eventcategory`
--

DROP TABLE IF EXISTS `eventcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventcategory`
--

LOCK TABLES `eventcategory` WRITE;
/*!40000 ALTER TABLE `eventcategory` DISABLE KEYS */;
INSERT INTO `eventcategory` VALUES (1,'Arts'),(2,'Classical'),(3,'Rock'),(4,'MoonLight'),(5,'Devotional');
/*!40000 ALTER TABLE `eventcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventfollowtable`
--

DROP TABLE IF EXISTS `eventfollowtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventfollowtable` (
  `id` int(11) NOT NULL,
  `eventid` varchar(45) NOT NULL,
  `follow_userid` varchar(45) NOT NULL,
  `follow_topic` varchar(45) DEFAULT NULL,
  `createdby` varchar(45) DEFAULT NULL,
  `createdtime` varchar(45) DEFAULT NULL,
  `modifiedby` varchar(45) DEFAULT NULL,
  `modifiedtime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventfollowtable`
--

LOCK TABLES `eventfollowtable` WRITE;
/*!40000 ALTER TABLE `eventfollowtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventfollowtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventregistration`
--

DROP TABLE IF EXISTS `eventregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eventregistration` (
  `id` int(11) NOT NULL,
  `eventid` varchar(45) NOT NULL,
  `userid` varchar(45) NOT NULL,
  `attendee_name` varchar(45) NOT NULL,
  `attendee_age` varchar(45) NOT NULL,
  `attendee_dob` varchar(45) NOT NULL,
  `attendee_count` varchar(45) NOT NULL,
  `attendee_seats` varchar(45) NOT NULL,
  `createdby` varchar(45) DEFAULT NULL,
  `createtime` varchar(45) DEFAULT NULL,
  `modifiedby` varchar(45) DEFAULT NULL,
  `modifiedtime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventregistration`
--

LOCK TABLES `eventregistration` WRITE;
/*!40000 ALTER TABLE `eventregistration` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventregistration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events` (
  `eventid` int(11) NOT NULL AUTO_INCREMENT,
  `eventaddedby` int(11) NOT NULL,
  `eventcategory` int(11) NOT NULL,
  `eventtitle` varchar(50) NOT NULL,
  `eventlocation` varchar(45) DEFAULT NULL,
  `eventtype` varchar(45) DEFAULT NULL,
  `eventdetails` varchar(455) DEFAULT NULL,
  `noofseats` varchar(45) DEFAULT NULL,
  `eventdate` date DEFAULT NULL,
  `eventimagepath` varchar(345) DEFAULT NULL,
  `eventorganisernumber` varchar(12) NOT NULL,
  `eventorganisermailid` varchar(55) NOT NULL,
  `createdby` int(11) DEFAULT NULL,
  `createdtime` datetime DEFAULT NULL,
  `modifiedby` int(11) DEFAULT NULL,
  `modifiedtime` datetime DEFAULT NULL,
  PRIMARY KEY (`eventid`),
  UNIQUE KEY `eventid_UNIQUE` (`eventid`),
  KEY `eventaddedby_idx` (`eventaddedby`),
  CONSTRAINT `eventaddedby` FOREIGN KEY (`eventaddedby`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (6,19,1,'test',NULL,NULL,'fjksdlfsa',NULL,'1970-01-01',NULL,'1234','test',19,NULL,NULL,NULL),(7,19,1,'surya rocks',NULL,NULL,'fjsdkfa;sdfa',NULL,'1970-01-01',NULL,'1234','surya',19,NULL,NULL,NULL),(8,26,1,'DJ Surya',NULL,NULL,'test',NULL,'1970-01-01',NULL,'1234','test,test',26,NULL,NULL,NULL),(9,26,1,'test','India','limit','fsdfasdfasd','10','2014-10-12',NULL,'919959747954','surya1988@gmail.com',26,NULL,NULL,NULL);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logindetails`
--

DROP TABLE IF EXISTS `logindetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logindetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `sessionvalue` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `userid` FOREIGN KEY (`id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logindetails`
--

LOCK TABLES `logindetails` WRITE;
/*!40000 ALTER TABLE `logindetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `logindetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (19,'surya','test',NULL,NULL,NULL,NULL,'surya@lisystems.in'),(20,'surya','test',NULL,NULL,NULL,NULL,'test'),(21,'surya@123','test',NULL,NULL,NULL,NULL,'test'),(26,'suryasistla','WG4tLWoF8McUdUNXANhMs1fL4a8=',NULL,NULL,NULL,NULL,'surya1988@gmail.com'),(27,'surya@123','K52c2LlQtUnJd73EUlJfv6NMJlY=',NULL,NULL,NULL,NULL,'surya1988@gmail.com');
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

-- Dump completed on 2014-05-05 22:04:22
