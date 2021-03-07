BEGIN TRANSACTION;
INSERT INTO "Carreras" ("id","inicio","fin","fecha","descr") VALUES (100,'2016-10-05','2016-10-25','2016-11-09','finalizada'),
 (101,'2016-10-05','2016-10-25','2016-11-10','en fase 3'),
 (102,'2016-11-05','2016-11-09','2016-11-20','en fase 2'),
 (103,'2016-11-10','2016-11-15','2016-11-21','en fase 1'),
 (104,'2016-11-11','2016-11-15','2016-11-22','antes inscripcion'),
 (105,'2016-11-12','2016-11-16','2016-11-23','en fase 1');
INSERT INTO "Curso" ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado") VALUES (1,'sql',67.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado'),
 (2,'c',34.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado'),
 (3,'java',21.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado'),
 (4,'eclipse',34.0,32,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','finalizado'),
 (5,'ethereum',45.0,47,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto'),
 (6,'bitcoin',32.0,43,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto');
INSERT INTO "Colegiado" ("idColegiado","nombre","apellidos","direccion","poblacion","telefono","datosBancarios","fechaSolicitudColegiado","titulacion","centro","anioTitulo","dni") VALUES (1,'Alvaro','fonseca','gijon','gijoon','89652345','536468536','2021-02-02','informatica','uniovi',2000,'235689'),
 (2,'Miguel','rguez','llangreu','langreo','2556454','523835684','2021-02-02','informatica','uniovi',2000,'235689'),
 (3,'Maria','berni','xixioin','xionxox','45675823','2342342343','2021-02-02','informatica','uniovi',2000,'3256478');
INSERT INTO "Perito" ("idPerito","idColegiado") VALUES (1,1),
 (2,3);
INSERT INTO "SolicitudColegio" ("idSolicitud","estado","idColegiado","fecha") VALUES (1,'pendiente',1,'2021-02-02');
INSERT INTO "InformesPerito" ("idInformePerito","idPerito","estado","fecha") VALUES (1,1,'finite',NULL),
 (2,0,'pendiente',NULL),
 (3,0,'pendiente',NULL);
INSERT INTO "Inscripcion" ("idInscripcion","idColegiado","idCurso","estado","fecha") VALUES (1,1,4,'preinscrito',NULL),
 (2,2,5,'preinscrito',NULL),
 (3,1,3,'preinscrito',NULL),
 (4,3,4,'preinscrito',NULL),
 (5,3,6,'preinscrito',NULL),
 (6,2,6,'preinscrito',NULL);
COMMIT;
