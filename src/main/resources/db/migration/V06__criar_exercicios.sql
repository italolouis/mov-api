CREATE TABLE exercicio(
	cod BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	exerciciocod BIGINT(20),
	descanso BIGINT(5),
	foreign key (exerciciocod) references tipoexercicio(cod)
);
