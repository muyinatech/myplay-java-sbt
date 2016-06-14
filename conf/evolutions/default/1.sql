# Tasks schema

# --- !Ups

create table task (
  id                            bigint not null,
  name                          varchar(255),
  done                          boolean,
  due_date                      timestamp,
  constraint pk_task primary key (id)
);
create sequence task_seq;


# --- !Downs

drop table if exists task;
drop sequence if exists task_seq;

