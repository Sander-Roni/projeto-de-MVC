CREATE DATABASE Campo;
USE Campo;
CREATE TABLE Cliente(
	id int primary key auto_increment not null,
    nome varchar(80) unique,
    email varchar(40) unique,
    telefone varchar(16),
    senha varchar(20) unique,
    idade varchar(3),
    cpf varchar(16) unique
);
CREATE TABLE Livros(
	id int primary key auto_increment not null,
    titulo varchar(20),
    autor varchar(20),
    genero varchar(10),
    isbn varchar(30) unique,
    ano_publicacao varchar(10),
    editora varchar(40),
    num_paginas varchar(100),
    idioma varchar(10),
    lido varchar(40),
    preco varchar(10),
    data_do_cadastro varchar(10),
    estoque_fisico varchar(30)
);

CREATE TABLE Compra(
	id int primary key auto_increment not null,
    titular varchar(40) unique,
    numero_cartao varchar(30) unique,
    validade varchar(20),
    cvv varchar(3) unique,
    endereco varchar(120)
);

CREATE TABLE Gerente(
	email varchar(40) unique,
    senha varchar(10) unique
); 

INSERT INTO Livros (
    titulo, autor, genero, isbn, ano_publicacao, 
    editora, num_paginas, idioma, lido, preco, 
    data_do_cadastro, estoque_fisico
) 
VALUES (
    'O Senhor dos Anéis', 'J.R.R. Tolkien', 'Fantasia', '9788546902680', '1954',
    'HarperCollins', '1216', 'Português', 'Não', '79.90',
    '2024-11-26', '50'
);
 
select * from Livros;


    

    