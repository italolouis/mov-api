CREATE TABLE treino_exercicios(
	treinocod BIGINT(20),
    exercicioscod BIGINT(20),
    primary key (treinocod, exercicioscod),
    foreign key (treinocod) references treino(cod),
    foreign key (exercicioscod) references exercicio(cod)
);