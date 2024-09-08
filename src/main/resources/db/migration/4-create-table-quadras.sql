create table quadras(
    id bigint auto_increment primary key,
	esporte varchar(30) not null,
    churrasqueira TINYINT(0) not null,
	aluguel float,
    empresa_id bigint not null,
    ativo TINYINT(1) not null,

	foreign key (empresa_id) references empresas(id) on delete cascade
    );