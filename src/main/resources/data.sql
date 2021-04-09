BEGIN TRANSACTION;
INSERT INTO "Colegiado" ("idColegiado","nombre","apellidos","direccion","poblacion","telefono","datosBancarios","fechaSolicitudColegiado","titulacion","centro","anioTitulo","dni") VALUES (1,'Alvaro','fonseca','gijon','gijoon','89652345','536468536','2021-02-02','informatica','uniovi',2000,'235689'),
 (2,'Miguel','rguez','llangreu','langreo','2556454','523835684','2021-02-02','informatica','uniovi',2000,'235689'),
 (3,'Maria','berni','el molinon','xixon','12345','12345','2021-02-02','informatica','uniovi',2000,'666');
INSERT INTO "SolicitudColegio" ("idSolicitud","estado","idColegiado","fecha") VALUES (1,'pendiente',1,'2021-02-02');
INSERT INTO "InformesPerito" ("idInformePerito","idPerito","estado","fecha") VALUES (1,1,'finite',NULL),
 (2,0,'pendiente',NULL),
 (3,0,'pendiente',NULL);
INSERT INTO "Inscripcion" ("idInscripcion","idColegiado","idCurso","estado","fecha") VALUES (1,1,4,'preinscrito','2021-05-04'),
 (2,2,5,'preinscrito','2021-05-04'),
 (3,1,3,'preinscrito','2021-05-04'),
 (4,3,4,'preinscrito','2021-05-04'),
 (5,3,6,'preinscrito','2021-05-04'),
 (6,2,6,'preinscrito','2021-05-04'),
 (7,3,5,'preinscrito','2021-04-03'),
 (8,1,5,'preinscrito','2021-04-06');
INSERT INTO "Perito" ("idPerito","idColegiado","fecha","turno","estado") VALUES (1,1,'2021-02-02',1,"aprobado"),
 (2,3,'2021-02-02',2,"aprobado");
INSERT INTO "Curso" ("idCurso","nombre","precio","plazasTotales","fechaInicio","fechaFin","fechaInicioInscripcion","fechaFinInscripción","estado","precioPrecolegiado","precioEstudiante","precioEmpresa","precioExterno") VALUES (1,'sql',67.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',NULL,NULL,NULL,NULL),
 (2,'c',34.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',NULL,NULL,NULL,NULL),
 (3,'java',21.0,0,'2021-05-02','2021-05-04',NULL,NULL,'planificado',NULL,NULL,NULL,NULL),
 (4,'eclipse',34.0,32,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','finalizado',20,10,5,2),
 (5,'ethereum',45.0,47,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto',20,10,5,2),
 (6,'bitcoin',32.0,43,'2021-04-02','2021-06-04','2021-02-02','2021-03-04','abierto',20,10,5,2);
INSERT INTO "Colectivo" ("idColectivo","nombre","apellidos","dni","direccion","poblacion","telefono","tipoColectivo") VALUES (1,'Samuel','rguez','3','la felguera','langreo','5345345','estudiante');
INSERT INTO "Precolegiado" ("id","nombre","apellidos","dni","direccion","datosCuenta","fechaSolicitudPrecolegiado","titulacion","poblacion","telefono","centro") VALUES (1,'Sergio','hndz',2,'rafael','453454','2021-04-06','ingenieria','la felguera',NULL,NULL);
COMMIT;
