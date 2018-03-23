create database aula04;
use aula04;

create table if not exists pais
(
	id int auto_increment not null,
    nome varchar(100),
    populacao bigint,
    area decimal(15,2),
    primary key(id)
);

select * from pais;
