create table quadras(

    id bigint not null auto_increment,

    nome varchar(100) not null,

--   endereco
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero  varchar(20),
    uf char(2) not null,
    cidade varchar(10) not null,
--
    esporte varchar(30) not null,
    quantidade_quadras int not null,
    inicio_funcionamento time not null,
    termino_funcionamento time not null,
    data_inicio date not null,
    data_termino date not null,
    quantidade_churraqueiras int not null,
    valor_locacao float,
    email varchar(100) not null unique,
    telefone varchar(100) not null,
    ativo TINYINT(1) NOT NULL DEFAULT 1,



    primary key(id)
);