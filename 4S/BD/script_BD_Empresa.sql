--CREATE DATABASE EMPRESA;
USE EMPRESA;

DROP TABLE IF EXISTS DEPENDENTE;
DROP TABLE IF EXISTS TRABALHA_EM;
DROP TABLE IF EXISTS PROJETO;
DROP TABLE IF EXISTS LOCALIZACAO_DEP;
--ALTER TABLE FUNCIONARIO DROP CONSTRAINT FK_FUNCDEP;
DROP TABLE IF EXISTS DEPARTAMENTO;
DROP TABLE IF EXISTS FUNCIONARIO;


CREATE TABLE FUNCIONARIO
(Pnome            VARCHAR(50)   NOT NULL,
 Minicial         CHAR,
 Unome            VARCHAR(50)   NOT NULL,
 Cpf              CHAR(11)      NOT NULL,
 Datanasc         DATE,
 Endereco         VARCHAR(100),
 Sexo             CHAR,
 Salario          DECIMAL(10,2),
 Cpf_supervisor   CHAR(11),
 Dnr              INTEGER,
 PRIMARY KEY (Cpf)
 );
 
CREATE TABLE DEPARTAMENTO
 (Dnome                VARCHAR(15)    NOT NULL,
  Dnumero              INT            NOT NULL,
  Cpf_gerente          CHAR(11),
  Data_inicio_gerente  DATE,
  PRIMARY KEY (Dnumero),
  UNIQUE (Dnome)
  );
  
CREATE TABLE LOCALIZACAO_DEP
 (Dnumero             INT            NOT NULL,
  Dlocal              VARCHAR(15)    NOT NULL,
   PRIMARY KEY (Dnumero, Dlocal)
 );
   
  CREATE TABLE PROJETO
  (Projnome          VARCHAR(20)      NOT NULL,
   Projnumero        INT              NOT NULL,
   Projlocal         VARCHAR(15),
   Dnum              INT,
   PRIMARY KEY (Projnumero),
   UNIQUE (Projnome)
   );
    
  CREATE TABLE TRABALHA_EM
  (Fcpf              CHAR(11)        NOT NULL,
   Pnr               INT             NOT NULL,
   Horas             DECIMAL(3,1)    NOT NULL,
   PRIMARY KEY (Fcpf, Pnr)
   );
  
  CREATE TABLE DEPENDENTE
  (Fcpf              CHAR(11)        NOT NULL,
   Nome_dependente   VARCHAR(15)     NOT NULL,
   Sexo              CHAR,
   Datanasc          DATE,
   Parentesco        VARCHAR(8)
   PRIMARY KEY (Fcpf, Nome_dependente)
   );
   
  ALTER TABLE FUNCIONARIO
    ADD CONSTRAINT FK_FUNCSUP FOREIGN KEY (Cpf_supervisor)
	REFERENCES FUNCIONARIO (Cpf);
	
  ALTER TABLE FUNCIONARIO
    ADD CONSTRAINT FK_FUNCDEP FOREIGN KEY (Dnr)
	REFERENCES DEPARTAMENTO (Dnumero);
	
  ALTER TABLE DEPARTAMENTO
    ADD CONSTRAINT FK_DEPGER FOREIGN KEY (Cpf_gerente)
	REFERENCES FUNCIONARIO (Cpf);
	
  ALTER TABLE LOCALIZACAO_DEP
    ADD CONSTRAINT FK_DEP FOREIGN KEY (Dnumero)
	REFERENCES DEPARTAMENTO (Dnumero);
	
  ALTER TABLE PROJETO 
    ADD CONSTRAINT FK_PROJDEP FOREIGN KEY (Dnum)
	REFERENCES DEPARTAMENTO (Dnumero);
	
  ALTER TABLE TRABALHA_EM
    ADD CONSTRAINT FK_TRABFUNC FOREIGN KEY (Fcpf)
	REFERENCES FUNCIONARIO (Cpf);
	
  ALTER TABLE TRABALHA_EM
	ADD CONSTRAINT FK_TRABDEP FOREIGN KEY (Pnr)
	REFERENCES PROJETO (Projnumero);
	
  ALTER TABLE DEPENDENTE 
    ADD CONSTRAINT FK_DEPFUNC FOREIGN KEY (Fcpf)
	REFERENCES FUNCIONARIO (Cpf);
	
  INSERT INTO DEPARTAMENTO 
    VALUES ('Pesquisa', 5, NULL, NULL);
	
  INSERT INTO DEPARTAMENTO 
    VALUES ('Administracao', 4, NULL, NULL);
	
  INSERT INTO DEPARTAMENTO 
    VALUES ('Matriz', 1, NULL, NULL);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Jorge', 'E', 'Brito', '88866555576','1937-11-10','Rua do Horto, 35, Sao Paulo, SP', 'M', 55000, NULL,1);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Fernando', 'T', 'Wong', '33344555587','1955-12-08','Rua da Lapa, 34, Sao Paulo, SP', 'M', 40000, '88866555576',5);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Joao', 'B', 'Silva', '12345678966','1965-01-09','Rua das Flores, 751, Sao Paulo, SP', 'M', 30000, '33344555587',5);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Jennifer', 'S', 'Souza', '98765432168','1941-06-20','Av. Arthur de Lima, 54, Santo Andre, SP', 'F', 43000, '88866555576',4);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Alice', 'J', 'Zelaya', '99988777767','1968-01-19','Rua Souza Lima, 35, Curitiba, PR', 'F', 25000, '98765432168',4);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Joice', 'A', 'Leite', '45345345376','1972-07-31','A. Lucas Obes, 74, Sao Paulo, SP', 'F', 25000, '33344555587',5);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Ronaldo', 'K', 'Lima', '66688444476','1962-09-15','Rua Reboucas, 65, Piracicaba, SP', 'M', 38000, '33344555587',5);
	
  INSERT INTO FUNCIONARIO
    VALUES ('Andre', 'V', 'Pereira', '98798798733','1969-03-29','Rua Timbira, 35, Sao Paulo, SP', 'M', 25000, '98765432168',4);
  
  UPDATE DEPARTAMENTO
  SET    Cpf_gerente = '33344555587', 
         Data_inicio_gerente = '1988-05-22'
  WHERE Dnumero = 5;
	
  UPDATE DEPARTAMENTO
  SET    Cpf_gerente = '98765432168', 
         Data_inicio_gerente = '1995-01-01'
  WHERE Dnumero = 4;
  
  UPDATE DEPARTAMENTO
  SET    Cpf_gerente = '88866555576', 
         Data_inicio_gerente = '1981-06-19'
  WHERE Dnumero = 1;
  
  INSERT INTO LOCALIZACAO_DEP
    VALUES (1, 'Sao Paulo');
	
  INSERT INTO LOCALIZACAO_DEP
    VALUES (4, 'Maua');
	
  INSERT INTO LOCALIZACAO_DEP
    VALUES (5, 'Santo Andre');
	
  INSERT INTO LOCALIZACAO_DEP
    VALUES (5, 'Itu');
	
  INSERT INTO LOCALIZACAO_DEP
    VALUES (5, 'Sao Paulo');
	
  INSERT INTO PROJETO
    VALUES ('Produto X', 1, 'Santo Andre', 5);
	
  INSERT INTO PROJETO
    VALUES ('Produto Y', 2, 'Itu', 5);
	
  INSERT INTO PROJETO
    VALUES ('Produto Z', 3, 'Sao Paulo', 5);
	
  INSERT INTO PROJETO
    VALUES ('Informatizacao', 10, 'Maua', 4);
	
  INSERT INTO PROJETO
    VALUES ('Reorganizacao', 20, 'Sao Paulo', 1);
	
  INSERT INTO PROJETO
    VALUES ('Novos Beneficios', 30, 'Maua', 4);
	
  INSERT INTO TRABALHA_EM
    VALUES ('12345678966', 1, 32.5);
	
  INSERT INTO TRABALHA_EM
    VALUES ('12345678966', 2, 7.5);
	
  INSERT INTO TRABALHA_EM
    VALUES ('66688444476', 3, 40);
	
  INSERT INTO TRABALHA_EM
    VALUES ('45345345376', 1, 20);
	
  INSERT INTO TRABALHA_EM
    VALUES ('45345345376', 2, 20);
	
  INSERT INTO TRABALHA_EM
    VALUES ('33344555587', 2, 10);
	
  INSERT INTO TRABALHA_EM
    VALUES ('33344555587', 3, 10);
	
  INSERT INTO TRABALHA_EM
    VALUES ('33344555587', 10, 10);
	
  INSERT INTO TRABALHA_EM
    VALUES ('33344555587', 20, 10);
	
  INSERT INTO TRABALHA_EM
    VALUES ('99988777767', 30, 30);
	
  INSERT INTO TRABALHA_EM
    VALUES ('99988777767', 10, 10);
	
  INSERT INTO TRABALHA_EM
    VALUES ('98798798733', 10, 35);
	
  INSERT INTO TRABALHA_EM
    VALUES ('98798798733', 30, 5);
	
  INSERT INTO TRABALHA_EM
    VALUES ('98765432168', 30, 20);
	
  INSERT INTO TRABALHA_EM
    VALUES ('98765432168', 20, 20);
	
  INSERT INTO TRABALHA_EM
    VALUES ('88866555576', 20, 40);
	
  INSERT INTO DEPENDENTE
    VALUES ('33344555587', 'Alicia', 'F', '1986-04-05', 'Filha');
	
  INSERT INTO DEPENDENTE
    VALUES ('33344555587', 'Tiago', 'M', '1983-10-25', 'Filho');
	
  INSERT INTO DEPENDENTE
    VALUES ('33344555587', 'Janaina', 'F', '1958-05-03', 'Esposa');
	
  INSERT INTO DEPENDENTE
    VALUES ('98765432168', 'Antonio', 'M', '1942-02-28', 'Marido');
	
  INSERT INTO DEPENDENTE
    VALUES ('12345678966', 'Michael', 'M', '1988-01-04', 'Filho');
	
  INSERT INTO DEPENDENTE
    VALUES ('12345678966', 'Alicia', 'F', '1988-12-30', 'Filha');
	
	INSERT INTO DEPENDENTE
    VALUES ('33344555587', 'Elizabeth', 'F', '1967-05-05', 'Esposa');
	
 