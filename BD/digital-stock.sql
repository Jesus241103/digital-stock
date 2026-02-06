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
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cedula` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

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
