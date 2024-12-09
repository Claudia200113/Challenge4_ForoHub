create table entrance(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar (500) not null,
    creationDate varchar (100) not null,
    status varchar (100) not null,
    author varchar (100) not null,
    replies varchar (100) not null,

    primary key (id)
);
