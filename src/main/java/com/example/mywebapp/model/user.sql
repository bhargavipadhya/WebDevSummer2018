CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;
SELECT `user`.`id`,
    `user`.`first_name`,
    `user`.`last_name`,
    `user`.`password`,
    `user`.`username`,
    `user`.`role`,
    `user`.`dob`,
    `user`.`email`,
    `user`.`phone`
FROM `heroku_7cbb72ab1719fca`.`user`;SELECT `user`.`id`,
    `user`.`first_name`,
    `user`.`last_name`,
    `user`.`password`,
    `user`.`username`,
    `user`.`role`,
    `user`.`dob`,
    `user`.`email`,
    `user`.`phone`
FROM `heroku_7cbb72ab1719fca`.`user`;

SELECT `user`.`id`,
    `user`.`first_name`,
    `user`.`last_name`,
    `user`.`password`,
    `user`.`username`,
    `user`.`role`,
    `user`.`dob`,
    `user`.`email`,
    `user`.`phone`
FROM `heroku_7cbb72ab1719fca`.`user`;
