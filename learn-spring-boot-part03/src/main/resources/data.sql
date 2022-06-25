insert into course(id, name,created_date, last_updated_date) values(10001, '인기강좌1', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name,created_date, last_updated_date) values(10002, '인기강좌2', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into course(id, name,created_date, last_updated_date) values(10003, '인기강좌3', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

insert into passport(id, number) values(20001, '여권번호1');
insert into passport(id, number) values(20002, '여권번호2');
insert into passport(id, number) values(20003, '여권번호3');

insert into student(id, name, passport_id) values(30001, '김씨', 20001);
insert into student(id, name, passport_id) values(30002, '감씨', 20002);
insert into student(id, name, passport_id) values(30003, '깜씨', 20003);


insert into review(id, rating, description) values(40001, '5', 'great course1');
insert into review(id, rating, description) values(40002, '5', 'great course2');
insert into review(id, rating, description) values(40003, '5', 'great course3');

