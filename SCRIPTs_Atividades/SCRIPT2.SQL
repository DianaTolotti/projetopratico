--SCRIPT2 TECHNO

DECLARE
    l_idnf      NUMBER(10);
    i_qtde      INTEGER := 0;
    n_data      DATE := ( SYSDATE - 9 );
    n_nf_numero NUMBER;
    n_t_numero  NUMBER;
BEGIN
    FOR nf IN 1..1000 LOOP
        IF i_qtde = 100 THEN
          n_data := ( n_data + 1 );

          i_qtde := 0;
        END IF;

        n_t_numero := 1;

        WHILE n_t_numero > 0 LOOP
            n_nf_numero := Round(dbms_random.Value(500, 9999));

            SELECT Count(*)
            INTO   n_t_numero
            FROM   exame_nf
            WHERE  numero = n_nf_numero;
        END LOOP;

        INSERT INTO exame_nf
                    (numero,
                     datacadastro,
                     totalgeral)
        VALUES      ( n_nf_numero,
                     n_data,
                     0 )
        returning idnf INTO l_idnf;

        FOR inf IN 1..3 LOOP
            INSERT INTO exame_itemnf
                        (idnf,
                         idproduto,
                         qtde,
                         valor)
            VALUES      ( l_idnf,
                         Round(dbms_random.Value(1, 5000)),
                         Round(dbms_random.Value(1, 30)),
                         dbms_random.Value(50, 1500) );
        END LOOP;

        UPDATE exame_nf
        SET    totalgeral = (SELECT SUM(valor)
                             FROM   exame_itemnf
                             WHERE  idnf = l_idnf)
        WHERE  idnf = l_idnf;

        i_qtde := i_qtde + 1;
    END LOOP;

    COMMIT;
END; 