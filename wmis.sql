-- Adminer 4.4.0 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';



DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
  `created_by` int(10) unsigned DEFAULT NULL,
  `updated_by` int(10) unsigned DEFAULT NULL,
  `renewed_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  KEY `package_id` (`package_id`),
  CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `super_admins` (`id`),
  CONSTRAINT `clients_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `super_admins` (`id`),
  CONSTRAINT `clients_ibfk_3` FOREIGN KEY (`package_id`) REFERENCES `package` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `clients` (`id`, `company_name`, `email`, `email_verified_at`, `password`, `contact_person_name`, `phone_no`, `address`, `city`, `state`, `zip`, `status`, `role`, `remember_token`, `package_id`, `created_by`, `updated_by`, `renewed_at`, `created_at`, `expires_at`, `updated_at`, `deleted_at`) VALUES
(5,	'Balaji Masala Wafers Pvt. Ltd.',	'aashishgnubca@gmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Prakash Patel',	'0000000055',	'Ratnadeep complex ,Sarvodaya NAgar Part-1',	'Ahmedabad',	'Gujarat',	380061,	'active',	'super',	'MuW11uRo0J5qvPGmjzvZGL4Mn8FJ8GyY1gwahpn7kfuxrnZKXoCBZ3DLmPAt',	1,	1,	1,	'2019-04-02 06:04:12',	'2019-01-02 03:16:23',	'2022-07-01 06:04:12',	'2019-04-08 07:51:49',	NULL),
(7,	'Coca Cola Pvt Ltd',	'pathakaashish007@gmail.com',	NULL,	'$2y$10$P5oEt3y/TCQSGqwa/4Sy0uwKWw.PMJ1Ld6saDGZGkvGE6VNhHB51S',	'Aashish.K.P',	'9900887766',	'Ratnadeep complex ,Sarvodaya NAgar Part-1',	'Ahmedabad',	'Gujarat',	380061,	'inactive',	'super',	'HrSBxErG5NxW58ZWYNwafk9dIBGyGktdF34CQ6xHNCJ8a9VAGAvSV933guF8',	2,	1,	1,	NULL,	'2019-01-18 04:34:31',	'2019-04-18 04:34:30',	'2019-01-18 04:34:31',	NULL),
(8,	'A TO Z PHARMACEUTICALS',	'aashishgnubca2@gmail.com',	NULL,	'$2y$10$LV4j697ijx7uDq5St2P60eeqqTcoRjPce7THbxUrOebW5ZrXGWSLO',	'Ramesh Bhai Patel',	'8849606266',	'b-7 Ratnadeep Complex Sarvodaya Nagar Part 1',	'Ahmedabad',	'Gujarat',	380061,	'active',	'super',	'taKTLwTHZA19Hh3rB6zaw3JrEJfu4lgBmJeILZZ4IAPoGAnV24UjrPruRtaH',	5,	NULL,	NULL,	NULL,	'2019-03-03 08:32:50',	'2020-03-02 08:32:50',	'2019-03-03 08:32:50',	NULL),
(9,	'Leffler LLC',	'layne.beahan@cummerata.info',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Alejandrin Mraz I',	'Goldner, Wisozk and Dibbert',	'969 Nitzsche Cliffs Suite 577',	'Herminiafort',	'New Hampshire',	5706,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-21 12:23:31',	NULL),
(10,	'Berge-Krajcik',	'xokon@champlin.net',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Derick Barrows',	'Legros, Denesik and Wolf',	'3920 Lesch Islands Apt. 127',	'Wolfton',	'Alaska',	80405,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-21 12:15:55',	NULL),
(11,	'Hansen-Cormier',	'fern.schoen@hotmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Nickolas Kertzmann',	'Labadie-Raynor',	'87849 Homenick Throughway',	'Emieburgh',	'Kansas',	79954,	'inactive',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-21 12:19:40',	NULL),
(12,	'Corkery Ltd',	'gage.casper@marks.info',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Dr. Leonel O\'Keefe MD',	'Purdy-Shields',	'6478 Erna Dam',	'West Briana',	'Florida',	90905,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(13,	'Davis, Simonis and Goodwin',	'karli.hermiston@cronin.org',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Cedrick Armstrong',	'Grant, Rogahn and Mohr',	'5180 Kunze Skyway Apt. 273',	'Hahnfurt',	'South Carolina',	13304,	'inactive',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-21 13:26:12',	NULL),
(14,	'Turcotte-Lowe',	'hill.gino@hotmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Mrs. Roxanne Lemke Jr.',	'Durgan-Mills',	'17640 Bechtelar Cliffs',	'New Javonte',	'Louisiana',	62331,	'inactive',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-21 13:26:15',	NULL),
(15,	'Williamson, Ryan and Macejkovic',	'tom90@yahoo.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Andreane Wunsch',	'Hermann-Heathcote',	'979 McClure Terrace',	'West Blairmouth',	'Nebraska',	23121,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(16,	'Gorczany-Waters',	'berge.jay@hermann.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Immanuel Ratke',	'Bartoletti-Reichel',	'44290 Beulah Circle',	'Lednerhaven',	'Nevada',	73811,	'inactive',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-21 13:26:17',	NULL),
(17,	'Corwin PLC',	'zjaskolski@hotmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Prof. Tessie Berge MD',	'Smitham-Muller',	'8529 Ankunding Fall',	'Raumouth',	'Wisconsin',	82128,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(18,	'Larkin-Marvin',	'fmcdermott@gmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Mrs. Jena Mraz Sr.',	'Koelpin-Davis',	'2004 Hudson Harbor',	'Montanafurt',	'Utah',	13342,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(19,	'Nolan, Waelchi and Friesen',	'kertzmann.celestino@gmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Kennedy Stamm Jr.',	'Barton-Schaefer',	'833 Blick Brook Suite 021',	'East Stefanfurt',	'North Carolina',	1353,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(20,	'Dare-Satterfield',	'shawna.mraz@russel.biz',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Onie Heathcote',	'Johns-Effertz',	'64438 Welch Courts',	'Flossieland',	'Idaho',	26539,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(21,	'Rodriguez, Gorczany and Hammes',	'ettie02@hotmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Merl Flatley',	'Hyatt Inc',	'783 Zoila Street Suite 950',	'Lake Lance',	'South Dakota',	13675,	'inactive',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-21 13:26:19',	NULL),
(22,	'Ratke PLC',	'rath.luis@gmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Mr. Misael O\'Kon',	'Gusikowski PLC',	'23397 Vivianne Place',	'East Devon',	'Montana',	82217,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(23,	'Brakus-Abshire',	'xschmidt@ebert.info',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Jacklyn Kemmer I',	'Stiedemann-Schmeler',	'1492 Naomie Junctions',	'Lake Junius',	'Virginia',	92373,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(24,	'Mosciski-Crist',	'tianna.heathcote@hotmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Lucy Kertzmann PhD',	'Heller, Torp and King',	'895 Rempel Isle Suite 633',	'Janaechester',	'Colorado',	62562,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(25,	'Klein, Graham and Huels',	'mueller.norwood@morar.info',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Mohamed Cormier',	'Bogisich Group',	'180 Mozelle Forge',	'Goldatown',	'Missouri',	44413,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(26,	'Walker, Kshlerin and Little',	'bruen.shany@reichel.org',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Deonte Cremin',	'Stroman, Lynch and Okuneva',	'986 Ryan Garden',	'Lake Kayceechester',	'Wisconsin',	76148,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(27,	'VonRueden Group',	'wzulauf@hartmann.biz',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Joan Torp PhD',	'Schoen Ltd',	'976 Lueilwitz Dam',	'West Adrien',	'District of Columbia',	70140,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(28,	'Welch PLC',	'autumn58@hotmail.com',	NULL,	'$2y$10$VP5aL1N/aMNObJpwJh/c1.123WloCk54YY0blFHoCfOmbUenWUhpm',	'Dr. Pete Lesch',	'Kuphal-Kilback',	'1438 Dimitri Shoal',	'Littelhaven',	'California',	87961,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-03-14 14:38:10',	NULL,	'2019-03-14 14:38:10',	NULL),
(31,	'Mayur',	'sankaliyamayur398@gmail.com',	NULL,	'$2y$10$zwOJz3.1hijfBtsSFEyPQuMg8qjGY7cQr/2QUr.rcZnzucbqr1yt.',	'Mayur',	'9999999999',	'jhgujg',	'jhjh',	'jhgjh',	9898,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-04-11 07:39:01',	'2019-04-18 07:39:00',	'2019-04-11 07:39:01',	NULL),
(32,	'Samrat INC.',	'jatinnayak1999@gmail.com',	NULL,	'$2y$10$qFy1ksNNwgx67PECvCbbBee0AowjRr0sk//JbX07Jv8C6G73iEiZ.',	'JATIN',	'9988990088',	'JATIN\'s ADDRESS',	'Ahmedabad',	'Gujarat',	380061,	'active',	'super',	NULL,	1,	NULL,	NULL,	NULL,	'2019-04-11 07:48:25',	'2019-04-18 07:48:25',	'2019-04-11 07:48:25',	NULL),
(33,	'Malboro new',	'aashishgnuadbdsa78@gmail.com56',	NULL,	'$2y$10$xCsQDe/1SEcmVUdzm1owduIw6f9QQOznjq0JprTp6V6FI5FMHUSEy',	'JATIN',	'9988990088',	'JATIN\'s ADDRESS',	'Ahmedabad',	'Gujarat',	380061,	'active',	'super',	NULL,	4,	NULL,	NULL,	'2019-04-11 08:43:20',	'2019-04-11 08:42:33',	'2020-04-10 08:43:20',	'2019-04-11 08:43:20',	NULL);

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned NOT NULL,
  `tax_rule_id` int(10) unsigned DEFAULT NULL,
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
  KEY `tax_rule_id` (`tax_rule_id`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE,
  CONSTRAINT `customers_ibfk_3` FOREIGN KEY (`tax_rule_id`) REFERENCES `tax_rules` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `customers` (`id`, `client_id`, `tax_rule_id`, `name`, `contact_name`, `email`, `address`, `city`, `state`, `postcode`, `contact_no`, `status`, `is_product_tax`, `created_at`, `updated_at`, `deleted_at`) VALUES
(3,	5,	5,	'Ashok Pan PArlour',	'aashish',	'ashokpanparlour@gmail.comhkgjk',	'opp. kargil petrol pump',	'Ahmedabad',	'Gujarat',	380061,	'8976556690',	'active',	0,	'2018-12-21 02:39:32',	'2019-03-01 03:38:40',	NULL),
(4,	5,	3,	'Shivam Dairy',	'ketan',	'shivamdairy@gmail.com',	'Gulab Tower',	'Ahmedabad',	'Gujarat',	380061,	'8977896500',	'active',	1,	'2018-12-21 02:39:32',	'2019-02-09 02:58:22',	NULL),
(5,	5,	2,	'Gulab Pan PArlour',	'hk',	'gulabpanparlour@gmail.com',	'pakwan cross road',	'Ahmedabad',	'Gujarat',	380061,	'8976556690',	'active',	0,	'2018-12-21 02:39:32',	'2018-12-21 02:39:32',	NULL),
(6,	5,	4,	'Khodiyar Dairy',	'kaushal',	'khodiyardairy@gmail.com',	'Gulab Tower',	'Ahmedabad',	'Gujarat',	380061,	'8977896500',	'active',	0,	'2018-12-21 02:39:32',	'2019-03-05 15:31:40',	NULL),
(12,	5,	5,	'Nirmal Traders',	'jatin',	'nirmaltrader@gmail.com',	'sola',	'Ahmedabad',	'Gujarat',	380061,	'9988776655',	'active',	1,	'2019-01-04 06:16:54',	'2019-03-05 15:31:54',	NULL),
(18,	5,	6,	'sager Wholesale pvt ltd',	'abhishek',	'sagarwholesale@gmail.com',	'xyz address',	'Ahmedabad',	'Gujarat',	380061,	'9988776655',	'active',	1,	'2019-02-02 04:33:53',	'2019-02-09 02:58:27',	NULL),
(19,	5,	3,	'Rajaram Kirana',	'mayur',	'pathakaashish539@gmail.com',	'sattadhar char rasta',	'Ahmedabad',	'Gujarat',	380061,	'9900998877',	'active',	1,	'2019-02-04 06:29:41',	'2019-02-09 02:57:16',	NULL),
(68,	8,	11,	'Savaram Chemist',	'Kalin Bhayia',	'savaram@gmail.com',	'sola',	'Ahmedabad',	'Gujarat',	380061,	'9988776655',	'active',	1,	'2019-03-03 08:37:33',	'2019-03-03 08:42:09',	NULL),
(69,	8,	9,	'Akshar Medical Store',	'Bunty',	'Akshar@gmail.com',	'Sattadhar',	'Ahmedabad',	'Gujarat',	380061,	'8877665509',	'active',	1,	'2019-03-03 08:43:12',	'2019-03-03 08:46:38',	NULL),
(70,	8,	8,	'Suvidha Medical Stores',	'Ganesh Gaitonde',	'Suvidha@gmail.com',	'Science City',	'Ahmedabad',	'Gujarat',	380061,	'99008877666',	'active',	1,	'2019-03-03 08:44:12',	'2019-03-03 08:46:26',	NULL),
(71,	8,	7,	'Arihant Medical Stores',	'Issa',	'Arihant@gmail.com',	'L.L/9, Manorath Complex',	'Ahmedabad',	'Gujarat',	380061,	'8899776655',	'active',	1,	'2019-03-03 08:45:26',	'2019-03-03 08:54:00',	NULL),
(72,	8,	7,	'MEDCHOICE PHARMACY',	'KuKu',	'Medchoice@gmail.com',	'18, Agrawal Tower,',	'Ahmedabad',	'Gujarat',	380061,	'8877665598',	'active',	1,	'2019-03-03 08:52:57',	'2019-03-05 11:54:53',	NULL),
(73,	5,	1,	'EFG Wholesale',	'ketan',	'keith212005@gmail.com',	'1300 xzy st',	'Ahmedabad',	'GJ',	380061,	'7774653256',	'active',	0,	'2019-03-05 20:58:29',	'2019-03-05 15:30:02',	NULL),
(74,	5,	6,	'Nirmal traders',	'Aashish Pathak',	'restaurantbillingsystem@gmail.com',	'Shri Dongre Maharaj Marg 2',	'Ahmedabad',	'Gujarat',	380061,	'+17600978483',	'active',	0,	'2019-03-06 02:04:28',	'2019-03-13 09:46:58',	NULL),
(95,	8,	5,	'Muller, Feest and Bruen',	'Miss Leta Jast',	'korbin47@hartmann.net',	'7004 Frances Ford',	'Port Tryciaview',	'North Carolina',	61443,	'1-219-465-8829 x83413',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(96,	8,	4,	'Metz Inc',	'Madaline Ward',	'shawna.champlin@kuphal.com',	'18233 Edyth Freeway Apt. 831',	'Windlerton',	'Arkansas',	73743,	'(640) 500-2832 x205',	'active',	1,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(97,	5,	1,	'Reynolds-Conroy',	'Sam Skiles',	'myrtle45@gmail.com',	'417 Tobin Glen Suite 622',	'Gildahaven',	'Nevada',	5366,	'+1.876.682.6124',	'active',	1,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(98,	5,	1,	'Mertz PLC',	'Rodolfo Pacocha',	'lorine.daniel@yahoo.com',	'7282 Thompson Trail Apt. 995',	'Marilouland',	'District of Columbia',	45212,	'+1-729-889-0559',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(99,	5,	4,	'Champlin, Ledner and Sanford',	'Miss Adeline Waelchi I',	'dbotsford@berge.net',	'30877 Monroe Run',	'Sauermouth',	'Delaware',	46316,	'(659) 401-5049',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(100,	5,	2,	'Hirthe, Tillman and Smitham',	'Raegan Corwin V',	'darrick43@ledner.org',	'6407 Wolf Mill',	'South Laneville',	'Minnesota',	90634,	'+1.275.242.9031',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(101,	8,	3,	'Jacobson-Kassulke',	'Dr. Darrin Haley',	'moore.warren@gmail.com',	'5790 O\'Hara Ports',	'South Aminachester',	'Colorado',	11467,	'1-429-233-4448 x9813',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(102,	5,	3,	'Dooley Ltd',	'Clarabelle Mraz',	'tracy29@auer.com',	'90657 Hoppe Points',	'Lefflerland',	'Alaska',	16872,	'1-994-665-0345',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(103,	5,	2,	'Zboncak and Sons',	'Urban Sipes',	'vena.pagac@gmail.com',	'310 William Keys Suite 913',	'Corwinborough',	'Ohio',	82046,	'1-938-231-4075 x58292',	'active',	1,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(104,	5,	1,	'Homenick PLC',	'Prof. Aniyah Buckridge III',	'xlueilwitz@hotmail.com',	'632 O\'Keefe Stravenue',	'South Jamie',	'Missouri',	32194,	'372.635.2420',	'active',	1,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(105,	5,	3,	'Fadel, Bashirian and Goldner',	'Miss Audie Wuckert Jr.',	'jacklyn61@considine.com',	'570 Huel Wells',	'North Electa',	'Montana',	8527,	'880.590.9106 x5657',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(106,	5,	1,	'Hand-Fadel',	'Leonardo Kertzmann',	'derek.nader@franecki.com',	'5807 Kris Vista Apt. 302',	'Port Renehaven',	'Virginia',	20369,	'1-869-583-1686',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(107,	8,	3,	'Hill and Sons',	'Faustino McKenzie',	'marlon21@bartoletti.com',	'1164 Greenfelder Road',	'O\'Konburgh',	'Utah',	36667,	'220.753.0249 x5189',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(108,	5,	2,	'Koepp, Bechtelar and Schultz',	'Dr. Dorothy Bernier I',	'gloria.swaniawski@brakus.biz',	'1425 Goldner Drive',	'Lennastad',	'South Dakota',	49875,	'+13902201306',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(109,	5,	1,	'Becker Ltd',	'Hellen Jacobi',	'lynch.madge@kuhlman.com',	'74943 Morissette Hills Apt. 414',	'Kreigershire',	'Florida',	29737,	'+1 (208) 430-2818',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(110,	5,	1,	'Gorczany, Kling and Klocko',	'Dr. Clay Rutherford Jr.',	'pklein@treutel.com',	'19968 Aufderhar Center Suite 424',	'West Bertaburgh',	'Montana',	86034,	'1-542-445-6407 x3185',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(111,	5,	6,	'Kunde and Sons',	'Celestine Stiedemann III',	'agnes67@tillman.com',	'945 Katelyn Knoll',	'East Anafurt',	'Georgia',	13552,	'539-954-0627',	'active',	1,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(112,	5,	6,	'Renner-Konopelski',	'Prof. Luz Quigley IV',	'btowne@gmail.com',	'989 Isaac Field',	'Napoleonmouth',	'Alaska',	98361,	'1-251-232-8546 x1576',	'active',	1,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(113,	5,	4,	'Green, Cronin and Shanahan',	'Gretchen Romaguera',	'kutch.lilyan@yahoo.com',	'41463 Carlie River Suite 885',	'South Sheridan',	'South Carolina',	4785,	'1-505-889-1709',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL),
(114,	5,	3,	'Lockman-Waelchi',	'Miss Aubrey Douglas',	'jade.effertz@yahoo.com',	'5638 Volkman Neck',	'Berneicehaven',	'Missouri',	72898,	'(987) 729-5593 x66444',	'active',	0,	'2019-03-14 14:55:08',	'2019-03-14 14:55:08',	NULL);

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `migrations`;
CREATE TABLE `migrations` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1,	'2016_06_01_000001_create_oauth_auth_codes_table',	1),
(2,	'2016_06_01_000002_create_oauth_access_tokens_table',	1),
(3,	'2016_06_01_000003_create_oauth_refresh_tokens_table',	1),
(4,	'2016_06_01_000004_create_oauth_clients_table',	1),
(5,	'2016_06_01_000005_create_oauth_personal_access_clients_table',	1),
(6,	'2018_11_29_180645_create_permission_tables',	2),
(7,	'2019_01_31_055953_create_notifications_table',	2);

DROP TABLE IF EXISTS `model_has_permissions`;
CREATE TABLE `model_has_permissions` (
  `permission_id` int(10) unsigned NOT NULL,
  `model_type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`permission_id`,`model_id`,`model_type`),
  KEY `model_has_permissions_model_id_model_type_index` (`model_id`,`model_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `model_has_roles`;
CREATE TABLE `model_has_roles` (
  `role_id` int(10) unsigned NOT NULL,
  `model_type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`role_id`,`model_id`,`model_type`),
  KEY `model_has_roles_model_id_model_type_index` (`model_id`,`model_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `key` varchar(255) NOT NULL,
  `is_saas_module` tinyint(1) NOT NULL DEFAULT '0',
  `is_archived` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` int(20) unsigned NOT NULL,
  `modified_by` int(20) unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `disabled_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `module` (`id`, `name`, `key`, `is_saas_module`, `is_archived`, `created_by`, `modified_by`, `created_at`, `modified_at`, `disabled_at`) VALUES
(10,	'Users',	'staff',	0,	0,	1,	0,	'2016-01-22 01:41:27',	'2016-01-22 01:41:27',	NULL),
(11,	'Report',	'report',	0,	0,	1,	0,	'2018-12-06 07:44:21',	'2018-12-06 07:44:21',	NULL);

DROP TABLE IF EXISTS `module_pages`;
CREATE TABLE `module_pages` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `system_module_id` int(20) unsigned DEFAULT NULL,
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
  `auth_display` tinyint(3) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `system_module_id` (`system_module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `module_pages` (`id`, `system_module_id`, `parent_id`, `client_parent_id`, `name`, `client_name`, `url`, `description`, `icon`, `show_in_nav`, `is_email_notification_module`, `is_email_notification_enabled`, `route_name`, `show_in_access`, `display_order`, `display_order_client`, `auth_display`) VALUES
(1,	NULL,	0,	0,	'Dashboard',	'Dashboard',	'/dashboard',	NULL,	'icon-display4',	1,	0,	0,	'dashboard',	0,	1,	1,	7),
(4,	10,	0,	0,	'Clients',	'Clients',	'/clients',	NULL,	'icon-user',	0,	0,	0,	'clients',	1,	7,	2,	7),
(5,	10,	0,	0,	'Products',	'Products',	'/product',	NULL,	'icon-graph',	1,	0,	0,	'Products',	1,	3,	2,	7),
(6,	10,	0,	0,	'Sales Rep',	'Sales Rep',	'/salesrep',	NULL,	'far fa-id-card',	1,	0,	0,	'Sales Rep',	1,	4,	0,	1),
(7,	11,	0,	NULL,	'Tax Rules',	'Tax Rules',	'/taxrules',	NULL,	'fas fa-poll-h',	1,	0,	0,	'/taxrule',	1,	5,	0,	1),
(8,	12,	0,	NULL,	'Orders',	'Orders',	'/orders',	NULL,	'fas fa-paste',	1,	0,	0,	'/order',	1,	6,	0,	1),
(9,	14,	0,	0,	'Customers',	'Customers',	'/customers',	NULL,	'icon-user',	1,	0,	0,	'/customers',	1,	2,	0,	1),
(10,	15,	0,	0,	'Package',	'Package',	'/package',	NULL,	'far fa-id-card',	0,	0,	0,	'package',	1,	8,	0,	1);

DROP TABLE IF EXISTS `notifications`;
CREATE TABLE `notifications` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `notifiable_type` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `notifiable_id` bigint(20) unsigned NOT NULL,
  `data` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `read_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `notifications_notifiable_type_notifiable_id_index` (`notifiable_type`,`notifiable_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `oauth_access_tokens`;
CREATE TABLE `oauth_access_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `client_id` int(10) unsigned NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_access_tokens_user_id_index` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `oauth_access_tokens` (`id`, `user_id`, `client_id`, `name`, `scopes`, `revoked`, `created_at`, `updated_at`, `expires_at`) VALUES
('a9b4de4fad3c4573a1eed5af70ba734e932bb47bc127a9af26ea66b926a84be90bfcba22c6424952',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-24 02:44:22',	'2019-01-24 02:44:22',	'2020-01-24 08:14:22'),
('473a06b858aed853e5262656596bbf9850d318dac7e1559f0e8cd2d2911e4d8f7850bce09989ccba',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-24 02:46:29',	'2019-01-24 02:46:29',	'2020-01-24 08:16:29'),
('32750b47608ca6700c91074d8ffcaec4a1a01810e7a280d014ff2b4da7cdc61ccb3ebe6a8339ab1d',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:06:53',	'2019-01-29 07:06:53',	'2020-01-29 12:36:53'),
('485b5ce239730cb01d8d3dbd1cacf3cd52df46301938ee9363c3b0a04d2be88d126a1af6054e466f',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:07:08',	'2019-01-29 07:07:08',	'2020-01-29 12:37:08'),
('c52fb53e57f1b1c1f421682025b75cf5c461c6a6aa9052bab27e58958210d083024e26422c200404',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:08:24',	'2019-01-29 07:08:24',	'2020-01-29 12:38:24'),
('a3031ce72fe079dbfead12ad3ebd258d5292bd436d1277af5066acfee90fa160b76e8400fca11f0e',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:13:46',	'2019-01-29 07:13:46',	'2020-01-29 12:43:46'),
('709071db9c840fd9de0a8c6face65125ef86d78d78a469ca04eb512b451ceeea3cb4cef125604a4b',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:24:25',	'2019-01-29 07:24:25',	'2020-01-29 12:54:25'),
('63f6c7ccd57fe86180932e9b1ab158520ef197dc04553022920ee3867785512e9681fde2d128c244',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:26:39',	'2019-01-29 07:26:39',	'2020-01-29 12:56:39'),
('ec1bc78b7f97b6d35a2dc2a3eae37712d70179294224197dbf619ef340ac1e3c26b7af9b08b2dbf6',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:27:16',	'2019-01-29 07:27:16',	'2020-01-29 12:57:16'),
('9d4692720a435894392c60b2e9b58aa2cf981812eb6bbd2531c0ccd781c1c6ac15f49222606336c3',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:27:47',	'2019-01-29 07:27:47',	'2020-01-29 12:57:47'),
('22cb69ab4db9e1a38683bb540b97b649380fce099bec502da5d0859fb5fafb3fdbca1a8feb1662bd',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:37:50',	'2019-01-29 07:37:50',	'2020-01-29 13:07:50'),
('f9142ab639c0d5bb45cfd2b627a9c8ab4eac41c021745ab39941458b77512f7de445a0625487130a',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-29 07:52:44',	'2019-01-29 07:52:44',	'2020-01-29 13:22:44'),
('39517c5a1dcd456f68395a09b57a9256b7401be2b9529c4a4db8a8e79b62448424001e2390ac6b03',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-30 05:55:28',	'2019-01-30 05:55:28',	'2020-01-30 11:25:28'),
('903b44e1ec30e4fbdcb8e324725520e458087a014f49b669adeccd092932e911ed17c6fa25a3cc95',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-01-30 05:55:45',	'2019-01-30 05:55:45',	'2020-01-30 11:25:45'),
('6addcb29fc2189990b3159c57a7d44fa0e7a783a097809e8f8a1f7befbaaecfd0ced90063947a1ee',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 03:54:29',	'2019-02-01 03:54:29',	'2020-02-01 09:24:29'),
('57dc7a6f269cb5c05b5d3e54b16903d8010c7c1057848f12fc2a03370ab02df4851e9fb4bff4029f',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 03:55:16',	'2019-02-01 03:55:16',	'2020-02-01 09:25:16'),
('be87e9bfcbfa40084a2f3b728850939417be91307510ccf6b79af341725e60783b4ed11485b5f020',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 04:07:37',	'2019-02-01 04:07:37',	'2020-02-01 09:37:37'),
('9e06f9eebc24a095962d25eeeaa328413e8558130eb878d90e745bb927b3742b11f0e225fbb992f1',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 04:08:35',	'2019-02-01 04:08:35',	'2020-02-01 09:38:35'),
('e8f0a73ceaa0273d33b41f6acc3230c6418fe162577bb50b24262232587ecf0f61bc58bd80ffe112',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 04:09:48',	'2019-02-01 04:09:48',	'2020-02-01 09:39:48'),
('ab17de42e0a89fa4d0317f10feff1ec57d997e73b3b5796c4b594ff131abc58b0147ba2ca5307380',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 04:10:05',	'2019-02-01 04:10:05',	'2020-02-01 09:40:05'),
('e309c21c0d698b8fcb77959f600b0c11b558634251444859d6d37abda64de0cd269183e067c041b8',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 04:11:27',	'2019-02-01 04:11:27',	'2020-02-01 09:41:27'),
('65563aeeffa4b69251057b1c08d3ec16be7fe6f21ad2bd9000e09101b3a08e1f5f063b66038227c5',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 04:18:49',	'2019-02-01 04:18:49',	'2020-02-01 09:48:49'),
('31f70095d1700c68d44c31b43339fddbe882a7c8a12ad61fee5f38cc78d5cee8102f3a9d84c52eb4',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 04:19:23',	'2019-02-01 04:19:23',	'2020-02-01 09:49:23'),
('d5a6b202e02a6af0fb5570e6f726e426d3e837b4d1eceed8deb432cb113c554df7f5954eddb5edcf',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-01 07:03:20',	'2019-02-01 07:03:20',	'2020-02-01 12:33:20'),
('c7d2fa9f9fe12704013433783645ae8de6432497bc9b5ec9ed00e74f9ed5f20aa9402bc66d777332',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-02 01:51:52',	'2019-02-02 01:51:52',	'2020-02-02 07:21:52'),
('36bd36fc5fe4f9e8a222c6c5022d145888121fc5fbe56a70cfb32ae1bbb8720603028940dbe65999',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-02 01:58:37',	'2019-02-02 01:58:37',	'2020-02-02 07:28:37'),
('b6eebee3135eb1ecaae3fe6659dd86d336714b742fc203bf60b3dfcf1f3296d3d2b8bbc38d7aedfe',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-02 02:33:56',	'2019-02-02 02:33:56',	'2020-02-02 08:03:56'),
('7b2dd0199baacb9549940b01379a53f0443b419a2ff3ef6903f8f7f44c83c1158dd0c9e649d2931e',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-02 03:18:20',	'2019-02-02 03:18:20',	'2020-02-02 08:48:20'),
('cfaab8ade5bfebbee12f0814c97e26ce2615bac5aa993ae79f445548cf4974a47598e784ede12615',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-21 03:34:19',	'2019-02-21 03:34:19',	'2020-02-21 09:04:19'),
('7ce4dc2dcdb0258b1001aae38a332dd9ab601dd5342016982e6a41e02226c2713df816ecf514e13f',	6,	1,	'Personal Access Token',	'[]',	0,	'2019-02-21 04:00:17',	'2019-02-21 04:00:17',	'2020-02-21 09:30:17'),
('c77f807888157eb209920cbe16ef82c7b0fca51e1f19384441fbe29d9f25db36734b0f05f495ee65',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-21 04:04:37',	'2019-02-21 04:04:37',	'2020-02-21 09:34:37'),
('0501f42ee17b83e07a4e25b786fc891b97293257ceaaf99bf782ab6bffa385477a4d7b25c0630f85',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-21 22:16:29',	'2019-02-21 22:16:29',	'2020-02-22 03:46:29'),
('3bcd1b642e173b0d098f99e152083cd07ea760d4e40e755be91178e98466411c37b6a4b89aa3b20a',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-22 00:53:18',	'2019-02-22 00:53:18',	'2020-02-22 06:23:18'),
('ad6c851bacb307255c178305033c209e1690dfb27f2b2984d9526e4fffede3747acf9c76693c44c4',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-22 00:58:00',	'2019-02-22 00:58:00',	'2020-02-22 06:28:00'),
('4b8f4a37fbae95cf290c5bc260e40fce32cd21d248858c70f323b8a37decbd8f492fd9520e5fe420',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-22 00:58:17',	'2019-02-22 00:58:17',	'2020-02-22 06:28:17'),
('489eb108ff1d834793598d719fa6d492cd5022a12bf3137ea63393eee539119fd8caea894086df0e',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:21:52',	'2019-02-23 05:21:52',	'2020-02-23 10:51:52'),
('813f36edc3252952bad6943aa0ff095176a11f15aab2071d2aea88df218256522b639a58595d597e',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:26:06',	'2019-02-23 05:26:06',	'2020-02-23 10:56:06'),
('9d50d83db8432fb4728a41bbd2585396b01a0732fa54d6cc6bf03345dc8bcf458275aa99e9ede595',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:28:08',	'2019-02-23 05:28:08',	'2020-02-23 10:58:08'),
('aaea1db7c6e90636c306c6c2b1506385d674d5a75089d67f0db14aa8741ede94e64a9f737eca1f96',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:29:55',	'2019-02-23 05:29:55',	'2020-02-23 10:59:55'),
('6df431fd53c03629c3ecddad520a7c3a4b68aa37bf68d74ee682f06f5e3c17b845df10263397272a',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:30:56',	'2019-02-23 05:30:56',	'2020-02-23 11:00:56'),
('81e994eca0c2c3a0e37e61c62a57e409d3744e829a2ae90b97be7d5dadb49706569cd488a4442ad9',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:32:30',	'2019-02-23 05:32:30',	'2020-02-23 11:02:30'),
('87412dbd9801230537d3fb83362df31b8744c46495f56f47bc2a8423c32fc06333a738da40b4bac3',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:34:43',	'2019-02-23 05:34:43',	'2020-02-23 11:04:43'),
('ac59fbcbf71197accd33b2dab73c1940d7663782407d336fedf2d8f4ac9afa1371e7b390fe92f2b8',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:35:18',	'2019-02-23 05:35:18',	'2020-02-23 11:05:18'),
('f3b93f683d3e2c23d7f2e8fefae74801f257bdc60a105d1c297392208565a754caced1a87240d98b',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:36:02',	'2019-02-23 05:36:02',	'2020-02-23 11:06:02'),
('a8ab2889750e2920c245ba366a0b9f5d4bfe8a432dd8120489304acbab0744eed0b7a3f5746e11aa',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:37:54',	'2019-02-23 05:37:54',	'2020-02-23 11:07:54'),
('16bac3534d77a1103739f225d5d78822ae9fc31b1507ae06de2e4356ade50b7d69a1aa530cdc1f90',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:38:55',	'2019-02-23 05:38:55',	'2020-02-23 11:08:55'),
('aa074ae88ea06d7a4b589861b6302570fd603e99feeb9b8d08ce93683744d992efa662070d4294ae',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:44:25',	'2019-02-23 05:44:25',	'2020-02-23 11:14:25'),
('a62f5b5e1d07b68cbded6120846704f35f7817d9050b3349acecc34cca2c9ecc23e1363776ea0c6c',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:46:22',	'2019-02-23 05:46:22',	'2020-02-23 11:16:22'),
('ecc027ef0ef1925c218808949ac91cff8ac72afafa6b30470e090869cc2f2468482781890ff96222',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-23 05:46:59',	'2019-02-23 05:46:59',	'2020-02-23 11:16:59'),
('dfd62915dfb37d1a823f394204ab44b7fff222dbed3b6d1e82a6e10ebe118869be097e604a1596d1',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-24 06:59:51',	'2019-02-24 06:59:51',	'2020-02-24 12:29:51'),
('f8305bbb95d39174e6325b82ce54a2a0103f71790b65c32956bcf03b7de879d16ab5cffe95b7294e',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-02-24 07:10:00',	'2019-02-24 07:10:00',	'2020-02-24 12:40:00'),
('bba0572122db8b00a8aedf1ae0acdf6a94bcc03480c6ee0cdb6896eb49d642713ba03805644bf240',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-03-05 15:14:34',	'2019-03-05 15:14:34',	'2020-03-05 16:14:34'),
('682afb7235a260d84c61cfe6e307f5ad5ec57af6f471cb43bf4fe7bdde80bd8091e2ee0241a3b33e',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-03-05 15:19:46',	'2019-03-05 15:19:46',	'2020-03-05 16:19:46'),
('d28253cb839e5ebcf7e6c08c30cf80dbdebc53d96fc60ba15a0926ac553b0cc8d1a64e4d2ff74d80',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-03-05 15:24:53',	'2019-03-05 15:24:53',	'2020-03-05 16:24:53'),
('2902cd50f0b0b0ac928d7f6fff110e651a7a5b0dd076358fefeadc1117002c1f8118103c9347fe7e',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-03-05 15:27:12',	'2019-03-05 15:27:12',	'2020-03-05 16:27:12'),
('2dfbf0c2a80468b56eb135d26c2ca9d2a0387c66fe592dd757ed277ad04c64d61d004f60dd2115b4',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-03-11 09:58:49',	'2019-03-11 09:58:49',	'2020-03-11 15:28:49'),
('f2888003d800f17b8e13629422612e5d9063ac7b1e5eaa6e08fdd0e135c05ec2323c3dc37239fe11',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-03-11 10:02:10',	'2019-03-11 10:02:10',	'2020-03-11 15:32:10'),
('83014895e4cb9baa05256dbb109062649888a36641568939fdc055a40a945a0fa866450d7338023d',	8,	1,	'Personal Access Token',	'[]',	0,	'2019-03-15 09:08:29',	'2019-03-15 09:08:29',	'2020-03-15 14:38:29'),
('e3e53ba0010890e97e03cc048c3adcfaefe9402b4ccdefabaeca4fc6c1dc2fd26add9813c4f93b18',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-03-15 09:19:50',	'2019-03-15 09:19:50',	'2020-03-15 14:49:50'),
('51a65afa1f6fd242fcd0c11ae1f30dc8d37005056551688b7b995a9e482aca6815cc37100b331172',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-04-02 03:06:33',	'2019-04-02 03:06:33',	'2020-04-02 08:36:33'),
('233edb7a126fb8de0472b02b81f92c1d6548ecde5a6cccddf6b739933352552e7566c3631112d932',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-04-02 03:41:34',	'2019-04-02 03:41:34',	'2020-04-02 09:11:34'),
('a758565cfeaf2e371fcb0bd89f57bceb2eb602b46e35fe3f742061a7141d46778513aa65e3b35249',	5,	1,	'Personal Access Token',	'[]',	0,	'2019-04-03 04:46:06',	'2019-04-03 04:46:06',	'2020-04-03 10:16:06');

DROP TABLE IF EXISTS `oauth_auth_codes`;
CREATE TABLE `oauth_auth_codes` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `client_id` int(10) unsigned NOT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `oauth_clients`;
CREATE TABLE `oauth_clients` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `oauth_clients` (`id`, `user_id`, `name`, `secret`, `redirect`, `personal_access_client`, `password_client`, `revoked`, `created_at`, `updated_at`) VALUES
(1,	NULL,	'Laravel Personal Access Client',	'WSEACQzpEg707Ja5hrTdDuevkzNULXvWcsEyoZcP',	'http://localhost',	1,	0,	0,	'2019-01-24 00:39:41',	'2019-01-24 00:39:41'),
(2,	NULL,	'Laravel Password Grant Client',	'szw7OEEDbYDp8CxOcY1P9jbw8nHOJVw20SrOVMCw',	'http://localhost',	0,	1,	0,	'2019-01-24 00:39:41',	'2019-01-24 00:39:41');

DROP TABLE IF EXISTS `oauth_personal_access_clients`;
CREATE TABLE `oauth_personal_access_clients` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_personal_access_clients_client_id_index` (`client_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `oauth_personal_access_clients` (`id`, `client_id`, `created_at`, `updated_at`) VALUES
(1,	1,	'2019-01-24 00:39:41',	'2019-01-24 00:39:41');

DROP TABLE IF EXISTS `oauth_refresh_tokens`;
CREATE TABLE `oauth_refresh_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `access_token_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `oauth_refresh_tokens_access_token_id_index` (`access_token_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned NOT NULL,
  `customer_id` int(11) NOT NULL,
  `sale_rep_id` int(10) unsigned NOT NULL,
  `tax_rule_id` int(10) unsigned NOT NULL,
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
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`sale_rep_id`) REFERENCES `sale_reps` (`id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`tax_rule_id`) REFERENCES `tax_rules` (`id`),
  CONSTRAINT `orders_ibfk_4` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `orders` (`order_id`, `client_id`, `customer_id`, `sale_rep_id`, `tax_rule_id`, `invoice_no`, `order_type`, `is_posted`, `notes`, `signature`, `created_at`, `updated_at`, `deleted_at`) VALUES
(164,	5,	19,	8,	5,	'SalesOrder-8-1',	'SalesOrder',	0,	'hello world',	'85ca42f9886cf8.jpg',	'2019-04-02 03:16:23',	'2019-04-08 03:00:56',	NULL),
(165,	5,	19,	8,	5,	'SalesOrder-8-2',	'SalesOrder',	0,	'hello world',	'85ca42f9886cf8.jpg',	'2019-04-02 03:16:23',	'2019-04-08 03:00:56',	NULL),
(166,	5,	19,	8,	5,	'SalesOrder-8-3',	'SalesOrder',	0,	'hello world',	'85ca42f9886cf8.jpg',	'2019-04-02 03:16:23',	'2019-04-08 03:00:56',	NULL),
(167,	5,	106,	8,	5,	'SalesOrder-8-4',	'SalesOrder',	0,	'hello world',	'85ca42f9886cf8.jpg',	'2019-05-02 03:16:23',	'2019-04-08 03:00:57',	NULL),
(168,	5,	3,	8,	5,	'SalesOrder-8-5',	'SalesOrder',	0,	'hello world',	'85ca42f9886cf8.jpg',	'2019-05-02 03:16:23',	'2019-04-08 03:00:57',	NULL),
(169,	5,	18,	8,	5,	'SalesOrder-8-6',	'SalesOrder',	0,	'hello world',	'85ca42f9886cf8.jpg',	'2019-04-02 03:16:23',	'2019-04-08 03:00:57',	NULL),
(170,	5,	74,	8,	5,	'SalesOrder-8-7',	'SalesOrder',	0,	'hello world',	'85ca42f9886cf8.jpg',	'2018-04-02 03:16:23',	'2019-04-08 03:00:58',	NULL),
(171,	5,	113,	8,	5,	'SalesOrder-8-8',	'SalesOrder',	0,	'hello world',	NULL,	'2018-04-02 03:16:23',	'2019-04-08 03:00:58',	NULL),
(172,	5,	114,	8,	5,	'SalesOrder-8-9',	'SalesOrder',	0,	'hello world',	NULL,	'2018-04-02 03:16:23',	'2019-04-08 03:00:58',	NULL),
(173,	5,	107,	8,	5,	'SalesOrder-8-10',	'SalesOrder',	0,	'hello world',	NULL,	'2018-04-02 03:16:23',	'2019-04-08 03:00:59',	NULL),
(174,	5,	19,	8,	5,	'SalesOrder-8-11',	'SalesOrder',	0,	'hello world',	NULL,	'2018-04-02 03:16:23',	'2019-04-08 03:00:59',	NULL),
(175,	5,	95,	8,	5,	'SalesOrder-8-12',	'SalesOrder',	0,	'hello world',	NULL,	'2019-03-02 03:16:23',	'2019-04-08 03:00:59',	NULL);

DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `client_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  `price` double(10,2) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`),
  CONSTRAINT `order_details_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `order_details_ibfk_3` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `order_details` (`id`, `order_id`, `client_id`, `product_id`, `quantity`, `price`) VALUES
(303,	164,	5,	2,	3,	10.00),
(304,	164,	5,	3,	4,	10.00),
(305,	165,	5,	2,	3,	10.00),
(306,	165,	5,	3,	4,	10.00),
(307,	166,	5,	2,	3,	10.00),
(308,	166,	5,	3,	4,	10.00),
(309,	167,	5,	2,	3,	10.00),
(310,	167,	5,	3,	4,	10.00),
(311,	168,	5,	2,	3,	10.00),
(312,	168,	5,	3,	4,	10.00),
(313,	169,	5,	2,	3,	10.00),
(314,	169,	5,	3,	4,	10.00),
(315,	170,	5,	2,	3,	10.00),
(316,	170,	5,	3,	4,	10.00),
(317,	171,	5,	2,	3,	10.00),
(318,	171,	5,	3,	4,	10.00),
(319,	172,	5,	2,	3,	10.00),
(320,	172,	5,	3,	4,	10.00),
(321,	173,	5,	2,	3,	10.00),
(322,	173,	5,	3,	4,	10.00),
(323,	174,	5,	2,	3,	10.00),
(324,	174,	5,	3,	4,	10.00),
(325,	175,	5,	2,	3,	10.00),
(326,	175,	5,	3,	4,	10.00);

DROP TABLE IF EXISTS `package`;
CREATE TABLE `package` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `validity` int(11) NOT NULL,
  `max_customers` int(11) DEFAULT NULL,
  `max_sales_rep` int(11) DEFAULT NULL,
  `max_products` int(11) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `package` (`id`, `name`, `validity`, `max_customers`, `max_sales_rep`, `max_products`, `price`, `status`) VALUES
(1,	'Free Trial',	7,	10,	10,	50,	0,	1),
(2,	'Silver Package',	90,	50,	15,	200,	299,	1),
(3,	'Gold Package',	180,	70,	20,	500,	499,	1),
(4,	'Platinum Package',	365,	100,	35,	1000,	999,	1),
(5,	'Premium Package',	365,	NULL,	NULL,	NULL,	1499,	1),
(6,	'new',	8,	3,	6,	3,	10,	0);

DROP TABLE IF EXISTS `password_resets`;
CREATE TABLE `password_resets` (
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `password_resets_type_index` (`type`),
  KEY `password_resets_email_index` (`email`),
  KEY `password_resets_token_index` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `password_resets` (`type`, `email`, `token`, `created_at`) VALUES
('',	'abcd@gmail.com',	'$2y$10$Z5nGvdRvASd7R/OLA1Q4EePahnAKcM.DndPfJQemDBnDb6vdf6Usy',	'2019-02-01 03:07:40'),
('',	'aashishgnubca@gmail.com',	'$2y$10$D83TrNl0DFmGe2D4.vcks.w/bFY9pvkFcNuwbKgqrSizRIlT4LQze',	'2019-03-13 09:14:59');

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `guard_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned NOT NULL,
  `barcodeno` text,
  `name` varchar(200) NOT NULL,
  `price` double(10,2) unsigned NOT NULL,
  `cost` double(10,2) unsigned DEFAULT NULL,
  `quantity` int(100) unsigned DEFAULT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `is_taxable` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `products` (`id`, `client_id`, `barcodeno`, `name`, `price`, `cost`, `quantity`, `is_active`, `is_taxable`, `created_at`, `updated_at`, `deleted_at`) VALUES
(2,	5,	'2343454',	'Balaji Tomato Masti',	200.00,	17.00,	67,	1,	1,	'2018-12-21 02:39:32',	'2019-04-02 05:49:19',	NULL),
(3,	5,	'112324323',	'Balaji Sev Mamara',	20.00,	17.00,	0,	1,	1,	'2018-12-21 02:39:32',	'2019-04-02 05:49:19',	NULL),
(4,	5,	'2343556434',	'Balaji Farali',	25.00,	20.00,	94,	1,	1,	'2018-12-21 02:39:32',	'2019-03-13 08:57:17',	NULL),
(6,	5,	'536284537',	'Balaji Pop Ring',	10.00,	7.00,	92,	1,	0,	'2018-12-29 09:03:14',	'2019-03-13 08:57:17',	NULL),
(7,	5,	'783648345',	'Balaji Pizzy',	10.00,	7.00,	100,	1,	0,	'2019-01-05 04:00:03',	'2019-03-05 15:26:57',	NULL),
(8,	5,	'82253783',	'Balaji Magic Masala Small',	10.00,	7.00,	100,	1,	0,	'2019-02-08 12:32:45',	'2019-03-05 15:27:13',	NULL),
(9,	5,	'8254827',	'Balaji Cream & Onion Small',	10.00,	7.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-03-05 15:27:25',	NULL),
(10,	5,	'263723845738',	'Balaji Magic Masala Large',	20.00,	17.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(11,	5,	'37823569',	'Balaji Cream & Onion Large',	20.00,	17.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(12,	5,	'384633923',	'Balaji Khatta Mith Mix Small',	10.00,	7.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(13,	5,	'87236847692',	'Balaji Simpe Salted Small',	10.00,	7.00,	100,	1,	0,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(14,	5,	'36728468912379',	'Balaji Chat Chaska Small',	10.00,	7.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(15,	5,	'7236846297',	'Balaji Khatta Mith Mix',	20.00,	14.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(16,	5,	'762384',	'Balaji Simpe Salted Large',	20.00,	14.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(17,	5,	'6358726438',	'Balaji Chat Chaska',	20.00,	17.00,	100,	1,	1,	'2019-02-08 12:32:45',	'2019-02-08 12:32:45',	NULL),
(19,	8,	'76817298382068767',	'Aciclovir tab 200 mg',	50.00,	40.00,	100,	1,	1,	'2019-03-03 08:32:50',	'2019-03-03 08:32:50',	NULL),
(20,	8,	'726342800',	'Amitriptyline tab 25 mg',	100.00,	90.00,	100,	0,	0,	'2019-03-03 03:44:31',	'2019-03-03 09:30:10',	NULL),
(21,	8,	'8764836',	' Amoxicillin cap 250 mg ',	180.00,	160.00,	100,	0,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(22,	8,	'25233234',	'Artesunate tab 100 mg ',	50.00,	45.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(23,	8,	'343534246',	'Atenolol tab 50 mg',	39.00,	36.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(24,	8,	'23425346',	'Beclomethasone inhaler 50 mg/dose ',	127.00,	120.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(25,	8,	'324324365',	' Captopril tab 25 mg',	134.00,	130.00,	100,	0,	1,	'2019-03-03 03:44:31',	'2019-03-03 09:30:17',	NULL),
(26,	8,	'234345464',	' Carbmazepine tab 200 mg ',	166.00,	150.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(27,	8,	'3543645734',	' Ceftriaxone inj 1 g powder',	88.00,	60.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(28,	8,	'3543453',	' Diclofenac tab 25 mg ',	88.00,	60.00,	100,	0,	1,	'2019-03-03 03:44:31',	'2019-03-03 09:30:13',	NULL),
(29,	8,	'43564737',	' Fluoxetine tab 20 mg',	35.00,	30.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(30,	8,	'3465646',	'Losartan tab 50 mg',	30.00,	25.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(31,	8,	'328453897',	' Lovastatin tab 20 mg ',	25.00,	18.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(32,	8,	'34234545',	' Metformin tab 500 mg ',	20.00,	15.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(33,	8,	'3242353',	' Nevirapine tab 200 mg 24',	10.00,	9.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL),
(34,	8,	'345677890987654',	'Nifedipine Retard tab 20 mg ',	90.00,	78.00,	100,	1,	1,	'2019-03-03 03:44:31',	'2019-03-03 03:44:31',	NULL);

DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `registration` (`id`, `client_id`, `registration_id`, `status`, `price`, `transaction_id`, `payment_mode`, `currency`, `created_at`, `updated_at`) VALUES
(6,	34,	'5c98b4f8657f2',	'pending',	'499',	'',	NULL,	NULL,	'2019-03-25 11:01:12',	'2019-03-25 11:01:12'),
(7,	29,	'5c99f8702a21b',	'complete',	'299',	'20190326111212800110168976000362051',	'PPI',	'INR',	'2019-03-26 10:02:28',	'2019-03-26 10:02:28'),
(8,	30,	'5c99fa61760ee',	'complete',	'499',	'20190326111212800110168454300356542',	'PPI',	'INR',	'2019-03-26 10:10:02',	'2019-03-26 10:10:02'),
(9,	5,	'5ca1dd4ae34ba',	'complete',	'299',	'20190401111212800110168329600371370',	'NB',	'INR',	'2019-04-01 09:46:10',	'2019-04-01 09:46:10'),
(10,	5,	'5ca1df1589650',	'pending',	'1499',	'',	NULL,	NULL,	'2019-04-01 09:51:17',	'2019-04-01 09:51:17'),
(11,	5,	'5ca1969071ecb',	'complete',	'1499',	'20190401111212800110168108700365014',	'NB',	'INR',	'2019-04-01 04:42:11',	'2019-04-01 04:42:11'),
(12,	5,	'5ca2f9cc6ac54',	'complete',	'299',	'20190402111212800110168016700372468',	'NB',	'INR',	'2019-04-02 06:04:12',	'2019-04-02 06:04:12'),
(13,	5,	'5ca2fb8c8c6ee',	'pending',	'',	'',	NULL,	NULL,	'2019-04-02 06:05:00',	'2019-04-02 06:05:00'),
(14,	33,	'5caefdf922316',	'complete',	'999',	'20190411111212800110168997300391549',	'NB',	'INR',	'2019-04-11 08:43:20',	'2019-04-11 08:43:20');

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `guard_name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `role_has_permissions`;
CREATE TABLE `role_has_permissions` (
  `permission_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`permission_id`,`role_id`),
  KEY `role_has_permissions_role_id_foreign` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


DROP TABLE IF EXISTS `sale_reps`;
CREATE TABLE `sale_reps` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned NOT NULL,
  `initial` varchar(50) NOT NULL,
  `region` varchar(100) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `sale_reps_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `sale_reps` (`id`, `client_id`, `initial`, `region`, `is_active`, `created_at`, `deleted_at`, `updated_at`) VALUES
(1,	5,	'sagar',	'Ghatlodia',	1,	'2019-03-05 16:34:19',	NULL,	'2019-03-05 15:34:19'),
(2,	5,	'nikhil',	'Science City',	1,	'2019-03-05 16:34:09',	NULL,	'2019-03-05 15:34:09'),
(3,	5,	'suhas',	'Pakwan',	1,	'0000-00-00 00:00:00',	NULL,	'2019-02-02 04:38:30'),
(4,	5,	'meet',	'lal darwaza',	1,	'0000-00-00 00:00:00',	NULL,	'2019-01-05 04:50:53'),
(6,	5,	'suraj',	'Ranip',	1,	'2019-03-05 16:33:57',	NULL,	'2019-03-05 15:33:57'),
(7,	5,	'kaushal',	'mehsana',	1,	'2019-02-21 18:30:00',	NULL,	NULL),
(8,	5,	'aashish',	'lal darwaza',	1,	'2019-02-21 18:30:00',	NULL,	NULL),
(9,	5,	'HK',	'wadaj',	1,	'2019-01-03 07:02:17',	NULL,	NULL),
(10,	8,	'ketan',	'sola',	1,	'2019-03-03 08:39:00',	NULL,	'2019-03-03 08:39:00'),
(11,	8,	'Aashish',	'Science City',	1,	'2019-03-03 08:39:17',	NULL,	'2019-03-03 08:39:17'),
(12,	8,	'Kaushal',	'Jamalpur',	1,	'2019-03-03 08:39:34',	NULL,	'2019-03-03 08:39:34'),
(13,	8,	'Jatin',	'Gurukul',	1,	'2019-03-03 08:40:09',	NULL,	'2019-03-03 08:40:09'),
(14,	8,	'H.K.',	'Wadaj',	1,	'2019-03-03 08:40:30',	NULL,	'2019-03-03 08:40:30'),
(15,	5,	'sa',	'sd',	1,	'2019-03-22 09:26:35',	NULL,	'2019-03-22 09:26:35');

DROP TABLE IF EXISTS `super_admins`;
CREATE TABLE `super_admins` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `super_admins` (`id`, `name`, `email`, `password`, `remember_token`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1,	'Aashish Pathak',	'aashishgnubca@gmail.com',	'0000',	NULL,	'2018-12-21 02:39:32',	'2018-12-21 02:39:32',	NULL),
(2,	'Aashish',	'aashishgnubca2@gmail.com',	'$2y$10$PMKOILm0Dqvggibk4sp6E.ecxxvOGlr/hIt9X6QSkU5fwum63WJt.',	NULL,	'2019-02-03 05:03:23',	'2019-02-03 05:03:23',	NULL),
(3,	'',	'abcd@gmail.com',	'$2y$10$YSNFQASGddmCGE7JnsfCMORhE92FiaS6FVYauPxcBDpUQNUjf6cye',	NULL,	'2019-03-18 10:32:21',	'2019-03-18 10:32:21',	NULL);

DROP TABLE IF EXISTS `sync_log`;
CREATE TABLE `sync_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned NOT NULL,
  `sales_rep_id` int(10) unsigned NOT NULL,
  `last_sync_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `sync_status` varchar(100) DEFAULT 'Pending',
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `sales_rep_id` (`sales_rep_id`),
  CONSTRAINT `sync_log_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE CASCADE,
  CONSTRAINT `sync_log_ibfk_2` FOREIGN KEY (`sales_rep_id`) REFERENCES `sale_reps` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `sync_log` (`id`, `client_id`, `sales_rep_id`, `last_sync_date`, `sync_status`) VALUES
(1,	5,	3,	NULL,	'Pending'),
(2,	5,	1,	NULL,	'Pending'),
(3,	5,	7,	NULL,	'Pending'),
(10,	5,	9,	NULL,	'Pending'),
(27,	5,	8,	NULL,	'Pending');

DROP TABLE IF EXISTS `tax_rules`;
CREATE TABLE `tax_rules` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `client_id` int(10) unsigned NOT NULL,
  `name` varchar(100) NOT NULL,
  `rate` double unsigned NOT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  CONSTRAINT `tax_rules_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `tax_rules` (`id`, `client_id`, `name`, `rate`, `updated_at`, `deleted_at`) VALUES
(1,	5,	'50% GST',	50,	NULL,	NULL),
(2,	5,	'10% GST',	10,	NULL,	NULL),
(3,	5,	'18% GST',	18,	NULL,	NULL),
(4,	5,	'15% tax',	15,	NULL,	NULL),
(5,	5,	'19% Tax',	19,	NULL,	NULL),
(6,	5,	'No Tax',	0,	NULL,	NULL),
(7,	8,	'50% Tax',	50,	NULL,	NULL),
(8,	8,	'25% Tax',	25,	NULL,	NULL),
(9,	8,	'18% Tax',	18,	NULL,	NULL),
(10,	8,	'10% Tax',	10,	NULL,	NULL),
(11,	8,	'5% Tax',	5,	NULL,	NULL);

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `users` (`id`, `name`, `email`, `password`, `image`, `role`, `mobile_no`, `phone_no`, `last_login`, `login_since`, `status`, `confirmed`, `remember_token`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1,	'Sandip Sathavara333',	'sandip@wims.com',	'$2y$10$tdOtu6Y5lT5CgtydvPxOm.buVUWXfmsbZab2bPlnZ1d7Es0pxAmti',	'5c1a1e3db92a1.jpg',	'super',	'9624618989',	'',	'2019-02-04 03:37:44',	'2019-02-04 03:37:44',	1,	1,	'spApoVUG8C1tzBbmnXYWcSt0lFwIpUO41a9AIJZFxNBy0MtCYLy06TGAB2DQ',	'2016-09-08 04:00:27',	'2019-02-04 03:37:44',	NULL),
(140,	'Sandip',	'sandip@asd.com',	'$2y$10$YZmgQcPGPYolBXMSh5K0nuRm3wtSnQ7btxrUIMO0M9ViEgxttyVde',	'avatar.png',	'super',	'1234567489',	NULL,	'2018-12-26 08:41:49',	'2018-12-26 08:41:49',	1,	0,	'wcHIOxn87EMAs3vtf0jVFw5cM7x0CI5zcDPa7GMjqf6DjFMsuW15y6tAOaGD',	'2018-11-29 09:10:21',	'2018-12-26 03:11:49',	NULL),
(148,	'Aashish',	'aashishgnubca@gmail.com',	'$2y$10$n/ft8mtAA4cPQLRn0jSiD.YCoaXZN/Aa6GkryWaO9WOSDZRl/0OAu',	'avatar.png',	'staff',	'',	NULL,	'2018-12-29 15:15:42',	'2018-12-29 15:15:42',	1,	0,	'0Rn3wmepsxR7wQ7OdschLoSqaGrbNaa9RXnbHrCxV5fj8E1CsJwFRbhWDi1W',	'2018-12-29 09:45:03',	'2018-12-29 09:45:03',	NULL);

DROP TABLE IF EXISTS `user_access`;
CREATE TABLE `user_access` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(20) unsigned NOT NULL,
  `system_pages_id` int(10) unsigned NOT NULL,
  `view_access` tinyint(1) DEFAULT NULL,
  `assigned_by` int(20) unsigned NOT NULL,
  `assigned_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user_access` (`id`, `user_id`, `system_pages_id`, `view_access`, `assigned_by`, `assigned_at`) VALUES
(9,	121,	1,	NULL,	140,	'2018-12-03 09:24:00'),
(10,	121,	4,	NULL,	140,	'2018-12-03 09:24:00');

-- 2019-04-30 01:46:57
