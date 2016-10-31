-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2016 at 12:51 PM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ap_pgraca`
--

-- --------------------------------------------------------

--
-- Table structure for table `despesas`
--

CREATE TABLE `despesas` (
  `idDespesa` int(11) NOT NULL,
  `nmDespesa` varchar(200) DEFAULT NULL,
  `descricao` longtext,
  `idUsuario` int(11) DEFAULT NULL,
  `idResidencia` int(11) DEFAULT NULL,
  `idDespesaCategoria` int(11) DEFAULT NULL,
  `idTiposVariacaoDespesa` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `despesas`
--

INSERT INTO `despesas` (`idDespesa`, `nmDespesa`, `descricao`, `idUsuario`, `idResidencia`, `idDespesaCategoria`, `idTiposVariacaoDespesa`) VALUES
(1, 'lux', '', NULL, NULL, 1, 2),
(2, 'lux', '', NULL, NULL, 1, 2),
(3, 'água', '', NULL, NULL, 1, 1),
(4, 'Telefone', '', NULL, NULL, 1, 2),
(5, 'GERA', 'DFFF', NULL, NULL, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `despesas_categorias`
--

CREATE TABLE `despesas_categorias` (
  `idDespesaCategoria` int(11) NOT NULL,
  `nmDespesaCategoria` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `despesas_categorias`
--

INSERT INTO `despesas_categorias` (`idDespesaCategoria`, `nmDespesaCategoria`) VALUES
(1, 'residencia');

-- --------------------------------------------------------

--
-- Table structure for table `despesas_meses`
--

CREATE TABLE `despesas_meses` (
  `idDespesaMes` int(11) NOT NULL,
  `idMes` int(11) DEFAULT NULL,
  `idDespesa` int(11) DEFAULT NULL,
  `ano` varchar(4) DEFAULT NULL,
  `valor` float(10,2) DEFAULT NULL,
  `dtDiaInserido` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `despesas_meses`
--

INSERT INTO `despesas_meses` (`idDespesaMes`, `idMes`, `idDespesa`, `ano`, `valor`, `dtDiaInserido`) VALUES
(1, 1, 5, NULL, 36.36, '2016-10-13 19:57:04'),
(2, NULL, NULL, NULL, 4.46, '2016-10-14 11:19:07'),
(3, 1, 4, NULL, 4.37, '2016-10-14 11:19:23'),
(4, 1, 1, NULL, 2.37, '2016-10-14 11:21:38'),
(5, NULL, NULL, NULL, 659.00, '2016-10-14 11:30:58'),
(6, 1, 1, NULL, 659.00, '2016-10-14 11:31:07');

-- --------------------------------------------------------

--
-- Table structure for table `meses`
--

CREATE TABLE `meses` (
  `idMes` int(2) NOT NULL,
  `nmMes` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meses`
--

INSERT INTO `meses` (`idMes`, `nmMes`) VALUES
(1, 'Janeiro'),
(2, 'Fervereiro');

-- --------------------------------------------------------

--
-- Table structure for table `residencias`
--

CREATE TABLE `residencias` (
  `idResidencia` int(10) NOT NULL,
  `nmResidencia` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `residencias`
--

INSERT INTO `residencias` (`idResidencia`, `nmResidencia`) VALUES
(1, 'principal');

-- --------------------------------------------------------

--
-- Table structure for table `residencias_usuarios`
--

CREATE TABLE `residencias_usuarios` (
  `idResidenciasUsuario` int(10) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `idResidencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tipos_variacao_despesa`
--

CREATE TABLE `tipos_variacao_despesa` (
  `idTiposVariacaoDespesa` int(11) NOT NULL,
  `nmTiposVariacaoDespesa` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipos_variacao_despesa`
--

INSERT INTO `tipos_variacao_despesa` (`idTiposVariacaoDespesa`, `nmTiposVariacaoDespesa`) VALUES
(1, 'fixa'),
(2, 'variavel');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(10) NOT NULL,
  `nmUsuario` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `despesas`
--
ALTER TABLE `despesas`
  ADD PRIMARY KEY (`idDespesa`),
  ADD KEY `idTiposVariacaoDespesa` (`idTiposVariacaoDespesa`),
  ADD KEY `idDespesaCategoria` (`idDespesaCategoria`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idResidencia` (`idResidencia`);

--
-- Indexes for table `despesas_categorias`
--
ALTER TABLE `despesas_categorias`
  ADD PRIMARY KEY (`idDespesaCategoria`);

--
-- Indexes for table `despesas_meses`
--
ALTER TABLE `despesas_meses`
  ADD PRIMARY KEY (`idDespesaMes`),
  ADD UNIQUE KEY `chaves_despesa_mes` (`idDespesa`,`idMes`,`ano`),
  ADD KEY `idMes` (`idMes`);

--
-- Indexes for table `meses`
--
ALTER TABLE `meses`
  ADD PRIMARY KEY (`idMes`);

--
-- Indexes for table `residencias`
--
ALTER TABLE `residencias`
  ADD PRIMARY KEY (`idResidencia`);

--
-- Indexes for table `residencias_usuarios`
--
ALTER TABLE `residencias_usuarios`
  ADD PRIMARY KEY (`idResidenciasUsuario`),
  ADD UNIQUE KEY `chaves_casas_usuarios` (`idUsuario`,`idResidencia`),
  ADD KEY `idResidencia` (`idResidencia`);

--
-- Indexes for table `tipos_variacao_despesa`
--
ALTER TABLE `tipos_variacao_despesa`
  ADD PRIMARY KEY (`idTiposVariacaoDespesa`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `despesas`
--
ALTER TABLE `despesas`
  MODIFY `idDespesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `despesas_categorias`
--
ALTER TABLE `despesas_categorias`
  MODIFY `idDespesaCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `despesas_meses`
--
ALTER TABLE `despesas_meses`
  MODIFY `idDespesaMes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `residencias`
--
ALTER TABLE `residencias`
  MODIFY `idResidencia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `residencias_usuarios`
--
ALTER TABLE `residencias_usuarios`
  MODIFY `idResidenciasUsuario` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tipos_variacao_despesa`
--
ALTER TABLE `tipos_variacao_despesa`
  MODIFY `idTiposVariacaoDespesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `despesas`
--
ALTER TABLE `despesas`
  ADD CONSTRAINT `despesas_ibfk_1` FOREIGN KEY (`idTiposVariacaoDespesa`) REFERENCES `tipos_variacao_despesa` (`idTiposVariacaoDespesa`),
  ADD CONSTRAINT `despesas_ibfk_2` FOREIGN KEY (`idDespesaCategoria`) REFERENCES `despesas_categorias` (`idDespesaCategoria`),
  ADD CONSTRAINT `despesas_ibfk_3` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `despesas_ibfk_4` FOREIGN KEY (`idResidencia`) REFERENCES `residencias` (`idResidencia`);

--
-- Constraints for table `despesas_meses`
--
ALTER TABLE `despesas_meses`
  ADD CONSTRAINT `despesas_meses_ibfk_1` FOREIGN KEY (`idMes`) REFERENCES `meses` (`idMes`),
  ADD CONSTRAINT `despesas_meses_ibfk_2` FOREIGN KEY (`idDespesa`) REFERENCES `despesas` (`idDespesa`);

--
-- Constraints for table `residencias_usuarios`
--
ALTER TABLE `residencias_usuarios`
  ADD CONSTRAINT `residencias_usuarios_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`),
  ADD CONSTRAINT `residencias_usuarios_ibfk_2` FOREIGN KEY (`idResidencia`) REFERENCES `residencias` (`idResidencia`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
