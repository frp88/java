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
-- Create schema bdfilmes
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ bdfilmes;
USE bdfilmes;

--
-- Table structure for table `bdfilmes`.`filme`
--

DROP TABLE IF EXISTS `filme`;
CREATE TABLE `filme` (
  `idFilme` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL,
  `dtEstreia` datetime default NULL,
  `dtSaida` datetime default NULL,
  `sinopse` varchar(100) default NULL,
  PRIMARY KEY  (`idFilme`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bdfilmes`.`filme`
--

/*!40000 ALTER TABLE `filme` DISABLE KEYS */;
INSERT INTO `filme` (`idFilme`,`nome`,`dtEstreia`,`dtSaida`,`sinopse`) VALUES 
 (1,'Dois filhos de Francisco','2000-12-12 00:00:00','2000-12-30 00:00:00','Meninos humilde que viraram estrelas...'),
 (2,'A lagoa azul','2000-01-20 00:00:00','2000-01-28 00:00:00','filme romantico'),
 (3,'Velozes e Furiosos','2000-12-10 00:00:00','2000-12-18 00:00:00','filme emocionante, de acao e ficcao'),
 (4,'Golpe baixo','2000-12-05 00:00:00','2000-12-15 00:00:00','filme de um jogador e futebol americano'),
 (5,'Amor para recordar','2009-01-01 00:00:00','2009-01-07 00:00:00','lindo filme'),
 (6,'Tropa de elite','2009-01-06 00:00:00','2009-01-14 00:00:00','filme da policia especializada do rio...'),
 (7,'E os declaro marido e Leury','2009-01-10 00:00:00','2009-01-18 00:00:00','filme de humor... muito legal!!!'),
 (8,'Eu sou a lenda','2009-01-12 00:00:00','2009-01-20 00:00:00','filme de ficcao'),
 (9,'Paixao de Cristo','2009-01-14 00:00:00','2009-01-22 00:00:00','filme que conta a historia da morte de Jesus Cristo'),
 (10,'Rambo','2009-03-15 00:00:00','2009-03-23 00:00:00','rambo na africa... acao e aventura do comeco ao fim...');
/*!40000 ALTER TABLE `filme` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
