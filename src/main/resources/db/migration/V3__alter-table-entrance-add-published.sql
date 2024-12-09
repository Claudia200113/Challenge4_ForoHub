alter table entrance add published tinyint;
update entrance set published = 1;