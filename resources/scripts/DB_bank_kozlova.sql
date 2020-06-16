CREATE DATABASE IF NOT EXISTS `Bank` DEFAULT CHARACTER SET utf8 ;
USE `Bank` ;
-- -----------------------------------------------------
-- Table `Bank`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bank`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) UNIQUE NOT NULL,
  `surname` VARCHAR(45) UNIQUE  NOT NULL,
  PRIMARY KEY (`id`));
-- -----------------------------------------------------
-- Table `Bank`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Bank`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` INT NOT NULL,
  `user_id` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_account_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `Bank`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);