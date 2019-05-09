CREATE TABLE equipamento(
	codequip BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO equipamento(descricao) VALUES ('Livre');
INSERT INTO equipamento(descricao) VALUES ('Halters');
INSERT INTO equipamento(descricao) VALUES ('Barras');
INSERT INTO equipamento(descricao) VALUES ('Ketbell');
INSERT INTO equipamento(descricao) VALUES ('Faixa de resistência');

