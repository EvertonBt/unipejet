-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Ago-2016 às 02:27
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lojinha`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `description` longtext NOT NULL,
  `pages` int(11) NOT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `summaryPath` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto_prices`
--

CREATE TABLE `produto_prices` (
  `Produto_id` int(11) NOT NULL,
  `bookType` int(11) DEFAULT NULL,
  `value` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `registro`
--

CREATE TABLE `registro` (
  `numero_registro` int(11) NOT NULL,
  `numero_passagens` int(11) DEFAULT NULL,
  `responsavel` varchar(255) NOT NULL,
  `total` double NOT NULL,
  `total_milhas` double NOT NULL,
  `data_hora` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `registro`
--

INSERT INTO `registro` (`numero_registro`, `numero_passagens`, `responsavel`, `total`, `total_milhas`, `data_hora`) VALUES
(12, 1, 'adm@gmail.com', 800, 1056.329, NULL),
(13, 1, 'adm@gmail.com', 800, 1056.329, NULL),
(14, 1, 'adm@gmail.com', 800, 1056.329, NULL),
(15, 1, 'adm@gmail.com', 800, 1056.329, NULL),
(16, 2, 'adm@gmail.com', 600, 621.37, NULL),
(17, 1, 'adm@gmail.com', 300, 310.685, NULL),
(18, 1, 'adm@gmail.com', 1000, 497.096, NULL),
(20, 1, 'administrador@gmail.com', 600, 1056.329, NULL),
(21, 1, 'maicon@gmail.com', 600, 497.096, NULL),
(22, 1, 'administrador@gmail.com', 600, 1056.329, NULL),
(23, 1, 'administrador@gmail.com', 999, 61.515629999999994, NULL),
(24, 2, 'administrador@gmail.com', 1998, 123.03125999999999, NULL),
(25, 7, 'administrador@gmail.com', 6993, 430.60940999999997, NULL),
(26, 1, 'administrador@gmail.com', 999, 61.515629999999994, '27-08-2016:21:07'),
(27, 1, 'macaco@gmail.com', 999, 61.515629999999994, '27-08-2016:22:05'),
(28, 8, 'administrador@gmail.com', 5200, 492.12503999999996, '29-08-2016:20:34'),
(29, 1, 'katy@gmail.com', 650, 21.12658, '29-08-2016:21:17');

-- --------------------------------------------------------

--
-- Estrutura da tabela `role`
--

CREATE TABLE `role` (
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `role`
--

INSERT INTO `role` (`name`) VALUES
('ROLE_ADMIN'),
('ROLE_CLIENTE');

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

CREATE TABLE `user` (
  `login` varchar(255) NOT NULL,
  `cartao_milha` double NOT NULL,
  `documento` varchar(255) NOT NULL,
  `idade` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `releaseDate` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `senha_testa` varchar(255) NOT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `cartao_credito` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`login`, `cartao_milha`, `documento`, `idade`, `name`, `password`, `releaseDate`, `role`, `senha_testa`, `tipo_documento`, `cartao_credito`) VALUES
('adm@gmail.com', 1471676154634, '984898489', 34, 'Administrador', '$2a$10$ERdR.phuNFXIldfuxyJbTeA80CPExXpSaUgTWGfAMkIIT8QRI9iLa', '1982-08-28', 'ROLE_ADMIN', '$2a$10$ERdR.phuNFXIldfuxyJbTeA80CPExXpSaUgTWGfAMkIIT8QRI9iLa', 'RG', 0),
('administrador@gmail.com', 1471831475104, '13232', 36, 'Administrador', '$2a$10$demyzJT7NbRWwE0X1LuLnuIKKLg8e0WzCn02vyn3WQxWqNXBjpeBC', '1980-08-31', 'ROLE_ADMIN', '$2a$10$demyzJT7NbRWwE0X1LuLnuIKKLg8e0WzCn02vyn3WQxWqNXBjpeBC', 'CPF', 6718.545030000001),
('alex@gmail.com', 1471741511517, '34242', 52, 'Alex', '$2a$10$GxBtAAxwyEsWYLU2jHbHeeBoLKYIqvVvecCJ0gUerRSZVWDL8BXJa', '1964-08-26', 'ROLE_CLIENTE', '$2a$10$GxBtAAxwyEsWYLU2jHbHeeBoLKYIqvVvecCJ0gUerRSZVWDL8BXJa', 'RG', 0),
('Alexandre@gmail.com', 1472513869104, '443', 27, 'alexandre', '$2a$10$q2KIUpQpC9e0DVX8LNf0b.Oa1rw0qlSjJ2pchrbZCPr0lZcEHXRLW', '1989-08-24', 'ROLE_ADMIN', '$2a$10$q2KIUpQpC9e0DVX8LNf0b.Oa1rw0qlSjJ2pchrbZCPr0lZcEHXRLW', 'RG', 10000),
('aluna@gmail.com', 1472515871816, '4343', 44, 'aluna', '$2a$10$8cnPJGcOMR7iOZ31VtTzy.3qcTEM0cYW6h.65916hlYmtYg7yFqU2', '1972-08-31', 'ROLE_CLIENTE', '$2a$10$8cnPJGcOMR7iOZ31VtTzy.3qcTEM0cYW6h.65916hlYmtYg7yFqU2', 'RG', 10000),
('andrea@gmail.com', 1471809548537, '4322', 38, 'Andrea', '$2a$10$SSDA.i9vIeOBYswlybhZ4.UtTIt/3tHfF.Qx38RJPDAQFUI6mGwP2', '1978-08-02', 'ROLE_CLIENTE', '$2a$10$SSDA.i9vIeOBYswlybhZ4.UtTIt/3tHfF.Qx38RJPDAQFUI6mGwP2', 'RG', 0),
('angelo@hotmail.com', 1471824656167, '2323', 38, 'angelo', '$2a$10$25N6LnG.FNW6p05TG8J9TO2Zr/GBrnT9Or.BNEu/UV97/SL9gFJr2', '1978-08-04', 'ROLE_CLIENTE', '$2a$10$25N6LnG.FNW6p05TG8J9TO2Zr/GBrnT9Or.BNEu/UV97/SL9gFJr2', 'RG', 10000),
('asa@gmail.com', 1472515768477, '2323', 46, 'kslkals', '$2a$10$ra.p7HudmRuCsNYvk9YJH.PzmudATU0tbZa/5V6nHHh7RbU.NH1aq', '1970-08-31', 'ROLE_CLIENTE', '$2a$10$ra.p7HudmRuCsNYvk9YJH.PzmudATU0tbZa/5V6nHHh7RbU.NH1aq', 'RG', 10000),
('baba@gmail.com', 1472514895904, '43423', 32, 'baba', '$2a$10$ONvgThLFxhPsaT745ZuN..9R4OWFNw5PWZgEuqqNO.stknGAO7qI6', '1984-08-25', 'ROLE_CLIENTE', '$2a$10$ONvgThLFxhPsaT745ZuN..9R4OWFNw5PWZgEuqqNO.stknGAO7qI6', 'RG', 10000),
('ee@jonhs.com', 1471670703373, 'asa', 30, 'sasasa', '123', '1986-08-03', 'ROLE_CLIENTE', '123', 'RG', 0),
('ellie@gmail.com', 1471910784576, '434343', 30, 'Ellie', '$2a$10$esDJPngKF2DdMbrSeriyEOVSI2iKnQ3vv/E4YhKX2CCZ0TQJCTMq2', '1986-08-23', 'ROLE_CLIENTE', '$2a$10$esDJPngKF2DdMbrSeriyEOVSI2iKnQ3vv/E4YhKX2CCZ0TQJCTMq2', 'RG', 10000),
('everonud@gmail.com', 1471671427655, 'sasa', 26, 'eeaea', '$2a$10$P6uOq4gbQB0NuK2YUEuDWuloFxNToQho.YcA.1aru.eO2RsOE3Fi.', '1990-08-25', 'ROLE_CLIENTE', '$2a$10$P6uOq4gbQB0NuK2YUEuDWuloFxNToQho.YcA.1aru.eO2RsOE3Fi.', 'CPF', 0),
('everton@gmail.com', 1471676687378, '33333', 32, 'Everton', '$2a$10$DjeIK/QhpW0zPCxd6hFlMe3bJ2ADZfjSDk5HvnjvHrcle4X7rN6OO', '1984-08-25', 'ROLE_ADMIN', '$2a$10$DjeIK/QhpW0zPCxd6hFlMe3bJ2ADZfjSDk5HvnjvHrcle4X7rN6OO', 'RG', 0),
('evertonid@ymail.clom', 1471673937719, '21212121', 32, 'everton', '$2a$10$R9owFEpbq8cLXt6RqI4dROJNbHVZ.VVi6.8wMNkbxIfKMRVotKGru', '1984-08-24', 'ROLE_CLIENTE', '$2a$10$R9owFEpbq8cLXt6RqI4dROJNbHVZ.VVi6.8wMNkbxIfKMRVotKGru', 'RG', 0),
('fugioka@gmail.com', 1472513914969, '34343', 35, 'Rodrigo', '$2a$10$GllcUyTOpCGdZhmEv7th5eZhT42j6P5Kx8vrc0Xo3NKYarwMACkf2', '1981-08-30', 'ROLE_ADMIN', '$2a$10$GllcUyTOpCGdZhmEv7th5eZhT42j6P5Kx8vrc0Xo3NKYarwMACkf2', 'RG', 10000),
('harry@gmail.com', 1472516375330, 'rerer', 51, 'harry', '$2a$10$pK.Q.x4JZDMPEy9Fs0N/D.VuhcLoamUqFwihbuVWVij.ZkypjYBQS', '1965-08-30', 'ROLE_CLIENTE', '$2a$10$pK.Q.x4JZDMPEy9Fs0N/D.VuhcLoamUqFwihbuVWVij.ZkypjYBQS', 'RG', 10000),
('henry@gmail.com', 1472516495785, '45547', 34, 'Henry', '$2a$10$ceyxehQeAxKLAbN99thxHOt/f.h.NNJIkxvenvMDfO4Hu2AV7svOa', '1982-08-31', 'ROLE_CLIENTE', '$2a$10$ceyxehQeAxKLAbN99thxHOt/f.h.NNJIkxvenvMDfO4Hu2AV7svOa', 'RG', 10000),
('juca@gmail.com', 1472515727836, '2323', 35, 'juca', '$2a$10$0IT9/EK4PrrsVCOH896/DeIdt27c9Xe7O7yMGHOsaDXaFDFrt/Cq6', '1981-08-31', 'ROLE_CLIENTE', '$2a$10$0IT9/EK4PrrsVCOH896/DeIdt27c9Xe7O7yMGHOsaDXaFDFrt/Cq6', 'RG', 10000),
('jucapires@gmail.com', 1471834946429, '232', 36, 'juca', '$2a$10$wQQVtPuyolec2twA4oGucOSc5vPtm/PHhMaSiNcJcDur.JXLr/jLO', '1980-08-24', 'ROLE_CLIENTE', '$2a$10$wQQVtPuyolec2twA4oGucOSc5vPtm/PHhMaSiNcJcDur.JXLr/jLO', 'RG', 10000),
('katy@gmail.com', 1472516158222, '43343', 38, 'Katy', '$2a$10$RSSOQf83osqlRJ.mwP2D3.vWaPj5Dd13yorodMUpIVaRkSBpqFudS', '1978-08-30', 'ROLE_CLIENTE', '$2a$10$RSSOQf83osqlRJ.mwP2D3.vWaPj5Dd13yorodMUpIVaRkSBpqFudS', 'RG', 9978.87342),
('lilian@gmail.com', 1471823891695, 'eeewew', 39, 'lilian', '$2a$10$fMFR0vSj1Gg8FBrm7IY7e.ahQyiuR72r8gaDw9liGJGRryXK3tPzG', '1977-08-03', 'ROLE_CLIENTE', '$2a$10$fMFR0vSj1Gg8FBrm7IY7e.ahQyiuR72r8gaDw9liGJGRryXK3tPzG', 'RG', 10000),
('macaco@gmail.com', 1472346262334, '54545454', 30, 'macaco', '$2a$10$K5SHMm55aYXa6dAPPrAHt.fnRAoW6J8gSdfWakjMhmzQWZP8bFuAW', '1986-08-25', 'ROLE_CLIENTE', '$2a$10$K5SHMm55aYXa6dAPPrAHt.fnRAoW6J8gSdfWakjMhmzQWZP8bFuAW', 'RG', 9938.48437),
('maicon@gmail.com', 1471833134503, '443', 26, 'maicon', '$2a$10$IBObNLnCBkTC54qfgWd2h.lqRwCp8HciR8yPywb1piFSi7y3f9UDm', '1990-10-10', 'ROLE_CLIENTE', '$2a$10$IBObNLnCBkTC54qfgWd2h.lqRwCp8HciR8yPywb1piFSi7y3f9UDm', 'RG', 9502.904),
('marilene@gmail.com', 1471824383124, '33333333', 32, 'marielen', '$2a$10$6A1E/9qfOGsz.U4JG9GPsefO4vc5BXMh5Tzh.dmN1kKprbehzsUeC', '1984-08-03', 'ROLE_CLIENTE', '$2a$10$6A1E/9qfOGsz.U4JG9GPsefO4vc5BXMh5Tzh.dmN1kKprbehzsUeC', 'CPF', 10000),
('mike@gmail.com', 1472516582309, '43434', 42, 'mike', '$2a$10$xqmO2dEUEAY/rPUqyJZk2euRZ3q/IFgBptPbM5EXkFpjSo3hsMxay', '1974-08-25', 'ROLE_ADMIN', '$2a$10$xqmO2dEUEAY/rPUqyJZk2euRZ3q/IFgBptPbM5EXkFpjSo3hsMxay', 'RG', 10000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_role`
--

CREATE TABLE `user_role` (
  `User_login` varchar(255) NOT NULL,
  `roles_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `user_role`
--

INSERT INTO `user_role` (`User_login`, `roles_name`) VALUES
('everonud@gmail.com', 'ROLE_CLIENTE'),
('evertonid@ymail.clom', 'ROLE_CLIENTE'),
('evertonid@ymail.clom', 'ROLE_ADMIN'),
('everton@gmail.com', 'ROLE_ADMIN'),
('alex@gmail.com', 'ROLE_CLIENTE'),
('ee@jonhs.com', 'ROLE_CLIENTE'),
('lilian@gmail.com', 'ROLE_CLIENTE'),
('marilene@gmail.com', 'ROLE_CLIENTE'),
('andrea@gmail.com', 'ROLE_CLIENTE'),
('angelo@hotmail.com', 'ROLE_CLIENTE'),
('maicon@gmail.com', 'ROLE_CLIENTE'),
('jucapires@gmail.com', 'ROLE_CLIENTE'),
('adm@gmail.com', 'ROLE_ADMIN'),
('ellie@gmail.com', 'ROLE_CLIENTE'),
('macaco@gmail.com', 'ROLE_CLIENTE'),
('administrador@gmail.com', 'ROLE_ADMIN'),
('Alexandre@gmail.com', 'ROLE_ADMIN'),
('fugioka@gmail.com', 'ROLE_ADMIN'),
('baba@gmail.com', 'ROLE_CLIENTE'),
('juca@gmail.com', 'ROLE_CLIENTE'),
('asa@gmail.com', 'ROLE_CLIENTE'),
('aluna@gmail.com', 'ROLE_CLIENTE'),
('katy@gmail.com', 'ROLE_CLIENTE'),
('harry@gmail.com', 'ROLE_CLIENTE'),
('henry@gmail.com', 'ROLE_CLIENTE'),
('mike@gmail.com', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Estrutura da tabela `voos`
--

CREATE TABLE `voos` (
  `identificador` int(11) NOT NULL,
  `assentos` int(11) DEFAULT NULL,
  `capacidade` int(11) NOT NULL,
  `data` varchar(255) NOT NULL,
  `destino` varchar(255) NOT NULL,
  `distancia` varchar(255) NOT NULL,
  `duracao` varchar(255) NOT NULL,
  `hora_partida` varchar(255) NOT NULL,
  `origem` varchar(255) NOT NULL,
  `preco` float NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `voos`
--

INSERT INTO `voos` (`identificador`, `assentos`, `capacidade`, `data`, `destino`, `distancia`, `duracao`, `hora_partida`, `origem`, `preco`, `status`) VALUES
(27, 87, 99, '21/08/2016', 'Rio de Janeiro', '99', '99', '07:00', 'Recife', 845, 1),
(28, 93, 100, '21/08/2016', 'Rio de Janeiro', '99', '99', '07:00', 'Recife', 650, 1),
(29, 97, 99, '21/08/2016', 'Rio de Janeiro', '99', '99', '07:00', 'Recife', 650, 1),
(30, 99, 100, '21/08/2016', 'Rio de Janeiro', '99', '99', '07:00', 'Recife', 650, 1),
(40, 443, 444, '21/08/2016', 'Rio de Janeiro', '34', '44', '09:00', 'Recife', 650, 1),
(41, 22, 22, '21/08/2016', 'Rio de Janeiro', '22', '22', '07:00', 'Recife', 650, 1),
(42, 443, 443, '26/08/2016', 'Recife', '443', '34', '10:00', 'Recife', 650, 1),
(46, 100, 100, '26/08/2016', 'Rio de Janeiro', '800', '5', '07:00', 'Recife', 650, 1),
(47, 100, 100, '26/08/2016', 'Fortaleza', '700', '7', '08:00', 'Recife', 650, 1),
(48, 100, 100, '25/08/2016', 'Rio de Janeiro', '800', '4', '07:00', 'Recife', 650, 1),
(49, 100, 100, '26/08/2016', 'Fortaleza', '700', '6', '10:00', 'Recife', 650, 1),
(50, 100, 100, '27/08/2016', 'Recife', '800', '4', '09:00', 'Rio de Janeiro', 650, 1),
(51, 100, 100, '28/08/2016', 'Fortaleza', '800', '4', '11:00', 'Rio de Janeiro', 650, 1),
(52, 100, 100, '26/08/2016', 'Rio de Janeiro', '890', '4', '08:00', 'Recife', 650, 1),
(53, 100, 100, '26/08/2016', 'Rio de Janeiro', '700', '6', '07:00', 'Recife', 650, 1),
(54, 100, 100, '20/08/2016', 'Fortaleza', '500', '680', '08:00', 'Recife', 910, 1),
(56, 100, 100, '26/12/2016', 'Rio de Janeiro', '2000', '10', '08:00', 'Recife', 1000, 0),
(57, 100, 100, '26/08/2016', 'Rio de Janeiro', '678', '5', '09:00', 'Recife', 1025.7, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto_prices`
--
ALTER TABLE `produto_prices`
  ADD KEY `FK_q3owa1fuk6mtgaxxkq4oa8n9k` (`Produto_id`);

--
-- Indexes for table `registro`
--
ALTER TABLE `registro`
  ADD PRIMARY KEY (`numero_registro`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`login`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK_kj5hi20v94v3qegbsqh36eqet` (`roles_name`),
  ADD KEY `FK_besatukaomklekcnfr4w6ti9y` (`User_login`);

--
-- Indexes for table `voos`
--
ALTER TABLE `voos`
  ADD PRIMARY KEY (`identificador`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `registro`
--
ALTER TABLE `registro`
  MODIFY `numero_registro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `voos`
--
ALTER TABLE `voos`
  MODIFY `identificador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `produto_prices`
--
ALTER TABLE `produto_prices`
  ADD CONSTRAINT `FK_q3owa1fuk6mtgaxxkq4oa8n9k` FOREIGN KEY (`Produto_id`) REFERENCES `produto` (`id`);

--
-- Limitadores para a tabela `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK_besatukaomklekcnfr4w6ti9y` FOREIGN KEY (`User_login`) REFERENCES `user` (`login`),
  ADD CONSTRAINT `FK_kj5hi20v94v3qegbsqh36eqet` FOREIGN KEY (`roles_name`) REFERENCES `role` (`name`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
