create table categoria (
    cod BIGINT(20) PRIMARY KEY,
    nome varchar(100),
    parentid BIGINT(20),
    foreign key (parentid) references categoria(cod)
);

--Categorias
INSERT INTO categoria(cod,nome) VALUES (1,'Grupo Muscular');
INSERT INTO categoria(cod,nome) VALUES (2,'Equipamento');

-- Subcategorias for 'Grupo Muscular'
INSERT INTO categoria(cod,nome,parentid) VALUES (3,'Abdômen',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (4,'Costas',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (5,'Bíceps',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (6,'Tríceps',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (7,'Antebraços',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (8,'Peito',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (9,'Ombros',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (10,'Pernas',1);
INSERT INTO categoria(cod,nome,parentid) VALUES (11,'Cardio',1);

--Subcategoria para equipamento
INSERT INTO categoria(cod,nome,parentid) VALUES (12,'Livre',2);
INSERT INTO categoria(cod,nome,parentid) VALUES (13,'Halters',2);
INSERT INTO categoria(cod,nome,parentid) VALUES (14,'Barras',2);
INSERT INTO categoria(cod,nome,parentid) VALUES (15,'Ketbell',2);
INSERT INTO categoria(cod,nome,parentid) VALUES (16,'Faixa de resistência',2);



