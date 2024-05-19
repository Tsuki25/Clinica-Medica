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
	codMedico BIGINT,
    codEnfermeiro BIGINT,
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente),
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario),
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario)
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
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente),
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario),
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario)
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
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente),
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario),
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario)
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
    FOREIGN KEY (codPaciente) REFERENCES PACIENTE(codPaciente),
    FOREIGN KEY (codMedico) REFERENCES MEDICO(codFuncionario),
    FOREIGN KEY (codEnfermeiro) REFERENCES ENFERMEIRO(codFuncionario)
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


-- Inserts para a tabela ENDERECO
INSERT INTO ENDERECO (cep, logradouro, bairro, cidade, estado, numero, complemento) VALUES
(12345678, 'Rua das Flores', 'Jardim das Rosas', 'São Paulo', 'SP', 100, 'Apto 101'),
(87654321, 'Avenida Central', 'Centro', 'Rio de Janeiro', 'RJ', 200, 'Bloco B'),
(11223344, 'Travessa da Esperança', 'Alvorada', 'Curitiba', 'PR', 300, NULL);

-- Inserts para a tabela PACIENTE
INSERT INTO PACIENTE (cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, historico, alergias, medicamentosUtilizados, anotacoes, codEnd) VALUES
('123.456.789-00', 'João', 'Silva', 'Masculino', '1990-01-01', '1111-1111', '99999-9999', 'joao.silva@example.com', 'Histórico do paciente João', 'Nenhuma', 'Nenhum', 'Nenhuma', 1),
('987.654.321-00', 'Maria', 'Oliveira', 'Feminino', '1985-05-05', '2222-2222', '88888-8888', 'maria.oliveira@example.com', 'Histórico do paciente Maria', 'Poeira', 'Paracetamol', 'Nenhuma', 2),
('555.666.777-88', 'Carlos', 'Santos', 'Masculino', '1975-12-12', '3333-3333', '77777-7777', 'carlos.santos@example.com', 'Histórico do paciente Carlos', 'Lactose', 'Ibuprofeno', 'Nenhuma', 3);

-- Inserts para a tabela RECEPCIONISTA
INSERT INTO RECEPCIONISTA (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, codEnd) VALUES
(1, '111.222.333-44', 'Ana', 'Pereira', 'Feminino', '1992-03-10', '4444-4444', '66666-6666', 'ana.pereira@example.com', 'senha123', 1),
(2, '555.666.777-88', 'José', 'Fernandes', 'Masculino', '1988-07-25', '5555-5555', '55555-5555', 'jose.fernandes@example.com', 'senha456', 2),
(3, '999.888.777-66', 'Beatriz', 'Costa', 'Feminino', '1980-11-30', '6666-6666', '44444-4444', 'beatriz.costa@example.com', 'senha789', 3);

-- Inserts para a tabela ENFERMEIRO
INSERT INTO ENFERMEIRO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, cip, codEnd) VALUES
(4, '333.444.555-66', 'Lucas', 'Almeida', 'Masculino', '1995-02-20', '7777-7777', '33333-3333', 'lucas.almeida@example.com', 'senha321', 'CIP12345', 1),
(5, '222.333.444-55', 'Fernanda', 'Lima', 'Feminino', '1991-08-15', '8888-8888', '22222-2222', 'fernanda.lima@example.com', 'senha654', 'CIP54321', 2),
(6, '666.555.444-33', 'Paulo', 'Souza', 'Masculino', '1983-04-10', '9999-9999', '11111-1111', 'paulo.souza@example.com', 'senha987', 'CIP98765', 3);

-- Inserts para a tabela MEDICO
INSERT INTO MEDICO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, crm, codEnd) VALUES
(7, '777.888.999-00', 'Roberta', 'Mendes', 'Feminino', '1970-10-05', '1111-1112', '99999-9991', 'roberta.mendes@example.com', 'senhaabc', 'CRM11111', 1),
(8, '888.999.000-11', 'Marcos', 'Ribeiro', 'Masculino', '1965-09-22', '1111-1113', '99999-9992', 'marcos.ribeiro@example.com', 'senhadef', 'CRM22222', 2),
(9, '999.000.111-22', 'Aline', 'Barbosa', 'Feminino', '1980-06-12', '1111-1114', '99999-9993', 'aline.barbosa@example.com', 'senhaghi', 'CRM33333', 3);

-- Inserts para a tabela AGENDA
INSERT INTO AGENDA (dataReserva, horarioInicio, horarioFim, motivo, codMedico, codEnfermeiro) VALUES
('2024-06-01', '08:00:00', '09:00:00', 'Consulta de rotina', 7, 4),
('2024-06-02', '09:00:00', '10:00:00', 'Consulta de retorno', 8, 5),
('2024-06-03', '10:00:00', '11:00:00', 'Exame preventivo', 9, 6);

-- Inserts para a tabela ELETROCARDIOGRAMA
INSERT INTO ELETROCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, ritmo, fc, conclusoes, codPaciente, codMedico, codEnfermeiro) VALUES
(1, 'Diagnóstico 1', 70.5, 1.75, 'Convenio A', 'Sinusal', 75, 'Conclusão 1', 1, 7, 4),
(2, 'Diagnóstico 2', 60.0, 1.65, 'Convenio B', 'Arritmia', 85, 'Conclusão 2', 2, 8, 5),
(3, 'Diagnóstico 3', 80.0, 1.80, 'Convenio C', 'Bradicardia', 65, 'Conclusão 3', 3, 9, 6);

-- Inserts para a tabela ECOCARDIOGRAMA
INSERT INTO ECOCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, raizAorta, atrioEsquerdo, ventriculoDir, ventriculoEsqSis, ventriculoEsqDias, ventriculoEsqParede, septoIntra, fraccaoEncurtamento, fraccaoEjecao, codPaciente, codMedico, codEnfermeiro) VALUES
(4, 'Diagnóstico 4', 75.0, 1.70, 'Convenio D', 35, 40, 30, 50, 55, 10, 9, 0.40, 0.60, 1, 7, 4),
(5, 'Diagnóstico 5', 65.0, 1.60, 'Convenio E', 36, 41, 31, 51, 56, 11, 10, 0.42, 0.62, 2, 8, 5),
(6, 'Diagnóstico 6', 85.0, 1.85, 'Convenio F', 37, 42, 32, 52, 57, 12, 11, 0.44, 0.64, 3, 9, 6);

-- Inserts para a tabela ERGONOMETRICO
INSERT INTO ERGONOMETRICO (codExame, diagClinico, peso, altura, convenio, marcaPasso, fumante, observacoes, codPaciente, codMedico, codEnfermeiro) VALUES
(7, 'Diagnóstico 7', 78.0, 1.78, 'Convenio G', 0, 1, 'Observação 1', 1, 7, 4),
(8, 'Diagnóstico 8', 68.0, 1.68, 'Convenio H', 1, 0, 'Observação 2', 2, 8, 5),
(9, 'Diagnóstico 9', 88.0, 1.88, 'Convenio I', 0, 0, 'Observação 3', 3, 9, 6);

-- Inserts para a tabela HOLTER
INSERT INTO HOLTER (codExame, diagClinico, peso, altura, convenio, ritmoCardiaco, variabilidadeCardiaca, intervaloQT, intervaloPR, condIntraventricular, segmentoST, extrassistotoles, arritmias, observacoes, codPaciente, codMedico, codEnfermeiro) VALUES
(10, 'Diagnóstico 10', 70.5, 1.75, 'Convenio J', 75, 0.80, 0.40, 0.20, 'Cond. normal', 'ST normal', 'Sem extrassístoles', 'Sem arritmias', 'Observação 4', 1, 7, 4),
(11, 'Diagnóstico 11', 60.0, 1.65, 'Convenio K', 85, 0.82, 0.42, 0.22, 'Cond. alterada', 'ST alterado', 'Com extrassístoles', 'Com arritmias', 'Observação 5', 2, 8, 5),
(12, 'Diagnóstico 12', 80.0, 1.80, 'Convenio L', 65, 0.84, 0.44, 0.24, 'Cond. levemente alterada', 'ST levemente alterado', 'Poucas extrassístoles', 'Poucas arritmias', 'Observação 6', 3, 9, 6);

-- Inserts para a tabela ENTREGA
INSERT INTO ENTREGA (dataRetirada, horarioRetirada, retiradoPor, codRecepcionista, codExame) VALUES
('2024-06-04', '08:00:00', 'Fulano de Tal', 1, 1),
('2024-06-05', '09:00:00', 'Beltrano de Souza', 2, 2),
('2024-06-06', '10:00:00', 'Ciclano da Silva', 3, 3);

-- Inserts para a tabela AGENDAMENTO
INSERT INTO AGENDAMENTO (dataAgendamento, horarioAgendamento, statusAgendamento, exame, codMedico, codEnfermeiro, codPaciente) VALUES
('2024-06-07', '08:00:00', 'Pendente', 'Eletrocardiograma', 7, 4, 1),
('2024-06-08', '09:00:00', 'Confirmado', 'Ecocardiograma', 8, 5, 2),
('2024-06-09', '10:00:00', 'Realizado', 'Ergometrico', 9, 6, 3);

use clinica;

select * from paciente;
select * from recepcionista;
SELECT * FROM agendamento;
SELECT * FROM agenda;

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

select count(codFuncionario) from enfermeiro where codFuncionario = 4;