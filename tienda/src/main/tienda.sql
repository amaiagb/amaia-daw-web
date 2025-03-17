-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.24-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para tienda
CREATE DATABASE IF NOT EXISTS `tienda` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `tienda`;

-- Volcando estructura para tabla tienda.administradores
CREATE TABLE IF NOT EXISTS `administradores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL DEFAULT '0',
  `Username` varchar(50) NOT NULL DEFAULT '0',
  `Password` varchar(100) NOT NULL DEFAULT '0',
  `Email` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla tienda.administradores: ~1 rows (aproximadamente)
INSERT INTO `administradores` (`id`, `Nombre`, `Username`, `Password`, `Email`) VALUES
	(1, 'Alberto', 'alberto', '1234', 'alberto@gmail.com');

-- Volcando estructura para tabla tienda.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla tienda.categorias: ~3 rows (aproximadamente)
INSERT INTO `categorias` (`id`, `nombre`) VALUES
	(1, 'electronica'),
	(2, 'sonido'),
	(3, 'gaming');

-- Volcando estructura para tabla tienda.productos
CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL DEFAULT '0',
  `Descripcion` text NOT NULL,
  `Precio` double NOT NULL DEFAULT 0,
  `Stock` int(11) NOT NULL DEFAULT 0,
  `Imagen` varchar(50) NOT NULL DEFAULT '0',
  `Categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_productos_categorias` (`Categoria`),
  CONSTRAINT `FK_productos_categorias` FOREIGN KEY (`Categoria`) REFERENCES `categorias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla tienda.productos: ~6 rows (aproximadamente)
INSERT INTO `productos` (`id`, `Nombre`, `Descripcion`, `Precio`, `Stock`, `Imagen`, `Categoria`) VALUES
	(1, 'Cámara', 'Cámara reflex Fujifilm', 600, 3, 'camara.jpg', 1),
	(2, 'Ipad', 'iPad 256GB', 400, 10, 'ipad.jpg', 1),
	(3, 'Auriculares', 'Auriculares Bluetooth', 160, 8, 'headphones.jpg', 2),
	(4, 'NES', 'Nintendo NES', 320, 2, 'nes.jpg', 3),
	(5, 'Auriculares Sony', 'Auriculares Bluetooth', 210, 20, 'cascos.jpg', 2),
	(6, 'Drone', 'Drone 4K Film', 999, 5, 'drone.jpg', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
