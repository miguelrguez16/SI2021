BEGIN TRANSACTION;
INSERT INTO "Carreras" ("id","inicio","fin","fecha","descr") VALUES (100,'2016-10-05','2016-10-25','2016-11-09','finalizada'),
 (101,'2016-10-05','2016-10-25','2016-11-10','en fase 3'),
 (102,'2016-11-05','2016-11-09','2016-11-20','en fase 2'),
 (103,'2016-11-10','2016-11-15','2016-11-21','en fase 1'),
 (104,'2016-11-11','2016-11-15','2016-11-22','antes inscripcion'),
 (105,'2016-11-12','2016-11-16','2016-11-23','en fase 1');
<<<<<<< HEAD
INSERT INTO "Colegiado" ("idColegiado","nombre","apellidos","direccion","poblacion","telefono","datosBancarios","fechaSolicitudColegiado","titulacion","centro","anioTitulo") VALUES (1,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','2/2/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (2,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','2/2/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (3,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','2/2/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (4,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','10:59 3 2/2/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (5,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','11:2 3 2/2/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (6,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','2/2/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (7,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','2/9/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (8,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','2/3/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020),
 (9,'Lionel Andres','Messi Cuccitini','Calle Ave del Paraiso','Gijon','643211664','ES21123456781234','2/3/2021','Ingenieria Informatica','Escuela Politecnica de Ingenieria',2020);
COMMIT;
delete from Curso;
    INSERT INTO "Curso" ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado") VALUES (1,'data mining',34.0,45,'2020-11-20','2020-11-30','2020-10-20','2020-10-30','finalizado'),
 (2,'redes',22.0,32,'2021-05-20','2021-06-30','2021-02-20','2021-02-28','abierto'),
 (3,'java',10.0,23,'2021-05-20','2021-06-30',NULL,NULL,'pendiente'),
 (4,'c',10.0,23,'2021-05-20','2021-06-30',NULL,NULL,'pendiente'),
 (5,'sql',10.0,23,'2021-05-20','2021-06-30',NULL,NULL,'pendiente');
=======
INSERT INTO "Curso" ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado") VALUES (1,'sql',67.0,0,'2020-02-02','2020-02-04',NULL,NULL,'planificado'),
 (2,'c',34.0,0,'2020-02-02','2020-02-04',NULL,NULL,'planificado'),
 (3,'java',21.0,0,'2020-02-02','2020-02-04',NULL,NULL,'planificado'),
 (4,'eclipse',34.0,32,'2019-02-02','2019-02-04','2019-01-02','2019-02-04','finalizado');
INSERT INTO "Colegiado" ("idColegiado","nombre","apellidos","direccion","poblacion","telefono","datosBancarios","fechaSolicitudColegiado","titulacion","centro","anioTitulo","dni") VALUES (1,'Alvaro','fonseca','gijon','gijoon','89652345','536468536','2021-02-02','informatica','uniovi',2000,'235689'),
 (2,'Miguel','rguez','llangreu','langreo','2556454','523835684','2021-02-02','informatica','uniovi',2000,'235689'),
 (3,'Maria','berni','xixioin','xionxox','45675823','2342342343','2021-02-02','informatica','uniovi',2000,'3256478');
INSERT INTO "Perito" ("idPerito","idColegiado") VALUES (1,1),
 (2,3);
INSERT INTO "InformesPerito" ("idInformePerito","idPerito","estado") VALUES (1,1,'finite'),
 (2,0,'pendiente'),
 (3,0,'pendiente');
INSERT INTO "SolicitudColegio" ("idSolicitud","estado","idColegiado","fecha") VALUES (1,'pendiente',1,'2021-02-02');
COMMIT;
>>>>>>> refs/heads/master
