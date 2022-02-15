DROP DATABASE IF EXISTS `receta`;
CREATE DATABASE `receta`;
USE `receta`;

CREATE TABLE `users` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `user` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `rol` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` (`user`, `password`, `rol`) VALUES
    ('admin', 'admin', 'profesor'),
    ('juan', 'j4', 'alumno');

CREATE TABLE `recetas` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(255) NOT NULL,
    `user` int(11) NOT NULL,
    `tipo` varchar(255) NOT NULL,
    `ingredientes` varchar(255) NOT NULL,
    `pasos` varchar(255) NOT NULL,
    `comensales` int,
    `tiempo` int,
    `calorias` int NOT NULL,
    `imagen` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_recetas_users` FOREIGN KEY (`user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 INSERT INTO `recetas` (`nombre`, `user`, `tipo`, `ingredientes`, `pasos`, `comensales`, `tiempo`, `calorias`, `imagen`) VALUES
     ("Flan", 2, "Postres","-Huevos -Leche", "-Batir -Hornear", 4, 30, 140, "flan.jpg"),
     ("Pollo", 2, "Segundo", "-Pollo -Aceite", "-Poner en la plancha", 2, 15, 200, "pollo.jpg");