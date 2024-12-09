create table user(
    id bigint not null auto_increment,
    mail varchar(100) not null unique,
    password varchar (100) not null,

    primary key (id)
);