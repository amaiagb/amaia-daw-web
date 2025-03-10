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


-- Volcando estructura de base de datos para inventario
CREATE DATABASE IF NOT EXISTS `inventario` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `inventario`;

-- Volcando estructura para tabla inventario.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `imagen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla inventario.producto: ~7 rows (aproximadamente)
INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `imagen`) VALUES
	(1, 'iPad Pro', 'iPad Pro 11" 256GB Negro espacial', 1079.00, 10, NULL),
	(2, 'iPad mini', 'iPad mini 128GB Wi-fi Blanco', 539.00, 20, NULL),
	(3, 'MacBook Air', 'MacBook Air 13" Plata', 1409.00, 15, NULL),
	(7, 'iMac', 'iMac 256GB Azul', 1479.00, 17, NULL),
	(8, 'MacBook Pro', 'MacBook Pro 14" 512GB', 1809.00, 8, NULL),
	(9, 'Apple Watch SE', 'Apple Watch Plata 44mm GPS + Cellular', 329.00, 6, NULL),
	(10, 'iPhone 16', '128GB Negro', 959.00, 30, NULL);

-- Volcando estructura para tabla inventario.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Nombre` varchar(100) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Rol` varchar(50) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla inventario.usuarios: ~2 rows (aproximadamente)
INSERT INTO `usuarios` (`Nombre`, `Username`, `Password`, `Rol`) VALUES
	('Alberto', 'alberto', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'admin'),
	('Amaia', 'amaia', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'usuario');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
