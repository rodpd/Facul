

-- NOME: RODRIGO PADILHA FONSECA
-- MATRICULA: 628826


-- QUESTAO 3

USE LIVRO;

SELECT TITULO, ANOPUBLIC, COUNT(*) QUANTIDADE, AVG(VALORAQUISICAO) PRECO_MEDIO
FROM LIVRO, EXEMPLAR, ASSUNTO
WHERE DATAAQUISICAO LIKE '%2019%'
AND CODLIVRO = LIVRO.CODIGO
AND CODASSUNTO = ASSUNTO.CODIGO
AND DESCRICAO = 'Literatura Brasileira'
GROUP BY TITULO, ANOPUBLIC;


-- QUESTAO 4

USE LIVRO;

SELECT TITULO, DATA, MULTA
FROM ALUNO, ITEMEMPREST, LIVRO, EXEMPLAR, EMPRESTIMO
WHERE NOME = 'BERNARDO FIGUEIREDO'
AND ALUNO.CODIGO = EMPRESTIMO.CODALUNO
AND EMPRESTIMO.CODEMPREST = ITEMEMPREST.CODEMPREST
AND EXEMPLAR.CODEXEMPLAR = ITEMEMPREST.CODEXEMPLAR
AND EXEMPLAR.CODLIVRO = LIVRO.CODIGO;


-- QUESTAO 5

 ( SELECT NOME
FROM ALUNO )
EXCEPT
( SELECT DISTINCT NOME
FROM ALUNO, EMPRESTIMO
WHERE CODALUNO = CODIGO );


-- QUESTAO 6

USE LIVRO;

SELECT DISTINCT NOME, COUNT(CODEMPREST) Qnt
FROM ALUNO
LEFT OUTER JOIN EMPRESTIMO on CODIGO = CODALUNO
GROUP BY NOME, CODALUNO;


-- QUESTAO 7

USE LIVRO;

SELECT DISTINCT NOMEAUT
FROM LIVRO, AUTOR, ASSUNTO, AUTORIA
WHERE DESCRICAO = 'Literatura Brasileira'
AND CODASSUNTO = ASSUNTO.CODIGO
AND AUTOR.CODIGO = AUTORIA.CODAUTOR
AND LIVRO.CODIGO = CODLIVRO;


-- QUESTAO 8

USE LIVRO;

SELECT NOME
FROM ALUNO, EMPRESTIMO
WHERE DATA LIKE '%2019%'
AND CODIGO = CODALUNO
GROUP BY NOME
HAVING COUNT(*) >= 10;


-- QUESTAO 9

USE LIVRO;

SELECT DISTINCT NOMEAUT
FROM AUTOR, AUTORIA
WHERE CODLIVRO IN ( SELECT CODLIVRO 
						FROM AUTOR, AUTORIA 
						WHERE NOMEAUT = 'NAVATHE'
						AND CODAUTOR = CODIGO )
AND CODAUTOR = CODIGO
AND NOMEAUT NOT LIKE '%NAVATHE%';


-- QUESTAO 10

USE LIVRO;

USE LIVRO;

SELECT NOMEAUT
		FROM AUTORIA, AUTOR
		WHERE CODIGO = CODAUTOR 
		GROUP BY NOMEAUT
		HAVING COUNT(CODAUTOR) > ( SELECT COUNT(*)
									FROM AUTORIA, AUTOR
									WHERE CODIGO = CODAUTOR
									AND NOMEAUT = 'NAVATHE' );


-- QUESTAO 11

USE LIVRO;

SELECT NOME, AVG(MULTA) Multa_Media
			FROM ALUNO
			LEFT OUTER JOIN EMPRESTIMO E on CODIGO = E.CODALUNO
			LEFT OUTER JOIN ITEMEMPREST I on I.CODEMPREST = E.CODEMPREST
			WHERE I.CODEMPREST = E.CODEMPREST
			AND CODALUNO = CODIGO
			GROUP BY NOME
			HAVING AVG(MULTA) > ( SELECT AVG(MULTA)
								FROM ALUNO, ITEMEMPREST, EMPRESTIMO
								WHERE CIDADE = 'Belo Horizonte' 
								AND ITEMEMPREST.CODEMPREST = EMPRESTIMO.CODEMPREST
								AND CODALUNO = CODIGO );


-- QUESTAO 12

USE LIVRO;


SELECT NOME
FROM ALUNO
WHERE NOME IN ( SELECT NOME
				FROM ALUNO, EMPRESTIMO
				WHERE CODIGO = CODALUNO
				GROUP BY NOME
				HAVING COUNT(*) > ( SELECT COUNT(*)
				FROM AUTOR, AUTORIA, ITEMEMPREST, EXEMPLAR
				WHERE NOMEAUT = 'MACHADO DE ASSIS'
				AND CODAUTOR = CODIGO
				AND EXEMPLAR.CODLIVRO = AUTORIA.CODLIVRO
				AND EXEMPLAR.CODEXEMPLAR = ITEMEMPREST.CODEXEMPLAR) );


-- QUESTAO 13

USE LIVRO;

SELECT NOMEEDIT
					FROM EDITORA, LIVRO
					WHERE EDITORA.CODIGO = CODEDIT
					GROUP BY NOMEEDIT
					HAVING COUNT(*) > ( SELECT COUNT(*)
										FROM EDITORA, LIVRO
										WHERE NOMEEDIT = 'CAMPUS'
										AND CODEDIT = EDITORA.CODIGO );

-- QUESTAO 14

USE LIVRO

SELECT TITULO, NOME
FROM LIVRO L, EMPRESTIMO E, ITEMEMPREST I, EXEMPLAR EX, ALUNO A
WHERE L.CODIGO = CODLIVRO
AND A.CODIGO = E.CODALUNO
AND EX.CODEXEMPLAR = I.CODEXEMPLAR
AND I.CODEMPREST = E.CODEMPREST
AND DATA LIKE '%2019-09%'
AND DATADEVOL LIKE '%2019-09%'
AND DAY (DATADEVOL) - DAY (DATA) <= 2;


-- QUESTAO 15

USE LIVRO;

SELECT TITULO
FROM ITEMEMPREST I, EXEMPLAR E, LIVRO, EMPRESTIMO EM
WHERE CODIGO = CODLIVRO
AND E.CODEXEMPLAR = I.CODEXEMPLAR
AND EM.CODEMPREST = I.CODEMPREST
AND DATA LIKE '%2019%'
GROUP BY TITULO 
HAVING COUNT(*) = ( SELECT TOP 1 COUNT(*) QNT
				FROM ITEMEMPREST I, EXEMPLAR E, LIVRO, EMPRESTIMO EM
				WHERE CODIGO = CODLIVRO
				AND E.CODEXEMPLAR = I.CODEXEMPLAR
				AND EM.CODEMPREST = I.CODEMPREST
				AND DATA LIKE '%2019%'
				GROUP BY TITULO
				ORDER BY QNT DESC );


-- QUESTAO 16

USE LIVRO;

SELECT TITULO, CODEXEMPLAR
FROM LIVRO A, EXEMPLAR B
WHERE CODIGO = CODLIVRO
AND VALORAQUISICAO > ( SELECT AVG(VALORAQUISICAO)
						FROM LIVRO, EXEMPLAR
						WHERE CODLIVRO = CODIGO
						AND CODLIVRO = B.CODLIVRO )



-- QUESTAO 17

DELETE FROM ALUNO
WHERE NOME IN ( SELECT NOME
				FROM ALUNO
				LEFT OUTER JOIN EMPRESTIMO ON CODIGO = CODALUNO
				GROUP BY NOME
				HAVING COUNT(CODEMPREST) = 0 );


-- QUESTAO 18

USE LIVRO;

UPDATE LIVRO
SET CODEDIT = ( SELECT CODIGO
				FROM EDITORA
				WHERE NOMEEDIT = 'PEARSON' )
WHERE CODEDIT = ( SELECT CODIGO
				FROM EDITORA
				WHERE NOMEEDIT = 'MAKRON BOOKS' );


