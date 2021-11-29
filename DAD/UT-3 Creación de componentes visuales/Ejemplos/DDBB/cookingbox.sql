-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2021 a las 19:07:11
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cookingbox`
--
CREATE DATABASE IF NOT EXISTS `cookingbox` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `cookingbox`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recipes`
--

CREATE TABLE `recipes` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `category` varchar(50) NOT NULL,
  `time` varchar(10) NOT NULL,
  `ingredients` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `recipes`
--

INSERT INTO `recipes` (`id`, `name`, `category`, `time`, `ingredients`, `description`) VALUES
(1, 'Macarrones', 'carne', '20', 'Macarrones, carne, tomate frito de pote', 'Cueces los macarrones, haces la carne, tiras el tomate por encima de la carne cuando este cocida y cuando los macarrones estén hechos lo unes todo en la cazuela, lo remueves y listo. '),
(3, '1', 'pescado', '10', 'vieja,\nsal,perejil,ajo, AOVE( Aceite virgen extra', 'Calentar sartén en el fuego, limpiar y preparar bien \'la vieja\' y ponerla en la sartén 5 minutos. Preparar la picada de ajo perejil con el aceite y cuando el pescado este listo lo enplatamos y le ponemos la sal y la picada.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(1, 'juan', 'j4', 'profesor'),
(2, 'ana', 'a3', 'alumna'),
(3, 'jonay', 'j5', 'alumno');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `recipes`
--
ALTER TABLE `recipes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category` (`category`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `recipes`
--
ALTER TABLE `recipes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
