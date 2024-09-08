create table empresas(

    id bigint not null auto_increment,
    nome varchar(100) not null,
--   endereco
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero  varchar(20),
    uf varchar(2) not null,
    cidade varchar(10) not null,
--
	email varchar(100) not null unique,
    telefone varchar(100) not null,
    horario_inicio time not null,
    horario_termino time not null,
    dia_inicio varchar(10) not null,
    dia_termino varchar(10) not null,
    ativo TINYINT(1) NOT NULL DEFAULT 1,

    primary key(id)
);