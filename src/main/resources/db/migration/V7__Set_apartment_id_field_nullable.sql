ALTER TABLE `student_hostel`.`user`
    DROP FOREIGN KEY `fk_user_apartment1`;
ALTER TABLE `student_hostel`.`user`
    CHANGE COLUMN `apartment_id` `apartment_id` INT NULL ;
ALTER TABLE `student_hostel`.`user`
    ADD CONSTRAINT `fk_user_apartment1`
        FOREIGN KEY (`apartment_id`)
            REFERENCES `student_hostel`.`apartment` (`id`);