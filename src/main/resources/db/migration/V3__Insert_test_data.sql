# floor data
INSERT INTO floor (number, apartments_count, head_student)
VALUES (1, NULL, NULL);

INSERT INTO floor (number, apartments_count, head_student)
VALUES (2, NULL, NULL);

INSERT INTO floor (number, apartments_count, head_student)
VALUES (3, NULL, NULL);


# apartment data
INSERT INTO apartment (number, floor_id, type_id)
VALUES (1, 1, 2);

INSERT INTO apartment (number, floor_id, type_id)
VALUES (2, 1, 3);

INSERT INTO apartment (number, floor_id, type_id)
VALUES (3, 2, 1);


# user data
INSERT INTO user
(phone, username, email, password, firstname, lastname, role_id, apartment_id)
VALUES ('38078954371', 'Andrey', 'andrey@gmail.com', 'qwerty54321',
        'Andrey', 'Ivanov', 2, 3);

INSERT INTO user
(phone, username, email, password, firstname, lastname, role_id, apartment_id)
VALUES ('38068750353', 'Nat123', 'natalia@gmail.com', 'qwerty54321',
        'Natalia', 'Vasilenko', 1, 2);