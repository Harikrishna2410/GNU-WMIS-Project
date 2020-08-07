-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 13, 2019 at 03:55 PM
-- Server version: 5.7.26
-- PHP Version: 7.0.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wmis`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `contact_person_name` varchar(100) NOT NULL,
  `phone_no` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `zip` int(6) NOT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'active',
  `role` varchar(50) NOT NULL DEFAULT 'super',
  `remember_token` varchar(100) DEFAULT NULL,
  `package_id` int(11) DEFAULT NULL,
  `created_by` int(10) UNSIGNED DEFAULT NULL,
  `updated_by` int(10) UNSIGNED DEFAULT NULL,
  `renewed_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  KEY `package_id` (`package_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `company_name`, `email`, `email_verified_at`, `password`, `contact_person_name`, `phone_no`, `address`, `city`, `state`, `zip`, `status`, `role`, `remember_token`, `package_id`, `created_by`, `updated_by`, `renewed_at`, `created_at`, `expires_at`, `updated_at`, `deleted_at`) VALUES
(5, 'Balaji Masala Wafers Pvt. Ltd.', 'aashishgnubca@gmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Prakash Patel', '8322831917', 'Ratnadeep complex ,Sarvodaya NAgar Part-1', 'Ahmedabad', 'Gujarat', 380061, 'active', 'super', '0G3YX645iLfRYsxsFFCn7YTl8iJFsTCB3Q2H989jpquwIghoixkS3HiQiOlO', 1, 1, 1, '2019-04-02 06:04:12', '2019-01-02 03:16:23', '2020-09-16 06:04:12', '2019-10-28 14:02:52', NULL),
(7, 'Coca Cola Pvt Ltd', 'pathakaashish007@gmail.com', NULL, '$2y$10$P5oEt3y/TCQSGqwa/4Sy0uwKWw.PMJ1Ld6saDGZGkvGE6VNhHB51S', 'Aashish.K.P', '9900887766', 'Ratnadeep complex ,Sarvodaya NAgar Part-1', 'Ahmedabad', 'Gujarat', 380061, 'inactive', 'super', 'HrSBxErG5NxW58ZWYNwafk9dIBGyGktdF34CQ6xHNCJ8a9VAGAvSV933guF8', 2, 1, 1, NULL, '2019-01-18 04:34:31', '2019-04-18 04:34:30', '2019-01-18 04:34:31', NULL),
(8, 'A TO Z PHARMACEUTICALS', 'aashishgnubca2@gmail.com', NULL, '$2y$10$LV4j697ijx7uDq5St2P60eeqqTcoRjPce7THbxUrOebW5ZrXGWSLO', 'Ramesh Bhai Patel', '8849606266', 'b-7 Ratnadeep Complex Sarvodaya Nagar Part 1', 'Ahmedabad', 'Gujarat', 380061, 'active', 'super', 'TuXO8qUgIAUjNZZGZ5PwK3aPMqEoEM5HiCMywj92IwW98lsNZl1V6nXJkl6F', 5, NULL, NULL, NULL, '2019-03-03 08:32:50', '2020-03-02 08:32:50', '2019-03-03 08:32:50', NULL),
(9, 'Leffler LLC', 'layne.beahan@cummerata.info', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Alejandrin Mraz I', 'Goldner, Wisozk and Dibbert', '969 Nitzsche Cliffs Suite 577', 'Herminiafort', 'New Hampshire', 5706, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-21 12:23:31', NULL),
(10, 'Berge-Krajcik', 'xokon@champlin.net', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Derick Barrows', 'Legros, Denesik and Wolf', '3920 Lesch Islands Apt. 127', 'Wolfton', 'Alaska', 80405, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-21 12:15:55', NULL),
(11, 'Hansen-Cormier', 'fern.schoen@hotmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Nickolas Kertzmann', 'Labadie-Raynor', '87849 Homenick Throughway', 'Emieburgh', 'Kansas', 79954, 'inactive', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-21 12:19:40', NULL),
(12, 'Corkery Ltd', 'gage.casper@marks.info', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Dr. Leonel O\'Keefe MD', 'Purdy-Shields', '6478 Erna Dam', 'West Briana', 'Florida', 90905, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(13, 'Davis, Simonis and Goodwin', 'karli.hermiston@cronin.org', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Cedrick Armstrong', 'Grant, Rogahn and Mohr', '5180 Kunze Skyway Apt. 273', 'Hahnfurt', 'South Carolina', 13304, 'inactive', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-21 13:26:12', NULL),
(14, 'Turcotte-Lowe', 'hill.gino@hotmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Mrs. Roxanne Lemke Jr.', 'Durgan-Mills', '17640 Bechtelar Cliffs', 'New Javonte', 'Louisiana', 62331, 'inactive', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-21 13:26:15', NULL),
(15, 'Williamson, Ryan and Macejkovic', 'tom90@yahoo.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Andreane Wunsch', 'Hermann-Heathcote', '979 McClure Terrace', 'West Blairmouth', 'Nebraska', 23121, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(16, 'Gorczany-Waters', 'berge.jay@hermann.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Immanuel Ratke', 'Bartoletti-Reichel', '44290 Beulah Circle', 'Lednerhaven', 'Nevada', 73811, 'inactive', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-21 13:26:17', NULL),
(17, 'Corwin PLC', 'zjaskolski@hotmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Prof. Tessie Berge MD', 'Smitham-Muller', '8529 Ankunding Fall', 'Raumouth', 'Wisconsin', 82128, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(18, 'Larkin-Marvin', 'fmcdermott@gmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Mrs. Jena Mraz Sr.', 'Koelpin-Davis', '2004 Hudson Harbor', 'Montanafurt', 'Utah', 13342, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(19, 'Nolan, Waelchi and Friesen', 'kertzmann.celestino@gmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Kennedy Stamm Jr.', 'Barton-Schaefer', '833 Blick Brook Suite 021', 'East Stefanfurt', 'North Carolina', 1353, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(20, 'Dare-Satterfield', 'shawna.mraz@russel.biz', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Onie Heathcote', 'Johns-Effertz', '64438 Welch Courts', 'Flossieland', 'Idaho', 26539, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(21, 'Rodriguez, Gorczany and Hammes', 'ettie02@hotmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Merl Flatley', 'Hyatt Inc', '783 Zoila Street Suite 950', 'Lake Lance', 'South Dakota', 13675, 'inactive', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-21 13:26:19', NULL),
(22, 'Ratke PLC', 'rath.luis@gmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Mr. Misael O\'Kon', 'Gusikowski PLC', '23397 Vivianne Place', 'East Devon', 'Montana', 82217, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(23, 'Brakus-Abshire', 'xschmidt@ebert.info', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Jacklyn Kemmer I', 'Stiedemann-Schmeler', '1492 Naomie Junctions', 'Lake Junius', 'Virginia', 92373, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(24, 'Mosciski-Crist', 'tianna.heathcote@hotmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Lucy Kertzmann PhD', 'Heller, Torp and King', '895 Rempel Isle Suite 633', 'Janaechester', 'Colorado', 62562, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(25, 'Klein, Graham and Huels', 'mueller.norwood@morar.info', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Mohamed Cormier', 'Bogisich Group', '180 Mozelle Forge', 'Goldatown', 'Missouri', 44413, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(26, 'Walker, Kshlerin and Little', 'bruen.shany@reichel.org', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Deonte Cremin', 'Stroman, Lynch and Okuneva', '986 Ryan Garden', 'Lake Kayceechester', 'Wisconsin', 76148, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(27, 'VonRueden Group', 'wzulauf@hartmann.biz', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Joan Torp PhD', 'Schoen Ltd', '976 Lueilwitz Dam', 'West Adrien', 'District of Columbia', 70140, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(28, 'Welch PLC', 'autumn58@hotmail.com', NULL, '$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm', 'Dr. Pete Lesch', 'Kuphal-Kilback', '1438 Dimitri Shoal', 'Littelhaven', 'California', 87961, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-03-14 14:38:10', NULL, '2019-03-14 14:38:10', NULL),
(31, 'Mayur', 'sankaliyamayur398@gmail.com', NULL, '$2y$10$zwOJz3.1hijfBtsSFEyPQuMg8qjGY7cQr/2QUr.rcZnzucbqr1yt.', 'Mayur', '9999999999', 'jhgujg', 'jhjh', 'jhgjh', 9898, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-04-11 07:39:01', '2019-04-18 07:39:00', '2019-04-11 07:39:01', NULL),
(32, 'Samrat INC.', 'jatinnayak1999@gmail.com', NULL, '$2y$10$qFy1ksNNwgx67PECvCbbBee0AowjRr0sk//JbX07Jv8C6G73iEiZ.', 'JATIN', '9988990088', 'JATIN\'s ADDRESS', 'Ahmedabad', 'Gujarat', 380061, 'active', 'super', NULL, 1, NULL, NULL, NULL, '2019-04-11 07:48:25', '2019-04-18 07:48:25', '2019-04-11 07:48:25', NULL),
(33, 'Malboro new', 'aashishgnuadbdsa78@gmail.com56', NULL, '$2y$10$xCsQDe/1SEcmVUdzm1owduIw6f9QQOznjq0JprTp6V6FI5FMHUSEy', 'JATIN', '9988990088', 'JATIN\'s ADDRESS', 'Ahmedabad', 'Gujarat', 380061, 'active', 'super', NULL, 4, NULL, NULL, '2019-04-11 08:43:20', '2019-04-11 08:42:33', '2020-04-10 08:43:20', '2019-04-11 08:43:20', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `client_devices_lisences`
--

DROP TABLE IF EXISTS `client_devices_lisences`;
CREATE TABLE IF NOT EXISTS `client_devices_lisences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `sales_rep_id` int(11) NOT NULL,
  `imei` varchar(15) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`,`sales_rep_id`)
) ENGINE=MyISAM AUTO_INCREMENT=211 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `tax_rule_id` int(10) UNSIGNED DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `contact_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` text NOT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `postcode` int(50) NOT NULL,
  `contact_no` varchar(50) DEFAULT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'active',
  `is_product_tax` tinyint(1) DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `tax_rule_id` (`tax_rule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `client_id`, `tax_rule_id`, `name`, `contact_name`, `email`, `address`, `city`, `state`, `postcode`, `contact_no`, `status`, `is_product_tax`, `created_at`, `updated_at`, `deleted_at`) VALUES
(3, 5, 5, 'Ashok Pan PArlour', 'aashish', 'ashokpanparlour@gmail.comhkgjk', 'opp. kargil petrol pump', 'Ahmedabad', 'Gujarat', 380061, '8976556690', 'active', 0, '2018-12-21 02:39:32', '2019-03-01 03:38:40', NULL),
(4, 5, 3, 'Shivam Dairy', 'ketan', 'shivamdairy@gmail.com', 'Gulab Tower', 'Ahmedabad', 'Gujarat', 380061, '8977896500', 'active', 1, '2018-12-21 02:39:32', '2019-02-09 02:58:22', NULL),
(5, 5, 2, 'Gulab Pan PArlour', 'hk', 'gulabpanparlour@gmail.com', 'pakwan cross road', 'Ahmedabad', 'Gujarat', 380061, '8976556690', 'active', 0, '2018-12-21 02:39:32', '2018-12-21 02:39:32', NULL),
(6, 5, 4, 'Khodiyar Dairy', 'kaushal', 'khodiyardairy@gmail.com', 'Gulab Tower', 'Ahmedabad', 'Gujarat', 380061, '8977896500', 'active', 0, '2018-12-21 02:39:32', '2019-03-05 15:31:40', NULL),
(12, 5, 5, 'Nirmal Traders', 'jatin', 'nirmaltrader@gmail.com', 'sola', 'Ahmedabad', 'Gujarat', 380061, '9988776655', 'active', 1, '2019-01-04 06:16:54', '2019-03-05 15:31:54', NULL),
(18, 5, 6, 'sager Wholesale pvt ltd', 'abhishek', 'sagarwholesale@gmail.com', 'xyz address', 'Ahmedabad', 'Gujarat', 380061, '9988776655', 'active', 1, '2019-02-02 04:33:53', '2019-02-09 02:58:27', NULL),
(19, 5, 3, 'Rajaram Kirana', 'mayur', 'pathakaashish539@gmail.com', 'sattadhar char rasta', 'Ahmedabad', 'Gujarat', 380061, '9900998877', 'active', 1, '2019-02-04 06:29:41', '2019-02-09 02:57:16', NULL),
(68, 8, 11, 'Savaram Chemist', 'Kalin Bhayia', 'savaram@gmail.com', 'sola', 'Ahmedabad', 'Gujarat', 380061, '9988776655', 'active', 1, '2019-03-03 08:37:33', '2019-03-03 08:42:09', NULL),
(69, 8, 9, 'Akshar Medical Store', 'Bunty', 'Akshar@gmail.com', 'Sattadhar', 'Ahmedabad', 'Gujarat', 380061, '8877665509', 'active', 1, '2019-03-03 08:43:12', '2019-03-03 08:46:38', NULL),
(70, 8, 8, 'Suvidha Medical Stores', 'Ganesh Gaitonde', 'Suvidha@gmail.com', 'Science City', 'Ahmedabad', 'Gujarat', 380061, '99008877666', 'active', 1, '2019-03-03 08:44:12', '2019-03-03 08:46:26', NULL),
(71, 8, 7, 'Arihant Medical Stores', 'Issa', 'Arihant@gmail.com', 'L.L/9, Manorath Complex', 'Ahmedabad', 'Gujarat', 380061, '8899776655', 'active', 1, '2019-03-03 08:45:26', '2019-03-03 08:54:00', NULL),
(72, 8, 7, 'MEDCHOICE PHARMACY', 'KuKu', 'Medchoice@gmail.com', '18, Agrawal Tower,', 'Ahmedabad', 'Gujarat', 380061, '8877665598', 'active', 1, '2019-03-03 08:52:57', '2019-03-05 11:54:53', NULL),
(73, 5, 1, 'EFG Wholesale', 'ketan', 'keith212005@gmail.com', '1300 xzy st', 'Ahmedabad', 'GJ', 380061, '7774653256', 'active', 0, '2019-03-05 20:58:29', '2019-11-05 18:19:27', '2019-11-05 18:19:27'),
(74, 5, 6, 'Nirmal traders', 'Aashish Pathak', 'restaurantbillingsystem@gmail.com', 'Shri Dongre Maharaj Marg 2', 'Ahmedabad', 'Gujarat', 380061, '+17600978483', 'active', 0, '2019-03-06 02:04:28', '2019-03-13 09:46:58', NULL),
(95, 8, 5, 'Muller, Feest and Bruen', 'Miss Leta Jast', 'korbin47@hartmann.net', '7004 Frances Ford', 'Port Tryciaview', 'North Carolina', 61443, '1-219-465-8829 x83413', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(96, 8, 4, 'Metz Inc', 'Madaline Ward', 'shawna.champlin@kuphal.com', '18233 Edyth Freeway Apt. 831', 'Windlerton', 'Arkansas', 73743, '(640) 500-2832 x205', 'active', 1, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(97, 5, 1, 'Reynolds-Conroy', 'Sam Skiles', 'myrtle45@gmail.com', '417 Tobin Glen Suite 622', 'Gildahaven', 'Nevada', 5366, '+1.876.682.6124', 'active', 1, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(98, 5, 1, 'Mertz PLC', 'Rodolfo Pacocha', 'lorine.daniel@yahoo.com', '7282 Thompson Trail Apt. 995', 'Marilouland', 'District of Columbia', 45212, '+1-729-889-0559', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(99, 5, 4, 'Champlin, Ledner and Sanford', 'Miss Adeline Waelchi I', 'dbotsford@berge.net', '30877 Monroe Run', 'Sauermouth', 'Delaware', 46316, '(659) 401-5049', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(100, 5, 2, 'Hirthe, Tillman and Smitham', 'Raegan Corwin V', 'darrick43@ledner.org', '6407 Wolf Mill', 'South Laneville', 'Minnesota', 90634, '+1.275.242.9031', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(101, 8, 3, 'Jacobson-Kassulke', 'Dr. Darrin Haley', 'moore.warren@gmail.com', '5790 O\'Hara Ports', 'South Aminachester', 'Colorado', 11467, '1-429-233-4448 x9813', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(102, 5, 3, 'Dooley Ltd', 'Clarabelle Mraz', 'tracy29@auer.com', '90657 Hoppe Points', 'Lefflerland', 'Alaska', 16872, '1-994-665-0345', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(103, 5, 2, 'Zboncak and Sons', 'Urban Sipes', 'vena.pagac@gmail.com', '310 William Keys Suite 913', 'Corwinborough', 'Ohio', 82046, '1-938-231-4075 x58292', 'active', 1, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(104, 5, 1, 'Homenick PLC', 'Prof. Aniyah Buckridge III', 'xlueilwitz@hotmail.com', '632 O\'Keefe Stravenue', 'South Jamie', 'Missouri', 32194, '372.635.2420', 'active', 1, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(105, 5, 3, 'Fadel, Bashirian and Goldner', 'Miss Audie Wuckert Jr.', 'jacklyn61@considine.com', '570 Huel Wells', 'North Electa', 'Montana', 8527, '880.590.9106 x5657', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(106, 5, 1, 'Hand-Fadel', 'Leonardo Kertzmann', 'derek.nader@franecki.com', '5807 Kris Vista Apt. 302', 'Port Renehaven', 'Virginia', 20369, '1-869-583-1686', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(107, 8, 3, 'Hill and Sons', 'Faustino McKenzie', 'marlon21@bartoletti.com', '1164 Greenfelder Road', 'O\'Konburgh', 'Utah', 36667, '220.753.0249 x5189', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(108, 5, 2, 'Koepp, Bechtelar and Schultz', 'Dr. Dorothy Bernier I', 'gloria.swaniawski@brakus.biz', '1425 Goldner Drive', 'Lennastad', 'South Dakota', 49875, '+13902201306', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(109, 5, 1, 'Becker Ltd', 'Hellen Jacobi', 'lynch.madge@kuhlman.com', '74943 Morissette Hills Apt. 414', 'Kreigershire', 'Florida', 29737, '+1 (208) 430-2818', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(110, 5, 1, 'Gorczany, Kling and Klocko', 'Dr. Clay Rutherford Jr.', 'pklein@treutel.com', '19968 Aufderhar Center Suite 424', 'West Bertaburgh', 'Montana', 86034, '1-542-445-6407 x3185', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(111, 5, 6, 'Kunde and Sons', 'Celestine Stiedemann III', 'agnes67@tillman.com', '945 Katelyn Knoll', 'East Anafurt', 'Georgia', 13552, '539-954-0627', 'active', 1, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(112, 5, 6, 'Renner-Konopelski', 'Prof. Luz Quigley IV', 'btowne@gmail.com', '989 Isaac Field', 'Napoleonmouth', 'Alaska', 98361, '1-251-232-8546 x1576', 'active', 1, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(113, 5, 4, 'Green, Cronin and Shanahan', 'Gretchen Romaguera', 'kutch.lilyan@yahoo.com', '41463 Carlie River Suite 885', 'South Sheridan', 'South Carolina', 4785, '1-505-889-1709', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(114, 5, 3, 'Lockman-Waelchi', 'Miss Aubrey Douglas', 'jade.effertz@yahoo.com', '5638 Volkman Neck', 'Berneicehaven', 'Missouri', 72898, '(987) 729-5593 x66444', 'active', 0, '2019-03-14 14:55:08', '2019-03-14 14:55:08', NULL),
(117, 5, 1, 'kj', 'kj', 'keith212005@gmail.com', 'kj', 'kjkj', 'kj', 88, '88', 'active', 1, '2019-10-23 20:32:12', '2019-11-05 20:13:45', '2019-11-05 20:13:45'),
(147, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-11-05 21:07:12', '2019-11-05 21:07:12'),
(148, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-11-05 21:07:31', '2019-11-05 21:07:31'),
(149, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-11-05 21:07:47', '2019-11-05 21:07:47'),
(150, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:04:41', NULL),
(151, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:04:42', NULL),
(155, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:04:47', NULL),
(156, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:04:48', NULL),
(157, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:06:26', NULL),
(158, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:06:27', NULL),
(159, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:06:29', NULL),
(160, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:06:30', NULL),
(161, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:06:31', NULL),
(162, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:12:54', NULL),
(163, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:12:56', NULL),
(164, 5, 3, 'new customer', 'new name', 'new email', 'sdvxdvx', 'kjsdgksd', 'fvdfv', 556677, '43546456', 'active', 1, '2018-02-08 04:22:56', '2019-10-31 10:20:25', NULL),
(165, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:05:58', '2019-11-01 19:05:58', NULL),
(166, 5, 1, 'john Hill', 'john Hill', 'cehohibot@w6mail.com', '5 Amrakunj Soc, Nikol Naroda Road', 'Ahmedabad', 'Karnataka', 382330, '8672803594', 'active', 1, '2019-11-01 19:06:16', '2019-11-01 19:06:16', NULL),
(167, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:06:31', '2019-11-01 19:06:31', NULL),
(168, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '2673  Rosemont Avenue, Pratt Avenue', 'irvine', 'California', 92603, '3608604038', 'active', 1, '2019-11-01 19:06:53', '2019-11-01 19:06:53', NULL),
(169, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:07:07', '2019-11-01 19:07:07', NULL),
(170, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'cehohibot@w6mail.com', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:07:22', '2019-11-01 19:07:22', NULL),
(171, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:07:47', '2019-11-01 19:07:47', NULL),
(172, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:09:12', '2019-11-01 19:09:12', NULL),
(173, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:09:51', '2019-11-01 19:09:51', NULL),
(174, 5, 1, 'Harikrishna Nirmal', 'Harikrishna Nirmal', 'hknirmal@vxmail.top', '5 amrakunj soc, nikol naroda road, nava naroda, Nikol naroda Road , nava naroda ,', 'Ahmedabad', 'New Jersey', 3823330, '7778050990', 'active', 1, '2019-11-01 19:10:05', '2019-11-01 19:10:05', NULL),
(175, 5, 1, 'Kevin S. Brackett', 'asdasd', 'KevinSBrackett@teleworm.us', 'sdcsd', 'asda', 'asdasd', 883554, '2342134', 'active', 1, '2019-11-05 20:16:32', '2019-11-05 20:17:26', '2019-11-05 20:17:26');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
CREATE TABLE IF NOT EXISTS `migrations` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2016_06_01_000001_create_oauth_auth_codes_table', 1),
(2, '2016_06_01_000002_create_oauth_access_tokens_table', 1),
(3, '2016_06_01_000003_create_oauth_refresh_tokens_table', 1),
(4, '2016_06_01_000004_create_oauth_clients_table', 1),
(5, '2016_06_01_000005_create_oauth_personal_access_clients_table', 1),
(6, '2018_11_29_180645_create_permission_tables', 2),
(7, '2019_01_31_055953_create_notifications_table', 2);

-- --------------------------------------------------------

--
-- Table structure for table `model_has_permissions`
--

DROP TABLE IF EXISTS `model_has_permissions`;
CREATE TABLE IF NOT EXISTS `model_has_permissions` (
  `permission_id` int(10) UNSIGNED NOT NULL,
  `model_type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model_id` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`permission_id`,`model_id`,`model_type`),
  KEY `model_has_permissions_model_id_model_type_index` (`model_id`,`model_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `model_has_roles`
--

DROP TABLE IF EXISTS `model_has_roles`;
CREATE TABLE IF NOT EXISTS `model_has_roles` (
  `role_id` int(10) UNSIGNED NOT NULL,
  `model_type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model_id` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`role_id`,`model_id`,`model_type`),
  KEY `model_has_roles_model_id_model_type_index` (`model_id`,`model_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
CREATE TABLE IF NOT EXISTS `module` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `key` varchar(255) NOT NULL,
  `is_saas_module` tinyint(1) NOT NULL DEFAULT '0',
  `is_archived` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` int(20) UNSIGNED NOT NULL,
  `modified_by` int(20) UNSIGNED NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `disabled_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`id`, `name`, `key`, `is_saas_module`, `is_archived`, `created_by`, `modified_by`, `created_at`, `modified_at`, `disabled_at`) VALUES
(10, 'Users', 'staff', 0, 0, 1, 0, '2016-01-22 01:41:27', '2016-01-22 01:41:27', NULL),
(11, 'Report', 'report', 0, 0, 1, 0, '2018-12-06 07:44:21', '2018-12-06 07:44:21', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `module_pages`
--

DROP TABLE IF EXISTS `module_pages`;
CREATE TABLE IF NOT EXISTS `module_pages` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `system_module_id` int(20) UNSIGNED DEFAULT NULL,
  `parent_id` int(20) NOT NULL DEFAULT '0',
  `client_parent_id` int(20) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `description` text,
  `icon` varchar(100) DEFAULT NULL,
  `show_in_nav` tinyint(1) NOT NULL DEFAULT '1',
  `is_email_notification_module` tinyint(1) NOT NULL,
  `is_email_notification_enabled` tinyint(1) NOT NULL DEFAULT '0',
  `route_name` varchar(100) NOT NULL,
  `show_in_access` tinyint(1) NOT NULL DEFAULT '1',
  `display_order` int(11) NOT NULL DEFAULT '0',
  `display_order_client` int(11) NOT NULL DEFAULT '0',
  `auth_display` tinyint(3) UNSIGNED NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `system_module_id` (`system_module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `module_pages`
--

INSERT INTO `module_pages` (`id`, `system_module_id`, `parent_id`, `client_parent_id`, `name`, `client_name`, `url`, `description`, `icon`, `show_in_nav`, `is_email_notification_module`, `is_email_notification_enabled`, `route_name`, `show_in_access`, `display_order`, `display_order_client`, `auth_display`) VALUES
(1, NULL, 0, 0, 'Dashboard', 'Dashboard', '/dashboard', NULL, 'icon-display4', 1, 0, 0, 'dashboard', 0, 1, 1, 7),
(4, 10, 0, 0, 'Clients', 'Clients', '/clients', NULL, 'icon-user', 0, 0, 0, 'clients', 1, 7, 2, 7),
(5, 10, 0, 0, 'Products', 'Products', '/product', NULL, 'icon-graph', 1, 0, 0, 'Products', 1, 3, 2, 7),
(6, 10, 0, 0, 'Sales Rep', 'Sales Rep', '/salesrep', NULL, 'far fa-id-card', 1, 0, 0, 'Sales Rep', 1, 4, 0, 1),
(7, 11, 0, NULL, 'Tax Rules', 'Tax Rules', '/taxrules', NULL, 'fas fa-poll-h', 1, 0, 0, '/taxrule', 1, 5, 0, 1),
(8, 12, 0, NULL, 'Orders', 'Orders', '/orders', NULL, 'fas fa-paste', 1, 0, 0, '/order', 1, 6, 0, 1),
(9, 14, 0, 0, 'Customers', 'Customers', '/customers', NULL, 'icon-user', 1, 0, 0, '/customers', 1, 2, 0, 1),
(10, 15, 0, 0, 'Package', 'Package', '/package', NULL, 'far fa-id-card', 0, 0, 0, 'package', 1, 8, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
CREATE TABLE IF NOT EXISTS `notifications` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `notifiable_type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `notifiable_id` bigint(20) UNSIGNED NOT NULL,
  `data` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `read_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `notifications_notifiable_type_notifiable_id_index` (`notifiable_type`,`notifiable_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_access_tokens`
--

DROP TABLE IF EXISTS `oauth_access_tokens`;
CREATE TABLE IF NOT EXISTS `oauth_access_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `client_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_access_tokens_user_id_index` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_access_tokens`
--

INSERT INTO `oauth_access_tokens` (`id`, `user_id`, `client_id`, `name`, `scopes`, `revoked`, `created_at`, `updated_at`, `expires_at`) VALUES
('a9b4de4fad3c4573a1eed5af70ba734e932bb47bc127a9af26ea66b926a84be90bfcba22c6424952', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-24 02:44:22', '2019-01-24 02:44:22', '2020-01-24 08:14:22'),
('473a06b858aed853e5262656596bbf9850d318dac7e1559f0e8cd2d2911e4d8f7850bce09989ccba', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-24 02:46:29', '2019-01-24 02:46:29', '2020-01-24 08:16:29'),
('32750b47608ca6700c91074d8ffcaec4a1a01810e7a280d014ff2b4da7cdc61ccb3ebe6a8339ab1d', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:06:53', '2019-01-29 07:06:53', '2020-01-29 12:36:53'),
('485b5ce239730cb01d8d3dbd1cacf3cd52df46301938ee9363c3b0a04d2be88d126a1af6054e466f', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:07:08', '2019-01-29 07:07:08', '2020-01-29 12:37:08'),
('c52fb53e57f1b1c1f421682025b75cf5c461c6a6aa9052bab27e58958210d083024e26422c200404', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:08:24', '2019-01-29 07:08:24', '2020-01-29 12:38:24'),
('a3031ce72fe079dbfead12ad3ebd258d5292bd436d1277af5066acfee90fa160b76e8400fca11f0e', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:13:46', '2019-01-29 07:13:46', '2020-01-29 12:43:46'),
('709071db9c840fd9de0a8c6face65125ef86d78d78a469ca04eb512b451ceeea3cb4cef125604a4b', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:24:25', '2019-01-29 07:24:25', '2020-01-29 12:54:25'),
('63f6c7ccd57fe86180932e9b1ab158520ef197dc04553022920ee3867785512e9681fde2d128c244', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:26:39', '2019-01-29 07:26:39', '2020-01-29 12:56:39'),
('ec1bc78b7f97b6d35a2dc2a3eae37712d70179294224197dbf619ef340ac1e3c26b7af9b08b2dbf6', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:27:16', '2019-01-29 07:27:16', '2020-01-29 12:57:16'),
('9d4692720a435894392c60b2e9b58aa2cf981812eb6bbd2531c0ccd781c1c6ac15f49222606336c3', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:27:47', '2019-01-29 07:27:47', '2020-01-29 12:57:47'),
('22cb69ab4db9e1a38683bb540b97b649380fce099bec502da5d0859fb5fafb3fdbca1a8feb1662bd', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:37:50', '2019-01-29 07:37:50', '2020-01-29 13:07:50'),
('f9142ab639c0d5bb45cfd2b627a9c8ab4eac41c021745ab39941458b77512f7de445a0625487130a', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-29 07:52:44', '2019-01-29 07:52:44', '2020-01-29 13:22:44'),
('39517c5a1dcd456f68395a09b57a9256b7401be2b9529c4a4db8a8e79b62448424001e2390ac6b03', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-30 05:55:28', '2019-01-30 05:55:28', '2020-01-30 11:25:28'),
('903b44e1ec30e4fbdcb8e324725520e458087a014f49b669adeccd092932e911ed17c6fa25a3cc95', 5, 1, 'Personal Access Token', '[]', 0, '2019-01-30 05:55:45', '2019-01-30 05:55:45', '2020-01-30 11:25:45'),
('6addcb29fc2189990b3159c57a7d44fa0e7a783a097809e8f8a1f7befbaaecfd0ced90063947a1ee', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 03:54:29', '2019-02-01 03:54:29', '2020-02-01 09:24:29'),
('57dc7a6f269cb5c05b5d3e54b16903d8010c7c1057848f12fc2a03370ab02df4851e9fb4bff4029f', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 03:55:16', '2019-02-01 03:55:16', '2020-02-01 09:25:16'),
('be87e9bfcbfa40084a2f3b728850939417be91307510ccf6b79af341725e60783b4ed11485b5f020', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 04:07:37', '2019-02-01 04:07:37', '2020-02-01 09:37:37'),
('9e06f9eebc24a095962d25eeeaa328413e8558130eb878d90e745bb927b3742b11f0e225fbb992f1', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 04:08:35', '2019-02-01 04:08:35', '2020-02-01 09:38:35'),
('e8f0a73ceaa0273d33b41f6acc3230c6418fe162577bb50b24262232587ecf0f61bc58bd80ffe112', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 04:09:48', '2019-02-01 04:09:48', '2020-02-01 09:39:48'),
('ab17de42e0a89fa4d0317f10feff1ec57d997e73b3b5796c4b594ff131abc58b0147ba2ca5307380', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 04:10:05', '2019-02-01 04:10:05', '2020-02-01 09:40:05'),
('e309c21c0d698b8fcb77959f600b0c11b558634251444859d6d37abda64de0cd269183e067c041b8', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 04:11:27', '2019-02-01 04:11:27', '2020-02-01 09:41:27'),
('65563aeeffa4b69251057b1c08d3ec16be7fe6f21ad2bd9000e09101b3a08e1f5f063b66038227c5', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 04:18:49', '2019-02-01 04:18:49', '2020-02-01 09:48:49'),
('31f70095d1700c68d44c31b43339fddbe882a7c8a12ad61fee5f38cc78d5cee8102f3a9d84c52eb4', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 04:19:23', '2019-02-01 04:19:23', '2020-02-01 09:49:23'),
('d5a6b202e02a6af0fb5570e6f726e426d3e837b4d1eceed8deb432cb113c554df7f5954eddb5edcf', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-01 07:03:20', '2019-02-01 07:03:20', '2020-02-01 12:33:20'),
('c7d2fa9f9fe12704013433783645ae8de6432497bc9b5ec9ed00e74f9ed5f20aa9402bc66d777332', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-02 01:51:52', '2019-02-02 01:51:52', '2020-02-02 07:21:52'),
('36bd36fc5fe4f9e8a222c6c5022d145888121fc5fbe56a70cfb32ae1bbb8720603028940dbe65999', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-02 01:58:37', '2019-02-02 01:58:37', '2020-02-02 07:28:37'),
('b6eebee3135eb1ecaae3fe6659dd86d336714b742fc203bf60b3dfcf1f3296d3d2b8bbc38d7aedfe', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-02 02:33:56', '2019-02-02 02:33:56', '2020-02-02 08:03:56'),
('7b2dd0199baacb9549940b01379a53f0443b419a2ff3ef6903f8f7f44c83c1158dd0c9e649d2931e', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-02 03:18:20', '2019-02-02 03:18:20', '2020-02-02 08:48:20'),
('cfaab8ade5bfebbee12f0814c97e26ce2615bac5aa993ae79f445548cf4974a47598e784ede12615', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-21 03:34:19', '2019-02-21 03:34:19', '2020-02-21 09:04:19'),
('7ce4dc2dcdb0258b1001aae38a332dd9ab601dd5342016982e6a41e02226c2713df816ecf514e13f', 6, 1, 'Personal Access Token', '[]', 0, '2019-02-21 04:00:17', '2019-02-21 04:00:17', '2020-02-21 09:30:17'),
('c77f807888157eb209920cbe16ef82c7b0fca51e1f19384441fbe29d9f25db36734b0f05f495ee65', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-21 04:04:37', '2019-02-21 04:04:37', '2020-02-21 09:34:37'),
('0501f42ee17b83e07a4e25b786fc891b97293257ceaaf99bf782ab6bffa385477a4d7b25c0630f85', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-21 22:16:29', '2019-02-21 22:16:29', '2020-02-22 03:46:29'),
('3bcd1b642e173b0d098f99e152083cd07ea760d4e40e755be91178e98466411c37b6a4b89aa3b20a', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-22 00:53:18', '2019-02-22 00:53:18', '2020-02-22 06:23:18'),
('ad6c851bacb307255c178305033c209e1690dfb27f2b2984d9526e4fffede3747acf9c76693c44c4', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-22 00:58:00', '2019-02-22 00:58:00', '2020-02-22 06:28:00'),
('4b8f4a37fbae95cf290c5bc260e40fce32cd21d248858c70f323b8a37decbd8f492fd9520e5fe420', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-22 00:58:17', '2019-02-22 00:58:17', '2020-02-22 06:28:17'),
('489eb108ff1d834793598d719fa6d492cd5022a12bf3137ea63393eee539119fd8caea894086df0e', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:21:52', '2019-02-23 05:21:52', '2020-02-23 10:51:52'),
('813f36edc3252952bad6943aa0ff095176a11f15aab2071d2aea88df218256522b639a58595d597e', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:26:06', '2019-02-23 05:26:06', '2020-02-23 10:56:06'),
('9d50d83db8432fb4728a41bbd2585396b01a0732fa54d6cc6bf03345dc8bcf458275aa99e9ede595', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:28:08', '2019-02-23 05:28:08', '2020-02-23 10:58:08'),
('aaea1db7c6e90636c306c6c2b1506385d674d5a75089d67f0db14aa8741ede94e64a9f737eca1f96', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:29:55', '2019-02-23 05:29:55', '2020-02-23 10:59:55'),
('6df431fd53c03629c3ecddad520a7c3a4b68aa37bf68d74ee682f06f5e3c17b845df10263397272a', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:30:56', '2019-02-23 05:30:56', '2020-02-23 11:00:56'),
('81e994eca0c2c3a0e37e61c62a57e409d3744e829a2ae90b97be7d5dadb49706569cd488a4442ad9', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:32:30', '2019-02-23 05:32:30', '2020-02-23 11:02:30'),
('87412dbd9801230537d3fb83362df31b8744c46495f56f47bc2a8423c32fc06333a738da40b4bac3', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:34:43', '2019-02-23 05:34:43', '2020-02-23 11:04:43'),
('ac59fbcbf71197accd33b2dab73c1940d7663782407d336fedf2d8f4ac9afa1371e7b390fe92f2b8', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:35:18', '2019-02-23 05:35:18', '2020-02-23 11:05:18'),
('f3b93f683d3e2c23d7f2e8fefae74801f257bdc60a105d1c297392208565a754caced1a87240d98b', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:36:02', '2019-02-23 05:36:02', '2020-02-23 11:06:02'),
('a8ab2889750e2920c245ba366a0b9f5d4bfe8a432dd8120489304acbab0744eed0b7a3f5746e11aa', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:37:54', '2019-02-23 05:37:54', '2020-02-23 11:07:54'),
('16bac3534d77a1103739f225d5d78822ae9fc31b1507ae06de2e4356ade50b7d69a1aa530cdc1f90', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:38:55', '2019-02-23 05:38:55', '2020-02-23 11:08:55'),
('aa074ae88ea06d7a4b589861b6302570fd603e99feeb9b8d08ce93683744d992efa662070d4294ae', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:44:25', '2019-02-23 05:44:25', '2020-02-23 11:14:25'),
('a62f5b5e1d07b68cbded6120846704f35f7817d9050b3349acecc34cca2c9ecc23e1363776ea0c6c', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:46:22', '2019-02-23 05:46:22', '2020-02-23 11:16:22'),
('ecc027ef0ef1925c218808949ac91cff8ac72afafa6b30470e090869cc2f2468482781890ff96222', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-23 05:46:59', '2019-02-23 05:46:59', '2020-02-23 11:16:59'),
('dfd62915dfb37d1a823f394204ab44b7fff222dbed3b6d1e82a6e10ebe118869be097e604a1596d1', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-24 06:59:51', '2019-02-24 06:59:51', '2020-02-24 12:29:51'),
('f8305bbb95d39174e6325b82ce54a2a0103f71790b65c32956bcf03b7de879d16ab5cffe95b7294e', 5, 1, 'Personal Access Token', '[]', 0, '2019-02-24 07:10:00', '2019-02-24 07:10:00', '2020-02-24 12:40:00'),
('bba0572122db8b00a8aedf1ae0acdf6a94bcc03480c6ee0cdb6896eb49d642713ba03805644bf240', 5, 1, 'Personal Access Token', '[]', 0, '2019-03-05 15:14:34', '2019-03-05 15:14:34', '2020-03-05 16:14:34'),
('682afb7235a260d84c61cfe6e307f5ad5ec57af6f471cb43bf4fe7bdde80bd8091e2ee0241a3b33e', 5, 1, 'Personal Access Token', '[]', 0, '2019-03-05 15:19:46', '2019-03-05 15:19:46', '2020-03-05 16:19:46'),
('d28253cb839e5ebcf7e6c08c30cf80dbdebc53d96fc60ba15a0926ac553b0cc8d1a64e4d2ff74d80', 5, 1, 'Personal Access Token', '[]', 0, '2019-03-05 15:24:53', '2019-03-05 15:24:53', '2020-03-05 16:24:53'),
('2902cd50f0b0b0ac928d7f6fff110e651a7a5b0dd076358fefeadc1117002c1f8118103c9347fe7e', 5, 1, 'Personal Access Token', '[]', 0, '2019-03-05 15:27:12', '2019-03-05 15:27:12', '2020-03-05 16:27:12'),
('2dfbf0c2a80468b56eb135d26c2ca9d2a0387c66fe592dd757ed277ad04c64d61d004f60dd2115b4', 5, 1, 'Personal Access Token', '[]', 0, '2019-03-11 09:58:49', '2019-03-11 09:58:49', '2020-03-11 15:28:49'),
('f2888003d800f17b8e13629422612e5d9063ac7b1e5eaa6e08fdd0e135c05ec2323c3dc37239fe11', 5, 1, 'Personal Access Token', '[]', 0, '2019-03-11 10:02:10', '2019-03-11 10:02:10', '2020-03-11 15:32:10'),
('83014895e4cb9baa05256dbb109062649888a36641568939fdc055a40a945a0fa866450d7338023d', 8, 1, 'Personal Access Token', '[]', 0, '2019-03-15 09:08:29', '2019-03-15 09:08:29', '2020-03-15 14:38:29'),
('e3e53ba0010890e97e03cc048c3adcfaefe9402b4ccdefabaeca4fc6c1dc2fd26add9813c4f93b18', 5, 1, 'Personal Access Token', '[]', 0, '2019-03-15 09:19:50', '2019-03-15 09:19:50', '2020-03-15 14:49:50'),
('51a65afa1f6fd242fcd0c11ae1f30dc8d37005056551688b7b995a9e482aca6815cc37100b331172', 5, 1, 'Personal Access Token', '[]', 0, '2019-04-02 03:06:33', '2019-04-02 03:06:33', '2020-04-02 08:36:33'),
('233edb7a126fb8de0472b02b81f92c1d6548ecde5a6cccddf6b739933352552e7566c3631112d932', 5, 1, 'Personal Access Token', '[]', 0, '2019-04-02 03:41:34', '2019-04-02 03:41:34', '2020-04-02 09:11:34'),
('a758565cfeaf2e371fcb0bd89f57bceb2eb602b46e35fe3f742061a7141d46778513aa65e3b35249', 5, 1, 'Personal Access Token', '[]', 0, '2019-04-03 04:46:06', '2019-04-03 04:46:06', '2020-04-03 10:16:06'),
('0a155529ab2a277f361757e851d36a667a78fe5e6a5c5976a2e695fc20e9ff5a4f532391887f87d1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-18 06:41:53', '2019-10-18 06:41:53', '2020-10-18 12:11:53'),
('b259e67a19b42c00d12010e44eee83d5aeb3d171a2d2a09d42227df32fc11b996d89e2870649af28', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-18 06:43:49', '2019-10-18 06:43:49', '2020-10-18 12:13:49'),
('10ced784b49e7fac441dde59d6977551381bd42b2860e887fcad54bc42fdb4498a4babc3214e99ed', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-18 06:44:04', '2019-10-18 06:44:04', '2020-10-18 12:14:04'),
('255569d774e10100166e9d13722adf1defd653661e3efd6a9cf0cb3b5a1aae07769cb90316e806a8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-18 06:47:50', '2019-10-18 06:47:50', '2020-10-18 12:17:50'),
('d5ba570287a4657fc939b3c0991cdcdd5528785153ac91386ae0a5bb57bba149555ec041d03dc41a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-20 09:14:09', '2019-10-20 09:14:09', '2020-10-20 14:44:09'),
('d104305a102b49e16255fcfb33e4cfa5d322c062c9809c27593503dc331a33935a7e37b20e64ef53', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-20 13:16:21', '2019-10-20 13:16:21', '2020-10-20 18:46:21'),
('07e7d557294899785307833a5eef7f8360d0669067b99dee9407a34c86ee8cb812c5de9c40301086', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 12:34:13', '2019-10-23 12:34:13', '2020-10-23 18:04:13'),
('b8bfbfaf65e51b30b5dc59464a9ea01ffc9775ef5c854f57ae806c02c7ce59a678bb55a5eed27c50', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 12:34:42', '2019-10-23 12:34:42', '2020-10-23 18:04:42'),
('90adf52fc1bb3310f5b22e255ff3000ac13971b590a57824e7f91dcddc63ef315df476c70c5d00a6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 12:44:39', '2019-10-23 12:44:39', '2020-10-23 18:14:39'),
('30b9139313f36605bc5725b23791bb1839cc8cb310026f69805ddf0a2244f845a00ca6dc30b029a0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 12:45:12', '2019-10-23 12:45:12', '2020-10-23 18:15:12'),
('4f8c5536de3171402dae27db84c022e1b1fd09eeb75a2154ba15dfed91a2184db3c88634e889444c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 19:01:15', '2019-10-23 19:01:15', '2020-10-24 00:31:15'),
('32ac063612d70a590f5b9e408cde420d47d8d3f0ff531cf09bcb5568c315b380154675ffb2f23860', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 19:02:37', '2019-10-23 19:02:37', '2020-10-24 00:32:37'),
('a90c3d5809d02dfc8cf3c0c8b4b072cf0016fef0465f4e078c6c0437746ad3d6935571c85626746e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 19:03:43', '2019-10-23 19:03:43', '2020-10-24 00:33:43'),
('5b920f34da40f550072a86264f0b335c6a66532d3dc812ca3b0a482f8cc2ae488b92b27709ed49d9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 19:04:58', '2019-10-23 19:04:58', '2020-10-24 00:34:58'),
('0b71b1bd22ce69af463257f2e29db9ed329513698df30e3c5f618a73b1ee031ba58326e5b3add3e6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 19:05:53', '2019-10-23 19:05:53', '2020-10-24 00:35:53'),
('c877fe8b24f096d235725459c675287970ce9ab7067f1a95753d0e95bb93afda6402d1336487cdc1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-23 20:30:31', '2019-10-23 20:30:31', '2020-10-24 02:00:31'),
('17e0bd017b63f18bd5bb988172f84a141a446a446efdac41e7aa5700586da39ad272b20452364906', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 09:44:09', '2019-10-27 09:44:09', '2020-10-27 15:14:09'),
('c33725977ac688267fa4f5a99f39c809e756a04790953e6b5e305afeb8875409dd0c49a88d61b12d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 09:48:13', '2019-10-27 09:48:13', '2020-10-27 15:18:13'),
('21c00ddf5ec4bc33e23ef0b909de74d83f06aacb28d5a2a53cae91dce8a192e9aa7e5ee9e0f5fa69', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 09:53:12', '2019-10-27 09:53:12', '2020-10-27 15:23:12'),
('eb31ec485ba74d5fb1aa92693a2af98c695d3c334a2fadf615f9394f10804b2b6439f482534ecf33', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 09:55:38', '2019-10-27 09:55:38', '2020-10-27 15:25:38'),
('66afd195b7fbbbadc66c00ef2da6dd3006f2b237beee78bd038a7576a164545c3eb82626697c8e44', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 09:56:17', '2019-10-27 09:56:17', '2020-10-27 15:26:17'),
('5cec4313a3ab3e1923c27da412126c2c4a80ff8674103470d8d9c710c5b7914500bc32f84b417f0b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 09:59:27', '2019-10-27 09:59:27', '2020-10-27 15:29:27'),
('2200eea9c09c964a39774944993a50d8eb7a8367d0eed1716f08b761e3429b035399d2a3a0da473e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 10:27:44', '2019-10-27 10:27:44', '2020-10-27 15:57:44'),
('2861ae5c08c1e8e2d5b99885662279dc81a476f5abded44bb377fc69dcc8fa52687a94ad3a704385', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 10:57:07', '2019-10-27 10:57:07', '2020-10-27 16:27:07'),
('e0196be3cb0400931e99eb4a88345bdcbca2add623989e43635f2f923edd2630ea0e07a12905c508', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 10:58:23', '2019-10-27 10:58:23', '2020-10-27 16:28:23'),
('7bfd1264a154f00e6c14d7f061af9915b8559bf7cd1f0630e135cec9937dd23178bdb5ba9a78bdda', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 11:02:03', '2019-10-27 11:02:03', '2020-10-27 16:32:03'),
('095f342ad60e4aa2893c79d859ecdcae786ae8c54608dbd8cf17c4dc3ae04b787aac9b995ad4b871', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 11:02:54', '2019-10-27 11:02:54', '2020-10-27 16:32:54'),
('1e521c35af13efed5e74a99e87f3c83c1e4cb1f0ff29c319b3d62d9d1b67cc78a1e68da66a94346f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 11:39:50', '2019-10-27 11:39:50', '2020-10-27 17:09:50'),
('704a599b359171d16e52a69f44d01def9bf79e16e31d5703e3725fedd4fa79b925a9974d789870ce', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 11:41:46', '2019-10-27 11:41:46', '2020-10-27 17:11:46'),
('f1b29805b45539ccce99eae0846df037f8ab0c62b3e4d018c77abcb393958def55641d80983b570c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 11:46:47', '2019-10-27 11:46:47', '2020-10-27 17:16:47'),
('9a9b67857f76f2d2b6d638a61df9ab39a52bc26fde4f5f3229aa0d188021c66d2625f35c4b620405', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 11:51:51', '2019-10-27 11:51:51', '2020-10-27 17:21:51'),
('048122c4de1370ddb8eddd37a6b0a3fe50594a7ba4efc89b4e5c8692a34f88c6c3542a448fe97971', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:04:27', '2019-10-27 12:04:27', '2020-10-27 17:34:27'),
('debe2be9b4f1441da3371c6196a96ef7d0a86308809b8b8a41d013166def8bbe698eebb84d553154', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:11:52', '2019-10-27 12:11:52', '2020-10-27 17:41:52'),
('2b5af9f2e9f9f1599dd764c478e70a9f55804aaa0a5940d1c71b6d89852a7d19802cb4d665bb1818', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:13:22', '2019-10-27 12:13:22', '2020-10-27 17:43:22'),
('aa6a1eef27c28f15afcad2363a31264306296f78604e8751dbf001504190702d3ae2c1f94c9ee1ce', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:14:48', '2019-10-27 12:14:48', '2020-10-27 17:44:48'),
('651e4f8bd43524a6e2ae413960c6bedc193a7666c955f805de7aa1ff18b1ff923631512a236e1d3b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:16:03', '2019-10-27 12:16:03', '2020-10-27 17:46:03'),
('69b1dd5d5865b8a9be8f17e458b25b4729df3146a36749da43ed90ebc3789d977507144413b26e5c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:17:08', '2019-10-27 12:17:08', '2020-10-27 17:47:08'),
('1aee565d83e48af8ad53f21c1fc359d6b96240543a8460940d87a802cb0637daeeccfd67f4a31441', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:17:29', '2019-10-27 12:17:29', '2020-10-27 17:47:29'),
('5089d17c7db9fef0773219ff173260e2156b23ff52b54eef2ea95bd45f45d88e2018a260c4183252', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:40:41', '2019-10-27 12:40:41', '2020-10-27 18:10:41'),
('c1c58ded3fae7bc617f54641777c0c1467961001e8aee0232e490c037aba7f16dba2c85a04ac9dcd', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-27 12:50:12', '2019-10-27 12:50:12', '2020-10-27 18:20:12'),
('9f04e34dad9e4580c7593526946054b7e2268d6493a6c3f733f955fc7fe2eeab895cd32a9310c941', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:12:07', '2019-10-28 11:12:07', '2020-10-28 16:42:07'),
('ee4bf9f18cbf434c3904c457d9d6bc932a8f6487ba5f2e98209ba867b2dabc24dd16ddc29ba7e9e6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:13:34', '2019-10-28 11:13:34', '2020-10-28 16:43:34'),
('43e95031d1d36251f732b775100a6be65281181c6b7f4254de71739ab71f7c13fc4f36e1bff5786f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:27:11', '2019-10-28 11:27:11', '2020-10-28 16:57:11'),
('63adbfb34938747c2d386941b31f589d37816151778aa40005a4f3f6e53848cfb2e361302921de3e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:29:31', '2019-10-28 11:29:31', '2020-10-28 16:59:31'),
('8eed2d71415c3b17f769155b03185124cd2f8481c0e3590af66f48386231ff1b9cbb4bb687318305', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:31:19', '2019-10-28 11:31:19', '2020-10-28 17:01:19'),
('069052e9ae93165f6ab69288c5e699f61895e63d07fc381f2d5f4920c195482ded028e33f499d6c1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:39:59', '2019-10-28 11:39:59', '2020-10-28 17:09:59'),
('23ce6678fd4e07314d030179540c2cde1c9227c347f09b09c08cfbff4ed2e6be47cacebd317aa0ed', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:40:54', '2019-10-28 11:40:54', '2020-10-28 17:10:54'),
('0aa99ed4e7f28962f22ed1b355d685df03b98f4119431e664536dae17233689acf382b25d93a36bc', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:43:36', '2019-10-28 11:43:36', '2020-10-28 17:13:36'),
('bbd2e72b2bf9db6754385aede47cecc2f932b9a0169eae9200fe9ff53d61b5bfef46d8586a374914', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:51:03', '2019-10-28 11:51:03', '2020-10-28 17:21:03'),
('5042237adc04054593061bcda5a178bcb0d46173d778cf459be04ae37dfb29d4fc502dfbb5e37a11', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 11:54:48', '2019-10-28 11:54:48', '2020-10-28 17:24:48'),
('090ccd4b9daba42ce9d02959a772c180467afa960a2db21ea26959a69c43c3d57d29b47c231b72bc', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 12:17:00', '2019-10-28 12:17:00', '2020-10-28 17:47:00'),
('d3a201fbc95af4d3bf7ae4570428afe6820b35c435c6db66eb97fb118b00c2b42f449047032c2176', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 12:29:08', '2019-10-28 12:29:08', '2020-10-28 17:59:08'),
('0ff29c1b285249092d029b142fa66136e9f7cf638f12bc98479a6d7ed4f0d1fb0af041659f3b8f2e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 12:29:22', '2019-10-28 12:29:22', '2020-10-28 17:59:22'),
('23c2871477f9011e3f90ff01d5113c8ba563f18a645745552611f7d793753948d123535be9c0618f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 12:48:42', '2019-10-28 12:48:42', '2020-10-28 18:18:42'),
('17117115d77c9cf7119eef5b3d3802489f8a509a2e2d3e1080e80fb15fda640eefe6a2448f89fc3d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 12:48:55', '2019-10-28 12:48:55', '2020-10-28 18:18:55'),
('7c8e3c2983f5d33f5f747e81cf68a0d92fc581397a89d3f4c43a764c8901256feece0392eb545378', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 12:49:13', '2019-10-28 12:49:13', '2020-10-28 18:19:13'),
('05f0a7670f3e59dfbae76fedc3a3d822eee5e915db8b919c6bde790147cfaec9b20bde8807f4cea6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 13:42:18', '2019-10-28 13:42:18', '2020-10-28 19:12:18'),
('b4f96bf97cce4a90b38659d7aae4ddaac0f684cec35c9b0fc2a447bf3de5d43c6ee390694eb1e9cd', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 14:05:17', '2019-10-28 14:05:17', '2020-10-28 19:35:17'),
('46d984ee2d02b5fd28e690bd229c916d82904f7bf1187d8ce616dc9386612955dbfa800e190d5a12', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 14:16:59', '2019-10-28 14:16:59', '2020-10-28 19:46:59'),
('75d2409a2fd506af51ab4cced3c26d07babfc8b2685e98e10bde66dbb88995f862659343c5a1009b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 19:24:34', '2019-10-28 19:24:34', '2020-10-29 00:54:34'),
('eff0850f97bc340fbf6673a37985f7f8d28db7094fbc3ec121da3211df5212b16a1a9f55c280f9c2', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 19:39:54', '2019-10-28 19:39:54', '2020-10-29 01:09:54'),
('0a526ad1102811b9eb454cfaca89cdd4809c9c1644103a95742ad7b28d2d329cab474f1b3e51fcd8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 19:39:55', '2019-10-28 19:39:55', '2020-10-29 01:09:55'),
('8028d7e359700ab832b74706a4353ef454f14b226bdd28e25331eec0dedfca6778d34084834ecfb6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 19:56:26', '2019-10-28 19:56:26', '2020-10-29 01:26:26'),
('902d7825418575ebdafc7a0b105fb47c80a903de4d9a6958385aec1f4dacca82dfef63e4848d12eb', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 20:49:09', '2019-10-28 20:49:09', '2020-10-29 02:19:09'),
('5756dc3202cd4af04fa3826ddaf474edeabf5018e459f52ba1b5f79740fd199a1c70c942daddf990', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 20:50:17', '2019-10-28 20:50:17', '2020-10-29 02:20:17'),
('68ebfa797569001085f17efec78cf06c751f718ab5dcc1a0adada751d707b34658edd3caadde8062', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 20:52:29', '2019-10-28 20:52:29', '2020-10-29 02:22:29'),
('409d34155336aaed25520c8d50e6f7c36b5d89ce589691689853761ba80f388158bddf696b48c7df', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:01:36', '2019-10-28 21:01:36', '2020-10-29 02:31:36'),
('881d030385421c8c5590ecb4567bacdcc5c4e2aacbe01b20c25fe9a4b38933770ea67c894b33d69c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:02:01', '2019-10-28 21:02:01', '2020-10-29 02:32:01'),
('942b03135cfd8ad92c4e649745937cff9f6514f7b3c44995e65a3c07d8e0d496509085ff7c0b0e19', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:02:52', '2019-10-28 21:02:52', '2020-10-29 02:32:52'),
('2ac26c63fe0b896097f16433dd5165907905afc6b57ca0cd6725999cd28b367e8d0d89ee712e5c84', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:05:24', '2019-10-28 21:05:24', '2020-10-29 02:35:24'),
('7cc2caf5600411b6c96999a969308ba0026b6f4d6c23b4b6b969dd0c6a2aa527c641284fd46c42d0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:18:28', '2019-10-28 21:18:28', '2020-10-29 02:48:28'),
('e9967fe6716eb11d3f1e8c6d192fd42ddfc50b6b7c7b3ab0f3a2cd1a5dbcb9c81bd16a013e8491a8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:19:12', '2019-10-28 21:19:12', '2020-10-29 02:49:12'),
('3df22576999e4d0993b1aeb169a8cd73ef613bd0c093c58d52cf9c53e1523d333ae1c97a03cb87df', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:20:08', '2019-10-28 21:20:08', '2020-10-29 02:50:08'),
('c0b76da76a86e902e57d2291d37888f61463a36bf7189c5d3aa15b058a66940999766966b61488b9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:27:49', '2019-10-28 21:27:49', '2020-10-29 02:57:49'),
('20eef7079efbd483b970071cab7d453557279e0b5d544c06cc397bf7b8494dca864e332c2b7a997d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:45:05', '2019-10-28 21:45:05', '2020-10-29 03:15:05'),
('ce62c3cac3b8e6d64fd2ad681c63d1fb173735a32f27cf815cfc8eb7518aae5a4c991ec393edaae8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-28 21:51:28', '2019-10-28 21:51:28', '2020-10-29 03:21:28'),
('96b645d5afc274eb0276d6e9e06feabe30a76e2f09bcf375a228f5f7951794e1684cc810c6aa16f9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 09:41:51', '2019-10-29 09:41:51', '2020-10-29 15:11:51'),
('0123b64aa663c2c3186f53d10f7b728e3d4b7f8313d21d17cf98cd2a26a8ab2aced5549d2371cb1e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 09:44:46', '2019-10-29 09:44:46', '2020-10-29 15:14:46'),
('fa9410d2e58eef5bd9823d7a32b2749a0c6959876a6e3b8ce870575304a5cbb0de9d4535b1552122', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:01:53', '2019-10-29 10:01:53', '2020-10-29 15:31:53'),
('b35dc3dd8f258f4fd704c97e8136e8dc9b04176e0e0a15fb4be3bd334c535451ed27afd489747b53', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:05:23', '2019-10-29 10:05:23', '2020-10-29 15:35:23'),
('3a3ce291c6726e4869788433031704c95a61b12a7324ec54c62521bac7720478d399134ddd71965b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:08:14', '2019-10-29 10:08:14', '2020-10-29 15:38:14'),
('ad7d9b80e8bdbf8ad4b77667b6130a4504c2e297a2f657147ba1fc956e71cadb656cf87035ff1a5d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:11:32', '2019-10-29 10:11:32', '2020-10-29 15:41:32'),
('6b310e0e9217e44a5991f823b5bd6803b64896354e488832b80271d146cd3d4ad73373ed0b042a79', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:13:10', '2019-10-29 10:13:10', '2020-10-29 15:43:10'),
('48f70523f66fc9630c946464a4e16855a39bea7dd528b42057aa07e1f374fc953ef9a23370148eea', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:14:32', '2019-10-29 10:14:32', '2020-10-29 15:44:32'),
('6b7f5d2f8e3e3e3cbb59e15c7fa39317e2d694c61d680ce12dd02a4d060b68ba3b393b6dbb6e9fef', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:15:44', '2019-10-29 10:15:44', '2020-10-29 15:45:44'),
('a23dcfc7a6cffaaf6c7fc16b72f9e9eb0064b0286074cf6ea768fab9b4a1dae03d0d5e69415a70fc', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:20:56', '2019-10-29 10:20:56', '2020-10-29 15:50:56'),
('48ecf32225a25ce420ea082722d09e7b111e4a08274bce3a35e7df2815bbb0bf69b3fba26d75b865', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:21:29', '2019-10-29 10:21:29', '2020-10-29 15:51:29'),
('5a21b4b5916f83d3830d026e10ff8d562004e5431fddf6012d8ba823d3515b135fd4a5b57b1696f2', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:25:12', '2019-10-29 10:25:12', '2020-10-29 15:55:12'),
('7dcd055b1a9670b9c0fa7214eaefc9b688b0e3e9797a49c88397ded286a3678e163d16a4de309cd9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:29:53', '2019-10-29 10:29:53', '2020-10-29 15:59:53'),
('ec19310dbc32b31687caabe2e4cb5ef2ef332485a5595581d57ed4dfe0e849e7e2a2481dcee9b3ba', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:34:20', '2019-10-29 10:34:20', '2020-10-29 16:04:20'),
('363da1a69e12ba172c19307b13d467ba94396b68d6db3160a2efe9172ae26991716370eab24cfe9c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:42:44', '2019-10-29 10:42:44', '2020-10-29 16:12:44'),
('3dc3d07e7580f4f21cc3c50231cf11837cfdfaae1bb56134ca2741a60bd8d3d242777f496c24732c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:44:10', '2019-10-29 10:44:10', '2020-10-29 16:14:10'),
('4cd1443c60d2c2e0899c43d315f6bbd78ca811c4ff7e01a04733f3a536441e96e7940f00175053a4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:48:24', '2019-10-29 10:48:24', '2020-10-29 16:18:24'),
('0a4c7eb88009dd90764e4f1844c8d5dbe5fa019e30f5b08d0f3032c29752aa8cce55d63b2dae8f0c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:48:53', '2019-10-29 10:48:53', '2020-10-29 16:18:53'),
('71cb1e61f740b2db08cabd0c84afd64cf8d508b0460b69f38a957fd425bbc4ddba92044c3f42ce83', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:51:57', '2019-10-29 10:51:57', '2020-10-29 16:21:57'),
('b6bbe81ce2ad7e482bc82cb90d67f011681ca2234c9ffcd45a39eeb7d278e97343bf166c7056181b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:53:48', '2019-10-29 10:53:48', '2020-10-29 16:23:48'),
('16314a6d6dc7aad0c5084cbf95c82fd6bebf2dcd0490cf246c88dd71cb5cb51c5025314e1084c757', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:55:02', '2019-10-29 10:55:02', '2020-10-29 16:25:02'),
('ebae4ead4a9a7dd09285755621f63eb9be03275f4969bc1298b53e21e4dd4a8b6762415eb6558525', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:56:51', '2019-10-29 10:56:51', '2020-10-29 16:26:51'),
('7ac26a20e47ddd5df4c5cf7863e4940f513617cf1768394a7ccbf68ac0b85d53003cc83169cf3c50', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:57:13', '2019-10-29 10:57:13', '2020-10-29 16:27:13'),
('4345b4fd7ba08b81a426062d13123a187ec3cc937bd82d7a475fa605ec412de8053df827b63d0b04', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:58:51', '2019-10-29 10:58:51', '2020-10-29 16:28:51'),
('aa3b9afa1d06a4260672744b54a6847ce08c47bcab3bac26840495a435d6a126c63d9cdd190d4984', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 10:59:44', '2019-10-29 10:59:44', '2020-10-29 16:29:44'),
('ffced35acc2ee4ee57455a7aa5219b0ee8b65443fa7a9acfa65b410534fb03ad2100d78f974c5e94', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:02:44', '2019-10-29 11:02:44', '2020-10-29 16:32:44'),
('e6967f9fc5a1899ccad4446dc06064026bf4d45c138792073f392e68e951a3841b2f9e7cd0b03cb2', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:03:08', '2019-10-29 11:03:08', '2020-10-29 16:33:08'),
('881c130f9640880ccc037fe71d649356c0a274fc4ec99016c9049c7cc51396a52d824f6dcd8ec872', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:05:59', '2019-10-29 11:05:59', '2020-10-29 16:35:59'),
('83ffb88e0957f50015faa13ab2791eeab4241858e40ec4df454c3352f7482fbcefd4b1119d466afb', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:08:41', '2019-10-29 11:08:41', '2020-10-29 16:38:41'),
('73ec863c130080c503c846e3a7b435286e2a3777adf3061324e29613fb6c0aa776732bc1cd91256c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:11:00', '2019-10-29 11:11:00', '2020-10-29 16:41:00'),
('13365eb471d603cb1174aa765430462dc51f292f102cd15d56bf7d8020d3451a334828fc6f5f16f2', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:13:19', '2019-10-29 11:13:19', '2020-10-29 16:43:19'),
('a3f539832e90e2785288e48f92c465374a8a372c1bf53c1bc1d7fd9df59686bd44631e2205809969', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:19:13', '2019-10-29 11:19:13', '2020-10-29 16:49:13'),
('2766b63beb10b5140b7d542021419677239fddaef6081ea7c6d9d51490f1a353894990604910d6ad', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:25:51', '2019-10-29 11:25:51', '2020-10-29 16:55:51'),
('fd2d6a9fa7003e95afe6d069662ccc6672ed2114b35e5915a15eeb166a83809bdfe357ed2d51c6ff', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:27:30', '2019-10-29 11:27:30', '2020-10-29 16:57:30'),
('00de10f2ac0307afe4fe79ef2fadfe6de8e375f8793ed1e9b3837dec04dda56d297649387d57ec10', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:42:52', '2019-10-29 11:42:52', '2020-10-29 17:12:52'),
('8c2ffc1ef383121c05d6453b4393e4149392e37449d458b0920d7408773c38c12621cdd66b9b171b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:44:39', '2019-10-29 11:44:39', '2020-10-29 17:14:39'),
('bd5f296c607d6d6e19cb5bac3962d3567808612903d2bd548faa8b6aab2aa05cd176943b804c31ac', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:45:52', '2019-10-29 11:45:52', '2020-10-29 17:15:52'),
('fc2e2f1cac7d8c7389a263fd9e77549e937bc4c1343e1f9d2eafe000815532264db5d9cc1bd4693b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:51:18', '2019-10-29 11:51:18', '2020-10-29 17:21:18'),
('1c123f1cf9fa42fcd50d15a8742b033f4aed64900882773fa9b3df9e6e02aeda501b9dc9f4dd74b3', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:55:35', '2019-10-29 11:55:35', '2020-10-29 17:25:35'),
('945cc9d05e06e9b25844114a67f51665eae3abad3a61114718b50fa23d9eb707ccc69e09af6a37b0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 11:56:39', '2019-10-29 11:56:39', '2020-10-29 17:26:39'),
('b0957d8beb5e8e597fddcb10603605d87addc47ef2e79f2dfbba08f53f93744fc351c204f823c66f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:03:03', '2019-10-29 12:03:03', '2020-10-29 17:33:03'),
('3fbd413b3013a38a536b0ff999588484648c3f731e2fce80de65ab34c5190c54afe85c1be131d33c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:03:21', '2019-10-29 12:03:21', '2020-10-29 17:33:21'),
('1981145ced3b38b26504368c88f0d552cbebaaed38af892db0c4474a7b578e2f06dabddbe61ea3b9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:06:33', '2019-10-29 12:06:33', '2020-10-29 17:36:33'),
('dcbe7a53bf917bf3e44b247624697d59cd29d9ee1b44668c5636645f3b5fc3dc44fae1f7378cac52', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:07:29', '2019-10-29 12:07:29', '2020-10-29 17:37:29'),
('152ecf707f4729c3d3b338337cc1db6b0c3dd117ec9fd24d29873de09f236a2551dbba2cf1a28d52', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:13:29', '2019-10-29 12:13:29', '2020-10-29 17:43:29'),
('98c7b0ecdc0221b21e00489165db6eb29d27a5dafc112f9789554d25eccfe9adbbfd1c4ba74bf1c5', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:14:42', '2019-10-29 12:14:42', '2020-10-29 17:44:42'),
('9b1f7a2b564104138b37b54d6a513ade7b9cb3b856e8df9681f80360e90737e9a36f341f3c15d213', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:19:26', '2019-10-29 12:19:26', '2020-10-29 17:49:26'),
('1683ea158aff00f2404d333dbb08451dae7bc0d990b56e01262dc7d8b016233a9a5b2361b8d22621', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:20:42', '2019-10-29 12:20:42', '2020-10-29 17:50:42'),
('101821b145ef9315920afaa07a93e536940f95f6d0a25bd6b1424f82c4cc35f4b1e3fde7b4f2a39d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:24:25', '2019-10-29 12:24:25', '2020-10-29 17:54:25'),
('c3aa80c586d3dbf9a3b332ab5c667aeb520cfaa4de8ecb3cdce658ecfc1f475eef8a10cb092e21b6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:24:56', '2019-10-29 12:24:56', '2020-10-29 17:54:56'),
('250eaa2da83e94854a7ad9933058444300485138cfb15f94248fe4118fbc0406caa9edc3145f9b92', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:27:59', '2019-10-29 12:27:59', '2020-10-29 17:57:59'),
('565115834ffa6ea47acced394c4e208953a67b4f2321afc69e2b16ae15bee1e9f9e0f87d188b620f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:29:16', '2019-10-29 12:29:16', '2020-10-29 17:59:16'),
('a9d4e4258674a178cd96a50779ba7df8c0e2568dfddb5a5a2ae1924085f18af9f7b1379f3885ccb5', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:31:47', '2019-10-29 12:31:47', '2020-10-29 18:01:47'),
('434ad84af7260ff6e6658f53b7dd7d4d2ab6cfcfef8f47ba5b217e6d9c7bb7d14081746ac4b41c3b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:39:21', '2019-10-29 12:39:21', '2020-10-29 18:09:21'),
('71d76adb3f0f428608694bceaf67ab62ed94885d74ab87edde2dd7cbf548515d6033d076e2e1bfc6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:39:47', '2019-10-29 12:39:47', '2020-10-29 18:09:47'),
('3aed39720643911f09737a31784f6e4c0c278162c535c80be94ea33bd4816389fe35214672d2aef0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:40:18', '2019-10-29 12:40:18', '2020-10-29 18:10:18'),
('6f7290638a077eada96fb8d0618b1294ae9d928a3ae04bbcf5efa32606eb9059ef5b0646898abed0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:41:34', '2019-10-29 12:41:34', '2020-10-29 18:11:34'),
('9e1da61a8c1e112a04a2a5978b7b9056bfd7482592435d3ac356ef529132884c7267adee48c40035', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:44:16', '2019-10-29 12:44:16', '2020-10-29 18:14:16'),
('a6c59b9f6ad86576c1f9759d36f89e20c1c86cf62ba004b54dbd0783c013bf541e6395002d3e1b9d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:44:44', '2019-10-29 12:44:44', '2020-10-29 18:14:44'),
('d8356705a1c932fdab2297cdcb637554168a0e090b97aa0b5c20ff0612fa64dfdcc90fd0153129bc', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:48:58', '2019-10-29 12:48:58', '2020-10-29 18:18:58'),
('9b646835410447250ff459dc4eae48c3c5d855177117d7bb5a1c5d65777353932f43fdbc705657d1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:50:24', '2019-10-29 12:50:24', '2020-10-29 18:20:24'),
('477fd8d50ab67dc6aec8948e7a700c1cda626c0e4ed955464d022fcb3412c874cbf925dc606263c8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:53:29', '2019-10-29 12:53:29', '2020-10-29 18:23:29'),
('9b47fc60340d5dfb991910e10c02932e75d0de2602e38a681a1cf78b176a2f57aeb27fda747af100', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 12:56:12', '2019-10-29 12:56:12', '2020-10-29 18:26:12'),
('dd44b54a95887b23ada481be5e070b0a945c44368fdc00c729aa5d3ee42178715806a7cf79a83284', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:41:19', '2019-10-29 13:41:19', '2020-10-29 19:11:19'),
('7441c3ef256b08790682af63b144e2c0aee4d633c4a2d6b96d19fc6a4b14afcf44549afa49c3fef1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:41:22', '2019-10-29 13:41:22', '2020-10-29 19:11:22'),
('25e09e58f8b7477d695462c4b1e690f5955b8a7e4ba581cab6b569a208e0360c67f51f8424276a3b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:43:12', '2019-10-29 13:43:12', '2020-10-29 19:13:12'),
('7d042f78e987e3ddbd64bafd24b44289d39ecef369d0a471ab988992eec6bd94cd4a1896b7c10836', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:49:45', '2019-10-29 13:49:45', '2020-10-29 19:19:45'),
('acc4ebd0fd277abad871408398afbdd3f96a22e9ed16393fac6bf807ec179f1ad741b098bbd3799d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:51:05', '2019-10-29 13:51:05', '2020-10-29 19:21:05'),
('6a7a15a87fbf02a9057a8cd9171d82bea1be6a958e0cadef925c5466f431a0bd862a3ffea59447e8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:53:39', '2019-10-29 13:53:39', '2020-10-29 19:23:39'),
('f64d57c6b7561f233f4e45b5a2b8807fdd16818edf4946331f00e64ca815bd151e222b77026fd1c8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:54:19', '2019-10-29 13:54:19', '2020-10-29 19:24:19'),
('889ddb9747da0114bd8fbd7bcbcc1d21ae09418c4b533a1a95ec61a766025f64dcf8cf748b97e559', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 13:56:39', '2019-10-29 13:56:39', '2020-10-29 19:26:39'),
('04cc14d5e31b38f8f1618eca48321330dab4798e811d689e789d22550c3fc4de6cbd31c7b5559430', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:01:22', '2019-10-29 14:01:22', '2020-10-29 19:31:22'),
('c9bb6b6362f00b4e147d90a2f59f7ed42957441f44955fb2af8ae63d088bbec2aad255043bbf062d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:12:42', '2019-10-29 14:12:42', '2020-10-29 19:42:42'),
('d37e4a12fd547b9a9cc8e1314b4697668baf042c3ff4d1a1678a4ebcf121a46fc5529616ec353571', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:13:09', '2019-10-29 14:13:09', '2020-10-29 19:43:09'),
('b17f018f232e2405d0f767402e736befd800c897939c98a1c07682811ac7767f972a0b1921561e22', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:14:37', '2019-10-29 14:14:37', '2020-10-29 19:44:37'),
('d6c9a49658e547cff639359f9e54199b130924d8321998c11eaf6c5253a35f39cefc9f917e3f62ca', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:17:38', '2019-10-29 14:17:38', '2020-10-29 19:47:38'),
('2f0347e93a22866b81539151b05844860a9a00f6b330cc684a6da629040d313cf2ff2896c9d27bf4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:24:15', '2019-10-29 14:24:15', '2020-10-29 19:54:15'),
('b1b682ea80d3644141b6154c0e95831d3aa38a522cfec8814821ad8f8cd3283b6cce0c178d325f34', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:26:49', '2019-10-29 14:26:49', '2020-10-29 19:56:49'),
('6b3795645bd086aa2858e719358df8c081580a07628363183aa1ce6a223c5edfc4cd20f4c28f9f38', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:28:56', '2019-10-29 14:28:56', '2020-10-29 19:58:56'),
('b44df508a09f4143c9e354bf0f66a9738a35a36c052dbc600bf77c60079189ab4faafdab7ef3fba0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:30:12', '2019-10-29 14:30:12', '2020-10-29 20:00:12'),
('818be4f4fd440f246b83fce9724d5f79aaeaa1bab3b667372ae4c54e1d87578d9469056cfc608f5e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:30:32', '2019-10-29 14:30:32', '2020-10-29 20:00:32'),
('f12a2c62295bb89b64235c6f2433b8c757ddd444ec0ef963b80e70ac8cd15e23ca2ac2d01d432887', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:31:46', '2019-10-29 14:31:46', '2020-10-29 20:01:46'),
('19cd3485fb4042beec489f015db989bec9d2df493df79d7d7332358af9d0b83ed870840910f694be', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:32:12', '2019-10-29 14:32:12', '2020-10-29 20:02:12'),
('27b6d69997ac3835842eb73a1f1ff272c53082c35fefeb7bafa66846db6a6ae75234ef7af543ca1e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:32:42', '2019-10-29 14:32:42', '2020-10-29 20:02:42'),
('b847235147ae8599985bb50a9d49e3ba2d6948b9b4108a6982ee7881ccd435457a3af5540d8f3e25', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:33:04', '2019-10-29 14:33:04', '2020-10-29 20:03:04'),
('e47b63b5e16f845f2c09fbec3cbfcedc8fbde612973873187d35a6b4ad1e1952414c844776fcb9b4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:33:57', '2019-10-29 14:33:57', '2020-10-29 20:03:57'),
('cf421277e8a29a13e873f1c461e21df7553edf2481202931aded0b6bad72650babe8cdae8d214dc8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:36:30', '2019-10-29 14:36:30', '2020-10-29 20:06:30'),
('e1a8f8e4e1c3d441ea2d0774f08cd00f7da4b481ec98ef6ec94ed812ea643a0a69fe86deba57dd0f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-29 14:36:59', '2019-10-29 14:36:59', '2020-10-29 20:06:59'),
('4f2d684199f624a5227021003f558be1a3da82b178826337a707ab2dab9b8d8d357387d83497c7ab', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:13:26', '2019-10-30 10:13:26', '2020-10-30 15:43:26'),
('0c7a0252a226a90cd078a164f5f29f1d9cffba3a7a387f1845c43983a80eaedfc860330e4864a4c1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:14:11', '2019-10-30 10:14:11', '2020-10-30 15:44:11'),
('c90b86fb12ff005cf8bab74930f735ef055b7d90e441f08f572f363ac6602243f5da51d33cc8347f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:16:02', '2019-10-30 10:16:02', '2020-10-30 15:46:02'),
('527c29ceac51437140acb95ca017c76fc0ba326b6fb8553bda4f31b29ba00a053e4ce5c7ea920341', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:17:10', '2019-10-30 10:17:10', '2020-10-30 15:47:10'),
('937b1f681647c4a13a2866b323c377a03a15c4abad9f4595bd8abb122efb59775d0629542815e2e7', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:20:17', '2019-10-30 10:20:17', '2020-10-30 15:50:17'),
('5bc8f49701630928dded8e96edde4e69d14c7bbf16d3949732035402b1c84f80d33b2a2e0026b8f8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:27:25', '2019-10-30 10:27:25', '2020-10-30 15:57:25'),
('49359f12b7b76a2d332c2349d834f23ab7aad4cc599c3b9997003475aa8c47eecdc69c716bb899a4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:32:56', '2019-10-30 10:32:56', '2020-10-30 16:02:56'),
('7e4eafffa54c47d5fca9e831b86f8d35bef457a676be8a4bf0ecf6521ecd1cd861830205b57fb657', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:33:21', '2019-10-30 10:33:21', '2020-10-30 16:03:21'),
('f79fdd77ffbbdabbc413381e23adac5dae67d98a20bbf73fdbe847a2e405ffd81722aa11e8cefa9d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 10:58:43', '2019-10-30 10:58:43', '2020-10-30 16:28:43'),
('9650603277687779fe4417e9accdc3fbe3d0978dd92435ac44a5b13042323837dd0c20844ff738aa', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:04:54', '2019-10-30 11:04:54', '2020-10-30 16:34:54'),
('deee8c5af6d50828953881c08d6f3308807fb86a5339eba37410c11384f54cbe2ca3d8ecebbe7c2f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:23:56', '2019-10-30 11:23:56', '2020-10-30 16:53:56'),
('7eb67d4f204295dd946581c54f7f881408dc9db7e0fd81f8722ca0bc02ad8527020415ddc4128172', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:25:19', '2019-10-30 11:25:19', '2020-10-30 16:55:19'),
('f3b88a5d7538b93e32b51553cdb65bc12f426bf9fe428bee9b3a94a2398e76ac162ef6d6964466c5', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:27:50', '2019-10-30 11:27:50', '2020-10-30 16:57:50'),
('df1945ffb726df5805bea55bf64486f87d154b299d14f1ade3ced46342f986690a04ba8f8b997659', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:30:27', '2019-10-30 11:30:27', '2020-10-30 17:00:27'),
('0bc7229359c89af52f583aaa6b56eb6226bc17405cfbb0c73d3b6cc664ee33c8105f5ae1e6b4b226', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:34:03', '2019-10-30 11:34:03', '2020-10-30 17:04:03'),
('0d84cd4e66c678e4a096ed476ee88f16918323e7cb62a90de1ff73410e9680486486e4b307fcce0d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:50:49', '2019-10-30 11:50:49', '2020-10-30 17:20:49'),
('b44fa0b1683f7c68fd44862b6cf02be0ff3c4dd3f8689d5be113cc951fa2af51b1911f3f17b50b48', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:53:38', '2019-10-30 11:53:38', '2020-10-30 17:23:38'),
('7bdd151efbbd3e09835019ea80d5a187bad857ca50ef3007580a42c23c8de4f7c35caa4b9a16e99b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:55:31', '2019-10-30 11:55:31', '2020-10-30 17:25:31'),
('83ef1f2232a04c30f7680b31be01d8b0ff8a33098fb5f37b8d986984e441ec8b2bb74b652d9c4e8c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:56:42', '2019-10-30 11:56:42', '2020-10-30 17:26:42'),
('126150fbc2ced40a77d81eff2afa63f0bafe68ce0ec19420a6970d20ff0b82cf371d455eae73b9c4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 11:59:27', '2019-10-30 11:59:27', '2020-10-30 17:29:27'),
('2664685d6bdd990f03a8f8f13d917b2c7c9913eb321e1f3c055fcc952d467e21cdeee066802a1864', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:03:09', '2019-10-30 12:03:09', '2020-10-30 17:33:09'),
('d982c96e15d304d408a36865ed18fd2a3fd9be7ee128ba446c786ef998d7cadf6f6c2d69e27c4707', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:04:14', '2019-10-30 12:04:14', '2020-10-30 17:34:14'),
('237979819a3d9ffaed84f3abcd4497d7849b268c98e98821cf3fc0bf3c75f50bad765c4056f4b40c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:05:10', '2019-10-30 12:05:10', '2020-10-30 17:35:10'),
('a91d76c08c424bcbf46950560e023d22d08c76123931869f49f9d448fcc90d92421650aaac60af82', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:06:14', '2019-10-30 12:06:14', '2020-10-30 17:36:14'),
('0ba4a57a6e9c3d416422724acfefd5d22e74fe3dbc4ae05d2332089a739f6489b9007c301c01b3ed', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:08:09', '2019-10-30 12:08:09', '2020-10-30 17:38:09'),
('e1fc20723775f57e771110e556fc3bf24a195ae47ad635d5f803bfe03f7e9efc9462146038c0c4aa', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:24:27', '2019-10-30 12:24:27', '2020-10-30 17:54:27'),
('dbd158db235e7a7a5ee298ed135e99a3ace01ec4e6ec65a8c30e4621ed31ab851f1ba3712c2359a4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:33:37', '2019-10-30 12:33:37', '2020-10-30 18:03:37'),
('8c3280e22706b7c26563ceeaf091c8c5722514293795998eb65e42ed952d3ca7b5be3120eacf303f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:52:27', '2019-10-30 12:52:27', '2020-10-30 18:22:27'),
('62a629f85f872bbb6dd8e215844f08dbac7a6fb206b078bdb80704eb234ae0caba03c8676f4b4fd3', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 12:55:56', '2019-10-30 12:55:56', '2020-10-30 18:25:56'),
('e09c5ad5ab8f71c3d6ee74eb769d7a0cdd7e1dc1c7e3e8ae774825809e527422bdc93917dfbf4ca4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 13:00:21', '2019-10-30 13:00:21', '2020-10-30 18:30:21'),
('13fdd67fb8e9ade68ca6b908ef32c3b6339289fdb4b0d05d6357fce036077248b5a2b21b2513b0b1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 13:01:36', '2019-10-30 13:01:36', '2020-10-30 18:31:36'),
('e1e4bdde35210f33fc3eb8a07f23a8ac027c6fc1655fd1179d84d690bcb647289b9d197e5d1f5b79', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 13:02:45', '2019-10-30 13:02:45', '2020-10-30 18:32:45');
INSERT INTO `oauth_access_tokens` (`id`, `user_id`, `client_id`, `name`, `scopes`, `revoked`, `created_at`, `updated_at`, `expires_at`) VALUES
('b1c336849766e94a0c29fa39da55a41225b69cb4c8d82976cf0296f890c21c93f261a7076de41007', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 13:03:24', '2019-10-30 13:03:24', '2020-10-30 18:33:24'),
('d652fdf5ae49a71d1a8f6754ee0c5e72e2dc99d75abc3e7257841de2fbcc4c164655f3ab99f40305', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 13:04:22', '2019-10-30 13:04:22', '2020-10-30 18:34:22'),
('b4dd35bcfd19918ae61fa7d79b094d0b5d05027a854d9211e35c208c70a026d12c46c21d16017349', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 17:51:21', '2019-10-30 17:51:21', '2020-10-30 23:21:21'),
('72a69e686383505ac0559c8454a16d192d530b4f552e94181adcd6370791c41f71da67297071dfe4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 17:57:18', '2019-10-30 17:57:18', '2020-10-30 23:27:18'),
('adac50b6c2f45f4472a30c821eb52b84e909a637e2b70c480211e90300084c8b64d469a5fd9ae259', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:00:31', '2019-10-30 18:00:31', '2020-10-30 23:30:31'),
('c3575f656c8a4dbccb0a90d5c6066ed8f246fe2c1127c90f794e478b89b7dfe1c25f4b079bcd0dfb', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:03:42', '2019-10-30 18:03:42', '2020-10-30 23:33:42'),
('cd1d4370a900f9dc2183ebba216ff5410224911ca46d18909cbbba66656092cc2dba8854892a6636', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:10:51', '2019-10-30 18:10:51', '2020-10-30 23:40:51'),
('e83854bf288d0ecb7ab8c833a0c90e254cc5a09bf7a6b81396715201bb712d4d6e0c8bfda3888cb7', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:11:13', '2019-10-30 18:11:13', '2020-10-30 23:41:13'),
('583db4dd41e3dbb444b153da13d3cf48d8113dc78d42d5d5072fe35324f15d0c92fb9395e0dc508d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:13:19', '2019-10-30 18:13:19', '2020-10-30 23:43:19'),
('a1f37e4f8cf09211c8493a73490cb57f328dd0c353398cf38da5bef9dacf6be319348fb612150f3c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:13:50', '2019-10-30 18:13:50', '2020-10-30 23:43:50'),
('7168c2e2e4a2f189ad5972a35485c75a10de4f2bea7cd625dbe82264ce50a164697e2b2ff1e78249', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:14:54', '2019-10-30 18:14:54', '2020-10-30 23:44:54'),
('dc3da8895614fa948724464e33d2481bfdf11ff61df881d2ea1786f67021fee3bc8482842a43087b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:17:48', '2019-10-30 18:17:48', '2020-10-30 23:47:48'),
('6c0e610d57ef1dc22bd71d9df849abdf5d872cc05edec1a154fb3e59cc71c9f283d8e106986c7a34', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:18:10', '2019-10-30 18:18:10', '2020-10-30 23:48:10'),
('80599e5bc9a22b0543ff1597098bc89427dcca55665158bd90cf8496ca1c7b950fb05f15bbf3900d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:26:41', '2019-10-30 18:26:41', '2020-10-30 23:56:41'),
('926c2380d3d40668fae5731d4e5fbfe352db5d238aae0db437259cd4ff49f78c2330c6a89face81a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:29:40', '2019-10-30 18:29:40', '2020-10-30 23:59:40'),
('6c5906c5b372d39aec1dd8c9cb59b526f528164619d636a5e5e786cc2e179c3911027143c9e148a6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:31:27', '2019-10-30 18:31:27', '2020-10-31 00:01:27'),
('fc1315d9bed9c3a060cdd90ae33c2ed40a9c597745d58b228268d8139fcd82c46b1c115c49fd7f4a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:32:56', '2019-10-30 18:32:56', '2020-10-31 00:02:56'),
('e95c825fc6f5e002b02019ef6e136c12e276bbd3d4190a090a4b1f1c53a20ff9fcf8fad2aa0d0b35', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:43:35', '2019-10-30 18:43:35', '2020-10-31 00:13:35'),
('1d7b32e90f63e057914f09d8886d09e2e52baad8371f823a4749cd345e0a799254ebb6c53dd3c071', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 18:59:35', '2019-10-30 18:59:35', '2020-10-31 00:29:35'),
('ba25afa5fddd1471f960da2a602e6d201ce420dfaacb3f861bfdfe3ee60f1076d986aa8cb77cb0dc', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:06:44', '2019-10-30 19:06:44', '2020-10-31 00:36:44'),
('733086e8180fc06e42cc93264933117445baf682ca84b31f131d202fe414c8f930a5a6c8e6c5f066', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:18:21', '2019-10-30 19:18:21', '2020-10-31 00:48:21'),
('936562e223ea8d15d4abb4fa0b3ede887d6ae936511f507b72b74dab5670ad249b76b4b3bf916060', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:20:10', '2019-10-30 19:20:10', '2020-10-31 00:50:10'),
('08065c5ebef764740155a6e199bdfacd3887cb010c327d23d541af138609182364e1a945b899b7be', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:28:39', '2019-10-30 19:28:39', '2020-10-31 00:58:39'),
('baa8ec541e9162978035a924528b3ece9c596fd82c91f850c035fed2c6208a6d2b440042f6aef24f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:29:26', '2019-10-30 19:29:26', '2020-10-31 00:59:26'),
('e911983c85fe2dd0c2c5fae09ffb88c0b86196f7dff5c0cfedb583e406f8141e7ab9cccc081e9bdd', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:45:18', '2019-10-30 19:45:18', '2020-10-31 01:15:18'),
('6492294761b92e2e8157da396613be1355f820e50bc50a2e104a6982cd4b151f54b166eea3fd2a35', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:51:26', '2019-10-30 19:51:26', '2020-10-31 01:21:26'),
('b6162d7c3f09e2679016b147461a4465ee8dc4314d3d6bb54d32fbaa7ef769d670b729845f3de68c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:51:54', '2019-10-30 19:51:54', '2020-10-31 01:21:54'),
('924cadbfb465e01b45ad938e84eb8b5978732deddbd28f7d0908675b16946da32d9603c835a50548', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:53:33', '2019-10-30 19:53:33', '2020-10-31 01:23:33'),
('dbdea178f489fe4994d3b6b1d713c87f834e86eea287edee4a9432c5b3f066e803f6a1b93184a071', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 19:54:34', '2019-10-30 19:54:34', '2020-10-31 01:24:34'),
('c6f1cc4013b3fcb1730935f5f722bd9242890d749223d65e46b61dc762529693060b88d259ab9ab4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:19:16', '2019-10-30 20:19:16', '2020-10-31 01:49:16'),
('c4485655ab2c56b6db9de37493d1dea20d70abc3eb9a83a6e98d1c59ea4f6801ebf5320d81671835', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:25:14', '2019-10-30 20:25:14', '2020-10-31 01:55:14'),
('e830d60f4114b4f39b203069a9e34ee1c8e843bc14b0f935efc909bbfd4210766bf9ee90d5b27fd9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:28:57', '2019-10-30 20:28:57', '2020-10-31 01:58:57'),
('157d68614b25857540dfddc98d4a8a0ba67128042862b6a85def6c9b9e161ac7e9a2402f56cdcd55', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:29:38', '2019-10-30 20:29:38', '2020-10-31 01:59:38'),
('458ab9a9a3219dc4fe0af66d0d358df01913b48dacb21f984d6b32fb1ddb54e60ddb61e95fb60bda', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:30:15', '2019-10-30 20:30:15', '2020-10-31 02:00:15'),
('46eecaa35b3c4909e84fa7d14625e6c7ec2011fc182dc44665f78cb11e65d06e185a22577593c959', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:32:15', '2019-10-30 20:32:15', '2020-10-31 02:02:15'),
('30c68c54eddd7f7c8735c833a5e62d720e73daeaf9e21121ef02f9db11c9978236532fca14ff0af1', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:32:46', '2019-10-30 20:32:46', '2020-10-31 02:02:46'),
('6076843c1e94cec07fa8951e7083c885fdbd9c7c6086ac70da36574ac0ff3e1b5b057e3977baee59', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:33:48', '2019-10-30 20:33:48', '2020-10-31 02:03:48'),
('12a0f853d9710a2dac822e2167b3e3b6e447cbf2c00d6d233fd74119dacd8818d1dec6d037316e19', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:36:35', '2019-10-30 20:36:35', '2020-10-31 02:06:35'),
('1c04aba52114127ee6fbb9cfde1d25f39cec705415319eccc81512036d360d2ab0f1b25e0cf2ec9e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:37:07', '2019-10-30 20:37:07', '2020-10-31 02:07:07'),
('5d4123f422af5918f3cd47c6e0c4f980acd3a745465af2795b5a992e361d42872123873d27349940', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:39:53', '2019-10-30 20:39:53', '2020-10-31 02:09:53'),
('ffaf7b37323def94be3caf208b68f2a0be72771c5187d399570ad0b49cb731f778de24be2a6335d8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:40:51', '2019-10-30 20:40:51', '2020-10-31 02:10:51'),
('23d7ff88f4c5120584574c7f51406ea00c1a339d68b9103d0f1db02e59f356c3559f124bc54644c0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:42:42', '2019-10-30 20:42:42', '2020-10-31 02:12:42'),
('ef55454519f798c1b4de7b2b02927e1d954a521f36175a0f48b93103e69bbb00ba80a1053cecf17f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:45:27', '2019-10-30 20:45:27', '2020-10-31 02:15:27'),
('8685c8b8ed5a03c1f8556507d00df247ecaf15a1ef0acb173156f32689b883c95bc7e6db636af0f0', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:48:26', '2019-10-30 20:48:26', '2020-10-31 02:18:26'),
('b38394c96a00aba55455030baad56d4b52ee74bcc94d292ba14a37af7dbc3c56a6d803bafa8e74df', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:51:02', '2019-10-30 20:51:02', '2020-10-31 02:21:02'),
('17e47e0d5f23591858195ad73b5a2cc0840446fa0034be4307773ccbd978d234b1db62a670ca0b51', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:51:47', '2019-10-30 20:51:47', '2020-10-31 02:21:47'),
('1ee628b4c023b101cd82fdfc0a6c020c5d64bc14be2a63f4ea66b1627833837556ad5ea0c288b947', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:52:36', '2019-10-30 20:52:36', '2020-10-31 02:22:36'),
('a2c0a22559b8253ad9056365b03f292a460a7fbdfc30732a42aaa6e718541e9d283624cfc903281b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:52:57', '2019-10-30 20:52:57', '2020-10-31 02:22:57'),
('372c12e1bc4fce5accfe812f3ba79295f8e1284441feb5136a9ba2bb3602b526dcd8d6d269ee0bf4', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:54:41', '2019-10-30 20:54:41', '2020-10-31 02:24:41'),
('175d560bb8af3bf412c9b41c919fa0a2a482a7215db18a3d0e8d285cd60d3ce8fbf0db922a04df4b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:55:30', '2019-10-30 20:55:30', '2020-10-31 02:25:30'),
('fdcd82b0f051e5e74f2eaafd22f05f000733acec9b967d84d2fa733465f6928f954b1df8564eee52', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:56:16', '2019-10-30 20:56:16', '2020-10-31 02:26:16'),
('32cb356f2b9ccb70f5d0247ba53d70e846b408ff63448d3af0dcf1f1d3118d74a09142f020b94dc5', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 20:58:34', '2019-10-30 20:58:34', '2020-10-31 02:28:34'),
('32351e16f4f5b7634a68fbf5a4cf3d5eb29b636c5a771b87c9812bec4ff0f607c2bd630ff44771bf', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:00:13', '2019-10-30 21:00:13', '2020-10-31 02:30:13'),
('049514a62256eb7c4d8d7bee1f2f8479ddb6a91d8ad577b2ef8a6254d8ee91676fa512455e6d4a1a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:01:33', '2019-10-30 21:01:33', '2020-10-31 02:31:33'),
('581bfdc3e72b6c01012f827fca3e5bd16e15a5f5cebfff248247be57e234d8a601b736cca7aa9866', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:03:54', '2019-10-30 21:03:54', '2020-10-31 02:33:54'),
('827ec8361840efed514c3a35badd2d68c46c2c2a95985ac7d90bfcd826358a59f6cdb30cf4c7ee2f', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:05:49', '2019-10-30 21:05:49', '2020-10-31 02:35:49'),
('8a3d7ef1b8ca41600ef9abf52d4cf928d0da3b8017c51ad7b69441f6bf0497ba8b55c9079c07ec04', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:06:16', '2019-10-30 21:06:16', '2020-10-31 02:36:16'),
('278c0756b4896073a5a84699c928953d509158f63333dee9013966e0ed2de2434f671d2748af31b9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:07:22', '2019-10-30 21:07:22', '2020-10-31 02:37:22'),
('7a03d2cf0afb6f6d6901ae1d04b8ba42ffb5da65a0d821ff4c33139ec98bbac9dd0ab5185700ebae', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:07:45', '2019-10-30 21:07:45', '2020-10-31 02:37:45'),
('f4a03ef47e7b7d8f69a00fc2324d83d3f85f0d6e4d252702113e8af7f4a9dca474bbf9e078d0e825', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:08:39', '2019-10-30 21:08:39', '2020-10-31 02:38:39'),
('14540dedcb0b3e94f4553a6529a63a2a873582c9df85669b7b44674ab9ddc6850ab36403281e0a97', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:50:42', '2019-10-30 21:50:42', '2020-10-31 03:20:42'),
('1611cc9565fa7476fb1c97bc85fac70951b531bf0b88ec0d2c1d477fdec320541cd4cd8b3dac3b74', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:59:03', '2019-10-30 21:59:03', '2020-10-31 03:29:03'),
('13151cbbda83fee93cb69c622f71d1bb5bf65bf4db2e0e3742a839331f796de544511bff7534956a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 21:59:52', '2019-10-30 21:59:52', '2020-10-31 03:29:52'),
('95a8995900348ef8b2547375472ddf80a19ecfc6ad3367c2fcc4d742da07b8daea0bc0bb151df102', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 22:32:06', '2019-10-30 22:32:06', '2020-10-31 04:02:06'),
('d67d41bd56b541c450db1def6f91f66f6259c0e46fdd53884e876ff96937d1f4dc924b312dfcba74', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 22:34:15', '2019-10-30 22:34:15', '2020-10-31 04:04:15'),
('d7969814909cb2af43b1a93071f0e694607e681abfbe107faf843e36311acfd4b3c4696b8f74468b', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 22:39:17', '2019-10-30 22:39:17', '2020-10-31 04:09:17'),
('48d9ec05e56f9db94f32d310beaafbfc6ef4d30d230129c1899664482985d5c3f4f45f5e35e5997c', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 22:43:11', '2019-10-30 22:43:11', '2020-10-31 04:13:11'),
('bd558054fde68069b0d2dd20cb73670ab171e01c00ab2e33402f4f9b59da6c3670c8c7a01df1da7a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-30 22:47:24', '2019-10-30 22:47:24', '2020-10-31 04:17:24'),
('593192d095c5f8a8f4b6ec746f0883b9c0f48517afb64e98598ee4551cf3a3d4d2e88c454bfdc92a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 08:29:05', '2019-10-31 08:29:05', '2020-10-31 13:59:05'),
('d854ee2550c18dfcefe22d941351ecc5896d3b1d73c2836fdcc7313fc4e80dce68153eb3270047d8', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 08:49:26', '2019-10-31 08:49:26', '2020-10-31 14:19:26'),
('6d933f06432d61818af7c4548faacbffe27f34f9432f4c7fd2c35137568bd534141f92a62f2abf7a', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:04:07', '2019-10-31 09:04:07', '2020-10-31 14:34:07'),
('ec9320808acd01f2b8f0ac76909d86305f3baabe9d303dedfc581a595e09c6f200c631f2363321d7', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:06:37', '2019-10-31 09:06:37', '2020-10-31 14:36:37'),
('576e90dda620e1d748d25870e19a9363b0b33909ef261c0ff17d8727363cb774e15074cf9f9c3551', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:07:26', '2019-10-31 09:07:26', '2020-10-31 14:37:26'),
('0d649285552234451c59eed4e027a009e089bf9f93125a06ee894f6190d0bcb69d6733e3d14b34c9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:11:10', '2019-10-31 09:11:10', '2020-10-31 14:41:10'),
('e4171e71db08ae821456e7e9520ea5b363ae4b92d8ad748bcca167d345551f247f47a2246ec21a70', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:12:12', '2019-10-31 09:12:12', '2020-10-31 14:42:12'),
('addc39dd82248bd81bafdcc39da40b19fb3a0e791dcaf4b6fcfc887667a57a74cc0126820fce73f9', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:15:32', '2019-10-31 09:15:32', '2020-10-31 14:45:32'),
('c9463eec3220921ef110f09e42cdba19a4b439914b3c2c2f903217be2a1a52d1437d209139b743b5', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:22:43', '2019-10-31 09:22:43', '2020-10-31 14:52:43'),
('e5ced57fa6bf872f345090c6dd7cbdd2c0536ff1baee6f998e9d514b38390f6f716eb7ac24f10b6d', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:23:31', '2019-10-31 09:23:31', '2020-10-31 14:53:31'),
('f8a8547a4a357b7aec1d5d6ae29b1c52fca7c3b5ede15dc2ae94084230c66ade3f2604f0ec38262e', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:28:31', '2019-10-31 09:28:31', '2020-10-31 14:58:31'),
('879125e10fa35590c1eb2b9b18b25c0bd9c36e99913f93c1532b938c6472b45857e87eedca152404', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:39:15', '2019-10-31 09:39:15', '2020-10-31 15:09:15'),
('6c34a3076d779849ba5c85ab693aad92a6518665b9c0d1fbd98ae7397e6de6b670da18464849accf', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:39:52', '2019-10-31 09:39:52', '2020-10-31 15:09:52'),
('2ace455b76e608bc16a529d1cbeda02e3123042001af2323decb1d6e7b7cf820c75c4eb782ac6fd6', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:40:10', '2019-10-31 09:40:10', '2020-10-31 15:10:10'),
('b194f9bf2f435a3bfe468921d995fd955d283a91e736fed5c001b8d1bd84064a97751f9f7a882e58', 5, 1, 'Personal Access Token', '[]', 0, '2019-10-31 09:52:15', '2019-10-31 09:52:15', '2020-10-31 15:22:15'),
('ed5bc78b1fd286b42fd589be1ff72f1f98385a1e78fe043b9745a190f9da0d238cf9c2b6ab339d72', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-01 18:54:20', '2019-11-01 18:54:20', '2020-11-02 00:24:20'),
('5a97a057336742992307827c090cfb32b67ef50f247a7e6c786f55491e83cdd06fca94ed13aa707e', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-01 18:57:07', '2019-11-01 18:57:07', '2020-11-02 00:27:07'),
('36eaa648a0ee7118f94bfae96512cff1513c4a668b431d5a9c683f94d8706c6539a4bb8aed57cc3c', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-01 18:59:56', '2019-11-01 18:59:56', '2020-11-02 00:29:56'),
('a94685b8bf6facaa4407c83905ff1ff5deffa3983b3b6dfc2056cd34e6f645066c0f87fdbd70e67e', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-01 19:05:12', '2019-11-01 19:05:12', '2020-11-02 00:35:12'),
('9c89c2190d4381e8a0583eb0012ad54a6e25a311a136fb8b882547f59927c32d71e746ddf95f9482', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-04 10:34:56', '2019-11-04 10:34:56', '2020-11-04 16:04:56'),
('699ea0397f731b524bf79c538d036743943b0e88dea1f6a95df0fdd913299c7683867201cb91afb4', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-04 10:39:02', '2019-11-04 10:39:02', '2020-11-04 16:09:02'),
('97b9c6105afd4bc92f0af930490223ee53bcc34a89cf3b706ba3bea0517a1352e97f6518da83c61c', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-04 11:02:58', '2019-11-04 11:02:58', '2020-11-04 16:32:58'),
('ad701f569dfb973b33a1cd3e168ad3ffae14845e7e02a698f07a24f54264265384ac02e3fda1216f', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-04 11:03:01', '2019-11-04 11:03:01', '2020-11-04 16:33:01'),
('7d8a716f3ba69007812cd8f3c989e6073713e568c2c49cc813eb80eaecb73620edf2fc95c93fccf0', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 16:32:23', '2019-11-05 16:32:23', '2020-11-05 22:02:23'),
('c2b567701e090bc09473117817cfced0da91c65b55d0bac9715088c0ee36777608895cccb665cee6', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 18:48:32', '2019-11-05 18:48:32', '2020-11-06 00:18:32'),
('16c87e6545a66d60b21080ca45b639cb4e6ee124993bf6e9bc6243e01761f7bd0644aed530e589aa', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 19:48:46', '2019-11-05 19:48:46', '2020-11-06 01:18:46'),
('be7bed8da7d89061287641cf746e46115130391f1beef94e8d5161464a3279bc4788418125e1fc99', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 19:48:48', '2019-11-05 19:48:48', '2020-11-06 01:18:48'),
('8f0ecc1f789c76e2833223e2060a74f1116093e2d1ba4039b4d35f354a2a9a9fb76be09778e98b0c', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:31:50', '2019-11-05 20:31:50', '2020-11-06 02:01:50'),
('1a32d0ff00c86fa1153270ceb2d15f762e5c349409f01d80a47f03655152754db61acbfdf86ff5db', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:35:00', '2019-11-05 20:35:00', '2020-11-06 02:05:00'),
('0f75f7a9a0e2e5769addcff61c9a719f561884864231211b4b6dc0e44138642bcda3d886e65d9342', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:35:26', '2019-11-05 20:35:26', '2020-11-06 02:05:26'),
('f98d184abc2a6ed41ef96ef5036cc03f51d89137925e768c0ae49cbe47398705b7d21c466a9c3b6a', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:42:06', '2019-11-05 20:42:06', '2020-11-06 02:12:06'),
('d621bcb8c9840574c2bbac8c579921a3644f5a8b667e53c401e1b2d7cde2306be6f8192077ed0f4b', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:51:40', '2019-11-05 20:51:40', '2020-11-06 02:21:40'),
('85aa07cd047fdfb74b04826e4346a9a35a59fa5a696bcf370e9a467a33a0ebcd13aa1d56fb3fe67b', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:52:40', '2019-11-05 20:52:40', '2020-11-06 02:22:40'),
('1d4a57fdb5e94d18458623334a31517e9d4dd2245c8e0706633b8b16950e0beb059055d8b67fdb9e', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:55:24', '2019-11-05 20:55:24', '2020-11-06 02:25:24'),
('70f33e3bcafe53f94adae4577768e553b9c1ee0b6b39e7116e2df3e1b5ffbcaa129cd4a8c4f678de', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 20:59:49', '2019-11-05 20:59:49', '2020-11-06 02:29:49'),
('0a9abc4d28aeeedc6c49291f4edd41531493462b1ac62c2dc0fe999d01d1615b6cb2cfdc28608f07', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 21:10:43', '2019-11-05 21:10:43', '2020-11-06 02:40:43'),
('e13f83bbe8e5b926705774cd71549f402b81b1e2e40037c9dc3dc169f8461d5d0d6fb97962ca54bd', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 21:10:58', '2019-11-05 21:10:58', '2020-11-06 02:40:58'),
('895e690790b21ae163c2656389f4c8c6b28e2659d2c51572eb24852f0bed017b570d11cadf199931', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-05 21:32:19', '2019-11-05 21:32:19', '2020-11-06 03:02:19'),
('fd70ee5d2c80ddc0746bae1d1108505c75e99a0bca519a0221706b1ae2a25635f45635c5a69e2a21', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-06 19:23:14', '2019-11-06 19:23:14', '2020-11-07 00:53:14'),
('fe0aa06af82f5936600d0321abf93a58520432c32df10d6fec07f46cc1e4d3f6a8de7e9337d200df', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 18:09:27', '2019-11-07 18:09:27', '2020-11-07 23:39:27'),
('16cd8fe03c6dc591e08b8a74f321c28a191772ba00b1beae44a1de23c57130c9025757fb1e896838', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 20:50:59', '2019-11-07 20:50:59', '2020-11-08 02:20:59'),
('7d855452dce2603b2a33f9194e92c4d9fb17ce4de7bbdd5fa28a9b3cdfce78ab5605167282f89c29', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 21:00:49', '2019-11-07 21:00:49', '2020-11-08 02:30:49'),
('60837e76830e37f698e8361e8b3fe5fc578903e8f064bee4b040c39bb0dd6a63a433cbcaa0e9cdc7', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 21:09:26', '2019-11-07 21:09:26', '2020-11-08 02:39:26'),
('686da2a9294621a0598ec3a6686be039247b676259b7da50620f904c758808412025dc7b2c7bcd9e', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 21:10:48', '2019-11-07 21:10:48', '2020-11-08 02:40:48'),
('3f46e972f5f7bb7285220bd65a77e69d1a1d08cd83d00ae628af9a15309d1c5444158b6ed480d9f2', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 21:13:17', '2019-11-07 21:13:17', '2020-11-08 02:43:17'),
('8bc024538a9f360c3e319f966862d1dad4a7ef6269b9ae88681adda2ceefbabb5d47d6eddef2ff6e', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 21:31:25', '2019-11-07 21:31:25', '2020-11-08 03:01:25'),
('72460692aeddc73e79d89f0ae1ee6d7cf4805d9967a27813b41c85e3c06d7a512b5b79aeed0963ec', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 21:52:06', '2019-11-07 21:52:06', '2020-11-08 03:22:06'),
('1ce1833e0baf136279172d8bef89369688657ddcb3cc5248d3e0784c164c1f32e87a7718245a628d', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-07 21:55:55', '2019-11-07 21:55:55', '2020-11-08 03:25:55'),
('d9a54e84f18bb1bd864b8e2dfe5f27dcd63d489c51c85b2cff94e05a86eae854fb6cb662f69deeb0', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-10 09:35:22', '2019-11-10 09:35:22', '2020-11-10 15:05:22'),
('4a65ab9641ddd7ef800d0f51d3d86c23c9b593abc85b5fe848abd393616c16ae9c5e59e8c07e6278', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-10 09:35:25', '2019-11-10 09:35:25', '2020-11-10 15:05:25'),
('386bd34f7800903d76b9d486bfd9c765ce81f63029f6a18b70153d73854d742282be9380617758ef', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-10 09:50:50', '2019-11-10 09:50:50', '2020-11-10 15:20:50'),
('97731a281fe719e40fa65fcf4fb3e2486e42dd73dab17f5a418be906bb3dc9bbae0f5df9504c9205', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-10 10:07:40', '2019-11-10 10:07:40', '2020-11-10 15:37:40'),
('4eb6501074c79c71acf99c7c2d94043fb4e0542b7080d38dfd920d0d8946c831d9a3f00d7a31235a', 5, 1, 'Personal Access Token', '[]', 0, '2019-11-10 10:49:50', '2019-11-10 10:49:50', '2020-11-10 16:19:50');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_auth_codes`
--

DROP TABLE IF EXISTS `oauth_auth_codes`;
CREATE TABLE IF NOT EXISTS `oauth_auth_codes` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `client_id` int(10) UNSIGNED NOT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_clients`
--

DROP TABLE IF EXISTS `oauth_clients`;
CREATE TABLE IF NOT EXISTS `oauth_clients` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `secret` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `redirect` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `personal_access_client` tinyint(1) NOT NULL,
  `password_client` tinyint(1) NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_clients_user_id_index` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_clients`
--

INSERT INTO `oauth_clients` (`id`, `user_id`, `name`, `secret`, `redirect`, `personal_access_client`, `password_client`, `revoked`, `created_at`, `updated_at`) VALUES
(1, NULL, 'Laravel Personal Access Client', 'WSEACQzpEg707Ja5hrTdDuevkzNULXvWcsEyoZcP', 'http://localhost', 1, 0, 0, '2019-01-24 00:39:41', '2019-01-24 00:39:41'),
(2, NULL, 'Laravel Password Grant Client', 'szw7OEEDbYDp8CxOcY1P9jbw8nHOJVw20SrOVMCw', 'http://localhost', 0, 1, 0, '2019-01-24 00:39:41', '2019-01-24 00:39:41');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_personal_access_clients`
--

DROP TABLE IF EXISTS `oauth_personal_access_clients`;
CREATE TABLE IF NOT EXISTS `oauth_personal_access_clients` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_personal_access_clients_client_id_index` (`client_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_personal_access_clients`
--

INSERT INTO `oauth_personal_access_clients` (`id`, `client_id`, `created_at`, `updated_at`) VALUES
(1, 1, '2019-01-24 00:39:41', '2019-01-24 00:39:41');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_refresh_tokens`
--

DROP TABLE IF EXISTS `oauth_refresh_tokens`;
CREATE TABLE IF NOT EXISTS `oauth_refresh_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `access_token_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_refresh_tokens_access_token_id_index` (`access_token_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `customer_id` int(11) NOT NULL,
  `sale_rep_id` int(10) UNSIGNED NOT NULL,
  `tax_rule_id` int(10) UNSIGNED NOT NULL,
  `invoice_no` varchar(50) NOT NULL,
  `order_type` varchar(20) DEFAULT NULL,
  `is_posted` tinyint(4) NOT NULL DEFAULT '0',
  `notes` text,
  `signature` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `client_id` (`client_id`),
  KEY `sale_rep_id` (`sale_rep_id`),
  KEY `tax_rule_id` (`tax_rule_id`),
  KEY `customer_id` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `client_id`, `customer_id`, `sale_rep_id`, `tax_rule_id`, `invoice_no`, `order_type`, `is_posted`, `notes`, `signature`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 5, 3, 16, 5, 'Invoice-16-1', 'Invoice', 0, NULL, '165dc1bb2e6bd59.jpg', '2019-11-05 18:10:21', '2019-11-05 18:10:54', NULL),
(2, 5, 3, 16, 5, 'Invoice-16-2', 'Invoice', 0, NULL, '165dc2f3b6c2b32.jpg', '2019-11-06 16:24:05', '2019-11-06 16:24:22', NULL),
(3, 5, 109, 16, 1, 'Invoice-16-3', 'Invoice', 0, NULL, '165dc2f413dfdbb.jpg', '2019-11-06 16:25:33', '2019-11-06 16:25:55', NULL),
(4, 5, 113, 16, 4, 'Invoice-16-4', 'Invoice', 0, NULL, '165dc2f4d354ae2.jpg', '2019-11-06 16:28:48', '2019-11-06 16:29:07', NULL),
(5, 5, 110, 16, 1, 'Invoice-16-5', 'Invoice', 0, NULL, '165dc2f6455ed20.jpg', '2019-11-06 16:35:03', '2019-11-06 16:35:17', NULL),
(6, 5, 110, 16, 1, 'Invoice-16-6', 'Invoice', 0, NULL, '165dc2f6ebaf26e.jpg', '2019-11-06 16:37:04', '2019-11-06 16:38:03', NULL),
(7, 5, 3, 16, 5, 'Invoice-16-7', 'Invoice', 0, NULL, '165dc2f6ebda5c3.jpg', '2019-11-06 16:37:23', '2019-11-06 16:38:03', NULL),
(8, 5, 109, 16, 1, 'Invoice-16-8', 'Invoice', 0, NULL, '165dc2f73514506.jpg', '2019-11-06 16:39:06', '2019-11-06 16:39:17', NULL),
(9, 5, 3, 17, 5, 'Invoice-17-9', 'Invoice', 0, NULL, '175dc7ea9ff3f47.jpg', '2019-11-10 10:46:14', '2019-11-10 10:46:56', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
CREATE TABLE IF NOT EXISTS `order_details` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` int(10) UNSIGNED NOT NULL,
  `client_id` int(10) UNSIGNED NOT NULL,
  `product_id` int(10) UNSIGNED NOT NULL,
  `quantity` int(10) UNSIGNED NOT NULL,
  `price` double(10,2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`id`, `order_id`, `client_id`, `product_id`, `quantity`, `price`) VALUES
(1, 1, 5, 17, 6, 200.00),
(2, 2, 5, 15, 186, 20.00),
(3, 3, 5, 12, 355, 10.00),
(4, 4, 5, 9, 1995533, 10.00),
(5, 5, 5, 11, 1, 20.00),
(6, 6, 5, 14, 5, 10.00),
(7, 6, 5, 15, 6, 20.00),
(8, 7, 5, 10, 1, 20.00),
(9, 8, 5, 12, 1, 10.00),
(10, 9, 5, 17, 150, 20.00);

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
CREATE TABLE IF NOT EXISTS `package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `validity` int(11) NOT NULL,
  `max_customers` int(11) DEFAULT NULL,
  `max_sales_rep` int(11) DEFAULT NULL,
  `max_products` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`id`, `name`, `validity`, `max_customers`, `max_sales_rep`, `max_products`, `price`, `status`) VALUES
(1, 'Free Trial', 7, 50, 2, 50, 0, 1),
(2, 'Silver Package', 90, 50, 15, 200, 299, 1),
(3, 'Gold Package', 180, 70, 20, 500, 499, 1),
(4, 'Platinum Package', 365, 100, 35, 1000, 999, 1),
(5, 'Premium Package', 365, NULL, NULL, NULL, 1499, 1),
(6, 'new', 8, 3, 6, 3, 10, 0);

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

DROP TABLE IF EXISTS `password_resets`;
CREATE TABLE IF NOT EXISTS `password_resets` (
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `password_resets_type_index` (`type`),
  KEY `password_resets_email_index` (`email`),
  KEY `password_resets_token_index` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `password_resets`
--

INSERT INTO `password_resets` (`type`, `email`, `token`, `created_at`) VALUES
('', 'abcd@gmail.com', '$2y$10$Z5nGvdRvASd7R/OLA1Q4EePahnAKcM.DndPfJQemDBnDb6vdf6Usy', '2019-02-01 03:07:40'),
('', 'aashishgnubca@gmail.com', '$2y$10$D83TrNl0DFmGe2D4.vcks.w/bFY9pvkFcNuwbKgqrSizRIlT4LQze', '2019-03-13 09:14:59');

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE IF NOT EXISTS `permissions` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `guard_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `barcodeno` text,
  `name` varchar(200) NOT NULL,
  `price` double(10,2) UNSIGNED NOT NULL,
  `cost` double(10,2) UNSIGNED DEFAULT NULL,
  `quantity` int(100) UNSIGNED DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `is_taxable` tinyint(4) NOT NULL DEFAULT '0',
  `imageurl` varchar(500) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `client_id`, `barcodeno`, `name`, `price`, `cost`, `quantity`, `is_active`, `is_taxable`, `imageurl`, `created_at`, `updated_at`, `deleted_at`) VALUES
(2, 5, '2343454', 'Balaji Tomato Masti', 200.00, 17.00, 58, 1, 1, NULL, '2018-12-21 02:39:32', '2019-10-23 20:42:06', '2019-10-23 20:42:06'),
(3, 5, '112324323', 'Balaji Sev Mamara', 20.00, 17.00, 0, 0, 1, NULL, '2018-12-21 02:39:32', '2019-11-05 18:21:22', '2019-11-05 18:21:22'),
(4, 5, '2343556434', 'Balaji Farali', 25.00, 20.00, 94, 1, 1, NULL, '2018-12-21 02:39:32', '2019-03-13 08:57:17', NULL),
(5, 5, 'MU79 UJFA 3191 5330 7213 5145 769S AL', 'Pepper - Pablano', 24.04, 7.70, 94, 0, 1, 'http://dummyimage.com/243x167.png/cc0000/ffffff', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(6, 5, '536284537', 'Balaji Pop Ring', 10.00, 7.00, 92, 1, 0, NULL, '2018-12-29 09:03:14', '2019-03-13 08:57:17', NULL),
(7, 5, '783648345', 'Balaji Pizzy', 10.00, 7.00, 100, 1, 0, NULL, '2019-01-05 04:00:03', '2019-03-05 15:26:57', NULL),
(8, 5, '82253783', 'Balaji Magic Masala Small', 10.00, 7.00, 100, 1, 0, NULL, '2019-02-08 12:32:45', '2019-03-05 15:27:13', NULL),
(9, 5, '8254827', 'Balaji Cream & Onion Small', 10.00, 7.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-03-05 15:27:25', NULL),
(10, 5, '263723845738', 'Balaji Magic Masala Large', 20.00, 17.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-02-08 12:32:45', NULL),
(11, 5, '37823569', 'Balaji Cream & Onion Large', 20.00, 17.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-02-08 12:32:45', NULL),
(12, 5, '384633923', 'Balaji Khatta Mith Mix Small', 10.00, 7.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-02-08 12:32:45', NULL),
(13, 5, '87236847692', 'Balaji Simpe Salted Small ssssssssssssssssssssssssssssssssssssssssssssssssssssssssss', 10.00, 7.00, 100, 1, 0, NULL, '2019-02-08 12:32:45', '2019-11-07 21:51:01', NULL),
(14, 5, '36728468912379', 'Balaji Chat Chaska Small', 10.00, 7.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-02-08 12:32:45', NULL),
(15, 5, '7236846297', 'Balaji Khatta Mith Mix', 20.00, 14.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-02-08 12:32:45', NULL),
(16, 5, '762384', 'Balaji Simpe Salted Large', 20.00, 14.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-02-08 12:32:45', NULL),
(17, 5, '6358726438', 'Balaji Chat Chaska', 20.00, 17.00, 100, 1, 1, NULL, '2019-02-08 12:32:45', '2019-10-23 20:43:07', NULL),
(18, 18, 'CZ59 3537 0685 9269 2525 2860', 'Nantucket Orange Juice', 73.48, 6.27, 91, 0, 0, 'http://dummyimage.com/126x130.jpg/cc0000/ffffff', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0000-00-00 00:00:00'),
(19, 8, '76817298382068767', 'Aciclovir tab 200 mgs', 50.00, 40.00, 100, 1, 1, NULL, '2019-03-03 08:32:50', '2019-10-05 14:39:22', NULL),
(20, 8, '726342800', 'Amitriptyline tab 25 mg', 100.00, 90.00, 100, 0, 0, NULL, '2019-03-03 03:44:31', '2019-03-03 09:30:10', NULL),
(21, 8, '8764836', ' Amoxicillin cap 250 mg ', 180.00, 160.00, 100, 0, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(22, 8, '25233234', 'Artesunate tab 100 mg ', 50.00, 45.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(23, 8, '343534246', 'Atenolol tab 50 mg', 39.00, 36.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(24, 8, '23425346', 'Beclomethasone inhaler 50 mg/dose ', 127.00, 120.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(25, 8, '324324365', ' Captopril tab 25 mg', 134.00, 130.00, 100, 0, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 09:30:17', NULL),
(26, 8, '234345464', ' Carbmazepine tab 200 mg ', 166.00, 150.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(27, 8, '3543645734', ' Ceftriaxone inj 1 g powder', 88.00, 60.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(28, 8, '3543453', ' Diclofenac tab 25 mg ', 88.00, 60.00, 100, 0, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 09:30:13', NULL),
(29, 8, '43564737', ' Fluoxetine tab 20 mg', 35.00, 30.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(30, 8, '3465646', 'Losartan tab 50 mg', 30.00, 25.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(31, 8, '328453897', ' Lovastatin tab 20 mg ', 25.00, 18.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(32, 8, '34234545', ' Metformin tab 500 mg ', 20.00, 15.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(33, 8, '3242353', ' Nevirapine tab 200 mg 24', 10.00, 9.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(34, 8, '345677890987654', 'Nifedipine Retard tab 20 mg ', 90.00, 78.00, 100, 1, 1, NULL, '2019-03-03 03:44:31', '2019-03-03 03:44:31', NULL),
(35, 5, '12457895623', 'Balaji Tomato Masti', 20.00, 17.00, 2000, 1, 1, NULL, '2019-11-05 18:22:39', '2019-11-05 18:22:39', NULL),
(36, 5, '112324323', 'Balaji Tomato Masti', 20.00, 17.00, 2000, 1, 1, NULL, '2019-11-05 18:25:55', '2019-11-05 18:25:55', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
CREATE TABLE IF NOT EXISTS `registration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` int(10) NOT NULL,
  `registration_id` varchar(191) NOT NULL,
  `status` varchar(100) NOT NULL DEFAULT 'pending',
  `price` varchar(100) NOT NULL,
  `transaction_id` varchar(100) NOT NULL,
  `payment_mode` varchar(100) DEFAULT NULL,
  `currency` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `client_id_2` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`id`, `client_id`, `registration_id`, `status`, `price`, `transaction_id`, `payment_mode`, `currency`, `created_at`, `updated_at`) VALUES
(6, 34, '5c98b4f8657f2', 'pending', '499', '', NULL, NULL, '2019-03-25 11:01:12', '2019-03-25 11:01:12'),
(7, 29, '5c99f8702a21b', 'complete', '299', '20190326111212800110168976000362051', 'PPI', 'INR', '2019-03-26 10:02:28', '2019-03-26 10:02:28'),
(8, 30, '5c99fa61760ee', 'complete', '499', '20190326111212800110168454300356542', 'PPI', 'INR', '2019-03-26 10:10:02', '2019-03-26 10:10:02'),
(9, 5, '5ca1dd4ae34ba', 'complete', '299', '20190401111212800110168329600371370', 'NB', 'INR', '2019-04-01 09:46:10', '2019-04-01 09:46:10'),
(10, 5, '5ca1df1589650', 'pending', '1499', '', NULL, NULL, '2019-04-01 09:51:17', '2019-04-01 09:51:17'),
(11, 5, '5ca1969071ecb', 'complete', '1499', '20190401111212800110168108700365014', 'NB', 'INR', '2019-04-01 04:42:11', '2019-04-01 04:42:11'),
(12, 5, '5ca2f9cc6ac54', 'complete', '299', '20190402111212800110168016700372468', 'NB', 'INR', '2019-04-02 06:04:12', '2019-04-02 06:04:12'),
(13, 5, '5ca2fb8c8c6ee', 'pending', '', '', NULL, NULL, '2019-04-02 06:05:00', '2019-04-02 06:05:00'),
(14, 33, '5caefdf922316', 'complete', '999', '20190411111212800110168997300391549', 'NB', 'INR', '2019-04-11 08:43:20', '2019-04-11 08:43:20');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `guard_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `role_has_permissions`
--

DROP TABLE IF EXISTS `role_has_permissions`;
CREATE TABLE IF NOT EXISTS `role_has_permissions` (
  `permission_id` int(10) UNSIGNED NOT NULL,
  `role_id` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`permission_id`,`role_id`),
  KEY `role_has_permissions_role_id_foreign` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sale_reps`
--

DROP TABLE IF EXISTS `sale_reps`;
CREATE TABLE IF NOT EXISTS `sale_reps` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `client_devices_lisences_id` int(11) DEFAULT NULL,
  `initial` varchar(50) NOT NULL,
  `region` varchar(100) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `client_devices_lisences` (`client_devices_lisences_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sale_reps`
--

INSERT INTO `sale_reps` (`id`, `client_id`, `client_devices_lisences_id`, `initial`, `region`, `is_active`, `created_at`, `deleted_at`, `updated_at`) VALUES
(10, 8, NULL, 'ketan', 'sola', 1, '2019-03-03 08:39:00', NULL, '2019-03-03 08:39:00'),
(11, 8, NULL, 'Aashish', 'Science City', 1, '2019-03-03 08:39:17', NULL, '2019-03-03 08:39:17'),
(12, 8, NULL, 'Kaushal', 'Jamalpur', 1, '2019-03-03 08:39:34', NULL, '2019-03-03 08:39:34'),
(13, 8, NULL, 'Jatin', 'Gurukul', 1, '2019-03-03 08:40:09', NULL, '2019-03-03 08:40:09'),
(14, 8, NULL, 'H.K.', 'Wadaj', 1, '2019-03-03 08:40:30', NULL, '2019-03-03 08:40:30'),
(16, 5, NULL, 'Hk', 'Bapunagar', 1, '2019-11-12 12:36:09', NULL, '2019-11-10 10:49:54'),
(17, 5, NULL, 'keitan', 'kalupur', 1, '2019-11-10 10:44:59', NULL, '2019-11-10 09:50:58'),
(18, 5, NULL, 'aashish', 'nikol', 1, '2019-11-10 10:08:28', NULL, '2019-11-10 10:08:28');

-- --------------------------------------------------------

--
-- Table structure for table `super_admins`
--

DROP TABLE IF EXISTS `super_admins`;
CREATE TABLE IF NOT EXISTS `super_admins` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `super_admins`
--

INSERT INTO `super_admins` (`id`, `name`, `email`, `password`, `remember_token`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Aashish Pathak', 'aashishgnubca@gmail.com', '0000', NULL, '2018-12-21 02:39:32', '2018-12-21 02:39:32', NULL),
(2, 'Aashish', 'aashishgnubca2@gmail.com', '$2y$10$PMKOILm0Dqvggibk4sp6E.ecxxvOGlr/hIt9X6QSkU5fwum63WJt.', NULL, '2019-02-03 05:03:23', '2019-02-03 05:03:23', NULL),
(3, '', 'abcd@gmail.com', '$2y$10$YSNFQASGddmCGE7JnsfCMORhE92FiaS6FVYauPxcBDpUQNUjf6cye', NULL, '2019-03-18 10:32:21', '2019-03-18 10:32:21', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `sync_log`
--

DROP TABLE IF EXISTS `sync_log`;
CREATE TABLE IF NOT EXISTS `sync_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `sales_rep_id` int(10) UNSIGNED NOT NULL,
  `last_sync_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `sync_status` varchar(100) DEFAULT 'Pending',
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `sales_rep_id` (`sales_rep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sync_log`
--

INSERT INTO `sync_log` (`id`, `client_id`, `sales_rep_id`, `last_sync_date`, `sync_status`) VALUES
(21, 5, 17, '2019-11-10 10:47:01', 'Complete'),
(22, 5, 18, '2019-11-10 10:07:54', 'Complete'),
(23, 5, 16, '2019-11-10 10:53:32', 'Complete');

-- --------------------------------------------------------

--
-- Table structure for table `tax_rules`
--

DROP TABLE IF EXISTS `tax_rules`;
CREATE TABLE IF NOT EXISTS `tax_rules` (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `rate` double UNSIGNED NOT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tax_rules`
--

INSERT INTO `tax_rules` (`id`, `client_id`, `name`, `rate`, `updated_at`, `deleted_at`) VALUES
(1, 5, '50% GST', 50, NULL, NULL),
(2, 5, '10% GST', 10, NULL, NULL),
(3, 5, '18% GST', 18, NULL, NULL),
(4, 5, '15% tax', 15, NULL, NULL),
(5, 5, '19% Tax', 19, NULL, NULL),
(6, 5, 'No Tax', 0, NULL, NULL),
(7, 8, '50% Tax', 50, NULL, NULL),
(8, 8, '25% Tax', 25, NULL, NULL),
(9, 8, '18% Tax', 18, NULL, NULL),
(10, 8, '10% Tax', 10, NULL, NULL),
(11, 8, '5% Tax', 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci DEFAULT 'avatar.png',
  `role` varchar(100) COLLATE utf8_unicode_ci DEFAULT 'staff',
  `mobile_no` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `phone_no` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_login` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `login_since` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0-Active 1-Deactive',
  `confirmed` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Flag is using for forget / reset password',
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `password`, `image`, `role`, `mobile_no`, `phone_no`, `last_login`, `login_since`, `status`, `confirmed`, `remember_token`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 'Sandip Sathavara333', 'sandip@wims.com', '$2y$10$tdOtu6Y5lT5CgtydvPxOm.buVUWXfmsbZab2bPlnZ1d7Es0pxAmti', '5c1a1e3db92a1.jpg', 'super', '9624618989', '', '2019-02-04 03:37:44', '2019-02-04 03:37:44', 1, 1, 'spApoVUG8C1tzBbmnXYWcSt0lFwIpUO41a9AIJZFxNBy0MtCYLy06TGAB2DQ', '2016-09-08 04:00:27', '2019-02-04 03:37:44', NULL),
(140, 'Sandip', 'sandip@asd.com', '$2y$10$YZmgQcPGPYolBXMSh5K0nuRm3wtSnQ7btxrUIMO0M9ViEgxttyVde', 'avatar.png', 'super', '1234567489', NULL, '2018-12-26 08:41:49', '2018-12-26 08:41:49', 1, 0, 'wcHIOxn87EMAs3vtf0jVFw5cM7x0CI5zcDPa7GMjqf6DjFMsuW15y6tAOaGD', '2018-11-29 09:10:21', '2018-12-26 03:11:49', NULL),
(148, 'Aashish', 'aashishgnubca@gmail.com', '$2y$10$n/ft8mtAA4cPQLRn0jSiD.YCoaXZN/Aa6GkryWaO9WOSDZRl/0OAu', 'avatar.png', 'staff', '', NULL, '2018-12-29 15:15:42', '2018-12-29 15:15:42', 1, 0, '0Rn3wmepsxR7wQ7OdschLoSqaGrbNaa9RXnbHrCxV5fj8E1CsJwFRbhWDi1W', '2018-12-29 09:45:03', '2018-12-29 09:45:03', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_access`
--

DROP TABLE IF EXISTS `user_access`;
CREATE TABLE IF NOT EXISTS `user_access` (
  `id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(20) UNSIGNED NOT NULL,
  `system_pages_id` int(10) UNSIGNED NOT NULL,
  `view_access` tinyint(1) DEFAULT NULL,
  `assigned_by` int(20) UNSIGNED NOT NULL,
  `assigned_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_access`
--

INSERT INTO `user_access` (`id`, `user_id`, `system_pages_id`, `view_access`, `assigned_by`, `assigned_at`) VALUES
(9, 121, 1, NULL, 140, '2018-12-03 09:24:00'),
(10, 121, 4, NULL, 140, '2018-12-03 09:24:00');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `super_admins` (`id`),
  ADD CONSTRAINT `clients_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `super_admins` (`id`),
  ADD CONSTRAINT `clients_ibfk_3` FOREIGN KEY (`package_id`) REFERENCES `package` (`id`);

--
-- Constraints for table `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `customers_ibfk_3` FOREIGN KEY (`tax_rule_id`) REFERENCES `tax_rules` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`sale_rep_id`) REFERENCES `sale_reps` (`id`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`tax_rule_id`) REFERENCES `tax_rules` (`id`),
  ADD CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  ADD CONSTRAINT `order_details_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `sale_reps`
--
ALTER TABLE `sale_reps`
  ADD CONSTRAINT `sale_reps_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);

--
-- Constraints for table `sync_log`
--
ALTER TABLE `sync_log`
  ADD CONSTRAINT `sync_log_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `sync_log_ibfk_2` FOREIGN KEY (`sales_rep_id`) REFERENCES `sale_reps` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `tax_rules`
--
ALTER TABLE `tax_rules`
  ADD CONSTRAINT `tax_rules_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
