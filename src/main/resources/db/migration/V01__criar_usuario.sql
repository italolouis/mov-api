CREATE TABLE usuario(
	codusu BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    dt_nascimento DATETIME,
    genero CHAR(1),
    altura DECIMAL(3, 2),
    telefone VARCHAR(12),
    email VARCHAR(50),
    senha VARCHAR(10),
    bloqueio CHAR(1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario(nome,genero,altura,telefone,email,senha) VALUES ('Italo', 'M', 1.50, '933000863', 'italo.louis@hotmail.com', 'teste');
