--CREATE DATABASE LIVRO;

USE LIVRO;

DROP TABLE IF EXISTS ALUNO;
DROP TABLE IF EXISTS ASSUNTO;
DROP TABLE IF EXISTS AUTOR;
DROP TABLE IF EXISTS AUTORIA;
DROP TABLE IF EXISTS EDITORA;
DROP TABLE IF EXISTS EMPRESTIMO;
DROP TABLE IF EXISTS EXEMPLAR;
DROP TABLE IF EXISTS ITEMEMPREST;
DROP TABLE IF EXISTS LIVRO;


CREATE TABLE AUTOR
( CODIGO	INTEGER NOT NULL,
 NOMEAUT	VARCHAR(30),
PRIMARY KEY (CODIGO)
);

CREATE TABLE EDITORA
( CODIGO	INTEGER NOT NULL,
 NOMEEDIT	VARCHAR(20),
PRIMARY KEY (CODIGO)
);

CREATE TABLE ASSUNTO
( CODIGO	INTEGER NOT NULL,
 DESCRICAO	VARCHAR(30),
PRIMARY KEY (CODIGO)
);

CREATE TABLE LIVRO
( CODIGO	INTEGER NOT NULL,
 TITULO		VARCHAR(60),
 ANOPUBLIC	DATE,
 CODEDIT	INTEGER,
 CODASSUNTO	INTEGER,
 PRIMARY KEY (CODIGO),
 FOREIGN KEY (CODEDIT) REFERENCES EDITORA(CODIGO),
 FOREIGN KEY (CODASSUNTO) REFERENCES ASSUNTO(CODIGO)
);

CREATE TABLE AUTORIA
( CODLIVRO	INTEGER NOT NULL,
 CODAUTOR	INTEGER NOT NULL,
PRIMARY KEY(CODLIVRO, CODAUTOR),
FOREIGN KEY(CODLIVRO) REFERENCES LIVRO(CODIGO),
FOREIGN KEY(CODAUTOR) REFERENCES AUTOR(CODIGO)
);


CREATE TABLE EXEMPLAR
( CODEXEMPLAR	INTEGER NOT NULL,
 CODLIVRO	INTEGER,
 DATAAQUISICAO	DATE,
 VALORAQUISICAO	INTEGER,
 PRIMARY KEY (CODEXEMPLAR),
 FOREIGN KEY (CODLIVRO) REFERENCES LIVRO(CODIGO)
);


CREATE TABLE ALUNO
( CODIGO	INTEGER NOT NULL,
 NOME		VARCHAR(30),
 DATANASC	DATE,
 CIDADE		VARCHAR(20),
PRIMARY KEY (CODIGO)
);

CREATE TABLE EMPRESTIMO
( CODEMPREST	INTEGER NOT NULL,
 DATA		DATE,
 CODALUNO	INTEGER,
PRIMARY KEY (CODEMPREST),
FOREIGN KEY (CODALUNO) REFERENCES ALUNO(CODIGO)
); 

CREATE TABLE ITEMEMPREST
( CODEMPREST	INTEGER NOT NULL,
 ITEM		INTEGER NOT NULL,
 CODEXEMPLAR	INTEGER,
 DATADEVOL	DATE,
 MULTA		INTEGER,
PRIMARY KEY (CODEMPREST, ITEM),
FOREIGN KEY (CODEMPREST) REFERENCES EMPRESTIMO(CODEMPREST),
FOREIGN KEY (CODEXEMPLAR) REFERENCES EXEMPLAR(CODEXEMPLAR)
);

