CREATE TABLE exercicio(
	cod BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(45),
    image longblob,
    grupo BIGINT(20),
    equipamento BIGINT(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE exercicio ADD CONSTRAINT fk_grupo FOREIGN KEY (grupo) REFERENCES grupo_muscular(codgrupo) ;
ALTER TABLE exercicio ADD CONSTRAINT fk_equipamento FOREIGN KEY (equipamento) REFERENCES equipamento(codequip) ;
 