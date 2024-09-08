create table usuarios(

    id bigint not null auto_increment,

    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    email varchar(100) not null unique,
    telefone varchar(100) not null,

--   endereco
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero  varchar(20),
    uf char(2) not null,
    cidade varchar(10) not null,
    ativo TINYINT(1) NOT NULL DEFAULT 1,
    admin tinyint not null

    primary key(id)
);