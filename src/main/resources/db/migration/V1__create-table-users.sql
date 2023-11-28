create table users(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(30) not null unique,
    senha varchar(100)not null,
    type varchar(50) not null,
    balance BigInt(20) not null,
    primary key(id)
);