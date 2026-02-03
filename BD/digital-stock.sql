-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-02-2026 a las 15:21:58
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `digital-stock`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bitacora`
--

CREATE TABLE `bitacora` (
  `id` int(11) NOT NULL,
  `cedula` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(50) NOT NULL,
  `accion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `bitacora`
--

INSERT INTO `bitacora` (`id`, `cedula`, `nombre`, `fecha`, `hora`, `accion`) VALUES
(1, 29623776, 'ADMINISTRADOR', '2025-06-12', '10:33:09', 'Agrego un Nuevo Proveedor.'),
(2, 29623776, 'ADMINISTRADOR', '2025-06-12', '10:39:35', 'Agrego un Nuevo Cliente.'),
(3, 29623776, 'ADMINISTRADOR', '2025-06-12', '10:47:49', 'Agrego un Nuevo Cliente.'),
(4, 29623776, 'ADMINISTRADOR', '2025-06-12', '10:59:19', 'Registro una Entrada.'),
(5, 29623776, 'ADMINISTRADOR', '2025-06-12', '12:28:30', 'Agrego un Nuevo Proveedor.'),
(6, 29623776, 'ADMINISTRADOR', '2025-06-12', '12:30:05', 'Agrego un Nuevo Producto.'),
(7, 29623776, 'ADMINISTRADOR', '2025-06-12', '12:32:13', 'Agrego un Nuevo Proveedor.'),
(8, 29623776, 'ADMINISTRADOR', '2025-06-12', '12:52:02', 'Registro una Entrada.'),
(9, 29623776, 'ADMINISTRADOR', '2025-06-12', '12:55:16', 'Registro una Entrada.'),
(10, 29623776, 'ADMINISTRADOR', '2025-06-12', '13:08:37', 'Registro una Salida.'),
(11, 29623776, 'ADMINISTRADOR', '2025-06-12', '13:12:47', 'Registro una Entrada.'),
(12, 29623776, 'ADMINISTRADOR', '2025-06-12', '13:19:04', 'Registro una Salida.'),
(13, 29623776, 'ADMINISTRADOR', '2025-06-12', '13:19:43', 'Registro una Entrada.'),
(14, 31189176, 'Usuario de Prubea', '2025-06-12', '18:05:00', 'Agrego un Nuevo Proveedor.'),
(15, 31189176, 'Usuario de Prubea', '2025-06-12', '18:05:23', 'Agrego un Nuevo Proveedor.'),
(16, 29623776, 'Gabriel', '2025-06-13', '11:19:46', 'Agrego un Nuevo Proveedor.'),
(17, 29623776, 'Gabriel', '2025-06-13', '11:25:39', 'Registro una Salida.'),
(18, 29623776, 'Gabriel', '2025-06-13', '11:26:19', 'Registro una Salida.'),
(19, 11585514, 'maria', '2025-06-13', '11:30:33', 'Registro una Salida.'),
(20, 30485111, 'Francisco', '2025-06-14', '10:00:14', 'Registro una Entrada.'),
(21, 30485111, 'Francisco', '2025-06-16', '10:02:07', 'Registro una Salida.'),
(22, 30485111, 'Francisco', '2025-06-17', '15:16:58', 'Registro una Entrada.'),
(23, 30485111, 'Francisco', '2025-06-17', '16:14:23', 'Registro una Entrada.'),
(24, 30485111, 'Francisco', '2025-06-17', '16:14:55', 'Registro una Salida.'),
(25, 30485111, 'Francisco', '2025-06-17', '16:19:00', 'Registro una Salida.'),
(26, 30485111, 'Francisco', '2025-06-17', '16:19:16', 'Registro una Entrada.'),
(27, 29623776, 'Gabriel', '2025-06-19', '09:16:50', 'Registro una Salida.'),
(28, 29623776, 'Gabriel', '2025-06-19', '14:27:11', 'Registro una Entrada.'),
(29, 29623776, 'Gabriel', '2025-06-19', '14:28:12', 'Registro una Salida.'),
(30, 30485111, 'Francisco', '2025-06-22', '23:35:20', 'Agrego un Nuevo Producto.'),
(31, 30485111, 'Francisco', '2025-06-22', '23:44:37', 'Registro una Entrada.'),
(32, 30485111, 'Francisco', '2025-06-22', '23:47:06', 'Registro una Entrada.'),
(33, 30485111, 'Francisco', '2025-06-22', '23:47:30', 'Registro una Entrada.'),
(34, 30485111, 'Francisco', '2025-06-22', '23:48:45', 'Agrego un Nuevo Cliente.'),
(35, 30485111, 'Francisco', '2025-06-22', '23:48:58', 'Registro una Salida.'),
(36, 30485111, 'Francisco', '2025-06-22', '23:50:44', 'Registro una Salida.'),
(37, 30485111, 'Francisco', '2025-06-24', '00:33:52', 'Registro una Salida.'),
(38, 30485111, 'Francisco', '2025-06-24', '00:42:24', 'Registro una Salida.'),
(39, 30485111, 'Francisco', '2025-06-24', '01:57:15', 'Registro una Salida.'),
(40, 29623776, 'Gabriel', '2025-06-25', '15:45:05', 'Registro una Entrada.'),
(41, 29623776, 'Gabriel', '2025-06-25', '15:47:02', 'Registro una Salida.'),
(42, 30485111, 'Francisco', '2025-06-25', '16:26:23', 'Registro una Entrada.'),
(43, 30485111, 'Francisco', '2025-06-26', '10:17:37', 'Registro una Entrada.'),
(44, 30485111, 'Francisco', '2025-06-26', '10:19:09', 'Registro una Salida.'),
(45, 30485111, 'Francisco', '2025-06-26', '10:23:41', 'Agrego un Nuevo Producto.'),
(46, 30485111, 'Francisco', '2025-06-26', '15:48:00', 'Registro una Entrada.'),
(47, 30485111, 'Francisco', '2025-06-26', '15:48:43', 'Registro una Salida.'),
(48, 30485111, 'Francisco', '2025-06-27', '10:51:37', 'Registro una Entrada.'),
(49, 30485111, 'Francisco', '2025-06-27', '10:52:58', 'Registro una Entrada.'),
(50, 30485111, 'Francisco', '2025-06-27', '11:10:02', 'Registro una Entrada.'),
(51, 30485111, 'Francisco', '2025-06-27', '11:12:07', 'Registro una Entrada.'),
(52, 30485111, 'Francisco', '2025-06-27', '11:21:30', 'Registro una Entrada.'),
(53, 30485111, 'Francisco', '2025-06-27', '11:23:29', 'Registro una Entrada.'),
(54, 30485111, 'Francisco', '2025-06-27', '11:27:19', 'Registro una Entrada.'),
(55, 30485111, 'Francisco', '2025-06-27', '13:38:44', 'Registro una Entrada.'),
(56, 30485111, 'Francisco', '2025-06-27', '13:41:11', 'Registro una Entrada.'),
(57, 30485111, 'Francisco', '2025-06-27', '13:44:37', 'Registro una Entrada.'),
(58, 30485111, 'Francisco', '2025-06-27', '13:50:44', 'Registro una Entrada.'),
(59, 30485111, 'Francisco', '2025-06-28', '09:50:26', 'Agrego un Nuevo Producto.'),
(60, 30485111, 'Francisco', '2025-06-28', '10:49:46', 'Registro una Entrada.'),
(61, 30485111, 'Francisco', '2025-06-28', '10:52:10', 'Registro una Salida.'),
(62, 30485111, 'Francisco', '2025-06-28', '11:15:56', 'Agrego un Nuevo Cliente.'),
(63, 30485111, 'Francisco', '2025-06-28', '11:17:27', 'Registro una Entrada.'),
(64, 30485111, 'Francisco', '2025-06-28', '11:18:47', 'Registro una Entrada.'),
(65, 30485111, 'Francisco', '2025-06-28', '11:20:56', 'Registro una Entrada.'),
(66, 30485111, 'Francisco', '2025-06-28', '11:22:57', 'Registro una Salida.'),
(67, 30485111, 'Francisco', '2025-06-28', '11:26:37', 'Registro una Entrada.'),
(68, 30485111, 'Francisco', '2025-06-28', '11:26:53', 'Registro una Salida.'),
(69, 30485111, 'Francisco', '2025-06-28', '11:41:17', 'Registro una Entrada.'),
(70, 30485111, 'Francisco', '2025-06-28', '11:42:21', 'Registro una Salida.'),
(71, 30485111, 'Francisco', '2025-06-28', '11:48:55', 'Registro una Entrada.'),
(72, 30485111, 'Francisco', '2025-06-28', '11:49:06', 'Registro una Salida.'),
(73, 30485111, 'Francisco', '2025-06-28', '18:53:39', 'Registro una Salida.'),
(74, 30485111, 'Francisco', '2025-06-28', '19:00:40', 'Registro una Salida.'),
(75, 30485111, 'Francisco', '2025-06-28', '19:00:53', 'Registro una Entrada.'),
(76, 30485111, 'Francisco', '2025-06-30', '10:45:41', 'Agrego un Nuevo Producto.'),
(77, 30485111, 'Francisco', '2025-06-30', '10:46:04', 'Registro una Entrada.'),
(78, 30485111, 'Francisco', '2025-06-30', '16:15:43', 'Agrego un Nuevo Cliente.'),
(79, 30485111, 'Francisco', '2025-06-30', '16:17:27', 'Registro una Salida.'),
(80, 30485111, 'Francisco', '2025-07-01', '13:19:11', 'Agrego un Nuevo Proveedor.'),
(81, 30485111, 'Francisco', '2025-07-01', '13:20:46', 'Registro una Entrada.'),
(82, 30485111, 'Francisco', '2025-07-01', '13:23:01', 'Agrego un Nuevo Proveedor.'),
(83, 30485111, 'Francisco', '2025-07-01', '13:29:43', 'Registro una Entrada.'),
(84, 30485111, 'Francisco', '2025-07-01', '13:30:39', 'Registro una Salida.'),
(85, 30485111, 'Francisco', '2025-07-01', '13:31:55', 'Registro una Salida.'),
(86, 12021966, 'steven', '2025-07-01', '13:41:41', 'Registro una Salida.'),
(87, 30485111, 'Francisco', '2025-07-02', '21:08:40', 'Registro una Entrada.'),
(88, 30485111, 'Francisco', '2025-07-02', '21:14:05', 'Registro una Entrada.'),
(89, 30485111, 'Francisco', '2025-07-02', '21:14:55', 'Registro una Entrada.'),
(90, 30485111, 'Francisco', '2025-07-02', '21:24:35', 'Agrego un Nuevo Cliente.'),
(91, 30485111, 'Francisco', '2025-07-02', '21:25:05', 'Registro una Salida.'),
(92, 30485111, 'Francisco', '2025-07-02', '21:26:37', 'Registro una Salida.'),
(93, 30485111, 'Francisco', '2025-07-02', '21:28:29', 'Registro una Entrada.'),
(94, 30485111, 'Francisco', '2025-07-02', '21:28:58', 'Registro una Salida.'),
(95, 30485111, 'Francisco', '2025-07-03', '09:16:02', 'Registro una Entrada.'),
(96, 30485111, 'Francisco', '2025-07-03', '09:20:14', 'Registro una Salida.'),
(97, 30485111, 'Francisco', '2025-07-03', '09:27:01', 'Agrego un Nuevo Proveedor.'),
(98, 30485111, 'Francisco', '2025-07-03', '12:17:28', 'Registro una Entrada.'),
(99, 30485111, 'Francisco', '2025-07-03', '12:26:34', 'Registro una Entrada.'),
(100, 30485111, 'Francisco', '2025-07-09', '10:31:05', 'Registro una Salida.'),
(101, 30485111, 'Francisco', '2025-07-09', '11:02:22', 'Agrego un Nuevo Producto.'),
(102, 30485111, 'Francisco', '2025-07-09', '11:02:58', 'Agrego un Nuevo Cliente.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cab_factura`
--

CREATE TABLE `cab_factura` (
  `id` int(11) NOT NULL,
  `cedula` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(20) NOT NULL,
  `monto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cab_factura`
--

INSERT INTO `cab_factura` (`id`, `cedula`, `fecha`, `hora`, `monto`) VALUES
(147, 30485111, '2025-06-28', '11:48:53', 4.64),
(148, 30485111, '2025-06-28', '19:00:51', 104.4),
(149, 30485111, '2025-06-30', '10:46:02', 242.56),
(150, 12345678, '2025-07-01', '13:20:25', 13.456),
(151, 31221251, '2025-07-01', '13:29:41', 66.816),
(152, 30485111, '2025-07-02', '21:08:38', 14.036),
(153, 30485111, '2025-07-02', '21:14:02', 1.392),
(154, 30485111, '2025-07-02', '21:14:54', 1.392),
(155, 30485111, '2025-07-02', '21:28:28', 5.22),
(156, 30485111, '2025-07-03', '09:15:58', 67.86),
(157, 30485111, '2025-07-03', '12:17:26', 5.104),
(158, 30485111, '2025-07-03', '12:26:32', 4.872);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cab_salida`
--

CREATE TABLE `cab_salida` (
  `id` int(11) NOT NULL,
  `cedula` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(20) NOT NULL,
  `monto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cab_salida`
--

INSERT INTO `cab_salida` (`id`, `cedula`, `fecha`, `hora`, `monto`) VALUES
(71, 30485111, '2025-06-28', '11:49:05', 3.364),
(72, 30485111, '2025-06-28', '18:53:37', 107.184),
(73, 30485111, '2025-06-28', '19:00:38', 2.784),
(74, 31663778, '2025-06-30', '16:17:20', 15.428),
(75, 30485111, '2025-07-01', '13:30:37', 69.6),
(76, 30485111, '2025-07-01', '13:31:50', 55.68),
(77, 30485111, '2025-07-01', '13:41:36', 11.136),
(78, 30123123, '2025-07-02', '21:25:03', 12.76),
(79, 30123123, '2025-07-02', '21:26:35', 14.152),
(80, 30123123, '2025-07-02', '21:28:57', 15.312),
(81, 30123123, '2025-07-03', '09:20:12', 9.86),
(82, 30123123, '2025-07-09', '10:30:57', 11.6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cedula`, `nombre`, `telefono`, `direccion`) VALUES
(12585514, 'ana', '04123558745', 'ana@gmail.com'),
(18345678, 'Marcos Ortega', '0416-7788990', 'marcos@gmail.com'),
(18654321, 'Daniela Morales', '0412-1020304', 'daniela@gmail.com'),
(18903456, 'Sofía Villalobos', '0426-4455667', 'sofia@gmail.com'),
(19112233, 'Javier Figueroa', '0426-9900112', 'javier@gmail.com'),
(19543210, 'Gabriela Márquez', '0412-6677889', 'gabriela@gmail.com'),
(19876543, 'Antonio Rojas', '0414-3311224', 'antonio@gmail.com'),
(20001112, 'Carolina Torres', '0414-8899001', 'carolina@gmail.com'),
(20123456, 'Valeria Pinto', '0416-2211334', 'valeria@gmail.com'),
(20234567, 'Andrés Herrera', '0424-3141592', 'andres@gmail.com'),
(21234567, 'Diego Camacho', '0424-5566778', 'diego@gmail.com'),
(30123123, 'Jesus', '04120485533', 'j79224690@gmail.com'),
(30456456, 'ANA Maria', '04126843799', 'anamaria@gmail.com'),
(30485111, 'Jesus M', '04127257387', 'jesus@gmail.com'),
(31123123, 'ANA', '04247696422', 'ana2@gmail.com'),
(31663778, 'Yule', '04121310431', 'yule@gmail.com'),
(312212512, 'erik', '04123513789', 'erik@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_fac`
--

CREATE TABLE `detalle_fac` (
  `id` int(11) NOT NULL,
  `codigo_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `iva` float NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `detalle_fac`
--

INSERT INTO `detalle_fac` (`id`, `codigo_producto`, `nombre`, `precio`, `iva`, `cantidad`) VALUES
(147, 100004, 'Café Madrid Molido 500g', 4, 16, 1),
(148, 123457, 'Harina de Trigo', 90, 16, 1),
(149, 123457, 'Harina de Trigo', 90, 16, 2),
(149, 500500, 'Arroz', 12, 2, 2),
(149, 100004, 'Café Madrid Molido 500g', 4, 16, 2),
(150, 100001, 'Arroz Mary Kg', 1.2, 16, 3),
(150, 100004, 'Café Madrid Molido ', 4, 16, 2),
(151, 100001, 'Arroz Mary Kg', 1.2, 16, 48),
(152, 100001, 'Arroz Mary Kg', 1.2, 16, 1),
(152, 100004, 'Café Madrid Molido ', 4, 16, 2),
(152, 100005, 'Leche Completa Los Andes ', 2.9, 16, 1),
(153, 100001, 'Arroz Mary Kg', 1.2, 16, 1),
(154, 100001, 'Arroz Mary Kg', 1.2, 16, 1),
(155, 100007, 'Galletas Oreo pzs', 1.5, 16, 3),
(156, 100006, 'Azúcar Central Kg', 2, 16, 12),
(156, 100007, 'Galletas Oreo pzs', 1.5, 16, 23),
(157, 100006, 'Azúcar Central Kg', 2, 16, 1),
(157, 100008, 'Jabón Las Llaves ', 1.2, 16, 2),
(158, 100007, 'Galletas Oreo pzs', 1.5, 16, 1),
(158, 100009, 'Detergente Ace g', 2.7, 16, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_salida`
--

CREATE TABLE `detalle_salida` (
  `id` int(11) NOT NULL,
  `codigo_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `iva` float NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `detalle_salida`
--

INSERT INTO `detalle_salida` (`id`, `codigo_producto`, `nombre`, `precio`, `iva`, `cantidad`) VALUES
(71, 100005, 'Leche Completa Los Andes 1L', 2.9, 16, 1),
(72, 123457, 'Harina de Trigo', 90, 16, 1),
(72, 100001, 'Arroz Mary Kg', 1.2, 16, 2),
(73, 100001, 'Arroz Mary Kg', 1.2, 16, 2),
(74, 100001, 'Arroz Mary Kg', 1.2, 16, 2),
(74, 100004, 'Café Madrid Molido 500g', 4, 16, 2),
(74, 100005, 'Leche Completa Los Andes 1L', 2.9, 16, 1),
(75, 100001, 'Arroz Mary Kg', 1.2, 16, 50),
(76, 100001, 'Arroz Mary Kg', 1.2, 16, 40),
(77, 100001, 'Arroz Mary Kg', 1.2, 16, 8),
(78, 100001, 'Arroz Mary Kg', 1.2, 16, 1),
(78, 100005, 'Leche Completa Los Andes ', 2.9, 16, 2),
(78, 100006, 'Azúcar Central Kg', 2, 16, 2),
(79, 100001, 'Arroz Mary Kg', 1.2, 16, 2),
(79, 100005, 'Leche Completa Los Andes ', 2.9, 16, 2),
(79, 100006, 'Azúcar Central Kg', 2, 16, 2),
(80, 100005, 'Leche Completa Los Andes ', 2.9, 16, 3),
(80, 100007, 'Galletas Oreo pzs', 1.5, 16, 3),
(81, 100006, 'Azúcar Central Kg', 2, 16, 2),
(81, 100007, 'Galletas Oreo pzs', 1.5, 16, 3),
(82, 100006, 'Azúcar Central Kg', 2, 16, 2),
(82, 100007, 'Galletas Oreo pzs', 1.5, 16, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL,
  `iva` float NOT NULL,
  `min` int(11) NOT NULL,
  `max` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `nombre`, `precio`, `iva`, `min`, `max`, `cantidad`, `estado`) VALUES
(100001, 'Arroz Mary Kg', 1.2, 16, 10, 100, 2, 1),
(100002, 'Harina PAN Blanca ', 2.1, 16, 15, 120, 32, 0),
(100003, 'Aceite Diana L', 3.5, 16, 5, 60, 16, 0),
(100004, 'Café Madrid Molido ', 4, 16, 3, 30, 18, 1),
(100005, 'Leche Completa Los Andes ', 2.9, 16, 8, 90, 5, 1),
(100006, 'Azúcar Central Kg', 2, 16, 12, 80, 26, 1),
(100007, 'Galletas Oreo pzs', 1.5, 16, 6, 40, 26, 1),
(100008, 'Jabón Las Llaves ', 1.2, 16, 5, 45, 9, 1),
(100009, 'Detergente Ace g', 2.7, 16, 10, 70, 29, 1),
(100010, 'Papel Higiénico Scott ', 4.6, 16, 3, 20, 5, 1),
(100011, 'Sardinas Eveba ', 1.8, 16, 6, 50, 14, 1),
(100012, 'Crema Dental Colgate g', 2.5, 16, 4, 35, 11, 0),
(100099, 'Pepsi', 3, 16, 100, 1000, 1, 0),
(102030, 'aceite', 120, 16, 100, 500, 200, 1),
(102033, 'Crema', 10, 2, 10, 340, 22, 1),
(123456, 'Granos', 110, 16, 100, 1000, 9, 0),
(123457, 'Harina de Trigo', 90, 16, 100, 500, 12, 1),
(123789, 'PASTA DENTAL COLGT', 20, 2, 200, 500, 222, 1),
(303030, 'Azucar Past', 10, 12, 100, 220, 20, 1),
(404040, 'Papel', 2, 1, 222, 1111, 30, 1),
(444222, 'TRIGO', 1, 9, 10000, 200000, 2000, 1),
(500500, 'Arroz', 12, 2, 120, 10000, 4002, 1),
(555111, 'Pintura', 10, 2, 999000, 999999, 500, 1),
(606060, 'Cable USB', 4, 2, 100, 100000, 5000, 1),
(654321, 'Mani', 70, 16, 10, 10000, 0, 1),
(909090, 'Sal', 2, 10, 100, 120, 110, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`codigo`, `nombre`, `telefono`, `direccion`, `estado`) VALUES
(12345678, 'jose', '04163504565', 'jose@gmail.com', 1),
(16234567, 'Laura Navarro', '0424-1122334', 'laura@gmail.com', 1),
(16543123, 'José Romero', '0424-5656565', 'joser@gmail.com', 1),
(17234567, 'Ana Salas', '0426-4433221', 'anas@gmail.com', 1),
(17432109, 'Lucía Paredes', '0412-3434343', 'lucia@gmail.com', 1),
(18329876, 'Miguel Pérez', '0416-8787878', 'miguel@gmail.com', 0),
(18765432, 'Patricia Díaz', '0414-9898989', 'patricia@gmail.com', 0),
(18994512, 'Luis Páez', '0412-3344556', 'luis@gmail.com', 0),
(19234567, 'Raúl Sánchez', '0426-1212121', 'raul@gmail.com', 1),
(20345678, 'María González', '0416-7778899', 'maria@gmail.com', 1),
(21456321, 'Carlos Mendoza', '0414-1112233', 'carlos@gmail.com', 1),
(30321321, 'arturos', '04246538965', 'arturos@gmail.com', 1),
(30485111, 'Jesus M', '04120483988', 'gomeztorres0103@gmail.com', 1),
(31212802, 'Diosimar Moreno', '04129323389', 'diosi@gmail.com', 1),
(31221251, 'Ericks de moreno', '04124673767', 'erikcs@gmail.com', 1),
(31221252, 'erikc segundo', '04120122322', 'eriskc@gmail.com', 1),
(312212521, 'Ana', '04122334567', 'anam@gmail.com', 1),
(343434343, 'ana', '04163504565', 'ananter@gmail.com', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cedula` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tlfn` varchar(20) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `rol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `nombre`, `tlfn`, `clave`, `rol`) VALUES
(11585514, 'maria', '04245255028', '123456', 'user'),
(12021966, 'steven', '04163504565', '12345', 'user'),
(29623776, 'Gabriel', '04246385522', '12345', 'admin'),
(30123123, 'Jesus', '01231231231', 'jesus123', 'user'),
(30485111, 'Francisco', '04245037543', '12345', 'admin'),
(31189176, 'Jose', '04120483988', '12345', 'user');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cedula` (`cedula`);

--
-- Indices de la tabla `cab_factura`
--
ALTER TABLE `cab_factura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cedula_proveedor` (`cedula`);

--
-- Indices de la tabla `cab_salida`
--
ALTER TABLE `cab_salida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cedula_cliente` (`cedula`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `detalle_fac`
--
ALTER TABLE `detalle_fac`
  ADD KEY `fk_detalle_entrada_cabecera` (`id`),
  ADD KEY `fk_codigo_producto` (`codigo_producto`);

--
-- Indices de la tabla `detalle_salida`
--
ALTER TABLE `detalle_salida`
  ADD KEY `fk_detalle_salida_cabecera` (`id`),
  ADD KEY `fk_codigo_producto_salida` (`codigo_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bitacora`
--
ALTER TABLE `bitacora`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT de la tabla `cab_factura`
--
ALTER TABLE `cab_factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=159;

--
-- AUTO_INCREMENT de la tabla `cab_salida`
--
ALTER TABLE `cab_salida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bitacora`
--
ALTER TABLE `bitacora`
  ADD CONSTRAINT `bitacora_ibfk_1` FOREIGN KEY (`cedula`) REFERENCES `usuario` (`cedula`);

--
-- Filtros para la tabla `cab_factura`
--
ALTER TABLE `cab_factura`
  ADD CONSTRAINT `fk_cedula_proveedor` FOREIGN KEY (`cedula`) REFERENCES `proveedor` (`codigo`);

--
-- Filtros para la tabla `cab_salida`
--
ALTER TABLE `cab_salida`
  ADD CONSTRAINT `fk_cedula_cliente` FOREIGN KEY (`cedula`) REFERENCES `cliente` (`cedula`);

--
-- Filtros para la tabla `detalle_fac`
--
ALTER TABLE `detalle_fac`
  ADD CONSTRAINT `detalle_fac_ibfk_1` FOREIGN KEY (`id`) REFERENCES `cab_factura` (`id`),
  ADD CONSTRAINT `fk_codigo_producto` FOREIGN KEY (`codigo_producto`) REFERENCES `producto` (`codigo`),
  ADD CONSTRAINT `fk_detalle_entrada_cabecera` FOREIGN KEY (`id`) REFERENCES `cab_factura` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_salida`
--
ALTER TABLE `detalle_salida`
  ADD CONSTRAINT `detalle_salida_ibfk_1` FOREIGN KEY (`id`) REFERENCES `cab_salida` (`id`),
  ADD CONSTRAINT `fk_codigo_producto_salida` FOREIGN KEY (`codigo_producto`) REFERENCES `producto` (`codigo`),
  ADD CONSTRAINT `fk_detalle_salida_cabecera` FOREIGN KEY (`id`) REFERENCES `cab_salida` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
