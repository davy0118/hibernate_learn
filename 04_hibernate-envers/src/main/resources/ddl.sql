CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `revinfo` (
  `rev` int NOT NULL AUTO_INCREMENT,
  `revtstmp` bigint DEFAULT NULL,
  PRIMARY KEY (`REV`)
);
CREATE TABLE `t_user_aud` (
  `id` bigint NOT NULL,
  `rev` int NOT NULL,
  `revtype` tinyint DEFAULT NULL,
  `age` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`REV`),
  KEY `FK8pj32jr5ggf21fdquo1dos76` (`REV`),
  CONSTRAINT `FK8pj32jr5ggf21fdquo1dos76` FOREIGN KEY (`REV`) REFERENCES `revinfo` (`REV`)
);