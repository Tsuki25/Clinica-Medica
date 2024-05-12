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
    dataReservada DATE NOT NULL,
    horarioInicio TIME NOT NULL,
    horarioFim TIME NOT NULL,
    codMedico BIGINT,
    codEnfermeiro BIGINT ,
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario),
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario)
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
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente)
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
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente)
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
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente)
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
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente)
);

CREATE TABLE IF NOT EXISTS ENTREGA(
    codEntrega BIGINT PRIMARY KEY AUTO_INCREMENT,
    dataRetirada DATE NOT NULL,
    horarioRetirada TIME NOT NULL,
    retiradoPor VARCHAR(150) NOT NULL,
    codRecepcionista BIGINT NOT NULL,
    codExame BIGINT NOT NULL, #REPRESENTARA O EXAME, NÃO É APRESENTADO COMO CHAVE ESTRANGEIRA POIS SERIAM NECESSARIAS 4 CHAVES
    FOREIGN KEY (codRecepcionista) REFERENCES RECEPCIONISTA(codFuncionario)
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
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario),
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario),
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente)
);


# INSERT DE DADOS PARA TESTE
-- Inserts para a tabela ENDERECO
INSERT INTO ENDERECO (cep, logradouro, bairro, cidade, estado, numero, complemento) VALUES
('12345-678', 'Rua Teste', 'Centro', 'Cidade Teste', 'TS', 123, 'Complemento Teste'),
('54321-876', 'Avenida Principal', 'Bairro Novo', 'Cidade Nova', 'NV', 456, 'Complemento Novo');

-- Inserts para a tabela PACIENTE
INSERT INTO PACIENTE (cpf, nome, sobrenome, sexo, dataNascimento, celular, email, codEnd) VALUES
('12345678901', 'João', 'Silva', 'Masculino', '1990-05-10', '(99) 99999-9999', 'joao@email.com', 1),
('98765432109', 'Maria', 'Santos', 'Feminino', '1985-08-15', '(88) 88888-8888', 'maria@email.com', 2);

-- Inserts para a tabela RECEPCIONISTA
INSERT INTO RECEPCIONISTA (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, celular, email, senha, codEnd) VALUES
(1, '11122233344', 'Ana', 'Souza', 'Feminino', '1980-01-20', '(77) 77777-7777', 'ana@email.com', 'senha123', 1),
(2, '22233344455', 'Pedro', 'Oliveira', 'Masculino', '1975-11-05', '(66) 66666-6666', 'pedro@email.com', 'senha456', 2);

-- Inserts para a tabela ENFERMEIRO
INSERT INTO ENFERMEIRO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, celular, email, senha, cip, codEnd) VALUES
(3, '33344455566', 'Mariana', 'Costa', 'Feminino', '1983-04-15', '(55) 55555-5555', 'mariana@email.com', 'senha789', 'CIP123', 1),
(4, '44455566677', 'Lucas', 'Ferreira', 'Masculino', '1978-07-25', '(44) 44444-4444', 'lucas@email.com', 'senha012', 'CIP456', 2);

-- Inserts para a tabela MEDICO
INSERT INTO MEDICO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, celular, email, senha, crm, codEnd) VALUES
(5, '55566677788', 'Juliana', 'Martins', 'Feminino', '1970-03-30', '(33) 33333-3333', 'juliana@email.com', 'senha345', 'CRM123', 1),
(6, '66677788899', 'Carlos', 'Lima', 'Masculino', '1965-09-10', '(22) 22222-2222', 'carlos@email.com', 'senha678', 'CRM456', 2);

-- Inserts para a tabela AGENDA
INSERT INTO AGENDA (codAgenda, dataReservada, horarioInicio, horarioFim, codMedico, codEnfermeiro) VALUES #MUDAR O NOME SE PA
(default, '2024-05-10', '08:00:00', '09:00:00', 5, null),
(default, '2024-05-11', '09:00:00', '10:00:00', 6, null);

-- Inserts para a tabela ELETROCARDIOGRAMA
INSERT INTO ELETROCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, ritmo, fc, conclusoes, codPaciente) VALUES
(1, 'Normal', 70.5, 1.75, 'Unimed', 'Sinusal', 70, 'Conclusões do eletrocardiograma', 1),
(2, 'Arritmia', 65.2, 1.68, 'Bradesco Saúde', 'Fibrilação Atrial', 85, 'Conclusões do eletrocardiograma', 2);

-- Inserts para a tabela ECOCARDIOGRAMA
INSERT INTO ECOCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, raizAorta, atrioEsquerdo, ventriculoDir, ventriculoEsqSis, ventriculoEsqDias, ventriculoEsqParede, septoIntra, fraccaoEncurtamento, fraccaoEjecao, codPaciente) VALUES
(3, 'Normal', 70.5, 1.75, 'Unimed', 30, 25, 30, 55, 25, 10, 12, 0.35, 0.60, 1),
(4, 'Cardiomiopatia', 65.2, 1.68, 'Bradesco Saúde', 35, 28, 35, 60, 28, 15, 14, 0.30, 0.55, 2);

-- Inserts para a tabela ERGONOMETRICO
INSERT INTO ERGONOMETRICO (codExame, diagClinico, peso, altura, convenio, marcaPasso, fumante, observacoes, codPaciente) VALUES
(5, 'Normal', 70.5, 1.75, 'Unimed', 0, 1, 'Observações sobre o teste ergométrico', 1),
(6, 'Descondicionado', 65.2, 1.68, 'Bradesco Saúde', 1, 0, 'Observações sobre o teste ergométrico', 2);

-- Inserts para a tabela HOLTER
INSERT INTO HOLTER (codExame, diagClinico, peso, altura, convenio, ritmoCardiaco, variabilidadeCardiaca, intervaloQT, intervaloPR, condIntraventricular, segmentoST, extrassistotoles, arritmias, observacoes, codPaciente) VALUES
(7, 'Normal', 70.5, 1.75, 'Unimed', 70, 15, 0.42, 0.18, 'Normal', 'Normal', 'Ausentes', 'Nenhuma', 'Observações sobre o Holter', 1),
(8, 'Taquicardia', 65.2, 1.68, 'Bradesco Saúde', 90, 20, 0.40, 0.20, 'Normal', 'Infradesnivelamento', 'Frequentemente presentes', 'Taquicardia sinusal', 'Observações sobre o Holter', 2);

INSERT INTO ENTREGA (dataRetirada, horarioRetirada, retiradoPor, codRecepcionista, codExame) VALUES
('2024-05-10', '10:00:00', 'Fulano', 1, 5),
('2024-05-11', '11:00:00', 'Ciclano', 2, 2);

-- Inserts para a tabela AGENDAMENTO
INSERT INTO AGENDAMENTO (dataAgendamento, horarioAgendamento, statusAgendamento, codMedico, codEnfermeiro, codPaciente) VALUES
('2024-05-12', '08:00:00', 'Agendado', 5, null, 1),
('2024-05-13', '10:00:00', 'Agendado', null, 4, 2);

select * from paciente;
select * from recepcionista;
SELECT * FROM agendamento;

SELECT MAX(codFuncionario) AS codigo_maximo FROM (
             SELECT codFuncionario FROM RECEPCIONISTA
             UNION ALL 
             SELECT codFuncionario FROM ENFERMEIRO
             UNION ALL
             SELECT codFuncionario FROM MEDICO
             ) AS todas_tabelas;

select count(codFuncionario) from enfermeiro where codFuncionario = 4;