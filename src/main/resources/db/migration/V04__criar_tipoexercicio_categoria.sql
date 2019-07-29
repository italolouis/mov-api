CREATE TABLE tipoexercicio_categoria (
    tipexercicio BIGINT(20),
    categoriacod BIGINT(20),
    primary key (tipexercicio, categoriacod),
    foreign key (tipexercicio) references tipoexercicio(cod),
    foreign key (categoriacod) references categoria(cod)
);

