create table login(
    id bigint auto_increment primary key,
	login varchar(30) unique not null,
    senha varchar(255) not null,
    userType ENUM('USUARIO', 'EMPRESA') NOT NULL,
    foreignId BIGINT,

    CONSTRAINT fk_usuario FOREIGN KEY (foreignId) REFERENCES usuarios(id) ON DELETE CASCADE,
    CONSTRAINT fk_empresa FOREIGN KEY (foreignId) REFERENCES empresas(id) ON DELETE CASCADE

    );


Admin
$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.