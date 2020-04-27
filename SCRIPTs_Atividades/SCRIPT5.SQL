CREATE INDEX item_valor_idx ON exame_itemnf (CASE WHEN valor < 50 THEN idnf END);
ANALYZE INDEX item_valor_idx COMPUTE STATISTICS;
EXPLAIN PLAN FOR
SELECT nf.datacadastro,
       Count(nf.idnf)
FROM   exame_nf nf
WHERE  nf.idnf = ANY (SELECT /*+ INDEX(exame_itemnf item_valor_idx) */ 
                    CASE WHEN valor < 50 THEN idnf END
                   FROM   exame_itemnf)
GROUP  BY nf.datacadastro 
ORDER  BY nf.datacadastro;
SELECT PLAN_TABLE_OUTPUT  FROM TABLE(DBMS_XPLAN.DISPLAY);