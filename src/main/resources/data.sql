insert into course(id, name, last_update_date, created_date, is_deleted) values(10001, 'JPA in 50 steps', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), false);
insert into course(id, name, last_update_date, created_date, is_deleted) values(10002, 'Teste 2', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), false);
insert into course(id, name, last_update_date, created_date, is_deleted) values(10003, 'Teste 3', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), false);

insert into passport(id, number)
    values(40001, 'E12346487');
insert into passport(id, number)
    values(40002, 'N12346487');
insert into passport(id, number)
    values(40003, 'T12346487');

insert into student(id, name,passport_id)
    values(20001, 'Paulo', 40001);
insert into student(id, name,passport_id)
    values(20002, 'Joana', 40002);
insert into student(id, name,passport_id)
    values(20003, 'Maria', 40003);


insert into review(id,rating,description, course_id)
    values(50001, '5', 'Great Course', 10001);
insert into review(id,rating,description, course_id)
    values(50002, '4', 'Great Course', 10001);

insert into student_course( student_id, course_id)
values(20001, 10001);
insert into student_course( student_id, course_id)
values(20002, 10001);
insert into student_course( student_id, course_id)
values(20003, 10001);
insert into student_course( student_id, course_id)
values(20001, 10003);