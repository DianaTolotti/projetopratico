CREATE OR replace PROCEDURE definir_valores
IS
  CURSOR c_itemnf IS
    SELECT iditemnf,
           idnf,
           idproduto,
           qtde,
           valor
    FROM   exame_itemnf
    FOR UPDATE;
  CURSOR c_nf IS
    SELECT idnf,
           numero,
           datacadastro,
           totalgeral
    FROM   exame_nf
    FOR UPDATE;
BEGIN
    FOR itemnf IN c_itemnf LOOP
        UPDATE exame_itemnf
        SET    valor = dbms_random.Value(1, 100)
        WHERE  iditemnf = itemnf.iditemnf;
    END LOOP;

    FOR nf IN c_nf LOOP
        UPDATE exame_nf
        SET    totalgeral = (SELECT SUM(valor)
                             FROM   exame_itemnf
                             WHERE  idnf = nf.idnf)
        WHERE  idnf = nf.idnf;
    END LOOP;
END; 