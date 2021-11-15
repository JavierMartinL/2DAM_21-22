DROP DATABASE IF EXISTS oficina;
CREATE DATABASE oficina;
use oficina;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `lapices` (
 `idlapiz` int AUTO_INCREMENT PRIMARY KEY NOT NULL,
 `marca` char(30) NOT NULL,
 `numero` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `lapices` (`marca`, `numero`) VALUES
('staedtler', 2),
('alpino', 1),
('alpino', 3),
('staedtler', 1);
COMMIT;