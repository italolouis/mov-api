CREATE TABLE pessoa(
	codusu BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    dtnascimento DATE,
    genero CHAR(1),
    altura DECIMAL(10,2),
    telefone VARCHAR(16),
    email VARCHAR(50),
    senha VARCHAR(10),
    cep VARCHAR(30),
    logradouro VARCHAR(30),
    complemento VARCHAR(30),
    bairro VARCHAR(30),
    numero VARCHAR(30),
    localidade VARCHAR(30),
	uf VARCHAR(30),
    bloqueio CHAR(1),
    foto BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
