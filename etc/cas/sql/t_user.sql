CREATE TABLE `t_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL COMMENT '用户名',
	`password` VARCHAR(128) NOT NULL COMMENT '用户密码',
	PRIMARY KEY (`id`)
)
COMMENT='用户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;