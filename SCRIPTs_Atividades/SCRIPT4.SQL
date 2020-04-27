EXPLAIN PLAN FOR
SELECT nf.datacadastro,
       Count(nf.idnf)
FROM   exame_nf nf
WHERE  nf.idnf IN (SELECT idnf
                   FROM   exame_itemnf
                   WHERE  valor < 50)
GROUP  BY nf.datacadastro 
ORDER  BY nf.datacadastro;
SELECT PLAN_TABLE_OUTPUT  FROM TABLE(DBMS_XPLAN.DISPLAY);
