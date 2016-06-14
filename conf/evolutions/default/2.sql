# --- Sample dataset

# --- !Ups

insert into task (id, name, done, dueDate) values (10, 'Pay bill', true, '2016-05-14');
insert into task (id, name, done, dueDate) values (11, 'Start project', true, '2016-05-21');
insert into task (id, name, done, dueDate) values (12, 'Close account', true, '2016-05-27');

# --- !Downs

delete from task;

