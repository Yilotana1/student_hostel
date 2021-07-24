SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Table `user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_role` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `floor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `floor` (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `number` INT NOT NULL,
                                              `apartments_count` INT NULL,
                                              `head_student` INT NULL,
                                              PRIMARY KEY (`id`),
    UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE,
    INDEX `fk_floor_user1_idx` (`head_student` ASC) VISIBLE,
    CONSTRAINT `fk_floor_user1`
    FOREIGN KEY (`head_student`)
    REFERENCES `user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `apartment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apartment_type` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `apartment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apartment` (
                                                  `id` INT NOT NULL AUTO_INCREMENT,
                                                  `number` VARCHAR(45) NOT NULL,
    `floor_id` INT NOT NULL,
    `type_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `number_UNIQUE` (`number` ASC) VISIBLE,
    INDEX `fk_apartment_floor1_idx` (`floor_id` ASC) VISIBLE,
    INDEX `fk_apartment_apartment_type1_idx` (`type_id` ASC) VISIBLE,
    CONSTRAINT `fk_apartment_floor1`
    FOREIGN KEY (`floor_id`)
    REFERENCES `floor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_apartment_apartment_type1`
    FOREIGN KEY (`type_id`)
    REFERENCES `apartment_type` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `phone` VARCHAR(45) NOT NULL,
    `username` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NULL,
    `password` VARCHAR(255) NOT NULL,
    `firstname` VARCHAR(45) NOT NULL,
    `lastname` VARCHAR(45) NOT NULL,
    `role_id` INT NOT NULL,
    `apartment_id` INT NOT NULL,
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
    PRIMARY KEY (`id`),
    INDEX `fk_user_role_idx` (`role_id` ASC) VISIBLE,
    INDEX `fk_user_apartment1_idx` (`apartment_id` ASC) VISIBLE,
    UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
    CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_user_apartment1`
    FOREIGN KEY (`apartment_id`)
    REFERENCES `apartment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
