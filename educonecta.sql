-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2024 a las 19:02:06
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `educonecta`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amistades`
--

CREATE TABLE `amistades` (
  `amistad_id` varchar(60) NOT NULL,
  `usuario1_id` varchar(60) NOT NULL,
  `usuario2_id` varchar(60) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chats`
--

CREATE TABLE `chats` (
  `chat_id` varchar(60) NOT NULL,
  `user1_id` varchar(60) NOT NULL,
  `user2_id` varchar(60) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE `comentarios` (
  `comentario_id` varchar(60) NOT NULL,
  `post_id` varchar(60) NOT NULL,
  `usuario_id` varchar(60) NOT NULL,
  `contenido` varchar(500) NOT NULL,
  `comentarioParent_id` varchar(60) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

CREATE TABLE `grupos` (
  `grupo_id` varchar(60) NOT NULL,
  `nombreGrupo` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `imggrupo` blob NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `likes`
--

CREATE TABLE `likes` (
  `like_id` varchar(60) NOT NULL,
  `post_id` varchar(60) NOT NULL,
  `usuario_id` varchar(60) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensageschats`
--

CREATE TABLE `mensageschats` (
  `mensage_id` varchar(60) NOT NULL,
  `chat_id` varchar(60) NOT NULL,
  `enviadorUser_id` varchar(60) NOT NULL,
  `contenido` varchar(500) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembrosgrupo`
--

CREATE TABLE `miembrosgrupo` (
  `grupo_id` varchar(60) NOT NULL,
  `usuario_id` varchar(60) NOT NULL,
  `rol` enum('ADMIN','USER','','') NOT NULL,
  `joined_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificaciones`
--

CREATE TABLE `notificaciones` (
  `notificacion_id` varchar(60) NOT NULL,
  `usuario_id` varchar(60) NOT NULL,
  `tipo` enum('comentario','peticionAmistad','like','') NOT NULL,
  `referencia_id` varchar(60) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `vista` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peticionesamistad`
--

CREATE TABLE `peticionesamistad` (
  `peticion_id` varchar(60) NOT NULL,
  `enviadorUser_id` varchar(60) NOT NULL,
  `receptorUser_id` varchar(60) NOT NULL,
  `estado` enum('pendiente','aceptada','rechazada','cancelada') NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicaciones`
--

CREATE TABLE `publicaciones` (
  `post_id` varchar(60) NOT NULL,
  `usuario_id` varchar(60) NOT NULL,
  `contenido` varchar(500) NOT NULL,
  `tema_id` varchar(60) NOT NULL,
  `imgpost` blob NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temasacademicos`
--

CREATE TABLE `temasacademicos` (
  `tema_id` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `descripcion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temasinteresusuario`
--

CREATE TABLE `temasinteresusuario` (
  `usuario_id` varchar(60) NOT NULL,
  `tema_id` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario_id` varchar(50) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `contrasena` varchar(150) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `imgperfil` blob DEFAULT NULL,
  `biografia` varchar(500) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `amistades`
--
ALTER TABLE `amistades`
  ADD PRIMARY KEY (`amistad_id`),
  ADD KEY `usuario1_id` (`usuario1_id`),
  ADD KEY `usuario2_id` (`usuario2_id`);

--
-- Indices de la tabla `chats`
--
ALTER TABLE `chats`
  ADD PRIMARY KEY (`chat_id`),
  ADD KEY `user1_id` (`user1_id`),
  ADD KEY `user2_id` (`user2_id`);

--
-- Indices de la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`comentario_id`),
  ADD KEY `post_id` (`post_id`),
  ADD KEY `usuario_id` (`usuario_id`),
  ADD KEY `comentarioParent_id` (`comentarioParent_id`);

--
-- Indices de la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD PRIMARY KEY (`grupo_id`);

--
-- Indices de la tabla `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`like_id`),
  ADD KEY `post_id` (`post_id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `mensageschats`
--
ALTER TABLE `mensageschats`
  ADD PRIMARY KEY (`mensage_id`),
  ADD KEY `chat_id` (`chat_id`),
  ADD KEY `enviadorUser_id` (`enviadorUser_id`);

--
-- Indices de la tabla `miembrosgrupo`
--
ALTER TABLE `miembrosgrupo`
  ADD KEY `grupo_id` (`grupo_id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD PRIMARY KEY (`notificacion_id`),
  ADD KEY `usuario_id` (`usuario_id`);

--
-- Indices de la tabla `peticionesamistad`
--
ALTER TABLE `peticionesamistad`
  ADD PRIMARY KEY (`peticion_id`),
  ADD KEY `enviadorUser_id` (`enviadorUser_id`),
  ADD KEY `receptorUser_id` (`receptorUser_id`);

--
-- Indices de la tabla `publicaciones`
--
ALTER TABLE `publicaciones`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `usuario_id` (`usuario_id`),
  ADD KEY `tema_id` (`tema_id`);

--
-- Indices de la tabla `temasacademicos`
--
ALTER TABLE `temasacademicos`
  ADD PRIMARY KEY (`tema_id`);

--
-- Indices de la tabla `temasinteresusuario`
--
ALTER TABLE `temasinteresusuario`
  ADD PRIMARY KEY (`usuario_id`,`tema_id`),
  ADD KEY `tema_id` (`tema_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario_id`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `amistades`
--
ALTER TABLE `amistades`
  ADD CONSTRAINT `amistades_ibfk_1` FOREIGN KEY (`usuario1_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `amistades_ibfk_2` FOREIGN KEY (`usuario2_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `chats`
--
ALTER TABLE `chats`
  ADD CONSTRAINT `chats_ibfk_1` FOREIGN KEY (`chat_id`) REFERENCES `mensageschats` (`chat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chats_ibfk_2` FOREIGN KEY (`user1_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `chats_ibfk_3` FOREIGN KEY (`user2_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comentarios_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `publicaciones` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `comentarios_ibfk_3` FOREIGN KEY (`comentario_id`) REFERENCES `comentarios` (`comentarioParent_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `likes`
--
ALTER TABLE `likes`
  ADD CONSTRAINT `likes_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `likes_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `publicaciones` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensageschats`
--
ALTER TABLE `mensageschats`
  ADD CONSTRAINT `mensageschats_ibfk_1` FOREIGN KEY (`enviadorUser_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `miembrosgrupo`
--
ALTER TABLE `miembrosgrupo`
  ADD CONSTRAINT `miembrosgrupo_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `miembrosgrupo_ibfk_2` FOREIGN KEY (`grupo_id`) REFERENCES `grupos` (`grupo_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD CONSTRAINT `notificaciones_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `peticionesamistad`
--
ALTER TABLE `peticionesamistad`
  ADD CONSTRAINT `peticionesamistad_ibfk_1` FOREIGN KEY (`enviadorUser_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `peticionesamistad_ibfk_2` FOREIGN KEY (`receptorUser_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `publicaciones`
--
ALTER TABLE `publicaciones`
  ADD CONSTRAINT `publicaciones_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `publicaciones_ibfk_2` FOREIGN KEY (`tema_id`) REFERENCES `temasacademicos` (`tema_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `temasinteresusuario`
--
ALTER TABLE `temasinteresusuario`
  ADD CONSTRAINT `temasinteresusuario_ibfk_1` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `temasinteresusuario_ibfk_2` FOREIGN KEY (`tema_id`) REFERENCES `temasacademicos` (`tema_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
