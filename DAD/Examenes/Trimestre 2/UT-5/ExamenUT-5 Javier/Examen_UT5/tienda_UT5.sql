SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `tienda_UT5` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `tienda_UT5`;

CREATE TABLE `basket` (
  `id_basket` int(11) NOT NULL,
  `id_catman` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `basket` (`id_basket`, `id_catman`, `name`, `total`) VALUES
(1, 12345670, 'Shirts2', 150),
(2, 12345674, 'Jeans3', 56.34),
(3, 12345675, 'Jeans2', 398.93),
(4, 12345678, 'Jeans1', 52.68),
(5, 12345670, 'shirts2', 2),
(6, 12345670, 'Shirts2', 0),
(7, 12345671, 'T-shirts1', 27),
(8, 12345678, 'Jeans1', 52.68),
(9, 12345671, 'T-shirts1', 36),
(10, 12345675, 'Jeans2', 398.93),
(11, 12345675, 'Jeans2', 398.93),
(12, 12345671, 'T-shirts1', 36),
(13, 12345671, 'T-shirts1', 18),
(14, 12345671, 'T-shirts1', 9),
(15, 12345671, 'T-shirts1', 18),
(16, 12345671, 'T-shirts1', 18),
(17, 12345671, 'T-shirts1', 18);

CREATE TABLE `categories` (
  `id_category` int(11) NOT NULL,
  `description` varchar(30) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `categories` (`id_category`, `description`) VALUES
(1, 'woman'),
(2, 'man'),
(3, 'kids'),
(4, 'news');

CREATE TABLE `catman` (
  `id` int(8) NOT NULL,
  `name` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `category` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_spanish2_ci NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `catman` (`id`, `name`, `category`, `description`, `price`, `quantity`) VALUES
(12345670, 'Shirts2', 'Shirts', 'És un shirt espectacular', 15, 10),
(12345671, 'T-shirts1', 'T-shirts', 'És un T-shirt espectacular', 9, 4),
(12345672, 'Shirts3', 'Shirts', 'És un shirt espectacular', 29.99, 30),
(12345673, 'Shirts4', 'Shirts', 'És un shirt espectacular', 19.95, 4),
(12345674, 'Jeans3', 'Jeans', 'És un jean espectacular', 56.34, 0),
(12345675, 'Jeans2', 'Jeans', 'És un jean espectacular', 56.99, 3),
(12345676, 'T-shirts2', 'T-shirts', 'És un T-shirt espectacular', 2, 2),
(12345678, 'Jeans1', 'Jeans', 'És un jean espectacular', 26.34, 8),
(12345679, 'Shirts1', 'Shirts', 'És un shirt espectacular', 18, 3);

CREATE TABLE `users` (
  `id_staff` int(10) NOT NULL,
  `password` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

INSERT INTO `users` (`id_staff`, `password`, `role`) VALUES
(12345678, 'pruebas', 'basic'),
(12345679, 'manager', 'admin'),
(15895145, 'Xenia2345', 'basic'),
(20154878, 'Zara2017', 'basic');


ALTER TABLE `basket`
  ADD PRIMARY KEY (`id_basket`) USING BTREE,
  ADD KEY `id_basket` (`id_basket`),
  ADD KEY `id_catman` (`id_catman`);

ALTER TABLE `categories`
  ADD PRIMARY KEY (`id_category`);

ALTER TABLE `catman`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `users`
  ADD PRIMARY KEY (`id_staff`);


ALTER TABLE `basket`
  MODIFY `id_basket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;


ALTER TABLE `basket`
  ADD CONSTRAINT `basket_ibfk_1` FOREIGN KEY (`id_catman`) REFERENCES `catman` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
