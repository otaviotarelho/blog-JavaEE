CREATE DATABASE  IF NOT EXISTS `blog` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `blog`;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.7.12

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
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `body` longtext,
  `date` datetime DEFAULT NULL,
  `authorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (3,' 22 Titulo','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam a ipsum sit amet dui efficitur faucibus. In finibus nisl at sapien vulputate, sit amet placerat quam ultrices. Proin commodo massa nunc, eu lobortis est ultrices vel. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque a pellentesque quam, auctor imperdiet neque. Vivamus ornare a urna id dictum. Nam sed nibh et nisl interdum sollicitudin. Fusce molestie justo turpis, sit amet rutrum ante imperdiet nec. Integer tincidunt laoreet sem ut lacinia.\r\n\r\nDonec elementum tempor suscipit. Etiam at libero semper, consequat nisl id, congue risus. Praesent quam tellus, dictum sed leo in, molestie blandit risus. Praesent viverra velit non magna accumsan, et dapibus odio egestas. Proin sed rhoncus ex. Nullam tempor efficitur magna, volutpat vehicula elit gravida at. Mauris mollis sodales turpis, a viverra justo efficitur in. Nunc pellentesque volutpat sapien id tincidunt. Aliquam ac odio quis tellus bibendum viverra. Mauris quis ante eget nisi tincidunt ornare. Cras fermentum, dui a finibus tincidunt, nunc mauris egestas sem, eget pretium quam arcu vel nibh. Donec dignissim ipsum nulla, vitae facilisis justo consectetur ac. Proin magna justo, sollicitudin a faucibus vitae, efficitur vel odio.\r\n\r\nDonec elementum tellus vel nisl gravida, sit amet finibus nisi iaculis. Nam viverra tortor sed nulla accumsan finibus. Phasellus lacinia imperdiet vestibulum. Sed mollis risus non imperdiet ornare. Phasellus malesuada nibh sed lectus malesuada imperdiet. Maecenas ut iaculis ex, vitae elementum ex. Integer in libero eu sem faucibus egestas. Nam sodales elit ut mauris venenatis, sed gravida ipsum sagittis. Nulla dolor dui, consequat sit amet efficitur in, euismod vitae ex. Curabitur mattis fermentum tellus, id semper libero lacinia a. Proin tincidunt mi nunc, eu cursus nulla luctus quis. Donec ac libero eu libero imperdiet iaculis in at arcu. Fusce eget diam turpis. Cras vitae lacus vitae massa condimentum dignissim. Vivamus euismod dictum tellus.\r\n\r\n\r\nteste','2016-05-31 04:17:41',1),(7,' 22 Titulo 222','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam a ipsum sit amet dui efficitur faucibus. In finibus nisl at sapien vulputate, sit amet placerat quam ultrices. Proin commodo massa nunc, eu lobortis est ultrices vel. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Quisque a pellentesque quam, auctor imperdiet neque. Vivamus ornare a urna id dictum. Nam sed nibh et nisl interdum sollicitudin. Fusce molestie justo turpis, sit amet rutrum ante imperdiet nec. Integer tincidunt laoreet sem ut lacinia.\r\n\r\nDonec elementum tempor suscipit. Etiam at libero semper, consequat nisl id, congue risus. Praesent quam tellus, dictum sed leo in, molestie blandit risus. Praesent viverra velit non magna accumsan, et dapibus odio egestas. Proin sed rhoncus ex. Nullam tempor efficitur magna, volutpat vehicula elit gravida at. Mauris mollis sodales turpis, a viverra justo efficitur in. Nunc pellentesque volutpat sapien id tincidunt. Aliquam ac odio quis tellus bibendum viverra. Mauris quis ante eget nisi tincidunt ornare. Cras fermentum, dui a finibus tincidunt, nunc mauris egestas sem, eget pretium quam arcu vel nibh. Donec dignissim ipsum nulla, vitae facilisis justo consectetur ac. Proin magna justo, sollicitudin a faucibus vitae, efficitur vel odio.\r\n\r\nDonec elementum tellus vel nisl gravida, sit amet finibus nisi iaculis. Nam viverra tortor sed nulla accumsan finibus. Phasellus lacinia imperdiet vestibulum. Sed mollis risus non imperdiet ornare. Phasellus malesuada nibh sed lectus malesuada imperdiet. Maecenas ut iaculis ex, vitae elementum ex. Integer in libero eu sem faucibus egestas. Nam sodales elit ut mauris venenatis, sed gravida ipsum sagittis. Nulla dolor dui, consequat sit amet efficitur in, euismod vitae ex. Curabitur mattis fermentum tellus, id semper libero lacinia a. Proin tincidunt mi nunc, eu cursus nulla luctus quis. Donec ac libero eu libero imperdiet iaculis in at arcu. Fusce eget diam turpis. Cras vitae lacus vitae massa condimentum dignissim. Vivamus euismod dictum tellus.\r\n\r\n\r\nteste','2016-05-31 05:10:38',1),(8,' 22 Titulo 222','\r\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Donec venenatis leo vel diam laoreet luctus. Integer ut quam ac sem finibus pharetra nec eu odio. Maecenas neque ipsum, tincidunt eget facilisis et, pharetra at lorem. Proin commodo diam mollis justo tincidunt hendrerit. Praesent in enim elit. Proin dignissim rutrum mauris in suscipit. Proin id imperdiet est. Sed posuere urna vitae mauris auctor, sit amet vehicula tellus pretium. Sed laoreet vestibulum urna, id rhoncus nisl.','2016-05-31 05:12:56',1),(9,' Testinho','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec venenatis leo vel diam laoreet luctus. Integer ut quam ac sem finibus pharetra nec eu odio. Maecenas neque ipsum, tincidunt eget facilisis et, pharetra at lorem. Proin commodo diam mollis justo tincidunt hendrerit. Praesent in enim elit. Proin dignissim rutrum mauris in suscipit. Proin id imperdiet est. Sed posuere urna vitae mauris auctor, sit amet vehicula tellus pretium. Sed laoreet vestibulum urna, id rhoncus nisl.','2016-05-31 05:13:36',1),(10,'AAAA','Testes','2016-05-31 21:59:56',6);
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authorID` int(11) NOT NULL,
  `article` int(11) NOT NULL,
  `content` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `authorID` (`authorID`),
  KEY `article` (`article`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,1,3,'xpto','2016-05-31 15:21:18'),(2,4,0,'nsdkjnaskjdnkasd','2016-05-31 21:37:55'),(3,4,0,'nsdkjnaskjdnkasd','2016-05-31 21:38:01'),(4,4,0,'nsdkjnaskjdnkasd','2016-05-31 21:38:02'),(5,6,0,'jdnakjdnjkasnd','2016-05-31 22:02:44');
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `pwd` varchar(15) DEFAULT NULL,
  `lastsingin` datetime DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `valid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Otavio','otarelho','info2011','2016-05-28 00:00:00',1,1),(2,'Lucas','lsamia','123','2016-05-30 00:00:00',2,1),(3,'Otavio','otarelho2','1234',NULL,2,0),(4,'leonardo','leonardo','123456',NULL,2,1),(6,'Leonardo','S','123',NULL,1,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-31 22:08:46
