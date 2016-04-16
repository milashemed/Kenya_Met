-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.9-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for metdb
CREATE DATABASE IF NOT EXISTS `metdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `metdb`;


-- Dumping structure for table metdb.newentity
CREATE TABLE IF NOT EXISTS `newentity` (
  `ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table metdb.newentity: ~0 rows (approximately)
/*!40000 ALTER TABLE `newentity` DISABLE KEYS */;
/*!40000 ALTER TABLE `newentity` ENABLE KEYS */;


-- Dumping structure for table metdb.reading
CREATE TABLE IF NOT EXISTS `reading` (
  `ID` bigint(20) NOT NULL,
  `Evaporation` double DEFAULT NULL,
  `Humidity` double DEFAULT NULL,
  `Pressure` double DEFAULT NULL,
  `Rainfall` double DEFAULT NULL,
  `Temperature` double DEFAULT NULL,
  `Wind_Speed` int(11) DEFAULT NULL,
  `Wind_Direction` enum('E','N','W','S','NE','NW','SW','SE') DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `Station` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table metdb.reading: ~23 rows (approximately)
/*!40000 ALTER TABLE `reading` DISABLE KEYS */;
REPLACE INTO `reading` (`ID`, `Evaporation`, `Humidity`, `Pressure`, `Rainfall`, `Temperature`, `Wind_Speed`, `Wind_Direction`, `time`, `Station`, `user`) VALUES
	(1251, 28, 32, NULL, 20, 27, 25, 'N', NULL, 151, 951),
	(1301, 28, 32, NULL, 20, 27, 25, 'N', NULL, 151, 951),
	(1351, 16, 18, 25, 25, 27, 30, 'N', NULL, 151, 951),
	(1401, 21, 25, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1451, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1501, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1551, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1601, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1651, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1701, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1751, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1801, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1851, 30, 29, 50, 25, 27, 100, 'N', NULL, 151, 951),
	(1901, 27, 31, 50, 30, 27, 60, 'N', NULL, 151, 951),
	(1951, 13, 14, 100, 200, 25, 50, 'N', NULL, 151, 951),
	(2001, 13, 14, 100, 200, 25, 50, 'N', NULL, 151, 951),
	(2051, 13, 14, 100, 200, 25, 50, 'N', NULL, 151, 951),
	(2101, 13, 14, 100, 200, 25, 50, 'N', NULL, 151, 951),
	(2151, 13, 14, 100, 200, 25, 50, 'N', NULL, 151, 951),
	(2201, 22, 20, 100, 20, 20, 50, 'N', NULL, 151, 951),
	(2251, 22, 20, 100, 20, 20, 50, 'N', NULL, 151, 951),
	(2301, 22, 20, 100, 20, 20, 50, 'N', NULL, 151, 951),
	(2351, 22, 20, 100, 20, 20, 50, 'N', NULL, 151, 951);
/*!40000 ALTER TABLE `reading` ENABLE KEYS */;


-- Dumping structure for table metdb.readings
CREATE TABLE IF NOT EXISTS `readings` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Temperature` double NOT NULL DEFAULT '0',
  `Humidity` double NOT NULL DEFAULT '0',
  `Wind_direction` int(11) NOT NULL DEFAULT '0',
  `Wind_speed` double NOT NULL DEFAULT '0',
  `Pressure` double NOT NULL DEFAULT '0',
  `Rainfall` double NOT NULL DEFAULT '0',
  `Evaporation` double NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user` int(11) NOT NULL DEFAULT '0',
  `Station` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `FK__users2` (`user`),
  KEY `FK__stations2` (`Station`),
  CONSTRAINT `FK__stations2` FOREIGN KEY (`Station`) REFERENCES `stations` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__users2` FOREIGN KEY (`user`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table metdb.readings: ~0 rows (approximately)
/*!40000 ALTER TABLE `readings` DISABLE KEYS */;
/*!40000 ALTER TABLE `readings` ENABLE KEYS */;


-- Dumping structure for table metdb.sequence
CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table metdb.sequence: ~0 rows (approximately)
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
REPLACE INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
	('SEQ_GEN', 2400);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;


-- Dumping structure for table metdb.stations
CREATE TABLE IF NOT EXISTS `stations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Station_Number` varchar(50) NOT NULL DEFAULT '0',
  `Location` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Station_Number` (`Station_Number`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=latin1;

-- Dumping data for table metdb.stations: ~2 rows (approximately)
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
REPLACE INTO `stations` (`ID`, `Station_Number`, `Location`) VALUES
	(151, '106102', 'Meru'),
	(201, '102', 'Mombasa');
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;


-- Dumping structure for table metdb.users
CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Phone_number` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Type` enum('Administrator','Data Entry','Management') NOT NULL,
  `Password` text NOT NULL,
  `passchange` bit(1) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username` (`Username`),
  UNIQUE KEY `Phone_number` (`Phone_number`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=latin1;

-- Dumping data for table metdb.users: ~4 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`ID`, `Fname`, `Lname`, `Username`, `Phone_number`, `Email`, `Type`, `Password`, `passchange`, `status`) VALUES
	(801, 'Salim', 'Said', 'admin', '0704720339', 'root@local.loc', 'Administrator', '$2a$10$btLMs7LWYroyNYPxLxmF4uqnRrpv5JZPwufn5z3TDORFOC5UhehMG', b'0', b'1'),
	(802, 'Hemed', 'Said', 'hemed.said', '0745123456', 'hemed@local.loc', 'Administrator', '$2a$10$1pkoEjFsxrhBGSg7WadQeesXzAdw1p9dhuBLtDYIvgJLxV.W6YXBe', b'0', b'1'),
	(951, 'Salim', 'Said', 'salim.said', '0736145123', 'salim@local.loc', 'Data Entry', '$2a$10$ZXm1saMJ7oooi23yaOcZoe4pNu5lFdrDTQo5Fee37yYSKsfxB9sji', b'0', b'1'),
	(1001, 'Moffat', 'Mwaniki', 'swale01', '0721458369', 'moffat@local.loc', 'Management', '$2a$10$d7aeSe6t1rxYGLAUFql16OY/DOFwAXauI61bfkARDfU/xAdgblNuK', b'0', b'1');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Dumping structure for table metdb.user_stations
CREATE TABLE IF NOT EXISTS `user_stations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Station` int(11) NOT NULL DEFAULT '0',
  `User` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Station` (`Station`),
  UNIQUE KEY `User` (`User`),
  CONSTRAINT `FK__stations` FOREIGN KEY (`Station`) REFERENCES `stations` (`ID`),
  CONSTRAINT `FK__users` FOREIGN KEY (`User`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=953 DEFAULT CHARSET=latin1;

-- Dumping data for table metdb.user_stations: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_stations` DISABLE KEYS */;
REPLACE INTO `user_stations` (`ID`, `Station`, `User`) VALUES
	(952, 151, 951);
/*!40000 ALTER TABLE `user_stations` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
