CREATE TABLE exercicio_serie(
	exerciciocod BIGINT(20),
    seriecod BIGINT(20),
    primary key (exerciciocod, seriecod),
    foreign key (exerciciocod) references exercicio(cod),
    foreign key (seriecod) references serie(cod)
);