ALTER TABLE `student_hostel`.`apartment`
    ADD COLUMN `head_id` INT NULL AFTER `type_id`,
    ADD UNIQUE INDEX `head_id_UNIQUE` (`head_id` ASC) VISIBLE;
;
ALTER TABLE `student_hostel`.`apartment`
    ADD CONSTRAINT `fk_apartment_head`
        FOREIGN KEY (`head_id`)
            REFERENCES `student_hostel`.`user` (`id`)
            ON DELETE SET NULL
            ON UPDATE CASCADE;
