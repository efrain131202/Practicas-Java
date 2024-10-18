CREATE TABLE tipo_cambio (
    idPais NUMBER(10),
    idTipoCambio VARCHAR2(3),
    idPeriodo NUMBER(8),
    tipoCambio NUMBER(10,4),
    ccStatus NUMBER(1),
    ccFuente CHAR(1)
);

COMMIT;

CREATE TABLE fil_pais (
    idPais NUMBER(10),
    Pais VARCHAR2(50)
);

COMMIT;

INSERT INTO tipo_cambio VALUES (1, 'USD', 20020123, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (1, 'USD', 20020124, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (1, 'USD', 20020125, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (2, 'GTQ', 20010102, 1.2648, 1, 'P');
INSERT INTO tipo_cambio VALUES (2, 'GTQ', 20010103, 1.2648, 1, 'P');
INSERT INTO tipo_cambio VALUES (2, 'GTQ', 20010104, 1.2672, 1, 'P');
INSERT INTO tipo_cambio VALUES (4, 'HNL', 20010101, 0.6467, 1, 'R');
INSERT INTO tipo_cambio VALUES (4, 'HNL', 20010102, 0.6467, 1, 'R');
INSERT INTO tipo_cambio VALUES (4, 'HNL', 20010103, 0.6467, 1, 'R');
INSERT INTO tipo_cambio VALUES (6, 'PEN', 20010101, 2.7589, 1, 'P');
INSERT INTO tipo_cambio VALUES (6, 'PEN', 20010102, 2.7589, 1, 'P');
INSERT INTO tipo_cambio VALUES (6, 'PEN', 20010103, 2.7953, 1, 'P');
INSERT INTO tipo_cambio VALUES (7, 'MXP', 20010123, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (7, 'MXP', 20010124, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (7, 'MXP', 20010125, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (8, 'MXP', 20010123, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (8, 'MXP', 20010124, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (8, 'MXP', 20010125, 1.225, 1, 'A');
INSERT INTO tipo_cambio VALUES (9, 'ARS', 20010101, 9.7169, 1, 'P');
INSERT INTO tipo_cambio VALUES (9, 'ARS', 20010102, 9.7169, 1, 'P');
INSERT INTO tipo_cambio VALUES (9, 'ARS', 20010103, 9.837, 1, 'P');
INSERT INTO tipo_cambio VALUES (11, 'BRL', 20071005, 6.0195, 1, 'A');
INSERT INTO tipo_cambio VALUES (11, 'BRL', 20071006, 6.0195, 1, 'A');
INSERT INTO tipo_cambio VALUES (11, 'BRL', 20071007, 6.0195, 1, 'A');



COMMIT;

INSERT INTO fil_pais VALUES (-1, 'Sin Pais');
INSERT INTO fil_pais VALUES (0, 'CONSOLIDADO');
INSERT INTO fil_pais VALUES (1, 'MEXICO');
INSERT INTO fil_pais VALUES (2, 'GUATEMALA');
INSERT INTO fil_pais VALUES (4, 'HONDURAS');
INSERT INTO fil_pais VALUES (6, 'PERU');
INSERT INTO fil_pais VALUES (7, 'PANAMA');
INSERT INTO fil_pais VALUES (8, 'EL SALVADOR');
INSERT INTO fil_pais VALUES (9, 'ARGENTINA');
INSERT INTO fil_pais VALUES (11, 'BRASEIL');

COMMIT;

SELECT 
    tc.idPais,
    fp.Pais,
    tc.idTipoCambio,
    tc.idPeriodo,
    tc.tipoCambio,
    tc.ccStatus,
    tc.ccFuente
FROM 
    tipo_cambio tc
JOIN 
    fil_pais fp ON tc.idPais = fp.idPais
ORDER BY 
    tc.idPeriodo;

CREATE OR REPLACE PROCEDURE sp_ConsultaTipoCambio(
    p_FechaInicio IN NUMBER,
    p_FechaFin IN NUMBER,
    p_Pais IN VARCHAR2
)
IS
BEGIN
    FOR rec IN (
        SELECT 
            tc.idPais,
            fp.Pais,
            tc.idTipoCambio,
            tc.idPeriodo,
            tc.tipoCambio,
            tc.ccStatus,
            tc.ccFuente
        FROM 
            tipo_cambio tc
        JOIN 
            fil_pais fp ON tc.idPais = fp.idPais
        WHERE 
            tc.idPeriodo BETWEEN p_FechaInicio AND p_FechaFin
            AND fp.Pais = p_Pais
        ORDER BY 
            tc.idPeriodo
    )
    LOOP
        
        DBMS_OUTPUT.PUT_LINE(rec.idPais || ' | ' || rec.Pais || ' | ' || rec.idTipoCambio || ' | ' || 
                             rec.idPeriodo || ' | ' || rec.tipoCambio || ' | ' || rec.ccStatus || ' | ' || 
                             rec.ccFuente);
    END LOOP;
END;
/

BEGIN
    sp_ConsultaTipoCambio(20010101, 20020125, 'MEXICO');
END;
/