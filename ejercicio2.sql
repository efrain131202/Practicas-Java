create table templeados (
    nuemp    number(3) primary key,
    nombre   varchar2(255) not null,
    depto    number(3) not null,
    puesto   varchar2(255) not null,
    telefono number(10) not null,
    ext      number(3) not null,
    anos     number(3) not null,
    salario  number(8,2) not null,
    comision number(7,2) not null
);
commit;

INSERT INTO TEmpleados VALUES (10, 'JORGE', 20, 'GERENTE', 35453534, 123, 7, 18375.5, NULL);
INSERT INTO TEmpleados VALUES (20, 'JOSE', 20, 'VENDEDOR', 34534567, 123, 8, 13240.4, 612.5);
INSERT INTO TEmpleados VALUES (30, 'GUSTAVO', 38, 'GERENTE', 34534678, 124, 5, 17500, NULL);
INSERT INTO TEmpleados VALUES (40, 'ENRIQUE', 38, 'VENDEDOR', 34533124, 124, 6, 18000.6, 856);
INSERT INTO TEmpleados VALUES (50, 'MARCO', 15, 'GERENTE', 34538767, 125, 10, 20659, NULL);
INSERT INTO TEmpleados VALUES (60, 'ISRAEL', 38, 'VENDEDOR', 34539898, 126, NULL, 16808.2, 650.25);
INSERT INTO TEmpleados VALUES (70, 'GERMAN', 15, 'VENDEDOR', 34555687, 127, 7, 16502.5, 1115.2);
INSERT INTO TEmpleados VALUES (80, 'ALBERTO', 20, 'EMPLEADO', 34234433, 128, NULL, 13504, 128);
INSERT INTO TEmpleados VALUES (90, 'SAMUEL', 42, 'VENDEDOR', 34588998, 129, 6, 18200, 1386);
INSERT INTO TEmpleados VALUES (100, 'RICARDO', 42, 'GERENTE', 34534566, 122, 7, 18352.34, NULL);
INSERT INTO TEmpleados VALUES (110, 'JUAN', 15, 'EMPLEADO', 34538941, 135, 5, 12502.6, 506);
INSERT INTO TEmpleados VALUES (120, 'MIGUEL', 38, 'EMPLEADO', 34535644, 111, NULL, 12954, 180);
commit;

create table tdeptos (
    numdepto     number(3) primary key,
    nomdepto     varchar2(20) not null,
    gerente      number(3) not null,
    division     varchar2(20) not null,
    localizacion varchar2(20) not null
);
commit;

INSERT INTO TDeptos VALUES (10, 'CENTRAL', 160, 'CORPORATIVO', 'D.F.');
INSERT INTO TDeptos VALUES (15, 'CULIACAN', 50, 'NORTE', 'SINALOA');
INSERT INTO TDeptos VALUES (20, 'NUEVO LEON', 10, 'NORTE', 'MONTERREY');
INSERT INTO TDeptos VALUES (38, 'CHIHUAHUA', 30, 'NORTE', 'CHIHUAHUA');
INSERT INTO TDeptos VALUES (42, 'TLAXCALA', 100, 'CENTRO', 'TLAXCALA');
INSERT INTO TDeptos VALUES (51, 'MORELIA', 140, 'CENTRO', 'MICHOACAN');
INSERT INTO TDeptos VALUES (66, 'TUXTLA', 270, 'SUR', 'CHIAPAS');
INSERT INTO TDeptos VALUES (84, 'QUINTANA ROO', 290, 'SUR', 'QUINTANA ROO');
commit;

CREATE TABLE TSedes (
    LOCALIZACION VARCHAR2(20) PRIMARY KEY,
    ESTADO VARCHAR2(20) NOT NULL,
    PAIS VARCHAR2(2) NOT NULL,
    REGION_GLOBAL VARCHAR2(20) NOT NULL
);
commit;

INSERT INTO TSedes VALUES ('D.F.', 'DF', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('SINALOA', 'CULIACAN', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('MONTERREY', 'NUEVO LEON', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('CHIHUAHUA', 'CHIHUAHUA', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('TLAXCALA', 'TLAXCALA', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('MICHOACAN', 'MORELIA', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('CHIAPAS', 'TUXTLA', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('QUINTANA ROO', 'QUINTANA ROO', 'MX', 'AMERICA');
INSERT INTO TSedes VALUES ('PHOENIX', 'ARIZONA', 'EU', 'AMERICA');
INSERT INTO TSedes VALUES ('BARCELONA', 'BARCELONA', 'ES', 'EUROPA');
commit;

/*1*/
SELECT d.nomdepto, SUM(e.salario) AS total_sueldo
FROM TEmpleados e
JOIN TDeptos d ON e.depto = d.numdepto
GROUP BY d.nomdepto;
commit;

/*2*/
SELECT d.nomdepto, SUM(e.salario) AS total_sueldo
FROM TEmpleados e
JOIN TDeptos d ON e.depto = d.numdepto
JOIN TSedes s ON d.localizacion = s.localizacion
WHERE s.pais = 'MX'
GROUP BY d.nomdepto;
commit;

/*3*/
SELECT e.nombre
FROM TEmpleados e
JOIN TDeptos d ON e.depto = d.numdepto
WHERE d.gerente = 30;
commit;

/*4*/
SELECT e.nombre, d.nomdepto, d.gerente, s.estado, s.pais
FROM TEmpleados e
JOIN TDeptos d ON e.depto = d.numdepto
JOIN TSedes s ON d.localizacion = s.localizacion
WHERE d.division = 'SUR';
commit;

/*5*/
SELECT d.division, SUM(e.salario) AS total_sueldo
FROM TEmpleados e
JOIN TDeptos d ON e.depto = d.numdepto
WHERE d.division IN ('CENTRO', 'SUR')
GROUP BY d.division;
commit;

/*6*/
WITH sueldo_min AS (
    SELECT MIN(salario) AS sueldo_minimo, depto
    FROM TEmpleados
    GROUP BY depto
)
SELECT e.nombre
FROM TEmpleados e
JOIN sueldo_min sm ON e.salario = sm.sueldo_minimo AND e.depto = sm.depto;
commit;

/*7*/
SELECT s.pais, SUM(e.salario) AS total_sueldo
FROM TEmpleados e
JOIN TDeptos d ON e.depto = d.numdepto
JOIN TSedes s ON d.localizacion = s.localizacion
GROUP BY s.pais;
commit;

/*8*/
SELECT e.nombre, s.estado, s.pais, d.nomdepto, d.gerente
FROM TEmpleados e
JOIN TDeptos d ON e.depto = d.numdepto
JOIN TSedes s ON d.localizacion = s.localizacion
WHERE e.comision <= 11;
commit;

/*9*/
DECLARE
    CURSOR cursor_empleado IS
        SELECT nombre, salario FROM TEmpleados;
    v_nombre TEmpleados.nombre%TYPE;
    v_salario TEmpleados.salario%TYPE;
BEGIN
    OPEN cursor_empleado;
    LOOP
        FETCH cursor_empleado INTO v_nombre, v_salario;
        EXIT WHEN cursor_empleado%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_nombre || ' - Salario: ' || v_salario);
    END LOOP;
    CLOSE cursor_empleado;
END;
/
commit;

BEGIN
    FOR empleado_cursor IN (SELECT nombre, salario FROM TEmpleados) LOOP
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || empleado_cursor.nombre || ' - Salario: ' || empleado_cursor.salario);
    END LOOP;
END;
/
commit;

/*10*/
CREATE OR REPLACE FUNCTION obtener_comision(p_nuemp IN TEmpleados.nuemp%TYPE)
RETURN NUMBER
IS
    v_comision TEmpleados.comision%TYPE;
BEGIN
    SELECT comision INTO v_comision
    FROM TEmpleados
    WHERE nuemp = p_nuemp;
    RETURN v_comision;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END obtener_comision;
/
commit;

/*11*/
CREATE VIEW vista_empleados AS
SELECT nombre, depto, puesto, salario
FROM TEmpleados;
commit;

/*12*/
CREATE OR REPLACE TRIGGER alerta_empleado
AFTER INSERT OR DELETE ON TEmpleados
FOR EACH ROW
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Se ha insertado un nuevo empleado: ' || :NEW.nombre);
    ELSIF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('Se ha eliminado un empleado: ' || :OLD.nombre);
    END IF;
END;
/
commit;





