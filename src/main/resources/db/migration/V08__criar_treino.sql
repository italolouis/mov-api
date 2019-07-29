CREATE TABLE treino(
	cod BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	dia VARCHAR(20),
	usuariocod BIGINT(20),
	exercicioscod BIGINT(20),
	foreign key (usuariocod) references usuario(codusu),
	foreign key (exercicioscod) references exercicio(cod)
);