USE LIVRO;

SELECT NOMEEDIT, AVG(VALORAQUISICAO)
FROM LIVRO L, EDITORA E, EXEMPLAR
WHERE L.CODIGO = CODLIVRO
AND E.CODIGO = CODEDIT
GROUP BY NOMEEDIT;


(SELECT TITULO, CODEXEMPLAR, VALORAQUISICAO, NOMEEDIT
FROM EXEMPLAR, LIVRO L, EDITORA E
WHERE E.CODIGO = CODEDIT
AND CODLIVRO = L.CODIGO)