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
-- Create schema mvc
--

CREATE DATABASE IF NOT EXISTS recurso;
USE recurso;

--
-- Definition of table `tblagendamento`
--

DROP TABLE IF EXISTS `tblagendamento`;
CREATE TABLE `tblagendamento` (
  `nIdAgendamento` int(10) unsigned NOT NULL auto_increment,
  `nIdRecurso` int(10) unsigned default NULL,
  `sIdUsuario` varchar(60) default NULL,
  `nStatus` int(10) unsigned default NULL,
  `sPredio` varchar(50) default NULL,
  `sSala` varchar(50) default NULL,
  `nDuracao` double default NULL,
  `dAgendamento` datetime default NULL,
  `dEmprestimo` datetime default NULL,
  `dDevolucao` datetime default NULL,
  PRIMARY KEY  (`nIdAgendamento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblagendamento`
--

/*!40000 ALTER TABLE `tblagendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblagendamento` ENABLE KEYS */;


--
-- Definition of table `tblrecurso`
--

DROP TABLE IF EXISTS `tblrecurso`;
CREATE TABLE `tblrecurso` (
  `nIdRecurso` int(10) unsigned NOT NULL auto_increment,
  `nIdTipoRecurso` int(10) unsigned default NULL,
  `sDescricao` varchar(50) default NULL,
  `sLocal` varchar(50) default NULL,
  `nStatus` int(10) unsigned default NULL,
  PRIMARY KEY  (`nIdRecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblrecurso`
--

/*!40000 ALTER TABLE `tblrecurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblrecurso` ENABLE KEYS */;


--
-- Definition of table `tbltiporecurso`
--

DROP TABLE IF EXISTS `tbltiporecurso`;
CREATE TABLE `tbltiporecurso` (
  `nIdTipoRecurso` int(10) unsigned NOT NULL auto_increment,
  `sDescricao` varchar(50) default NULL,
  `sObs` varchar(100) default NULL,
  PRIMARY KEY  (`nIdTipoRecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbltiporecurso`
--

/*!40000 ALTER TABLE `tbltiporecurso` DISABLE KEYS */;
INSERT INTO `tbltiporecurso` (`nIdTipoRecurso`,`sDescricao`,`sObs`) VALUES 
 (1,'Retroprojetor','Para as aulas'),
 (2,'scaner','scaner HP');
/*!40000 ALTER TABLE `tbltiporecurso` ENABLE KEYS */;


--
-- Definition of table `tblusuario`
--

DROP TABLE IF EXISTS `tblusuario`;
CREATE TABLE `tblusuario` (
  `sIdUsuario` varchar(60) NOT NULL,
  `sSenha` varchar(60) default NULL,
  `sNome` varchar(100) default NULL,
  `nStatus` int(10) unsigned default NULL,
  `nTipo` int(10) unsigned default NULL,
  PRIMARY KEY  (`sIdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tblusuario`
--

/*!40000 ALTER TABLE `tblusuario` DISABLE KEYS */;
INSERT INTO `tblusuario` (`sIdUsuario`,`sSenha`,`sNome`,`nStatus`,`nTipo`) VALUES 
 ('fernando','fer','Fernando Roberto',0,NULL);
/*!40000 ALTER TABLE `tblusuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
