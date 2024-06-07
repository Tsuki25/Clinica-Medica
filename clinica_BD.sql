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
(01001000, 'Praça da Sé', 'Sé', 'São Paulo', 'SP', 1, 'Edifício Central'),
(01045001, 'Rua Barão de Itapetininga', 'República', 'São Paulo', 'SP', 50, 'Sala 301'),
(01225000, 'Rua João Guimarães Rosa', 'Santa Cecília', 'São Paulo', 'SP', 100, 'Apto 101'),
(01310930, 'Av. Paulista', 'Bela Vista', 'São Paulo', 'SP', 1578, 'Apto 1302'),
(01415000, 'Rua Oscar Freire', 'Jardins', 'São Paulo', 'SP', 1250, 'Casa 2'),
(01508001, 'Rua do Paraíso', 'Paraíso', 'São Paulo', 'SP', 200, 'Bloco B, Apto 203'),
(02022000, 'Rua Voluntários da Pátria', 'Santana', 'São Paulo', 'SP', 300, 'Sala 2'),
(03071000, 'Rua Silva Teles', 'Brás', 'São Paulo', 'SP', 400, 'Galpão'),
(04018001, 'Rua Tutóia', 'Paraíso', 'São Paulo', 'SP', 500, 'Apto 501'),
(04105000, 'Rua Luís Góis', 'Mirandópolis', 'São Paulo', 'SP', 600, 'Casa 3'),
(05015001, 'Rua Caiubi', 'Perdizes', 'São Paulo', 'SP', 700, 'Apto 704'),
(05010000, 'Av. Sumaré', 'Perdizes', 'São Paulo', 'SP', 800, 'Cobertura');

-- Inserções para PACIENTE
INSERT INTO PACIENTE (cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, historico, alergias, medicamentosUtilizados, anotacoes, codEnd) VALUES
('123.456.789-09', 'Carlos', 'Pereira', 'Masculino', '1975-03-03', '3456-7890', '99456-7890', 'carlos.pereira@gmail.com', 'Histórico de hipertensão', 'Alergia a penicilina', 'Losartana', 'Monitorar pressão arterial regularmente', 1),
('987.654.321-00', 'Ana', 'Santos', 'Feminino', '1985-04-04', '4455-6677', '99455-6677', 'ana.santos@gmail.com', 'Histórico de asma', 'Alergia a pólen', 'Salbutamol', 'Evitar locais com alta concentração de pólen', 2),
('159.753.486-20', 'Pedro', 'Costa', 'Masculino', '1995-05-05', '5566-7788', '99566-7788', 'pedro.costa@gmail.com', 'Histórico de diabetes tipo 1', 'Alergia a frutos do mar', 'Insulina', 'Realizar medições de glicose regularmente', 3);

-- Inserções para RECEPCIONISTA
INSERT INTO RECEPCIONISTA (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, codEnd) VALUES
(1, '325.654.987-09', 'Paula', 'Costa', 'Feminino', '1992-07-12', '3789-4567', '98945-1234', 'paula.costa@gmail.com', 'senha789', 4),
(2, '123.464.788-01', 'Mariana', 'Silva', 'Feminino', '1990-02-10', '3123-4567', '99123-4567', 'mariana.silva@gmail.com', 'senha123', 5),
(7, '987.689.321-19', 'Rafael', 'Souza', 'Masculino', '1988-03-15', '3987-6543', '99876-5432', 'rafael.souza@gmail.com', 'senha321', 10);

-- Inserções para ENFERMEIRO
INSERT INTO ENFERMEIRO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, cip, codEnd) VALUES
(3, '475.351.654-20', 'Ana', 'Pereira', 'Feminino', '1987-09-25', '3456-7890', '99834-5678', 'ana.pereira@gmail.com', 'senha456', 'CIP789', 6),
(4, '759.164.426-13', 'Bruno', 'Ferreira', 'Masculino', '1982-06-22', '3344-5566', '99445-6677', 'bruno.ferreira@gmail.com', 'senha789', 'CIP123', 7),
(9, '357.988.652-22', 'Juliana', 'Martins', 'Feminino', '1995-08-30', '3778-8899', '99988-7766', 'juliana.martins@gmail.com', 'senha654', 'CIP456', 12);

-- Inserções para MEDICO
INSERT INTO MEDICO (codFuncionario, cpf, nome, sobrenome, sexo, dataNascimento, telefone, celular, email, senha, crm, codEnd) VALUES
(5, '865.917.332-11', 'Carlos', 'Santos', 'Masculino', '1973-11-30', '3345-6789', '99765-4321', 'carlos.santos@gmail.com', 'senha123', 'CRM456', 8),
(6, '124.373.954-52', 'Fernanda', 'Lima', 'Feminino', '1978-12-01', '3234-5678', '99345-6789', 'fernanda.lima@gmail.com', 'senha321', 'CRM789', 9),
(8, '469.748.132-45', 'Miguel', 'Oliveira', 'Masculino', '1985-05-15', '3345-6789', '99654-3210', 'miguel.oliveira@gmail.com', 'senha987', 'CRM321', 11);

-- Inserções para ELETROCARDIOGRAMA
INSERT INTO ELETROCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, ritmo, fc, conclusoes, codPaciente, codMedico, codEnfermeiro) VALUES
(1, 'NORMAL_ADULTO', 74.0, 1.78, 'Amil', 'Sinusal', 72, 'Eletrocardiograma normal.', 1, 5, null),
(2, 'ALTERACAO_RELAXAMENTO_VE', 60.0, 1.65, 'Unimed', 'Arritmia', 85, 'Indícios de alteração no relaxamento do ventrículo esquerdo.', 2, 6, null),
(3, 'OUTROS', 68.0, 1.70, 'SulAmérica', 'Bradicardia', 55, 'Bradicardia sinusal detectada.', 3, 8, null);

-- Inserções para ECOCARDIOGRAMA
/*INSERT INTO ECOCARDIOGRAMA (codExame, diagClinico, peso, altura, convenio, raizAorta, atrioEsquerdo, ventriculoDir, ventriculoEsqSis, ventriculoEsqDias, ventriculoEsqParede, septoIntra, fraccaoEncurtamento, fraccaoEjecao, codPaciente, codMedico, codEnfermeiro) VALUES
(4, 'Diagnóstico C', 70.5, 1.75, 'Convenio A', 34, 45, 23, 34, 56, 34, 23, 50.5, 65.3, 1, 3, null),
(5, 'Diagnóstico D', 68.0, 1.65, 'Convenio B', 35, 46, 24, 35, 57, 35, 24, 51.5, 66.3, 2, 3, null);*/

-- Inserções para ERGONOMETRICO
INSERT INTO ERGONOMETRICO (codExame, diagClinico, peso, altura, convenio, marcaPasso, fumante, observacoes, codPaciente, codMedico, codEnfermeiro) VALUES
(4, 'OUTROS', 70.5, 1.75, 'Amil', FALSE, TRUE, 'Paciente apresenta dificuldades durante o teste de ergometria.', 2, null, 4);

-- Inserções para HOLTER
INSERT INTO HOLTER (codExame, diagClinico, peso, altura, convenio, ritmoCardiaco, variabilidadeCardiaca, intervaloQT, intervaloPR, condIntraventricular, segmentoST, extrassistotoles, arritmias, observacoes, codPaciente, codMedico, codEnfermeiro) VALUES
(5, 'NORMAL_ADULTO', 68.0, 1.65, 'Notre Dame', 75, 5.5, 0.5, 0.3, 'Normal', 'Normal', 'Poucas', 'Leve', 'Sem alterações consideraveis nos resultados', 1, null, 3);

-- Inserções para ENTREGA
INSERT INTO ENTREGA (dataRetirada, horarioRetirada, retiradoPor, codRecepcionista, codExame) VALUES
('2024-06-19', '14:00:00', 'Flávio Armut', 1, 1),
('2024-06-20', '11:00:00', 'Rafael Bispo', 2, 3);

-- Inserções para AGENDA
INSERT INTO AGENDA (dataReserva, horarioInicio, horarioFim, motivo, codMedico, codEnfermeiro) VALUES
('2024-07-19', '09:00:00', '10:30:00', 'Consulta Psicologo', 6, null),
('2024-07-12', '08:00:00', '18:00:00', 'Doação de Sangue', null, 3),
('2024-07-08', '08:00:00', '10:00:00', 'Reunião Filha', 5, null),
('2024-07-17', '15:00:00', '18:00:00', 'Dentista', null, 3);

-- Inserções para AGENDAMENTO
INSERT INTO AGENDAMENTO (dataAgendamento, horarioAgendamento, statusAgendamento, exame, codMedico, codEnfermeiro, codPaciente) VALUES
('2024-06-25', '10:30:00', 'AGENDADO', 'ELETROCARDIOGRAMA', 6, null, 1),
('2024-06-25', '15:00:00', 'AGENDADO', 'ELETROCARDIOGRAMA', 8, null, 2),
('2024-06-27', '09:45:00', 'AGENDADO', 'ELETROCARDIOGRAMA', 5, null, 3),
('2024-06-26', '13:15:00', 'AGENDADO', 'HOLTER', null, 4, 2);


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