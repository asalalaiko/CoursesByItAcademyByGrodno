create sequence hibernate_sequence start 1 increment 1;
create table user_table (id int4 not null, activation_code varchar(255), active boolean, email varchar(255), password varchar(255) not null, user_role varchar(255), user_picture varchar(255), username varchar(255), primary key (id));
alter table user_table add constraint UK_eamk4l51hm6yqb8xw37i23kb5 unique (email)
