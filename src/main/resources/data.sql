BEGIN TRANSACTION;
INSERT INTO "Colegiado" ("idColegiado","nombre","apellidos","direccion","poblacion","telefono","datosBancarios","fechaSolicitudColegiado","titulacion","centro","anioTitulo","dni") VALUES (1,'Alvaro','Fonseca','gijon','gijoon','89652345','536468536','2020-02-02','informatica','uniovi',2000,'72746653E'),
 (2,'Miguel','Rodriguez','llangreu','langreo','2556454','523835684','2020-02-02','informatica','uniovi',2000,'63178588A'),
 (3,'Maria','Berni','el molinon','xixon','12345','12345','2020-02-02','informatica','uniovi',2000,'62810739Q'),
 (4,'Nerea','Granda','Aviles','Ailes','53543','345345345','2020-02-02','informatica','uniovi',2000,'77600235Y'),
 (5,'Frank','Pichon','colloto','colloto','2432342','523824335684','2020-02-02','informatica','uniovi',2000,'32404476Y'),
 (6,'Alvaro','Rodriguez','Xixon','Xixon','75738','7833567','2020-02-02','informatica','uniovi',2001,'01039207K'),
 (7,'Paula','Granda','Aviles','Ailes','35345','34533','2021-02-02','quimica','uniovi',2002,'65151727H'),
 (8,'Laura','Junqueras','Pola de Siero','Siero','534534','435345','2021-02-02','informatica','uniovi',2000,'05891104E'),
 (9,'Adan','Valles','Sotrondio','SMR','3463','3453453','2021-02-02','informatica','uniovi',2000,'74028086X');
INSERT INTO "SolicitudColegio" ("idSolicitud","estado","idColegiado","fecha") VALUES (1,'aprobado',1,'2020-02-02'),
(2,'aprobado',2,'2020-02-02'),
(3,'aprobado',3,'2020-02-02'),
(4,'aprobado',4,'2020-02-02'),
(5,'aprobado',5,'2020-02-02'),
(6,'aprobado',6,'2020-02-02'),
(7,'pendiente',7,'2021-02-02'),
(8,'pendiente',8,'2021-02-02'),
(9,'pendiente',9,'2021-02-02');
INSERT INTO "InformesPerito" ("idInformePerito","idPerito","estado","fecha") VALUES (1,1,'asignado',NULL),
 (2,0,'pendiente',NULL),
 (3,0,'pendiente',NULL),
 (4,0,'pendiente',NULL);
INSERT INTO "Inscripcion" ("idInscripcion","idColegiado","idCurso","estado","fecha") VALUES (1,1,4,'preinscrito','2021-05-04'),
 (2,2,5,'preinscrito','2021-05-04'),
 (3,1,3,'preinscrito','2021-05-04'),
 (4,3,4,'preinscrito','2021-05-04'),
 (5,3,6,'preinscrito','2021-05-04'),
 (6,2,6,'preinscrito','2021-05-04'),
 (7,3,5,'preinscrito','2021-04-03'),
 (8,1,5,'preinscrito','2021-04-06');
INSERT INTO "Perito" ("idPerito","idColegiado","fecha","turno","estado") VALUES (1,1,'2021-02-02',1,"aprobado"),
 (2,3,'2021-02-02',2,"aprobado"),
 (3,2,'2021-02-02',5,"aprobado"),
 (4,5,'2021-02-02',4,"aprobado"),
 (5,4,'2021-02-02',3,"aprobado");
INSERT INTO "Curso" ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado","precioPrecolegiado","precioEstudiante","precioEmpresa","precioExterno") VALUES (1,'sql',67.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',NULL,NULL,NULL,NULL),
 (2,'c',34.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',NULL,NULL,NULL,NULL),
 (3,'java',21.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',NULL,NULL,NULL,NULL),
 (4,'eclipse',34.0,32,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','finalizado',20,10,5,2),
 (5,'ethereum',45.0,47,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto',20,10,5,2),
 (6,'bitcoin',32.0,43,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto',20,10,5,2);
INSERT INTO "Colectivo" ("idColectivo","nombre","apellidos","dni","direccion","poblacion","telefono","tipoColectivo") VALUES (1,'Samuel','rguez','3','la felguera','langreo','12466061S','estudiante');
INSERT INTO "Precolegiado" ("id","nombre","apellidos","dni","direccion","datosCuenta","fechaSolicitudPrecolegiado","titulacion","poblacion","telefono","centro") VALUES (1,'Sergio','hndz','23578734P','rafael','453454','2021-04-06','ingenieria','la felguera',NULL,NULL);
COMMIT;
