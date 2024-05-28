CREATE DATABASE clinica;

USE clinica;

CREATE TABLE IF NOT EXISTS ENDERECO(
    codEnd BIGINT PRIMARY KEY AUTO_INCREMENT,
    cep int NOT NULL,
    logradouro VARCHAR(60) NOT NULL,
    bairro VARCHAR(60) NOT NULL,
    cidade VARCHAR(60) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS PACIENTE(
    codPaciente BIGINT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(150) NOT NULL,
    sexo VARCHAR(15) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(15),
    celular VARCHAR(20) NOT NULL,
    email VARCHAR(80) NOT NULL,
    historico TEXT,
    alergias TEXT,
    medicamentosUtilizados TEXT,
    anotacoes TEXT,
    codEnd BIGINT NOT NULL,
    FOREIGN KEY (codEnd) REFERENCES ENDERECO(codEnd)
);

CREATE TABLE IF NOT EXISTS RECEPCIONISTA( #NECESSARIO TRATIVA INTERNA DO SISTEMA PARA UMA CONTAGEM UNICA DE IDS PARA TODO O SISTEMA
    codFuncionario BIGINT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(150) NOT NULL,
    sexo VARCHAR(15) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(15),
    celular VARCHAR(20) NOT NULL,
    email VARCHAR(80) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    codEnd BIGINT NOT NULL,
    FOREIGN KEY (codEnd) REFERENCES ENDERECO(codEnd)
);

CREATE TABLE IF NOT EXISTS ENFERMEIRO( #NECESSARIO TRATIVA INTERNA DO SISTEMA PARA UMA CONTAGEM UNICA DE IDS PARA TODO O SISTEMA
    codFuncionario BIGINT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(150) NOT NULL,
    sexo VARCHAR(15) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(15),
    celular VARCHAR(20) NOT NULL,
    email VARCHAR(80) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    cip VARCHAR(10) NOT NULL UNIQUE,
    codEnd BIGINT NOT NULL,
    FOREIGN KEY (codEnd) REFERENCES ENDERECO(codEnd) 
);

CREATE TABLE IF NOT EXISTS MEDICO( #NECESSARIO TRATIVA INTERNA DO SISTEMA PARA UMA CONTAGEM UNICA DE IDS PARA TODO O SISTEMA
    codFuncionario BIGINT PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(20) NOT NULL,
    sobrenome VARCHAR(150) NOT NULL,
    sexo VARCHAR(15) NOT NULL,
    dataNascimento DATE NOT NULL,
    telefone VARCHAR(15),
    celular VARCHAR(20) NOT NULL,
    email VARCHAR(80) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    crm VARCHAR(10) NOT NULL UNIQUE,
    codEnd BIGINT NOT NULL,
    FOREIGN KEY (codEnd) REFERENCES ENDERECO(codEnd)
);

CREATE TABLE IF NOT EXISTS AGENDA(
    codAgenda BIGINT PRIMARY KEY AUTO_INCREMENT,
    dataReserva DATE NOT NULL,
    horarioInicio TIME NOT NULL,
    horarioFim TIME NOT NULL,
    motivo VARCHAR(200) NOT NULL,
    codMedico BIGINT,
    codEnfermeiro BIGINT ,
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ELETROCARDIOGRAMA( #NECESSARIO TRATIVA INTERNA DO SISTEMA PARA UMA CONTAGEM UNICA DE IDS PARA TODO O SISTEMA
    codExame BIGINT PRIMARY KEY,
    diagClinico VARCHAR(360),
    peso DOUBLE NOT NULL,
    altura DOUBLE NOT NULL,
    convenio VARCHAR(20) NOT NULL,
    ritmo VARCHAR(20) NOT NULL,
    fc INT NOT NULL,
    conclusoes VARCHAR(360) NOT NULL,
    codPaciente BIGINT NOT NULL,
	codMedico BIGINT,
    codEnfermeiro BIGINT,
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ECOCARDIOGRAMA( #NECESSARIO TRATIVA INTERNA DO SISTEMA PARA UMA CONTAGEM UNICA DE IDS PARA TODO O SISTEMA
    codExame BIGINT PRIMARY KEY,
    diagClinico VARCHAR(360),
    peso DOUBLE NOT NULL,
    altura DOUBLE NOT NULL,
    convenio VARCHAR(20) NOT NULL,
    raizAorta INT NOT NULL,
    atrioEsquerdo INT NOT NULL,
    ventriculoDir INT NOT NULL,
    ventriculoEsqSis INT NOT NULL,
    ventriculoEsqDias INT NOT NULL,
    ventriculoEsqParede INT NOT NULL,
    septoIntra INT NOT NULL,
    fraccaoEncurtamento DOUBLE NOT NULL,
    fraccaoEjecao DOUBLE NOT NULL,
    codPaciente BIGINT NOT NULL,
	codMedico BIGINT,
    codEnfermeiro BIGINT,
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ERGONOMETRICO( #NECESSARIO TRATIVA INTERNA DO SISTEMA PARA UMA CONTAGEM UNICA DE IDS PARA TODO O SISTEMA
    codExame BIGINT PRIMARY KEY,
    diagClinico VARCHAR(360),
    peso DOUBLE NOT NULL,
    altura DOUBLE NOT NULL,
    convenio VARCHAR(20) NOT NULL,
    marcaPasso BOOLEAN NOT NULL,
    fumante BOOLEAN NOT NULL,
    observacoes VARCHAR(360) NOT NULL,
    codPaciente BIGINT NOT NULL,
	codMedico BIGINT,
    codEnfermeiro BIGINT,
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS HOLTER( #NECESSARIO TRATIVA INTERNA DO SISTEMA PARA UMA CONTAGEM UNICA DE IDS PARA TODO O SISTEMA
    codExame BIGINT PRIMARY KEY,
    diagClinico VARCHAR(360),
    peso DOUBLE NOT NULL,
    altura DOUBLE NOT NULL,
    convenio VARCHAR(20) NOT NULL,
    ritmoCardiaco INT NOT NULL,
    variabilidadeCardiaca DOUBLE NOT NULL,
    intervaloQT DOUBLE NOT NULL,
    intervaloPR DOUBLE NOT NULL,
    condIntraventricular VARCHAR(240) NOT NULL,
    segmentoST VARCHAR(240) NOT NULL,
    extrassistotoles VARCHAR(240) NOT NULL,
    arritmias VARCHAR(240) NOT NULL,
    observacoes VARCHAR(360) NOT NULL,
    codPaciente BIGINT NOT NULL,
    codMedico BIGINT,
    codEnfermeiro BIGINT,
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS ENTREGA(
    codEntrega BIGINT PRIMARY KEY AUTO_INCREMENT,
    dataRetirada DATE NOT NULL,
    horarioRetirada TIME NOT NULL,
    retiradoPor VARCHAR(150) NOT NULL,
    codRecepcionista BIGINT NOT NULL,
    codExame BIGINT NOT NULL, #REPRESENTARA O EXAME, NÃO É APRESENTADO COMO CHAVE ESTRANGEIRA POIS SERIAM NECESSARIAS 4 CHAVES
    FOREIGN KEY (codRecepcionista) REFERENCES RECEPCIONISTA(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS AGENDAMENTO(
    codAgendamento BIGINT PRIMARY KEY AUTO_INCREMENT,
    dataAgendamento DATE NOT NULL,
    horarioAgendamento TIME NOT NULL,
    statusAgendamento VARCHAR(10) NOT NULL,
    exame varchar(25) NOT NULL,
    codMedico BIGINT,
    codEnfermeiro BIGINT,
    codPaciente BIGINT NOT NULL,
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserções para ENDERECO
INSERT INTO ENDERECO (cep, logradouro, bairro, cidade, estado, numero, complemento) VALUES
(12345678, 'Rua A', 'Bairro A', 'Cidade A', 'AA', 1, 'Apto 101'),
(23456789, 'Rua B', 'Bairro B', 'Cidade B', 'BB', 2, 'Apto 202'),
(34567890, 'Rua C', 'Bairro C', 'Cidade C', 'CC', 3, 'Apto 303'),
(45678901, 'Rua D', 'Bairro D', 'Cidade D', 'DD', 4, 'Apto 404'),
(55555555, 'Rua E', 'Bairro E', 'Cidade E', 'EE', 5, 'Apto 555');

-- Inserções para PACIENTE
INSERT INTO PACIENTE (cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, historico, alergias, medicamentosUtilizados, anotacoes, codEnd) VALUES
('111.111.111-11', 'João', 'Silva', 'Masculino', '1980-01-01', '1111-1111', '91111-1111', 'joao.silva@example.com', 'Histórico A', 'Alergias A', 'Medicamentos A', 'Anotações A', 1),
('222.222.222-22', 'Maria', 'Oliveira', 'Feminino', '1990-02-02', '2222-2222', '92222-2222', 'maria.oliveira@example.com', 'Histórico B', 'Alergias B', 'Medicamentos B', 'Anotações B', 2);

-- Inserções para RECEPCIONISTA
INSERT INTO RECEPCIONISTA (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, codEnd) VALUES
(1, '555.555.555-55', 'Paula', 'Costa', 'Feminino', '1995-05-05', '5555-5555', '95555-5555', 'paula.costa@example.com', 'senha789', 3);

-- Inserções para ENFERMEIRO
INSERT INTO ENFERMEIRO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, cip, codEnd) VALUES
(2, '444.444.444-44', 'Ana', 'Pereira', 'Feminino', '1985-04-04', '4444-4444', '94444-4444', 'ana.pereira@example.com', 'senha456', 'CIP456', 4);

-- Inserções para MEDICO
INSERT INTO MEDICO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, crm, codEnd) VALUES
(3, '333.333.333-33', 'Carlos', 'Santos', 'Masculino', '1975-03-03', '3333-3333', '93333-3333', 'carlos.santos@example.com', 'senha123', 'CRM123', 5);

-- Inserções para AGENDA
INSERT INTO AGENDA (dataReserva, horarioInicio, horarioFim, motivo, codMedico, codEnfermeiro) VALUES
('2024-06-01', '09:00:00', '10:00:00', 'Consulta de rotina', null, 2),
('2024-06-02', '11:00:00', '12:00:00', 'Exame cardiológico', 3, null);

-- Inserções para ELETROCARDIOGRAMA
INSERT INTO ELETROCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, ritmo, fc, conclusoes, codPaciente, codMedico, codEnfermeiro) VALUES
(1, 'NORMAL_ADULTO', 70.5, 1.75, 'Convenio A', 'Normal', 75, 'Conclusão A', 1, 3, null),
(2, 'NORMAL_ADULTO', 68.0, 1.65, 'Convenio B', 'Arritmia', 80, 'Conclusão B', 2, null, 2);

-- Inserções para ECOCARDIOGRAMA
INSERT INTO ECOCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, raizAorta, atrioEsquerdo, ventriculoDir, ventriculoEsqSis, ventriculoEsqDias, ventriculoEsqParede, septoIntra, fraccaoEncurtamento, fraccaoEjecao, codPaciente, codMedico, codEnfermeiro) VALUES
(3, 'Diagnóstico C', 70.5, 1.75, 'Convenio A', 34, 45, 23, 34, 56, 34, 23, 50.5, 65.3, 1, 3, null),
(4, 'Diagnóstico D', 68.0, 1.65, 'Convenio B', 35, 46, 24, 35, 57, 35, 24, 51.5, 66.3, 2, 3, null);

-- Inserções para ERGONOMETRICO
INSERT INTO ERGONOMETRICO (codExame, diagClinico, peso, altura, convenio, marcaPasso, fumante, observacoes, codPaciente, codMedico, codEnfermeiro) VALUES
(5, 'Diagnóstico E', 70.5, 1.75, 'Convenio A', FALSE, TRUE, 'Observação A', 1, null, 2),
(6, 'Diagnóstico F', 68.0, 1.65, 'Convenio B', TRUE, FALSE, 'Observação B', 2, null, 2);

-- Inserções para HOLTER
INSERT INTO HOLTER (codExame, diagClinico, peso, altura, convenio, ritmoCardiaco, variabilidadeCardiaca, intervaloQT, intervaloPR, condIntraventricular, segmentoST, extrassistotoles, arritmias, observacoes, codPaciente, codMedico, codEnfermeiro) VALUES
(7, 'Diagnóstico G', 70.5, 1.75, 'Convenio A', 70, 5.2, 0.4, 0.2, 'Normal', 'Normal', 'Nenhuma', 'Nenhuma', 'Observação G', 1, 3, null),
(8, 'Diagnóstico H', 68.0, 1.65, 'Convenio B', 75, 5.5, 0.5, 0.3, 'Anormal', 'Anormal', 'Poucas', 'Leve', 'Observação H', 2, 3, null);

-- Inserções para ENTREGA
INSERT INTO ENTREGA (dataRetirada, horarioRetirada, retiradoPor, codRecepcionista, codExame) VALUES
('2024-06-01', '14:00:00', 'João Silva', 1, 1),
('2024-06-02', '15:00:00', 'Maria Oliveira', 1, 2);

-- Inserções para AGENDAMENTO
INSERT INTO AGENDAMENTO (dataAgendamento, horarioAgendamento, statusAgendamento, exame, codMedico, codEnfermeiro, codPaciente) VALUES
('2024-06-01', '10:00:00', 'AGENDADO', 'Eletrocardiograma', 3, null, 1),
('2024-06-02', '11:00:00', 'AGENDADO', 'Ecocardiograma', null, 2, 2);

# drop database clinica;

use clinica;
select * from paciente;
select * from recepcionista;
SELECT * FROM agendamento;
SELECT * FROM agenda;
SELECT * FROM eletrocardiograma;

SELECT MAX(codFuncionario) AS codigo_maximo FROM (
             SELECT codFuncionario FROM RECEPCIONISTA
             UNION ALL 
             SELECT codFuncionario FROM ENFERMEIRO
             UNION ALL
             SELECT codFuncionario FROM MEDICO
             ) AS todas_tabelas;
             
             SELECT nome, sobrenome FROM
                    ( 
                    SELECT codFuncionario, nome, sobrenome FROM RECEPCIONISTA
                    UNION ALL 
                    SELECT codFuncionario, nome, sobrenome FROM ENFERMEIRO
                    UNION ALL
                    SELECT codFuncionario, nome, sobrenome FROM MEDICO
                    ) AS todas_tabelas;

select count(codFuncionario) from enfermeiro where codFuncionario = 2;