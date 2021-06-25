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
-- Create schema amigooculto
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ amigooculto;
USE amigooculto;

--
-- Table structure for table `amigooculto`.`tblparticipante`
--

DROP TABLE IF EXISTS `tblparticipante`;
CREATE TABLE `tblparticipante` (
  `idparticipante` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(50) NOT NULL,
  `amigo` int(10) unsigned default NULL,
  `senha` varchar(20) NOT NULL,
  `login` varchar(30) NOT NULL,
  `presentes` varchar(1000) NOT NULL,
  PRIMARY KEY  (`idparticipante`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `amigooculto`.`tblparticipante`
--

/*!40000 ALTER TABLE `tblparticipante` DISABLE KEYS */;
INSERT INTO `tblparticipante` (`idparticipante`,`nome`,`amigo`,`senha`,`login`,`presentes`) VALUES 
 (1,'Fernando Roberto',0,'fer','fernando','fazenda\nrancho\nmulher gostosa'),
 (2,'Kaue Melo',0,'ka','kaue','boi'),
 (3,'Kauana Lorena',0,'123','kauana','blusa'),
 (4,'Kauana Lorena de Melo',0,'asd','kauanal','blusa\ncalça'),
 (5,'Bruno',0,'b','bruno','1 baralho\n2 presunto\n3 porco\n4pinguim\n'),
 (6,'Katiucha Melo',0,'feia','katty','1 baton\n1 bala de 5 centavos'),
 (7,'Katiucha Nelyolga Melo',0,'123','katy','3 cabritas'),
 (8,'fernando',0,'frp','frp','taxi\nmonsa'),
 (9,'Simone Machado',0,'si','simone','blusa\nsandalia'),
 (18,'teste tes',0,'te','teste','testando'),
 (19,'Mailson de Queiroz',0,'123','mailson','Gol G5\nParati'),
 (20,'Fernando',0,'fer','fer','fdsaf	'),
 (21,'mailson proenca',0,'123','maia','teste');
/*!40000 ALTER TABLE `tblparticipante` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
