CREATE TABLE grupo_muscular(
	codgrupo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(45) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO grupo_muscular(descricao) VALUES ('Abdômen');
INSERT INTO grupo_muscular(descricao) VALUES ('Costas');
INSERT INTO grupo_muscular(descricao) VALUES ('Bíceps');
INSERT INTO grupo_muscular(descricao) VALUES ('Tríceps');
INSERT INTO grupo_muscular(descricao) VALUES ('Antebraços');
INSERT INTO grupo_muscular(descricao) VALUES ('Peito');
INSERT INTO grupo_muscular(descricao) VALUES ('Ombros');
INSERT INTO grupo_muscular(descricao) VALUES ('Pernas');
INSERT INTO grupo_muscular(descricao) VALUES ('Cardio');


