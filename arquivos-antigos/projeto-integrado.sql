-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.24-log
-- Versão do PHP: 5.3.13
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `projeto-integrado`

--
drop database if exists `projeto-integrado`;
create database if not exists `projeto-integrado`;
use `projeto-integrado`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `automovel`
--

CREATE TABLE IF NOT EXISTS `automovel` (
  `au_code` int(10) NOT NULL AUTO_INCREMENT,
  `au_chassi` varchar(50) NOT NULL,
  `au_modelo` varchar(50) NOT NULL,
  `au_placa` varchar(10) NOT NULL,
  `au_grupo` varchar(30) NOT NULL,
  `au_fabricante` varchar(40) NOT NULL,
  `au_cidade` varchar(50) NOT NULL,
  `au_estado` varchar(3) NOT NULL,
  `au_km` int(6) NOT NULL,
  `au_kmLivre` varchar(40) NOT NULL,
  `au_kmControlado` varchar(40) NOT NULL,
  `au_foto` varchar(100) NOT NULL,
  `au_gps` varchar(6) NOT NULL,
  `au_cadeira` varchar(6) NOT NULL,
  `au_motorista` varchar(6) NOT NULL,
  PRIMARY KEY (`au_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `automovel`
--

INSERT INTO `automovel` (`au_code`, `au_chassi`, `au_modelo`, `au_placa`, `au_grupo`, `au_fabricante`, `au_cidade`, `au_estado`, `au_km`, `au_kmLivre`, `au_kmControlado`,`au_foto`, `au_gps`, `au_cadeira`, `au_motorista`) VALUES
(3, 'CH123456789', 'CORSA', 'SAT-4666', 'A - Econômico', 'CHEVROLET', 'São Paulo', ' SP', 2300, '1.20', '1.20', '/images/Carros/carro3.png','true','false','false'),
(5, 'CH987654321', 'CELTA', 'PLC-1234', 'B - SEI LÁ ESSE GRUPO', 'FIAT', '897', ' SP', 10000, '2.00', '3.00', '/images/Carros/carro1.png','false','true','false'),
(6, '1234567890', 'MODELO', 'DLU-6666', 'C - 123MUDAR', 'FABRICANTE', 'SAO PAULO', ' SP', 40, '1,20', '2,20', '/images/Carros/carro2.png','true','false','true');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `cl_code` int(10) NOT NULL AUTO_INCREMENT,
  `cl_cpf` varchar(16) NOT NULL,
  `cl_nome` varchar(60) NOT NULL,
  `cl_documento` varchar(20) NOT NULL,
  `cl_email` varchar(40) NOT NULL,
  `cl_telefone` varchar(22) NOT NULL,
  `cl_nascimento` date NOT NULL,
  `cl_sexo` varchar(1) NOT NULL,
  `cl_ufcode` varchar(20) NOT NULL,
  `cl_cidade` varchar(40) NOT NULL,
  `cl_endereco` varchar(50) NOT NULL,
  `cl_numEndereco` varchar(10) NOT NULL,
  `cl_cadastro` date NOT NULL,
  `cl_hb_num` varchar(20) NOT NULL,
  `cl_hb_validade` date NOT NULL,
  `cl_hb_ufcode` varchar(20) NOT NULL,
  `cl_hb_cidade` varchar(40) NOT NULL,
  `cl_bairro` varchar(45) NOT NULL,
  PRIMARY KEY (`cl_code`,`cl_cpf`),
  KEY `cl_bairro` (`cl_bairro`),
  KEY `cl_hb_validade` (`cl_hb_validade`),
  KEY `cl_hb_num` (`cl_hb_num`),
  KEY `cl_cadastro` (`cl_cadastro`),
  KEY `cl_code` (`cl_code`,`cl_cpf`,`cl_nome`,`cl_documento`,`cl_email`,`cl_telefone`,`cl_nascimento`,`cl_sexo`,`cl_ufcode`,`cl_cidade`,`cl_endereco`,`cl_numEndereco`,`cl_cadastro`,`cl_hb_num`,`cl_hb_validade`,`cl_bairro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`cl_code`, `cl_cpf`, `cl_nome`, `cl_documento`, `cl_email`, `cl_telefone`, `cl_nascimento`, `cl_sexo`, `cl_ufcode`, `cl_cidade`, `cl_endereco`, `cl_numEndereco`, `cl_cadastro`, `cl_hb_num`, `cl_hb_validade`, `cl_hb_ufcode`, `cl_hb_cidade`, `cl_bairro`) VALUES
(5, '41277883807', 'Ramon Andrade Antunes', '375419950', 'andrade_ramon@outlook.com', '1127416737', '2014-10-20', 'f', 'SP', 'São Paulo', 'João Bezerra de Souza', '45', '1990-10-10', '12345', '1990-10-10', 'SP', 'São Paulo', ''),
(6, '43764769056', 'Eric de Abreu Dallo', '356834393', 'ericdallo06@hotmail.com', '1129574905', '2014-10-14', 'f', 'SP', 'São Paulo', 'Aquilino Vidal', '18', '1992-06-02', '67890', '1992-06-02', 'SP', 'São Paulo', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao`
--

CREATE TABLE IF NOT EXISTS `locacao` (
  `lc_code` int(10) NOT NULL AUTO_INCREMENT,
  `cl_code` int(10) NOT NULL,
  `au_code` int(10) NOT NULL,
  `lc_dtlocacao` date NOT NULL,
  `lc_dtprevista` date NOT NULL,
  `lc_aglocacao` varchar(10) NOT NULL,
  `lc_agprevista` varchar(10) NOT NULL,
  `lc_tipokm` varchar(1) NOT NULL,
  `lc_valor` float(11,2) NOT NULL,
  `pg_code` int(10) DEFAULT NULL,
  `lc_dtdevolucao` date DEFAULT NULL,
  `lc_agdevolucao` varchar(10) DEFAULT NULL,
  `lc_status` varchar(10) NOT NULL,
  PRIMARY KEY (`lc_code`),
  KEY `pg_code` (`pg_code`),
  KEY `cl_code` (`cl_code`),
  KEY `au_code` (`au_code`),
  KEY `au_code_2` (`au_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;

--
-- Extraindo dados da tabela `locacao`
--

INSERT INTO `locacao` (`lc_code`, `cl_code`, `au_code`, `lc_dtlocacao`, `lc_dtprevista`, `lc_aglocacao`, `lc_agprevista`, `lc_tipokm`, `lc_valor`, `pg_code`, `lc_dtdevolucao`, `lc_agdevolucao`, `lc_status`) VALUES
(36, 5, 3, '2014-10-19', '2014-10-20', 'SP', 'SP', 'L', 1555.55, 20, '2014-12-30', 'RJ', 'F'),
(37, 5, 3, '2014-10-20', '2014-10-22', 'SP', 'SP', 'L', 500.00, 21, '2014-10-21', 'RJ', 'F'),
(38, 6, 5, '2014-10-14', '2014-10-27', 'SP', 'SP', 'L', 200.00, 22, '2014-10-26', 'RJ', 'F');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
  `pg_code` int(10) NOT NULL AUTO_INCREMENT,
  `lc_code` int(10) NOT NULL,
  `pg_valor` float(11,2) NOT NULL DEFAULT '0.00',
  `pg_tipopag` varchar(1) DEFAULT NULL,
  `pg_status` varchar(20) NOT NULL DEFAULT 'A',
  `pg_numerocartao` varchar(20) DEFAULT NULL,
  `pg_datavalidade` date DEFAULT NULL,
  `pg_codigoseguranca` varchar(5) DEFAULT NULL,
  `pg_banco` varchar(20) DEFAULT NULL,
  `pg_agencia` varchar(20) DEFAULT NULL,
  `pg_conta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pg_code`),
  KEY `lc_code` (`lc_code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Extraindo dados da tabela `pagamento`
--

INSERT INTO `pagamento` (`pg_code`, `lc_code`, `pg_valor`, `pg_tipopag`, `pg_status`, `pg_numerocartao`, `pg_datavalidade`, `pg_codigoseguranca`, `pg_banco`, `pg_agencia`, `pg_conta`) VALUES
(20, 36, 3111.10, 'D', 'F', NULL, NULL, NULL, 'Itau', '1514', '17542-9'),
(21, 37, 500.00, 'D', 'F', NULL, NULL, NULL, 'ituau', '1514', '12131'),
(22, 38, 200.00, 'D', 'F', NULL, NULL, NULL, 'bradesco', '0088', '13425');

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `locacao_ibfk_1` FOREIGN KEY (`pg_code`) REFERENCES `pagamento` (`pg_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `locacao_ibfk_2` FOREIGN KEY (`cl_code`) REFERENCES `cliente` (`cl_code`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `locacao_ibfk_4` FOREIGN KEY (`au_code`) REFERENCES `automovel` (`au_code`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para a tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`lc_code`) REFERENCES `locacao` (`lc_code`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;