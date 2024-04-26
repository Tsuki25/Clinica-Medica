CREATE DATABASE clinica;

use clinica;

CREATE TABLE IF NOT EXISTS ENDERECO(
	codEnd bigint primary key auto_increment,
    cep varchar(9) not null,
    logradouro varchar(60) not null,
    bairro varchar(60) not null,
    cidade varchar(60) not null,
    estado varchar(2) not null,
    numero int not null,
    complemento varchar(50)
);

CREATE TABLE IF NOT EXISTS PACIENTE(
	codPaciente bigint primary key auto_increment,
    cpf varchar(11) unique not null,
    nome varchar(20) not null,
    sobrenome varchar(150) not null,
    sexo varchar(15) not null,
    dataNascimento date not null,
    telefone varchar(15),
    celular varchar(20) not null,
    email varchar(80) not null,
    historico text not null,
    alergias text not null,
    medicamentosUtilizados text not null,
    anotacoes text not null,
    codEnd bigint not null,
    FOREIGN KEY (codEnd) REFERENCES ENDERECO(codEnd)
);

INSERT INTO ENDERECO VALUES (default,'12345678', 'Rua Exemplo', 'Bairro Exemplo', 'Cidade Exemplo', 'UF', 123, 'Complemento Exemplo');
INSERT INTO PACIENTE VALUES (default,'12345678901', 'João', 'Silva', 'Masculino', '1990-01-01', null,'999999999', 'joao@example.com', 'Histórico médico...', 'Alergias...', 'Medicamentos utilizados...', 'Anotações...', 1);

SELECT * FROM ENDERECO;
SELECT * FROM PACIENTE;