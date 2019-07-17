-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le: Ven 19 Décembre 2014 à 17:14
-- Version du serveur: 5.5.32
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `lddt_db`
--
CREATE DATABASE IF NOT EXISTS `lddt_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `lddt_db`;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `category`
--

INSERT INTO `category` (`id`, `name`, `is_active`) VALUES
(1, 'sport', 1),
(2, 'humour', 1),
(3, 'voyage', 1),
(4, 'insolite', 1);

-- --------------------------------------------------------

--
-- Structure de la table `color`
--

CREATE TABLE IF NOT EXISTS `color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Contenu de la table `color`
--

INSERT INTO `color` (`id`, `name`, `code`) VALUES
(1, 'rouge', '#D81F1A'),
(2, 'jaune', '#F5F215'),
(3, 'vert', '#1AD826');

-- --------------------------------------------------------

--
-- Structure de la table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `draw_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_5BC96BF06FC5C1B8` (`draw_id`),
  KEY `IDX_5BC96BF0A76ED395` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Contenu de la table `comment`
--

INSERT INTO `comment` (`id`, `content`, `created_at`, `draw_id`, `user_id`) VALUES
(8, 'test', '2014-12-19 16:56:34', 23, 4);

-- --------------------------------------------------------

--
-- Structure de la table `draw`
--

CREATE TABLE IF NOT EXISTS `draw` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `draw_path` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `is_online` tinyint(1) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_D0C01231E6ADA943` (`cat_id`),
  KEY `IDX_D0C01231A76ED395` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=24 ;

--
-- Contenu de la table `draw`
--

INSERT INTO `draw` (`id`, `title`, `draw_path`, `is_online`, `created_at`, `updated_at`, `cat_id`, `user_id`) VALUES
(22, '<x', 'ef2568c6fec099b5723553a617c28392bcd854b1.jpeg', 1, '2014-12-19 16:36:35', '2014-12-19 16:36:35', 2, 3),
(23, 'fred', '56aef8a5dc1f7fe8e8dc149ecaca14f0b4ca2ecc.jpeg', 1, '2014-12-19 16:49:10', '2014-12-19 16:49:10', 2, 4);

-- --------------------------------------------------------

--
-- Structure de la table `draw_color`
--

CREATE TABLE IF NOT EXISTS `draw_color` (
  `draw_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  PRIMARY KEY (`draw_id`,`color_id`),
  KEY `IDX_8DF16C796FC5C1B8` (`draw_id`),
  KEY `IDX_8DF16C797ADA1FB5` (`color_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `draw_color`
--

INSERT INTO `draw_color` (`draw_id`, `color_id`) VALUES
(22, 2),
(23, 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `locked` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  `confirmation_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `credentials_expired` tinyint(1) NOT NULL,
  `credentials_expire_at` datetime DEFAULT NULL,
  `avatar_path` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_2DA1797792FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_2DA17977A0D96FBF` (`email_canonical`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `locked`, `expired`, `expires_at`, `confirmation_token`, `password_requested_at`, `roles`, `credentials_expired`, `credentials_expire_at`, `avatar_path`) VALUES
(1, 'moi', 'moi', 'm.de.ubeda@gmail.com', 'm.de.ubeda@gmail.com', 1, 'smxacfqs5xwsoso808w0s884g408w80', 'oIwJYnEvLSLKsluEx8htKLuRivHjkvwH/2wcDLbN97xbaQtQ0MuebQGzKglO6DYy8E/vwa2OPopKz6QLml7JsQ==', '2014-12-19 13:04:27', 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL),
(2, 'admin', 'admin', 'admin@toto.com', 'admin@toto.com', 1, '6h9w08rskj4sw80o4kss8oc80ogo4kc', 'pphTE1Afnzja5ATGcVFW9MklwvMW5xvkYivFzhYU7E/MpE3ZgCBl9t2ENvFjSxr2cgyMZc9Dr+ySSelRYYA6oA==', '2014-12-19 12:02:16', 0, 0, NULL, NULL, NULL, 'a:1:{i:0;s:16:"ROLE_SUPER_ADMIN";}', 0, NULL, NULL),
(3, 'bibi', 'bibi', 'bibi@gmail.com', 'bibi@gmail.com', 1, 'dwzmh5116lw884co00k4gw44kkkskcs', 'FaXYUvoPNfh2ZpOJg8vipWSoVXZ+VoQOXq/d2SXsO2QIL0LlBR3cYxdDfVj/quo/8LhfMiyGTLg73WVTp7amYg==', '2014-12-19 17:11:22', 0, 0, NULL, NULL, NULL, 'a:2:{i:0;s:5:"ADMIN";i:1;s:10:"ROLE_ADMIN";}', 0, NULL, '2d423b2f9d31ad080366e683f0b8be2ca7bdfcb6.jpeg'),
(4, 'charlie2000', 'charlie2000', 'charlie2000@toto.com', 'charlie2000@toto.com', 1, 's6i1l6ngxog0ckckoco44so8sg08ow4', 'M8r/lJWOZeuPEk5enbboDkhRW7cDHiNPK+s6y4EnV01L4mK2WRCoHrAfmgYV2wczvZDD6seKBhDrtOXvUIDoXQ==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL, '5d9c68c0dcbc1f573046d0af64adda79c893b890.jpeg');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK_5BC96BF06FC5C1B8` FOREIGN KEY (`draw_id`) REFERENCES `draw` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_5BC96BF0A76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `draw`
--
ALTER TABLE `draw`
  ADD CONSTRAINT `FK_D0C01231A76ED395` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_D0C01231E6ADA943` FOREIGN KEY (`cat_id`) REFERENCES `category` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `draw_color`
--
ALTER TABLE `draw_color`
  ADD CONSTRAINT `FK_8DF16C796FC5C1B8` FOREIGN KEY (`draw_id`) REFERENCES `draw` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_8DF16C797ADA1FB5` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
