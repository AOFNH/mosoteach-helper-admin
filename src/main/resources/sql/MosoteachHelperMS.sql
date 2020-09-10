CREATE TABLE `func_function` (
`fc_id` bigint NOT NULL AUTO_INCREMENT,
`fc_no` int(11) NULL,
`fc_name` varchar(50) NULL,
`fc_status` int(5) NULL DEFAULT 1,
`fc_hits` bigint NULL DEFAULT 0,
PRIMARY KEY (`fc_id`) 
);
CREATE TABLE `sys_user` (
`usr_id` bigint NOT NULL AUTO_INCREMENT,
`usr_role_id` bigint NULL,
`usr_name` varchar(100) NULL,
`usr_password` varchar(100) NULL,
`usr_role_name` varchar(100) NULL,
`usr_flag` int NULL DEFAULT 1,
PRIMARY KEY (`usr_id`) 
);
CREATE TABLE `func_hits` (
`ht_id` bigint NOT NULL AUTO_INCREMENT,
`ht_fc_id` bigint NOT NULL,
`ht_date` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`ht_usr_id` bigint NOT NULL DEFAULT 0,
PRIMARY KEY (`ht_id`) 
);
CREATE TABLE `sys_role` (
`role_id` bigint NOT NULL AUTO_INCREMENT,
`role_name` varchar(100) NULL,
`role_desc` varchar(100) NULL,
`role_flag` int NULL DEFAULT 1,
PRIMARY KEY (`role_id`) 
);

ALTER TABLE `func_hits` ADD CONSTRAINT `FK_Func_hits_Func_function` FOREIGN KEY (`ht_fc_id`) REFERENCES `func_function` (`fc_id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `sys_user` ADD CONSTRAINT `FK_Sys_user_Sys_role` FOREIGN KEY (`usr_role_id`) REFERENCES `sys_role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE `func_hits` ADD CONSTRAINT `FK_Func_hits_Sys_user` FOREIGN KEY (`ht_usr_id`) REFERENCES `sys_user` (`usr_id`) ON DELETE CASCADE ON UPDATE CASCADE;

