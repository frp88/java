-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema petshop
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ petshop;
USE petshop;

--
-- Table structure for table `petshop`.`agenda`
--

DROP TABLE IF EXISTS `agenda`;
CREATE TABLE `agenda` (
  `idAgenda` int(10) unsigned NOT NULL auto_increment,
  `IdAnimal` int(10) unsigned NOT NULL,
  `Data` varchar(10) NOT NULL,
  `Hora` varchar(5) NOT NULL,
  PRIMARY KEY  (`idAgenda`),
  KEY `FKAnimalAgenda` (`IdAnimal`),
  CONSTRAINT `FKAnimalAgenda` FOREIGN KEY (`IdAnimal`) REFERENCES `animal` (`idAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='InnoDB free: 4096 kB';

--
-- Dumping data for table `petshop`.`agenda`
--

/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` (`idAgenda`,`IdAnimal`,`Data`,`Hora`) VALUES 
 (2,18,'2000/12/12','09:00'),
 (3,9,'2008/12/12','09:00'),
 (4,15,'2008/12/12','09:00'),
 (5,10,'2008/12/12','09:00'),
 (6,12,'2008/12/12','14:00'),
 (7,2,'2008/12/12','14:00');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;


--
-- Table structure for table `petshop`.`animal`
--

DROP TABLE IF EXISTS `animal`;
CREATE TABLE `animal` (
  `idAnimal` int(10) unsigned NOT NULL auto_increment,
  `Nome` varchar(50) NOT NULL,
  `NomeDono` varchar(50) NOT NULL,
  `Rua` varchar(50) NOT NULL,
  `Numero` int(10) unsigned NOT NULL,
  `Bairro` varchar(50) NOT NULL,
  `Cidade` varchar(50) NOT NULL,
  `Estado` char(2) NOT NULL,
  `DataNasc` varchar(10) NOT NULL,
  `Tamanho` int(10) unsigned NOT NULL,
  `Tel` varchar(10) NOT NULL,
  `Email` varchar(45) NOT NULL,
  PRIMARY KEY  (`idAnimal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petshop`.`animal`
--

/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`idAnimal`,`Nome`,`NomeDono`,`Rua`,`Numero`,`Bairro`,`Cidade`,`Estado`,`DataNasc`,`Tamanho`,`Tel`,`Email`) VALUES 
 (1,'Pequeno01','dono','rua',69,'bairro','cidade','PA','12/21/2209',1,'3324324','teste@gmail.com'),
 (2,'Grande01','teste','teste1',43,'teste2','passos','SP','12/12/2000',3,'5555555555','fernando@gmail.com'),
 (4,'Aladim','teste','dfdsaf',32,'afdsh','fadsfj','DF','12/12/2009',3,'43243242','fadsas@gamai.com'),
 (7,'Bingo','produtor','gsdgf',2344,'sdfsdfsdf','sdfsdfdsfdsf','MG','30/02/2003',2,'32435689','sdfds@kjkjk'),
 (8,'Pequeno02','fadsfasf','fdsafasdfa',150,'dasfas','sadfasdf','SP','01/02/2005',1,'99999999','vatapa@hotmail.com'),
 (9,'Valente','com laranja','farofinha',540,'cove','tumate','SC','21/11/2004',1,'88888888','caganeiranodiaseguinte@hospital.com'),
 (10,'Medio01','donomed2','rau',123,'bairro','cidade','AL','12/12/2000',2,'3424324','oteste@com'),
 (11,'Tina','Angela maria','Jeronimo Neto',293,'Centro','Passos','MG','08/07/1998',1,'1234-4321','teste@teste.com'),
 (12,'Lulu','Fernando','fer',444,'nando','passos','SP','12/12/1999',3,'2323-2323','fernando@hotmail.com');
INSERT INTO `animal` (`idAnimal`,`Nome`,`NomeDono`,`Rua`,`Numero`,`Bairro`,`Cidade`,`Estado`,`DataNasc`,`Tamanho`,`Tel`,`Email`) VALUES 
 (13,'Grande02','eu','fajshd',76,'fdsagfadfgf','Guarulhos','BA','07/07/1997',3,'3425-5435','roberto@gmail.com'),
 (14,'Pequeno03','Bruno','fdsahjf',57,'masnfjadsf','Jacui','SE','09/09/2001',1,'2364-4329','testess@hotmail.com'),
 (15,'Medio02','Tales','fdjsf',33,'fasfdsaf','Alpinopolis','DF','03/032003',2,'2323-0943','fasfa@gmail.com'),
 (16,'Grande03','Lucas','sdfhjdfas',98,'fdasfah','Passos','RO','09/09/2004',3,'4343-4343','sadfkjh@gamil.com'),
 (17,'Medio03','Patricia','fasdjdfh',78,'dfasjfsj','Paraiso','SC','09/08/2003',2,'','fadsfsdf@hotmail.com'),
 (18,'pituxa','Simone','Tajai',145,'Vila Rica','Passos','MG','12/11/2005',1,'9817-9002','si.cap@hotmail.com'),
 (19,'Lele','Fernando Roberto','Rua da  Minha Casa',1232,'Meu Bairro','Coração','MG','21/03/1988',2,'1111-7070','lele@gmail.com'),
 (20,'ted','polvo','pindaíba',12,'wer','passos','MG','21/12/2001',1,'123','3123');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
