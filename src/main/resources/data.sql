BEGIN TRANSACTION;
INSERT INTO "Colegiado" ("idColegiado","nombre","apellidos","direccion","poblacion","telefono","datosBancarios","fechaSolicitudColegiado","titulacion","centro","anioTitulo","dni","estadoCobro","fechaEmision","fechaCobro","fechaReclamacion") VALUES (1,'Alvaro','Fonseca','gijon','gijoon','89652345','536468536','2020-02-02','Ing. Informática','uniovi',2000,'72746653E',"cobrado","2020-04-02","",""),
 (2,'Miguel','Rodriguez','llangreu','langreo','2556454','523835684','2020-02-02','Master Ing. Informática','uniovi',2000,'63178588A',"cobrado","2020-04-02","",""),
 (3,'Maria','Berni','el molinon','xixon','12345','12345','2020-02-02','Master Ing. Informática','uniovi',2000,'62810739Q',"cobrado","2020-04-02","",""),
 (4,'Nerea','Granda','Aviles','Ailes','53543','345345345','2020-02-02','Lic. Informática','uniovi',2000,'77600235Y',"cobrado","2020-04-02","",""),
 (5,'Frank','Pichon','colloto','colloto','2432342','523824335684','2020-02-02','Ing. Informática','uniovi',2000,'32404476Y',"cobrado","2020-04-02","",""),
 (6,'Alvaro','Rodriguez','Xixon','Xixon','75738','7833567','2020-02-02','Ing. Informática','uniovi',2001,'01039207K',"cobrado","2020-04-02","",""),
 (7,'Paula','Granda','Aviles','Ailes','35345','34533','2021-02-02','quimica','uniovi',2002,'65151727H',"cobrado","2020-04-02","",""),
 (8,'Laura','Junqueras','Pola de Siero','Siero','534534','435345','2021-02-02','Ing. Informática','uniovi',2000,'05891104E',"cobrado","2020-04-02","",""),
 (9,'Adan','Valles','Sotrondio','SMR','3463','3453453','2021-02-02','Ing. Informática','uniovi',2000,'74028086X',"cobrado","2020-04-02","","");
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
INSERT INTO "Profesor" ("id","nombre","apellidos","estado") VALUES (1,"Nela","Lois","activo"),
(2,"Pelayo","Iglesias","activo"),
(3,"Irene","Alonso","activo"),
(4,"Celia","Corte ","activo");
INSERT INTO "InscripcionCurso" ("idInscripcionCurso","id","idCurso","tipo","estado","fecha","cantidadDevolver") VALUES (1,1,4,'colegiado','preinscrito','2021-05-04',0.0),
(2,2,5,'colegiado','preinscrito','2021-05-04',0.0),
(3,1,3,'colegiado','preinscrito','2021-05-04',0.0),
(4,3,4,'colegiado','preinscrito','2021-05-04',0.0),
(5,3,6,'colegiado','preinscrito','2021-05-04',0.0),
(6,2,6,'colegiado','preinscrito','2021-04-03',0.0),
(7,3,5,'colegiado','preinscrito','2021-04-03',0.0),
(8,1,5,'colegiado','preinscrito','2021-04-06',0.0),
(9,1,5,'precolegiado','preinscrito','2021-04-06',0.0),
(10,1,5,'estudiante','preinscrito','2021-04-06',0.0);
INSERT INTO "Perito" ("idPerito","idColegiado","fecha","turno","estado") VALUES (1,1,'2021-02-02',1,'aprobado'),
 (2,3,'2021-02-02',2,'aprobado'),
 (3,2,'2021-02-02',5,'aprobado'),
 (4,5,'2021-02-02',4,'aprobado'),
 (5,4,'2021-02-02',3,'aprobado');
INSERT INTO "Curso" ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado","precioPrecolegiado","precioEstudiante","precioEmpresa","precioExterno","idProfesor","instalacion") VALUES (1,'sql',67.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',20.0,10.0,5.0,2.0,1,"Sala 4"),
 (2,'c',34.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',20.0,10.0,5.0,2.0,2,"Sala 4"),
 (3,'java',21.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',20.0,10.0,5.0,2.0,4,"Sala 4"),
 (4,'eclipse',34.0,32,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','finalizado',20.0,10.0,5.0,2.0,1,"Sala 5"),
 (5,'ethereum',45.0,47,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto',20.0,10.0,5.0,2.0,2,"Aula de video 5"),
 (6,'bitcoin',32.0,43,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto',20.0,10.0,5.0,2.0,3,"Sala 4");
INSERT INTO "Colectivo" ("idColectivo","nombre","apellidos","dni","direccion","poblacion","telefono","tipoColectivo") VALUES (1,'Samuel','rguez','3','la felguera','langreo','12466061S','estudiante');
INSERT INTO "Precolegiado" ("id","nombre","apellidos","dni","direccion","datosCuenta","fechaSolicitudPrecolegiado","titulacion","poblacion","telefono","centro","estadoCobro","fechaEmision","fechaCobro","fechaReclamacion") VALUES (1,'Sergio','hndz','23578734P','rafael','453454','2021-04-06','ingenieria','la felguera',666777444,"uniovi","cobrado","2020-02-05","",""),
(2,'Juan','hndz','99578444Z','rafael','453454','2021-04-06','ingenieria','la felguera',666777444,"uniovi","cobrado","2020-02-05","",""),
(3,'Elias','fndz','07000172Z','belderrain','453454','2021-04-06','ingenieria','la felguera',666777444,"uniovi","cobrado","2020-02-05","","");
COMMIT;
