/*
SQLyog Community v13.1.1 (32 bit)
MySQL - 5.5.62 : Database - reciklaza
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`reciklaza` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `reciklaza`;

/*Table structure for table `ambalaza` */

DROP TABLE IF EXISTS `ambalaza`;

CREATE TABLE `ambalaza` (
  `ambalazaID` int(10) NOT NULL AUTO_INCREMENT,
  `nazivAmbalaze` varchar(50) NOT NULL,
  `reciklazniKod` int(10) NOT NULL,
  `korisnikID` int(10) DEFAULT NULL,
  PRIMARY KEY (`ambalazaID`),
  KEY `reciklazniKod` (`reciklazniKod`),
  KEY `korisnikID` (`korisnikID`),
  CONSTRAINT `ambalaza_ibfk_1` FOREIGN KEY (`reciklazniKod`) REFERENCES `reciklaznikod` (`kod`),
  CONSTRAINT `ambalaza_ibfk_2` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `ambalaza` */

insert  into `ambalaza`(`ambalazaID`,`nazivAmbalaze`,`reciklazniKod`,`korisnikID`) values 
(1,'cep sa flasice vode',2,1),
(2,'cep sa tetrapaka',2,1),
(3,'flasica vode',1,1),
(4,'knjiga',20,1),
(5,'pivo, staklena flasa',70,2),
(6,'kartonska kutija',22,2),
(7,'papir za stampanje',21,2),
(8,'pivo, plasticna flasa',1,2),
(9,'rendom nova',1,1);

/*Table structure for table `kategorija` */

DROP TABLE IF EXISTS `kategorija`;

CREATE TABLE `kategorija` (
  `kategorijaID` int(10) NOT NULL AUTO_INCREMENT,
  `nazivKategorije` varchar(50) NOT NULL,
  PRIMARY KEY (`kategorijaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `kategorija` */

insert  into `kategorija`(`kategorijaID`,`nazivKategorije`) values 
(1,'plastika'),
(2,'papir'),
(3,'metal'),
(4,'staklo');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnikID` int(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `korisnickoIme` varchar(20) NOT NULL,
  `sifra` varchar(20) NOT NULL,
  `emailKor` varchar(40) NOT NULL,
  PRIMARY KEY (`korisnikID`),
  UNIQUE KEY `korisnickoIme` (`korisnickoIme`,`emailKor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnikID`,`ime`,`prezime`,`korisnickoIme`,`sifra`,`emailKor`) values 
(1,'Katarina','Jerinic','kjer','11','katarinajerinic8@gmail.com'),
(2,'Andrijana','Jerinic','ajerinic','22','andrijanajerinic10@gmail.com'),
(3,'Dusan','Sikora','dsikora','33','dusansikora33@gmail.com'),
(4,'admin','admin','admin','admin','admin@admin.com'),
(8,'Pavle','Pavlic','pp','pp','p@p.rs');

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `pttBroj` int(10) NOT NULL,
  `nazivMesta` varchar(20) NOT NULL,
  PRIMARY KEY (`pttBroj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mesto` */

insert  into `mesto`(`pttBroj`,`nazivMesta`) values 
(11080,'Zemun'),
(14000,'Valjevo'),
(15000,'Sabac'),
(21000,'Novi Sad'),
(21400,'Backa'),
(26000,'Pancevo'),
(31210,'Pozega'),
(34300,'Arandjelovac');

/*Table structure for table `reciklazer` */

DROP TABLE IF EXISTS `reciklazer`;

CREATE TABLE `reciklazer` (
  `reciklazerID` int(10) NOT NULL AUTO_INCREMENT,
  `nazivReciklazera` varchar(50) NOT NULL,
  `opisReciklazera` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `kategorijaID` int(10) DEFAULT NULL,
  `korisnikID` int(10) DEFAULT NULL,
  PRIMARY KEY (`reciklazerID`),
  UNIQUE KEY `nazivReciklazera` (`nazivReciklazera`,`email`),
  KEY `kategorijaID` (`kategorijaID`),
  KEY `korisnikID` (`korisnikID`),
  CONSTRAINT `reciklazer_ibfk_1` FOREIGN KEY (`kategorijaID`) REFERENCES `kategorija` (`kategorijaID`),
  CONSTRAINT `reciklazer_ibfk_2` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Data for the table `reciklazer` */

insert  into `reciklazer`(`reciklazerID`,`nazivReciklazera`,`opisReciklazera`,`email`,`kategorijaID`,`korisnikID`) values 
(2,'Eko-plast','plastika','izmisljen@ekoplast.rs',1,1),
(3,'Nova plastika','plastika','izmisljen@novaplastika.rs',1,1),
(4,'Drvored','hartija i karton','izmisljen@drvored.rs',2,2),
(5,'Novi papir','hartija i karton','izmisljen@novipapir.rs',2,2),
(6,'Novo staklo','staklo','izmisljen@novostaklo.rs',4,1),
(7,'Novi Metal','metal','izmisljen@novimetal.rs',3,1),
(8,'Super metal','prerada metala','izmisljen@supermetal.rs',3,1),
(9,'Super papir','reciklaza papira','izmisljen@superpapir.rs',2,1),
(10,'Star1','super smo','star@star.rs',1,1),
(11,'Suma peva','volimo sume','suma@suma.rs',2,8);

/*Table structure for table `reciklaznikod` */

DROP TABLE IF EXISTS `reciklaznikod`;

CREATE TABLE `reciklaznikod` (
  `kod` int(10) NOT NULL,
  `slova` varchar(20) CHARACTER SET latin1 NOT NULL,
  `kategorijaID` int(10) DEFAULT NULL,
  PRIMARY KEY (`kod`),
  KEY `kategorijaID` (`kategorijaID`),
  CONSTRAINT `reciklaznikod_ibfk_1` FOREIGN KEY (`kategorijaID`) REFERENCES `kategorija` (`kategorijaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_slovenian_ci;

/*Data for the table `reciklaznikod` */

insert  into `reciklaznikod`(`kod`,`slova`,`kategorijaID`) values 
(1,'PET',1),
(2,'HDPE',1),
(3,'PCV',1),
(4,'LDPE',1),
(5,'PP',1),
(6,'PS',1),
(7,'O',1),
(20,'PAP',2),
(21,'PAP',2),
(22,'PAP',2),
(41,'ALU',3),
(70,'GL',4),
(71,'GL',4);

/*Table structure for table `recikliranje` */

DROP TABLE IF EXISTS `recikliranje`;

CREATE TABLE `recikliranje` (
  `recikliranjeID` int(10) NOT NULL AUTO_INCREMENT,
  `reciklazerID` int(10) DEFAULT NULL,
  `ambalazaID` int(10) DEFAULT NULL,
  `napomena` varchar(200) DEFAULT NULL,
  `korisnikID` int(10) DEFAULT NULL,
  PRIMARY KEY (`recikliranjeID`),
  KEY `reciklazerID` (`reciklazerID`),
  KEY `ambalazaID` (`ambalazaID`),
  KEY `korisnikID` (`korisnikID`),
  CONSTRAINT `recikliranje_ibfk_3` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`korisnikID`),
  CONSTRAINT `recikliranje_ibfk_1` FOREIGN KEY (`reciklazerID`) REFERENCES `reciklazer` (`reciklazerID`),
  CONSTRAINT `recikliranje_ibfk_2` FOREIGN KEY (`ambalazaID`) REFERENCES `ambalaza` (`ambalazaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `recikliranje` */

insert  into `recikliranje`(`recikliranjeID`,`reciklazerID`,`ambalazaID`,`napomena`,`korisnikID`) values 
(1,2,1,'odlicna usluga',1),
(2,3,3,'osrednji su',1),
(3,4,6,'samo kartone recikliraju',2),
(4,6,5,'za jelen rade flase',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
