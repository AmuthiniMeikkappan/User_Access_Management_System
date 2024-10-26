CREATE SCHEMA `access_managements` ;

-- create users table --

CREATE TABLE `access_managements`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);
  
  -- create software table -- 
  CREATE TABLE `access_managements`.`software` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(100) NULL,
  `access_levels` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

-- create requests table -- 
CREATE TABLE `access_managements`.`request` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `software_id` INT NULL,
  `access_type` VARCHAR(45) NULL,
  `reason` VARCHAR(150) NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `software_id_idx` (`software_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `access_management`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `software_id`
    FOREIGN KEY (`software_id`)
    REFERENCES `access_management`.`software` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 