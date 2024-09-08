create table reservas(
    id bigint auto_increment primary key,
	usuario_id bigint not null,
    quadra_id bigint not null,
    horario_inicio time not null,
    horario_termino time not null,
    dia date not null,

    foreign key (usuario_id) references usuarios(id) on delete cascade,
    foreign key (quadra_id) references quadras(id) on delete cascade
    );
