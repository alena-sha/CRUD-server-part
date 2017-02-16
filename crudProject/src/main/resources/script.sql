CREATE DATABASE `employee` /*!40100 DEFAULT CHARACTER SET cp1251 */;
set character_set_database=cp1251;
set character_set_server=cp1251;


DROP TABLE IF EXISTS `employee`.`Employee`;
CREATE TABLE `employee`.`Employee` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
`gender` varchar(6) DEFAULT NULL,
`dateOfBirth` datetime NOT NULL ,
`position` varchar(50) DEFAULT NULL,
`comment` varchar(30) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
`password` varchar(30) DEFAULT NULL,
`image` LONGBLOB DEFAULT NULL, 
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `employee`.`Task`;
CREATE TABLE `employee`.`Task` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(100) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `priority` int(10) unsigned DEFAULT NULL,
  `employee` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
);
INSERT INTO `employee`.`Employee` (`firstName`, `lastName`,`gender`, `yearOfBirth`, `position`,`comment`, `login`,`password`) VALUES
    ('Ivan', 'Ivanov','m',1986,'director','la-la-la','asa','asa');
INSERT INTO `employee`.`Employee` (`firstName`, `lastName`,`gender`, `yearOfBirth`, `position`,`comment`, `login`,`password`) VALUES
     ('Petr', 'Petrov','m',1986,'engineer','b-b-b','dsa','dsa');
INSERT INTO `employee`.`Task` (`name`, `content`,`priority`, `employee`) VALUES
     ('write docs', 'write documentation for current project',1,1);


